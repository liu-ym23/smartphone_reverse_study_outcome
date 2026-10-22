package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class ExceedGroupLimitAndApplyInterceptor_Factory implements Factory<ExceedGroupLimitAndApplyInterceptor> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ExceedGroupLimitAndApplyInterceptor_Factory f420218a = null;

        static {
            f420218a = new ExceedGroupLimitAndApplyInterceptor_Factory();
        }
    }

    public ExceedGroupLimitAndApplyInterceptor_Factory() {
    }

    public static ExceedGroupLimitAndApplyInterceptor newInstance() {
        return new ExceedGroupLimitAndApplyInterceptor();
    }

    @Override // javax.inject.Provider
    public ExceedGroupLimitAndApplyInterceptor get() {
        return newInstance();
    }

    public static ExceedGroupLimitAndApplyInterceptor_Factory create() {
        return a.f420218a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
