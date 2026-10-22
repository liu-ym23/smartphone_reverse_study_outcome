package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Dialog;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupOrDialogVisibilityTracker$dialogVisibleRectResolver$1 extends FunctionReferenceImpl implements Function1<Dialog, Rect> {
    public PopupOrDialogVisibilityTracker$dialogVisibleRectResolver$1(Object r100) {
        super(1, r100, PopupOrDialogVisibilityTracker.class, "resolveDialogVisibleRect", "resolveDialogVisibleRect$impl_mainlandRelease(Landroid/app/Dialog;)Landroid/graphics/Rect;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Rect invoke2(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return ((PopupOrDialogVisibilityTracker) this.receiver).resolveDialogVisibleRect$impl_mainlandRelease(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Rect invoke(Dialog r100) {
        return invoke2(r100);
    }
}
