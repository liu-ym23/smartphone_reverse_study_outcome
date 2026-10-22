package com.bytedance.ee.bear.domain;

import awa.d;
import com.bytedance.ee.bear.document.template.a;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import s45.c;
import s45.f;
import s45.j;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeSpaceKitUrlHelper_Factory implements Factory<j> {
    private final Provider<c> domainCharacteristicServiceProvider;
    private final Provider<f> domainConfigParserProvider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<a> templateUrlDependencyProvider;
    private final Provider<d> userSettingManagerProvider;

    @Override // javax.inject.Provider
    public j get() {
        return newInstance(this.passportUserServiceProvider.get(), this.domainCharacteristicServiceProvider.get(), this.userSettingManagerProvider.get(), this.domainConfigParserProvider.get(), this.templateUrlDependencyProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSpaceKitUrlHelper_Factory(Provider<m> r100, Provider<c> r101, Provider<d> r102, Provider<f> r103, Provider<a> r104) {
        this.passportUserServiceProvider = r100;
        this.domainCharacteristicServiceProvider = r101;
        this.userSettingManagerProvider = r102;
        this.domainConfigParserProvider = r103;
        this.templateUrlDependencyProvider = r104;
    }

    public static OfficeSpaceKitUrlHelper_Factory create(Provider<m> r100, Provider<c> r101, Provider<d> r102, Provider<f> r110, Provider<a> r111) {
        return new OfficeSpaceKitUrlHelper_Factory(r100, r101, r102, r110, r111);
    }

    public static j newInstance(m r100, c r101, d r102, f r103, Provider<a> r104) {
        return new j(r101, r102, r103, r104);
    }
}
