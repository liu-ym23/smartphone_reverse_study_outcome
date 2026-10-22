package com.ss.android.lark.integrator.todo.dependency;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements g7c.j {
    public p() {
    }

    @Override // g7c.j
    public final boolean a(String r100, boolean r101) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100, r101);
    }
}
