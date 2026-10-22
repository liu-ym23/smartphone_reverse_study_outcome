package com.bytedance.android.shopping.mall.feed.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/holder/ECMallFeedTitleViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFeedTitleViewHolder extends BaseViewHolder {
    public static final /* synthetic */ int o = 0;

    public static final class a {
    }

    static {
    }

    public final boolean C3() {
        return false;
    }

    public ECMallFeedTitleViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public final void b4(Object r2, String r3, k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        super.b4(r2, r3, r4);
        View r5 = null;
        if ((r2 instanceof i93.a) == true) goto L5;
        r2 = null;
    L5:
        i93.a r6 = (i93.a) r2;
        if (r6 == null) goto L15;
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r7 instanceof TextView) == false) goto L11;
        r5 = r7;
    L11:
        TextView r8 = (TextView) r5;
        if (r8 == null) goto L16;
        r8.setText(r6.a());
        return;
    L16:
        return;
    }
}
