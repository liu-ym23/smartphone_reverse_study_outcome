package com.ss.android.lark.profile_office.userprofile;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeProfileModel_Factory implements Factory<OfficeProfileModel> {
    private final Provider<com.ss.android.lark.profile.core.di.a> netClientGetterProvider;

    public static OfficeProfileModel newInstance() {
        return new OfficeProfileModel();
    }

    @Override // javax.inject.Provider
    public OfficeProfileModel get() {
        OfficeProfileModel r100 = newInstance();
        r100.f438882a = this.netClientGetterProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeProfileModel_Factory(Provider<com.ss.android.lark.profile.core.di.a> r100) {
        this.netClientGetterProvider = r100;
    }

    public static OfficeProfileModel_Factory create(Provider<com.ss.android.lark.profile.core.di.a> r100) {
        return new OfficeProfileModel_Factory(r100);
    }
}
