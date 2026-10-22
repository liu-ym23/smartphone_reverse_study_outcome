package com.ss.android.lark.passport.auth;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyPassportAuthHeaderService_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyPassportAuthHeaderService_Factory f437707a = null;

        static {
            f437707a = new EmptyPassportAuthHeaderService_Factory();
        }
    }

    public EmptyPassportAuthHeaderService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static EmptyPassportAuthHeaderService_Factory create() {
        return a.f437707a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
