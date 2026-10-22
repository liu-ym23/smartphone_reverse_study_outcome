package com.bytedance.ee.bear.wikiv2.create;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WikiCreateSelectView f240687c;

    public f(WikiCreateSelectView r100) {
        this.f240687c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        WikiCreateSelectView.c r101 = this.f240687c.getDelegate();
        if (r101 == null) goto L6;
        r101.onCancelClick();
        return;
    }
}
