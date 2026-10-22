package com.bytedance.bdturing.senseless;

import qb4.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements a.InterfaceC0114a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ d.e c;
    public final /* synthetic */ d d;

    @Override // com.bytedance.bdturing.senseless.a.InterfaceC0114a
    public final void T0() {
        d r0 = this.d;
        String r1 = this.a;
        String r2 = this.b;
        d.e r3 = this.c;
        a r4 = r0.a;
        if (r4 == null) goto L7;
        r4.b = false;
        c0.b r6 = c0.a.a.b;
        if (r6 == null) goto L7;
        r6.removeCallbacks(r4);
    L7:
        r0.f = 0;
        r0.c(r1, r2, new e(r0, r3, r1, r2), 0);
    }

    public b(d r1, String r2, String r3, SenselessVerifyService$d r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
