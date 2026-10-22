package com.bytedance.android.shopping.store.search.recyclerview.holder;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qj3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopRecommendedNoticeHolder;", "Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopBaseSearchResultViewHolder;", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopRecommendedNoticeHolder extends ShopBaseSearchResultViewHolder {

    public static final class a {
    }

    public static final class b extends LinearLayout {
        public c a;

        public b(Context r3) {
            super(r3);
            setOrientation(1);
            setGravity(17);
            c r4 = new c(getContext());
            this.a = r4;
            addView(r4, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    static {
        com.bytedance.android.shopping.extensions.b.b(4);
    }

    public ShopRecommendedNoticeHolder(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(null, new b(r3), SearchResultItemType.RECOMMEND_NOTICE);
    }

    @Override // com.bytedance.android.shopping.store.search.recyclerview.holder.ShopBaseSearchResultViewHolder
    public final void T3(en.b r9) {
        Intrinsics.checkNotNullParameter(r9, "vo");
        View r0 = this.b;
        if (r0 == null) goto L36;
        b r1 = (b) r0;
        en.c r10 = (en.c) r9;
        boolean r2 = r10.b;
        boolean r11 = r10.c;
        int r3 = 2131896849;
        if (r2 == false) goto L25;
        if (r11 == false) goto L25;
        c r4 = r1.a;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("productTopBanner");
    L11:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        ViewGroup.LayoutParams r7 = null;
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        r5 = null;
    L14:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        if (r6 == null) goto L17;
        r6.topMargin = com.bytedance.android.shopping.extensions.b.b(10);
    L17:
        ViewGroup.LayoutParams r8 = r4.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r7 = r8;
    L21:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r7;
        if (r12 == null) goto L24;
        r12.bottomMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L24:
        r4.getTextView().setTextColor((int) 2568362019L);
        r4.getTextView().setTypeface(Typeface.DEFAULT);
        r4.getTextView().setTextSize(2, 13.0f);
        r4.getTextView().setText(2131896849);
        r4.getLeftImage().setImageResource(2131234752);
        r4.getRightImage().setImageResource(2131234752);
    L25:
        c r13 = r1.a;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("productTopBanner");
    L28:
        TextView r14 = r13.getTextView();
        if (r2 == false) goto L32;
        if (r11 == false) goto L32;
    L33:
        r14.setText(r3);
        return;
    L32:
        r3 = 2131896862;
        goto L33
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.search.recyclerview.holder.ShopRecommendedNoticeHolder.ShopNoticeView");
    }
}
