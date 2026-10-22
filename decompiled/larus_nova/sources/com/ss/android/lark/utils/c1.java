package com.ss.android.lark.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.widget.Toast;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes38.dex */
public final class c1 {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f444703a = null;

        static {
            int[] r100 = new int[ImageUtils.ImageType.values().length];
            f444703a = r100;
            r100[ImageUtils.ImageType.TYPE_JPG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f444703a[ImageUtils.ImageType.TYPE_PNG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f444703a[ImageUtils.ImageType.TYPE_GIF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f444703a[ImageUtils.ImageType.TYPE_TIFF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f444703a[ImageUtils.ImageType.TYPE_BMP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f444703a[ImageUtils.ImageType.TYPE_WEBP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f444703a[ImageUtils.ImageType.TYPE_ICO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f444703a[ImageUtils.ImageType.TYPE_UNKNOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
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

    public static long b(Context r100, Uri r101) {
        ParcelFileDescriptor r102 = a(r100.getContentResolver(), r101);     // Catch: Throwable -> L10 FileNotFoundException -> L12
        if (r102 == null) goto L14;
        int r103 = r102.detachFd();
        r102.close();     // Catch: IOException -> L8
    L16:
        return r103;
    L8:
        e = move-exception;
        e.printStackTrace();
    L14:
        r103 = 0;
        goto L16
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        Log.e("UriUtils", "cannot open fd in r, reason:" + e.getMessage());     // Catch: Throwable -> L10
        goto L14
    }

    public static String c(Context r100, Uri r101) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L19;
        String r102 = FileUtils.q(r100, r101);
        if (e(r100, r102) == false) goto L9;
        return null;
    L9:
        if (r102 == null) goto L11;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);     // Catch: Exception -> L20
        if (r103.exists() == false) goto L18;
        if (r103.canRead() == true) goto L18;
        return d(r100, r101);
    L18:
        return r102;
    L11:
        return d(r100, r101);
    L19:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static String d(Context r100, Uri r101) {
        if (DevEnvUtil.isDebugMode(r100) == false) goto L8;
        String r102 = "Never Call This, Uri: " + r101;
        Toast.makeText(r100, r102, 0).show();     // Catch: Exception -> L7
    L7:
        Log.e("UriUtils", r102);
    L8:
        String r103 = r101.getPath();
        PolarisFileWrapper r104 = null;
        ?? r105 = 0;
        r104 = null;
        if (TextUtils.isEmpty(r103) == false) goto L12;
        return null;
    L12:
        if ("content".equalsIgnoreCase(r101.getScheme()) == false) goto L34;
        String[] r106 = FileUtils.f285888a;
        String[] r107 = {"_display_name"};
        Cursor r108 = FileUtils.a(r100.getContentResolver(), r101, r107);     // Catch: Throwable -> L24 Exception -> L26
        if (r108 != null) goto L90;
    L29:
        com.larksuite.framework.utils.d.a(r108);
        String r109 = null;
    L36:
        if (TextUtils.isEmpty(r109) == false) goto L39;
        r109 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(System.currentTimeMillis())) + ".";
    L39:
        if (TextUtils.isEmpty(r109) == false) goto L41;
        return null;
    L41:
        if (e(r100, r109) == true) goto L95;
        String r110 = com.ss.android.lark.diskmanage.storage.d.q(r100) + HTTP.URL_DEFAULT + System.currentTimeMillis() + HTTP.URL_DEFAULT;
        FileUtils.t(r110);
        if (new PolarisFileWrapper(r110).exists() == false) goto L96;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110 + File.separator + r109);
        InputStream r112 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);     // Catch: FileNotFoundException -> L52
        if (r112 == null) goto L55;
        FileUtils.d(r112, new PolarisFileOutputStreamWrapper(r111));     // Catch: FileNotFoundException -> L52
    L55:
        if (r111.exists() == true) goto L58;
        return null;
    L58:
        if (TextUtils.isEmpty(FileUtils.k(r109)) == true) goto L60;
    L80:
        if (r104 == null) goto L82;
        String r113 = r104.getAbsolutePath();
    L84:
        return r113;
    L82:
        r113 = r111.getAbsolutePath();
        goto L84
    L60:
        switch(a.f444703a[ImageUtils.c(r111).ordinal()]) {
            case 1: goto L74;
            case 2: goto L73;
            case 3: goto L72;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L69;
            case 7: goto L68;
            default: goto L61;
        };
    L61:
        String r114 = ImageUtils.a(r111);
        if (r114.contains("667479704D534E56") == false) goto L64;
    L76:
        String r115 = ".mp4";
    L77:
        PolarisFileWrapper r116 = new PolarisFileWrapper(r110 + File.separator + r109 + r115);
        if (r111.renameTo(r116) == false) goto L80;
        r104 = r116;
        goto L80
    L64:
        if (r114.contains("6674797069736F6D") == true) goto L76;
        if (r114.contains("667479706D703432") == true) goto L76;
        r115 = "";
        goto L77
    L68:
        r115 = ".ico";
        goto L77
    L69:
        r115 = ".webp";
        goto L77
    L70:
        r115 = ".bmp";
        goto L77
    L71:
        r115 = ".tif";
        goto L77
    L72:
        r115 = EffectConstants.GIF_FILE_SUFFIX;
        goto L77
    L73:
        r115 = RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
        goto L77
    L74:
        r115 = ".jpg";
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L55
    L96:
        return null;
    L95:
        return null;
    L90:
    L22:
        e = e;
    L28:
        Log.i("FileUtils", String.format(Locale.getDefault(), "getFileNameFromContentUri: _display_name - [%s]", new Object[]{e.getMessage()}));     // Catch: Throwable -> L30
        goto L29
    L17:
        if (r108.moveToFirst() == false) goto L29;
        int r117 = r108.getColumnIndex("_display_name");     // Catch: Exception -> L22 Throwable -> L30
        if (r117 < 0) goto L29;
        r109 = r108.getString(r117);     // Catch: Exception -> L22 Throwable -> L30
        com.larksuite.framework.utils.d.a(r108);
        goto L36
    L30:
        th = th;
        r105 = r107;
    L32:
        com.larksuite.framework.utils.d.a(r105);
        throw th;
    L26:
        e = e;
        r108 = null;
    L24:
        th = th;
        goto L32
    L34:
        r109 = FileUtils.l(r103);
        goto L36
    }

    public static boolean e(Context r100, String r101) {
        String r102 = r100.getPackageName();
        if (r101 != null) goto L19;
        return false;
    L19:
        r101 = new PolarisFileWrapper(r101).getCanonicalPath();     // Catch: IOException -> L7
    L10:
        if (r101.contains("/data/data/") == true) goto L14;
        if (r101.contains("/data/user/") == true) goto L14;
        return false;
    L14:
        if (r101.contains(HTTP.URL_DEFAULT + r102 + HTTP.URL_DEFAULT) == false) goto L16;
    L17:
        return true;
    L16:
        if (r101.contains(HTTP.URL_DEFAULT + r102 + "-") == true) goto L17;
        return false;
    L7:
        e = move-exception;
        Log.e("UriUtils", "An exception occurred while getCanonicalPath," + e.getMessage());
        e.getMessage();
        goto L10
    }
}
