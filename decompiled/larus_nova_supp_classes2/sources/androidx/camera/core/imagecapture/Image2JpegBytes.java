package androidx.camera.core.imagecapture;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.workaround.JpegMetadataCorrector;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.ByteArrayInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class Image2JpegBytes implements Operation<In, Packet<byte[]>> {
    private final JpegMetadataCorrector mJpegMetadataCorrector;

    public static abstract class In {
        public In() {
        }

        public abstract int getJpegQuality();

        public abstract Packet<ImageProxy> getPacket();

        public static In of(Packet<ImageProxy> r1, int r2) {
            return new AutoValue_Image2JpegBytes_In(r1, r2);
        }
    }

    public Image2JpegBytes(Quirks r2) {
        this.mJpegMetadataCorrector = new JpegMetadataCorrector(r2);
    }

    private static Exif extractExif(byte[] r3) throws ImageCaptureException {
        return Exif.createFromInputStream(new ByteArrayInputStream(r3));
    L4:
        e = move-exception;
        throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e);
    }

    private Packet<byte[]> processYuvImage(In r13) throws ImageCaptureException {
        Packet<ImageProxy> r0 = r13.getPacket();
        ImageProxy r1 = r0.getData();
        Rect r2 = r0.getCropRect();
        byte[] r4 = ImageUtil.yuvImageToJpegByteArray(r1, r2, r13.getJpegQuality(), r0.getRotationDegrees());     // Catch: ImageUtil.CodecFailedException -> L6
        return Packet.of(r4, extractExif(r4), 256, new Size(r2.width(), r2.height()), new Rect(0, 0, r2.width(), r2.height()), r0.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(r0.getSensorToBufferTransform(), r2), r0.getCameraCaptureResult());
    L6:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to encode the image to JPEG.", e);
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<byte[]> apply2(In r5) throws ImageCaptureException {
        int r1 = r5.getPacket().getFormat();     // Catch: Throwable -> L17
        if (r1 != 35) goto L6;
        Packet<byte[]> r0 = processYuvImage(r5);     // Catch: Throwable -> L17
    L13:
        r5.getPacket().getData().close();
        return r0;
    L6:
        if (r1 != 256) goto L8;
    L12:
        r0 = processJpegImage(r5, r1);     // Catch: Throwable -> L17
        goto L13
    L8:
        if (r1 == 4101) goto L12;
        throw new IllegalArgumentException("Unexpected format: " + r1);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r5.getPacket().getData().close();
        throw th;
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<byte[]> apply(In r1) throws ImageCaptureException {
        return apply2(r1);
    }

    private Packet<byte[]> processJpegImage(In r11, int r12) {
        Packet<ImageProxy> r13 = r11.getPacket();
        byte[] r2 = this.mJpegMetadataCorrector.jpegImageToJpegByteArray(r13.getData());
        Exif r3 = r13.getExif();
        Objects.requireNonNull(r3);
        return Packet.of(r2, r3, r12, r13.getSize(), r13.getCropRect(), r13.getRotationDegrees(), r13.getSensorToBufferTransform(), r13.getCameraCaptureResult());
    }
}
