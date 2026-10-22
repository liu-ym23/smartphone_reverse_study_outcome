package com.ss.android.lark.officesdk.provider;

import com.suite.lark.component.navroute.args.b;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import nwb.g;

/* JADX INFO: loaded from: classes37.dex */
public final class RouterProvider_ProvideNavGraphRepositoryFactory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RouterProvider_ProvideNavGraphRepositoryFactory f437149a = null;

        static {
            f437149a = new RouterProvider_ProvideNavGraphRepositoryFactory();
        }
    }

    public RouterProvider_ProvideNavGraphRepositoryFactory() {
    }

    public static b provideNavGraphRepository() {
        int r100 = g.f521021a;
        return (b) Preconditions.checkNotNullFromProvides(com.suite.lark.component.navroute.generated.aggregator.a.f460361b);
    }

    @Override // javax.inject.Provider
    public b get() {
        return provideNavGraphRepository();
    }

    public static RouterProvider_ProvideNavGraphRepositoryFactory create() {
        return a.f437149a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
