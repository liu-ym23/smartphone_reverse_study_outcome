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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
class NavigationItemView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LKUIRoundedImageView2 f228318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f228319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDBadgeView f228320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Constraints.LayoutParams f228321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintLayout.LayoutParams f228322e;

    public NavigationItemView() {
        throw null;
    }

    public NavigationItemView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        setPadding(0, 0, 0, y9c.d.a(8));
        setId(R.id.list_navigation_item_container);
        setBackground(getResources().getDrawable(R.drawable.list_navigation_item_selector));
        LKUIRoundedImageView2 r102 = new LKUIRoundedImageView2(r100);
        this.f228318a = r102;
        r102.setId(R.id.list_navigation_item_icon);
        ConstraintLayout.LayoutParams r103 = new ConstraintLayout.LayoutParams(y9c.d.a(30), y9c.d.a(30));
        r103.topToTop = 0;
        r103.leftToLeft = 0;
        r103.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r103).topMargin = y9c.d.a(4);
        addView(this.f228318a, r103);
        TextView r104 = new TextView(r100);
        this.f228319b = r104;
        r104.setId(R.id.list_navigation_item_name);
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(-2, -2);
        this.f228322e = r105;
        ((ViewGroup.MarginLayoutParams) r105).topMargin = y9c.d.a(4);
        ConstraintLayout.LayoutParams r106 = this.f228322e;
        r106.topToBottom = R.id.list_navigation_item_icon;
        r106.leftToLeft = 0;
        r106.rightToRight = 0;
        this.f228319b.setGravity(17);
        this.f228319b.setMaxLines(2);
        this.f228319b.setEllipsize(TextUtils.TruncateAt.END);
        this.f228319b.setTextColor(r100.getResources().getColor(R.color.text_title));
        this.f228319b.setTextSize(2, 12.0f);
        addView(this.f228319b, this.f228322e);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDBadgeView r107 = new UDBadgeView(r100, null, 0, R.style.UDBadge_Dot_StrongReminder_Small);
        String r108 = r107.f284529h;
        if (r108 == null) goto L5;
        r107.setText(r108);
    L5:
        Drawable r109 = r107.f284534m;
        if (r109 == null) goto L8;
        r107.setIcon(r109);
    L8:
        r107.b();
        this.f228320c = r107;
        r107.setId(R.id.list_navigation_item_badge);
        Constraints.LayoutParams r110 = new Constraints.LayoutParams(-2, -2);
        this.f228321d = r110;
        ((ViewGroup.MarginLayoutParams) r110).rightMargin = y9c.d.a(2);
        Constraints.LayoutParams r111 = this.f228321d;
        ((ViewGroup.MarginLayoutParams) r111).topMargin = y9c.d.a(6);
        Constraints.LayoutParams r112 = this.f228321d;
        r112.topToTop = R.id.list_navigation_item_name;
        r112.rightToLeft = R.id.list_navigation_item_name;
        this.f228320c.setBadgeColor(ContextCompat.getColor(r100, R.color.primary_fill_loading));
        this.f228320c.a();
        addView(this.f228320c, this.f228321d);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (this.f228320c.getVisibility() == 0) goto L5;
        return;
    L5:
        if (this.f228319b.getLeft() > this.f228320c.getMeasuredWidth()) goto L9;
        this.f228319b.layout(this.f228320c.getMeasuredWidth(), this.f228319b.getTop(), Math.min(this.f228319b.getRight(), getMeasuredWidth()), this.f228319b.getBottom());
        UDBadgeView r105 = this.f228320c;
        r105.layout(0, r105.getTop(), this.f228320c.getMeasuredWidth(), this.f228320c.getBottom());
        return;
    }
}
