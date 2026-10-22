package com.larus.bmhome.bigimg;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.downloadlib.constants.MimeType;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f295998a;

    public static String b() {
        if (TextUtils.isEmpty(f295998a) == true) goto L7;
        return f295998a;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Application r100 = AppHost.f326268a.getApplication();
        if (r100 != null) goto L12;
        return null;
    L12:
        File r101 = r100.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (r101 == null) goto L18;
        if (r101.exists() == false) goto L18;
        f295998a = r101.getAbsolutePath();
    L18:
        return f295998a;
    L19:
        File r102 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "Camera");
        if (r103.exists() == false) goto L23;
        String r104 = r103.getAbsolutePath();
        f295998a = r104;
        return r104;
    L23:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102, "100MEDIA");
        if (r105.exists() == false) goto L27;
        String r106 = r105.getAbsolutePath();
        f295998a = r106;
        return r106;
    L27:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r102, "100ANDRO");
        if (r107.exists() == false) goto L31;
        String r108 = r107.getAbsolutePath();
        f295998a = r108;
        return r108;
    L31:
        String r109 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "nova_image";
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109);
        if (r110.exists() == true) goto L34;
        r110.mkdirs();
    L34:
        f295998a = r109;
        return r109;
    }

    public static Uri c(Context r100, PolarisFileWrapper r101) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L14;
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".ug.sdk.share.fileprovider", r101);
    L9:
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".fileprovider", r101);
    L11:
        th = move-exception;
        FLogger.f375446a.e("ImageFileUtils", th.toString());
        return null;
    L14:
        return Uri.fromFile(r101);
    L5:
        r102 = false;
        goto L6
    }

    public static Uri a(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean d(File r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L90:
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L90;
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L90;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L12;
        r103.mkdirs();
    L12:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, r102);
        if (r104.exists() == false) goto L28;
        r104 = new PolarisFileWrapper(r103, r102);
        if (r104.exists() == false) goto L28;
        int r105 = r102.lastIndexOf(".");
        if (r105 > 0) goto L20;
    L22:
        String r106 = r102;
        String r107 = "";
    L23:
        int r108 = 1;
    L25:
        if (r104.exists() == false) goto L28;
        r104 = new PolarisFileWrapper(r103, r106 + "(" + r108 + ")" + r107);
        r108 = r108 + 1;
        goto L25
    L20:
        if (r105 >= (r102.length() - 1)) goto L22;
        r106 = r102.substring(0, r105);
        r107 = r102.substring(r105);
    L28:
        if (r104.exists() == false) goto L97;
    L34:
        PolarisFileInputStreamWrapper r109 = null;
        PolarisFileInputStreamWrapper r110 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L62 Exception -> L64
        PolarisFileOutputStreamWrapper r111 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L56 Exception -> L59
    L107:
        byte[] r112 = new byte[2048];     // Catch: Throwable -> L52 Exception -> L54
    L40:
        if (r110.read(r112) < 0) goto L42;
        r111.write(r112);     // Catch: Throwable -> L52 Exception -> L54
        goto L40
    L42:
        r111.flush();     // Catch: Throwable -> L52 Exception -> L54
        r110.close();     // Catch: Exception -> L45
    L99:
        r111.close();     // Catch: Exception -> L49
    L51:
        return true;
    L49:
        e = move-exception;
        e.printStackTrace();
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L99
    L54:
        e = e;
    L61:
        r109 = r110;
    L93:
        e.printStackTrace();     // Catch: Throwable -> L78
        if (r109 != null) goto L101;
    L72:
        if (r111 != null) goto L105;
    L77:
        return false;
    L105:
        r111.close();     // Catch: Exception -> L75
    L75:
        e = move-exception;
        e.printStackTrace();
        goto L77
    L101:
        r109.close();     // Catch: Exception -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
    L78:
        th = th;
    L79:
        if (r109 != null) goto L95;
    L84:
        if (r111 == null) goto L115;
        r111.close();     // Catch: Exception -> L87
        throw th;
    L87:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L115:
        throw th;
    L95:
        r109.close();     // Catch: Exception -> L82
    L82:
        e = move-exception;
        e.printStackTrace();
    L52:
        th = th;
    L58:
        r109 = r110;
    L59:
        e = e;
        r111 = null;
    L56:
        th = th;
        r111 = null;
        goto L58
    L64:
        e = e;
        r111 = null;
    L62:
        th = th;
        r111 = null;
        goto L79
    L97:
        r104.createNewFile();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean e(Bitmap r110, String r111, String r112) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
    L75:
        return false;
    L5:
        if (TextUtils.isEmpty(r112) == true) goto L75;
        PolarisFileOutputStreamWrapper r100 = null;
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L40;
        int r101 = j1.f296003a;
        AppHost.Companion r102 = AppHost.f326268a;
        String r103 = r102.getApplication().getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNull(r103);
        String r104 = StringsKt.replace$default(r103, "/user/0/", "/data/", false, 4, null);
        String r105 = r102.getApplication().getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNull(r105);
        String r106 = StringsKt.replace$default(r105, "/user/0/", "/data/", false, 4, null);
        if (r111 != null) goto L12;
    L14:
        boolean r107 = false;
    L15:
        if (r107 == true) goto L36;
        if (r111 != null) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == true) goto L36;
        if (r111 != null) goto L24;
    L26:
        boolean r109 = false;
    L27:
        if (r109 == true) goto L36;
        if (r111 != null) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == true) goto L36;
        boolean r114 = false;
    L37:
        if (r114 == true) goto L40;
        return false;
    L30:
        if (StringsKt.startsWith$default(r111, r106, false, 2, null) != true) goto L32;
        r113 = true;
        goto L33
    L24:
        if (StringsKt.startsWith$default(r111, r105, false, 2, null) != true) goto L26;
        r109 = true;
        goto L27
    L18:
        if (StringsKt.startsWith$default(r111, r104, false, 2, null) != true) goto L20;
        r108 = true;
    L36:
        r114 = true;
        goto L37
    L12:
        if (StringsKt.startsWith$default(r111, r103, false, 2, null) != true) goto L14;
        r107 = true;
    L40:
        PolarisFileWrapper r115 = new PolarisFileWrapper(r111);
        if (r115.exists() == true) goto L43;
        r115.mkdirs();
    L43:
        PolarisFileWrapper r116 = new PolarisFileWrapper(r115 + HTTP.URL_DEFAULT + r112);
        if (r116.exists() == false) goto L83;
    L80:
        PolarisFileOutputStreamWrapper r117 = new PolarisFileOutputStreamWrapper(r116);     // Catch: Throwable -> L61 Exception -> L63
        r110.compress(Bitmap.CompressFormat.JPEG, 100, r117);     // Catch: Throwable -> L57 Exception -> L59
        r117.flush();     // Catch: Throwable -> L57 Exception -> L59
        r117.close();     // Catch: Exception -> L54
    L56:
        return true;
    L54:
        e = move-exception;
        e.printStackTrace();
        goto L56
    L59:
        e = e;
        r100 = r117;
    L64:
        e.printStackTrace();     // Catch: Throwable -> L61
        r100.close();     // Catch: Exception -> L67
    L69:
        return false;
    L67:
        e = move-exception;
        e.printStackTrace();
    L57:
        th = th;
        r100 = r117;
    L78:
        r100.close();     // Catch: Exception -> L72
    L74:
        throw th;
    L72:
        e = move-exception;
        e.printStackTrace();
    L63:
        e = e;
    L61:
        th = th;
        goto L78
    L83:
        r116.createNewFile();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static Uri f(Context r100, String r101, boolean r102) {
        BufferedInputStream r103 = null;
        OutputStream r104 = null;
        r104 = null;
        r104 = null;
        r103 = null;
        if (r100 != null) goto L5;
    L73:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L73;
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        MediaScannerConnection.scanFile(r100, new String[]{r101}, null, new h1());
        return null;
    L11:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101);
        if (r105.exists() == true) goto L14;
        return null;
    L14:
        ContentResolver r106 = r100.getContentResolver();
        ContentValues r107 = new ContentValues();
        r107.put("title", r105.getName());
        r107.put("_display_name", r105.getName());
        if (r102 == false) goto L17;
        String r108 = "image/*";
    L18:
        r107.put("mime_type", r108);
        if (r102 == false) goto L21;
        String r109 = Environment.DIRECTORY_PICTURES;
    L22:
        r107.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r109);
        if (r102 == false) goto L25;
        Uri r110 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L28
    L26:
        Uri r111 = a(r106, r110, r107);     // Catch: Exception -> L28
    L76:
        BufferedInputStream r112 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r105));     // Catch: Throwable -> L49 IOException -> L51
        if (r111 != null) goto L81;
    L36:
        if (r104 == null) goto L45;
        byte[] r113 = new byte[4096];     // Catch: Throwable -> L32 IOException -> L34
    L38:
        int r114 = r112.read(r113);     // Catch: Throwable -> L32 IOException -> L34
        if (r114 == (-1)) goto L41;
        r104.write(r113, 0, r114);     // Catch: Throwable -> L32 IOException -> L34
        goto L38
    L41:
        r104.flush();     // Catch: Throwable -> L32 IOException -> L34
    L34:
        e = e;
        OutputStream r115 = r104;
        r103 = r112;
        OutputStream r116 = r115;
    L77:
        e.printStackTrace();     // Catch: Throwable -> L63
        if (r103 == null) goto L58;
        r103.close();     // Catch: IOException -> L56
    L58:
        if (r116 == null) goto L62;
        r116.close();     // Catch: IOException -> L56
    L62:
        return r111;
    L63:
        th = th;
    L64:
        if (r103 != null) goto L74;
    L68:
        if (r116 == null) goto L72;
        r116.close();     // Catch: IOException -> L66
    L66:
        e = move-exception;
        e.printStackTrace();
    L72:
        throw th;
    L74:
        r103.close();     // Catch: IOException -> L66
    L32:
        th = th;
        OutputStream r117 = r104;
        r103 = r112;
        r116 = r117;
    L45:
        r112.close();     // Catch: IOException -> L56
        if (r104 == null) goto L62;
        r104.close();     // Catch: IOException -> L56
        goto L62
    L81:
        r104 = ContentResolverWrapper.openOutputStream(r106, r111);     // Catch: Throwable -> L32 IOException -> L34
        goto L36
    L56:
        e = move-exception;
        e.printStackTrace();
    L51:
        e = e;
        r116 = null;
    L49:
        th = th;
        r116 = null;
        goto L64
    L25:
        r110 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L28
    L28:
        r111 = null;
        goto L76
    L21:
        r109 = Environment.DIRECTORY_MOVIES;
        goto L22
    L17:
        r108 = MimeType.MP4;
        goto L18
    }

    public static Uri g(Context r100, String r101, String r102, boolean r103) {
        BufferedInputStream r104 = null;
        OutputStream r105 = null;
        r105 = null;
        r105 = null;
        r104 = null;
        if (r100 != null) goto L5;
    L75:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L75;
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        MediaScannerConnection.scanFile(r100, new String[]{r101}, null, new h1());
        return null;
    L11:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101);
        if (r106.exists() == true) goto L14;
        return null;
    L14:
        if (r102 != null) goto L19;
        if (r103 == false) goto L17;
        String r107 = Environment.DIRECTORY_DCIM;
    L18:
        r102 = r107;
        goto L19
    L17:
        r107 = Environment.DIRECTORY_MOVIES;
    L19:
        ContentResolver r108 = r100.getContentResolver();
        ContentValues r109 = new ContentValues();
        r109.put("title", r106.getName());
        r109.put("_display_name", r106.getName());
        if (r103 == false) goto L22;
        String r110 = "image/*";
    L23:
        r109.put("mime_type", r110);
        r109.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r102);
        if (r103 == false) goto L26;
        Uri r111 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L29
    L27:
        Uri r112 = a(r108, r111, r109);     // Catch: Exception -> L29
    L82:
        BufferedInputStream r113 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r106));     // Catch: Throwable -> L51 IOException -> L53
        if (r112 != null) goto L84;
    L38:
        if (r105 == null) goto L47;
        byte[] r114 = new byte[4096];     // Catch: Throwable -> L34 IOException -> L36
    L40:
        int r115 = r113.read(r114);     // Catch: Throwable -> L34 IOException -> L36
        if (r115 == (-1)) goto L43;
        r105.write(r114, 0, r115);     // Catch: Throwable -> L34 IOException -> L36
        goto L40
    L43:
        r105.flush();     // Catch: Throwable -> L34 IOException -> L36
    L36:
        e = e;
        OutputStream r116 = r105;
        r104 = r113;
        OutputStream r117 = r116;
    L78:
        e.printStackTrace();     // Catch: Throwable -> L65
        if (r104 == null) goto L60;
        r104.close();     // Catch: IOException -> L58
    L60:
        if (r117 == null) goto L64;
        r117.close();     // Catch: IOException -> L58
    L64:
        return r112;
    L65:
        th = th;
    L66:
        if (r104 != null) goto L80;
    L70:
        if (r117 == null) goto L74;
        r117.close();     // Catch: IOException -> L68
    L68:
        e = move-exception;
        e.printStackTrace();
    L74:
        throw th;
    L80:
        r104.close();     // Catch: IOException -> L68
    L34:
        th = th;
        OutputStream r118 = r105;
        r104 = r113;
        r117 = r118;
    L47:
        r113.close();     // Catch: IOException -> L58
        if (r105 == null) goto L64;
        r105.close();     // Catch: IOException -> L58
        goto L64
    L84:
        r105 = ContentResolverWrapper.openOutputStream(r108, r112);     // Catch: Throwable -> L34 IOException -> L36
        goto L38
    L58:
        e = move-exception;
        e.printStackTrace();
    L53:
        e = e;
        r117 = null;
    L51:
        th = th;
        r117 = null;
        goto L66
    L26:
        r111 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L29
    L29:
        e = move-exception;
        FLogger.f375446a.e("ImageFileUtils", "syncMediaToTargetAlbum failed", e);
        r112 = null;
        goto L82
    L22:
        r110 = MimeType.MP4;
        goto L23
    }
}
