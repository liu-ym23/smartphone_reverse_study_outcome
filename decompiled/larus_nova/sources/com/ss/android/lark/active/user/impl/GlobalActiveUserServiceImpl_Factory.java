package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class GlobalActiveUserServiceImpl_Factory implements Factory<b> {
    private final Provider<IGlobalActiveUserManager> activeUserManagerProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.activeUserManagerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalActiveUserServiceImpl_Factory(Provider<IGlobalActiveUserManager> r100) {
        this.activeUserManagerProvider = r100;
    }

    public static GlobalActiveUserServiceImpl_Factory create(Provider<IGlobalActiveUserManager> r100) {
        return new GlobalActiveUserServiceImpl_Factory(r100);
    }

    public static b newInstance(IGlobalActiveUserManager r100) {
        return new b(r100);
    }
}
