package f25;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f475146a;

    public /* synthetic */ c(f r100) {
        this.f475146a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f475146a;
        r100.f475156g.removeObserver(r100.f475158i);
    }
}
