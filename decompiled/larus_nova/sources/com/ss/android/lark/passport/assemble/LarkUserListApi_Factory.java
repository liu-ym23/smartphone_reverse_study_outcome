package com.ss.android.lark.passport.assemble;

import com.ss.android.lark.passport_user.api.IUserListService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class LarkUserListApi_Factory implements Factory<d> {
    private final Provider<IUserListService> userListServiceProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.userListServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkUserListApi_Factory(Provider<IUserListService> r100) {
        this.userListServiceProvider = r100;
    }

    public static LarkUserListApi_Factory create(Provider<IUserListService> r100) {
        return new LarkUserListApi_Factory(r100);
    }

    public static d newInstance(IUserListService r100) {
        return new d(r100);
    }
}
