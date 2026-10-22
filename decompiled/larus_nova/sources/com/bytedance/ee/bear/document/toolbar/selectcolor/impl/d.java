package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Highlight.ColorItem f222412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SelectColorV2Adapter f222413d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SelectColorV2Adapter.b r101 = this.f222413d.f222380f;
        if (r101 == null) goto L6;
        r101.a(this.f222412c);
        return;
    }

    public d(SelectColorV2Adapter r100, Highlight.ColorItem r101, int r102) {
        this.f222413d = r100;
        this.f222412c = r101;
    }
}
