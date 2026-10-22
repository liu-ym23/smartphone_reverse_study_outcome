package com.vivo.push;

/* JADX INFO: loaded from: classes41.dex */
final class p implements IPushActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f462430a;

    public p(m r100) {
        this.f462430a = r100;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int r100) {
        if (r100 != 0) goto L6;
        com.vivo.push.restructure.a.a().h().b("");
        return;
    L6:
        com.vivo.push.restructure.a.a().h().c("");
    }
}
