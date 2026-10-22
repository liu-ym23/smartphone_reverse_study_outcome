package com.bytedance.android.shopping.api.mall.common.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.api.mall.common.tools.h;
import yj.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ Context b;

    public a(b r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        Activity r1 = ECHybridExtensionsKt.a(this.b);
        if (r1 == null) goto L9;
        s r0 = h.b.getIHybridHostUserService();
        String r8 = this.a.getEnterFrom();
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        r0.e(r1, r8, "click_ecom_tab", null, null);
        this.a.getClickListener().invoke();
        return;
    }
}
