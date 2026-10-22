package com.bytedance.ee.bear.lark;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.PlaceholderHeader;
import com.bytedance.ee.bear.list.homepage.FlingBehavior;
import com.bytedance.ee.bear.list.homepage.KeepWithinParentBoundsScrollingBehavior;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x {
    public static ViewGroup a(Context r13) {
        FrameLayout r0 = new FrameLayout(r13);
        r0.setId(2131378120);
        r0.setBackground(r13.getResources().getDrawable(2131100548, null));
        SmartRefreshLayout r1 = new SmartRefreshLayout(r13);
        r1.setId(2131378171);
        r1.setBackground(null);
        r1.g(false);
        r1.I = false;
        r1.J = false;
        r1.A = true;
        ViewGroup.MarginLayoutParams r4 = new ViewGroup.MarginLayoutParams(-1, com.bytedance.ee.util.ui.n.d(60));
        r4.topMargin = y9c.d.a(35);
        PlaceholderHeader r6 = new PlaceholderHeader(r13);
        r6.setId(2131378170);
        r6.setVisibility(4);
        r6.setLayoutParams(r4);
        r1.G(r6, y9c.d.a(60));
        CoordinatorLayout r5 = new CoordinatorLayout(r13);
        r5.setId(2131378119);
        ViewGroup.LayoutParams r7 = new CoordinatorLayout.LayoutParams(-1, -2);
        r7.setBehavior(new FlingBehavior(r13, null));
        AppBarLayout r8 = new AppBarLayout(r13);
        r8.setId(2131378183);
        r8.setBackground(null);
        ViewGroup.LayoutParams r9 = new AppBarLayout.LayoutParams(-1, -2);
        r9.setScrollFlags(15);
        CollapsingToolbarLayout r10 = new CollapsingToolbarLayout(r13);
        r10.setId(2131378079);
        LinearLayout r11 = new LinearLayout(r13);
        r11.setId(2131378117);
        r11.setOrientation(1);
        r10.addView(r11, new CollapsingToolbarLayout.LayoutParams(-1, -2));
        r10.setOnApplyWindowInsetsListener(null);
        r10.setMinimumHeight(r13.getResources().getDimensionPixelSize(2131167711));
        r8.addView(r10, r9);
        r5.addView(r8, r7);
        ViewGroup.LayoutParams r2 = new CoordinatorLayout.LayoutParams(-1, -1);
        r2.setBehavior(new KeepWithinParentBoundsScrollingBehavior());
        HomeViewPager r12 = new HomeViewPager(r13);
        r12.setId(2131378123);
        r12.setOnApplyWindowInsetsListener(null);
        r5.addView(r12, r2);
        r5.setOnApplyWindowInsetsListener(null);
        r1.E(r5);
        r0.addView(r1, new FrameLayout.LayoutParams(-1, -1));
        CommonCreateButton r3 = new CommonCreateButton(r13);
        r3.setId(2131367552);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 8388693;
        r0.addView(r3, r14);
        return r0;
    }
}
