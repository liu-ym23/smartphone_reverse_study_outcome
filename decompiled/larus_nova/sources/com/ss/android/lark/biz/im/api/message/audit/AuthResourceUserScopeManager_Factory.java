package com.ss.android.lark.biz.im.api.message.audit;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthResourceUserScopeManager_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AuthResourceUserScopeManager_Factory f410325a = null;

        static {
            f410325a = new AuthResourceUserScopeManager_Factory();
        }
    }

    public AuthResourceUserScopeManager_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static AuthResourceUserScopeManager_Factory create() {
        return a.f410325a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
