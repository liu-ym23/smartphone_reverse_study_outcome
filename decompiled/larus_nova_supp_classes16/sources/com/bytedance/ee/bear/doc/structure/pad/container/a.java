package com.bytedance.ee.bear.doc.structure.pad.container;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import nz4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnHoverListener {
    public final /* synthetic */ PadCatalogController a;

    public a(PadCatalogController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View r3, MotionEvent r4) {
        if (r4.getAction() != 9) goto L8;
        com.bytedance.ee.bear.contract.d r5 = m.a;
        CatalogMode r6 = this.a.d.getCatalogMode();
        if (r6 == null) goto L8;
        m.a.n("docs_Doc_iPad_show_catalog", MapsKt.mapOf(new Pair[]{TuplesKt.to("catalog_mode", m.a(r6)), TuplesKt.to("catalog_action", "Doc_iPad_hover_catalog_item")}));
    L8:
        return true;
    }
}
