package com.ss.android.lark.officesdk.provider;

import com.suite.lark.component.navroute.generated.aggregator.NavGraphAggregatorRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import nwb.g;

/* JADX INFO: loaded from: classes37.dex */
public final class RouterProvider_ProvideRouterFactory implements Factory<com.suite.lark.component.navroute.graph.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RouterProvider_ProvideRouterFactory f437150a = null;

        static {
            f437150a = new RouterProvider_ProvideRouterFactory();
        }
    }

    public RouterProvider_ProvideRouterFactory() {
    }

    public static com.suite.lark.component.navroute.graph.a provideRouter() {
        int r100 = g.f521021a;
        return (com.suite.lark.component.navroute.graph.a) Preconditions.checkNotNullFromProvides(NavGraphAggregatorRepository.f460360f);
    }

    @Override // javax.inject.Provider
    public com.suite.lark.component.navroute.graph.a get() {
        return provideRouter();
    }

    public static RouterProvider_ProvideRouterFactory create() {
        return a.f437150a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
