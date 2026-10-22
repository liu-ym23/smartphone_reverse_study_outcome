package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.View;
import com.bytedance.ee.bear.bitable.toolbox.model.toolbar.ToolbarData;
import com.bytedance.ee.bear.widgets.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ToolbarData.MenuItem f216039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ToolbarMenuAdapter.MenuViewHolder f216040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ToolbarMenuAdapter f216041e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        String r101 = this.f216039c.getId();
        if (r101 == null) goto L7;
        Function1<? super String, Unit> r102 = this.f216041e.f216027b;
        if (r102 == null) goto L7;
        r102.invoke(r101);
    L7:
        this.f216040d.f216033f.setVisibility(8);
    }

    public f(ToolbarData.MenuItem r100, ToolbarMenuAdapter.MenuViewHolder r101, ToolbarMenuAdapter r102) {
        this.f216039c = r100;
        this.f216040d = r101;
        this.f216041e = r102;
    }
}
