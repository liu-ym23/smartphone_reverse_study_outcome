package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f322498a;

    public /* synthetic */ b(Fragment r100) {
        this.f322498a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Fragment r101 = this.f322498a;
        FragmentTransaction r102 = (FragmentTransaction) r100;
        Intrinsics.checkNotNullParameter(r102, "$this$inTransaction");
        return r102.show(r101);
    }
}
