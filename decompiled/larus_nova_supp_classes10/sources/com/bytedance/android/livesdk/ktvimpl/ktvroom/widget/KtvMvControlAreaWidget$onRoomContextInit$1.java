package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvMvControlAreaWidget$onRoomContextInit$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public KtvMvControlAreaWidget$onRoomContextInit$1(KtvMvControlAreaWidget r8) {
        super(1, r8, KtvMvControlAreaWidget.class, "onKtvPreviewSongsShown", "onKtvPreviewSongsShown(Z)V", 0);
    }

    public final void invoke(boolean r4) {
        KtvMvControlAreaWidget r0 = (KtvMvControlAreaWidget) ((CallableReference) this).receiver;
        if (r4 == false) goto L11;
        TextView r5 = r0.d;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mWelcomeTextView");
    L7:
        r5.setVisibility(0);
        View r6 = r0.a;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSeparator");
    L10:
        r6.setVisibility(0);
        return;
    L11:
        TextView r7 = r0.d;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mWelcomeTextView");
    L14:
        r7.setVisibility(8);
        View r8 = r0.a;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSeparator");
    L17:
        r8.setVisibility(8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
