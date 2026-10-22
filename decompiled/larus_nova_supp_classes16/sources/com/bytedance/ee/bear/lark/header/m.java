package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m implements i {
    public NoNetworkView a;
    public boolean b;
    public final boolean c;

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("OfflineTipsHeader", "destroy()...");
        this.a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.b;
    }

    public m(boolean r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r2) {
        if (r2 != null) goto L4;
    L7:
        this.a.setVisibility(0);
        return;
    L4:
        if (r2.a() == false) goto L7;
        this.a.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r2) {
        tt5.a.h("OfflineTipsHeader", "initData()...");
        this.b = true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.bytedance.ee.bear.facade.common.widget.NoNetworkView] */
    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r3) {
        tt5.a.h("OfflineTipsHeader", "createView()...");
        ?? r0 = new NoNetworkView(r3);
        this.a = r0;
        r0.setVisibility(8);
        ViewGroup.LayoutParams r4 = new ViewGroup.LayoutParams(-1, -2);
        this.a.setLayoutParams(r4);
        return this.a;
    }
}
