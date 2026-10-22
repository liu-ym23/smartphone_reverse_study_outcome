package com.bytedance.ee.bear.doc.structure.pad.container;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes16.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PadCatalogController f218247a;

    public f(PadCatalogController r100) {
        this.f218247a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        tt5.a.h("PadCatalogController", "isModeChangedToPadLiveData isPad=" + r101);
        if (r101.booleanValue() == false) goto L5;
        PadCatalogController.c(this.f218247a);
        return;
    L5:
        PadCatalogController.a(this.f218247a);
    }
}
