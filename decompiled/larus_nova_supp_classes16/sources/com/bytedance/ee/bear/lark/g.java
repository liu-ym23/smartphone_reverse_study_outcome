package com.bytedance.ee.bear.lark;

import android.view.View;
import com.bytedance.ee.bear.lark.dependency.g0;
import com.larksuite.framework.utils.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ com.ss.android.lark.maintab.export.d a;
    public final /* synthetic */ f b;

    public g(com.ss.android.lark.maintab.export.d r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.c();
        h0.a.a.b("key_space_search_title", null);
        ((g0) org.koin.java.a.c(g0.class, null, null, 6)).a(this.b.a.getContext(), this.b.a, this.a.getTitleBarHeight());
    }
}
