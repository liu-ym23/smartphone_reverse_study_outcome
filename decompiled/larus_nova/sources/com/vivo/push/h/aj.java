package com.vivo.push.h;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
final class aj extends com.vivo.push.s {
    public aj(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        Context r101 = this.f462510a;
        if (r101 != null) goto L6;
        com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask " + r100 + " ; mContext is Null");
        return;
    L6:
        if (r100 != null) goto L9;
        com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask pushCommand is Null");
        return;
    L9:
        com.vivo.push.model.a r102 = com.vivo.push.util.aa.a(r101, com.vivo.push.restructure.a.a().f());
        int r103 = r100.b();
        if (r103 == 2009) goto L26;
        if (r103 == 2011) goto L24;
        switch(r103) {
            case 2002: goto L15;
            case 2003: goto L15;
            case 2004: goto L15;
            case 2005: goto L15;
            default: goto L28;
        };
    L15:
        if (r102 != null) goto L17;
    L23:
        com.vivo.push.m.a().a(((com.vivo.push.b.c) r100).g(), 1005);
        goto L28
    L17:
        if (r102.c() == true) goto L23;
        com.vivo.push.b.c r104 = (com.vivo.push.b.c) r100;
        int r105 = com.vivo.push.util.y.a(r104);
        if (r105 == 0) goto L28;
        com.vivo.push.m.a().a(r104.g(), r105);
        return;
    L28:
        if (r102 != null) goto L31;
        com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask " + r100 + " ; pushPkgInfo is Null");
        return;
    L31:
        String r106 = r102.a();
        if (r102.c() == true) goto L40;
    L38:
        com.vivo.push.a.a.a(this.f462510a, r106, r100);
        return;
    L40:
        com.vivo.push.m.a().a(((com.vivo.push.b.c) r100).g(), 1004);     // Catch: Exception -> L35
    L37:
        r100 = new com.vivo.push.b.e();
        com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask " + r100 + " ; pkgName is InBlackList ");
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L24:
        com.vivo.push.util.t.d("SendCommandTask", "SendCommandTask pushCommand is " + ((com.vivo.push.b.x) r100).e());
        goto L28
    L26:
        if (com.vivo.push.util.t.b() == false) goto L28;
        com.vivo.push.m.a();
        com.vivo.push.restructure.a.a().e().e();
        com.vivo.push.util.c r107 = new com.vivo.push.util.c();
        r107.a(this.f462510a, "com.vivo.push_preferences.hybridapptoken_v1");
        r107.b();
        new com.vivo.push.util.z(this.f462510a).b();
        goto L28
    }
}
