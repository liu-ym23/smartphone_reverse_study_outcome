package com.bytedance.android.shopping.feed.adapter;

import androidx.recyclerview.widget.GridLayoutManager;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/VideoProductFeedSpanSizeLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProductFeedSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
    public final ProductFeedAdapter a;
    public final AnchorV3Param b;

    public final int getSpanSize(int r4) {
        if (this.a.y != 2) goto L15;
        AnchorV3Param r0 = this.b;
        if (r0 == null) goto L9;
        List r1 = r0.getPromotions();
        if (r1 == null) goto L9;
        int r2 = r1.size();
    L10:
        if (r4 <= r2) goto L15;
        if (r4 != (this.a.getItemCount() - 1)) goto L14;
        return 2;
    L14:
        return 1;
    L9:
        r2 = 1;
    L15:
        return 2;
    }

    public VideoProductFeedSpanSizeLookup(ProductFeedAdapter r2, AnchorV3Param r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        this.a = r2;
        this.b = r3;
    }
}
