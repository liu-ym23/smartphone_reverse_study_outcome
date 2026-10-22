package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DNode$drag$2$1", f = "Scrollable2D.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
public final class Scrollable2DNode$drag$2$1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
    private /* synthetic */ Object L$0;
    int label;

    public Scrollable2DNode$drag$2$1(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super Scrollable2DNode$drag$2$1> r2) {
        this.$forEachDelta = r1;
        super(2, r2);
    }

    public static /* synthetic */ Unit a(NestedScrollScope r0, DragEvent.DragDelta r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Scrollable2DNode$drag$2$1 r0 = new Scrollable2DNode$drag$2$1(this.$forEachDelta, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((NestedScrollScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final NestedScrollScope r6 = (NestedScrollScope) this.L$0;
        Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> r2 = this.$forEachDelta;
        Function1 r3 = new b2(r6);
        this.label = 1;
        if (r2.invoke(r3, this) != r0) goto L12;
        return r0;
    }

    private static final Unit invokeSuspend$lambda$0(NestedScrollScope r2, DragEvent.DragDelta r3) {
        r2.mo615scrollByWithOverscrollOzD1aCk(r3.m565getDeltaF1C5BW0(), NestedScrollSource.Companion.getUserInput-WNlRxjI());
        return Unit.INSTANCE;
    }
}
