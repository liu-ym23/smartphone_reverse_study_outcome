package com.ss.android.lark.chameleonv2.container.webcontainer.cookie;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import o0b.b;
import o0b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class AuthCookieModule_ProvideServiceFactory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AuthCookieModule_ProvideServiceFactory f411159a = null;

        static {
            f411159a = new AuthCookieModule_ProvideServiceFactory();
        }
    }

    public AuthCookieModule_ProvideServiceFactory() {
    }

    public static c provideService() {
        int r100 = b.f521650a;
        Object r101 = (c) OfficeSDKManager.getHostGlobalService(c.class);
        if (r101 != null) goto L6;
        r101 = new o0b.a();
    L6:
        return (c) Preconditions.checkNotNullFromProvides(r101);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static AuthCookieModule_ProvideServiceFactory create() {
        return a.f411159a;
    }

    @Override // javax.inject.Provider
    public c get() {
        return provideService();
    }
}
