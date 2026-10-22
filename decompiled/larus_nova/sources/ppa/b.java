package ppa;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.tasm.behavior.c f530237a;

    public b() {
        if (c.f530238c == null) goto L5;
    L14:
        this.f530237a = new com.lynx.tasm.behavior.c(c.f530238c.a());
        return;
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.f530238c != null) goto L9;
        c.f530238c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }
}
