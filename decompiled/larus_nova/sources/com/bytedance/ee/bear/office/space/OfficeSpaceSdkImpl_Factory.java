package com.bytedance.ee.bear.office.space;

import android.app.Application;
import com.bytedance.ee.bear.contract.NetService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeSpaceSdkImpl_Factory implements Factory<l> {
    private final Provider<Application> applicationProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<com.bytedance.ee.bear.init.a> officeCCMGlobalInitProvider;

    @Override // javax.inject.Provider
    public l get() {
        return newInstance(this.applicationProvider.get(), this.officeCCMGlobalInitProvider.get(), this.netServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSpaceSdkImpl_Factory(Provider<Application> r100, Provider<com.bytedance.ee.bear.init.a> r101, Provider<NetService> r102) {
        this.applicationProvider = r100;
        this.officeCCMGlobalInitProvider = r101;
        this.netServiceProvider = r102;
    }

    public static OfficeSpaceSdkImpl_Factory create(Provider<Application> r100, Provider<com.bytedance.ee.bear.init.a> r101, Provider<NetService> r102) {
        return new OfficeSpaceSdkImpl_Factory(r100, r101, r102);
    }

    public static l newInstance(Application r100, com.bytedance.ee.bear.init.a r101, NetService r102) {
        return new l(r100, r101, r102);
    }
}
