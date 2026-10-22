package com.ss.android.lark.statistics.internal;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class NoopStatistics_Factory implements Factory<x5c.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopStatistics_Factory f440719a = null;

        static {
            f440719a = new NoopStatistics_Factory();
        }
    }

    public NoopStatistics_Factory() {
    }

    public static x5c.a newInstance() {
        return new x5c.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static NoopStatistics_Factory create() {
        return a.f440719a;
    }

    @Override // javax.inject.Provider
    public x5c.a get() {
        return newInstance();
    }
}
