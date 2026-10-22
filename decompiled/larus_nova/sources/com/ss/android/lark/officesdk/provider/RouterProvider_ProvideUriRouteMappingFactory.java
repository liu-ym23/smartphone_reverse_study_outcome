package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import nwb.g;
import xnc.b;

/* JADX INFO: loaded from: classes37.dex */
public final class RouterProvider_ProvideUriRouteMappingFactory implements Factory<xnc.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RouterProvider_ProvideUriRouteMappingFactory f437151a = null;

        static {
            f437151a = new RouterProvider_ProvideUriRouteMappingFactory();
        }
    }

    public RouterProvider_ProvideUriRouteMappingFactory() {
    }

    public static xnc.a provideUriRouteMapping() {
        int r100 = g.f521021a;
        return (xnc.a) Preconditions.checkNotNullFromProvides(new b());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static RouterProvider_ProvideUriRouteMappingFactory create() {
        return a.f437151a;
    }

    @Override // javax.inject.Provider
    public xnc.a get() {
        return provideUriRouteMapping();
    }
}
