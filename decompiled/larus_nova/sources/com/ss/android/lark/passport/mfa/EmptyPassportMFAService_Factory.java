package com.ss.android.lark.passport.mfa;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyPassportMFAService_Factory implements Factory<yyb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyPassportMFAService_Factory f438047a = null;

        static {
            f438047a = new EmptyPassportMFAService_Factory();
        }
    }

    public EmptyPassportMFAService_Factory() {
    }

    public static yyb.a newInstance() {
        return new yyb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static EmptyPassportMFAService_Factory create() {
        return a.f438047a;
    }

    @Override // javax.inject.Provider
    public yyb.a get() {
        return newInstance();
    }
}
