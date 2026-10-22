package com.ss.android.lark.passport.cookie;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyPassportCookieSyncService_Factory implements Factory<com.ss.android.lark.passport.cookie.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyPassportCookieSyncService_Factory f437717a = null;

        static {
            f437717a = new EmptyPassportCookieSyncService_Factory();
        }
    }

    public EmptyPassportCookieSyncService_Factory() {
    }

    public static com.ss.android.lark.passport.cookie.a newInstance() {
        return new com.ss.android.lark.passport.cookie.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.passport.cookie.a get() {
        return newInstance();
    }

    public static EmptyPassportCookieSyncService_Factory create() {
        return a.f437717a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
