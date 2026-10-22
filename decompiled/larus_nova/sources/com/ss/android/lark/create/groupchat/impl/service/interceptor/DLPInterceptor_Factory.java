package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class DLPInterceptor_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DLPInterceptor_Factory f420215a = null;

        static {
            f420215a = new DLPInterceptor_Factory();
        }
    }

    public DLPInterceptor_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static DLPInterceptor_Factory create() {
        return a.f420215a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
