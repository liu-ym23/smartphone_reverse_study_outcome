package com.bytedance.android.shopping.api.mall.feed.card;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/card/DeliveryCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeliveryCard extends BaseViewHolder {
    public final Lazy o;
    public final View p;
    public final View q;

    public final boolean C3() {
        return false;
    }

    public DeliveryCard(final View r20) {
        Intrinsics.checkNotNullParameter(r20, "itemView");
        super(r20);
        Lazy r10 = LazyKt.lazy(new DeliveryCard$tvText$2(r20));
        this.o = r10;
        View r11 = r20.findViewById(2131377758);
        this.p = r11;
        View r12 = r20.findViewById(2131384570);
        this.q = r12;
        Double r17 = Double.valueOf(19.75d);
        q4(this, r11, 36, 1, null, r17, 8, null, 36);
        q4(this, r12, 36, 1, 8, r17, null, null, 48);
        r11.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{ColorProtector.parseColor("#F4F4F4"), ColorProtector.parseColor("#D9D9D9")}));
        r12.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{ColorProtector.parseColor("#D9D9D9"), ColorProtector.parseColor("#F4F4F4")}));
        r11.setAlpha(1.0f);
        r12.setAlpha(1.0f);
        q4(this, (AppCompatTextView) r10.getValue(), null, null, null, Double.valueOf(11.5d), null, Double.valueOf(10.5d), 23);
        ((AppCompatTextView) r10.getValue()).setMaxWidth(ToolsKt.d(270, ((RecyclerView.ViewHolder) this).itemView.getContext(), true, null));
        ((AppCompatTextView) r10.getValue()).setTextSize(0, ToolsKt.d(12, ((RecyclerView.ViewHolder) this).itemView.getContext(), true, null));
        TextViewCompat.setLineHeight((AppCompatTextView) r10.getValue(), ToolsKt.d(17, ((RecyclerView.ViewHolder) this).itemView.getContext(), true, null));
    }

    public final void b4(Object r2, String r3, k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        super.b4(r2, r3, r4);
        if ((r2 instanceof DeliveryCardData) == true) goto L5;
        r2 = null;
    L5:
        DeliveryCardData r5 = (DeliveryCardData) r2;
        if (r5 == null) goto L11;
        String r6 = r5.getText();
        if (r6 == null) goto L12;
        ((AppCompatTextView) this.o.getValue()).setText(r6);
        return;
    L12:
        return;
    }

    public static void q4(DeliveryCard r2, View r3, Number r4, Number r5, Number r6, Number r7, Number r8, Number r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & 32) == 0) goto L20;
        r9 = null;
    L20:
        r2.getClass();
        ViewGroup.LayoutParams r11 = r3.getLayoutParams();
        if (r11 != null) goto L23;
        return;
    L23:
        if (r4 == null) goto L25;
        r11.width = ToolsKt.d(r4, r3.getContext(), true, null);
    L25:
        if (r5 == null) goto L28;
        r11.height = ToolsKt.d(r5, r3.getContext(), true, null);
    L28:
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L30;
        ViewGroup.LayoutParams r12 = null;
    L31:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 == null) goto L41;
        if (r6 == null) goto L35;
        r13.setMarginStart(ToolsKt.d(r6, r3.getContext(), true, null));
    L35:
        if (r7 == null) goto L37;
        r13.topMargin = ToolsKt.d(r7, r3.getContext(), true, null);
    L37:
        if (r8 == null) goto L39;
        r13.setMarginEnd(ToolsKt.d(r8, r3.getContext(), true, null));
    L39:
        if (r9 == null) goto L41;
        r13.bottomMargin = ToolsKt.d(r9, r3.getContext(), true, null);
    L41:
        r3.setLayoutParams(r11);
        return;
    L30:
        r12 = r11;
        goto L31
    }
}
