package com.bytedance.ee.permission.service;

import by4.b;
import com.bytedance.ee.bear.middleground.permission.apply.c0;
import dagger.internal.Factory;
import javax.inject.Provider;
import zt5.c;

/* JADX INFO: loaded from: classes19.dex */
public final class PermissionUIService_Factory implements Factory<c> {
    private final Provider<b> kvStorageProvider;
    private final Provider<c0> permissionPageFactoryProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.kvStorageProvider.get(), this.permissionPageFactoryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PermissionUIService_Factory(Provider<b> r100, Provider<c0> r101) {
        this.kvStorageProvider = r100;
        this.permissionPageFactoryProvider = r101;
    }

    public static PermissionUIService_Factory create(Provider<b> r100, Provider<c0> r101) {
        return new PermissionUIService_Factory(r100, r101);
    }

    public static c newInstance(b r100, c0 r101) {
        return new c(r100, r101);
    }
}
