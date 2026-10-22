package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;

/* JADX INFO: loaded from: classes16.dex */
public final class m implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NoNetworkView f227397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f227398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f227399c;

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("OfflineTipsHeader", "destroy()...");
        this.f227397a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return this.f227399c;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f227398b;
    }

    public m(boolean r100) {
        this.f227399c = r100;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r100) {
        if (r100 != null) goto L4;
    L7:
        this.f227397a.setVisibility(0);
        return;
    L4:
        if (r100.a() == false) goto L7;
        this.f227397a.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r100) {
        tt5.a.h("OfflineTipsHeader", "initData()...");
        this.f227398b = true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r100) {
        tt5.a.h("OfflineTipsHeader", "createView()...");
        NoNetworkView r101 = new NoNetworkView(r100);
        this.f227397a = r101;
        r101.setVisibility(8);
        ViewGroup.LayoutParams r102 = new ViewGroup.LayoutParams(-1, -2);
        this.f227397a.setLayoutParams(r102);
        return this.f227397a;
    }
}
