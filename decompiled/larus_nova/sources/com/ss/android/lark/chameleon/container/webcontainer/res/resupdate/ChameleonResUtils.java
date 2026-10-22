package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.text.TextUtils;
import com.bytedance.keva.KevaImpl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.util.CommonResUtils;
import com.ss.android.lark.chameleon.container.webcontainer.util.Storage;
import com.ss.android.lark.chameleon.container.webcontainer.util.StorageUtils;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.LzmaUtils;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J3\u0010\u001e\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\"j\b\u0012\u0004\u0012\u00020\u000e`#H\u0002¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResUtils;", "", "()V", "TAG", "", "closeSafe", "", "closeable", "Ljava/io/Closeable;", "convertString", "inputStream", "Ljava/io/InputStream;", "getLatestResourceVersion", "resourceRootDir", "Ljava/io/File;", "getOfflineFileVersion", "path", "getOfflineParentDir", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "channel", "getOfflineResVersion", SRStrategy.MEDIAINFO_KEY_BITRATE, "Ljava/io/BufferedReader;", "getResInfo", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResInfo;", "getResInfoOf7z", "resPath", "getResourceRootDir", "getWebcontainerRootDir", "pickUpFiles", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "validFiles", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "([Ljava/io/File;Ljava/util/ArrayList;)V", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonResUtils {
    public static final ChameleonResUtils INSTANCE = null;
    public static final String TAG = "CML_TAG_RestUtils";

    static {
        INSTANCE = new ChameleonResUtils();
    }

    private ChameleonResUtils() {
    }

    public final String getWebcontainerRootDir() {
        return new PolarisFileWrapper(StorageUtils.composeStoragePath(Env.getApplication(), ChameleonResConstants.WEBCONAINER_ROOT_DIR, "", Storage.Type.INNER_FILES, null)).getCanonicalPath();
    }

    private final void closeSafe(Closeable r100) {
        if (r100 == null) goto L13;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L9;
        r101 = "Unknown error";
    L9:
        Log.e(TAG, r101, e);
        return;
    }

    private final String getLatestResourceVersion(File r100) {
        File r101 = null;
        if (r100 != null) goto L30;
        File[] r102 = null;
    L9:
        if (r102 != null) goto L11;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        Log.i(TAG, "getLatestResourceVersion(): resourceRootDir is empty");     // Catch: IOException -> L5
        return "";
    L21:
        ArrayList<File> r104 = new ArrayList();     // Catch: IOException -> L5
        pickUpFiles(r102, r104);     // Catch: IOException -> L5
        CommonResUtils.sortValidFiles(r104);     // Catch: IOException -> L5
        if ((!r104.isEmpty()) == false) goto L24;
        r101 = (File) ListProtector.remove(r104, 0);     // Catch: IOException -> L5
    L24:
        if (r101 != null) goto L27;
        return "";
    L27:
        return r101.getName();
    L11:
        if (r102.length != 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L17;
        r103 = false;
        goto L18
    L13:
        r105 = false;
        goto L14
    L30:
        r102 = r100.listFiles();     // Catch: IOException -> L5
    L5:
        e = move-exception;
        Log.e(TAG, "getLatestResourceVersion(): failed ", e);
        return "";
    }

    private final String getOfflineResVersion(BufferedReader r100) {
        if (r100 != null) goto L48;
    L47:
        return null;
    L48:
        String r101 = r100.readLine();     // Catch: Throwable -> L37 Exception -> L39
        if (r101 == null) goto L36;
        boolean r102 = false;
        if (StringsKt.startsWith$default(r101, "version", false, 2, null) != true) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L48;
        List<String> r104 = new Regex(":").split(r101, 0);     // Catch: Throwable -> L37 Exception -> L39
        if (r104 != null) goto L14;
    L27:
        String[] r105 = null;
    L28:
        if (r105 != null) goto L30;
    L32:
        if (r102 == false) goto L48;
        String r106 = r105[1];     // Catch: Throwable -> L37 Exception -> L39
        closeSafe(r100);
        return r106;
    L30:
        if (r105.length != 2) goto L32;
        r102 = true;
        goto L32
    L14:
        if (r104.isEmpty() == true) goto L24;
        ListIterator<String> r107 = r104.listIterator(r104.size());     // Catch: Throwable -> L37 Exception -> L39
    L17:
        if (r107.hasPrevious() == false) goto L24;
        if (r107.previous().length() != 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L17;
        List r109 = CollectionsKt.take(r104, r107.nextIndex() + 1);     // Catch: Throwable -> L37 Exception -> L39
    L25:
        if (r109 == null) goto L27;
        r105 = (String[]) r109.toArray(new String[0]);     // Catch: Throwable -> L37 Exception -> L39
        goto L28
    L21:
        r108 = false;
    L24:
        r109 = CollectionsKt.emptyList();     // Catch: Throwable -> L37 Exception -> L39
        goto L25
    L9:
        r103 = false;
    L36:
        closeSafe(r100);
    L39:
        e = move-exception;
        String r110 = e.getMessage();     // Catch: Throwable -> L37
        if (r110 != null) goto L43;
        r110 = "Unknown error";
    L43:
        Log.e(TAG, r110, e);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        closeSafe(r100);
        throw th;
    }

    private final ChameleonResInfo getResInfo(BufferedReader r100) {
        ChameleonResInfo r101 = new ChameleonResInfo(null, null, 3, null);
        if (r100 != null) goto L47;
    L46:
        return r101;
    L47:
        String r102 = r100.readLine();     // Catch: Throwable -> L36 IOException -> L38
        if (r102 == null) goto L35;
        boolean r103 = false;
        if (StringsKt.startsWith$default(r102, "version", false, 2, null) != true) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L47;
        List<String> r105 = new Regex(":").split(r102, 0);     // Catch: Throwable -> L36 IOException -> L38
        if (r105 != null) goto L14;
    L27:
        String[] r106 = null;
    L28:
        if (r106 != null) goto L30;
    L32:
        if (r103 == false) goto L47;
        r101.setVersion(r106[1]);     // Catch: Throwable -> L36 IOException -> L38
        goto L47
    L30:
        if (r106.length != 2) goto L32;
        r103 = true;
        goto L32
    L14:
        if (r105.isEmpty() == true) goto L24;
        ListIterator<String> r107 = r105.listIterator(r105.size());     // Catch: Throwable -> L36 IOException -> L38
    L17:
        if (r107.hasPrevious() == false) goto L24;
        if (r107.previous().length() != 0) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L17;
        List r109 = CollectionsKt.take(r105, r107.nextIndex() + 1);     // Catch: Throwable -> L36 IOException -> L38
    L25:
        if (r109 == null) goto L27;
        r106 = (String[]) r109.toArray(new String[0]);     // Catch: Throwable -> L36 IOException -> L38
        goto L28
    L21:
        r108 = false;
    L24:
        r109 = CollectionsKt.emptyList();     // Catch: Throwable -> L36 IOException -> L38
        goto L25
    L9:
        r104 = false;
    L35:
        INSTANCE.closeSafe(r100);
        goto L46
    L36:
        th = move-exception;
        INSTANCE.closeSafe(r100);
        throw th;
    L38:
        e = move-exception;
        String r110 = e.getMessage();     // Catch: Throwable -> L36
        if (r110 != null) goto L42;
        r110 = "Unknown error";
    L42:
        Log.e(TAG, r110, e);     // Catch: Throwable -> L36
        goto L35
    }

    public final String convertString(InputStream r100) {
        StringBuffer r101 = new StringBuffer();
        Closeable r102 = null;
        if (r100 != null) goto L38;
    L22:
        Log.e(TAG, "convertString()... steam is invalid");     // Catch: Throwable -> L18 IOException -> L20
        String r103 = r101.toString();     // Catch: Throwable -> L18 IOException -> L20
        closeSafe(r100);
        closeSafe(null);
        return r103;
    L38:
    L20:
        e = move-exception;
        BufferedReader r104 = null;
        IOException e100 = e;
    L25:
        String r105 = e100.getMessage();     // Catch: Throwable -> L31
        if (r105 != null) goto L28;
        r105 = "Unknown error";
    L28:
        Log.e(TAG, r105, e100);     // Catch: Throwable -> L31
    L29:
        closeSafe(r100);
        closeSafe(r104);
        return r101.toString();
    L31:
        th = th;
        r102 = r104;
    L33:
        closeSafe(r100);
        closeSafe(r102);
        throw th;
    L18:
        th = th;
        goto L33
    L5:
        if (r100.available() <= 0) goto L22;
        r104 = new BufferedReader(new InputStreamReader(r100));     // Catch: Throwable -> L18 IOException -> L20
        String r106 = null;
    L35:
        String r107 = r104.readLine();     // Catch: IOException -> L16 Throwable -> L31
        if (r107 == null) goto L12;
        r106 = r107;
    L13:
        if (r107 == null) goto L29;
        r101.append(r106 + System.getProperty("line.separator"));     // Catch: IOException -> L16 Throwable -> L31
        goto L35
    L12:
        r107 = null;
    L16:
        e100 = e;
        goto L25
    }

    public final String getOfflineFileVersion(String r100) {
        if (r100 == null) goto L18;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, ChameleonResConstants.TEMPLATE_VERSION);
        if (r101.isFile() == true) goto L6;
        return "";
    L6:
        if (r101.exists() == false) goto L20;
        return getOfflineResVersion(new BufferedReader(new PolarisFileReaderWrapper(r101)));
    L9:
        e = move-exception;
        String r102 = e.getMessage();
        if (r102 != null) goto L13;
        r102 = "Unknown error";
    L13:
        Log.e(TAG, r102, e);
        return "";
    L20:
        return "";
    L18:
        return "";
    }

    private final File getOfflineParentDir(ChameleonConfig r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(getWebcontainerRootDir());
        if (r100 == null) goto L9;
        ResConfig r103 = r100.getResConfig();
        if (r103 == null) goto L9;
        String r104 = r103.getRootPath();
        if (r104 == null) goto L9;
        r102 = new PolarisFileWrapper(r102, r104);
    L9:
        if (r101 == null) goto L12;
        r102 = new PolarisFileWrapper(r102, r101);
    L12:
        if (r102.exists() == true) goto L14;
        r102.mkdirs();
    L18:
        return r102;
    L14:
        if (r102.isFile() == false) goto L16;
        r102.delete();
    L16:
        r102.mkdirs();
        goto L18
    }

    private final void pickUpFiles(File[] r100, ArrayList<File> r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        File r104 = r100[r103];
        if (CommonResUtils.isValidVersion(r104.getName()) == false) goto L7;
        r101.add(r104);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public final ChameleonResInfo getResInfoOf7z(ChameleonConfig r110, String r111) {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
        if (r110 == null) goto L12;
        ResConfig r112 = r110.getResConfig();
        if (r112 == null) goto L12;
        String r102 = r112.getOfflineZipName();
        if (r102 == null) goto L12;
        List r113 = StringsKt.split$default(r102, new String[]{"."}, false, 0, 6, null);
        if (r113 == null) goto L12;
        String r114 = (String) ListProtector.get(r113, 0);
        if (r114 == null) goto L12;
    L13:
        r100.append(r114);
        r100.append(File.separator);
        r100.append(ChameleonResConstants.TEMPLATE_VERSION);
        String r115 = LzmaUtils.extract7zEntry(r111, r100.toString());
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r115) == false) goto L17;
        r101 = -1;
    L17:
        r103.put("result", r101);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r115) == false) goto L22;
        Log.e(TAG, "get versioninfo is null");     // Catch: Exception -> L23
        return new ChameleonResInfo(null, null, 3, null);
    L22:
        return getResInfo(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r115.getBytes(Charsets.UTF_8)))));
    L23:
        e = move-exception;
        Log.e(TAG, "getResInfoOf7z: report event fails:" + e);
        return new ChameleonResInfo(null, null, 3, null);
    L12:
        r114 = "";
        goto L13
    }

    public final File getResourceRootDir(ChameleonConfig r100, String r101) throws IOException {
        return getOfflineParentDir(r100, r101);
    }
}
