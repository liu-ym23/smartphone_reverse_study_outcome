package com.bytedance.ee.bear.doc.structure.pad.container;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.doc.structure.pad.CatalogListView;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadCatalogController f218253a;

    public j(PadCatalogController r100) {
        this.f218253a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CatalogListView r101 = this.f218253a.f218234f;
        r101.setActiveContentId((String) r100);
    }
}
