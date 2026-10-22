package com.bytedance.android.window.shop.search.recyclerview.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowRecommendedNoticeHolder;", "Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowBaseSearchResultViewHolder;", "a", "b", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowRecommendedNoticeHolder extends WindowBaseSearchResultViewHolder {
    public static final int d = 0;

    public static final class a {
    }

    public static final class b extends LinearLayout {
        public TextView a;
        public SimpleDraweeView b;

        public final SimpleDraweeView getImageView() {
            SimpleDraweeView r0 = this.b;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        L5:
            return r0;
        }

        public final TextView getTextView() {
            TextView r0 = this.a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        L5:
            return r0;
        }

        public b(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            super(r5);
            setOrientation(0);
            setGravity(17);
            View r0 = new SimpleDraweeView(getContext());
            r0.setActualImageResource(2131234820);
            r0.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
            Unit r1 = Unit.INSTANCE;
            this.b = r0;
            LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(24), com.bytedance.android.shopping.extensions.b.b(24));
            int r2 = WindowRecommendedNoticeHolder.d;
            r3.setMargins(r2, 0, r2, 0);
            addView(r0, r3);
            TextView r4 = new TextView(getContext());
            this.a = r4;
            r4.setTextColor(ContextCompat.getColor(getContext(), 2131101553));
            View r6 = this.a;
            if (r6 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        L5:
            LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
            r7.setMargins(r2, 0, r2, 0);
            addView(r6, r7);
        }

        public final void setImageView(SimpleDraweeView r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.b = r2;
        }

        public final void setTextView(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.a = r2;
        }
    }

    public static final class c extends LinearLayout {
        public b a;
        public bp.a b;

        public c(Context r3) {
            super(r3);
            setOrientation(1);
            setGravity(17);
            this.a = new b(getContext());
            LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -2);
            r4.topMargin = com.bytedance.android.shopping.extensions.b.b(8);
            r4.bottomMargin = com.bytedance.android.shopping.extensions.b.b(16);
            addView(this.a, r4);
            View r5 = new bp.a(getContext());
            this.b = r5;
            addView(r5, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    static {
        d = com.bytedance.android.shopping.extensions.b.b(4);
    }

    public WindowRecommendedNoticeHolder(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(null, new c(r3), WindowSearchResultItemType.RECOMMEND_NOTICE);
    }

    @Override // com.bytedance.android.window.shop.search.recyclerview.holder.WindowBaseSearchResultViewHolder
    public final void T3(jp.b r8) {
        Intrinsics.checkNotNullParameter(r8, "vo");
        View r0 = this.b;
        if (r0 == null) goto L41;
        c r1 = (c) r0;
        jp.c r9 = (jp.c) r8;
        boolean r2 = r9.b;
        int r3 = 8;
        if (r9.c == false) goto L23;
        b r10 = r1.a;
        if (r10 == null) goto L20;
        TextView r5 = r10.a;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L11:
        if (r2 == false) goto L13;
        int r6 = 2131895874;
    L14:
        r5.setText(r6);
        SimpleDraweeView r11 = r10.b;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
    L17:
        if (r2 == false) goto L19;
        r3 = 0;
    L19:
        r11.setVisibility(r3);
        goto L20
    L13:
        r6 = 2131895873;
    L20:
        b r12 = r1.a;
        if (r12 == null) goto L35;
        r12.setVisibility(0);
    L35:
        bp.a r13 = r1.b;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("productTopBanner");
    L38:
        r13.getTextView().setText(2131896935);
        return;
    L23:
        b r14 = r1.a;
        if (r14 == null) goto L26;
        r14.setVisibility(8);
    L26:
        bp.a r15 = r1.b;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("productTopBanner");
    L29:
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == true) goto L32;
        r16 = null;
    L32:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r17 == null) goto L35;
        r17.topMargin = com.bytedance.android.shopping.extensions.b.b(16);
        goto L35
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.search.recyclerview.holder.WindowRecommendedNoticeHolder.WindowNoticeView");
    }
}
