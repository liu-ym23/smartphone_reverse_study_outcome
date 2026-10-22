package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements ntb.h {
    public k() {
    }

    @Override // ntb.h
    public final boolean isEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100);
    L5:
        return false;
    }
}
