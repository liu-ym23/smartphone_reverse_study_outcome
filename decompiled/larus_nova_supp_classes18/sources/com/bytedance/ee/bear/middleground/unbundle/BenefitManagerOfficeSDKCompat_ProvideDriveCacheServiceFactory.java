package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BenefitManagerOfficeSDKCompat_ProvideDriveCacheServiceFactory implements Factory<BenefitManagerAPI> {
    private final Provider<com.bytedance.ee.util.db.a> dbControllerProvider;
    private final Provider<by4.b> kvStorageProvider;
    private final a module;
    private final Provider<NetService> netServiceProvider;
    private final Provider<m> passportUserServiceProvider;

    public BenefitManagerAPI get() {
        return provideDriveCacheService(this.module, (NetService) this.netServiceProvider.get(), (m) this.passportUserServiceProvider.get(), (by4.b) this.kvStorageProvider.get(), (com.bytedance.ee.util.db.a) this.dbControllerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m300get() {
        return get();
    }

    public BenefitManagerOfficeSDKCompat_ProvideDriveCacheServiceFactory(a r1, Provider<NetService> r2, Provider<m> r3, Provider<by4.b> r4, Provider<com.bytedance.ee.util.db.a> r5) {
        this.module = r1;
        this.netServiceProvider = r2;
        this.passportUserServiceProvider = r3;
        this.kvStorageProvider = r4;
        this.dbControllerProvider = r5;
    }

    public static BenefitManagerOfficeSDKCompat_ProvideDriveCacheServiceFactory create(a r7, Provider<NetService> r8, Provider<m> r9, Provider<by4.b> r10, Provider<com.bytedance.ee.util.db.a> r11) {
        return new BenefitManagerOfficeSDKCompat_ProvideDriveCacheServiceFactory(r7, r8, r9, r10, r11);
    }

    public static BenefitManagerAPI provideDriveCacheService(a r0, NetService r1, m r2, by4.b r3, com.bytedance.ee.util.db.a r4) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "netService");
        Intrinsics.checkNotNullParameter(r2, "passportUserService");
        Intrinsics.checkNotNullParameter(r3, "kvStorage");
        Intrinsics.checkNotNullParameter(r4, "dbController");
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r5 = new d();
    L10:
        return (BenefitManagerAPI) Preconditions.checkNotNullFromProvides(r5);
    L8:
        r5 = new BenefitManagerImpl(r1, r2, r3, r4);
        goto L10
    }
}
