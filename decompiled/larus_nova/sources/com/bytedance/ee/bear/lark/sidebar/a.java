package com.bytedance.ee.bear.lark.sidebar;

import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.list.sidebar.navigation.SidebarNavigationView;
import com.bytedance.ee.bear.list.sidebar.tab.SidebarHomeSubMenuView;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements xc5.b.InterfaceC8214b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarDocTabFragment f227519a;

    public a(SidebarDocTabFragment r100) {
        this.f227519a = r100;
    }

    @Override // xc5.b.InterfaceC8214b
    public final void a(int r100) {
        tt5.a.h("SidebarDocTabFragment", "onTabSelected()...index = " + r100);
        SidebarDocTabFragment r101 = this.f227519a;
        int r102 = SidebarDocTabFragment.Y;
        if (r101.f227191y != r100) goto L5;
        return;
    L5:
        ViewPager r103 = r101.f227181o;
        if (r103 == null) goto L8;
        r103.setCurrentItem(r100);
    L8:
        SidebarDocTabFragment r104 = this.f227519a;
        r104.f227191y = r100;
        int r105 = 0;
        if (r100 == 0) goto L13;
        if (r100 == 2) goto L13;
        boolean r106 = false;
    L14:
        SidebarHomeSubMenuView r107 = r104.I;
        if (r107 == null) goto L22;
        ImageView r108 = r107.f229625b;
        if (r108 == null) goto L22;
        if (r106 == true) goto L21;
        r105 = 8;
    L21:
        r108.setVisibility(r105);
    L22:
        SidebarDocTabFragment r109 = this.f227519a;
        SidebarNavigationView r110 = r109.M;
        if (r110 == null) goto L25;
        r110.setCurrentModule(r109.m6());
    L25:
        by4.d r111 = this.f227519a.O;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r111 = null;
    L29:
        if (r111 == null) goto L33;
        com.ss.android.lark.storage.kv.repo.a r112 = r111.b("platform");
        if (r112 == null) goto L33;
        r112.putInt("last_select_tab", this.f227519a.f227191y);
    L33:
        SidebarDocTabFragment r113 = this.f227519a;
        if (r113.f227191y != 2) goto L38;
        SidebarHomeSubMenuView r114 = r113.I;
        if (r114 == null) goto L41;
        r114.a(r113.Y90(r113.f227190x));
    L41:
        lc5.f.a r115 = lc5.f.f508440a;
        this.f227519a.getClass();
        String r116 = this.f227519a.m6();
        if (this.f227519a.f227191y != 0) goto L44;
        String r117 = "recent";
    L45:
        p r118 = new p("home", r116, r117, "", "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r118, "param");
        r115.I(r118);
        return;
    L44:
        r117 = "catalogue";
        goto L45
    L38:
        SidebarHomeSubMenuView r119 = r113.I;
        if (r119 == null) goto L41;
        r119.a(r113.Y90(r113.f227189w));
    L13:
        r106 = true;
        goto L14
    }
}
