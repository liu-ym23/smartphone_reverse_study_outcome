package com.bytedance.ee.bear.wikiv2.create;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiCreateSelectPanelDialog f240682a;

    public c(WikiCreateSelectPanelDialog r100) {
        this.f240682a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        WikiCreateSelectView r102 = this.f240682a.Z90();
        Intrinsics.checkNotNull(r101);
        r102.setEnable(r101.booleanValue());
    }
}
