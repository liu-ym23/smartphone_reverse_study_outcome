package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements com.bytedance.ee.bear.lark.dependency.f {
    public n() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.f
    public final void b(Context r100, String r101) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).G0();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.f
    public final void a(Context r100, String r101, Map<String, String> r102) {
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).openUrl(r100, r101);
    }
}
