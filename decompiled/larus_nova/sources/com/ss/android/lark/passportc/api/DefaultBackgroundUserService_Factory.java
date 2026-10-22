package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DefaultBackgroundUserService_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultBackgroundUserService_Factory f438098a = null;

        static {
            f438098a = new DefaultBackgroundUserService_Factory();
        }
    }

    public DefaultBackgroundUserService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static DefaultBackgroundUserService_Factory create() {
        return a.f438098a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
