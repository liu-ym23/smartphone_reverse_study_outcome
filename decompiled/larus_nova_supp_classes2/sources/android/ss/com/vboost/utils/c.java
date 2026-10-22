package android.ss.com.vboost.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class c<T> {
    private volatile boolean hasInitialized;
    private volatile boolean hasSetInitialValue;
    private volatile T value;

    public c() {
        this.hasInitialized = false;
        this.hasSetInitialValue = false;
    }

    private T setInitialValue() {
        if (this.hasSetInitialValue == true) goto L5;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.hasSetInitialValue == false) goto L12;
        T r0 = this.value;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r0;
    L12:
        this.value = initialValue();     // Catch: Throwable -> L15
        this.hasSetInitialValue = true;     // Catch: Throwable -> L15
        T r1 = this.value;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r1;
    L5:
        return this.value;
    }

    public T get() {
        if (this.value == null) goto L7;
        return this.value;
    L7:
        return setInitialValue();
    }

    public boolean hasInitialized() {
        return this.hasInitialized;
    }

    public T initialValue() {
        throw null;
    }

    public void set(T r1) {
        this.value = r1;
        this.hasInitialized = true;
    }
}
