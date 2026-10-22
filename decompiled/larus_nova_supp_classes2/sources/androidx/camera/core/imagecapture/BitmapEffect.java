package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.ImageProcessorRequest;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BitmapEffect implements Operation<Packet<Bitmap>, Packet<Bitmap>> {
    private final InternalImageProcessor mProcessor;

    public BitmapEffect(InternalImageProcessor r1) {
        this.mProcessor = r1;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<Bitmap> apply2(Packet<Bitmap> r10) throws ImageCaptureException {
        ImageProxy r0 = this.mProcessor.safeProcess(new ImageProcessorRequest(new RgbaImageProxy(r10), 1)).getOutputImage();
        Objects.requireNonNull(r0);
        Bitmap r3 = ImageUtil.createBitmapFromPlane(r0.getPlanes(), r0.getWidth(), r0.getHeight());
        Exif r4 = r10.getExif();
        Objects.requireNonNull(r4);
        return Packet.of(r3, r4, r10.getCropRect(), r10.getRotationDegrees(), r10.getSensorToBufferTransform(), r10.getCameraCaptureResult());
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<Bitmap> apply(Packet<Bitmap> r1) throws ImageCaptureException {
        return apply2(r1);
    }
}
