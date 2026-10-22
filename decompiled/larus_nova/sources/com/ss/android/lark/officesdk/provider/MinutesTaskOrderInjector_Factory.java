package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.e;

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesTaskOrderInjector_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MinutesTaskOrderInjector_Factory f437148a = null;

        static {
            f437148a = new MinutesTaskOrderInjector_Factory();
        }
    }

    public MinutesTaskOrderInjector_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static MinutesTaskOrderInjector_Factory create() {
        return a.f437148a;
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }
}
