package com.ss.android.lark.officesdk.container;

import android.app.Application;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKUserComponentManagerImpl_Factory implements Factory<OfficeSDKUserComponentManagerImpl> {
    private final Provider<Application> applicationProvider;
    private final Provider<OfficeSDKUserComponentBuilder> builderProvider;
    private final Provider<UserSession> userSessionProvider;

    @Override // javax.inject.Provider
    public OfficeSDKUserComponentManagerImpl get() {
        return newInstance(this.applicationProvider.get(), this.userSessionProvider.get(), this.builderProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKUserComponentManagerImpl_Factory(Provider<Application> r100, Provider<UserSession> r101, Provider<OfficeSDKUserComponentBuilder> r102) {
        this.applicationProvider = r100;
        this.userSessionProvider = r101;
        this.builderProvider = r102;
    }

    public static OfficeSDKUserComponentManagerImpl_Factory create(Provider<Application> r100, Provider<UserSession> r101, Provider<OfficeSDKUserComponentBuilder> r102) {
        return new OfficeSDKUserComponentManagerImpl_Factory(r100, r101, r102);
    }

    public static OfficeSDKUserComponentManagerImpl newInstance(Application r100, UserSession r101, OfficeSDKUserComponentBuilder r102) {
        return new OfficeSDKUserComponentManagerImpl(r100, r101, r102);
    }
}
