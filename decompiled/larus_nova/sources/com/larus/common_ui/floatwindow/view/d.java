package com.larus.common_ui.floatwindow.view;

import android.app.Activity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Activity r101 = (Activity) r100;
        Intrinsics.checkNotNullParameter(r101, "previous");
        int r102 = e.f327493a;
        if ((r101 instanceof e19.a) == false) goto L5;
    L10:
        boolean r103 = true;
    L12:
        return Boolean.valueOf(!r103);
    L5:
        if (r101.isFinishing() == true) goto L10;
        if (r101.isDestroyed() == true) goto L10;
        r103 = false;
        goto L12
    }
}
