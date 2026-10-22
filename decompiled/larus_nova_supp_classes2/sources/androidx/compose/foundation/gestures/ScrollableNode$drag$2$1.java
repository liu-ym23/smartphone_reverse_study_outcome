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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$drag$2$1", f = "Scrollable.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollableNode$drag$2$1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
    final /* synthetic */ ScrollingLogic $this_with;
    private /* synthetic */ Object L$0;
    int label;

    public ScrollableNode$drag$2$1(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r1, ScrollingLogic r2, Continuation<? super ScrollableNode$drag$2$1> r3) {
        this.$forEachDelta = r1;
        this.$this_with = r2;
        super(2, r3);
    }

    public static /* synthetic */ Unit a(NestedScrollScope r0, ScrollingLogic r1, DragEvent.DragDelta r2) {
        return invokeSuspend$lambda$0(r0, r1, r2);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ScrollableNode$drag$2$1 r0 = new ScrollableNode$drag$2$1(this.$forEachDelta, this.$this_with, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((NestedScrollScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final NestedScrollScope r7 = (NestedScrollScope) this.L$0;
        Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> r2 = this.$forEachDelta;
        final ScrollingLogic r3 = this.$this_with;
        Function1 r4 = new i2(r7, r3);
        this.label = 1;
        if (r2.invoke(r4, this) != r0) goto L12;
        return r0;
    }

    private static final Unit invokeSuspend$lambda$0(NestedScrollScope r2, ScrollingLogic r3, DragEvent.DragDelta r4) {
        r2.mo615scrollByWithOverscrollOzD1aCk(r3.m700singleAxisOffsetMKHz9U(r4.m565getDeltaF1C5BW0()), NestedScrollSource.Companion.getUserInput-WNlRxjI());
        return Unit.INSTANCE;
    }
}
