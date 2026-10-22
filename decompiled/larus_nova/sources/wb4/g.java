package wb4;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f558951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f558952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f558953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f558954d;

    public g() {
    }

    public final synchronized void a(int r100) {
        monitor-enter(this);
        this.f558952b = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
