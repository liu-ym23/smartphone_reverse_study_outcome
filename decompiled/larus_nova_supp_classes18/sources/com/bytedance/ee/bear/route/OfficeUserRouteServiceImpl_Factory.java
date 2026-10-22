package com.bytedance.ee.bear.route;

import com.bytedance.ee.bear.basesdk.services.route.UserRouteServiceImpl;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUserRouteServiceImpl_Factory implements Factory<g> {
    private final Provider<t45.c> spaceKitUrlHelperProvider;
    private final Provider<yqb.a> tabDataManagerProvider;

    public g get() {
        g r0 = newInstance((t45.c) this.spaceKitUrlHelperProvider.get());
        ((UserRouteServiceImpl) r0).a = DoubleCheck.lazy(this.tabDataManagerProvider);
        return r0;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m501get() {
        return get();
    }

    public static g newInstance(t45.c r1) {
        return new g(r1);
    }

    public OfficeUserRouteServiceImpl_Factory(Provider<t45.c> r1, Provider<yqb.a> r2) {
        this.spaceKitUrlHelperProvider = r1;
        this.tabDataManagerProvider = r2;
    }

    public static OfficeUserRouteServiceImpl_Factory create(Provider<t45.c> r1, Provider<yqb.a> r2) {
        return new OfficeUserRouteServiceImpl_Factory(r1, r2);
    }
}
