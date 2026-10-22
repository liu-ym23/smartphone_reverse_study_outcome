package com.ss.android.lark.passport_user.impl;

import a0c.a;
import dagger.internal.Factory;
import javax.inject.Provider;
import yzb.b;

/* JADX INFO: loaded from: classes37.dex */
public final class GlobalUserDataSourceImpl_Factory implements Factory<a> {
    private final Provider<b> userListApiProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.userListApiProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalUserDataSourceImpl_Factory(Provider<b> r100) {
        this.userListApiProvider = r100;
    }

    public static GlobalUserDataSourceImpl_Factory create(Provider<b> r100) {
        return new GlobalUserDataSourceImpl_Factory(r100);
    }

    public static a newInstance(b r100) {
        return new a(r100);
    }
}
