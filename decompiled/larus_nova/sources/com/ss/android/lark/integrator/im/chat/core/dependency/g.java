package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements w4b.l {
    public g() {
    }

    @Override // w4b.l
    public final boolean isEnable(String r100) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }
}
