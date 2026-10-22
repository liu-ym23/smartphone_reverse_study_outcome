package com.bytedance.ee.bear.bitable.infoarch;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.search.SearchViewModel;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.core.basemain.ability.b f213201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchViewModel f213202b;

    public d(com.bytedance.ee.bear.bitable.core.basemain.ability.b r100, SearchViewModel r101) {
        this.f213201a = r100;
        this.f213202b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L7;
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r101 = this.f213201a;
        if (r101 == null) goto L11;
        final SearchViewModel r102 = this.f213202b;
        r101.Sa(new WorkaroundKt$interceptTopContainerEventInSearch$1$1(r102));
        return;
    L11:
        return;
    L7:
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r103 = this.f213201a;
        if (r103 == null) goto L13;
        r103.Sa(null);
        return;
    }
}
