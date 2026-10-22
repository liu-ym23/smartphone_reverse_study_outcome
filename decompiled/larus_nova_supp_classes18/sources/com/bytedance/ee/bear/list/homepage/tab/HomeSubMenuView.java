package com.bytedance.ee.bear.list.homepage.tab;

import ad5.b;
import ad5.c;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import net.lucode.hackware.magicindicator.MagicIndicator;
import tt5.a;
import wc5.f;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeSubMenuView extends LinearLayout implements f {
    public MagicIndicator a;
    public AppCompatImageView b;
    public AppCompatImageView c;
    public View d;
    public boolean e;
    public f.a f;
    public String g;
    public boolean h;
    public ObjectAnimator i;

    @Override // wc5.f
    public final void a(String r1) {
    }

    @Override // wc5.f
    public void setTitle(String r1) {
    }

    public final void d() {
        AppCompatImageView r0 = this.c;
        if (this.e == false) goto L5;
        int r1 = 2131254229;
    L6:
        r0.setImageResource(r1);
        return;
    L5:
        r1 = 2131253870;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.h("HomeSubMenuView", "onDetachedFromWindow()...");
        ObjectAnimator r0 = this.i;
        if (r0 == null) goto L6;
        r0.cancel();
        this.i = null;
        return;
    }

    public MagicIndicator getMagicIndicator() {
        return this.a;
    }

    public HomeSubMenuView(Context r2) {
        this(r2, null);
    }

    @Override // wc5.f
    public final void b(boolean r3) {
        a.h("HomeSubMenuView", "showGrid()...isGrid = " + r3);
        this.e = r3;
        d();
    }

    public final void e(String r3) {
        a.h("HomeSubMenuView", "showFilterDesc()...desc = " + r3);
        this.g = r3;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        SubMenuView.FilterState r4 = SubMenuView.FilterState.DEFAULT;
    L6:
        setFilterState(r4);
        return;
    L5:
        r4 = SubMenuView.FilterState.CHECKED;
        goto L6
    }

    @Override // wc5.f
    public void setFilterState(SubMenuView.FilterState r5) {
        int r2 = 2131102416;
        if (r5 != SubMenuView.FilterState.DEFAULT) goto L10;
        if (this.h == true) goto L8;
        r2 = 2131102419;
    L8:
        this.b.setBackgroundDrawable(null);
    L18:
        l.c(this.b, r2);
        return;
    L10:
        if (this.h == true) goto L13;
        r2 = 2131106273;
    L13:
        this.b.setBackgroundDrawable(getResources().getDrawable(2131243704, null));
        if (this.h == false) goto L16;
        int r6 = 2131106270;
    L17:
        l.b(this.b, r6);
        goto L18
    L16:
        r6 = 2131106271;
        goto L17
    }

    @Override // wc5.f
    public void setOffline(boolean r1) {
        this.h = r1;
        e(this.g);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r1) {
        this.f = r1;
    }

    public HomeSubMenuView(Context r5, AttributeSet r6) {
        super(r5, r6);
        this.e = false;
        setGravity(16);
        setOrientation(0);
        MagicIndicator r0 = new MagicIndicator(r5);
        this.a = r0;
        r0.setClipToPadding(false);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.leftMargin = n.d(6);
        addView(this.a, r1);
        this.d = new View(r5);
        ViewGroup.LayoutParams r2 = new LinearLayout.LayoutParams(0, -1);
        addView(this.d, r2);
        AppCompatImageView r7 = new AppCompatImageView(r5);
        this.b = r7;
        r7.setId(2131376241);
        this.b.setImageResource(2131254759);
        this.b.setImageTintList(ColorStateList.valueOf(getResources().getColor(2131102419)));
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(n.d(22), n.d(22));
        r8.leftMargin = n.d(20);
        addView(this.b, r8);
        int r9 = d.a(2);
        this.b.setPadding(r9, r9, r9, r9);
        AppCompatImageView r3 = new AppCompatImageView(r5);
        this.c = r3;
        r3.setId(2131376649);
        this.c.setImageTintList(ColorStateList.valueOf(getResources().getColor(2131102419)));
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(n.d(22), n.d(22));
        r10.leftMargin = n.d(20);
        r10.rightMargin = n.d(21);
        d();
        addView(this.c, r10);
        this.c.setPadding(r9, r9, r9, r9);
        this.b.setOnClickListener(new b(this));
        this.c.setOnClickListener(new c(this));
    }

    public final void c(AppCompatImageView r5, boolean r6) {
        ObjectAnimator r0 = this.i;
        if (r0 != null) goto L5;
    L8:
        float r1 = 1.0f;
        if (r6 == false) goto L11;
        float r2 = 0.0f;
    L12:
        if (r6 == true) goto L15;
        r1 = 0.0f;
    L15:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{r2, r1});
        this.i = r3;
        r3.setDuration(250);
        this.i.addListener(new ad5.a(r5, r6));
        this.i.start();
        return;
    L11:
        r2 = 1.0f;
        goto L12
    L5:
        if (r0.isRunning() == false) goto L7;
        this.i.cancel();
    L7:
        this.i = null;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L7;
        measureChildWithMargins(getChildAt(r1), r10, 0, r11, 0);
        r1 = r1 + 1;
        goto L4
    L7:
        if (this.c.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        int r13 = (this.c.getMeasuredWidth() + r12.leftMargin) + r12.rightMargin;
    L11:
        if (this.b.getVisibility() != 0) goto L13;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
        int r2 = (this.b.getMeasuredWidth() + r14.leftMargin) + r14.rightMargin;
    L15:
        if (this.a.getVisibility() != 0) goto L17;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
        int r3 = (this.a.getMeasuredWidth() + r15.leftMargin) + r15.rightMargin;
    L18:
        int r16 = getMeasuredWidth();
        int r4 = getMeasuredHeight();
        int r17 = (r16 - r13) - r2;
        if (r3 <= r17) goto L21;
        r3 = r17;
    L22:
        int r5 = View.MeasureSpec.makeMeasureSpec(r3, 1073741824);
        int r6 = View.MeasureSpec.makeMeasureSpec(this.a.getMeasuredHeight(), 1073741824);
        this.a.measure(r5, r6);
        int r7 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r8 = View.MeasureSpec.makeMeasureSpec(this.d.getMeasuredHeight(), 1073741824);
        this.d.measure(r7, r8);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r16, 1073741824), View.MeasureSpec.makeMeasureSpec(r4, 1073741824));
        return;
    L21:
        r0 = r17 - r3;
        goto L22
    L17:
        r3 = 0;
        goto L18
    L13:
        r2 = 0;
        goto L15
    L9:
        r13 = 0;
        goto L11
    }
}
