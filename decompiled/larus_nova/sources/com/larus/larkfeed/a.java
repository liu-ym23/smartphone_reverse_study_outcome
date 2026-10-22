package com.larus.larkfeed;

import android.view.View;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.feed.export.feedcard.e;
import com.ss.android.lark.feed.export.feedcard.f;
import com.ss.android.lark.feed.export.feedcard.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements e {
    public a() {
    }

    @Override // com.ss.android.lark.feed.export.feedcard.e
    public final f a() {
        return IFlowLarkFeedApi.f355117a.d();
    }

    @Override // com.ss.android.lark.feed.export.feedcard.e
    public final AppFeedCardType bizType() {
        return AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.e
    public final FeedCard.Type type() {
        return FeedCard.Type.DOUBAO_CONVERSATION;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.e
    public final h b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        return IFlowLarkFeedApi.f355117a.j();
    }

    @Override // com.ss.android.lark.feed.export.feedcard.e
    public final aeb.f c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "feedCardContext");
        return IFlowLarkFeedApi.f355117a.g(r100);
    }
}
