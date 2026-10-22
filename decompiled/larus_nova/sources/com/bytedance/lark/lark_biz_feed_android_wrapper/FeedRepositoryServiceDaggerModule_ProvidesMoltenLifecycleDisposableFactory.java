package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.view_flow_wrapper.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory implements Factory<m> {
    private final a module;

    @Override // javax.inject.Provider
    public m get() {
        return providesMoltenLifecycleDisposable(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory(a r100) {
        this.module = r100;
    }

    public static FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory create(a r100) {
        return new FeedRepositoryServiceDaggerModule_ProvidesMoltenLifecycleDisposableFactory(r100);
    }

    public static m providesMoltenLifecycleDisposable(a r100) {
        r100.getClass();
        return (m) Preconditions.checkNotNullFromProvides(r100);
    }
}
