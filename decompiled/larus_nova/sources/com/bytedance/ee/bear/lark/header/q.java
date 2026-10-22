package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class q implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zc5.a f227417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f227418b;

    public static final class a {
    }

    static {
    }

    public q() {
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void destroy() {
        tt5.a.h("SubTitleHeader", MapMonitorConst.EVENT_DESTROY);
        this.f227417a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.f227418b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r100) {
        tt5.a.h("SubTitleHeader", "onNetworkStateChanged " + r100);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        tt5.a.h("SubTitleHeader", "initData");
        this.f227418b = true;
        zc5.a r101 = this.f227417a;
        if (r101 == null) goto L5;
        r101.setLeftTitle(r100.getString(R.string.Bitable_Workspace_MyBase_Title));
    L5:
        zc5.a r102 = this.f227417a;
        if (r102 == null) goto L9;
        r102.setMoreVisible(false);
        return;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        tt5.a.h("SubTitleHeader", "createView");
        zc5.a r101 = new zc5.a(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f227417a = r101;
        TextView r102 = r101.getLeftTitle();
        if (r102 == null) goto L6;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        int r104 = y9c.d.a(4);
        ((LinearLayout.LayoutParams) r103).bottomMargin = r104;
    L6:
        return this.f227417a;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r100) {
        tt5.a.h("SubTitleHeader", "setUserVisibleHint " + r100);
    }
}
