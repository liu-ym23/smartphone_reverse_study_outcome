package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SingleImageProxyBundle implements ImageProxyBundle {
    private final int mCaptureId;
    private final ImageProxy mImageProxy;

    public void close() {
        this.mImageProxy.close();
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    public List<Integer> getCaptureIds() {
        return Collections.singletonList(Integer.valueOf(this.mCaptureId));
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    public ListenableFuture<ImageProxy> getImageProxy(int r2) {
        if (r2 == this.mCaptureId) goto L7;
        return Futures.immediateFailedFuture(new IllegalArgumentException("Capture id does not exist in the bundle"));
    L7:
        return Futures.immediateFuture(this.mImageProxy);
    }

    public SingleImageProxyBundle(ImageProxy r2, String r3) {
        ImageInfo r0 = r2.getImageInfo();
        if (r0 == null) goto L11;
        Integer r4 = (Integer) r0.getTagBundle().getTag(r3);
        if (r4 == null) goto L9;
        this.mCaptureId = r4.intValue();
        this.mImageProxy = r2;
        return;
    L9:
        throw new IllegalArgumentException("ImageProxy has no associated tag");
    L11:
        throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
    }

    public SingleImageProxyBundle(ImageProxy r1, int r2) {
        this.mCaptureId = r2;
        this.mImageProxy = r1;
    }
}
