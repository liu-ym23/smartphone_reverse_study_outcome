package com.bytedance.ee.bear.wikiv2.create;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WikiCreateSelectView f240686c;

    public e(WikiCreateSelectView r100) {
        this.f240686c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        WikiCreateSelectView.c r101 = this.f240686c.getDelegate();
        if (r101 == null) goto L6;
        r101.onCancelClick();
        return;
    }
}
