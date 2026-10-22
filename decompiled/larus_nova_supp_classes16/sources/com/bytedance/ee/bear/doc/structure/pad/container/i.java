package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ PadCatalogController a;

    public i(PadCatalogController r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        final Boolean r6 = (Boolean) r5;
        final View r0 = this.a.e();
        if (r0 == null) goto L14;
        final ViewGroup r1 = (ViewGroup) this.a.c.getValue();
        if (r1 != null) goto L9;
        return;
    L9:
        if ((r1.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        tt5.a.h("PadCatalogController", "skip manual width change on constraint-driven container, isOnEmbed=" + r6);
        PadCatalogController.b(this.a);
        return;
    L11:
        final PadCatalogController r3 = this.a;
        r0.post(new PadCatalogController$setupViewModel$2$4$1(r6, r3, r0, r1));
        return;
    }
}
