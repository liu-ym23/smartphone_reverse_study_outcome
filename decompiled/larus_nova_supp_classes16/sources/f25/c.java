package f25;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ f a;

    public /* synthetic */ c(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = this.a;
        r0.g.removeObserver(r0.i);
    }
}
