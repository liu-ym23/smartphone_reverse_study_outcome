package com.bytedance.locallife.poi.newdetail.component;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class y<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiQuickPageNavigationBar f263239a;

    public y(PoiQuickPageNavigationBar r100) {
        this.f263239a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        PoiQuickPageNavigationBar r102 = this.f263239a;
        if (r102.K == false) goto L6;
        r102.j0(false, true);
        return;
    }
}
