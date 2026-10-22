package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f227377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f227378b;

    public c() {
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
        tt5.a.h("DividerHeader", "destroy()...");
        this.f227377a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f227378b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r100) {
        tt5.a.h("DividerHeader", "initData()...");
        this.f227378b = true;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r100) {
        tt5.a.h("DividerHeader", "createView()...");
        View r101 = new View(r100);
        this.f227377a = r101;
        r101.setBackground(r100.getResources().getDrawable(R.color.bg_base, null));
        ViewGroup.LayoutParams r102 = new ViewGroup.LayoutParams(-1, y9c.d.a(12));
        this.f227377a.setLayoutParams(r102);
        return this.f227377a;
    }
}
