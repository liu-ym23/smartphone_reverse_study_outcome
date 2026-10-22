package com.bytedance.ee.bear.bitable.homepage.chart.container;

import dagger.internal.Factory;
import ks4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class ChartLynxContainerProvider_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChartLynxContainerProvider_Factory f212435a = null;

        static {
            f212435a = new ChartLynxContainerProvider_Factory();
        }
    }

    public ChartLynxContainerProvider_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChartLynxContainerProvider_Factory create() {
        return a.f212435a;
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }
}
