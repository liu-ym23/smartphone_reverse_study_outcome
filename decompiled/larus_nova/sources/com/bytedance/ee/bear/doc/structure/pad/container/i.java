package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes16.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadCatalogController f218252a;

    public i(PadCatalogController r100) {
        this.f218252a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        final Boolean r101 = (Boolean) r100;
        final View r102 = this.f218252a.e();
        if (r102 == null) goto L14;
        final ViewGroup r103 = (ViewGroup) this.f218252a.f218231c.getValue();
        if (r103 != null) goto L9;
        return;
    L9:
        if ((r103.getLayoutParams() instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        tt5.a.h("PadCatalogController", "skip manual width change on constraint-driven container, isOnEmbed=" + r101);
        PadCatalogController.b(this.f218252a);
        return;
    L11:
        final PadCatalogController r104 = this.f218252a;
        r102.post(new PadCatalogController$setupViewModel$2$4$1(r101, r104, r102, r103));
        return;
    }
}
