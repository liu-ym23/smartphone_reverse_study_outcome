package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.lark.lark_biz_feed_android.f1;
import com.bytedance.lark.view_flow_wrapper.ViewFlowPlugin;
import com.bytedance.lark.view_flow_wrapper.p;
import com.bytedance.lark.view_flow_wrapper.v;
import com.bytedance.lark.view_flow_wrapper.y;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory implements Factory<FeedRepositoryServiceExportedModuleWrapper> {
    private final a module;
    private final Provider<f1> param0Provider;
    private final Provider<v> strategyProvider;

    @Override // javax.inject.Provider
    public FeedRepositoryServiceExportedModuleWrapper get() {
        return providesFeedRepositoryServiceExportedModule(this.module, this.param0Provider.get(), this.strategyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory(a r100, Provider<f1> r101, Provider<v> r102) {
        this.module = r100;
        this.param0Provider = r101;
        this.strategyProvider = r102;
    }

    public static FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory create(a r100, Provider<f1> r101, Provider<v> r102) {
        return new FeedRepositoryServiceDaggerModule_ProvidesFeedRepositoryServiceExportedModuleFactory(r100, r101, r102);
    }

    public static FeedRepositoryServiceExportedModuleWrapper providesFeedRepositoryServiceExportedModule(a r100, final f1 r101, final v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "param0");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Function0<FeedRepositoryServiceExportedModuleWrapper> r103 = new FeedRepositoryServiceDaggerModule$providesFeedRepositoryServiceExportedModule$1(r101, r102);
        Intrinsics.checkNotNullParameter(r103, "creator");
        Object r104 = r100.f254448d;
        Object r105 = r104;
        if (r104 != null) goto L9;
        FeedRepositoryServiceExportedModuleWrapper r106 = r103.invoke();
        y r107 = ViewFlowPlugin.f254409a;
        if (r107 == null) goto L7;
        r107.a(new p((String) r100.f254447c.getValue(), r100.f254445a));
    L7:
        r100.f254448d = r106;
        r105 = r106;
    L9:
        return (FeedRepositoryServiceExportedModuleWrapper) Preconditions.checkNotNullFromProvides((FeedRepositoryServiceExportedModuleWrapper) r105);
    }
}
