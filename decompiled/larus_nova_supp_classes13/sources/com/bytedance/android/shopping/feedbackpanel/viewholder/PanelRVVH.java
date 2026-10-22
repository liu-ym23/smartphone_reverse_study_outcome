package com.bytedance.android.shopping.feedbackpanel.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.feedbackpanel.enums.WhereType;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import de3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/viewholder/PanelRVVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelRVVH extends RecyclerView.ViewHolder {
    public final LinearLayout a;
    public final View b;
    public final ECDraweeView c;
    public final TextView d;

    public PanelRVVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (LinearLayout) r2.findViewById(2131372290);
        this.b = r2.findViewById(2131372301);
        this.c = r2.findViewById(2131372300);
        this.d = (TextView) r2.findViewById(2131372299);
    }

    public final void T3(final c r11, final ce3.c r12) {
        Intrinsics.checkNotNullParameter(r11, "itemData");
        WhereType r0 = r11.d;
        if (r0 == null) goto L18;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L8;
        this.a.setBackgroundResource(2131234388);
        this.b.setVisibility(0);
        goto L18
    L8:
        if (r1 != 2) goto L10;
        this.a.setBackgroundResource(2131234386);
        this.b.setVisibility(0);
        goto L18
    L10:
        if (r1 != 3) goto L12;
        this.a.setBackgroundResource(2131234385);
        this.b.setVisibility(8);
        goto L18
    L12:
        if (r1 != 4) goto L18;
        this.a.setBackgroundResource(2131234387);
        this.b.setVisibility(8);
    L18:
        ECDraweeView r4 = this.c;
        ECUrlModel r2 = r11.b;
        if (r2 == null) goto L21;
        String r5 = r2.getFirstUrl();
    L22:
        h0.e(r4, r5, new r("ec_goods_feed", "ec_goods_feed_default"), null, null, 120);
        this.d.setText(r11.c);
        f.c(((RecyclerView.ViewHolder) this).itemView, null, null, new PanelRVVH$bind$1(r12, r11), 3);
        return;
    L21:
        r5 = null;
        goto L22
    }
}
