package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class JpegImage2Result implements Operation<Packet<ImageProxy>, ImageProxy> {
    public JpegImage2Result() {
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ImageProxy apply2(Packet<ImageProxy> r7) throws ImageCaptureException {
        ImageProxy r0 = r7.getData();
        ImageInfo r1 = ImmutableImageInfo.create(r0.getImageInfo().getTagBundle(), r0.getImageInfo().getTimestamp(), r7.getRotationDegrees(), r7.getSensorToBufferTransform());
        SettableImageProxy r2 = new SettableImageProxy(r0, r7.getSize(), r1);
        r2.setCropRect(r7.getCropRect());
        return r2;
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ ImageProxy apply(Packet<ImageProxy> r1) throws ImageCaptureException {
        return apply2(r1);
    }
}
