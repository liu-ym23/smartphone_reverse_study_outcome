package com.bytedance.push.utils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k<T> {
    private volatile T mInstance;

    public k() {
    }

    public abstract T create(Object... r100);

    public final void resetInstance() {
        this.mInstance = null;
    }

    public final T get(Object... r100) {
        if (this.mInstance != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mInstance != null) goto L8;
        this.mInstance = create(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mInstance;
    }
}
