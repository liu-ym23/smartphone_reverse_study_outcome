package com.larus.camera.impl.ui.component.result.general;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c2 implements Function1<View, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResultTitleComponent f322242a;

    public c2(ResultTitleComponent r100) {
        this.f322242a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View r100) {
        View r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "$this$configRedoUndoButtonContainer");
        ResultTitleComponent r102 = this.f322242a;
        if (r102.f322216r == false) goto L6;
        r102.f322216r = false;
        com.larus.utils.e1.x(r101);
        r101.setEnabled(true);
    L6:
        return Unit.INSTANCE;
    }
}
