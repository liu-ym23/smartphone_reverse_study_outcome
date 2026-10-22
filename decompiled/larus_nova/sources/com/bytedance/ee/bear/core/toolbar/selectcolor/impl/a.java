package com.bytedance.ee.bear.core.toolbar.selectcolor.impl;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Highlight.ColorItem f217253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SelectColorV2Adapter f217254d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SelectColorV2Adapter.b r101 = this.f217254d.f217228f;
        if (r101 == null) goto L6;
        r101.a(this.f217253c);
        return;
    }

    public a(SelectColorV2Adapter r100, Highlight.ColorItem r101, int r102) {
        this.f217254d = r100;
        this.f217253c = r101;
    }
}
