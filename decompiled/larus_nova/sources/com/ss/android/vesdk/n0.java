package com.ss.android.vesdk;

import android.media.Image;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public final class n0 {
    public static void a(ByteBuffer r100, String r101) {
        if (r100 != null) goto L6;
        VELogUtil.e("VEImageUtils", "Input null buffer, failed to save yuv!");
        return;
    L6:
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L18 IOException -> L20
        byte[] r104 = new byte[r100.remaining()];     // Catch: Throwable -> L14 IOException -> L16
        r100.get(r104);     // Catch: Throwable -> L14 IOException -> L16
        r103.write(r104);     // Catch: Throwable -> L14 IOException -> L16
        r100.rewind();     // Catch: Throwable -> L14 IOException -> L16
        r103.close();     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L16:
        e = e;
        r102 = r103;
    L21:
        VELogUtil.e("VEImageUtils", "save yuv failed!");     // Catch: Throwable -> L18
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r102 == null) goto L47;
        r102.close();     // Catch: IOException -> L25
        return;
    L25:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L47:
        return;
    L14:
        th = th;
    L29:
        if (r103 != null) goto L39;
    L34:
        throw th;
    L39:
        r103.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
    L18:
        th = th;
        r103 = r102;
    L20:
        e = e;
        goto L21
    }

    public static void b(byte[] r100, String r101) {
        if (r100 != null) goto L6;
        VELogUtil.e("VEImageUtils", "Input null byte data, failed to save yuv!");
        return;
    L6:
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L18 IOException -> L20
        r103.write(r100);     // Catch: Throwable -> L14 IOException -> L16
        r103.close();     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L16:
        e = e;
        r102 = r103;
    L21:
        VELogUtil.e("VEImageUtils", "save yuv failed!");     // Catch: Throwable -> L18
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r102 == null) goto L47;
        r102.close();     // Catch: IOException -> L25
        return;
    L25:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L47:
        return;
    L14:
        th = th;
    L29:
        if (r103 != null) goto L37;
    L34:
        throw th;
    L37:
        r103.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
    L20:
        e = e;
    L18:
        th = th;
        r103 = r102;
        goto L29
    }

    public static void c(Image.Plane[] r100, int r101, int r102, String r103) {
        if (r100 != null) goto L6;
        VELogUtil.e("VEImageUtils", "Input null plane, failed to save yuv!");
        return;
    L6:
        int r104 = 0;
        if (r100[0] == null) goto L39;
        ByteBuffer r105 = ByteBuffer.allocate(16);
        r105.putInt(r101).putInt(r102).putInt(r100[0].getPixelStride()).putInt(r100[0].getRowStride());
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L23 IOException -> L25
        r107.write(r105.array());     // Catch: Throwable -> L19 IOException -> L21
        int r108 = r100.length;     // Catch: Throwable -> L19 IOException -> L21
    L11:
        if (r104 >= r108) goto L45;
        ByteBuffer r109 = r100[r104].getBuffer();     // Catch: Throwable -> L19 IOException -> L21
        byte[] r110 = new byte[r109.remaining()];     // Catch: Throwable -> L19 IOException -> L21
        r109.get(r110);     // Catch: Throwable -> L19 IOException -> L21
        r107.write(r110);     // Catch: Throwable -> L19 IOException -> L21
        r109.rewind();     // Catch: Throwable -> L19 IOException -> L21
        r104 = r104 + 1;
        goto L11
    L45:
        r107.close();     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L21:
        e = e;
        r106 = r107;
    L26:
        VELogUtil.e("VEImageUtils", "save yuv failed!");     // Catch: Throwable -> L23
        e.printStackTrace();     // Catch: Throwable -> L23
        if (r106 == null) goto L53;
        r106.close();     // Catch: IOException -> L30
        return;
    L30:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L53:
        return;
    L19:
        th = th;
        r106 = r107;
    L33:
        if (r106 != null) goto L48;
    L38:
        throw th;
    L48:
        r106.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
    L23:
        th = th;
    L25:
        e = e;
        goto L26
    L39:
        VELogUtil.e("VEImageUtils", "save yuv failed, plane is null");
    }
}
