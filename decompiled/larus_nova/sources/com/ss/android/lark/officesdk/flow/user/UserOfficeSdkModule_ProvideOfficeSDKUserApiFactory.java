package com.ss.android.lark.officesdk.flow.user;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import rtb.b;
import stb.a;

/* JADX INFO: loaded from: classes37.dex */
public final class UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfficeSDKUserApi(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory(b r100) {
        this.module = r100;
    }

    public static UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory create(b r100) {
        return new UserOfficeSdkModule_ProvideOfficeSDKUserApiFactory(r100);
    }

    public static a provideOfficeSDKUserApi(b r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new rtb.a());
    }
}
