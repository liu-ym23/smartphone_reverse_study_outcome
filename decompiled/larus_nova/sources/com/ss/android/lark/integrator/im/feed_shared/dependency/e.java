package com.ss.android.lark.integrator.im.feed_shared.dependency;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements peb.b.f {
    public e() {
    }

    @Override // peb.b.f
    public final boolean isCurrentEnable(String r100) {
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r100);
    }

    @Override // peb.b.f
    public final boolean isEnable(String r100) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }
}
