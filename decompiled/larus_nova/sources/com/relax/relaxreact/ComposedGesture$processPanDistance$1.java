package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "gesture", "Lcom/relax/relaxreact/BaseGesture;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ComposedGesture$processPanDistance$1 extends Lambda implements Function1<BaseGesture, Unit> {
    final /* synthetic */ Ref.BooleanRef $hasTapLikeGesture;
    final /* synthetic */ ArrayList<r0> $panGestures;

    public ComposedGesture$processPanDistance$1(Ref.BooleanRef r100, ArrayList<r0> r101) {
        this.$hasTapLikeGesture = r100;
        this.$panGestures = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BaseGesture r100) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        if (r100.getType().getValue() != GestureTypeInner.Tap.getValue()) goto L5;
    L10:
        this.$hasTapLikeGesture.element = true;
        return;
    L5:
        if (r100.getType().getValue() == GestureTypeInner.Longpress.getValue()) goto L10;
        if (r100.getType().getValue() != GestureTypeInner.Pan.getValue()) goto L12;
        com.bytedance.rts.kmp.foundation.i.f(this.$panGestures, (r0) r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BaseGesture r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
