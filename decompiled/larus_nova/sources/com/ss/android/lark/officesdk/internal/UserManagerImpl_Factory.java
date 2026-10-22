package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.IOnlineOfflineService;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class UserManagerImpl_Factory implements Factory<UserManagerImpl> {
    private final Provider<IOfficeSDKLifeCycle> officeSDKLifeCycleProvider;
    private final Provider<IOnlineOfflineService> onlineOfflineServiceProvider;
    private final Provider<IOfficeSDKTokenProvider> tokenProvider;

    @Override // javax.inject.Provider
    public UserManagerImpl get() {
        return newInstance(this.onlineOfflineServiceProvider.get(), this.tokenProvider.get(), this.officeSDKLifeCycleProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserManagerImpl_Factory(Provider<IOnlineOfflineService> r100, Provider<IOfficeSDKTokenProvider> r101, Provider<IOfficeSDKLifeCycle> r102) {
        this.onlineOfflineServiceProvider = r100;
        this.tokenProvider = r101;
        this.officeSDKLifeCycleProvider = r102;
    }

    public static UserManagerImpl_Factory create(Provider<IOnlineOfflineService> r100, Provider<IOfficeSDKTokenProvider> r101, Provider<IOfficeSDKLifeCycle> r102) {
        return new UserManagerImpl_Factory(r100, r101, r102);
    }

    public static UserManagerImpl newInstance(IOnlineOfflineService r100, IOfficeSDKTokenProvider r101, IOfficeSDKLifeCycle r102) {
        return new UserManagerImpl(r100, r101, r102);
    }
}
