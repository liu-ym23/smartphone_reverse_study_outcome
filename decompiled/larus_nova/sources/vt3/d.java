package vt3;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f557201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f557202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f557203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final uu3.a f557204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public bq7.a f557205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f557206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ut3.c f557207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f557208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f557209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f557210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f557211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f557212l;

    public final synchronized void b() {
        monitor-enter(this);
        a(this.f557208h);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public d(uu3.a r100) {
        this.f557201a = false;
        this.f557202b = false;
        this.f557204d = r100;
    }

    public final void a(f r100) {
        if (this.f557201a == true) goto L5;
        return;
    L5:
        if (this.f557202b == false) goto L20;
        this.f557206f = r100;
        ut3.c r101 = this.f557207g;
        uu3.a r102 = this.f557204d;
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        r100.d(r101, r103);
        if (xu3.a.a() == false) goto L19;
        av3.b.d("APM-CPU", "change cpu exception detect state: " + this.f557206f);
        return;
    L19:
        return;
    L10:
        if (r102.isForeground() == false) goto L13;
        r103 = false;
        goto L14
    }
}
