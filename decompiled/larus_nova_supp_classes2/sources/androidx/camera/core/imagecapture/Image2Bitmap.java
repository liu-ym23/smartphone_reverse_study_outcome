package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Image2Bitmap implements Operation<Packet<ImageProxy>, Bitmap> {
    public Image2Bitmap() {
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Bitmap apply2(Packet<ImageProxy> r11) throws ImageCaptureException {
        SafeCloseImageReaderProxy r4 = null;
    L35:
        e = e;
    L37:
        if (r11.getFormat() != 35) goto L39;
        String r12 = "YUV";
    L41:
        throw new ImageCaptureException(0, "Can't convert " + r12 + " to bitmap", e);     // Catch: Throwable -> L33
    L39:
        r12 = "JPEG";
        goto L41
    L4:
        if (r11.getFormat() != 35) goto L26;
        ImageProxy r1 = r11.getData();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        if ((r11.getRotationDegrees() % 180) == 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        int r7 = r1.getHeight();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
    L12:
        if (r5 == false) goto L14;
        int r6 = r1.getWidth();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
    L15:
        SafeCloseImageReaderProxy r8 = new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r7, r6, 1, 2));     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        ImageProxy r9 = ImageProcessingUtil.convertYUVToRGB(r1, r8, ByteBuffer.allocateDirect((r1.getWidth() * r1.getHeight()) * 4), r11.getRotationDegrees(), false);     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        r1.close();     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        if (r9 == null) goto L20;
        Bitmap r2 = ImageUtil.createBitmapFromImageProxy(r9);     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        r9.close();     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
        r4 = r8;
    L28:
        if (r4 == null) goto L30;
        r4.close();
    L30:
        return r2;
    L20:
        throw new ImageCaptureException(0, "Can't covert YUV to RGB", null);     // Catch: Throwable -> L21 UnsupportedOperationException -> L23
    L23:
        e = e;
    L21:
        th = th;
        r4 = r8;
    L42:
        if (r4 == null) goto L44;
        r4.close();
    L44:
        throw th;
    L14:
        r6 = r1.getHeight();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        goto L15
    L11:
        r7 = r1.getWidth();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        goto L12
    L8:
        r5 = false;
        goto L9
    L26:
        if (r11.getFormat() != 256) goto L32;
        ImageProxy r3 = r11.getData();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        Bitmap r10 = ImageUtil.createBitmapFromImageProxy(r3);     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        r3.close();     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        r2 = ImageUtil.rotateBitmap(r10, r11.getRotationDegrees());     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
        goto L28
    L32:
        throw new IllegalArgumentException("Invalid postview image format : " + r11.getFormat());     // Catch: Throwable -> L33 UnsupportedOperationException -> L35
    L33:
        th = th;
        goto L42
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Bitmap apply(Packet<ImageProxy> r1) throws ImageCaptureException {
        return apply2(r1);
    }
}
