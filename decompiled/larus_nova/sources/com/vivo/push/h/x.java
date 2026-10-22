package com.vivo.push.h;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
final class x extends ab {
    public x(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        Context r101 = this.f462510a;
        if (com.vivo.push.util.aa.c(r101, r101.getPackageName()) == false) goto L6;
        e r102 = new e(r100);
        r102.a(this.f462339b);
        r102.a(r100);
        return;
    L6:
        d r103 = new d(r100);
        r103.a(this.f462339b);
        r103.a(r100);
    }
}
