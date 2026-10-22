package com.ss.ugc.live.sdk.msg.unify;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f458411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f458412b;

    public h(c r100, f r101) {
        this.f458411a = r100;
        this.f458412b = r101;
    }

    public final void a() {
        this.f458411a.f458358c.d(c.a.b.f458365a);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458412b.f458401n, "bridge register timeout: " + this.f458411a.a() + ", try http once");
        f r100 = this.f458412b;
        r100.g(r100.a());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
