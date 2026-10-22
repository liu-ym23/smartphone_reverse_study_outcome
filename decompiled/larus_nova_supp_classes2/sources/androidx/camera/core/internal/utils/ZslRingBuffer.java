package androidx.camera.core.internal.utils;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ZslRingBuffer extends ArrayRingBuffer<ImageProxy> {
    private boolean isValidZslFrame(ImageInfo r4) {
        CameraCaptureResult r5 = CameraCaptureResults.retrieveCameraCaptureResult(r4);
        if (r5.getAfState() == CameraCaptureMetaData.AfState.LOCKED_FOCUSED) goto L8;
        if (r5.getAfState() == CameraCaptureMetaData.AfState.PASSIVE_FOCUSED) goto L8;
        return false;
    L8:
        if (r5.getAeState() == CameraCaptureMetaData.AeState.CONVERGED) goto L11;
        return false;
    L11:
        if (r5.getAwbState() == CameraCaptureMetaData.AwbState.CONVERGED) goto L13;
        return false;
    L13:
        return true;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void enqueue(ImageProxy r2) {
        if (isValidZslFrame(r2.getImageInfo()) == false) goto L5;
        super.enqueue(r2);
        return;
    L5:
        this.mOnRemoveCallback.onRemove((T) r2);
    }

    @Override // androidx.camera.core.internal.utils.ArrayRingBuffer, androidx.camera.core.internal.utils.RingBuffer
    public /* bridge */ /* synthetic */ void enqueue(Object r1) {
        enqueue((ImageProxy) r1);
    }

    public ZslRingBuffer(int r1, RingBuffer.OnRemoveCallback<ImageProxy> r2) {
        super(r1, r2);
    }
}
