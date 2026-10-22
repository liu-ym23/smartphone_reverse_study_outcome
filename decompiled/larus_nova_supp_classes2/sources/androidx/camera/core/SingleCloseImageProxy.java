package androidx.camera.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class SingleCloseImageProxy extends ForwardingImageProxy {
    private final AtomicBoolean mClosed;

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        if (this.mClosed.getAndSet(true) == true) goto L6;
        super.close();
        return;
    }

    public SingleCloseImageProxy(ImageProxy r2) {
        super(r2);
        this.mClosed = new AtomicBoolean(false);
    }
}
