package com.bytedance.ee.bear.templates.center;

import android.view.View;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ TemplateCenterView a;

    public g(TemplateCenterView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        boolean r4 = ForsetiHelper.c(this.a.d);
        ((BaseTitleBar) this.a.c.findViewById(2131388775)).setNeedReturnBack(r4);
        if (r4 == false) goto L5;
        return;
    L5:
        ((BaseTitleBar) this.a.c.findViewById(2131388775)).setNeedReturnBack(false);
    }
}
