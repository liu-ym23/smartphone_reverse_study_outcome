package vt3;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wt3.d f557198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f557199b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f557200a = null;

        static {
            f557200a = new c();
        }
    }

    public c() {
        this.f557198a = new wt3.d();
    }

    public final synchronized void a(ut3.c r100) {
        monitor-enter(this);
        if (r100 != null) goto L21;
        monitor-exit(this);
        return;
    L21:
    L18:
        th = move-exception;
        throw th;
    L7:
        if (du3.a.o() == true) goto L13;
        if (r100.f551642g == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (r100.f551636a == false) goto L15;
        this.f557199b = r100.f551645j;     // Catch: Throwable -> L18
        this.f557198a.a(r100);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L15:
        this.f557198a.b();     // Catch: Throwable -> L18
        goto L16
    }
}
