package com.bytedance.ee.bear.templates.center.list.base;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListPresenter f239012a;

    public h(BaseTemplateListPresenter r100) {
        this.f239012a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        sbb.e r101 = (sbb.e) r100;
        BaseTemplateListPresenter r102 = this.f239012a;
        Intrinsics.checkNotNull(r101);
        r102.S8(r101);
    }
}
