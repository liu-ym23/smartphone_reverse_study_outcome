package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadCatalogController f218245a;

    public d(PadCatalogController r100) {
        this.f218245a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.f218245a.f218232d.getCatalogMode() == CatalogMode.COVERAGE) goto L6;
        return false;
    L6:
        if (r101.getAction() != 0) goto L8;
        tt5.a.h("PadCatalogController", "closeCatalogView by touch web in coverage mode");
        this.f218245a.f218232d.openOrCloseCatalogView(false);
    L8:
        return false;
    }
}
