package tz6;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements oz6.a.InterfaceC7134a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oz6.c f548052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.lottie.model.layer.a f548053b;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        com.bytedance.lottie.model.layer.a r100 = this.f548053b;
        if (this.f548052a.e().floatValue() != 1.0f) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == r100.f264545u) goto L10;
        r100.f264545u = r101;
        r100.f264537m.invalidateSelf();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L7
    }

    public a(com.bytedance.lottie.model.layer.a r100, oz6.c r101) {
        this.f548053b = r100;
        this.f548052a = r101;
    }
}
