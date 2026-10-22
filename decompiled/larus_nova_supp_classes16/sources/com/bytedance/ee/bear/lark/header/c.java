package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements i {
    public View a;
    public boolean b;

    public c() {
    }

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
        tt5.a.h("DividerHeader", "destroy()...");
        this.a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r2) {
        tt5.a.h("DividerHeader", "initData()...");
        this.b = true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r4) {
        tt5.a.h("DividerHeader", "createView()...");
        View r0 = new View(r4);
        this.a = r0;
        r0.setBackground(r4.getResources().getDrawable(2131100545, null));
        ViewGroup.LayoutParams r5 = new ViewGroup.LayoutParams(-1, y9c.d.a(12));
        this.a.setLayoutParams(r5);
        return this.a;
    }
}
