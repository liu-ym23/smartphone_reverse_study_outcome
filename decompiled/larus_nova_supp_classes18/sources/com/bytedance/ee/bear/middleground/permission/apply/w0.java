package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w0 implements View.OnClickListener {
    public static final w0 a = null;

    static {
        a = new w0();
    }

    public w0() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        s45.h r4 = s45.g.a;
        String r5 = s45.g.a.b("173353144094", "067313445121", null);
        ((com.bytedance.ee.bear.route.h) e0c.k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(r5);
    }
}
