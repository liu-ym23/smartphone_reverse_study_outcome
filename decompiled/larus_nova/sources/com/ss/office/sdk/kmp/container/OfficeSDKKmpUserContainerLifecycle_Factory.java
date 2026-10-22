package com.ss.office.sdk.kmp.container;

import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import javax.inject.Provider;
import skc.a;

/* JADX INFO: loaded from: classes40.dex */
public final class OfficeSDKKmpUserContainerLifecycle_Factory implements Factory<a> {
    private final Provider<UserSession> userSessionProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.userSessionProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKKmpUserContainerLifecycle_Factory(Provider<UserSession> r100) {
        this.userSessionProvider = r100;
    }

    public static OfficeSDKKmpUserContainerLifecycle_Factory create(Provider<UserSession> r100) {
        return new OfficeSDKKmpUserContainerLifecycle_Factory(r100);
    }

    public static a newInstance(UserSession r100) {
        return new a(r100);
    }
}
