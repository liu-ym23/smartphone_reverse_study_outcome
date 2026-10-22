package com.ss.android.lark.im.base;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class ImBaseBizModule_Factory implements Factory<ImBaseBizModule> {
    private final Provider<b> ccmDependencyProvider;
    private final Provider<c> extensionDependencyProvider;

    public static ImBaseBizModule newInstance() {
        return new ImBaseBizModule();
    }

    @Override // javax.inject.Provider
    public ImBaseBizModule get() {
        ImBaseBizModule r100 = newInstance();
        r100.f425877a = this.extensionDependencyProvider.get();
        r100.f425878b = this.ccmDependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImBaseBizModule_Factory(Provider<c> r100, Provider<b> r101) {
        this.extensionDependencyProvider = r100;
        this.ccmDependencyProvider = r101;
    }

    public static ImBaseBizModule_Factory create(Provider<c> r100, Provider<b> r101) {
        return new ImBaseBizModule_Factory(r100, r101);
    }
}
