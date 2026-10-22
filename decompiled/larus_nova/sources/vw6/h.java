package vw6;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements xl4.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f557437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f557438b;

    @Override // xl4.a.d
    public final void bubbleDismiss() {
        b r100 = this.f557437a;
        if (r100 == null) goto L5;
        r100.onHide();
    L5:
        this.f557438b.f557433a = null;
    }

    public h(c r100, e r101) {
        this.f557437a = r100;
        this.f557438b = r101;
    }
}
