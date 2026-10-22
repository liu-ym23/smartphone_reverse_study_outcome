package com.vivo.push;

/* JADX INFO: loaded from: classes41.dex */
final class n implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m.a f462423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f462424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f462425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f462426d;

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int r100) {
        if (r100 != 0) goto L12;
        Object[] r101 = this.f462423a.b();
        if (r101 != null) goto L6;
    L10:
        com.vivo.push.util.t.a("PushClientManager", "bind app result is null");
        return;
    L6:
        if (r101.length == 0) goto L10;
        com.vivo.push.restructure.a.a().h().a((String) this.f462423a.b()[0], this.f462424b, this.f462425c);
        return;
    L12:
        com.vivo.push.restructure.a.a().h().a("");
    }

    public n(m r100, m.a r101, String r102, String r103) {
        this.f462426d = r100;
        this.f462423a = r101;
        this.f462424b = r102;
        this.f462425c = r103;
    }
}
