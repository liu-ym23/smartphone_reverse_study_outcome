package com.vivo.push.restructure.a.a;

import android.content.Context;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
final class h extends a<com.vivo.push.restructure.a.a> {
    @Override // com.vivo.push.restructure.a.a.a
    public final /* synthetic */ int a(com.vivo.push.restructure.a.a r100) {
        Context r101 = com.vivo.push.restructure.a.a().b();
        com.vivo.push.m.a().a(r101);
        t.d("InitNode", "PushMessageReceiver " + r101.getPackageName() + " ; requestId = " + r100.c());
        return 0;
    }

    public h(com.vivo.push.restructure.a.a r100, j r101) {
        super("InitNode", r100, r101);
    }
}
