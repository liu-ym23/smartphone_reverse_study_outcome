package com.bytedance.ee.bear.bitable.chameleon;

import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f209648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tu4.f f209649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f209650c;

    @Override // com.bytedance.ee.bear.bitable.chameleon.b
    public final void G3() {
        Intrinsics.checkNotNullParameter("onDestroyView", "reason");
        if (this.f209650c == true) goto L6;
        Lazy r100 = tu4.b.f547622a;
        tu4.b.h(this.f209648a, Long.valueOf(System.currentTimeMillis()), "onDestroyView");
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.b
    public final void stop() {
        if (this.f209650c == true) goto L6;
        this.f209650c = true;
        String r100 = this.f209648a;
        Lazy r101 = tu4.b.f547622a;
        Intrinsics.checkNotNullParameter(r100, "traceId");
        tu4.b.c().stopTrace(r100, Boolean.TRUE);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.b
    public final tu4.f getProxy() {
        return this.f209649b;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.b
    public final String getTraceId() {
        return this.f209648a;
    }

    public c(String r100, tu4.f r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "proxy");
        this.f209648a = r100;
        this.f209649b = r101;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.b
    public final void Vl(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f209650c == true) goto L6;
        tu4.b.f(this.f209648a, r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.b
    public final void ge(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (this.f209650c == true) goto L6;
        tu4.b.a(this.f209648a, r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.b
    public final void jg(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f209650c == true) goto L6;
        tu4.b.g(this.f209648a, r100, r101);
        return;
    }
}
