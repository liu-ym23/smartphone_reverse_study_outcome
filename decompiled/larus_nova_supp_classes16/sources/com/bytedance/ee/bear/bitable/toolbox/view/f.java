package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.ToolbarData;
import com.bytedance.ee.bear.widgets.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends t {
    public final /* synthetic */ ToolbarData.MenuItem c;
    public final /* synthetic */ ToolbarMenuAdapter.MenuViewHolder d;
    public final /* synthetic */ ToolbarMenuAdapter e;

    public final void a(View r2) {
        String r3 = this.c.getId();
        if (r3 == null) goto L7;
        Function1<? super String, Unit> r0 = this.e.b;
        if (r0 == null) goto L7;
        r0.invoke(r3);
    L7:
        this.d.f.setVisibility(8);
    }

    public f(ToolbarData.MenuItem r1, ToolbarMenuAdapter.MenuViewHolder r2, ToolbarMenuAdapter r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
