package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class UserScopeBridge_Factory implements Factory<j> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.internal.b> backgroundAccessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> globalPassportServiceProvider;
    private final Provider<mua.a> multiSwitchProvider;
    private final Provider<com.ss.android.lark.passportc.api.i> multiUserFGProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;
    private final Provider<IUserListService> userServiceProvider;

    @Override // javax.inject.Provider
    public j get() {
        return newInstance(this.passportProvider.get(), this.globalPassportServiceProvider.get(), this.userServiceProvider.get(), this.multiSwitchProvider.get(), this.multiUserFGProvider.get(), this.accessorProvider.get(), this.backgroundAccessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserScopeBridge_Factory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<IUserListService> r102, Provider<mua.a> r103, Provider<com.ss.android.lark.passportc.api.i> r104, Provider<v> r105, Provider<com.ss.android.lark.passportc.internal.b> r106) {
        this.passportProvider = r100;
        this.globalPassportServiceProvider = r101;
        this.userServiceProvider = r102;
        this.multiSwitchProvider = r103;
        this.multiUserFGProvider = r104;
        this.accessorProvider = r105;
        this.backgroundAccessorProvider = r106;
    }

    public static UserScopeBridge_Factory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.api.j> r110, Provider<IUserListService> r111, Provider<mua.a> r112, Provider<com.ss.android.lark.passportc.api.i> r113, Provider<v> r114, Provider<com.ss.android.lark.passportc.internal.b> r115) {
        return new UserScopeBridge_Factory(r100, r110, r111, r112, r113, r114, r115);
    }

    public static j newInstance(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.api.j r110, IUserListService r111, mua.a r112, com.ss.android.lark.passportc.api.i r113, v r114, com.ss.android.lark.passportc.internal.b r115) {
        return new j(r100, r110, r111, r112, r113, r114, r115);
    }
}
