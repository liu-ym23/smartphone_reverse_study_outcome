package com.bytedance.ee.bear.templates.center;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends BaseTitleBar.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ TemplateCenterView f238939k;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r100) {
        c r101 = this.f238939k.f238904e;
        if (r101 == null) goto L6;
        r101.M6();
        return;
    }

    public k(Drawable r100, TemplateCenterView r101) {
        this.f238939k = r101;
        super(r100);
    }
}
