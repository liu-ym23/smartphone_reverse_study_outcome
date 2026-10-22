package com.ss.android.lark.passport;

import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserListFetcherTriggerImpl_Factory implements Factory<UserListFetcherTriggerImpl> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public UserListFetcherTriggerImpl get() {
        return newInstance(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserListFetcherTriggerImpl_Factory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static UserListFetcherTriggerImpl_Factory create(Provider<j> r100, Provider<v> r101) {
        return new UserListFetcherTriggerImpl_Factory(r100, r101);
    }

    public static UserListFetcherTriggerImpl newInstance(j r100, v r101) {
        return new UserListFetcherTriggerImpl(r100, r101);
    }
}
