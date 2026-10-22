package com.suite.lark.platform.component.storage.clean;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class CleanModuleProvider_Factory implements Factory<e> {
    private final Provider<Set<j>> cleanModulesProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.cleanModulesProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CleanModuleProvider_Factory(Provider<Set<j>> r100) {
        this.cleanModulesProvider = r100;
    }

    public static CleanModuleProvider_Factory create(Provider<Set<j>> r100) {
        return new CleanModuleProvider_Factory(r100);
    }

    public static e newInstance(Set<j> r100) {
        return new e(r100);
    }
}
