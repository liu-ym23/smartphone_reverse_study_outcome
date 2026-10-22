package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements i {
    public FrameLayout a;
    public yc5.b b;
    public boolean c;
    public final yc5.b.a d;

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("NotificationHeader", "destroy()...");
        yc5.b r0 = this.b;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.c;
    }

    public l(yc5.b.a r1) {
        this.d = r1;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r2) {
        this.b.c(r2);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r4) {
        tt5.a.h("NotificationHeader", "initData()...");
        this.c = true;
        this.b = new yc5.b(r4, this.a, this.d);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r3) {
        tt5.a.h("NotificationHeader", "createView()...");
        FrameLayout r0 = new FrameLayout(r3);
        this.a = r0;
        r0.setId(2131378163);
        ViewGroup.LayoutParams r4 = new ViewGroup.LayoutParams(-1, -2);
        this.a.setLayoutParams(r4);
        return this.a;
    }
}
