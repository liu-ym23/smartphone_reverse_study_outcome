package com.bytedance.ee.bear.facade.common.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.CacTagView;
import com.bytedance.ee.bear.widgets.OwnerTagView;
import com.bytedance.ee.bear.widgets.PublicTagView;
import com.bytedance.ee.bear.widgets.TemplateTagView;
import com.bytedance.ee.bear.widgets.crosstenant.ExternalView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CustomTitleView extends LinearLayout {
    public TextView a;
    public boolean b;
    public TextView c;
    public ExternalView d;
    public CacTagView e;
    public OwnerTagView f;
    public PublicTagView g;
    public TemplateTagView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public CharSequence l;
    public TextView m;
    public int n;
    public int o;
    public final String[] p;
    public final ValueAnimator q;
    public CustomTitleLayout r;

    public boolean getExternalVisible() {
        if (this.d.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getStarVisible() {
        if (this.i.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getTitleVisible() {
        if (this.a.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.q;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public ImageView getIconView() {
        return this.j;
    }

    public CharSequence getTitle() {
        return this.l;
    }

    public CustomTitleLayout getTitleLayout() {
        return this.r;
    }

    public CustomTitleView(Context r5) {
        super(r5);
        this.b = false;
        com.bytedance.ee.util.ui.n.d(16);
        this.n = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        this.o = 1;
        this.p = new String[]{"", ".", "..", "..."};
        this.q = ValueAnimator.ofInt(new int[]{0, 4});
        c(r5, null);
    }

    private void setFirstTitle(CharSequence r3) {
        this.a.setText(r3);
        if (this.b == false) goto L13;
        int r1 = 0;
        if ((!TextUtils.isEmpty(this.c.getText())) == false) goto L11;
        TextView r0 = this.a;
        if (TextUtils.isEmpty(r3) == false) goto L10;
        r1 = 8;
    L10:
        r0.setVisibility(r1);
        return;
    L11:
        this.a.setVisibility(0);
        return;
    }

    public void setCacTagVisible(boolean r2) {
        CacTagView r0 = this.e;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setExternalTagEnabled(boolean r1) {
        if (r1 == false) goto L4;
        addView(this.d);
        return;
    L4:
        removeView(this.d);
    }

    public void setExternalVisible(boolean r2) {
        ExternalView r0 = this.d;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setOwnerTagVisible(boolean r2) {
        OwnerTagView r0 = this.f;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setPublicVisible(boolean r2) {
        PublicTagView r0 = this.g;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setSecondTitle(CharSequence r3) {
        TextView r0 = this.c;
        if (r0 == null) goto L16;
        r0.setText(r3);
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (this.a.getText() == null) goto L18;
        CharSequence r4 = this.a.getText();
        int r1 = 8;
        if (this.b == false) goto L14;
        TextView r2 = this.a;
        if (TextUtils.isEmpty(r4) == true) goto L13;
        r1 = 0;
    L13:
        r2.setVisibility(r1);
        return;
    L14:
        this.a.setVisibility(8);
        return;
    L18:
        return;
    }

    public void setSecondTitleLeftDrawable(Drawable r4) {
        if (this.c == null) goto L6;
        r4.setBounds(0, 0, y9c.d.a(15), y9c.d.a(15));
        this.c.setCompoundDrawables(r4, null, null, null);
        return;
    }

    public void setSecondTitleVisibility(boolean r2) {
        if (r2 == false) goto L4;
        this.c.setVisibility(0);
        return;
    L4:
        this.c.setVisibility(8);
    }

    public void setStarVisible(boolean r2) {
        ImageView r0 = this.i;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setTemplateTagVisible(boolean r2) {
        TemplateTagView r0 = this.h;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public void setTipsClickListener(View.OnClickListener r2) {
        this.k.setOnClickListener(r2);
    }

    public void setTipsIcon(int r3) {
        this.k.setBackground(com.bytedance.ee.util.ui.n.k(getContext(), r3));
    }

    public void setTipsVisible(boolean r2) {
        ImageView r0 = this.k;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setTitle(int r2) {
        String r3 = getResources().getString(r2);
        this.l = r3;
        setFirstTitle(r3);
        if (this.q.isRunning() == false) goto L6;
        this.q.cancel();
        return;
    }

    public void setTitleSize(float r2) {
        this.a.setTextSize(r2);
    }

    public void setTitleTextBold(boolean r2) {
        this.a.getPaint().setFakeBoldText(r2);
    }

    public void setTitleTextColor(int r3) {
        this.a.setTextColor(getResources().getColor(r3));
    }

    public void setTitleTextSize(int r3) {
        this.a.setTextSize(0, a08.b.a(getResources().getDimension(r3), getContext()));
    }

    public void setTitleVisible(boolean r5) {
        TextView r0 = this.a;
        if (r5 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        this.b = r5;
        if (r5 == true) goto L9;
    L11:
        this.j.setVisibility(8);
    L12:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        if (r5 == false) goto L15;
        r1.leftMargin = getResources().getDimensionPixelSize(2131166501);
        return;
    L15:
        r1.leftMargin = 0;
        return;
    L9:
        if (this.j.getDrawable() == null) goto L11;
        this.j.setVisibility(0);
        goto L12
    L5:
        r3 = 8;
        goto L6
    }

    public void setTitle(CharSequence r1) {
        this.l = r1;
        setFirstTitle(r1);
        if (this.q.isRunning() == false) goto L6;
        this.q.cancel();
        return;
    }

    public CustomTitleView(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.b = false;
        com.bytedance.ee.util.ui.n.d(16);
        this.n = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        this.o = 1;
        this.p = new String[]{"", ".", "..", "..."};
        this.q = ValueAnimator.ofInt(new int[]{0, 4});
        c(r5, r6);
    }

    public static /* synthetic */ void a(CustomTitleView r3, ValueAnimator r4) {
        r3.getClass();
        r3.setFirstTitle(r3.getResources().getString(2131888312) + r3.p[((Integer) r4.getAnimatedValue()).intValue() % r3.p.length]);
    }

    public static /* synthetic */ void b(CustomTitleView r0, CharSequence r1) {
        r0.setFirstTitle(r1);
    }

    public final void c(Context r10, AttributeSet r11) {
        this.n = getResources().getColor(2131106622);
        if (r11 == null) goto L5;
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{2130974575, 2130974583, 2130974585, 2130974586, 2130974587, 2130974588});
        this.l = r12.getString(5);
        r12.getDimension(2, getResources().getDimension(2131166502));
        this.n = r12.getColor(0, getResources().getColor(2131106622));
        this.o = r12.getInt(1, 1);
        r12.recycle();
    L5:
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        r13.gravity = 17;
        r13.width = getResources().getDimensionPixelSize(2131166499);
        r13.height = getResources().getDimensionPixelSize(2131166499);
        r13.rightMargin = getResources().getDimensionPixelSize(2131166498);
        ImageView r5 = new ImageView(r10);
        this.j = r5;
        r5.setVisibility(8);
        addView(this.j, r13);
        ViewGroup.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
        CustomTitleLayout r6 = new CustomTitleLayout(r10);
        this.r = r6;
        addView(r6, r14);
        CustomTitleLayout r16 = this.r;
        this.a = r16.c;
        this.c = r16.d;
        if (TextUtils.isEmpty(this.l) == true) goto L9;
        setFirstTitle(this.l);
    L9:
        if (this.o != 1) goto L11;
        this.a.setSingleLine(true);
    L12:
        this.q.addUpdateListener(new a(this));
        this.q.addListener(new b(this));
        this.q.setDuration(500);
        this.q.setRepeatCount(-1);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-2, -2);
        r17.gravity = 17;
        TextView r0 = new TextView(r10);
        this.m = r0;
        r0.setPadding(y9c.d.a(2), 0, 0, 0);
        this.m.setTextSize(2, 16.0f);
        this.m.setTextColor(this.n);
        this.m.setVisibility(8);
        addView(this.m, r17);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        r18.gravity = 17;
        r18.leftMargin = getResources().getDimensionPixelSize(2131166501);
        ExternalView r1 = new ExternalView(r10);
        this.d = r1;
        r1.setVisibility(8);
        addView(this.d, r18);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, -2);
        r19.gravity = 17;
        r19.leftMargin = getResources().getDimensionPixelSize(2131166501);
        PublicTagView r2 = new PublicTagView(r10);
        this.g = r2;
        r2.setVisibility(8);
        addView(this.g, r19);
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        r110.gravity = 17;
        r110.width = getResources().getDimensionPixelSize(2131166500);
        r110.height = getResources().getDimensionPixelSize(2131166500);
        r110.leftMargin = getResources().getDimensionPixelSize(2131166501);
        ImageView r3 = new ImageView(r10);
        this.i = r3;
        r3.setBackground(com.bytedance.ee.util.ui.n.k(r10, 2131254138));
        com.bytedance.ee.util.ui.l.b(this.i, 2131101124);
        this.i.setVisibility(8);
        addView(this.i, r110);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -2);
        r111.gravity = 17;
        r111.width = getResources().getDimensionPixelSize(2131166500);
        r111.height = getResources().getDimensionPixelSize(2131166500);
        ImageView r4 = new ImageView(r10);
        this.k = r4;
        r4.setBackground(getResources().getDrawable(2131235945));
        com.bytedance.ee.util.ui.l.b(this.k, 2131102419);
        this.k.setVisibility(8);
        addView(this.k, r111);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        r112.gravity = 17;
        r112.leftMargin = getResources().getDimensionPixelSize(2131166501);
        OwnerTagView r7 = new OwnerTagView(r10);
        this.f = r7;
        r7.setVisibility(8);
        addView(this.f, r112);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, -2);
        r113.gravity = 17;
        r113.leftMargin = getResources().getDimensionPixelSize(2131166501);
        TemplateTagView r8 = new TemplateTagView(r10);
        this.h = r8;
        r8.setVisibility(8);
        addView(this.h, r113);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        r114.gravity = 17;
        r114.leftMargin = getResources().getDimensionPixelSize(2131166501);
        CacTagView r9 = new CacTagView(r10);
        this.e = r9;
        r9.setVisibility(8);
        addView(this.e, r114);
        return;
    L11:
        this.a.setSingleLine(false);
        this.a.setMaxLines(this.o);
        goto L12
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L7;
        measureChildWithMargins(getChildAt(r1), r11, 0, r12, 0);
        r1 = r1 + 1;
        goto L4
    L7:
        if (this.j.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        int r14 = (this.j.getMeasuredWidth() + r13.leftMargin) + r13.rightMargin;
    L11:
        if (this.i.getVisibility() != 0) goto L13;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        int r2 = (this.i.getMeasuredWidth() + r16.leftMargin) + r16.rightMargin;
    L15:
        if (this.k.getVisibility() != 0) goto L17;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
        int r3 = (this.k.getMeasuredWidth() + r17.leftMargin) + r17.rightMargin;
    L19:
        if (this.d.getVisibility() != 0) goto L21;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        int r4 = (this.d.getMeasuredWidth() + r18.leftMargin) + r18.rightMargin;
    L23:
        if (this.f.getVisibility() != 0) goto L25;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
        int r5 = (this.f.getMeasuredWidth() + r19.leftMargin) + r19.rightMargin;
    L27:
        if (this.g.getVisibility() != 0) goto L29;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
        int r6 = (this.g.getMeasuredWidth() + r110.leftMargin) + r110.rightMargin;
    L31:
        if (this.m.getVisibility() != 0) goto L33;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) this.m.getLayoutParams();
        int r7 = (this.m.getMeasuredWidth() + r111.leftMargin) + r111.rightMargin;
    L35:
        if (this.h.getVisibility() != 0) goto L37;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
        int r8 = (this.h.getMeasuredWidth() + r112.leftMargin) + r112.rightMargin;
    L39:
        if (this.e.getVisibility() != 0) goto L41;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
        r0 = (this.e.getMeasuredWidth() + r113.leftMargin) + r113.rightMargin;
    L41:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
        int r9 = (this.a.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
        int r115 = getMeasuredWidth();
        int r10 = getMeasuredHeight();
        int r20 = ((((((((r115 - r4) - r6) - r2) - r14) - r3) - r5) - r7) - r8) - r0;
        if (r9 <= r20) goto L44;
        r9 = r20;
    L44:
        int r21 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
        int r22 = View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824);
        this.r.measure(r21, r22);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r115, 1073741824), View.MeasureSpec.makeMeasureSpec(r10, 1073741824));
        return;
    L37:
        r8 = 0;
        goto L39
    L33:
        r7 = 0;
        goto L35
    L29:
        r6 = 0;
        goto L31
    L25:
        r5 = 0;
        goto L27
    L21:
        r4 = 0;
        goto L23
    L17:
        r3 = 0;
        goto L19
    L13:
        r2 = 0;
        goto L15
    L9:
        r14 = 0;
        goto L11
    }

    public CustomTitleView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.b = false;
        com.bytedance.ee.util.ui.n.d(16);
        this.n = com.bytedance.ee.util.ui.n.h(getContext(), 2131106622);
        this.o = 1;
        this.p = new String[]{"", ".", "..", "..."};
        this.q = ValueAnimator.ofInt(new int[]{0, 4});
        c(r4, r5);
    }
}
