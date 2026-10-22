package com.vivo.push.e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
final class j implements com.vivo.push.restructure.request.c<com.vivo.push.e.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IPushRequestCallback f462321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f462322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f462323c;

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b r100) {
        com.vivo.push.e.a.b r101 = (com.vivo.push.e.a.b) r100;
        if (this.f462321a == null) goto L6;
        t.b(this.f462322b + " sync success");
        this.f462321a.onSuccess(0);
        return;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int r100) {
        if (this.f462321a == null) goto L6;
        t.b(this.f462322b + " sync err : " + r100);
        this.f462321a.onError(r100);
        return;
    }

    public j(d r100, IPushRequestCallback r101, int r102) {
        this.f462323c = r100;
        this.f462321a = r101;
        this.f462322b = r102;
    }
}
