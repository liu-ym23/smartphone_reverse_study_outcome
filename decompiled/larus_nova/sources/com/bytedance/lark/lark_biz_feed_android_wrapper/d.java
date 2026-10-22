package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.molten_livequery_wrapper.f;
import com.bytedance.lark.pb.feed.v1.LarkFeedListItem;
import com.bytedance.lark.pb.feed.v1.LarkFeedListKeyChange;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements f.a<LarkFeedListItem> {
    public d() {
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.f.a
    public final Object b(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        return LarkFeedListKeyChange.ADAPTER.decode(r100);
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.f.a
    public final LarkFeedListItem a(int r100, byte[] r101, LarkFeedListItem r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        LarkFeedListItem r103 = LarkFeedListItem.ADAPTER.decode(r101);
        Intrinsics.checkNotNull(r103);
        return r103;
    }
}
