package com.bytedance.common.utility;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import f06.b;
import f06.d;
import g06.a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public final class BitmapUtils {
    public static Bitmap decodeBitmap(File r100) {
        PolarisFileInputStreamWrapper r101 = null;
        if (r100.exists() == true) goto L40;
        return null;
    L40:
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L14 Exception -> L16
        Bitmap r103 = BitmapFactory.decodeStream(r102);     // Catch: Exception -> L12 Throwable -> L24
        r102.close();     // Catch: Exception -> L9
    L11:
        return r103;
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = e;
    L18:
        e.printStackTrace();     // Catch: Throwable -> L24
        r102.close();     // Catch: Exception -> L21
    L23:
        return null;
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        th = th;
        r101 = r102;
    L38:
        r101.close();     // Catch: Exception -> L28
    L30:
        throw th;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L16:
        e = e;
        r102 = null;
    L14:
        th = th;
        goto L38
    }

    public static Bitmap getBitmapFromSD(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L10;
        return null;
    L10:
        return decodeBitmap(r101);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static int readPictureDegree(String r100) {
        int r101 = com_bytedance_common_utility_BitmapUtils_android_media_ExifInterface_getAttributeInt(new ExifInterface(r100), androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);     // Catch: IOException -> L14
        if (r101 == 3) goto L21;
        if (r101 == 6) goto L20;
        if (r101 == 8) goto L19;
        return 0;
    L19:
        return 270;
    L20:
        return 90;
    L21:
        return 180;
    L14:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static Bitmap decodeBitmap(File r100, int r101) {
        return decodeBitmap(r100, r101, false);
    }

    public static Bitmap rotateBitmap(Bitmap r100, int r101) {
        if (r100 == null) goto L5;
        Matrix r102 = new Matrix();
        r102.postRotate(r101);
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, true);
    L5:
        return r100;
    }

    private static int com_bytedance_common_utility_BitmapUtils_android_media_ExifInterface_getAttributeInt(ExifInterface r110, String r111, int r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210)};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
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
        d r107 = r106.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.getAttributeInt(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Bitmap decodeBitmap(File r100, int r101, boolean r102) {
        Bitmap r103 = null;
        BitmapFactory.Options r104 = new BitmapFactory.Options();     // Catch: Exception -> L24
        r104.inJustDecodeBounds = true;     // Catch: Exception -> L24
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L24
        BitmapFactory.decodeStream(r105, null, r104);     // Catch: Exception -> L24
        r105.close();     // Catch: Exception -> L24
        if (r104.outWidth > 0) goto L6;
    L22:
        r100.delete();     // Catch: Exception -> L24
        return null;
    L6:
        if (r104.outHeight <= 0) goto L22;
        int r106 = 1;
    L9:
        int r107 = r104.outWidth;     // Catch: Exception -> L24
        if (r107 < (r101 * 2)) goto L15;
        int r108 = r104.outHeight;     // Catch: Exception -> L24
        if (r108 < 4000) goto L15;
        r104.outWidth = r107 / 2;     // Catch: Exception -> L24
        r104.outHeight = r108 / 2;     // Catch: Exception -> L24
        r106 = r106 * 2;     // Catch: Exception -> L24
    L15:
        BitmapFactory.Options r109 = new BitmapFactory.Options();     // Catch: Exception -> L24
        r109.inSampleSize = r106;     // Catch: Exception -> L24
        r109.inPurgeable = true;     // Catch: Exception -> L24
        if (r102 == false) goto L18;
        Bitmap.Config r110 = Bitmap.Config.ARGB_8888;     // Catch: Exception -> L24
    L19:
        r109.inPreferredConfig = r110;     // Catch: Exception -> L24
        PolarisFileInputStreamWrapper r111 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L24
        r103 = BitmapFactory.decodeStream(r111, null, r109);     // Catch: Exception -> L24
        r111.close();     // Catch: Exception -> L24
        if (r103 != null) goto L26;
        r100.delete();     // Catch: Exception -> L24
    L26:
        return r103;
    L18:
        r110 = Bitmap.Config.RGB_565;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static Bitmap getBitmapFromSD(String r100, int r101, int r102) {
        return getBitmapFromSD(r100, r101, r102, -1, null);
    }

    public static boolean saveBitmapToSD(Bitmap r100, String r101, String r102) {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L41;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L7;
        r103.mkdirs();
    L7:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103 + HTTP.URL_DEFAULT + r102);
        if (r104.exists() == false) goto L42;
    L14:
        PolarisFileOutputStreamWrapper r105 = null;
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L27 Exception -> L29
        r100.compress(Bitmap.CompressFormat.PNG, 100, r106);     // Catch: Throwable -> L23 Exception -> L25
        r106.flush();     // Catch: Throwable -> L23 Exception -> L25
        r106.close();     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
        return true;
    L25:
        e = e;
        r105 = r106;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L27
        r105.close();     // Catch: Exception -> L33
    L35:
        return false;
    L33:
        e = move-exception;
        e.printStackTrace();
    L23:
        th = th;
        r105 = r106;
    L50:
        r105.close();     // Catch: Exception -> L38
    L40:
        throw th;
    L38:
        e = move-exception;
        e.printStackTrace();
    L27:
        th = th;
    L29:
        e = e;
        goto L30
    L42:
        r104.createNewFile();     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L41:
        return false;
    }

    public static Bitmap decodeBitmap(byte[] r100, int r101, int r102) {
        if (r100 != null) goto L5;
    L20:
        return null;
    L5:
        if (r101 < 1) goto L20;
        if (r102 < 1) goto L20;
        BitmapFactory.Options r103 = new BitmapFactory.Options();     // Catch: Exception -> L18
        r103.inJustDecodeBounds = true;     // Catch: Exception -> L18
        BitmapFactory.decodeByteArray(r100, 0, r100.length, r103);     // Catch: Exception -> L18
        int r104 = r103.outWidth;     // Catch: Exception -> L18
        int r105 = r103.outHeight;     // Catch: Exception -> L18
        int r106 = 1;
    L10:
        if ((r104 / 2) < r101) goto L12;
    L16:
        r104 = r104 / 2;     // Catch: Exception -> L18
        r105 = r105 / 2;     // Catch: Exception -> L18
        r106 = r106 * 2;
        goto L10
    L12:
        if ((r105 / 2) >= r102) goto L16;
        BitmapFactory.Options r107 = new BitmapFactory.Options();     // Catch: Exception -> L18
        r107.inSampleSize = r106;     // Catch: Exception -> L18
        r107.inPurgeable = true;     // Catch: Exception -> L18
        r107.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Exception -> L18
        return BitmapFactory.decodeByteArray(r100, 0, r100.length, r107);
    L18:
        e = move-exception;
        Logger.d("BitmapUtils", "decode image error: " + e);
        goto L20
    }

    public static Bitmap decodeBitmap(File r100, int r101, int r102, Bitmap.Config r110) {
        PolarisFileInputStreamWrapper r103 = null;
        if (r100 == null) goto L38;
        if (r101 <= 0) goto L38;
        if (r102 <= 0) goto L38;
    L35:
        PolarisFileInputStreamWrapper r104 = null;
    L36:
        if (r104 == null) goto L38;
        r104.close();     // Catch: Exception -> L41
    L31:
        th = th;
    L32:
        if (r103 != null) goto L44;
    L34:
        throw th;
    L44:
        r103.close();     // Catch: Exception -> L39
        goto L34
    L8:
        if (r100.isFile() == true) goto L10;
        return null;
    L10:
        BitmapFactory.Options r105 = new BitmapFactory.Options();     // Catch: Throwable -> L31 Exception -> L35
        r105.inJustDecodeBounds = true;     // Catch: Throwable -> L31 Exception -> L35
        r104 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L31 Exception -> L35
        BitmapFactory.decodeStream(r104, null, r105);     // Catch: Throwable -> L29 Exception -> L40
        r104.close();     // Catch: Throwable -> L29 Exception -> L40
        int r106 = r105.outWidth;     // Catch: Throwable -> L29 Exception -> L40
        int r107 = r105.outHeight;     // Catch: Throwable -> L29 Exception -> L40
        int r108 = 1;
    L13:
        if ((r106 / 2) < r101) goto L15;
    L27:
        r106 = r106 / 2;     // Catch: Throwable -> L29 Exception -> L40
        r107 = r107 / 2;     // Catch: Throwable -> L29 Exception -> L40
        r108 = r108 * 2;
        goto L13
    L15:
        if ((r107 / 2) >= r102) goto L27;
        BitmapFactory.Options r109 = new BitmapFactory.Options();     // Catch: Throwable -> L29 Exception -> L40
        r109.inSampleSize = r108;     // Catch: Throwable -> L29 Exception -> L40
        r109.inPurgeable = true;     // Catch: Throwable -> L29 Exception -> L40
        if (r110 == null) goto L20;
        r109.inPreferredConfig = r110;     // Catch: Throwable -> L29 Exception -> L40
    L21:
        PolarisFileInputStreamWrapper r111 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L29 Exception -> L40
        Bitmap r112 = BitmapFactory.decodeStream(r111, null, r109);     // Catch: Throwable -> L24 Exception -> L26
        r111.close();     // Catch: Throwable -> L24 Exception -> L26
        return r112;
    L26:
        r104 = r111;
    L24:
        th = th;
        r103 = r111;
        goto L32
        goto L36
    L20:
        r109.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Throwable -> L29 Exception -> L40
    L29:
        th = th;
        r103 = r104;
        goto L32
    L38:
        return null;
    }

    public static Bitmap decodeBitmap(ContentResolver r100, Uri r101, int r102, int r103) {
        byte[] r104 = null;
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        if (r102 < 1) goto L22;
        if (r103 < 1) goto L22;
        InputStream r105 = ContentResolverWrapper.openInputStream(r100, r101);     // Catch: Exception -> L18
        if (r105 != null) goto L12;
        return null;
    L12:
        byte[] r106 = new byte[8192];     // Catch: Exception -> L18
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();     // Catch: Exception -> L18
    L13:
        int r108 = r105.read(r106);     // Catch: Exception -> L18
        if (r108 == (-1)) goto L16;
        r107.write(r106, 0, r108);     // Catch: Exception -> L18
        goto L13
    L16:
        r104 = r107.toByteArray();     // Catch: Exception -> L18
    L21:
        return decodeBitmap(r104, r102, r103);
    L18:
        e = move-exception;
        e.printStackTrace();
    L22:
        return null;
    }

    public static Bitmap getBitmapFromSD(String r100, int r101, int r102, int r103, Bitmap.Config r110) {
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100);     // Catch: Exception -> L14
        if (r104.isFile() == true) goto L6;
        return null;
    L6:
        if (r103 > 0) goto L8;
    L17:
        r104.setLastModified(System.currentTimeMillis());     // Catch: Exception -> L15
    L13:
        return decodeBitmap(r104, r101, r102, r110);
    L8:
        if (r104.length() <= r103) goto L17;
        r104.delete();     // Catch: Exception -> L14
        return null;
    L14:
        return null;
    }
}
