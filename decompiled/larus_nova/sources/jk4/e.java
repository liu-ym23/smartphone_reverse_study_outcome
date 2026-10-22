package jk4;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements vk4.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f499502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f499503b;

    public final void a() {
        d r100 = this.f499503b;
        int r101 = this.f499502a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r100.d(r101) == true) goto L7;
    L9:
        monitor-exit(r100);
        return;
    L7:
        if (r100.f499486a.e() == true) goto L9;
        r100.r();     // Catch: Throwable -> L11
        goto L9
    }

    public e(d r100, int r101) {
        this.f499503b = r100;
        this.f499502a = r101;
    }
}
