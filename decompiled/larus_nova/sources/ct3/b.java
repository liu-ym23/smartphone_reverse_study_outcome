package ct3;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f465314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465315b;

    public final void b() {
        f r100 = new f("page_load_trace", "activity");
        this.f465314a = r100;
        r100.f465340a = System.currentTimeMillis();
    }

    public b(String r100) {
        this.f465315b = r100;
    }

    public final void a(int r100, long r101) {
        f r102 = this.f465314a;
        if (r102 == null) goto L6;
        r102.b(r100, this.f465315b, r101);
        return;
    }
}
