package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e1 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ WikiTreeCtrlView c;

    public e1(WikiTreeCtrlView r3) {
        this.c = r3;
        super(1000);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        WikiTreeCtrlView r0 = this.c;
        if (r0.f == null) goto L5;
        tt5.a.h(r0.e, "click add node on root " + du5.b.g(this.c.getViewModel().getRootToken()));
    L5:
        this.c.l(r4);
    }
}
