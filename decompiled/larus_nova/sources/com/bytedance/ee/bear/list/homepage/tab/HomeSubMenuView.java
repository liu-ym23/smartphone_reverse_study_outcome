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
import com.larus.nova.R;
import net.lucode.hackware.magicindicator.MagicIndicator;
import tt5.a;
import wc5.f;
import y9c.d;

/* JADX INFO: loaded from: classes18.dex */
public class HomeSubMenuView extends LinearLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MagicIndicator f228330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f228331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f228332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f228333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f228334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f.a f228335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f228336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f228337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObjectAnimator f228338i;

    @Override // wc5.f
    public final void a(String r100) {
    }

    @Override // wc5.f
    public void setTitle(String r100) {
    }

    public final void d() {
        AppCompatImageView r100 = this.f228332c;
        if (this.f228334e == false) goto L5;
        int r101 = R.drawable.ud_icon_disorder_list_outlined;
    L6:
        r100.setImageResource(r101);
        return;
    L5:
        r101 = R.drawable.ud_icon_borders_outlined;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.h("HomeSubMenuView", "onDetachedFromWindow()...");
        ObjectAnimator r100 = this.f228338i;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f228338i = null;
        return;
    }

    public MagicIndicator getMagicIndicator() {
        return this.f228330a;
    }

    public HomeSubMenuView(Context r100) {
        this(r100, null);
    }

    @Override // wc5.f
    public final void b(boolean r100) {
        a.h("HomeSubMenuView", "showGrid()...isGrid = " + r100);
        this.f228334e = r100;
        d();
    }

    public final void e(String r100) {
        a.h("HomeSubMenuView", "showFilterDesc()...desc = " + r100);
        this.f228336g = r100;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        SubMenuView.FilterState r101 = SubMenuView.FilterState.DEFAULT;
    L6:
        setFilterState(r101);
        return;
    L5:
        r101 = SubMenuView.FilterState.CHECKED;
        goto L6
    }

    @Override // wc5.f
    public void setFilterState(SubMenuView.FilterState r100) {
        SubMenuView.FilterState r101 = SubMenuView.FilterState.DEFAULT;
        int r102 = R.color.icon_disable;
        if (r100 != r101) goto L10;
        if (this.f228337h == true) goto L8;
        r102 = R.color.icon_n2;
    L8:
        this.f228331b.setBackgroundDrawable(null);
    L18:
        l.c(this.f228331b, r102);
        return;
    L10:
        if (this.f228337h == true) goto L13;
        r102 = R.color.space_list_icon_filter_blue;
    L13:
        this.f228331b.setBackgroundDrawable(getResources().getDrawable(R.drawable.list_filter_icon_offline_bg, null));
        if (this.f228337h == false) goto L16;
        int r103 = R.color.space_list_bg_filter_icon_offline;
    L17:
        l.b(this.f228331b, r103);
        goto L18
    L16:
        r103 = R.color.space_list_bg_filter_icon_selected;
        goto L17
    }

    @Override // wc5.f
    public void setOffline(boolean r100) {
        this.f228337h = r100;
        e(this.f228336g);
    }

    @Override // wc5.f
    public void setViewDelegate(f.a r100) {
        this.f228335f = r100;
    }

    public HomeSubMenuView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f228334e = false;
        setGravity(16);
        setOrientation(0);
        MagicIndicator r102 = new MagicIndicator(r100);
        this.f228330a = r102;
        r102.setClipToPadding(false);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.leftMargin = n.d(6);
        addView(this.f228330a, r103);
        this.f228333d = new View(r100);
        ViewGroup.LayoutParams r104 = new LinearLayout.LayoutParams(0, -1);
        addView(this.f228333d, r104);
        AppCompatImageView r105 = new AppCompatImageView(r100);
        this.f228331b = r105;
        r105.setId(R.id.iv_filter);
        this.f228331b.setImageResource(R.drawable.ud_icon_filter_outlined);
        this.f228331b.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.icon_n2)));
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(n.d(22), n.d(22));
        r106.leftMargin = n.d(20);
        addView(this.f228331b, r106);
        int r107 = d.a(2);
        this.f228331b.setPadding(r107, r107, r107, r107);
        AppCompatImageView r108 = new AppCompatImageView(r100);
        this.f228332c = r108;
        r108.setId(R.id.iv_switch);
        this.f228332c.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.icon_n2)));
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(n.d(22), n.d(22));
        r109.leftMargin = n.d(20);
        r109.rightMargin = n.d(21);
        d();
        addView(this.f228332c, r109);
        this.f228332c.setPadding(r107, r107, r107, r107);
        this.f228331b.setOnClickListener(new b(this));
        this.f228332c.setOnClickListener(new c(this));
    }

    public final void c(AppCompatImageView r100, boolean r101) {
        ObjectAnimator r102 = this.f228338i;
        if (r102 != null) goto L5;
    L8:
        float r103 = 1.0f;
        if (r101 == false) goto L11;
        float r104 = 0.0f;
    L12:
        if (r101 == true) goto L15;
        r103 = 0.0f;
    L15:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{r104, r103});
        this.f228338i = r105;
        r105.setDuration(250);
        this.f228338i.addListener(new ad5.a(r100, r101));
        this.f228338i.start();
        return;
    L11:
        r104 = 1.0f;
        goto L12
    L5:
        if (r102.isRunning() == false) goto L7;
        this.f228338i.cancel();
    L7:
        this.f228338i = null;
        goto L8
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
        if (this.f228332c.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) this.f228332c.getLayoutParams();
        int r113 = (this.f228332c.getMeasuredWidth() + r112.leftMargin) + r112.rightMargin;
    L11:
        if (this.f228331b.getVisibility() != 0) goto L13;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) this.f228331b.getLayoutParams();
        int r102 = (this.f228331b.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin;
    L15:
        if (this.f228330a.getVisibility() != 0) goto L17;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) this.f228330a.getLayoutParams();
        int r103 = (this.f228330a.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin;
    L18:
        int r116 = getMeasuredWidth();
        int r104 = getMeasuredHeight();
        int r117 = (r116 - r113) - r102;
        if (r103 <= r117) goto L21;
        r103 = r117;
    L22:
        int r105 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        int r106 = View.MeasureSpec.makeMeasureSpec(this.f228330a.getMeasuredHeight(), 1073741824);
        this.f228330a.measure(r105, r106);
        int r107 = View.MeasureSpec.makeMeasureSpec(r100, 1073741824);
        int r108 = View.MeasureSpec.makeMeasureSpec(this.f228333d.getMeasuredHeight(), 1073741824);
        this.f228333d.measure(r107, r108);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r116, 1073741824), View.MeasureSpec.makeMeasureSpec(r104, 1073741824));
        return;
    L21:
        r100 = r117 - r103;
        goto L22
    L17:
        r103 = 0;
        goto L18
    L13:
        r102 = 0;
        goto L15
    L9:
        r113 = 0;
        goto L11
    }
}
