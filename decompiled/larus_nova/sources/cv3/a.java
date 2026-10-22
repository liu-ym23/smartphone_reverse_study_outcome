package cv3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f465483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f465484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f465485c;

    public a() {
        this(0);
    }

    public a(long r100) {
        this(r100, 0);
    }

    public a(long r100, long r101) {
        this.f465483a = r100;
        this.f465485c = r101;
        if (r101 <= 0) goto L6;
        this.f465484b = true;
        return;
    }
}
