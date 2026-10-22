package com.vivo.push.h;

/* JADX INFO: loaded from: classes41.dex */
public final class o extends ab {
    public o(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.b.l r101 = (com.vivo.push.b.l) r100;
        int r102 = r101.e();
        int r103 = r101.f();
        com.vivo.push.util.ad.c().a("key_dispatch_environment", r102);
        com.vivo.push.util.ad.c().a("key_dispatch_area", r103);
        com.vivo.push.util.t.d("OnDispatcherReceiveTask", "environment  and area=" + r102 + "  ; " + r103);
    }
}
