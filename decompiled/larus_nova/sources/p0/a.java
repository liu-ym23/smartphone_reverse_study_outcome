package p0;

/* JADX INFO: loaded from: classes28.dex */
public final class a implements j0.a.InterfaceC6374a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.airbnb.lottie.model.layer.a f527260a;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        boolean r100 = false;
        if (r0.c.a.f535397a == false) goto L10;
        com.airbnb.lottie.model.layer.a r101 = this.f527260a;
        if (r101.f24902p.l() != 1.0f) goto L8;
        r100 = true;
    L8:
        if (r100 == r101.f24908v) goto L17;
        r101.f24908v = r100;
        r101.f24899m.invalidateSelf();
        return;
    L17:
        return;
    L10:
        com.airbnb.lottie.model.layer.a r102 = this.f527260a;
        if (r102.f24902p.g().floatValue() != 1.0f) goto L14;
        r100 = true;
    L14:
        if (r100 == r102.f24908v) goto L19;
        r102.f24908v = r100;
        r102.f24899m.invalidateSelf();
        return;
    }

    public a(com.airbnb.lottie.model.layer.a r100) {
        this.f527260a = r100;
    }
}
