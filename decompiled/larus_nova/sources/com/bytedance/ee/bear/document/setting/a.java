package com.bytedance.ee.bear.document.setting;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocumentPermTyeActivity f221750a;

    public a(DocumentPermTyeActivity r100) {
        this.f221750a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        DocumentPermTyeActivity r102 = this.f221750a;
        Intrinsics.checkNotNull(r101);
        DocumentPermTyeActivity.C1(r102, r101.intValue());
    }
}
