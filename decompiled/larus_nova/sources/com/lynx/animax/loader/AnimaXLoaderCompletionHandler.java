package com.lynx.animax.loader;

import java.util.concurrent.atomic.AtomicBoolean;
import u4a.l;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXLoaderCompletionHandler implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f380302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f380303b;

    public native void nativeOnComplete(long r100, AnimaXLoaderResponseNativeAdapter r101);

    public AnimaXLoaderCompletionHandler(long r100) {
        this.f380303b = new AtomicBoolean(false);
        this.f380302a = r100;
    }

    public static AnimaXLoaderCompletionHandler createCompletionHandler(long r100) {
        return new AnimaXLoaderCompletionHandler(r100);
    }

    public final void a(AnimaXLoaderResponse<?> r100) {
        if (this.f380303b.getAndSet(true) == true) goto L6;
        nativeOnComplete(this.f380302a, new AnimaXLoaderResponseNativeAdapter(r100));
        return;
    }
}
