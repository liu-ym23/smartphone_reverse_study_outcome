package com.facebook.common.util;

/* JADX INFO: loaded from: classes3.dex */
public class Lazy<T> {
    private volatile boolean hasInitialized;
    private volatile boolean hasSetInitialValue;
    private volatile T value;

    public T initialValue() {
        return null;
    }

    private T setInitialValue() {
        if (this.hasSetInitialValue == true) goto L5;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.hasSetInitialValue == false) goto L12;
        T r100 = this.value;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r100;
    L12:
        this.value = initialValue();     // Catch: Throwable -> L18
        if (this.value == null) goto L15;
        this.hasSetInitialValue = true;     // Catch: Throwable -> L18
    L15:
        T r101 = this.value;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return r101;
    L5:
        return this.value;
    }

    public T get() {
        if (this.value == null) goto L7;
        return this.value;
    L7:
        return setInitialValue();
    }

    public Lazy() {
        this.hasInitialized = false;
        this.hasSetInitialValue = false;
    }

    public boolean hasInitialized() {
        return this.hasInitialized;
    }

    public void set(T r100) {
        this.value = r100;
        this.hasInitialized = true;
    }
}
