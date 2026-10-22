package com.bytedance.mira.multidex;

import android.content.SharedPreferences;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes21.dex */
public class PluginMultiDexCompat {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = ".crc";
    private static final String KEY_DEX_CRC = ".dex.crc.";
    private static final String KEY_DEX_NUMBER = ".dex.number";
    private static final String KEY_NAME = ".name";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String TAG = "Plugin-MultiDex";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;

    public static class ExtractedDex extends File {

        /* JADX INFO: renamed from: crc, reason: collision with root package name */
        public long f265554crc;

        public ExtractedDex(File r100, String r101) {
            super(r100, r101);
            this.f265554crc = -1;
        }
    }

    public PluginMultiDexCompat() {
    }

    public static boolean isNeedExtract() {
        return !isVMMultidexCapable(System.getProperty("java.vm.version"));
    }

    private static SharedPreferences getMultiDexPreferences() {
        return Mira.getAppContext().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static void clearDexDir(File r100) {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L8;
    L18:
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Failed to list secondary dex dir content (" + r100.getPath() + ").");
        return;
    L8:
        if (r101.length == 0) goto L18;
        int r102 = r101.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L17;
        File r104 = r101[r103];
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + r104.getPath() + " of size " + r104.length());
        if (r104.delete() == true) goto L15;
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + r104.getPath());
    L16:
        r103 = r103 + 1;
        goto L11
    L15:
        MiraLogger.i(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Deleted old file " + r104.getPath());
        goto L16
    }

    private static void closeQuietly(Closeable r100) {
        r100.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
    }

    private static int getMultiDexPreferencesIntValue(String r100) {
        return getMultiDexPreferences().getInt(r100, 0);
    }

    private static long getMultiDexPreferencesLongValue(String r100) {
        return getMultiDexPreferences().getLong(r100, 0);
    }

    private static String getMultiDexPreferencesStringValue(String r100) {
        return getMultiDexPreferences().getString(r100, "");
    }

    private static long getZipCrc(File r100) throws IOException {
        long r101 = ZipUtil.getZipCrc(r100);
        if (r101 == (-1)) goto L5;
        return r101;
    L5:
        return r101 - 1;
    }

    private static boolean isVMMultidexCapable(String r100) {
        boolean r101 = false;
        if (r100 == null) goto L13;
        Matcher r102 = PatternProtector.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(r100);
        if (r102.matches() == false) goto L13;
        int r103 = CastIntegerProtector.parseInt(r102.group(1));     // Catch: NumberFormatException -> L12
        int r104 = CastIntegerProtector.parseInt(r102.group(2));     // Catch: NumberFormatException -> L12
        if (r103 > 2) goto L11;
        if (r103 != 2) goto L13;
        if (r104 < 1) goto L13;
    L11:
        r101 = true;
    L13:
        StringBuilder r105 = new StringBuilder("Plugin-MultiDex VM with version ");
        r105.append(r100);
        if (r101 == false) goto L16;
        String r106 = " has multidex support";
    L17:
        r105.append(r106);
        MiraLogger.i(MiraLogger.TAG_INSTALL, r105.toString());
        return r101;
    L16:
        r106 = " does not have multidex support";
        goto L17
    }

    public static String buildMultiDexPath(String r100, int r101) {
        String r102 = getSourceFileName(r100, r101) + EXTRACTED_NAME_EXT;
        int r103 = getSourceFileDexNumber(r100, r101);
        StringBuilder r104 = new StringBuilder();
        r104.append(PluginDirHelper.getSourceFile(r100, r101));
        r104.append(":");
        int r105 = 2;
    L4:
        if (r105 > (r103 + 1)) goto L6;
        r104.append(new ExtractedDex(new PolarisFileWrapper(PluginDirHelper.getSecondaryDexesDir(r100, r101)), r102 + r105 + ".zip").getAbsolutePath());
        r104.append(":");
        r105 = r105 + 1;
        goto L4
    L6:
        r104.delete(r104.length() - 1, r104.length());
        return r104.toString();
    }

    private static long getSourceFileCRC(String r100, int r101) {
        return getMultiDexPreferencesLongValue((r100 + "-" + r101) + KEY_CRC);
    }

    private static int getSourceFileDexNumber(String r100, int r101) {
        return getMultiDexPreferencesIntValue((r100 + "-" + r101) + KEY_DEX_NUMBER);
    }

    private static String getSourceFileName(String r100, int r101) {
        return getMultiDexPreferencesStringValue((r100 + "-" + r101) + KEY_NAME);
    }

    public static boolean isPluginExtract(String r110, int r111) {
        String r100 = PluginDirHelper.getSourceFile(r110, r111);
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L6;
        MiraLogger.e(MiraLogger.TAG_LOAD, "Plugin-MultiDex Failed to find source file " + r100);
        return false;
    L6:
        long r102 = getSourceFileCRC(r110, r111);
        long r103 = getZipCrc(r101);     // Catch: IOException -> L9
    L11:
        if (r102 == r103) goto L14;
        MiraLogger.e(MiraLogger.TAG_LOAD, "Plugin-MultiDex Failed to match source file crc [old] >>> " + r102 + "[current] >>> " + r103);
        return false;
    L14:
        String r104 = getSourceFileName(r110, r111) + EXTRACTED_NAME_EXT;
        int r105 = getSourceFileDexNumber(r110, r111);
        int r106 = 2;
    L16:
        if (r106 > (r105 + 1)) goto L29;
        ExtractedDex r107 = new ExtractedDex(new PolarisFileWrapper(PluginDirHelper.getSecondaryDexesDir(r110, r111)), r104 + r106 + ".zip");
        if (r107.exists() == true) goto L20;
        MiraLogger.e(MiraLogger.TAG_LOAD, "Plugin-MultiDex Failed to find dex file " + r107.getAbsolutePath());
    L20:
        long r112 = getSourceFileDexCRC(r110, r111, r106);
        long r113 = getZipCrc(r107);     // Catch: IOException -> L23
    L25:
        if (r112 != r113) goto L26;
        r106 = r106 + 1;
        goto L16
    L26:
        MiraLogger.e(MiraLogger.TAG_LOAD, "Plugin-MultiDex Failed to match dex file crc dexIndex >>> " + r106 + "[old] >>> " + r112 + "[current] >>> " + r113);
        return false;
    L23:
        r113 = Long.MIN_VALUE;
        goto L25
    L29:
        return true;
    L9:
        r103 = Long.MIN_VALUE;
        goto L11
    }

    public static void extract(File r110, String r111, int r112) throws IOException {
        if (r110 == null) goto L54;
        if (r110.exists() == false) goto L54;
        if (r111 == null) goto L54;
        PolarisZipFileWrapper r100 = new PolarisZipFileWrapper(r110);     // Catch: Exception -> L9
    L10:
        PolarisZipFileWrapper r113 = r100;
        if (r113 == null) goto L52;
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L44
        PolarisFileWrapper r102 = new PolarisFileWrapper(PluginDirHelper.getSecondaryDexesDir(r111, r112));     // Catch: Throwable -> L44
        clearDexDir(r102);     // Catch: Throwable -> L44
        String r103 = r110.getName() + EXTRACTED_NAME_EXT;     // Catch: Throwable -> L44
        int r104 = 2;
    L13:
        ZipEntry r105 = r113.getEntry(DEX_PREFIX + r104 + ".dex");     // Catch: Throwable -> L44
        if (r105 == null) goto L15;
        ExtractedDex r114 = new ExtractedDex(r102, r103 + r104 + ".zip");     // Catch: Throwable -> L44
        boolean r106 = false;
        int r115 = 0;
    L24:
        if (r115 >= 3) goto L40;
        if (r106 == true) goto L40;
        extractEntry(r113, r105, r114, r103);     // Catch: IOException -> L28 Throwable -> L44
        r114.f265554crc = getZipCrc(r114);     // Catch: IOException -> L28 Throwable -> L44
        r106 = true;
    L30:
        int r116 = r115 + 1;     // Catch: Throwable -> L44
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L44
        r117.append("Plugin-MultiDex Extraction ");     // Catch: Throwable -> L44
        if (r106 == false) goto L33;
        String r118 = "succeeded";
    L34:
        r117.append(r118);     // Catch: Throwable -> L44
        r117.append(" '");     // Catch: Throwable -> L44
        r117.append(r114.getAbsolutePath());     // Catch: Throwable -> L44
        r117.append("': length ");     // Catch: Throwable -> L44
        r117.append(r114.length());     // Catch: Throwable -> L44
        r117.append(" - crc: ");     // Catch: Throwable -> L44
        r117.append(r114.f265554crc);     // Catch: Throwable -> L44
        MiraLogger.i(MiraLogger.TAG_INSTALL, r117.toString());     // Catch: Throwable -> L44
        if (r106 == true) goto L39;
        r114.delete();     // Catch: Throwable -> L44
        if (r114.exists() == false) goto L39;
        MiraLogger.w(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + r114.getPath() + "'");     // Catch: Throwable -> L44
    L39:
        r115 = r116;
        goto L24
    L33:
        r118 = "failed";
        goto L34
    L28:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + r114.getAbsolutePath(), e);     // Catch: Throwable -> L44
        r106 = false;
    L40:
        if (r106 == false) goto L43;
        r101.add(r114);     // Catch: Throwable -> L44
        r104 = r104 + 1;     // Catch: Throwable -> L44
        goto L13
    L43:
        throw new IOException("Could not create zip file " + r114.getAbsolutePath() + " for secondary dex (" + r104 + ")");     // Catch: Throwable -> L44
    L15:
        saveExtractedFileInfo(r111, r112, r110.getName(), getZipCrc(r110), r101);     // Catch: Throwable -> L44
        r113.close();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        return;
    L44:
        th = move-exception;
        r113.close();     // Catch: Exception -> L48
        throw th;
    L48:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        throw th;
    L52:
        throw new IOException("Could not create zip file " + r110.getAbsolutePath());
    L9:
        r100 = null;
    L54:
        throw new IOException("Could not check apk info " + r110.getAbsolutePath());
    }

    private static long getSourceFileDexCRC(String r100, int r101, int r102) {
        return getMultiDexPreferencesLongValue((r100 + "-" + r101) + KEY_DEX_CRC + r102);
    }

    private static void extractEntry(ZipFile r100, ZipEntry r101, ExtractedDex r102, String r103) throws IOException {
        InputStream r104 = r100.getInputStream(r101);
        File r105 = File.createTempFile("tmp-" + r103, ".zip", r102.getParentFile());
        ZipOutputStream r106 = new ZipOutputStream(new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r105)));     // Catch: Throwable -> L22
        ZipEntry r107 = new ZipEntry("classes.dex");     // Catch: Throwable -> L19
        r107.setTime(r101.getTime());     // Catch: Throwable -> L19
        r106.putNextEntry(r107);     // Catch: Throwable -> L19
        byte[] r108 = new byte[16384];     // Catch: Throwable -> L19
    L5:
        int r109 = r104.read(r108);     // Catch: Throwable -> L19
        if (r109 == (-1)) goto L8;
        r106.write(r108, 0, r109);     // Catch: Throwable -> L19
        goto L5
    L8:
        r106.closeEntry();     // Catch: Throwable -> L19
        r106.close();     // Catch: Throwable -> L22
        if (r105.setReadOnly() == false) goto L18;
        if (r105.renameTo(r102) == false) goto L16;
        closeQuietly(r104);
        r105.delete();
        return;
    L16:
        throw new IOException("Failed to rename \"" + r105.getAbsolutePath() + "\" to \"" + r102.getAbsolutePath() + "\"");     // Catch: Throwable -> L22
    L18:
        throw new IOException("Failed to mark readonly \"" + r105.getAbsolutePath() + "\" (tmp of \"" + r102.getAbsolutePath() + "\")");     // Catch: Throwable -> L22
    L19:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        closeQuietly(r104);
        r105.delete();
        throw th;
    }

    private static void saveExtractedFileInfo(String r100, int r101, String r102, long r103, List<ExtractedDex> r104) {
        String r105 = r100 + "-" + r101;
        SharedPreferences.Editor r106 = getMultiDexPreferences().edit();
        r106.putLong(r105 + KEY_CRC, r103);
        r106.putString(r105 + KEY_NAME, r102);
        r106.putInt(r105 + KEY_DEX_NUMBER, r104.size());
        Iterator<ExtractedDex> r107 = r104.iterator();
        int r108 = 2;
    L4:
        if (r107.hasNext() == false) goto L6;
        r106.putLong(r105 + KEY_DEX_CRC + r108, r107.next().f265554crc);
        r108 = r108 + 1;
        goto L4
    L6:
        r106.commit();
    }
}
