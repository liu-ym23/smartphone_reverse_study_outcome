package com.bytedance.ee.bear.domain;

import awa.d;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import s45.c;
import s45.f;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SpaceKitUrlHelper_Factory implements Factory<p> {
    private final Provider<c> domainCharacteristicServiceProvider;
    private final Provider<f> domainConfigParserProvider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<d> userSettingManagerProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public p m279get() {
        return newInstance((m) this.passportUserServiceProvider.get(), (c) this.domainCharacteristicServiceProvider.get(), (d) this.userSettingManagerProvider.get(), (f) this.domainConfigParserProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m279get();
    }

    public SpaceKitUrlHelper_Factory(Provider<m> r1, Provider<c> r2, Provider<d> r3, Provider<f> r4) {
        this.passportUserServiceProvider = r1;
        this.domainCharacteristicServiceProvider = r2;
        this.userSettingManagerProvider = r3;
        this.domainConfigParserProvider = r4;
    }

    public static SpaceKitUrlHelper_Factory create(Provider<m> r1, Provider<c> r2, Provider<d> r3, Provider<f> r4) {
        return new SpaceKitUrlHelper_Factory(r1, r2, r3, r4);
    }

    public static p newInstance(m r0, c r1, d r2, f r3) {
        return new p(r1, r2, r3);
    }
}
