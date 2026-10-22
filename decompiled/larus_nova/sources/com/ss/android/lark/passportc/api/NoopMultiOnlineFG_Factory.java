package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopMultiOnlineFG_Factory implements Factory<t> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopMultiOnlineFG_Factory f438101a = null;

        static {
            f438101a = new NoopMultiOnlineFG_Factory();
        }
    }

    public NoopMultiOnlineFG_Factory() {
    }

    public static t newInstance() {
        return new t();
    }

    @Override // javax.inject.Provider
    public t get() {
        return newInstance();
    }

    public static NoopMultiOnlineFG_Factory create() {
        return a.f438101a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
