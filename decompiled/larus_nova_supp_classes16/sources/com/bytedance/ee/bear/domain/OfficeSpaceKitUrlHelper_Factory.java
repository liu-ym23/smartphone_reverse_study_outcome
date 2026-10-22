package com.bytedance.ee.bear.domain;

import awa.d;
import com.bytedance.ee.bear.document.template.a;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import s45.c;
import s45.f;
import s45.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeSpaceKitUrlHelper_Factory implements Factory<j> {
    private final Provider<c> domainCharacteristicServiceProvider;
    private final Provider<f> domainConfigParserProvider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<a> templateUrlDependencyProvider;
    private final Provider<d> userSettingManagerProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public j m278get() {
        return newInstance((m) this.passportUserServiceProvider.get(), (c) this.domainCharacteristicServiceProvider.get(), (d) this.userSettingManagerProvider.get(), (f) this.domainConfigParserProvider.get(), this.templateUrlDependencyProvider);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m278get();
    }

    public OfficeSpaceKitUrlHelper_Factory(Provider<m> r1, Provider<c> r2, Provider<d> r3, Provider<f> r4, Provider<a> r5) {
        this.passportUserServiceProvider = r1;
        this.domainCharacteristicServiceProvider = r2;
        this.userSettingManagerProvider = r3;
        this.domainConfigParserProvider = r4;
        this.templateUrlDependencyProvider = r5;
    }

    public static OfficeSpaceKitUrlHelper_Factory create(Provider<m> r7, Provider<c> r8, Provider<d> r9, Provider<f> r10, Provider<a> r11) {
        return new OfficeSpaceKitUrlHelper_Factory(r7, r8, r9, r10, r11);
    }

    public static j newInstance(m r0, c r1, d r2, f r3, Provider<a> r4) {
        return new j(r1, r2, r3, r4);
    }
}
