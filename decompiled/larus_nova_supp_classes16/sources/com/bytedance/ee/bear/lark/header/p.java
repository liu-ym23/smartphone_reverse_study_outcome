package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p implements i {
    public HomeSubMenuView a;
    public boolean b;
    public final boolean c;
    public final int d;

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r1) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("SubMenuHeader", "destroy()...");
        this.a = null;
    }

    public p() {
        this.d = 2131167711;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.b;
    }

    public p(int r2) {
        this.d = 2131167711;
        this.c = true;
        this.d = r2;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r2) {
        tt5.a.h("SubMenuHeader", "initData()...");
        this.b = true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r5) {
        tt5.a.h("SubMenuHeader", "createView()...");
        HomeSubMenuView r0 = new HomeSubMenuView(r5);
        this.a = r0;
        r0.setId(2131374462);
        this.a.setBackground(r5.getResources().getDrawable(2131243713, null));
        ViewGroup.LayoutParams r1 = new ViewGroup.LayoutParams(-1, r5.getResources().getDimensionPixelOffset(this.d));
        this.a.setLayoutParams(r1);
        if (this.c == false) goto L6;
        HomeSubMenuView r6 = this.a;
        r6.getClass();
        tt5.a.h("HomeSubMenuView", "hideFilter()...");
        r6.c(r6.b, false);
    L6:
        return this.a;
    }
}
