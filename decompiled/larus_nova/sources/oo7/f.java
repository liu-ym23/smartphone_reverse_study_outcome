package oo7;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f524620a;

    public static String e() {
        if (TextUtils.isEmpty(f524620a) == true) goto L7;
        return f524620a;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        Context r100 = com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a;
        if (r100 != null) goto L12;
        return null;
    L12:
        File r101 = r100.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (r101 == null) goto L18;
        if (r101.exists() == false) goto L18;
        f524620a = r101.getAbsolutePath();
    L18:
        return f524620a;
    L19:
        File r102 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "Camera");
        if (r103.exists() == false) goto L23;
        String r104 = r103.getAbsolutePath();
        f524620a = r104;
        return r104;
    L23:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102, "100MEDIA");
        if (r105.exists() == false) goto L27;
        String r106 = r105.getAbsolutePath();
        f524620a = r106;
        return r106;
    L27:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r102, "100ANDRO");
        if (r107.exists() == false) goto L31;
        String r108 = r107.getAbsolutePath();
        f524620a = r108;
        return r108;
    L31:
        String r109 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "share_content_cache";
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109);
        if (r110.exists() == true) goto L34;
        r110.mkdirs();
    L34:
        f524620a = r109;
        return r109;
    }

    public static String f() {
        Context r100 = com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a;
        if (r100 != null) goto L6;
        return null;
    L6:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getExternalCacheDir(), "share_content_cache");
        if (r101.exists() == true) goto L10;
        r101.mkdirs();
    L10:
        return r101.getPath();
    }

    public static Bitmap d(String r100) {
        Context r101 = com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a;
        Bitmap r102 = null;
        ParcelFileDescriptor r103 = null;
        r102 = null;
        if (r101 != null) goto L62;
        return null;
    L62:
        ContentResolver r104 = r101.getContentResolver();     // Catch: Throwable -> L30
        Cursor r105 = c(r104, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{DBDefinition.ID}, "_data=?", new String[]{r100});     // Catch: Throwable -> L30
        if (r105 != null) goto L54;
    L20:
        Bitmap r106 = null;
    L21:
        if (r105 != null) goto L52;
    L25:
        if (r103 == null) goto L66;
        r103.close();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L66:
        return r106;
    L52:
        r105.close();     // Catch: Exception -> L23
        goto L25
    L54:
    L18:
        th = move-exception;
        Throwable th10 = th;
        ParcelFileDescriptor r107 = null;
    L56:
        th10.printStackTrace();     // Catch: Throwable -> L42
        if (r105 != null) goto L60;
    L37:
        if (r107 == null) goto L67;
        r107.close();     // Catch: Exception -> L35
        return null;
    L35:
        e = move-exception;
        e.printStackTrace();
        return null;
    L67:
        return null;
    L60:
        r105.close();     // Catch: Exception -> L35
    L42:
        th = move-exception;
        if (r105 != null) goto L58;
    L47:
        if (r107 == null) goto L51;
        r107.close();     // Catch: Exception -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L58:
        r105.close();     // Catch: Exception -> L45
        goto L47
    L8:
        if (r105.moveToFirst() == false) goto L20;
        r107 = b(r104, ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r105.getInt(r105.getColumnIndex(DBDefinition.ID))));     // Catch: Throwable -> L18
        if (r107 != null) goto L64;
    L17:
        Bitmap r108 = r102;
        r103 = r107;
        r106 = r108;
        goto L21
    L64:
    L15:
        th10 = th;
        goto L56
    L12:
        if (r107.getFileDescriptor() == null) goto L17;
        r102 = BitmapFactory.decodeFileDescriptor(r107.getFileDescriptor());     // Catch: Throwable -> L15
    L30:
        th = move-exception;
        th10 = th;
        r105 = null;
        r107 = null;
        goto L56
    }

    public static ParcelFileDescriptor b(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean i(InputStream r100, String r101) {
        if (r100 != null) goto L5;
    L48:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L48;
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L34 Exception -> L49
        if (r103.exists() == false) goto L11;
    L17:
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r103, "wx_share_temp.jpg"));     // Catch: Throwable -> L34 Exception -> L49
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L31 Exception -> L33
    L20:
        int r106 = r100.read(r105);     // Catch: Throwable -> L31 Exception -> L33
        if (r106 == (-1)) goto L23;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L31 Exception -> L33
        goto L20
    L23:
        r104.flush();     // Catch: Throwable -> L31 Exception -> L33
        r104.close();     // Catch: Throwable -> L31 Exception -> L33
        r100.close();     // Catch: Throwable -> L34 Exception -> L49
        r100.close();     // Catch: Exception -> L27
        return true;
    L27:
        e = move-exception;
        k.b(e.toString());
        return true;
        goto L50
    L33:
        r102 = r104;
    L31:
        th = th;
        r102 = r104;
    L52:
        r100.close();     // Catch: Exception -> L39
        if (r102 == null) goto L41;
        r102.close();     // Catch: Exception -> L39
    L41:
        throw th;
    L39:
        e = move-exception;
        k.b(e.toString());
        goto L41
    L11:
        if (r103.mkdirs() == true) goto L17;
        r100.close();     // Catch: Exception -> L14
    L16:
        return false;
    L14:
        e = move-exception;
        k.b(e.toString());
    L34:
        th = th;
    L50:
        r100.close();     // Catch: Exception -> L46
        if (r102 == null) goto L48;
        r102.close();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        k.b(e.toString());
        goto L48
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

    public static Uri g(Context r100, String r101, boolean r102) {
        if (Build.VERSION.SDK_INT < 29) goto L40;
        Uri r103 = null;
        if (r100 != null) goto L43;
        return null;
    L43:
        ContentResolver r104 = r100.getContentResolver();     // Catch: Throwable -> L21
        if (r102 == false) goto L10;
        Uri r105 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L21
    L11:
        Cursor r106 = c(r104, r105, new String[]{DBDefinition.ID}, "_data=?", new String[]{r101});     // Catch: Throwable -> L21
        if (r106 != null) goto L47;
    L19:
        if (r106 != null) goto L41;
    L29:
        if (r103 == null) goto L31;
        return r103;
    L31:
        return n.b(r101);
    L41:
        r106.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L47:
    L17:
        Throwable th10 = th;
    L45:
        th10.printStackTrace();     // Catch: Throwable -> L32
        if (r106 == null) goto L29;
    L32:
        th = move-exception;
        if (r106 != null) goto L49;
    L38:
        throw th;
    L49:
        r106.close();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L14:
        if (r106.moveToFirst() == false) goto L19;
        r103 = ContentUris.withAppendedId(r105, r106.getInt(r106.getColumnIndex(DBDefinition.ID)));     // Catch: Throwable -> L17
        goto L19
    L10:
        r105 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L45
    L40:
        return n.b(r101);
    }

    public static boolean h(Bitmap r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L46:
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L46;
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L46;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L12;
        r103.mkdirs();
    L12:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103 + HTTP.URL_DEFAULT + r102);
        if (r104.exists() == false) goto L49;
    L19:
        PolarisFileOutputStreamWrapper r105 = null;
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L32 Exception -> L34
        r100.compress(Bitmap.CompressFormat.JPEG, 100, r106);     // Catch: Throwable -> L28 Exception -> L30
        r106.flush();     // Catch: Throwable -> L28 Exception -> L30
        r106.close();     // Catch: Exception -> L24
        return true;
    L24:
        e = move-exception;
        e.printStackTrace();
        return true;
    L30:
        e = e;
        r105 = r106;
    L35:
        e.printStackTrace();     // Catch: Throwable -> L32
        r105.close();     // Catch: Exception -> L38
    L40:
        return false;
    L38:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = th;
        r105 = r106;
    L55:
        r105.close();     // Catch: Exception -> L43
    L45:
        throw th;
    L43:
        e = move-exception;
        e.printStackTrace();
    L32:
        th = th;
    L34:
        e = e;
        goto L35
    L49:
        r104.createNewFile();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void j(Context r100, String r101, boolean r110) {
        if (Build.VERSION.SDK_INT < 29) goto L93;
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L116;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L11;
        return;
    L11:
        ContentResolver r103 = r100.getContentResolver();
        String r104 = r102.getName();
        BufferedInputStream r105 = null;
        OutputStream r106 = null;
        r106 = null;
        r106 = null;
        r105 = null;
        if (r110 == false) goto L14;
        Uri r107 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L30
    L15:
        boolean r108 = true;
        Cursor r109 = c(r103, r107, new String[]{DBDefinition.ID}, "_display_name=?", new String[]{r104});     // Catch: Throwable -> L30
        if (r109 != null) goto L97;
    L25:
        if (r109 != null) goto L103;
    L34:
        r108 = false;
    L35:
        if (r108 == false) goto L37;
        return;
    L37:
        ContentValues r111 = new ContentValues();
        r111.put("title", r102.getName());
        r111.put("_display_name", r102.getName());
        if (r110 == false) goto L40;
        String r112 = "image/*";
    L41:
        r111.put("mime_type", r112);
        if (r110 == false) goto L44;
        String r113 = Environment.DIRECTORY_DCIM + "/Camera";
    L45:
        r111.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r113);
        if (r110 == false) goto L48;
        Uri r114 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L69 IOException -> L71
    L49:
        Uri r115 = a(r103, r114, r111);     // Catch: Throwable -> L69 IOException -> L71
        BufferedInputStream r116 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r102));     // Catch: Throwable -> L69 IOException -> L71
        if (r115 != null) goto L107;
    L54:
        if (r106 == null) goto L61;
        byte[] r117 = new byte[4096];     // Catch: IOException -> L52 Throwable -> L67
    L56:
        int r118 = r116.read(r117);     // Catch: IOException -> L52 Throwable -> L67
        if (r118 == (-1)) goto L59;
        r106.write(r117, 0, r118);     // Catch: IOException -> L52 Throwable -> L67
        goto L56
    L59:
        r106.flush();     // Catch: IOException -> L52 Throwable -> L67
    L61:
        if (Build.MODEL.equals("M2002J9E") == false) goto L63;
        r102.delete();     // Catch: IOException -> L52 Throwable -> L67
    L52:
        e = e;
        OutputStream r119 = r106;
        r105 = r116;
    L99:
        e.printStackTrace();     // Catch: Throwable -> L83
        if (r105 == null) goto L78;
        r105.close();     // Catch: IOException -> L76
    L78:
        if (r119 == null) goto L112;
        r119.close();     // Catch: IOException -> L76
        return;
    L112:
        return;
    L83:
        th = th;
    L84:
        if (r105 != null) goto L94;
    L88:
        if (r119 == null) goto L92;
        r119.close();     // Catch: IOException -> L86
    L86:
        e = move-exception;
        e.printStackTrace();
    L92:
        throw th;
    L94:
        r105.close();     // Catch: IOException -> L86
    L67:
        th = th;
        r119 = r106;
        r105 = r116;
    L63:
        r116.close();     // Catch: IOException -> L76
        if (r106 == null) goto L111;
        r106.close();     // Catch: IOException -> L76
        return;
    L111:
        return;
    L107:
        r106 = ContentResolverWrapper.openOutputStream(r103, r115);     // Catch: IOException -> L52 Throwable -> L67
        goto L54
    L48:
        r114 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L69 IOException -> L71
    L76:
        e = move-exception;
        e.printStackTrace();
        return;
    L71:
        e = e;
        r119 = null;
    L69:
        th = th;
        r119 = null;
        goto L84
    L44:
        r113 = Environment.DIRECTORY_MOVIES;
        goto L45
    L40:
        r112 = MimeType.MP4;
    L103:
        r109.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L34
    L97:
        if (r109.moveToFirst() == false) goto L25;
        b(r103, Uri.parse(r107.toString() + HTTP.URL_DEFAULT + r109.getString(0)));     // Catch: Throwable -> L24
        r109.close();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L31:
        if (r109 == null) goto L34;
    L14:
        r107 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L30
    L30:
        r109 = null;
        goto L31
    L116:
        return;
    }

    public static Cursor c(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
