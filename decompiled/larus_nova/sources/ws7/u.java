package ws7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.log.RecordService;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes22.dex */
public final class u {
    public static void a(ArrayList r110, PolarisFileWrapper r111, int r210, int r211, int r212) {
        ZipOutputStream r100 = new ZipOutputStream(new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r111)));
        int r101 = 0;
    L4:
        if (r101 >= r110.size()) goto L58;
        String r102 = "frame_" + r101 + ".jpeg";
        ByteBuffer r103 = (ByteBuffer) ListProtector.get(r110, r101);
        if (r103 == null) goto L54;
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        new YuvImage(r103.array(), 17, r210, r211, null).compressToJpeg(new Rect(0, 0, r210, r211), 60, r104);     // Catch: Throwable -> L36
        byte[] r105 = r104.toByteArray();     // Catch: Throwable -> L36
        BitmapFactory.Options r106 = new BitmapFactory.Options();     // Catch: Throwable -> L36
        r106.inJustDecodeBounds = true;     // Catch: Throwable -> L36
        BitmapFactory.decodeByteArray(r105, 0, r105.length, r106);     // Catch: Throwable -> L36
        int r112 = r106.outWidth;     // Catch: Throwable -> L36
        int r113 = r112 / 2;     // Catch: Throwable -> L36
        int r114 = r106.outHeight;     // Catch: Throwable -> L36
        int r115 = r114 / 2;     // Catch: Throwable -> L36
        if (r114 > r115) goto L16;
        if (r112 > r113) goto L16;
        int r116 = 1;
    L23:
        r106.inSampleSize = r116;     // Catch: Throwable -> L36
        r106.inJustDecodeBounds = false;     // Catch: Throwable -> L36
        r106.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L36
        r106.inPurgeable = true;     // Catch: Throwable -> L36
        r106.inInputShareable = true;     // Catch: Throwable -> L36
        Bitmap r107 = BitmapFactory.decodeByteArray(r105, 0, r105.length, r106);     // Catch: Throwable -> L36
        if (r107 == null) goto L35;
        Matrix r108 = new Matrix();     // Catch: Throwable -> L36
        r108.setRotate(r212);     // Catch: Throwable -> L33
        Bitmap r109 = Bitmap.createBitmap(r107, 0, 0, r107.getWidth(), r107.getHeight(), r108, false);     // Catch: Throwable -> L33
        if (r107 != r109) goto L30;
    L32:
        i.j(r104);
    L43:
        if (r109 == null) goto L54;
        if (r109.isRecycled() == true) goto L54;
        byte[] r117 = i.c(r109);
        if (r117 == null) goto L52;
        if (r117.length <= 0) goto L52;
        r100.putNextEntry(new ZipEntry(r102));
        r100.write(r117, 0, r117.length);
        r100.flush();
        r100.closeEntry();
    L52:
        if (r109.isRecycled() == true) goto L54;
        r109.recycle();     // Catch: Throwable -> L60
        goto L54
    L30:
        if (r107.isRecycled() == true) goto L32;
        r107.recycle();     // Catch: Throwable -> L33
    L33:
        th = th;
    L61:
        RecordService.getInstance().recordException(th);     // Catch: Throwable -> L55
        i.j(r104);
    L42:
        r109 = null;
    L55:
        th = move-exception;
        i.j(r104);
        throw th;
    L35:
        i.j(r104);
    L16:
        int r118 = r114 / 2;     // Catch: Throwable -> L36
        int r119 = r112 / 2;     // Catch: Throwable -> L36
        r116 = 1;
    L18:
        if ((r118 / r116) < r115) goto L23;
        if ((r119 / r116) < r113) goto L23;
        r116 = r116 * 2;     // Catch: Throwable -> L36
    L36:
        th = th;
    L38:
        th = th;
    L54:
        r101 = r101 + 1;
        goto L4
    L58:
        r100.close();
    }
}
