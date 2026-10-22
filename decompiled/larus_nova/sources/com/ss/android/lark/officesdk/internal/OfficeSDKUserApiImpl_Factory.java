package com.ss.android.lark.officesdk.internal;

import com.bytedance.lark.sdk.refactor.n;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKUserApiImpl_Factory implements Factory<h> {
    private final Provider<OfficeSDKUserComponentManager> componentManagerProvider;
    private final Provider<n> rustSDKProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public h get() {
        return newInstance(this.userIdProvider.get(), this.componentManagerProvider.get(), this.rustSDKProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKUserApiImpl_Factory(Provider<String> r100, Provider<OfficeSDKUserComponentManager> r101, Provider<n> r102) {
        this.userIdProvider = r100;
        this.componentManagerProvider = r101;
        this.rustSDKProvider = r102;
    }

    public static OfficeSDKUserApiImpl_Factory create(Provider<String> r100, Provider<OfficeSDKUserComponentManager> r101, Provider<n> r102) {
        return new OfficeSDKUserApiImpl_Factory(r100, r101, r102);
    }

    public static h newInstance(String r100, OfficeSDKUserComponentManager r101, n r102) {
        return new h(r100, r101, r102);
    }
}
