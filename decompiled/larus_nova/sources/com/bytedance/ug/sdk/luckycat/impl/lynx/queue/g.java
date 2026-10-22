package com.bytedance.ug.sdk.luckycat.impl.lynx.queue;

import com.bytedance.ug.sdk.luckycat.impl.lynx.n;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;

/* JADX INFO: loaded from: classes22.dex */
public final class g extends a<c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f271264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f271265d;

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final String d() {
        return "lynx";
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final boolean b() {
        return m.a.f271349a.s();
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final void g() {
        if (this.f271264c != null) goto L5;
    L5:
        this.f271264c = null;
    }

    public g(n r100) {
        this.f271265d = new f(r100);
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.lynx.queue.a
    public final void f(c r100) {
        if (b() == false) goto L5;
        c("lynx env is ready!!!");
        e();
        return;
    L5:
        c("start to wait lynx ready...");
        this.f271264c = new h(this.f271265d);
        com.bytedance.ug.sdk.luckycat.api.depend.h r101 = m.a.f271349a.f271343k;
        if (r101 == null) goto L10;
        r101.f();
        return;
    }
}
