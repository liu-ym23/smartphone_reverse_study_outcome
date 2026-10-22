package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f227393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public yc5.b f227394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f227395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yc5.b.a f227396d;

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("NotificationHeader", "destroy()...");
        yc5.b r100 = this.f227394b;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        this.f227393a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f227395c;
    }

    public l(yc5.b.a r100) {
        this.f227396d = r100;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r100) {
        this.f227394b.c(r100);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r100) {
        tt5.a.h("NotificationHeader", "initData()...");
        this.f227395c = true;
        this.f227394b = new yc5.b(r100, this.f227393a, this.f227396d);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r100) {
        tt5.a.h("NotificationHeader", "createView()...");
        FrameLayout r101 = new FrameLayout(r100);
        this.f227393a = r101;
        r101.setId(R.id.list_notification_container);
        ViewGroup.LayoutParams r102 = new ViewGroup.LayoutParams(-1, -2);
        this.f227393a.setLayoutParams(r102);
        return this.f227393a;
    }
}
