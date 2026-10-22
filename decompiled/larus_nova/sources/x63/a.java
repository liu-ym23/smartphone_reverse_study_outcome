package x63;

/* JADX INFO: loaded from: classes12.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f562600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f562601b;

    public abstract void a();

    public a() {
        this.f562601b = true;
    }

    public final void b(boolean r100) {
        if (r100 == true) goto L5;
        this.f562601b = false;
        return;
    L5:
        if (this.f562601b == false) goto L12;
        a r101 = this.f562600a;
        if (r101 == null) goto L9;
        r101.a();
    L9:
        this.f562601b = false;
        return;
    }
}
