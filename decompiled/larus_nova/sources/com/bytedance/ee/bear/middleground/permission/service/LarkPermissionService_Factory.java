package com.bytedance.ee.bear.middleground.permission.service;

import by4.b;
import dagger.internal.Factory;
import gi5.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes18.dex */
public final class LarkPermissionService_Factory implements Factory<a> {
    private final Provider<b> kvStorageProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkPermissionService_Factory(Provider<b> r100) {
        this.kvStorageProvider = r100;
    }

    public static LarkPermissionService_Factory create(Provider<b> r100) {
        return new LarkPermissionService_Factory(r100);
    }

    public static a newInstance(b r100) {
        return new a(r100);
    }
}
