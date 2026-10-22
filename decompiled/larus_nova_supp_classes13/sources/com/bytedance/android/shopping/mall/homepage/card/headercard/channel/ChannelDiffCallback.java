package com.bytedance.android.shopping.mall.homepage.card.headercard.channel;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/ChannelDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ChannelVO;", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelDiffCallback extends DiffUtil.ItemCallback<ChannelVO> {
    public ChannelDiffCallback() {
    }

    public final boolean areContentsTheSame(Object r2, Object r3) {
        ChannelVO r4 = (ChannelVO) r2;
        ChannelVO r5 = (ChannelVO) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        return Intrinsics.areEqual(r4, r5);
    }

    public final boolean areItemsTheSame(Object r2, Object r3) {
        ChannelVO r4 = (ChannelVO) r2;
        ChannelVO r5 = (ChannelVO) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        return Intrinsics.areEqual(r4.getComponentId(), r5.getComponentId());
    }
}
