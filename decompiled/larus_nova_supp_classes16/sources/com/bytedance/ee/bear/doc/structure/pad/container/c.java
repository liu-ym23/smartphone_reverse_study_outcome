package com.bytedance.ee.bear.doc.structure.pad.container;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.doc.structure.Structure;
import com.bytedance.ee.bear.doc.structure.pad.CatalogListView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ PadCatalogController a;

    public c(PadCatalogController r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        CatalogListView r0 = this.a.f;
        r0.setData((Structure) r2);
        com.bytedance.ee.util.ui.j.c(new b(this.a));
    }
}
