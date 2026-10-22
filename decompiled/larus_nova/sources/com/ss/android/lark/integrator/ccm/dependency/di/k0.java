package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class k0 implements com.bytedance.ee.bear.list.u0 {
    public k0() {
    }

    @Override // com.bytedance.ee.bear.list.u0
    public final void a() {
        tt5.a.h("MileStoneAgentImpl_firstTab", "notifyBootMileStoneFirstDataLoaded, tabName = wiki");
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).a();
    }

    @Override // com.bytedance.ee.bear.list.u0
    public final void b(String r100) {
        tt5.a.h("MileStoneAgentImpl_firstTab", "notifyBootMileStoneFirstContentDraw, tabName = ".concat(r100));
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).L0();
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).A0();
    }

    @Override // com.bytedance.ee.bear.list.u0
    public final void c(String r100) {
        tt5.a.h("MileStoneAgentImpl_firstTab", "notifyBootMileStoneFirstFrameDraw, tabName = ".concat(r100));
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).K0();
    }
}
