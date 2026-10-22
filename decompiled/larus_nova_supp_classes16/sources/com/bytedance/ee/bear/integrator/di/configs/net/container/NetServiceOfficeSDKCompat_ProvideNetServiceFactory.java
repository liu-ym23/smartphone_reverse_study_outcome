package com.bytedance.ee.bear.integrator.di.configs.net.container;

import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import jdb.g;
import kotlin.jvm.internal.Intrinsics;
import nb5.b;
import sa5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class NetServiceOfficeSDKCompat_ProvideNetServiceFactory implements Factory<NetService> {
    private final Provider<j> cookiesAdapterV2Provider;
    private final b module;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<t45.b> userDocDomainConfigProvider;
    private final Provider<g> userFgServiceProvider;

    public NetService get() {
        return provideNetService(this.module, (t45.b) this.userDocDomainConfigProvider.get(), (m) this.passportUserServiceProvider.get(), (j) this.cookiesAdapterV2Provider.get(), (g) this.userFgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m411get() {
        return get();
    }

    public NetServiceOfficeSDKCompat_ProvideNetServiceFactory(b r1, Provider<t45.b> r2, Provider<m> r3, Provider<j> r4, Provider<g> r5) {
        this.module = r1;
        this.userDocDomainConfigProvider = r2;
        this.passportUserServiceProvider = r3;
        this.cookiesAdapterV2Provider = r4;
        this.userFgServiceProvider = r5;
    }

    public static NetServiceOfficeSDKCompat_ProvideNetServiceFactory create(b r7, Provider<t45.b> r8, Provider<m> r9, Provider<j> r10, Provider<g> r11) {
        return new NetServiceOfficeSDKCompat_ProvideNetServiceFactory(r7, r8, r9, r10, r11);
    }

    public static NetService provideNetService(b r0, t45.b r1, m r2, j r3, g r4) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "userDocDomainConfig");
        Intrinsics.checkNotNullParameter(r2, "passportUserService");
        Intrinsics.checkNotNullParameter(r3, "cookiesAdapterV2");
        Intrinsics.checkNotNullParameter(r4, "userFgService");
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L8;
        Object r5 = new OfficeUserNetServiceImpl(r1, r2, r3, r4);
    L10:
        return (NetService) Preconditions.checkNotNullFromProvides(r5);
    L8:
        r5 = new UserNetServiceImpl(r1, r2, r3, r4);
        goto L10
    }
}
