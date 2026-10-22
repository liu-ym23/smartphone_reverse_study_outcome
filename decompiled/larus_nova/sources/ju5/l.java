package ju5;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f500502a;

    public /* synthetic */ l(Runnable r100) {
        this.f500502a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f500502a.run();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("SecureTaskExecutor", e, false);
        iu5.d.c(e);
    }
}
