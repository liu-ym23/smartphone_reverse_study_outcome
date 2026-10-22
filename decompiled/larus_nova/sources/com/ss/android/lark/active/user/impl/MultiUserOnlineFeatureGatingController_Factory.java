package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.e;

/* JADX INFO: loaded from: classes34.dex */
public final class MultiUserOnlineFeatureGatingController_Factory implements Factory<c> {
    private final Provider<e> globalFgServiceProvider;
    private final Provider<yzb.b> larkUserServiceProvider;
    private final Provider<MultiUserOnlineFgRepository> multiOnlineFgRepoProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        c r100 = newInstance(this.passportProvider.get(), this.globalFgServiceProvider.get(), this.multiOnlineFgRepoProvider.get());
        r100.f408628d = this.larkUserServiceProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static c newInstance(j r100, e r101, MultiUserOnlineFgRepository r102) {
        return new c(r100, r101, r102);
    }

    public MultiUserOnlineFeatureGatingController_Factory(Provider<j> r100, Provider<e> r101, Provider<MultiUserOnlineFgRepository> r102, Provider<yzb.b> r103) {
        this.passportProvider = r100;
        this.globalFgServiceProvider = r101;
        this.multiOnlineFgRepoProvider = r102;
        this.larkUserServiceProvider = r103;
    }

    public static MultiUserOnlineFeatureGatingController_Factory create(Provider<j> r100, Provider<e> r101, Provider<MultiUserOnlineFgRepository> r102, Provider<yzb.b> r103) {
        return new MultiUserOnlineFeatureGatingController_Factory(r100, r101, r102, r103);
    }
}
