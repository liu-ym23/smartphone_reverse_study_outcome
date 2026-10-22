package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class GlobalActiveUserSelect_Factory implements Factory<a> {
    private final Provider<j> userListApiProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.userListApiProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalActiveUserSelect_Factory(Provider<j> r100) {
        this.userListApiProvider = r100;
    }

    public static GlobalActiveUserSelect_Factory create(Provider<j> r100) {
        return new GlobalActiveUserSelect_Factory(r100);
    }

    public static a newInstance(j r100) {
        return new a(r100);
    }
}
