package com.ss.android.lark.integrator.security.compliance.export;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class SecurityFileCryptoService_Factory implements Factory<SecurityFileCryptoService> {
    private final Provider<jkc.c> cipherManagerProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public SecurityFileCryptoService get() {
        return newInstance(this.userIdProvider.get(), this.cipherManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SecurityFileCryptoService_Factory(Provider<String> r100, Provider<jkc.c> r101) {
        this.userIdProvider = r100;
        this.cipherManagerProvider = r101;
    }

    public static SecurityFileCryptoService_Factory create(Provider<String> r100, Provider<jkc.c> r101) {
        return new SecurityFileCryptoService_Factory(r100, r101);
    }

    public static SecurityFileCryptoService newInstance(String r100, jkc.c r101) {
        return new SecurityFileCryptoService(r100, r101);
    }
}
