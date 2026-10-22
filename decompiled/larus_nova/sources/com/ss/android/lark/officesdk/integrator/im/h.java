package com.ss.android.lark.officesdk.integrator.im;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {
    public h() {
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    }
}
