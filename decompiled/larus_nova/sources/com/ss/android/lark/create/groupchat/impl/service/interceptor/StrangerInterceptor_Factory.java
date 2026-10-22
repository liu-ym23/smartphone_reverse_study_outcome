package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class StrangerInterceptor_Factory implements Factory<g> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final StrangerInterceptor_Factory f420223a = null;

        static {
            f420223a = new StrangerInterceptor_Factory();
        }
    }

    public StrangerInterceptor_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    @Override // javax.inject.Provider
    public g get() {
        return newInstance();
    }

    public static StrangerInterceptor_Factory create() {
        return a.f420223a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
