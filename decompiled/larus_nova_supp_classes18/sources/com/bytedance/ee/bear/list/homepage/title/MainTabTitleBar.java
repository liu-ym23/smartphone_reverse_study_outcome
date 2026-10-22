package com.bytedance.ee.bear.list.homepage.title;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import bd5.i;
import com.bytedance.ee.bear.facade.common.widget.RoundImageView;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MainTabTitleBar extends RelativeLayout implements b {
    public float a;
    public RoundImageView b;
    public AppCompatImageView c;
    public TextView d;
    public BaseTitleBar e;
    public Animator f;
    public boolean g;

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void b() {
        this.a = 0.0f;
        this.g = true;
        setAlpha(1.0f);
        setVisibility(0);
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public View getCreateView() {
        return null;
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleType() {
        return 0;
    }

    public void setCreateViewEnable(boolean r1) {
    }

    public /* bridge */ /* synthetic */ void setMoreViewClickListener(View.OnClickListener r1) {
    }

    public void setOnCreateViewClickListener(View.OnClickListener r1) {
    }

    public void setOnGridViewClickListener(HomeMainTitleBar.a r1) {
    }

    public void setShowBadgeDelegate(HomeMainTitleBar.b r1) {
    }

    public final void c() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) getResources().getDimension(2131167714)));
        setBackgroundColor(n.h(getContext(), 2131100548));
        RoundImageView r0 = new RoundImageView(getContext());
        this.b = r0;
        r0.setImageResource(2131235295);
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(n.d(32), n.d(32));
        r1.setMarginStart(n.d(16));
        r1.addRule(20);
        r1.addRule(15);
        addView(this.b, r1);
        AppCompatImageView r2 = new AppCompatImageView(getContext());
        this.c = r2;
        r2.setId(View.generateViewId());
        this.c.setImageResource(2131255617);
        l.c(this.c, 2131101926);
        RelativeLayout.LayoutParams r3 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        r3.setMarginEnd(n.d(16));
        r3.addRule(21);
        r3.addRule(15);
        addView(this.c, r3);
        BaseTitleBar r4 = new BaseTitleBar(getContext());
        this.e = r4;
        r4.setDividerVisible(false);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-2, -2);
        r5.addRule(13);
        addView(this.e, r5);
        TextView r6 = new TextView(getContext());
        this.d = r6;
        r6.setTextSize(2, 16.0f);
        this.d.setTextColor(getResources().getColor(2131105548));
        this.d.setText(getResources().getString(2131888692));
        this.d.setVisibility(8);
        this.d.setGravity(17);
        RelativeLayout.LayoutParams r7 = new RelativeLayout.LayoutParams(-2, -2);
        r7.setMarginEnd(n.d(16));
        r7.addRule(21);
        r7.addRule(15);
        addView(this.d, r7);
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(2131167714);
    }

    public Bitmap getTitleSnapshot() {
        return t0.q(this);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    public View getLeftView() {
        return this.b;
    }

    public MainTabTitleBar(Context r1) {
        super(r1);
        this.a = 0.0f;
        this.g = true;
        c();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r7) {
        this.a += r7;
        float r0 = getLayoutParams().height;
        tt5.a.b("MainTabTitleBar", "dy:" + r7 + ", mTotalDy:" + this.a + "height = " + r0);
        float r8 = this.a;
        float r2 = 0.0f;
        if (r8 <= r0) goto L6;
        this.a = r0;
    L9:
        if (((r0 - this.a) / r0) <= 0.1f) goto L11;
        boolean r9 = true;
    L12:
        tt5.a.b("MainTabTitleBar", "correct mTotalDy:" + this.a + "visible = " + r9);
        if (r9 == this.g) goto L29;
        Animator r1 = this.f;
        if (r1 == null) goto L18;
        r1.cancel();
    L18:
        this.g = r9;
        if (r9 == false) goto L21;
        setVisibility(0);
    L21:
        boolean r10 = this.g;
        if (r10 == false) goto L24;
        float r3 = 0.0f;
    L25:
        if (r10 == false) goto L27;
        r2 = 1.0f;
    L27:
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, "alpha", new float[]{r3, r2}).setDuration(200);
        this.f = r11;
        r11.start();
        this.f.addListener(new i(this));
        return;
    L24:
        r3 = 1.0f;
        goto L25
    L29:
        return;
    L11:
        r9 = false;
        goto L12
    L6:
        if (r8 >= 0.0f) goto L9;
        this.a = 0.0f;
        goto L9
    }

    public void setAllReadClickListener(View.OnClickListener r2) {
        TextView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public void setAllReadState(boolean r4) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 == false) goto L7;
        r0.setText(getResources().getString(2131888694));
        this.d.setTextColor(getResources().getColor(2131106610));
    L8:
        this.d.setClickable(!r4);
        return;
    L7:
        r0.setTextColor(getResources().getColor(2131105548));
        this.d.setText(getResources().getString(2131888692));
        goto L8
    }

    public void setAllReadVisible(boolean r2) {
        TextView r0 = this.d;
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

    public void setAvatarVisible(boolean r2) {
        RoundImageView r0 = this.b;
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

    public void setOnLeftViewClickListener(View.OnClickListener r2) {
        RoundImageView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public void setSearchViewClickListener(View.OnClickListener r2) {
        AppCompatImageView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public void setSearchVisible(boolean r2) {
        AppCompatImageView r0 = this.c;
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

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public void setTitle(String r2) {
        BaseTitleBar r0 = this.e;
        if (r0 == null) goto L6;
        r0.setTitle(r2);
        return;
    }

    public MainTabTitleBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 0.0f;
        this.g = true;
    }

    public MainTabTitleBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 0.0f;
        this.g = true;
    }
}
