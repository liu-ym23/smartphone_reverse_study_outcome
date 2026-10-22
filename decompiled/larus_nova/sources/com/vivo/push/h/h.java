package com.vivo.push.h;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
final class h extends ab {
    public h(com.vivo.push.v r100) {
        super(r100);
    }

    public static /* synthetic */ Context b(h r100) {
        return r100.f462510a;
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.b.i r101 = (com.vivo.push.b.i) r100;
        String r102 = r101.f();
        com.vivo.push.util.t.d("OnBindTask", "doTask,订阅APP结果 = " + r101.j() + " clientToken= " + r102);
        com.vivo.push.m.a().a(r101.i(), r101.j(), new Object[]{r102});
        com.vivo.push.t.a(new i(this, r102, r101));
    }

    public static /* synthetic */ Context a(h r100) {
        return r100.f462510a;
    }
}
