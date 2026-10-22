package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes41.dex */
public class cl implements fe, fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f463252a;

    @Override // com.xiaomi.push.fj
    /* JADX INFO: renamed from: a */
    public boolean mo8908a(fn r100) {
        return true;
    }

    public cl(Context r100) {
        this.f463252a = r100;
    }

    @Override // com.xiaomi.push.fe
    public void a(eq r100) {
        if (r100 != null) goto L4;
    L8:
        cs.a(this.f463252a);
        return;
    L4:
        if (r100.a() != 0) goto L8;
        if ("PING".equals(r100.m9058a()) == false) goto L8;
        cs.c(this.f463252a);
    }

    @Override // com.xiaomi.push.fe
    public void a(fn r100) {
        cs.a(this.f463252a);
    }
}
