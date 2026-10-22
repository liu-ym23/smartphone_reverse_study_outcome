package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class ExceedGroupLimitInterceptor_Factory implements Factory<ExceedGroupLimitInterceptor> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ExceedGroupLimitInterceptor_Factory f420219a = null;

        static {
            f420219a = new ExceedGroupLimitInterceptor_Factory();
        }
    }

    public ExceedGroupLimitInterceptor_Factory() {
    }

    public static ExceedGroupLimitInterceptor newInstance() {
        return new ExceedGroupLimitInterceptor();
    }

    @Override // javax.inject.Provider
    public ExceedGroupLimitInterceptor get() {
        return newInstance();
    }

    public static ExceedGroupLimitInterceptor_Factory create() {
        return a.f420219a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
