package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;

/* JADX INFO: loaded from: classes36.dex */
public final class z implements zob.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0.a f427873a;

    public z(y r100) {
        this.f427873a = r100;
    }

    @Override // zob.b
    public final void a(Locale r100, Locale r101) {
        ((ra5.c) ((y) this.f427873a).f427872a).getClass();
        ((com.bytedance.ee.bear.basesdk.apisupport.f) qa5.b.a.f532259a.f532258a.b()).a();
        if (com.ss.android.lark.utils.o0.b(LarkContext.getApplication()) == false) goto L6;
        com.bytedance.ee.bear.lark.dependency.g r102 = (com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class);
        LarkContext.getApplication();
        r102.H0();
        return;
    }
}
