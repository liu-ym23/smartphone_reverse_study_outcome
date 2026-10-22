package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public final class g1 implements com.bytedance.ee.bear.lark.dependency.a0 {
    @Inject
    public g1() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.a0
    public final void k8(com.bytedance.ee.bear.lark.dependency.a0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.a0
    public final void wd(com.bytedance.ee.bear.lark.dependency.a0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }
}
