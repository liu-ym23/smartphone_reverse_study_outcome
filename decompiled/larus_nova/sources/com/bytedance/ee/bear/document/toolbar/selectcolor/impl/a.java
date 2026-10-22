package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f222408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SelectColorAdapter f222409d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SelectColorAdapter.a r101 = this.f222409d.f222355d;
        if (r101 == null) goto L6;
        String r102 = this.f222408c;
        ((b) r101).f222410a.f222363h.colorSelected(r102);
        return;
    }

    public a(SelectColorAdapter r100, String r101) {
        this.f222409d = r100;
        this.f222408c = r101;
    }
}
