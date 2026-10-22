package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ PadCatalogController a;

    public d(PadCatalogController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        if (this.a.d.getCatalogMode() == CatalogMode.COVERAGE) goto L6;
        return false;
    L6:
        if (r4.getAction() != 0) goto L8;
        tt5.a.h("PadCatalogController", "closeCatalogView by touch web in coverage mode");
        this.a.d.openOrCloseCatalogView(false);
    L8:
        return false;
    }
}
