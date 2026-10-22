package onb;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements c {
    @Override // onb.c
    public final void destroy() {
    }

    public l() {
    }

    @Override // onb.c
    public final void submit(Runnable r100) {
        qnb.b.a().a().execute(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        rnb.c.f538745a.e("JSDispatcher", th);
    }
}
