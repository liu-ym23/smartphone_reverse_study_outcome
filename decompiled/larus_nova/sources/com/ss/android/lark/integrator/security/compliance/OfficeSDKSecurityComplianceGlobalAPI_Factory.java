package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKSecurityComplianceGlobalAPI_Factory implements Factory<e> {
    private final Provider<com.ss.android.lark.screenprotect.userscope.b> screenProtectServiceProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.screenProtectServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKSecurityComplianceGlobalAPI_Factory(Provider<com.ss.android.lark.screenprotect.userscope.b> r100) {
        this.screenProtectServiceProvider = r100;
    }

    public static OfficeSDKSecurityComplianceGlobalAPI_Factory create(Provider<com.ss.android.lark.screenprotect.userscope.b> r100) {
        return new OfficeSDKSecurityComplianceGlobalAPI_Factory(r100);
    }

    public static e newInstance(com.ss.android.lark.screenprotect.userscope.b r100) {
        return new e(r100);
    }
}
