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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class MainTabTitleBar extends RelativeLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f228375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RoundImageView f228376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f228377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f228378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f228379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f228380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f228381g;

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void b() {
        this.f228375a = 0.0f;
        this.f228381g = true;
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

    public void setCreateViewEnable(boolean r100) {
    }

    public /* bridge */ /* synthetic */ void setMoreViewClickListener(View.OnClickListener r100) {
    }

    public void setOnCreateViewClickListener(View.OnClickListener r100) {
    }

    public void setOnGridViewClickListener(HomeMainTitleBar.a r100) {
    }

    public void setShowBadgeDelegate(HomeMainTitleBar.b r100) {
    }

    public final void c() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.list_home_title_bar_height_min)));
        setBackgroundColor(n.h(getContext(), R.color.bg_body));
        RoundImageView r100 = new RoundImageView(getContext());
        this.f228376b = r100;
        r100.setImageResource(R.drawable.facade_common_avatar_place_holder);
        RelativeLayout.LayoutParams r101 = new RelativeLayout.LayoutParams(n.d(32), n.d(32));
        r101.setMarginStart(n.d(16));
        r101.addRule(20);
        r101.addRule(15);
        addView(this.f228376b, r101);
        AppCompatImageView r102 = new AppCompatImageView(getContext());
        this.f228377c = r102;
        r102.setId(View.generateViewId());
        this.f228377c.setImageResource(R.drawable.ud_icon_search_outlined);
        l.c(this.f228377c, R.color.facade_selector_icon_n1);
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(n.d(24), n.d(24));
        r103.setMarginEnd(n.d(16));
        r103.addRule(21);
        r103.addRule(15);
        addView(this.f228377c, r103);
        BaseTitleBar r104 = new BaseTitleBar(getContext());
        this.f228379e = r104;
        r104.setDividerVisible(false);
        RelativeLayout.LayoutParams r105 = new RelativeLayout.LayoutParams(-2, -2);
        r105.addRule(13);
        addView(this.f228379e, r105);
        TextView r106 = new TextView(getContext());
        this.f228378d = r106;
        r106.setTextSize(2, 16.0f);
        this.f228378d.setTextColor(getResources().getColor(R.color.primary_fill_default));
        this.f228378d.setText(getResources().getString(R.string.FeishuDocs_ClickToRead_Button));
        this.f228378d.setVisibility(8);
        this.f228378d.setGravity(17);
        RelativeLayout.LayoutParams r107 = new RelativeLayout.LayoutParams(-2, -2);
        r107.setMarginEnd(n.d(16));
        r107.addRule(21);
        r107.addRule(15);
        addView(this.f228378d, r107);
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public int getTitleBarHeight() {
        return getResources().getDimensionPixelSize(R.dimen.list_home_title_bar_height_min);
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
        return this.f228376b;
    }

    public MainTabTitleBar(Context r100) {
        super(r100);
        this.f228375a = 0.0f;
        this.f228381g = true;
        c();
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public final void a(int r100) {
        this.f228375a += r100;
        float r101 = getLayoutParams().height;
        tt5.a.b("MainTabTitleBar", "dy:" + r100 + ", mTotalDy:" + this.f228375a + "height = " + r101);
        float r102 = this.f228375a;
        float r103 = 0.0f;
        if (r102 <= r101) goto L6;
        this.f228375a = r101;
    L9:
        if (((r101 - this.f228375a) / r101) <= 0.1f) goto L11;
        boolean r104 = true;
    L12:
        tt5.a.b("MainTabTitleBar", "correct mTotalDy:" + this.f228375a + "visible = " + r104);
        if (r104 == this.f228381g) goto L29;
        Animator r105 = this.f228380f;
        if (r105 == null) goto L18;
        r105.cancel();
    L18:
        this.f228381g = r104;
        if (r104 == false) goto L21;
        setVisibility(0);
    L21:
        boolean r106 = this.f228381g;
        if (r106 == false) goto L24;
        float r107 = 0.0f;
    L25:
        if (r106 == false) goto L27;
        r103 = 1.0f;
    L27:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(this, "alpha", new float[]{r107, r103}).setDuration(200);
        this.f228380f = r108;
        r108.start();
        this.f228380f.addListener(new i(this));
        return;
    L24:
        r107 = 1.0f;
        goto L25
    L29:
        return;
    L11:
        r104 = false;
        goto L12
    L6:
        if (r102 >= 0.0f) goto L9;
        this.f228375a = 0.0f;
        goto L9
    }

    public void setAllReadClickListener(View.OnClickListener r100) {
        TextView r101 = this.f228378d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setAllReadState(boolean r100) {
        TextView r101 = this.f228378d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r101.setText(getResources().getString(R.string.FeishuDocs_MarkAllRead_Button));
        this.f228378d.setTextColor(getResources().getColor(R.color.text_disable));
    L8:
        this.f228378d.setClickable(!r100);
        return;
    L7:
        r101.setTextColor(getResources().getColor(R.color.primary_fill_default));
        this.f228378d.setText(getResources().getString(R.string.FeishuDocs_ClickToRead_Button));
        goto L8
    }

    public void setAllReadVisible(boolean r100) {
        TextView r101 = this.f228378d;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public void setAvatarVisible(boolean r100) {
        RoundImageView r101 = this.f228376b;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public void setOnLeftViewClickListener(View.OnClickListener r100) {
        RoundImageView r101 = this.f228376b;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setSearchViewClickListener(View.OnClickListener r100) {
        AppCompatImageView r101 = this.f228377c;
        if (r101 == null) goto L6;
        r101.setOnClickListener(r100);
        return;
    }

    public void setSearchVisible(boolean r100) {
        AppCompatImageView r101 = this.f228377c;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.homepage.title.b
    public void setTitle(String r100) {
        BaseTitleBar r101 = this.f228379e;
        if (r101 == null) goto L6;
        r101.setTitle(r100);
        return;
    }

    public MainTabTitleBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f228375a = 0.0f;
        this.f228381g = true;
    }

    public MainTabTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f228375a = 0.0f;
        this.f228381g = true;
    }
}
