package com.bytedance.ee.bear.templates.center;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends BaseTitleBar.c {
    public final /* synthetic */ TemplateCenterView k;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r1) {
        c r2 = this.k.e;
        if (r2 == null) goto L6;
        r2.M6();
        return;
    }

    public k(Drawable r1, TemplateCenterView r2) {
        this.k = r2;
        super(r1);
    }
}
