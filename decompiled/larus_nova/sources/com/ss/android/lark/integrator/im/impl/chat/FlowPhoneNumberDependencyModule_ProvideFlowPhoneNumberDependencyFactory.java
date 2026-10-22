package com.ss.android.lark.integrator.im.impl.chat;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dza.a;
import smb.c;
import smb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory implements Factory<a> {
    private final d module;

    @Override // javax.inject.Provider
    public a get() {
        return provideFlowPhoneNumberDependency(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory(d r100) {
        this.module = r100;
    }

    public static FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory create(d r100) {
        return new FlowPhoneNumberDependencyModule_ProvideFlowPhoneNumberDependencyFactory(r100);
    }

    public static a provideFlowPhoneNumberDependency(d r100) {
        r100.getClass();
        Object r101 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r101 != null) goto L6;
        r101 = new c();
    L6:
        return (a) Preconditions.checkNotNullFromProvides(r101);
    }
}
