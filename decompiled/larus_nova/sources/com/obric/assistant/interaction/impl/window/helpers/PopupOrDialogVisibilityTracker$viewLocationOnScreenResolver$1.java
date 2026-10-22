package com.obric.assistant.interaction.impl.window.helpers;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupOrDialogVisibilityTracker$viewLocationOnScreenResolver$1 extends FunctionReferenceImpl implements Function1<View, int[]> {
    public PopupOrDialogVisibilityTracker$viewLocationOnScreenResolver$1(Object r100) {
        super(1, r100, PopupOrDialogVisibilityTracker.class, "resolveViewLocationOnScreen", "resolveViewLocationOnScreen$impl_mainlandRelease(Landroid/view/View;)[I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int[] invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((PopupOrDialogVisibilityTracker) this.receiver).resolveViewLocationOnScreen$impl_mainlandRelease(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ int[] invoke(View r100) {
        return invoke2(r100);
    }
}
