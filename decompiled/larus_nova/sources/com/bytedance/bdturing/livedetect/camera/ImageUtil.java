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

/* JADX INFO: loaded from: classes14.dex */
public class ImageUtil {
    public static final int SCALE_TYPE_H = 1;
    public static final int SCALE_TYPE_V = 0;

    public ImageUtil() {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:16777259), block:B:20:0x002b */
    public static byte[] bitmapToRgbBytes(Bitmap r100) {
        ByteArrayOutputStream r101 = null;
        if (r100 != null) goto L44;
        byte[] r102 = null;
    L28:
        if (r101 == null) goto L34;
        r101.close();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        return r102;
    L44:
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L9 Exception -> L11
        r100.compress(Bitmap.CompressFormat.JPEG, 95, r103);     // Catch: Exception -> L7 Throwable -> L19
        r102 = r103.toByteArray();     // Catch: Exception -> L7 Throwable -> L19
        r101 = r103;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r103 == null) goto L46;
        r103.close();     // Catch: Exception -> L17
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L46:
        return null;
    L11:
        e = e;
        r103 = null;
    L9:
        th = th;
    L21:
        if (r101 != null) goto L42;
    L26:
        throw th;
    L42:
        r101.close();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r101 = r1;
        goto L21
    }

    public static ImageDataWrapper buildBitmap(f r100) {
        int r101 = r100.f558950e;
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return null;
    L11:
        return i420ToBitmap(r100);
    L9:
        return nv21ToBitmap(r100);
    }

    public static byte[] convertBitmapToRgbBytes(Bitmap r110) {
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        int r102 = r100 * r101;
        byte[] r103 = new byte[r102 * 3];
        int[] r111 = new int[r102];
        r110.getPixels(r111, 0, r100, 0, 0, r100, r101);
        int r112 = 0;
        int r104 = 0;
    L3:
        if (r112 >= r102) goto L5;
        int r105 = r111[r112];
        byte r106 = (byte) ((r105 >> 16) & 255);
        byte r107 = (byte) ((r105 >> 8) & 255);
        int r108 = r104 + 1;
        r103[r104] = r106;
        int r109 = r108 + 1;
        r103[r108] = r107;
        r103[r109] = (byte) (r105 & 255);
        r112 = r112 + 1;
        r104 = r109 + 1;
        goto L3
    L5:
        return r103;
    }

    private static ImageDataWrapper i420ToBitmap(f r100) {
        byte[] r101 = r100.f558946a;     // Catch: Exception -> L4
        int r102 = r100.f558947b;     // Catch: Exception -> L4
        int r103 = r100.f558948c;     // Catch: Exception -> L4
        return TuringYuv.I420ToBitmap(r101, new byte[(r102 * r103) * 4], r102, r103, r100.f558949d);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static ImageDataWrapper nv21ToBitmap(f r110) {
        Bitmap r100 = null;
        r100 = null;
        r100 = null;
        ByteArrayOutputStream r101 = null;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L11 Exception -> L13
        new YuvImage(r110.f558946a, 17, r110.f558947b, r110.f558948c, null).compressToJpeg(new Rect(0, 0, r110.f558947b, r110.f558948c), 95, r102);     // Catch: Exception -> L9 Throwable -> L26
        byte[] r103 = r102.toByteArray();     // Catch: Exception -> L9 Throwable -> L26
        r100 = BitmapFactory.decodeByteArray(r103, 0, r103.length);     // Catch: Exception -> L9 Throwable -> L26
        r102.close();     // Catch: Exception -> L7
    L39:
    L18:
        if (r100 == null) goto L24;
        if (r110 == null) goto L24;
        int r111 = r110.f558949d;
        if (r111 <= 0) goto L23;
        r100 = rotateBitmap(r100, r111);
    L23:
        r100 = scaleBitmap(r100, 0);
    L24:
        ImageDataWrapper r112 = new ImageDataWrapper();
        r112.bitmap = r100;
        return r112;
    L9:
        e = e;
    L15:
        e.printStackTrace();     // Catch: Throwable -> L26
        if (r102 == null) goto L18;
        r102.close();     // Catch: Exception -> L7
    L26:
        th = th;
        r101 = r102;
    L28:
        if (r101 != null) goto L36;
    L33:
        throw th;
    L36:
        r101.close();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L7:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = e;
        r102 = null;
    L11:
        th = th;
        goto L28
    }

    public static Bitmap rgbBytesToBitmap(byte[] r100) {
        if (r100 == null) goto L13;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r100.length <= 0) goto L14;
        return BitmapFactory.decodeByteArray(r100, 0, r100.length);
    L14:
        return null;
    L13:
        return null;
    }

    public static Bitmap rotateBitmap(Bitmap r100, int r101) {
        Matrix r102 = new Matrix();
        r102.postRotate(r101);
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, true);
    }

    public static void saveBitmap(Bitmap r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r102.exists() == true) goto L11;
        if (r100 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: Exception -> L12
        r100.compress(Bitmap.CompressFormat.JPEG, 95, r103);     // Catch: Exception -> L12
        r103.flush();     // Catch: Exception -> L12
        r103.close();     // Catch: Exception -> L12
        return;
    L18:
        return;
    }

    public static Bitmap scaleBitmap(Bitmap r100, int r101) {
        Matrix r102 = new Matrix();
        if (r101 != 0) goto L6;
        r102.setScale(-1.0f, 1.0f);
    L9:
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, true);
    L6:
        if (1 != r101) goto L9;
        r102.setScale(1.0f, -1.0f);
        goto L9
    }

    public static Bitmap RGBAToBitmap(byte[] r100, int r101, int r102) {
        Bitmap r103 = null;
        r103 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L5
        r103.copyPixelsFromBuffer(ByteBuffer.wrap(r100));     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r103;
    }

    public static Bitmap scaleBitmapCropCenter(Bitmap r100, int r101, int r102) {
        float r103 = r101;
        float r104 = r100.getWidth();
        float r105 = r102;
        float r106 = r100.getHeight();
        float r107 = Math.max(r103 / r104, r105 / r106);
        Bitmap r108 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        Canvas r109 = new Canvas(r108);
        Matrix r110 = new Matrix();
        r110.postTranslate((r103 - (r104 * r107)) / 2.0f, (r105 - (r106 * r107)) / 2.0f);
        r110.preScale(r107, r107);
        Paint r111 = new Paint();
        r111.setFilterBitmap(true);
        r111.setAntiAlias(true);
        r109.drawBitmap(r100, r110, r111);
        return r108;
    }
}
