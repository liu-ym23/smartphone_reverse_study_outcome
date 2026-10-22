package com.ss.android.lark.passport;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeTokenServiceImpl_Factory implements Factory<OfficeTokenServiceImpl> {
    private final Provider<IOfficeSDKTokenProvider> tokenProvider;

    @Override // javax.inject.Provider
    public OfficeTokenServiceImpl get() {
        return newInstance(this.tokenProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeTokenServiceImpl_Factory(Provider<IOfficeSDKTokenProvider> r100) {
        this.tokenProvider = r100;
    }

    public static OfficeTokenServiceImpl_Factory create(Provider<IOfficeSDKTokenProvider> r100) {
        return new OfficeTokenServiceImpl_Factory(r100);
    }

    public static OfficeTokenServiceImpl newInstance(IOfficeSDKTokenProvider r100) {
        return new OfficeTokenServiceImpl(r100);
    }
}
