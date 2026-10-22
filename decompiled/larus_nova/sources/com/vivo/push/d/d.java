package com.vivo.push.d;

import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
final class d implements com.vivo.push.restructure.request.c<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f462285a;

    public d(c r100) {
        this.f462285a = r100;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b r100) {
        i r101 = (i) r100;
        if (r101 != null) goto L6;
        this.f462285a.f462283b.onStateChanged(10000);
        return;
    L6:
        t.d("NotifyGuideDialogManage", "onReceiveAck:" + r101.a());
        this.f462285a.f462283b.onStateChanged(r101.a());
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int r100) {
        t.d("NotifyGuideDialogManage", "onError:".concat(String.valueOf(r100)));
        this.f462285a.f462283b.onStateChanged(r100);
    }
}
