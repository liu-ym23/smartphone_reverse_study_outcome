package tmc;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> {
    private T configValue;
    private int priority;

    public synchronized T value() {
        monitor-enter(this);
        T r100 = this.configValue;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private a() {
        this.priority = 0;
    }

    public a(T r100) {
        this.priority = 0;
        this.configValue = r100;
    }

    public synchronized void setConfig(T r100, int r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r101 >= this.priority) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.configValue = r100;     // Catch: Throwable -> L10
        this.priority = r101;     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
