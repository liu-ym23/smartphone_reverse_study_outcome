package com.bytedance.ee.bear.facade.common.widget;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class n extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ErrorTipsView.b f226626c;

    public n(ErrorTipsView.b r100) {
        this.f226626c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f226626c.onClick("close", "");
    }
}
