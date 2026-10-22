package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.view_flow_wrapper.h;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory implements Factory<b> {
    private final Provider<FeedRepositoryServiceExportedModuleWrapper> containerProvider;
    private final a module;

    @Override // javax.inject.Provider
    public b get() {
        return providesFeedBadgeService(this.module, this.containerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory(a r100, Provider<FeedRepositoryServiceExportedModuleWrapper> r101) {
        this.module = r100;
        this.containerProvider = r101;
    }

    public static FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory create(a r100, Provider<FeedRepositoryServiceExportedModuleWrapper> r101) {
        return new FeedRepositoryServiceDaggerModule_ProvidesFeedBadgeServiceFactory(r100, r101);
    }

    public static b providesFeedBadgeService(a r100, final FeedRepositoryServiceExportedModuleWrapper r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        b.f253230u1.getClass();
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        b.C3604b r102 = new b.C3604b(new IFeedBadgeService$Companion$from$1(r101));
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        return (b) Preconditions.checkNotNullFromProvides((b) ((h) r102.f254411a.invoke()));
    }
}
