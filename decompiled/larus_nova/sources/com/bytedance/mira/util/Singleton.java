package com.bytedance.mira.util;

/* JADX INFO: loaded from: classes21.dex */
public abstract class Singleton<T> {
    private T mInstance;

    public Singleton() {
    }

    public abstract T create();

    public final T get() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mInstance != null) goto L6;
        this.mInstance = create();     // Catch: Throwable -> L9
    L6:
        T r100 = this.mInstance;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r100;
    }
}
