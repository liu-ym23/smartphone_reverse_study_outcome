package d8a;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements k7a.a.InterfaceC6515a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f467436a;

    public d(l7a.e r100) {
        this.f467436a = r100;
    }

    @Override // k7a.a.InterfaceC6515a
    public final void a(byte[] r100, Throwable r101) {
        l7a.k r102 = ((l7a.e) this.f467436a).f507886a;
        if (r101 != null) goto L5;
        boolean r103 = true;
    L7:
        if (r101 == null) goto L9;
        String r104 = r101.getMessage();
    L10:
        r102.b(r103, r100, null, r104);
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = false;
        goto L7
    }
}
