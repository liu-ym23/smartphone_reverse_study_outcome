package com.bytedance.ee.bear.assemble.profile;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class OfficeProfileDependencyImpl_Factory implements Factory<c> {
    private final Provider<by4.b> kvStorageProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeProfileDependencyImpl_Factory(Provider<by4.b> r100) {
        this.kvStorageProvider = r100;
    }

    public static OfficeProfileDependencyImpl_Factory create(Provider<by4.b> r100) {
        return new OfficeProfileDependencyImpl_Factory(r100);
    }

    public static c newInstance(by4.b r100) {
        return new c();
    }
}
