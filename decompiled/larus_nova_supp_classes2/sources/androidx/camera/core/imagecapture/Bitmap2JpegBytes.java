package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class Bitmap2JpegBytes implements Operation<In, Packet<byte[]>> {

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static boolean hasGainmap(Bitmap r0) {
            return r0.hasGainmap();
        }
    }

    public static abstract class In {
        public In() {
        }

        public abstract int getJpegQuality();

        public abstract Packet<Bitmap> getPacket();

        public static In of(Packet<Bitmap> r1, int r2) {
            return new AutoValue_Bitmap2JpegBytes_In(r1, r2);
        }
    }

    public Bitmap2JpegBytes() {
    }

    private static int getOutputFormat(Bitmap r2) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return 256;
    L5:
        if (Api34Impl.hasGainmap(r2) == false) goto L10;
        return 4101;
    L10:
        return 256;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<byte[]> apply2(In r13) throws ImageCaptureException {
        Packet<Bitmap> r0 = r13.getPacket();
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        r0.getData().compress(Bitmap.CompressFormat.JPEG, r13.getJpegQuality(), r1);
        byte[] r4 = r1.toByteArray();
        Exif r5 = r0.getExif();
        Objects.requireNonNull(r5);
        return Packet.of(r4, r5, getOutputFormat(r0.getData()), r0.getSize(), r0.getCropRect(), r0.getRotationDegrees(), r0.getSensorToBufferTransform(), r0.getCameraCaptureResult());
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<byte[]> apply(In r1) throws ImageCaptureException {
        return apply2(r1);
    }
}
