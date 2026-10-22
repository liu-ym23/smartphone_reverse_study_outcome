package com.bytedance.ee.bear.middleground.permission.apply;

import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<PermApplyViewModel.PermType, Unit> f233024a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super PermApplyViewModel.PermType, Unit> r100) {
        this.f233024a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        PermApplyViewModel.PermType r101 = (PermApplyViewModel.PermType) r100;
        Function1<PermApplyViewModel.PermType, Unit> r102 = this.f233024a;
        Intrinsics.checkNotNull(r101);
        r102.invoke(r101);
    }
}
