package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class HitPointInterceptor_Factory implements Factory<f> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HitPointInterceptor_Factory f420222a = null;

        static {
            f420222a = new HitPointInterceptor_Factory();
        }
    }

    public HitPointInterceptor_Factory() {
    }

    public static f newInstance() {
        return new f();
    }

    @Override // javax.inject.Provider
    public f get() {
        return newInstance();
    }

    public static HitPointInterceptor_Factory create() {
        return a.f420222a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
