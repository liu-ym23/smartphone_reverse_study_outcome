package com.bytedance.mira.core;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.mira.util.ZipUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import dalvik.system.DexFile;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes21.dex */
public class MultiDexExtractor {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static Method sApplyMethod;
    private static HashMap<String, SharedPreferencesImpl> sSharedPrefs;

    public MultiDexExtractor() {
    }

    static {
        sApplyMethod = SharedPreferences.Editor.class.getMethod(e1.REPLY_ACTION_APPLY, new Class[0]);     // Catch: NoSuchMethodException -> L4
        return;
    L4:
        sApplyMethod = null;
    }

    private static void apply(SharedPreferences.Editor r100) {
        Method r101 = sApplyMethod;
        if (r101 != null) goto L11;
    L9:
        r100.commit();
        return;
    L11:
        r101.invoke(r100, new Object[0]);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private static SharedPreferences getMultiDexPreferences(File r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "multidex.version.xml");
        monitor-enter(MultiDexExtractor.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sSharedPrefs != null) goto L7;
        sSharedPrefs = new HashMap();     // Catch: Throwable -> L12
    L7:
        SharedPreferencesImpl r102 = sSharedPrefs.get(r101.getPath());     // Catch: Throwable -> L12
        if (r102 != null) goto L10;
        r102 = new SharedPreferencesImpl(r101, 4);     // Catch: Throwable -> L12
        sSharedPrefs.put(r101.getPath(), r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(MultiDexExtractor.class);     // Catch: Throwable -> L12
        return r102;
    }

    private static File getPreferencesDir(String r100) {
        return new PolarisFileWrapper(PluginDirHelper.getDataDir(r100), "shared_prefs");
    }

    private static long getTimeStamp(File r100) {
        long r101 = r100.lastModified();
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        return r101 - 1;
    }

    private static long getZipCrc(File r100) throws IOException {
        long r101 = ZipUtils.getZipCrc(r100);
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        return r101 - 1;
    }

    public static boolean verifyZipFile(File r100) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L13:
        new PolarisZipFileWrapper(r100).close();     // Catch: IOException -> L6 Exception -> L9
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L9
        return false;
    }

    private static String optimizedPathFor(File r100, File r101) {
        String r102 = r100.getName();
        if (r102.endsWith(".dex") == true) goto L9;
        int r103 = r102.lastIndexOf(".");
        if (r103 >= 0) goto L7;
        r102 = r102.concat(".dex");
        goto L9
    L7:
        StringBuilder r104 = new StringBuilder(r103 + 4);
        r104.append(r102, 0, r103);
        r104.append(".dex");
        r102 = r104.toString();
    L9:
        return new PolarisFileWrapper(r101, r102).getPath();
    }

    private static List<File> performExtractions(File r100, File r101) throws Exception {
        String r102 = r100.getName() + EXTRACTED_NAME_EXT;
        prepareDexDir(r101, r102);
        ArrayList r103 = new ArrayList();
        PolarisZipFileWrapper r104 = new PolarisZipFileWrapper(r100);
        ZipEntry r105 = r104.getEntry("classes2.dex");     // Catch: Throwable -> L21
        int r106 = 2;
    L4:
        if (r105 == null) goto L27;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r101, r102 + r106 + ".zip");     // Catch: Throwable -> L21
        r103.add(r107);     // Catch: Throwable -> L21
        int r108 = 0;
        boolean r109 = false;
    L7:
        if (r108 >= 3) goto L12;
        if (r109 == true) goto L12;
        r108 = r108 + 1;     // Catch: Throwable -> L21
        extract(r104, r105, r107, r102);     // Catch: Throwable -> L21
        r109 = verifyZipFile(r107);     // Catch: Throwable -> L21
        if (r109 == true) goto L7;
        r107.delete();     // Catch: Throwable -> L21
    L12:
        if (r109 == false) goto L15;
        r106 = r106 + 1;     // Catch: Throwable -> L21
        r105 = r104.getEntry(DEX_PREFIX + r106 + ".dex");     // Catch: Throwable -> L21
        goto L4
    L15:
        throw new IOException("Could not create zip file " + r107.getAbsolutePath() + " for secondary dex (" + r106 + ")");     // Catch: Throwable -> L21
    L27:
        r104.close();     // Catch: IOException -> L18
    L20:
        return r103;
    L18:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        r104.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    private static void prepareDexDir(File r100, final String r101) throws IOException {
        r100.mkdir();
        if (r100.isDirectory() == false) goto L12;
        File[] r102 = r100.listFiles(new AnonymousClass1(r101));
        if (r102 != null) goto L7;
        return;
    L7:
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        r102[r104].delete();
        r104 = r104 + 1;
        goto L8
    L10:
        return;
    L12:
        throw new IOException("Failed to create dex directory " + r100.getPath());
    }

    private static boolean isModified(File r100, long r101, File r110) {
        SharedPreferences r111 = getMultiDexPreferences(r110);
        if (r111.getLong("timestamp", -1) == getTimeStamp(r100)) goto L5;
    L8:
        return true;
    L5:
        if (r111.getLong(KEY_CRC, -1) != r101) goto L8;
        return false;
    }

    private static List<File> loadExistingExtractions(File r100, File r101, File r102) throws Exception {
        String r103 = r100.getName() + EXTRACTED_NAME_EXT;
        int r104 = getMultiDexPreferences(r102).getInt(KEY_DEX_NUMBER, 1);
        ArrayList r105 = new ArrayList(r104);
        int r106 = 2;
    L3:
        if (r106 > r104) goto L13;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r101, r103 + r106 + ".zip");
        if (r107.isFile() == false) goto L12;
        r105.add(r107);
        if (verifyZipFile(r107) == false) goto L10;
        r106 = r106 + 1;
        goto L3
    L10:
        throw new IOException("Invalid ZIP file.");
    L12:
        throw new IOException("Missing extracted secondary dex file '" + r107.getPath() + "'");
    L13:
        return r105;
    }

    private static void extract(ZipFile r100, ZipEntry r101, File r102, String r103) throws Exception {
        InputStream r104 = r100.getInputStream(r101);
        File r105 = File.createTempFile(r103, ".zip", r102.getParentFile());
        ZipOutputStream r106 = new ZipOutputStream(new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r105)));     // Catch: Throwable -> L18
        ZipEntry r107 = new ZipEntry("classes.dex");     // Catch: Throwable -> L15
        r107.setTime(r101.getTime());     // Catch: Throwable -> L15
        r106.putNextEntry(r107);     // Catch: Throwable -> L15
        byte[] r108 = new byte[16384];     // Catch: Throwable -> L15
        int r109 = r104.read(r108);     // Catch: Throwable -> L15
    L6:
        if (r109 == (-1)) goto L8;
        r106.write(r108, 0, r109);     // Catch: Throwable -> L15
        r109 = r104.read(r108);     // Catch: Throwable -> L15
        goto L6
    L8:
        r106.closeEntry();     // Catch: Throwable -> L15
        r106.close();     // Catch: Throwable -> L18
        if (r105.renameTo(r102) == false) goto L14;
        IOUtils.closeSilently(r104);
        r105.delete();
        return;
    L14:
        throw new IOException("Failed to rename " + r105.getAbsolutePath() + " to " + r102.getAbsolutePath());     // Catch: Throwable -> L18
    L15:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        IOUtils.closeSilently(r104);
        r105.delete();
        throw th;
    }

    public static void load(String r100, File r101, File r102, boolean r110) throws Exception {
        if (TextUtils.isEmpty(r100) == true) goto L31;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.exists() == false) goto L44;
        if (r102 != null) goto L10;
    L12:
        File r103 = getPreferencesDir(r100);
        long r104 = getZipCrc(r101);
        if (r110 == false) goto L15;
    L19:
        List<File> r105 = performExtractions(r101, r102);
        saveApkInfo(r103, getTimeStamp(r101), r104, r105.size() + 1);
    L20:
        if (r105 != null) goto L22;
        return;
    L22:
        if (r105.isEmpty() == true) goto L43;
        Iterator<File> r106 = r105.iterator();
    L25:
        if (r106.hasNext() == false) goto L45;
        File r107 = r106.next();
        if (r107 == null) goto L25;
        if (r107.exists() == false) goto L25;
        String r111 = optimizedPathFor(r107, r102);
        DexFile.loadDex(r107.getPath(), r111, 0);
        goto L25
    L45:
        return;
    L43:
        return;
    L15:
        if (isModified(r101, r104, r103) == true) goto L19;
        r105 = loadExistingExtractions(r101, r102, r103);     // Catch: IOException -> L18
    L18:
        r105 = performExtractions(r101, r102);
        saveApkInfo(r103, getTimeStamp(r101), r104, r105.size() + 1);
        goto L20
    L10:
        if (r102.exists() == true) goto L12;
        r102.mkdirs();
        goto L12
    L44:
        return;
    }

    private static void saveApkInfo(File r100, long r101, long r102, int r103) {
        SharedPreferences.Editor r104 = getMultiDexPreferences(r100).edit();
        r104.putLong("timestamp", r101);
        r104.putLong(KEY_CRC, r102);
        r104.putInt(KEY_DEX_NUMBER, r103);
        apply(r104);
    }
}
