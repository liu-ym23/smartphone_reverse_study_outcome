package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeCompatRelativeLayout;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\"\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/toolarea/ToolItemView;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeCompatRelativeLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "r", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconSdView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconSdView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getTitleTextView", "()Landroid/widget/TextView;", "titleTextView", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeView;", "t", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeView;", "getBadeView", "()Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/BadgeView;", "badeView", "Landroid/view/View;", "u", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "anchorView", "v", "getAnchorViewRight", "anchorViewRight", "w", "getAnchorViewLeft", "anchorViewLeft", "x", "getAnchorViewBottomLeft", "anchorViewBottomLeft", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolItemView extends BadgeCompatRelativeLayout {
    public final View q;
    public final SimpleDraweeView r;
    public final TextView s;
    public final BadgeView t;
    public final View u;
    public final View v;
    public final View w;
    public final View x;

    public ToolItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ToolItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View getAnchorView() {
        return this.u;
    }

    public final View getAnchorViewBottomLeft() {
        return this.x;
    }

    public final View getAnchorViewLeft() {
        return this.w;
    }

    public final View getAnchorViewRight() {
        return this.v;
    }

    public final BadgeView getBadeView() {
        return this.t;
    }

    public final SimpleDraweeView getIconSdView() {
        return this.r;
    }

    public final TextView getTitleTextView() {
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView] */
    public ToolItemView(Context r19, AttributeSet r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "context");
        super(r19, r20, r21);
        View r2 = new View(r19);
        r2.setId(ViewCompat.generateViewId());
        Unit r3 = Unit.INSTANCE;
        this.q = r2;
        int r5 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r4 = com.bytedance.android.ec.hybrid.list.util.c.c(1, getContext(), true);
        int r7 = com.bytedance.android.ec.hybrid.list.util.c.c(4, getContext(), true);
        int r9 = com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true);
        SimpleDraweeView r10 = new SimpleDraweeView(r19);
        this.r = r10;
        TextView r11 = new TextView(r19);
        r11.setSingleLine();
        r11.setTextAlignment(4);
        r11.setTextColor(ContextCompat.getColor(r19, 2131106115));
        r11.setTextSize(0, com.bytedance.android.ec.hybrid.list.util.c.c(11, getContext(), true));
        r11.setId(ViewCompat.generateViewId());
        this.s = r11;
        ?? r6 = new BadgeView(r19, null, 6, 0);
        t93.a.d(r6);
        r6.setVisibility(8);
        this.t = r6;
        View r13 = new View(r19);
        this.u = r13;
        View r15 = new View(r19);
        this.v = r15;
        View r14 = new View(r19);
        r14.setId(ViewCompat.generateViewId());
        this.w = r14;
        View r8 = new View(r19);
        this.x = r8;
        setVisibility(8);
        BadgeCompatRelativeLayout.LayoutParams r1 = new BadgeCompatRelativeLayout.LayoutParams(com.bytedance.android.ec.hybrid.list.util.c.c(44, getContext(), true), com.bytedance.android.ec.hybrid.list.util.c.c(48, getContext(), true));
        ((ViewGroup.MarginLayoutParams) r1).topMargin = com.bytedance.android.ec.hybrid.list.util.c.c(8, getContext(), true);
        r1.a(10, -1);
        r1.a(14, -1);
        addView(r2, r1);
        BadgeCompatRelativeLayout.LayoutParams r12 = new BadgeCompatRelativeLayout.LayoutParams(com.bytedance.android.ec.hybrid.list.util.c.c(36, getContext(), true), com.bytedance.android.ec.hybrid.list.util.c.c(36, getContext(), true));
        r12.a(14, -1);
        r12.a(10, -1);
        ((ViewGroup.MarginLayoutParams) r12).topMargin = r7;
        addView(r10, r12);
        BadgeCompatRelativeLayout.LayoutParams r16 = new BadgeCompatRelativeLayout.LayoutParams(-2, com.bytedance.android.ec.hybrid.list.util.c.c(18, getContext(), true));
        r16.a(14, -1);
        r16.a(8, r2.getId());
        addView(r11, r16);
        BadgeCompatRelativeLayout.LayoutParams r17 = new BadgeCompatRelativeLayout.LayoutParams(-2, com.bytedance.android.ec.hybrid.list.util.c.c(14, getContext(), true));
        r17.a(18, r2.getId());
        r17.a(10, -1);
        ((ViewGroup.MarginLayoutParams) r17).topMargin = com.bytedance.android.ec.hybrid.list.util.c.c(6, getContext(), true);
        addView(r6, r17);
        BadgeCompatRelativeLayout.LayoutParams r18 = new BadgeCompatRelativeLayout.LayoutParams(r4, r4);
        r18.a(14, -1);
        r18.a(12, -1);
        ((ViewGroup.MarginLayoutParams) r18).bottomMargin = r9;
        addView(r13, r18);
        BadgeCompatRelativeLayout.LayoutParams r22 = new BadgeCompatRelativeLayout.LayoutParams(r4, r4);
        r22.a(21, -1);
        r22.a(12, -1);
        r22.setMarginEnd(r9);
        ((ViewGroup.MarginLayoutParams) r22).bottomMargin = r9;
        addView(r15, r22);
        BadgeCompatRelativeLayout.LayoutParams r23 = new BadgeCompatRelativeLayout.LayoutParams(r4, r4);
        r23.a(20, -1);
        r23.a(12, -1);
        r23.setMarginStart(r9);
        ((ViewGroup.MarginLayoutParams) r23).bottomMargin = r9;
        addView(r14, r23);
        BadgeCompatRelativeLayout.LayoutParams r24 = new BadgeCompatRelativeLayout.LayoutParams(r4, r4);
        r24.a(18, r14.getId());
        r24.a(6, r14.getId());
        ((ViewGroup.MarginLayoutParams) r24).topMargin = com.bytedance.android.ec.hybrid.list.util.c.c(4, getContext(), true);
        addView(r8, r24);
        setLayoutParams(new BadgeCompatRelativeLayout.LayoutParams(com.bytedance.android.ec.hybrid.list.util.c.c(71, getContext(), true), com.bytedance.android.ec.hybrid.list.util.c.c(66, getContext(), true)));
    }

    public /* synthetic */ ToolItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
