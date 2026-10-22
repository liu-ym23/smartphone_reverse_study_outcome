package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class DefaultErrorInterceptor_Factory implements Factory<DefaultErrorInterceptor> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultErrorInterceptor_Factory f420216a = null;

        static {
            f420216a = new DefaultErrorInterceptor_Factory();
        }
    }

    public DefaultErrorInterceptor_Factory() {
    }

    public static DefaultErrorInterceptor newInstance() {
        return new DefaultErrorInterceptor();
    }

    @Override // javax.inject.Provider
    public DefaultErrorInterceptor get() {
        return newInstance();
    }

    public static DefaultErrorInterceptor_Factory create() {
        return a.f420216a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
