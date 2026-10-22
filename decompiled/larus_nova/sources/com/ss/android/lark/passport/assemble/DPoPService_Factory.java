package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class DPoPService_Factory implements Factory<com.ss.android.lark.passport.assemble.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DPoPService_Factory f437683a = null;

        static {
            f437683a = new DPoPService_Factory();
        }
    }

    public DPoPService_Factory() {
    }

    public static com.ss.android.lark.passport.assemble.a newInstance() {
        return new com.ss.android.lark.passport.assemble.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.passport.assemble.a get() {
        return newInstance();
    }

    public static DPoPService_Factory create() {
        return a.f437683a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
