package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class TraceInterceptor_Factory implements Factory<e0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TraceInterceptor_Factory f425686a = null;

        static {
            f425686a = new TraceInterceptor_Factory();
        }
    }

    public TraceInterceptor_Factory() {
    }

    public static e0 newInstance() {
        return new e0();
    }

    @Override // javax.inject.Provider
    public e0 get() {
        return newInstance();
    }

    public static TraceInterceptor_Factory create() {
        return a.f425686a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
