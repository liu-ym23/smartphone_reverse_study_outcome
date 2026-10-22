package com.bytedance.ee.bear.middleground.permission.service;

import by4.b;
import dagger.internal.Factory;
import gi5.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class LarkPermissionService_Factory implements Factory<a> {
    private final Provider<b> kvStorageProvider;

    public a get() {
        return newInstance((b) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m293get() {
        return get();
    }

    public LarkPermissionService_Factory(Provider<b> r1) {
        this.kvStorageProvider = r1;
    }

    public static LarkPermissionService_Factory create(Provider<b> r1) {
        return new LarkPermissionService_Factory(r1);
    }

    public static a newInstance(b r1) {
        return new a(r1);
    }
}
