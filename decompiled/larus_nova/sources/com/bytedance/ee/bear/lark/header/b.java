package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DigitDanceHeader f227375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f227376b;

    public b() {
    }

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
        tt5.a.h("DigitalRefreshHeader", "destroy()...");
        this.f227375a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f227376b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r100) {
        tt5.a.h("DigitalRefreshHeader", "initData()...");
        this.f227376b = true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r100) {
        tt5.a.h("DigitalRefreshHeader", "createView()...");
        DigitDanceHeader r101 = new DigitDanceHeader(r100);
        this.f227375a = r101;
        r101.setId(R.id.list_appbar_refresh_header);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, y9c.d.a(65));
        this.f227375a.setLayoutParams(r102);
        return this.f227375a;
    }

    public final void d(SmartRefreshLayout r100) {
        tt5.a.h("DigitalRefreshHeader", "attachToRefreshLayout()...");
        if (r100 != null) goto L6;
        tt5.a.d("DigitalRefreshHeader", "attachToRefreshLayout()...smartRefreshLayout is null");
        return;
    L6:
        wa5.a r101 = (wa5.a) r100.getRefreshHeader();
        if (r101 == null) goto L12;
        r101.setAssociatedHeader(this.f227375a);
        String r102 = com.bytedance.ee.util.ui.n.x(r100.getContext(), R.string.Doc_List_RefreshDocTips);
        DigitDanceHeader r103 = this.f227375a;
        if (r103 == null) goto L13;
        r103.setCustomText(r102);
        return;
    L13:
        return;
    }
}
