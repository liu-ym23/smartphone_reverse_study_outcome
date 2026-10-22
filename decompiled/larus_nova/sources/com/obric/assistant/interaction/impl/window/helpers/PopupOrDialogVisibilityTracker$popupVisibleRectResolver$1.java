package com.obric.assistant.interaction.impl.window.helpers;

import android.graphics.Rect;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupOrDialogVisibilityTracker$popupVisibleRectResolver$1 extends FunctionReferenceImpl implements Function1<PopupWindow, Rect> {
    public PopupOrDialogVisibilityTracker$popupVisibleRectResolver$1(Object r100) {
        super(1, r100, PopupOrDialogVisibilityTracker.class, "resolvePopupVisibleRect", "resolvePopupVisibleRect$impl_mainlandRelease(Landroid/widget/PopupWindow;)Landroid/graphics/Rect;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Rect invoke2(PopupWindow r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((PopupOrDialogVisibilityTracker) this.receiver).resolvePopupVisibleRect$impl_mainlandRelease(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Rect invoke(PopupWindow r100) {
        return invoke2(r100);
    }
}
