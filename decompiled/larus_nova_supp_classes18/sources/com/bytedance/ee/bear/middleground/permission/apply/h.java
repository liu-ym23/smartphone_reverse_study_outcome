package com.bytedance.ee.bear.middleground.permission.apply;

import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ Function1<PermApplyViewModel.PermType, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super PermApplyViewModel.PermType, Unit> r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        PermApplyViewModel.PermType r3 = (PermApplyViewModel.PermType) r2;
        Function1<PermApplyViewModel.PermType, Unit> r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.invoke(r3);
    }
}
