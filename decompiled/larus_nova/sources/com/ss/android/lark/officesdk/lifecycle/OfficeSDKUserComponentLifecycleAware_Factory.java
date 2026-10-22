package com.ss.android.lark.officesdk.lifecycle;

import android.app.Application;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import cub.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKUserComponentLifecycleAware_Factory implements Factory<a> {
    private final Provider<Application> applicationProvider;
    private final Provider<OfficeSDKUserComponentManager> officeSDKUserComponentManagerProvider;
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.applicationProvider.get(), this.officeSDKUserComponentManagerProvider.get(), this.userIdProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKUserComponentLifecycleAware_Factory(Provider<Application> r100, Provider<OfficeSDKUserComponentManager> r101, Provider<String> r102) {
        this.applicationProvider = r100;
        this.officeSDKUserComponentManagerProvider = r101;
        this.userIdProvider = r102;
    }

    public static OfficeSDKUserComponentLifecycleAware_Factory create(Provider<Application> r100, Provider<OfficeSDKUserComponentManager> r101, Provider<String> r102) {
        return new OfficeSDKUserComponentLifecycleAware_Factory(r100, r101, r102);
    }

    public static a newInstance(Application r100, OfficeSDKUserComponentManager r101, String r102) {
        return new a(r100, r101, r102);
    }
}
