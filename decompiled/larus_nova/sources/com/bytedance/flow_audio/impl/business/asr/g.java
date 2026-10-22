package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements sw5.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f243982b;

    @Override // sw5.b
    public final void A1() {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.c(f.f243970l, this.f243982b.f243972b.a("record started"));
    }

    @Override // sw5.b
    public final void a2() {
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.c(f.f243970l, this.f243982b.f243972b.a("record finished frames=" + this.f243982b.f243979i.c() + " bytes=" + this.f243982b.f243980j.c()));
    }

    public g(f r100) {
        this.f243982b = r100;
    }

    @Override // sw5.b
    public final void i1(hw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        IKMPLoggerService r101 = lp7.a.f510233a;
        lp7.a.b(f.f243970l, this.f243982b.f243972b.a("record callback failed isStarting=" + this.f243982b.f243977g.c() + ' ' + zw5.b.b(r100)));
        if (this.f243982b.f243977g.c() == false) goto L5;
        this.f243982b.f243978h.d(r100);
        return;
    L5:
        this.f243982b.f243976f.invoke(r100);
    }

    @Override // sw5.b
    public final void o2(rw5.d r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceData");
        this.f243982b.f243979i.d();
        this.f243982b.f243980j.a(r100.f539717b.length);
        this.f243982b.f243973c.invoke(r100);
    }
}
