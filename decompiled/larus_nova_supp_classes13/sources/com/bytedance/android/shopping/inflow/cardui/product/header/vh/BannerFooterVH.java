package com.bytedance.android.shopping.inflow.cardui.product.header.vh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcListVH;
import com.bytedance.android.shopping.inflow.common.utils.Contants$InflowType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/vh/BannerFooterVH;", "Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcListVH;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BannerFooterVH extends DeepFeedSlcListVH {
    public static final /* synthetic */ int b = 0;
    public final TextView a;

    public static final class a {
        public static BannerFooterVH a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            return new BannerFooterVH(LayoutInflater.from(r3.getContext()).inflate(2131564828, r3, false));
        }
    }

    static {
    }

    public BannerFooterVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (TextView) r2.findViewById(2131386346);
    }

    public final void T3(Contants$InflowType r3) {
        Intrinsics.checkNotNullParameter(r3, "inflowType");
        if (r3 != Contants$InflowType.INFEED_PRODUCT) goto L6;
        TextView r4 = this.a;
        int r0 = g1.a;
        r4.setTextColor(g1.a.a(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131105992));
        return;
    }
}
