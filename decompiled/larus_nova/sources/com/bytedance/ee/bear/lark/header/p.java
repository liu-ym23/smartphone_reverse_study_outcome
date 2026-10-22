package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class p implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HomeSubMenuView f227413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f227414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f227415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f227416d;

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r100) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("SubMenuHeader", "destroy()...");
        this.f227413a = null;
    }

    public p() {
        this.f227416d = R.dimen.list_home_sub_menu_height;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f227414b;
    }

    public p(int r100) {
        this.f227416d = R.dimen.list_home_sub_menu_height;
        this.f227415c = true;
        this.f227416d = r100;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r100) {
        tt5.a.h("SubMenuHeader", "initData()...");
        this.f227414b = true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r100) {
        tt5.a.h("SubMenuHeader", "createView()...");
        HomeSubMenuView r101 = new HomeSubMenuView(r100);
        this.f227413a = r101;
        r101.setId(R.id.home_sub_title_view);
        this.f227413a.setBackground(r100.getResources().getDrawable(R.drawable.list_home_sub_menu_bg, null));
        ViewGroup.LayoutParams r102 = new ViewGroup.LayoutParams(-1, r100.getResources().getDimensionPixelOffset(this.f227416d));
        this.f227413a.setLayoutParams(r102);
        if (this.f227415c == false) goto L6;
        HomeSubMenuView r103 = this.f227413a;
        r103.getClass();
        tt5.a.h("HomeSubMenuView", "hideFilter()...");
        r103.c(r103.f228331b, false);
    L6:
        return this.f227413a;
    }
}
