package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class ProfileDependencyImpl_Factory implements Factory<n1> {
    private final Provider<by4.b> kvStorageProvider;

    @Override // javax.inject.Provider
    public n1 get() {
        return newInstance(this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ProfileDependencyImpl_Factory(Provider<by4.b> r100) {
        this.kvStorageProvider = r100;
    }

    public static ProfileDependencyImpl_Factory create(Provider<by4.b> r100) {
        return new ProfileDependencyImpl_Factory(r100);
    }

    public static n1 newInstance(by4.b r100) {
        return new n1();
    }
}
