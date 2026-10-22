package com.bytedance.locallife.host.feeds;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DeferredRefreshLifeFeedDataProvider$loadMore$1$1 extends FunctionReferenceImpl implements Function1<cy6.d, cy6.d> {
    public DeferredRefreshLifeFeedDataProvider$loadMore$1$1(Object r100) {
        super(1, r100, DeferredRefreshLifeFeedDataProvider.class, "filterEnterAweme", "filterEnterAweme(Lcom/bytedance/locallife/poi/api/feed/LifeFeedPageResult;)Lcom/bytedance/locallife/poi/api/feed/LifeFeedPageResult;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final cy6.d invoke2(cy6.d r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return DeferredRefreshLifeFeedDataProvider.b((DeferredRefreshLifeFeedDataProvider) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ cy6.d invoke(cy6.d r100) {
        return invoke2(r100);
    }
}
