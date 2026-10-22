package com.bytedance.ee.bear.bitable.filter.step.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.filter.step.EFilterStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubFilterValueFragment f211909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilterStepViewModel f211910b;

    public d(SubFilterValueFragment r100, FilterStepViewModel r101) {
        this.f211909a = r100;
        this.f211910b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        EFilterStep r101 = (EFilterStep) r100;
        if (r101 != EFilterStep.Value) goto L13;
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r102 = this.f211909a.f211905g;
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r103 = null;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterValueEditView");
        r102 = null;
    L7:
        r102.a(r101.getSubValueStep());
        MutableLiveData<String> r104 = this.f211910b.getCurrentStepTitle();
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r105 = this.f211909a.f211905g;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterValueEditView");
    L11:
        r104.setValue(r103.getTitle());
        return;
    L10:
        r103 = r105;
        goto L11
    }
}
