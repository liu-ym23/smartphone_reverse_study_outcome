package wu8;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f561468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f561469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f561470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f561471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f561472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f561473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f561474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f561475h;

    public b() {
    }

    public final boolean a() {
        if (this.f561468a == false) goto L5;
    L8:
        return true;
    L5:
        if (b() == true) goto L8;
        return false;
    }

    public final boolean b() {
        if (this.f561469b == false) goto L5;
    L16:
        return true;
    L5:
        if (this.f561470c == true) goto L16;
        if (this.f561472e == true) goto L16;
        if (this.f561473f == true) goto L16;
        if (this.f561474g == true) goto L16;
        if (this.f561475h == true) goto L16;
        return false;
    }
}
