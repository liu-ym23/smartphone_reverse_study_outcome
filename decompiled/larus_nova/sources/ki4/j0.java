package ki4;

/* JADX INFO: loaded from: classes15.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f503632a;

    public j0() {
    }

    public abstract String[] a();

    public abstract String b();

    public abstract j0 c();

    public final String toString() {
        if (this.f503632a == false) goto L6;
        return "NOT " + b();
    L6:
        return b();
    }
}
