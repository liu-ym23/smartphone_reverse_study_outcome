package com.ss.android.lark.passport.auth;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyPassportAuthHeaderBindingService_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyPassportAuthHeaderBindingService_Factory f437706a = null;

        static {
            f437706a = new EmptyPassportAuthHeaderBindingService_Factory();
        }
    }

    public EmptyPassportAuthHeaderBindingService_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static EmptyPassportAuthHeaderBindingService_Factory create() {
        return a.f437706a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
