package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class v implements com.bytedance.ee.bear.lark.dependency.m {
    public v() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.m
    public final String getString() {
        return ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).O0();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.m
    public final boolean getBoolean(String r100) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }
}
