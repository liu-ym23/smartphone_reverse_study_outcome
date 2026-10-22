package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.ConnectionService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q implements i {
    public zc5.a a;
    public boolean b;

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
        tt5.a.h("SubTitleHeader", "destroy");
        this.a = null;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final boolean isAdded() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void b(ConnectionService.NetworkState r3) {
        tt5.a.h("SubTitleHeader", "onNetworkStateChanged " + r3);
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final void c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        tt5.a.h("SubTitleHeader", "initData");
        this.b = true;
        zc5.a r0 = this.a;
        if (r0 == null) goto L5;
        r0.setLeftTitle(r3.getString(2131886913));
    L5:
        zc5.a r4 = this.a;
        if (r4 == null) goto L9;
        r4.setMoreVisible(false);
        return;
    }

    @Override // com.bytedance.ee.bear.lark.header.i
    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        tt5.a.h("SubTitleHeader", "createView");
        zc5.a r0 = new zc5.a(r4);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.a = r0;
        TextView r5 = r0.getLeftTitle();
        if (r5 == null) goto L6;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        int r1 = y9c.d.a(4);
        ((LinearLayout.LayoutParams) r6).bottomMargin = r1;
    L6:
        return this.a;
    }

    @Override // com.bytedance.ee.bear.lark.header.j
    public final void setUserVisibleHint(boolean r3) {
        tt5.a.h("SubTitleHeader", "setUserVisibleHint " + r3);
    }
}
