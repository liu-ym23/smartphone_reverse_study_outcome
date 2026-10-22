package com.bytedance.ee.bear.appsetting.di;

import dagger.internal.Factory;
import dn4.b;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes15.dex */
public final class UserAppSettingImpl_Factory implements Factory<b> {
    private final Provider<g> userFgServiceProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.userFgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserAppSettingImpl_Factory(Provider<g> r100) {
        this.userFgServiceProvider = r100;
    }

    public static UserAppSettingImpl_Factory create(Provider<g> r100) {
        return new UserAppSettingImpl_Factory(r100);
    }

    public static b newInstance(g r100) {
        return new b(r100);
    }
}
