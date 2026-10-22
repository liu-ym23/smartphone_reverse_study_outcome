package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.integrator.im.dependency.IEnvDependency;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.internal.Contexts;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements IEnvDependency {
    public f() {
    }

    @Override // com.ss.android.lark.integrator.im.dependency.IEnvDependency
    public final void rustSdkLogSubPath() {
    }

    @Override // com.ss.android.lark.integrator.im.dependency.IEnvDependency
    public final int envType() {
        return ((gpb.a) e0c.k.a(Contexts.getApplication(LarkContext.getApplication()), gpb.a.class)).envType();
    }
}
