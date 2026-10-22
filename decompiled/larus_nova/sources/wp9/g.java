package wp9;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f560628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f560629b;

    public /* synthetic */ g() {
        this(16);
    }

    public final boolean a() {
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f560629b) < this.f560628a) goto L6;
        this.f560629b = r100;
        return true;
    L6:
        return false;
    }

    public g(long r100) {
        this.f560628a = r100;
    }
}
