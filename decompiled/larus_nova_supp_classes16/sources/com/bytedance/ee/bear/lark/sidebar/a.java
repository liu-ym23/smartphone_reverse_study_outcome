package com.bytedance.ee.bear.lark.sidebar;

import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.list.sidebar.navigation.SidebarNavigationView;
import com.bytedance.ee.bear.list.sidebar.tab.SidebarHomeSubMenuView;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements xc5.b.b {
    public final /* synthetic */ SidebarDocTabFragment a;

    public a(SidebarDocTabFragment r1) {
        this.a = r1;
    }

    public final void a(int r9) {
        tt5.a.h("SidebarDocTabFragment", "onTabSelected()...index = " + r9);
        SidebarDocTabFragment r0 = this.a;
        int r1 = SidebarDocTabFragment.Y;
        if (r0.y != r9) goto L5;
        return;
    L5:
        ViewPager r2 = r0.o;
        if (r2 == null) goto L8;
        r2.setCurrentItem(r9);
    L8:
        SidebarDocTabFragment r3 = this.a;
        r3.y = r9;
        int r4 = 0;
        if (r9 == 0) goto L13;
        if (r9 == 2) goto L13;
        boolean r10 = false;
    L14:
        SidebarHomeSubMenuView r5 = r3.I;
        if (r5 == null) goto L22;
        ImageView r6 = r5.b;
        if (r6 == null) goto L22;
        if (r10 == true) goto L21;
        r4 = 8;
    L21:
        r6.setVisibility(r4);
    L22:
        SidebarDocTabFragment r11 = this.a;
        SidebarNavigationView r7 = r11.M;
        if (r7 == null) goto L25;
        r7.setCurrentModule(r11.m6());
    L25:
        by4.d r12 = this.a.O;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r12 = null;
    L29:
        if (r12 == null) goto L33;
        com.ss.android.lark.storage.kv.repo.a r13 = r12.b("platform");
        if (r13 == null) goto L33;
        r13.putInt("last_select_tab", this.a.y);
    L33:
        SidebarDocTabFragment r14 = this.a;
        if (r14.y != 2) goto L38;
        SidebarHomeSubMenuView r8 = r14.I;
        if (r8 == null) goto L41;
        r8.a(r14.Y90(r14.x));
    L41:
        lc5.f.a r16 = lc5.f.a;
        this.a.getClass();
        String r17 = this.a.m6();
        if (this.a.y != 0) goto L44;
        String r18 = "recent";
    L45:
        p r19 = new p("home", r17, r18, "", "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r19, "param");
        r16.I(r19);
        return;
    L44:
        r18 = "catalogue";
        goto L45
    L38:
        SidebarHomeSubMenuView r20 = r14.I;
        if (r20 == null) goto L41;
        r20.a(r14.Y90(r14.w));
    L13:
        r10 = true;
        goto L14
    }
}
