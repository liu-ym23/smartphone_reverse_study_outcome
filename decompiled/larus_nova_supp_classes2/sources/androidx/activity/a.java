package androidx.activity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f189a;

    public /* synthetic */ a(ComponentActivity r1) {
        this.f189a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f189a.invalidateMenu();
    }
}
