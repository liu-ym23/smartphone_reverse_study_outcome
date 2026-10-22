package com.ss.android.lark.flow.feed.action;

import com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel;
import com.ss.android.lark.feed.export.feedcard.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class FlowBaseActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f423195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f423196b;

    public final LarkFeedListViewModel p() {
        return (LarkFeedListViewModel) this.f423196b.getValue();
    }

    public FlowBaseActionHandler(d r100) {
        Intrinsics.checkNotNullParameter(r100, "feedCardContext");
        this.f423195a = r100;
        this.f423196b = LazyKt.lazy(new FlowBaseActionHandler$feedItemsViewModel$2(this));
    }
}
