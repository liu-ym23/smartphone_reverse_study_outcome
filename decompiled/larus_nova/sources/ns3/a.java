package ns3;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f520285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ct3.a.C5583a f520286b;

    /* JADX INFO: renamed from: ns3.a$a, reason: collision with other inner class name */
    public static final class C6968a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f520287a = null;

        static {
            f520287a = new a();
        }
    }

    public final synchronized c a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f520285a != null) goto L6;
        this.f520285a = new c(false, false, false);     // Catch: Throwable -> L9
    L6:
        c r100 = this.f520285a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public a() {
    }

    public final synchronized void b(c r100) {
        monitor-enter(this);
        this.f520285a = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
