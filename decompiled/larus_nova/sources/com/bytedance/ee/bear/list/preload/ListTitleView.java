package com.bytedance.ee.bear.list.preload;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.PublicTagView;
import com.bytedance.ee.bear.widgets.TemplateTagView;
import com.bytedance.ee.bear.widgets.UpgradeTagView;
import com.bytedance.ee.bear.widgets.crosstenant.ExternalView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceTagTextView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ListTitleView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f229172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ExternalView f229173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UpgradeTagView f229174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PublicTagView f229175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TemplateTagView f229176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f229177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f229178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f229179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f229180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SpaceTagTextView f229181j;

    public boolean getExternalVisible() {
        ExternalView r100 = this.f229173b;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getPublicVisible() {
        PublicTagView r100 = this.f229175d;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getSharedVisible() {
        SpaceTagTextView r100 = this.f229181j;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getStarVisible() {
        ImageView r100 = this.f229177f;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public boolean getUpgradeVisible() {
        UpgradeTagView r100 = this.f229174c;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        return true;
    }

    public CharSequence getTitle() {
        return this.f229178g;
    }

    public ListTitleView(Context r100) {
        super(r100);
        n.d(16);
        this.f229180i = 1;
        a(r100, null);
    }

    public void setExternalVisible(boolean r100) {
        ExternalView r101 = this.f229173b;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == true) goto L7;
        r102 = 8;
    L7:
        r101.setVisibility(r102);
        return;
    L8:
        if (r100 == false) goto L15;
        Context r103 = getContext();
        if (this.f229173b != null) goto L12;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        r104.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        ExternalView r105 = new ExternalView(r103);
        this.f229173b = r105;
        r105.setVisibility(8);
        addView(this.f229173b, r104);
    L12:
        this.f229173b.setVisibility(0);
        return;
    }

    public void setPublicVisible(boolean r100) {
        Context r101 = getContext();
        int r102 = 8;
        if (this.f229175d != null) goto L5;
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        r103.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        PublicTagView r104 = new PublicTagView(r101);
        this.f229175d = r104;
        r104.setVisibility(8);
        addView(this.f229175d, r103);
    L5:
        PublicTagView r105 = this.f229175d;
        if (r100 == false) goto L8;
        r102 = 0;
    L8:
        r105.setVisibility(r102);
    }

    public void setSharedVisible(boolean r100) {
        Context r101 = getContext();
        int r102 = 8;
        if (this.f229181j != null) goto L5;
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        r103.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        SpaceTagTextView r104 = new SpaceTagTextView(getContext());
        this.f229181j = r104;
        UDTagsDrawable.d.a r105 = new UDTagsDrawable.d.a(r101);
        r105.f285353c = getContext().getString(R.string.LarkCCM_Wiki_PublishWorkspace_Tag_External_Mob);
        r105.c(UDTagsDrawable.TagColorSet.BLUE);
        r104.y(r105.b());
        this.f229181j.setVisibility(8);
        addView(this.f229181j, r103);
    L5:
        SpaceTagTextView r106 = this.f229181j;
        if (r100 == false) goto L8;
        r102 = 0;
    L8:
        r106.setVisibility(r102);
    }

    public void setStarVisible(boolean r100) {
        ImageView r101 = this.f229177f;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == true) goto L7;
        r102 = 8;
    L7:
        r101.setVisibility(r102);
        return;
    L8:
        if (r100 == false) goto L15;
        Context r103 = getContext();
        if (this.f229177f != null) goto L12;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        r104.width = getResources().getDimensionPixelSize(R.dimen.facade_star_view_edge);
        r104.height = getResources().getDimensionPixelSize(R.dimen.facade_star_view_edge);
        r104.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        ImageView r105 = new ImageView(r103);
        this.f229177f = r105;
        r105.setBackground(getResources().getDrawable(R.drawable.ud_icon_collect_filled));
        l.b(this.f229177f, R.color.colorful_yellow);
        this.f229177f.setVisibility(8);
        addView(this.f229177f, r104);
    L12:
        this.f229177f.setVisibility(0);
        return;
    }

    public void setTemplateVisible(boolean r100) {
        TemplateTagView r101 = this.f229176e;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == true) goto L7;
        r102 = 8;
    L7:
        r101.setVisibility(r102);
        return;
    L8:
        if (r100 == false) goto L15;
        Context r103 = getContext();
        if (this.f229176e != null) goto L12;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        r104.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        TemplateTagView r105 = new TemplateTagView(r103);
        this.f229176e = r105;
        r105.setVisibility(8);
        addView(this.f229176e, r104);
    L12:
        this.f229176e.setVisibility(0);
        return;
    }

    public void setTitle(int r100) {
        String r101 = getResources().getString(r100);
        this.f229178g = r101;
        this.f229172a.setText(r101);
    }

    public void setTitleColor(int r100) {
        this.f229172a.setTextColor(r100);
    }

    public void setTitleMaxLines(int r100) {
        if (r100 != 1) goto L5;
        this.f229172a.setSingleLine(true);
        this.f229172a.setMaxLines(1);
        return;
    L5:
        this.f229172a.setSingleLine(false);
        this.f229172a.setMaxLines(r100);
    }

    public void setTitleSize(float r100) {
        this.f229172a.setTextSize(r100);
    }

    public void setUpgradeVisible(boolean r100) {
        UpgradeTagView r101 = this.f229174c;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == true) goto L7;
        r102 = 8;
    L7:
        r101.setVisibility(r102);
        return;
    L8:
        if (r100 == false) goto L15;
        Context r103 = getContext();
        if (this.f229174c != null) goto L12;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        r104.leftMargin = getResources().getDimensionPixelSize(R.dimen.facade_star_view_margin_left);
        UpgradeTagView r105 = new UpgradeTagView(r103);
        this.f229174c = r105;
        r105.setVisibility(8);
        addView(this.f229174c, r104);
    L12:
        this.f229174c.setVisibility(0);
        return;
    }

    public void setTitle(CharSequence r100) {
        this.f229178g = r100;
        this.f229172a.setText(r100);
    }

    public ListTitleView(Context r100, AttributeSet r101) {
        super(r100, r101);
        n.d(16);
        this.f229180i = 1;
        a(r100, r101);
    }

    public final void a(Context r100, AttributeSet r101) {
        this.f229179h = r100.getResources().getColor(R.color.text_title);
        if (r101 == null) goto L5;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.titleColor, R.attr.titleMaxLines, R.attr.titleSize, R.attr.titleTagInterval, R.attr.titleTagMargin, R.attr.titleText});
        this.f229178g = r102.getString(5);
        r102.getDimension(2, getResources().getDimension(R.dimen.facade_title_text_size));
        this.f229179h = r102.getColor(0, getResources().getColor(R.color.text_title));
        this.f229180i = r102.getInt(1, 1);
        r102.recycle();
    L5:
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        TextView r104 = new TextView(r100);
        this.f229172a = r104;
        r104.setEllipsize(TextUtils.TruncateAt.END);
        this.f229172a.setGravity(16);
        this.f229172a.setTextSize(2, 16.0f);
        this.f229172a.setTextColor(this.f229179h);
        if (TextUtils.isEmpty(this.f229178g) == true) goto L9;
        this.f229172a.setText(this.f229178g);
    L9:
        if (this.f229180i != 1) goto L11;
        this.f229172a.setSingleLine(true);
    L12:
        addView(this.f229172a, r103);
        return;
    L11:
        this.f229172a.setSingleLine(false);
        this.f229172a.setMaxLines(this.f229180i);
        goto L12
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L6;
        measureChildWithMargins(getChildAt(r101), r110, 0, r111, 0);
        r101 = r101 + 1;
        goto L4
    L6:
        ImageView r112 = this.f229177f;
        if (r112 != null) goto L9;
    L11:
        int r113 = 0;
    L12:
        ExternalView r114 = this.f229173b;
        if (r114 != null) goto L15;
    L17:
        int r102 = 0;
    L18:
        UpgradeTagView r115 = this.f229174c;
        if (r115 != null) goto L21;
    L23:
        int r103 = 0;
    L24:
        PublicTagView r116 = this.f229175d;
        if (r116 != null) goto L27;
    L29:
        int r104 = 0;
    L30:
        SpaceTagTextView r117 = this.f229181j;
        if (r117 != null) goto L33;
    L35:
        int r105 = 0;
    L36:
        TemplateTagView r118 = this.f229176e;
        if (r118 != null) goto L39;
    L41:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) this.f229172a.getLayoutParams();
        int r106 = (this.f229172a.getMeasuredWidth() + r119.leftMargin) + r119.rightMargin;
        int r120 = getMeasuredWidth();
        int r107 = getMeasuredHeight();
        int r108 = (((((r120 - r102) - r103) - r104) - r113) - r100) - r105;
        if (r106 <= r108) goto L44;
        r106 = r108;
    L44:
        int r109 = View.MeasureSpec.makeMeasureSpec(r106, 1073741824);
        int r121 = View.MeasureSpec.makeMeasureSpec(this.f229172a.getMeasuredHeight(), 1073741824);
        this.f229172a.measure(r109, r121);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r120, 1073741824), View.MeasureSpec.makeMeasureSpec(r107, 1073741824));
        return;
    L39:
        if (r118.getVisibility() != 0) goto L41;
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) this.f229176e.getLayoutParams();
        r100 = (this.f229176e.getMeasuredWidth() + r122.leftMargin) + r122.rightMargin;
        goto L41
    L33:
        if (r117.getVisibility() != 0) goto L35;
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) this.f229181j.getLayoutParams();
        r105 = (this.f229181j.getMeasuredWidth() + r123.leftMargin) + r123.rightMargin;
        goto L36
    L27:
        if (r116.getVisibility() != 0) goto L29;
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) this.f229175d.getLayoutParams();
        r104 = (this.f229175d.getMeasuredWidth() + r124.leftMargin) + r124.rightMargin;
        goto L30
    L21:
        if (r115.getVisibility() != 0) goto L23;
        ViewGroup.MarginLayoutParams r125 = (ViewGroup.MarginLayoutParams) this.f229174c.getLayoutParams();
        r103 = (this.f229174c.getMeasuredWidth() + r125.leftMargin) + r125.rightMargin;
        goto L24
    L15:
        if (r114.getVisibility() != 0) goto L17;
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) this.f229173b.getLayoutParams();
        r102 = (this.f229173b.getMeasuredWidth() + r126.leftMargin) + r126.rightMargin;
        goto L18
    L9:
        if (r112.getVisibility() != 0) goto L11;
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) this.f229177f.getLayoutParams();
        r113 = (this.f229177f.getMeasuredWidth() + r127.leftMargin) + r127.rightMargin;
        goto L12
    }

    public ListTitleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        n.d(16);
        this.f229180i = 1;
        a(r100, r101);
    }
}
