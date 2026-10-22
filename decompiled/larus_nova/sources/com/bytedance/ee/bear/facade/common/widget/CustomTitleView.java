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
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;

/* JADX INFO: loaded from: classes16.dex */
public class CustomTitleView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f226452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f226453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f226454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExternalView f226455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CacTagView f226456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OwnerTagView f226457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PublicTagView f226458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TemplateTagView f226459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f226460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f226461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f226462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f226463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f226464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f226465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f226466o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String[] f226467p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ValueAnimator f226468q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CustomTitleLayout f226469r;

    public boolean getExternalVisible() {
        if (this.f226455d.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getStarVisible() {
        if (this.f226460i.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getTitleVisible() {
        if (this.f226452a.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f226468q;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public ImageView getIconView() {
        return this.f226461j;
    }

    public CharSequence getTitle() {
        return this.f226463l;
    }

    public CustomTitleLayout getTitleLayout() {
        return this.f226469r;
    }

    public CustomTitleView(Context r100) {
        super(r100);
        this.f226453b = false;
        com.bytedance.ee.util.ui.n.d(16);
        this.f226465n = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        this.f226466o = 1;
        this.f226467p = new String[]{"", ".", DownloadConstants.VULNERABILITY_PATH, "..."};
        this.f226468q = ValueAnimator.ofInt(new int[]{0, 4});
        c(r100, null);
    }

    private void setFirstTitle(CharSequence r100) {
        this.f226452a.setText(r100);
        if (this.f226453b == false) goto L13;
        int r101 = 0;
        if ((!TextUtils.isEmpty(this.f226454c.getText())) == false) goto L11;
        TextView r102 = this.f226452a;
        if (TextUtils.isEmpty(r100) == false) goto L10;
        r101 = 8;
    L10:
        r102.setVisibility(r101);
        return;
    L11:
        this.f226452a.setVisibility(0);
        return;
    }

    public void setCacTagVisible(boolean r100) {
        CacTagView r101 = this.f226456e;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setExternalTagEnabled(boolean r100) {
        if (r100 == false) goto L4;
        addView(this.f226455d);
        return;
    L4:
        removeView(this.f226455d);
    }

    public void setExternalVisible(boolean r100) {
        ExternalView r101 = this.f226455d;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setOwnerTagVisible(boolean r100) {
        OwnerTagView r101 = this.f226457f;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setPublicVisible(boolean r100) {
        PublicTagView r101 = this.f226458g;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setSecondTitle(CharSequence r100) {
        TextView r101 = this.f226454c;
        if (r101 == null) goto L16;
        r101.setText(r100);
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (this.f226452a.getText() == null) goto L18;
        CharSequence r102 = this.f226452a.getText();
        int r103 = 8;
        if (this.f226453b == false) goto L14;
        TextView r104 = this.f226452a;
        if (TextUtils.isEmpty(r102) == true) goto L13;
        r103 = 0;
    L13:
        r104.setVisibility(r103);
        return;
    L14:
        this.f226452a.setVisibility(8);
        return;
    L18:
        return;
    }

    public void setSecondTitleLeftDrawable(Drawable r100) {
        if (this.f226454c == null) goto L6;
        r100.setBounds(0, 0, y9c.d.a(15), y9c.d.a(15));
        this.f226454c.setCompoundDrawables(r100, null, null, null);
        return;
    }

    public void setSecondTitleVisibility(boolean r100) {
        if (r100 == false) goto L4;
        this.f226454c.setVisibility(0);
        return;
    L4:
        this.f226454c.setVisibility(8);
    }

    public void setStarVisible(boolean r100) {
        ImageView r101 = this.f226460i;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setTemplateTagVisible(boolean r100) {
        TemplateTagView r101 = this.f226459h;
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

    public void setTipsClickListener(View.OnClickListener r100) {
        this.f226462k.setOnClickListener(r100);
    }

    public void setTipsIcon(int r100) {
        this.f226462k.setBackground(com.bytedance.ee.util.ui.n.k(getContext(), r100));
    }

    public void setTipsVisible(boolean r100) {
        ImageView r101 = this.f226462k;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setTitle(int r100) {
        String r101 = getResources().getString(r100);
        this.f226463l = r101;
        setFirstTitle(r101);
        if (this.f226468q.isRunning() == false) goto L6;
        this.f226468q.cancel();
        return;
    }

    public void setTitleSize(float r100) {
        this.f226452a.setTextSize(r100);
    }

    public void setTitleTextBold(boolean r100) {
        this.f226452a.getPaint().setFakeBoldText(r100);
    }

    public void setTitleTextColor(int r100) {
        this.f226452a.setTextColor(getResources().getColor(r100));
    }

    public void setTitleTextSize(int r100) {
        this.f226452a.setTextSize(0, a08.b.a(getResources().getDimension(r100), getContext()));
    }

    public void setTitleVisible(boolean r100) {
        TextView r101 = this.f226452a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        this.f226453b = r100;
        if (r100 == true) goto L9;
    L11:
        this.f226461j.setVisibility(8);
    L12:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) this.f226455d.getLayoutParams();
        if (r100 == false) goto L15;
        r103.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        return;
    L15:
        r103.leftMargin = 0;
        return;
    L9:
        if (this.f226461j.getDrawable() == null) goto L11;
        this.f226461j.setVisibility(0);
        goto L12
    L5:
        r102 = 8;
        goto L6
    }

    public void setTitle(CharSequence r100) {
        this.f226463l = r100;
        setFirstTitle(r100);
        if (this.f226468q.isRunning() == false) goto L6;
        this.f226468q.cancel();
        return;
    }

    public CustomTitleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f226453b = false;
        com.bytedance.ee.util.ui.n.d(16);
        this.f226465n = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        this.f226466o = 1;
        this.f226467p = new String[]{"", ".", DownloadConstants.VULNERABILITY_PATH, "..."};
        this.f226468q = ValueAnimator.ofInt(new int[]{0, 4});
        c(r100, r101);
    }

    public static /* synthetic */ void a(CustomTitleView r100, ValueAnimator r101) {
        r100.getClass();
        r100.setFirstTitle(r100.getResources().getString(R.string.Doc_Widget_LoadingWithoutEllipsis) + r100.f226467p[((Integer) r101.getAnimatedValue()).intValue() % r100.f226467p.length]);
    }

    public static /* synthetic */ void b(CustomTitleView r100, CharSequence r101) {
        r100.setFirstTitle(r101);
    }

    public final void c(Context r110, AttributeSet r111) {
        this.f226465n = getResources().getColor(R.color.text_title);
        if (r111 == null) goto L5;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.titleColor, R.attr.titleMaxLines, R.attr.titleSize, R.attr.titleTagInterval, R.attr.titleTagMargin, R.attr.titleText});
        this.f226463l = r112.getString(5);
        r112.getDimension(2, getResources().getDimension(R.dimen.facade_title_text_size));
        this.f226465n = r112.getColor(0, getResources().getColor(R.color.text_title));
        this.f226466o = r112.getInt(1, 1);
        r112.recycle();
    L5:
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r113 = new LinearLayout.LayoutParams(-2, -2);
        r113.gravity = 17;
        r113.width = getResources().getDimensionPixelSize(R.dimen.facade_icon_size);
        r113.height = getResources().getDimensionPixelSize(R.dimen.facade_icon_size);
        r113.rightMargin = getResources().getDimensionPixelSize(R.dimen.facade_icon_margin_right);
        ImageView r100 = new ImageView(r110);
        this.f226461j = r100;
        r100.setVisibility(8);
        addView(this.f226461j, r113);
        ViewGroup.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        CustomTitleLayout r101 = new CustomTitleLayout(r110);
        this.f226469r = r101;
        addView(r101, r114);
        CustomTitleLayout r115 = this.f226469r;
        this.f226452a = r115.f226450c;
        this.f226454c = r115.f226451d;
        if (TextUtils.isEmpty(this.f226463l) == true) goto L9;
        setFirstTitle(this.f226463l);
    L9:
        if (this.f226466o != 1) goto L11;
        this.f226452a.setSingleLine(true);
    L12:
        this.f226468q.addUpdateListener(new a(this));
        this.f226468q.addListener(new b(this));
        this.f226468q.setDuration(500);
        this.f226468q.setRepeatCount(-1);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
        r116.gravity = 17;
        TextView r102 = new TextView(r110);
        this.f226464m = r102;
        r102.setPadding(y9c.d.a(2), 0, 0, 0);
        this.f226464m.setTextSize(2, 16.0f);
        this.f226464m.setTextColor(this.f226465n);
        this.f226464m.setVisibility(8);
        addView(this.f226464m, r116);
        LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-2, -2);
        r117.gravity = 17;
        r117.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        ExternalView r103 = new ExternalView(r110);
        this.f226455d = r103;
        r103.setVisibility(8);
        addView(this.f226455d, r117);
        LinearLayout.LayoutParams r118 = new LinearLayout.LayoutParams(-2, -2);
        r118.gravity = 17;
        r118.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        PublicTagView r104 = new PublicTagView(r110);
        this.f226458g = r104;
        r104.setVisibility(8);
        addView(this.f226458g, r118);
        LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(-2, -2);
        r119.gravity = 17;
        r119.width = getResources().getDimensionPixelSize(R.dimen.facade_star_view_edge);
        r119.height = getResources().getDimensionPixelSize(R.dimen.facade_star_view_edge);
        r119.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        ImageView r105 = new ImageView(r110);
        this.f226460i = r105;
        r105.setBackground(com.bytedance.ee.util.ui.n.k(r110, R.drawable.ud_icon_collect_filled));
        com.bytedance.ee.util.ui.l.b(this.f226460i, R.color.colorful_yellow);
        this.f226460i.setVisibility(8);
        addView(this.f226460i, r119);
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(-2, -2);
        r120.gravity = 17;
        r120.width = getResources().getDimensionPixelSize(R.dimen.facade_star_view_edge);
        r120.height = getResources().getDimensionPixelSize(R.dimen.facade_star_view_edge);
        ImageView r106 = new ImageView(r110);
        this.f226462k = r106;
        r106.setBackground(getResources().getDrawable(R.drawable.ic_icon_tool_guide_nor));
        com.bytedance.ee.util.ui.l.b(this.f226462k, R.color.icon_n2);
        this.f226462k.setVisibility(8);
        addView(this.f226462k, r120);
        LinearLayout.LayoutParams r121 = new LinearLayout.LayoutParams(-2, -2);
        r121.gravity = 17;
        r121.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        OwnerTagView r107 = new OwnerTagView(r110);
        this.f226457f = r107;
        r107.setVisibility(8);
        addView(this.f226457f, r121);
        LinearLayout.LayoutParams r122 = new LinearLayout.LayoutParams(-2, -2);
        r122.gravity = 17;
        r122.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        TemplateTagView r108 = new TemplateTagView(r110);
        this.f226459h = r108;
        r108.setVisibility(8);
        addView(this.f226459h, r122);
        LinearLayout.LayoutParams r123 = new LinearLayout.LayoutParams(-2, -2);
        r123.gravity = 17;
        r123.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        CacTagView r109 = new CacTagView(r110);
        this.f226456e = r109;
        r109.setVisibility(8);
        addView(this.f226456e, r123);
        return;
    L11:
        this.f226452a.setSingleLine(false);
        this.f226452a.setMaxLines(this.f226466o);
        goto L12
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L7;
        measureChildWithMargins(getChildAt(r101), r110, 0, r111, 0);
        r101 = r101 + 1;
        goto L4
    L7:
        if (this.f226461j.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) this.f226461j.getLayoutParams();
        int r113 = (this.f226461j.getMeasuredWidth() + r112.leftMargin) + r112.rightMargin;
    L11:
        if (this.f226460i.getVisibility() != 0) goto L13;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) this.f226460i.getLayoutParams();
        int r102 = (this.f226460i.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
    L15:
        if (this.f226462k.getVisibility() != 0) goto L17;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) this.f226462k.getLayoutParams();
        int r103 = (this.f226462k.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin;
    L19:
        if (this.f226455d.getVisibility() != 0) goto L21;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) this.f226455d.getLayoutParams();
        int r104 = (this.f226455d.getMeasuredWidth() + r116.leftMargin) + r116.rightMargin;
    L23:
        if (this.f226457f.getVisibility() != 0) goto L25;
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) this.f226457f.getLayoutParams();
        int r105 = (this.f226457f.getMeasuredWidth() + r117.leftMargin) + r117.rightMargin;
    L27:
        if (this.f226458g.getVisibility() != 0) goto L29;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) this.f226458g.getLayoutParams();
        int r106 = (this.f226458g.getMeasuredWidth() + r118.leftMargin) + r118.rightMargin;
    L31:
        if (this.f226464m.getVisibility() != 0) goto L33;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) this.f226464m.getLayoutParams();
        int r107 = (this.f226464m.getMeasuredWidth() + r119.leftMargin) + r119.rightMargin;
    L35:
        if (this.f226459h.getVisibility() != 0) goto L37;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) this.f226459h.getLayoutParams();
        int r108 = (this.f226459h.getMeasuredWidth() + r120.leftMargin) + r120.rightMargin;
    L39:
        if (this.f226456e.getVisibility() != 0) goto L41;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) this.f226456e.getLayoutParams();
        r100 = (this.f226456e.getMeasuredWidth() + r121.leftMargin) + r121.rightMargin;
    L41:
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) this.f226452a.getLayoutParams();
        int r109 = (this.f226452a.getMeasuredWidth() + r122.leftMargin) + r122.rightMargin;
        int r123 = getMeasuredWidth();
        int r124 = getMeasuredHeight();
        int r125 = ((((((((r123 - r104) - r106) - r102) - r113) - r103) - r105) - r107) - r108) - r100;
        if (r109 <= r125) goto L44;
        r109 = r125;
    L44:
        int r126 = View.MeasureSpec.makeMeasureSpec(r109, 1073741824);
        int r127 = View.MeasureSpec.makeMeasureSpec(this.f226452a.getMeasuredHeight(), 1073741824);
        this.f226469r.measure(r126, r127);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r123, 1073741824), View.MeasureSpec.makeMeasureSpec(r124, 1073741824));
        return;
    L37:
        r108 = 0;
        goto L39
    L33:
        r107 = 0;
        goto L35
    L29:
        r106 = 0;
        goto L31
    L25:
        r105 = 0;
        goto L27
    L21:
        r104 = 0;
        goto L23
    L17:
        r103 = 0;
        goto L19
    L13:
        r102 = 0;
        goto L15
    L9:
        r113 = 0;
        goto L11
    }

    public CustomTitleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f226453b = false;
        com.bytedance.ee.util.ui.n.d(16);
        this.f226465n = com.bytedance.ee.util.ui.n.h(getContext(), R.color.text_title);
        this.f226466o = 1;
        this.f226467p = new String[]{"", ".", DownloadConstants.VULNERABILITY_PATH, "..."};
        this.f226468q = ValueAnimator.ofInt(new int[]{0, 4});
        c(r100, r101);
    }
}
