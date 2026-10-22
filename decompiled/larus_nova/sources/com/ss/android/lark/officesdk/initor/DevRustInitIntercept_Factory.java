package com.ss.android.lark.officesdk.initor;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class DevRustInitIntercept_Factory implements Factory<a> {
    private final Provider<IOfficeSDKConfigProvider> officeSDKConfigProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.officeSDKConfigProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DevRustInitIntercept_Factory(Provider<IOfficeSDKConfigProvider> r100) {
        this.officeSDKConfigProvider = r100;
    }

    public static DevRustInitIntercept_Factory create(Provider<IOfficeSDKConfigProvider> r100) {
        return new DevRustInitIntercept_Factory(r100);
    }

    public static a newInstance(IOfficeSDKConfigProvider r100) {
        return new a(r100);
    }
}
