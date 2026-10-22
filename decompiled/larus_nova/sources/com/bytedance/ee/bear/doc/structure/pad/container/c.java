package com.bytedance.ee.bear.doc.structure.pad.container;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.doc.structure.Structure;
import com.bytedance.ee.bear.doc.structure.pad.CatalogListView;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadCatalogController f218244a;

    public c(PadCatalogController r100) {
        this.f218244a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CatalogListView r101 = this.f218244a.f218234f;
        r101.setData((Structure) r100);
        com.bytedance.ee.util.ui.j.c(new b(this.f218244a));
    }
}
