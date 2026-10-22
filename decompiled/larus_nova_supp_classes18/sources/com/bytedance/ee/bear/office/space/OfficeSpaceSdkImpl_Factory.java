package com.bytedance.ee.bear.office.space;

import android.app.Application;
import com.bytedance.ee.bear.contract.NetService;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeSpaceSdkImpl_Factory implements Factory<l> {
    private final Provider<Application> applicationProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<com.bytedance.ee.bear.init.a> officeCCMGlobalInitProvider;

    public l get() {
        return newInstance((Application) this.applicationProvider.get(), (com.bytedance.ee.bear.init.a) this.officeCCMGlobalInitProvider.get(), (NetService) this.netServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m462get() {
        return get();
    }

    public OfficeSpaceSdkImpl_Factory(Provider<Application> r1, Provider<com.bytedance.ee.bear.init.a> r2, Provider<NetService> r3) {
        this.applicationProvider = r1;
        this.officeCCMGlobalInitProvider = r2;
        this.netServiceProvider = r3;
    }

    public static OfficeSpaceSdkImpl_Factory create(Provider<Application> r1, Provider<com.bytedance.ee.bear.init.a> r2, Provider<NetService> r3) {
        return new OfficeSpaceSdkImpl_Factory(r1, r2, r3);
    }

    public static l newInstance(Application r1, com.bytedance.ee.bear.init.a r2, NetService r3) {
        return new l(r1, r2, r3);
    }
}
