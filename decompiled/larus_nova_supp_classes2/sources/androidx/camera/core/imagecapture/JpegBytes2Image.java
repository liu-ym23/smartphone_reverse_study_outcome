package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class JpegBytes2Image implements Operation<Packet<byte[]>, Packet<ImageProxy>> {
    private static final int MAX_IMAGES = 2;

    public JpegBytes2Image() {
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public Packet<ImageProxy> apply2(Packet<byte[]> r9) throws ImageCaptureException {
        SafeCloseImageReaderProxy r0 = new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r9.getSize().getWidth(), r9.getSize().getHeight(), 256, 2));
        ImageProxy r1 = ImageProcessingUtil.convertJpegBytesToImage(r0, r9.getData());
        r0.safeClose();
        Objects.requireNonNull(r1);
        Exif r3 = r9.getExif();
        Objects.requireNonNull(r3);
        return Packet.of(r1, r3, r9.getCropRect(), r9.getRotationDegrees(), r9.getSensorToBufferTransform(), r9.getCameraCaptureResult());
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ Packet<ImageProxy> apply(Packet<byte[]> r1) throws ImageCaptureException {
        return apply2(r1);
    }
}
