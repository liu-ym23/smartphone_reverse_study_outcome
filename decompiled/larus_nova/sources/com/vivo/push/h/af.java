package com.vivo.push.h;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
final class af extends ab {
    public af(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.b.i r101 = (com.vivo.push.b.i) r100;
        com.vivo.push.util.t.c("OnUnBindTask", "doTask,解订阅APP结果 = " + r101.j() + " clientToken= " + r101.f());
        com.vivo.push.m.a().a(r101.i(), r101.j(), new Object[0]);
        com.vivo.push.t.a(new ag(this, r101));
    }

    public static /* synthetic */ Context a(af r100) {
        return r100.f462510a;
    }
}
