package wb4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public int a;
    public int b;
    public int c;
    public int d;

    public g() {
    }

    public final synchronized void a(int r1) {
        monitor-enter(this);
        this.b = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
