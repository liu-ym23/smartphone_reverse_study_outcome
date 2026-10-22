package com.ss.android.lark.passport.assemble;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserListService_Factory implements Factory<UserListService> {
    private final Provider<Context> contextProvider;
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;

    @Override // javax.inject.Provider
    public UserListService get() {
        return newInstance(this.contextProvider.get(), this.kvStorageProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserListService_Factory(Provider<Context> r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        this.contextProvider = r100;
        this.kvStorageProvider = r101;
    }

    public static UserListService_Factory create(Provider<Context> r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        return new UserListService_Factory(r100, r101);
    }

    public static UserListService newInstance(Context r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        return new UserListService(r100, r101);
    }
}
