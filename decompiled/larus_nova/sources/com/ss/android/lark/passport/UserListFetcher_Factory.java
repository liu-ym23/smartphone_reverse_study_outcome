package com.ss.android.lark.passport;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserListFetcher_Factory implements Factory<UserListFetcher> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<l> userRustClientProvider;

    @Override // javax.inject.Provider
    public UserListFetcher get() {
        return newInstance(this.currentUserIdProvider.get(), this.userRustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserListFetcher_Factory(Provider<String> r100, Provider<l> r101) {
        this.currentUserIdProvider = r100;
        this.userRustClientProvider = r101;
    }

    public static UserListFetcher_Factory create(Provider<String> r100, Provider<l> r101) {
        return new UserListFetcher_Factory(r100, r101);
    }

    public static UserListFetcher newInstance(String r100, l r101) {
        return new UserListFetcher(r100, r101);
    }
}
