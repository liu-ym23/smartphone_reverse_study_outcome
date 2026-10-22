package com.ss.android.lark.app.router;

import com.suite.lark.component.navroute.args.b;
import com.suite.lark.component.navroute.graph.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class InitRouterTask_Factory implements Factory<InitRouterTask> {
    private final Provider<b> navArgsTypeRepositoryProvider;
    private final Provider<a> navRouteGraphRepositoryProvider;
    private final Provider<xnc.a> uriRouteMappingProvider;

    @Override // javax.inject.Provider
    public InitRouterTask get() {
        return newInstance(this.navRouteGraphRepositoryProvider, this.navArgsTypeRepositoryProvider, this.uriRouteMappingProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitRouterTask_Factory(Provider<a> r100, Provider<b> r101, Provider<xnc.a> r102) {
        this.navRouteGraphRepositoryProvider = r100;
        this.navArgsTypeRepositoryProvider = r101;
        this.uriRouteMappingProvider = r102;
    }

    public static InitRouterTask_Factory create(Provider<a> r100, Provider<b> r101, Provider<xnc.a> r102) {
        return new InitRouterTask_Factory(r100, r101, r102);
    }

    public static InitRouterTask newInstance(Provider<a> r100, Provider<b> r101, Provider<xnc.a> r102) {
        return new InitRouterTask(r100, r101, r102);
    }
}
