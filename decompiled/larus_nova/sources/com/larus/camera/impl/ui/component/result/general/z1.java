package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z1 implements Function1<View, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResultTitleComponent f322479a;

    public z1(ResultTitleComponent r100) {
        this.f322479a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View r100) {
        View r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$configRedoUndoButtonContainer");
        if (r101.getVisibility() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        this.f322479a.f322216r = true;
        com.larus.utils.e1.o(r101);
        r101.setEnabled(false);
    L9:
        return Unit.INSTANCE;
    L5:
        r102 = false;
        goto L6
    }
}
