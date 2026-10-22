package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements i {
    public DigitDanceHeader a;
    public boolean b;

    public b() {
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
        tt5.a.h("DigitalRefreshHeader", "destroy()...");
        this.a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r2) {
        tt5.a.h("DigitalRefreshHeader", "initData()...");
        this.b = true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r3) {
        tt5.a.h("DigitalRefreshHeader", "createView()...");
        DigitDanceHeader r0 = new DigitDanceHeader(r3);
        this.a = r0;
        r0.setId(2131378060);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, y9c.d.a(65));
        this.a.setLayoutParams(r4);
        return this.a;
    }

    public final void d(SmartRefreshLayout r3) {
        tt5.a.h("DigitalRefreshHeader", "attachToRefreshLayout()...");
        if (r3 != null) goto L6;
        tt5.a.d("DigitalRefreshHeader", "attachToRefreshLayout()...smartRefreshLayout is null");
        return;
    L6:
        wa5.a r0 = (wa5.a) r3.getRefreshHeader();
        if (r0 == null) goto L12;
        r0.setAssociatedHeader(this.a);
        String r4 = com.bytedance.ee.util.ui.n.x(r3.getContext(), 2131887957);
        DigitDanceHeader r1 = this.a;
        if (r1 == null) goto L13;
        r1.setCustomText(r4);
        return;
    L13:
        return;
    }
}
