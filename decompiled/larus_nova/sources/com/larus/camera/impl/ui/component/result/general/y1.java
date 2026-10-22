package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y1 implements Function1<View, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResultTitleComponent f322475a;

    public y1(ResultTitleComponent r100) {
        this.f322475a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View r100) {
        View r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$configMiddleTitleIconContainer");
        if (r101.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        this.f322475a.f322215q = true;
        com.larus.utils.e1.o(r101);
    L9:
        return Unit.INSTANCE;
    L5:
        r102 = false;
        goto L6
    }
}
