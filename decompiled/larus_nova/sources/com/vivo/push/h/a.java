package com.vivo.push.h;

/* JADX INFO: loaded from: classes41.dex */
final class a extends com.vivo.push.s {
    public a(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.b.c r101 = (com.vivo.push.b.c) r100;
        com.vivo.push.model.a r102 = com.vivo.push.util.aa.a(this.f462510a, com.vivo.push.restructure.a.a().f());
        if (r102 != null) goto L6;
        com.vivo.push.m.a().a(r101.g(), 1005, new Object[0]);
        return;
    L6:
        String r103 = r102.a();
        if (r102.c() == false) goto L9;
        com.vivo.push.m.a().a(r101.g(), 1004, new Object[0]);
        r100 = new com.vivo.push.b.e();
    L13:
        com.vivo.push.a.a.a(this.f462510a, r103, r100);
        return;
    L9:
        int r104 = com.vivo.push.util.y.a(r101);
        if (r104 == 0) goto L13;
        com.vivo.push.m.a().a(r101.g(), r104, new Object[0]);
    }
}
