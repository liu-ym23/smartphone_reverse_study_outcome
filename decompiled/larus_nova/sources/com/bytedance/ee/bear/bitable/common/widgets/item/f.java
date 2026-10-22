package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.panel.m f210026a;

    public f(com.bytedance.ee.bear.bitable.panel.m r100) {
        this.f210026a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.bitable.panel.m r101 = this.f210026a;
        if (r101 == null) goto L6;
        r101.a("exit");
        return;
    }
}
