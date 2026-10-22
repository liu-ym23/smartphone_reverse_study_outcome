package com.bytedance.ee.bear.doc.structure.pad.container;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ PadCatalogController a;

    public f(PadCatalogController r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        tt5.a.h("PadCatalogController", "isModeChangedToPadLiveData isPad=" + r4);
        if (r4.booleanValue() == false) goto L5;
        PadCatalogController.c(this.a);
        return;
    L5:
        PadCatalogController.a(this.a);
    }
}
