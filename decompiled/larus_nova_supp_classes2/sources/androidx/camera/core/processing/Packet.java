package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class Packet<T> {
    public Packet() {
    }

    public abstract CameraCaptureResult getCameraCaptureResult();

    public abstract Rect getCropRect();

    public abstract T getData();

    public abstract Exif getExif();

    public abstract int getFormat();

    public abstract int getRotationDegrees();

    public abstract Matrix getSensorToBufferTransform();

    public abstract Size getSize();

    public boolean hasCropping() {
        return TransformUtils.hasCropping(getCropRect(), getSize());
    }

    public static Packet<Bitmap> of(Bitmap r10, Exif r11, Rect r12, int r13, Matrix r14, CameraCaptureResult r15) {
        return new AutoValue_Packet(r10, r11, 42, new Size(r10.getWidth(), r10.getHeight()), r12, r13, r14, r15);
    }

    public static Packet<ImageProxy> of(ImageProxy r7, Exif r8, Rect r9, int r10, Matrix r11, CameraCaptureResult r12) {
        return of(r7, r8, new Size(r7.getWidth(), r7.getHeight()), r9, r10, r11, r12);
    }

    public static Packet<ImageProxy> of(ImageProxy r10, Exif r11, Size r12, Rect r13, int r14, Matrix r15, CameraCaptureResult r16) {
        if (ImageUtil.isJpegFormats(r10.getFormat()) == false) goto L7;
        Preconditions.checkNotNull(r11, "JPEG image must have Exif.");
    L7:
        return new AutoValue_Packet(r10, r11, r10.getFormat(), r12, r13, r14, r15, r16);
    }

    public static Packet<byte[]> of(byte[] r10, Exif r11, int r12, Size r13, Rect r14, int r15, Matrix r16, CameraCaptureResult r17) {
        return new AutoValue_Packet(r10, r11, r12, r13, r14, r15, r16, r17);
    }
}
