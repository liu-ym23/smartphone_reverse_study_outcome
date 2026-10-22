package com.ss.android.lark.active.message.impl;

import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import nua.c;
import yzb.b;

/* JADX INFO: loaded from: classes34.dex */
public final class MultiTenantMsgSwitchImpl_Factory implements Factory<a> {
    private final Provider<IGlobalActiveUserManager> activeUserManagerProvider;
    private final Provider<b> larkUserListServiceProvider;
    private final Provider<c> multiUserFGServiceProvider;
    private final Provider<i> onlineFGProvider;
    private final Provider<j> passportGlobalServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.activeUserManagerProvider.get(), this.multiUserFGServiceProvider.get(), this.larkUserListServiceProvider.get(), this.passportGlobalServiceProvider.get(), this.onlineFGProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MultiTenantMsgSwitchImpl_Factory(Provider<IGlobalActiveUserManager> r100, Provider<c> r101, Provider<b> r102, Provider<j> r103, Provider<i> r104) {
        this.activeUserManagerProvider = r100;
        this.multiUserFGServiceProvider = r101;
        this.larkUserListServiceProvider = r102;
        this.passportGlobalServiceProvider = r103;
        this.onlineFGProvider = r104;
    }

    public static MultiTenantMsgSwitchImpl_Factory create(Provider<IGlobalActiveUserManager> r100, Provider<c> r101, Provider<b> r102, Provider<j> r110, Provider<i> r111) {
        return new MultiTenantMsgSwitchImpl_Factory(r100, r101, r102, r110, r111);
    }

    public static a newInstance(IGlobalActiveUserManager r100, c r101, b r102, j r110, i r111) {
        return new a(r100, r101, r102, r110, r111);
    }
}
