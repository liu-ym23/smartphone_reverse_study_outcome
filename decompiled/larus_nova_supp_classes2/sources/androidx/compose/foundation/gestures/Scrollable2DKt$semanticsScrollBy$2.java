package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DKt$semanticsScrollBy$2", f = "Scrollable2D.kt", i = {}, l = {527}, m = "invokeSuspend", n = {}, s = {})
public final class Scrollable2DKt$semanticsScrollBy$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $offset;
    final /* synthetic */ Ref.LongRef $previousValue;
    private /* synthetic */ Object L$0;
    int label;

    public Scrollable2DKt$semanticsScrollBy$2(long r1, Ref.LongRef r3, Continuation<? super Scrollable2DKt$semanticsScrollBy$2> r4) {
        this.$offset = r1;
        this.$previousValue = r3;
        super(2, r4);
    }

    public static /* synthetic */ Unit a(Ref.LongRef r0, NestedScrollScope r1, Offset r2, Offset r3) {
        return invokeSuspend$lambda$0(r0, r1, r2, r3);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Scrollable2DKt$semanticsScrollBy$2 r0 = new Scrollable2DKt$semanticsScrollBy$2(this.$offset, this.$previousValue, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((NestedScrollScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        final NestedScrollScope r14 = (NestedScrollScope) this.L$0;
        Offset.Companion r2 = Offset.Companion;
        TwoWayConverter<Offset, AnimationVector2D> r3 = VectorConvertersKt.getVectorConverter(r2);
        Offset r4 = Offset.box-impl(r2.getZero-F1C5BW0());
        Offset r5 = Offset.box-impl(this.$offset);
        final Ref.LongRef r6 = this.$previousValue;
        Function2 r8 = new y1(r6, r14);
        this.label = 1;
        if (SuspendAnimationKt.animate$default(r3, r4, r5, null, null, r8, this, 24, null) != r0) goto L12;
        return r0;
    }

    private static final Unit invokeSuspend$lambda$0(Ref.LongRef r2, NestedScrollScope r3, Offset r4, Offset r5) {
        long r6 = r3.mo614scrollByOzD1aCk(Offset.minus-MK-Hz9U(r4.unbox-impl(), r2.element), NestedScrollSource.Companion.getUserInput-WNlRxjI());
        r2.element = Offset.plus-MK-Hz9U(r2.element, r6);
        return Unit.INSTANCE;
    }
}
