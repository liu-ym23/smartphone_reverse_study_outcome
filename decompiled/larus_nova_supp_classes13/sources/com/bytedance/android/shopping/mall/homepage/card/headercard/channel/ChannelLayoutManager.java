package com.bytedance.android.shopping.mall.homepage.card.headercard.channel;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/ChannelLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelLayoutManager extends GridLayoutManager {

    public static final class a {
    }

    static {
    }

    public final boolean canScrollHorizontally() {
        return false;
    }

    public final boolean canScrollVertically() {
        return false;
    }

    public ChannelLayoutManager(final ChannelAdapter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 4);
        setSpanSizeLookup(new AnonymousClass1(r2));
        GridLayoutManager.SpanSizeLookup r4 = getSpanSizeLookup();
        if (r4 == null) goto L6;
        r4.setSpanIndexCacheEnabled(true);
        return;
    }
}
