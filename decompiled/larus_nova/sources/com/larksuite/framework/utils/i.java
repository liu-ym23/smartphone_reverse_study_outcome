package com.larksuite.framework.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i {
    public static PolarisFileWrapper f(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory() + File.separator + r100);
        if (r101.exists() == true) goto L5;
        r101.mkdirs();
    L5:
        return r101;
    }

    public static String g(String r100, String r101) {
        PolarisFileWrapper r102 = f(r100);
        r102.mkdirs();
        String r103 = PatternProtector.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]").matcher(r101).replaceAll("_");
        Log.i("ExternalStorageUtils", "getExportFileName: " + r103);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102, r103);
        int r105 = r103.lastIndexOf(46);
        if (r105 >= 0) goto L5;
        r105 = r103.length();
    L5:
        int r106 = 0;
        String r107 = r103;
    L7:
        if (r104.exists() == false) goto L9;
        r106 = r106 + 1;
        r107 = new StringBuilder(r103).insert(r105, "(" + r106 + ")").toString();
        r104 = new PolarisFileWrapper(r102, r107);
        goto L7
    L9:
        Log.i("ExternalStorageUtils", "getUniqueFileNameWithNumber: " + r106);
        return r107;
    }

    public static boolean a(Context r100, String r101, Uri r102) {
        Log.i("ExternalStorageUtils", "copyFileToUri: uri = " + r102);
        if (r101 == null) goto L10;
        if (r102 == null) goto L10;
        return b(r100, new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r101)), r102);
    L8:
        e = move-exception;
        Log.e("ExternalStorageUtils", "copyFileToUri: ", e);
        e.printStackTrace();
    L10:
        return false;
    }

    public static boolean b(Context r100, InputStream r101, Uri r102) {
        Log.i("ExternalStorageUtils", "copyInputStreamToUri: uri = " + r102);
        if (r102 != null) goto L20;
    L19:
        return false;
    L20:
    L17:
        e = move-exception;
        Log.e("ExternalStorageUtils", "copyInputStreamToUri fail ", e);
        e.printStackTrace();
        goto L19
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L8;
        OutputStream r103 = new PolarisFileOutputStreamWrapper(r102.getPath());     // Catch: IOException -> L17
    L9:
        if (r103 == null) goto L19;
        byte[] r104 = new byte[1024];     // Catch: IOException -> L17
    L11:
        int r105 = r101.read(r104);     // Catch: IOException -> L17
        if (r105 == (-1)) goto L14;
        r103.write(r104, 0, r105);     // Catch: IOException -> L17
        goto L11
    L14:
        r103.flush();     // Catch: IOException -> L17
        r101.close();     // Catch: IOException -> L17
        r103.close();     // Catch: IOException -> L17
        Log.i("ExternalStorageUtils", "copyInputStreamToUri success");     // Catch: IOException -> L17
        return true;
    L8:
        r103 = ContentResolverWrapper.openOutputStream(r100.getContentResolver(), r102);     // Catch: IOException -> L17
        goto L9
    }

    public static void h(Context r100, Uri r110, Token r111) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 29) goto L16;
        String r112 = r110.getPath();
        String[] r113 = FileUtils.f285888a;
        if (TextUtils.isEmpty(r112) == true) goto L24;
        PolarisFileWrapper r114 = new PolarisFileWrapper(r112);
        if (r101 >= 29) goto L10;
    L13:
        DownloadManager r102 = (DownloadManager) r100.getSystemService("download");
        if (r102 == null) goto L21;
        r102.addCompletedDownload(r114.getName(), r114.getName(), true, FileUtils.p(r114.getPath()), r114.getAbsolutePath(), r114.length(), true);
        return;
    L21:
        return;
    L10:
        if (Environment.isExternalStorageLegacy() == true) goto L13;
        Log.e("FileUtils", "target Build.VERSION_CODES Q or above and running under the scoped storage model!!! ");
        return;
    L24:
        return;
    L16:
        String r115 = FileUtils.q(r100, r110);
        if (r115 == null) goto L23;
        MediaStoreUtil.j(r100, r115, r111);
        return;
    }

    public static void i(Context r100, Uri r101, Token r102) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        FileUtils.v(r100, r101.getPath(), r102);
        return;
    L5:
        String r103 = FileUtils.q(r100, r101);
        if (r103 == null) goto L10;
        MediaStoreUtil.j(r100, r103, r102);
        return;
    }

    public static void j(Context r100, Uri r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101.getPath());
        int r104 = Build.VERSION.SDK_INT;
        boolean r105 = false;
        if (r104 >= 29) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L8;
        if (r104 != 29) goto L15;
        r105 = true;
    L15:
        if (r105 == true) goto L17;
    L21:
        Set<String> r107 = MediaStoreUtil.f285910a;
        if (BdMediaFileSystem.isUriExists(r100, r101) == true) goto L25;
        return;
    L25:
        if (TextUtils.isEmpty(r102) == false) goto L27;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r102 = r100.getContentResolver().getType(r101);
    L27:
        Log.i("ExternalStorageUtils", "openUri: uri = " + r101 + ", mimeType = " + r102);
        Intent r108 = new Intent();
        r108.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r108.addFlags(268435456);
        r108.setDataAndType(r101, r102);
        if (r104 < 24) goto L35;
        r108.addFlags(1);
        r108.addFlags(2);
    L35:
        r100.startActivity(r108);     // Catch: Exception -> L32
        return;
    L32:
        e = move-exception;
        Log.e("ExternalStorageUtils", "openUri: ", e);
        return;
    L17:
        if (r103.exists() == false) goto L21;
        r101 = m.a(r100, new PolarisFileWrapper(r101.getPath()));
        if (TextUtils.isEmpty(r102) == false) goto L27;
        String[] r109 = FileUtils.f285888a;
        r102 = FileUtils.p(r103.getPath());
        goto L27
    L8:
        if (r103.exists() == true) goto L10;
        return;
    L10:
        r101 = m.a(r100, new PolarisFileWrapper(r101.getPath()));
        if (TextUtils.isEmpty(r102) == false) goto L27;
        String[] r110 = FileUtils.f285888a;
        r102 = FileUtils.p(r103.getPath());
        goto L27
    L5:
        r106 = false;
        goto L6
    }

    public static Uri c(Context r100, String r101, String r102, MediaStoreUtil.DirType r103) {
        return e(r100, r101, r102, r103, null);
    }

    public static Uri d(Context r100, String r101, String r102, Token r103) {
        Set<String> r104 = MediaStoreUtil.f285910a;
        MediaStoreUtil.DirType r105 = MediaStoreUtil.h(r101);
        Log.i("ExternalStorageUtils", "createUriPsda ... mimeType = dirType =" + r105 + " name =" + r101);
        if (TextUtils.isEmpty(r102) == true) goto L10;
        if (r102.startsWith("image") == true) goto L10;
        if (r105 != MediaStoreUtil.DirType.PICTURES) goto L10;
        Log.i("ExternalStorageUtils", "createUriPsda .. force dirType to be DOWNLOADS");
        r105 = MediaStoreUtil.DirType.DOWNLOADS;
    L10:
        return e(r100, r101, r102, r105, r103);
    }

    public static Uri e(Context r100, String r101, String r102, MediaStoreUtil.DirType r110, Token r111) {
        Uri r103 = null;
        if (r110 == null) goto L47;
    L7:
        StringBuilder r104 = new StringBuilder("createUri Build.VERSION.SDK_INT =");     // Catch: Throwable -> L5
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L5
        r104.append(r105);     // Catch: Throwable -> L5
        r104.append(" mimeType =");     // Catch: Throwable -> L5
        r104.append(r102);     // Catch: Throwable -> L5
        r104.append(" dirType =");     // Catch: Throwable -> L5
        r104.append(r110);     // Catch: Throwable -> L5
        r104.append(" name =");     // Catch: Throwable -> L5
        r104.append(r101);     // Catch: Throwable -> L5
        Log.i("ExternalStorageUtils", r104.toString());     // Catch: Throwable -> L5
        boolean r106 = true;
        if (r105 >= 29) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L14;
        String r108 = MediaStoreUtil.i(r110);     // Catch: Throwable -> L5
        return Uri.fromFile(new PolarisFileWrapper(f(r108), g(r108, r101)));
    L14:
        if (TextUtils.isEmpty(r102) == false) goto L46;
        r102 = FileUtils.p(r101);     // Catch: Throwable -> L5
    L46:
    L28:
        th = move-exception;
        Log.e("ExternalStorageUtils", "createUri fallback", th);     // Catch: Throwable -> L5
    L38:
        if (r103 != null) goto L45;
        if (r111 == null) goto L50;
        return MediaStoreUtil.e(r100, r101, FileUtils.p(r101), MediaStoreUtil.DirType.DOWNLOADS, r111);
    L50:
        return MediaStoreUtil.d(r100, r101, FileUtils.p(r101), MediaStoreUtil.DirType.DOWNLOADS);
    L45:
        return r103;
    L5:
        th = move-exception;
        Log.e("ExternalStorageUtils", "createUri", th);
        goto L45
    L17:
        if (r102.contains("image") == false) goto L19;
    L33:
        if (r111 == null) goto L35;
        Uri r109 = MediaStoreUtil.e(r100, r101, r102, r110, r111);     // Catch: Throwable -> L28
    L36:
        r103 = r109;
        goto L38
    L35:
        r109 = MediaStoreUtil.d(r100, r101, r102, r110);     // Catch: Throwable -> L28
        goto L36
    L19:
        if (r102.contains("video") == true) goto L33;
        if (r102.contains("audio") == true) goto L33;
        if (r105 == 29) goto L26;
        r106 = false;
    L26:
        if (r106 == false) goto L30;
        String r112 = MediaStoreUtil.i(r110);     // Catch: Throwable -> L28
        r109 = Uri.fromFile(new PolarisFileWrapper(f(r112), g(r112, r101)));     // Catch: Throwable -> L28
        goto L36
    L30:
        if (r111 == null) goto L32;
        r109 = MediaStoreUtil.e(r100, r101, r102, r110, r111);     // Catch: Throwable -> L28
        goto L36
    L32:
        r109 = MediaStoreUtil.d(r100, r101, r102, r110);     // Catch: Throwable -> L28
        goto L36
    L10:
        r107 = false;
        goto L11
    L47:
        Set<String> r113 = MediaStoreUtil.f285910a;     // Catch: Throwable -> L5
        r110 = MediaStoreUtil.h(r101);     // Catch: Throwable -> L5
        goto L7
    }
}
