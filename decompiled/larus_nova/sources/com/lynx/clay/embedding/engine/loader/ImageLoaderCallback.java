package com.lynx.clay.embedding.engine.loader;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes32.dex */
public class ImageLoaderCallback {
    private long mPtr;

    private native void nativeDestroyCallback(long r100);

    private native void nativeOnFailed(long r100, String r101);

    private native void nativeOnSucceeded(long r100, CloseableReference<CloseableImage> r101);

    public void destroy() {
        long r100 = this.mPtr;
        if (r100 == 0) goto L6;
        nativeDestroyCallback(r100);
        this.mPtr = 0;
        return;
    }

    public void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    public ImageLoaderCallback(long r100) {
        this.mPtr = r100;
    }

    public void onFailed(String r100) {
        nativeOnFailed(this.mPtr, r100);
    }

    public void onSucceeded(CloseableReference<CloseableImage> r100) {
        nativeOnSucceeded(this.mPtr, r100);
    }
}
