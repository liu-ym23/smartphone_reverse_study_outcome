package com.ss.android.lark.rustinfrabridge.store.service.impl.userscope;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class UserStoreService_Factory implements Factory<UserStoreService> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public UserStoreService get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserStoreService_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static UserStoreService_Factory create(Provider<l> r100) {
        return new UserStoreService_Factory(r100);
    }

    public static UserStoreService newInstance(l r100) {
        return new UserStoreService(r100);
    }
}
