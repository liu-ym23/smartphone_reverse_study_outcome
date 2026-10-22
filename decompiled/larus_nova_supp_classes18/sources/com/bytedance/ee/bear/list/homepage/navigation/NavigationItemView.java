package com.bytedance.ee.bear.list.homepage.navigation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class NavigationItemView extends ConstraintLayout {
    public LKUIRoundedImageView2 a;
    public TextView b;
    public UDBadgeView c;
    public Constraints.LayoutParams d;
    public ConstraintLayout.LayoutParams e;

    public NavigationItemView() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NavigationItemView(Context r7, AttributeSet r8) {
        super(r7, r8);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setPadding(0, 0, 0, y9c.d.a(8));
        setId(2131378159);
        setBackground(getResources().getDrawable(2131243716));
        LKUIRoundedImageView2 r9 = new LKUIRoundedImageView2(r7);
        this.a = r9;
        r9.setId(2131378160);
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(y9c.d.a(30), y9c.d.a(30));
        r10.topToTop = 0;
        r10.leftToLeft = 0;
        r10.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = y9c.d.a(4);
        addView(this.a, r10);
        TextView r11 = new TextView(r7);
        this.b = r11;
        r11.setId(2131378161);
        ConstraintLayout.LayoutParams r12 = new ConstraintLayout.LayoutParams(-2, -2);
        this.e = r12;
        ((ViewGroup.MarginLayoutParams) r12).topMargin = y9c.d.a(4);
        ConstraintLayout.LayoutParams r13 = this.e;
        r13.topToBottom = 2131378160;
        r13.leftToLeft = 0;
        r13.rightToRight = 0;
        this.b.setGravity(17);
        this.b.setMaxLines(2);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.b.setTextColor(r7.getResources().getColor(2131106622));
        this.b.setTextSize(2, 12.0f);
        addView(this.b, this.e);
        Intrinsics.checkNotNullParameter(r7, "context");
        UDBadgeView r14 = new UDBadgeView(r7, null, 0, 2131953811);
        String r0 = r14.h;
        if (r0 == null) goto L5;
        r14.setText(r0);
    L5:
        Drawable r1 = r14.m;
        if (r1 == null) goto L8;
        r14.setIcon(r1);
    L8:
        r14.b();
        this.c = r14;
        r14.setId(2131378158);
        Constraints.LayoutParams r15 = new Constraints.LayoutParams(-2, -2);
        this.d = r15;
        ((ViewGroup.MarginLayoutParams) r15).rightMargin = y9c.d.a(2);
        Constraints.LayoutParams r16 = this.d;
        ((ViewGroup.MarginLayoutParams) r16).topMargin = y9c.d.a(6);
        Constraints.LayoutParams r17 = this.d;
        ((ConstraintLayout.LayoutParams) r17).topToTop = 2131378161;
        ((ConstraintLayout.LayoutParams) r17).rightToLeft = 2131378161;
        this.c.setBadgeColor(ContextCompat.getColor(r7, 2131105550));
        this.c.a();
        addView(this.c, this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.c.getVisibility() == 0) goto L5;
        return;
    L5:
        if (this.b.getLeft() > this.c.getMeasuredWidth()) goto L9;
        this.b.layout(this.c.getMeasuredWidth(), this.b.getTop(), Math.min(this.b.getRight(), getMeasuredWidth()), this.b.getBottom());
        UDBadgeView r6 = this.c;
        r6.layout(0, r6.getTop(), this.c.getMeasuredWidth(), this.c.getBottom());
        return;
    }
}
