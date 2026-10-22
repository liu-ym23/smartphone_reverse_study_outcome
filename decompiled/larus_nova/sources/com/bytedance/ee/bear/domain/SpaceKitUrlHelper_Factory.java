package com.bytedance.ee.bear.domain;

import awa.d;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import s45.c;
import s45.f;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public final class SpaceKitUrlHelper_Factory implements Factory<p> {
    private final Provider<c> domainCharacteristicServiceProvider;
    private final Provider<f> domainConfigParserProvider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<d> userSettingManagerProvider;

    @Override // javax.inject.Provider
    public p get() {
        return newInstance(this.passportUserServiceProvider.get(), this.domainCharacteristicServiceProvider.get(), this.userSettingManagerProvider.get(), this.domainConfigParserProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SpaceKitUrlHelper_Factory(Provider<m> r100, Provider<c> r101, Provider<d> r102, Provider<f> r103) {
        this.passportUserServiceProvider = r100;
        this.domainCharacteristicServiceProvider = r101;
        this.userSettingManagerProvider = r102;
        this.domainConfigParserProvider = r103;
    }

    public static SpaceKitUrlHelper_Factory create(Provider<m> r100, Provider<c> r101, Provider<d> r102, Provider<f> r103) {
        return new SpaceKitUrlHelper_Factory(r100, r101, r102, r103);
    }

    public static p newInstance(m r100, c r101, d r102, f r103) {
        return new p(r101, r102, r103);
    }
}
