package com.ss.android.lark.applink;

import android.app.Application;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import ova.r;
import pva.b;
import pva.c;

/* JADX INFO: loaded from: classes34.dex */
public final class UserScopeAppLinkContributor_Factory implements Factory<r> {
    private final Provider<Application> appProvider;
    private final Provider<Set<b>> extensionsProvider;
    private final Provider<j> globalPassportProvider;
    private final Provider<c> registryProvider;
    private final Provider<m> userPassportProvider;
    private final Provider<UserSession> userSessionProvider;

    @Override // javax.inject.Provider
    public r get() {
        return newInstance(this.appProvider.get(), this.globalPassportProvider.get(), this.userPassportProvider.get(), this.userSessionProvider.get(), DoubleCheck.lazy(this.registryProvider), DoubleCheck.lazy(this.extensionsProvider));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserScopeAppLinkContributor_Factory(Provider<Application> r100, Provider<j> r101, Provider<m> r102, Provider<UserSession> r103, Provider<c> r104, Provider<Set<b>> r105) {
        this.appProvider = r100;
        this.globalPassportProvider = r101;
        this.userPassportProvider = r102;
        this.userSessionProvider = r103;
        this.registryProvider = r104;
        this.extensionsProvider = r105;
    }

    public static UserScopeAppLinkContributor_Factory create(Provider<Application> r100, Provider<j> r101, Provider<m> r110, Provider<UserSession> r111, Provider<c> r112, Provider<Set<b>> r113) {
        return new UserScopeAppLinkContributor_Factory(r100, r101, r110, r111, r112, r113);
    }

    public static r newInstance(Application r100, j r101, m r110, UserSession r111, Lazy<c> r112, Lazy<Set<b>> r113) {
        return new r(r100, r101, r110, r111, r112, r113);
    }
}
