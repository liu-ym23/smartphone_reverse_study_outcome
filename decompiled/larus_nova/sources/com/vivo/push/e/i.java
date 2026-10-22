package com.vivo.push.e;

import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
final class i implements com.vivo.push.restructure.request.c<com.vivo.push.e.a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f462320a;

    public i(h r100) {
        this.f462320a = r100;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int r100) {
        if (this.f462320a.f462318a == null) goto L6;
        t.b("query err : ".concat(String.valueOf(r100)));
        this.f462320a.f462318a.onError(r100);
        return;
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.restructure.request.a.a.b r100) {
        com.vivo.push.e.a.b r101 = (com.vivo.push.e.a.b) r100;
        if (this.f462320a.f462318a == null) goto L6;
        t.b("query success");
        this.f462320a.f462318a.onSuccess(r101.a());
        return;
    }
}
