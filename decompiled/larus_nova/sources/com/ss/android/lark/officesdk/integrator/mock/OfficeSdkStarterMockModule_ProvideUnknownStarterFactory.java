package com.ss.android.lark.officesdk.integrator.mock;

import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.chatwindow.launcher.starter.a;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ytb.q;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSdkStarterMockModule_ProvideUnknownStarterFactory implements Factory<a> {
    private final Provider<ytb.a> mockProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideUnknownStarter(this.mockProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSdkStarterMockModule_ProvideUnknownStarterFactory(Provider<ytb.a> r100) {
        this.mockProvider = r100;
    }

    public static OfficeSdkStarterMockModule_ProvideUnknownStarterFactory create(Provider<ytb.a> r100) {
        return new OfficeSdkStarterMockModule_ProvideUnknownStarterFactory(r100);
    }

    public static a provideUnknownStarter(ytb.a r100) {
        int r101 = q.f569209a;
        Intrinsics.checkNotNullParameter(r100, BenefitStore.FROM_MOCK);
        return (a) Preconditions.checkNotNullFromProvides(r100);
    }
}
