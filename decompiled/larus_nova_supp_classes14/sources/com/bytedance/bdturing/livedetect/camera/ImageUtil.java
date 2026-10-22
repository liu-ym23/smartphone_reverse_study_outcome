package com.bytedance.bdturing.livedetect.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.text.TextUtils;
import com.bytedance.bdturing.livedetect.yuv.TuringYuv;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import wb4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ImageUtil {
    public static final int SCALE_TYPE_H = 1;
    public static final int SCALE_TYPE_V = 0;

    public ImageUtil() {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:16777259), block:B:20:0x002b */
    public static byte[] bitmapToRgbBytes(Bitmap r4) {
        ByteArrayOutputStream r0 = null;
        if (r4 != null) goto L44;
        byte[] r5 = null;
    L28:
        if (r0 == null) goto L34;
        r0.close();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        return r5;
    L44:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L9 Exception -> L11
        r4.compress(Bitmap.CompressFormat.JPEG, 95, r1);     // Catch: Exception -> L7 Throwable -> L19
        r5 = r1.toByteArray();     // Catch: Exception -> L7 Throwable -> L19
        r0 = r1;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r1 == null) goto L46;
        r1.close();     // Catch: Exception -> L17
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L46:
        return null;
    L11:
        e = e;
        r1 = null;
    L9:
        th = th;
    L21:
        if (r0 != null) goto L42;
    L26:
        throw th;
    L42:
        r0.close();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r0 = r1;
        goto L21
    }

    public static ImageDataWrapper buildBitmap(f r2) {
        int r0 = r2.e;
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L11;
        return null;
    L11:
        return i420ToBitmap(r2);
    L9:
        return nv21ToBitmap(r2);
    }

    public static byte[] convertBitmapToRgbBytes(Bitmap r11) {
        int r6 = r11.getWidth();
        int r7 = r11.getHeight();
        int r8 = r6 * r7;
        byte[] r9 = new byte[r8 * 3];
        int[] r10 = new int[r8];
        r11.getPixels(r10, 0, r6, 0, 0, r6, r7);
        int r12 = 0;
        int r0 = 0;
    L3:
        if (r12 >= r8) goto L5;
        int r1 = r10[r12];
        byte r2 = (byte) ((r1 >> 16) & 255);
        byte r3 = (byte) ((r1 >> 8) & 255);
        int r4 = r0 + 1;
        r9[r0] = r2;
        int r5 = r4 + 1;
        r9[r4] = r3;
        r9[r5] = (byte) (r1 & 255);
        r12 = r12 + 1;
        r0 = r5 + 1;
        goto L3
    L5:
        return r9;
    }

    private static ImageDataWrapper i420ToBitmap(f r4) {
        byte[] r0 = r4.a;     // Catch: Exception -> L4
        int r1 = r4.b;     // Catch: Exception -> L4
        int r2 = r4.c;     // Catch: Exception -> L4
        return TuringYuv.I420ToBitmap(r0, new byte[(r1 * r2) * 4], r1, r2, r4.d);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static ImageDataWrapper nv21ToBitmap(f r10) {
        Bitmap r1 = null;
        r1 = null;
        r1 = null;
        ByteArrayOutputStream r2 = null;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L11 Exception -> L13
        new YuvImage(r10.a, 17, r10.b, r10.c, null).compressToJpeg(new Rect(0, 0, r10.b, r10.c), 95, r3);     // Catch: Exception -> L9 Throwable -> L26
        byte[] r4 = r3.toByteArray();     // Catch: Exception -> L9 Throwable -> L26
        r1 = BitmapFactory.decodeByteArray(r4, 0, r4.length);     // Catch: Exception -> L9 Throwable -> L26
        r3.close();     // Catch: Exception -> L7
    L39:
    L18:
        if (r1 == null) goto L24;
        if (r10 == null) goto L24;
        int r11 = r10.d;
        if (r11 <= 0) goto L23;
        r1 = rotateBitmap(r1, r11);
    L23:
        r1 = scaleBitmap(r1, 0);
    L24:
        ImageDataWrapper r12 = new ImageDataWrapper();
        r12.bitmap = r1;
        return r12;
    L9:
        e = e;
    L15:
        e.printStackTrace();     // Catch: Throwable -> L26
        if (r3 == null) goto L18;
        r3.close();     // Catch: Exception -> L7
    L26:
        th = th;
        r2 = r3;
    L28:
        if (r2 != null) goto L36;
    L33:
        throw th;
    L36:
        r2.close();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L7:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = e;
        r3 = null;
    L11:
        th = th;
        goto L28
    }

    public static Bitmap rgbBytesToBitmap(byte[] r3) {
        if (r3 == null) goto L13;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r3.length <= 0) goto L14;
        return BitmapFactory.decodeByteArray(r3, 0, r3.length);
    L14:
        return null;
    L13:
        return null;
    }

    public static Bitmap rotateBitmap(Bitmap r7, int r8) {
        Matrix r5 = new Matrix();
        r5.postRotate(r8);
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r5, true);
    }

    public static void saveBitmap(Bitmap r2, String r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r0.exists() == true) goto L11;
        if (r2 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        PolarisFileOutputStreamWrapper r4 = new PolarisFileOutputStreamWrapper(r0);     // Catch: Exception -> L12
        r2.compress(Bitmap.CompressFormat.JPEG, 95, r4);     // Catch: Exception -> L12
        r4.flush();     // Catch: Exception -> L12
        r4.close();     // Catch: Exception -> L12
        return;
    L18:
        return;
    }

    public static Bitmap scaleBitmap(Bitmap r7, int r8) {
        Matrix r5 = new Matrix();
        if (r8 != 0) goto L6;
        r5.setScale(-1.0f, 1.0f);
    L9:
        return Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r5, true);
    L6:
        if (1 != r8) goto L9;
        r5.setScale(1.0f, -1.0f);
        goto L9
    }

    public static Bitmap RGBAToBitmap(byte[] r2, int r3, int r4) {
        Bitmap r0 = null;
        r0 = Bitmap.createBitmap(r3, r4, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L5
        r0.copyPixelsFromBuffer(ByteBuffer.wrap(r2));     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r0;
    }

    public static Bitmap scaleBitmapCropCenter(Bitmap r6, int r7, int r8) {
        float r2 = r7;
        float r0 = r6.getWidth();
        float r4 = r8;
        float r1 = r6.getHeight();
        float r3 = Math.max(r2 / r0, r4 / r1);
        Bitmap r9 = Bitmap.createBitmap(r7, r8, Bitmap.Config.ARGB_8888);
        Canvas r10 = new Canvas(r9);
        Matrix r5 = new Matrix();
        r5.postTranslate((r2 - (r0 * r3)) / 2.0f, (r4 - (r1 * r3)) / 2.0f);
        r5.preScale(r3, r3);
        Paint r11 = new Paint();
        r11.setFilterBitmap(true);
        r11.setAntiAlias(true);
        r10.drawBitmap(r6, r5, r11);
        return r9;
    }
}
