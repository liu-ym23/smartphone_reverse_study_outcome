package androidx.compose.foundation.gestures;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$doFlingAnimation$2", f = "Scrollable2D.kt", i = {}, l = {473}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollingLogic2D$doFlingAnimation$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    public ScrollingLogic2D$doFlingAnimation$2(ScrollingLogic2D r1, long r2, Ref.LongRef r4, Continuation<? super ScrollingLogic2D$doFlingAnimation$2> r5) {
        this.this$0 = r1;
        this.$available = r2;
        this.$result = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ScrollingLogic2D$doFlingAnimation$2 r6 = new ScrollingLogic2D$doFlingAnimation$2(this.this$0, this.$available, this.$result, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((NestedScrollScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        Ref.LongRef r3 = (Ref.LongRef) this.L$0;
        ResultKt.throwOnFailure(r8);
    L12:
        r3.element = ScrollingLogic2D.access$doFlingAnimation_QWom1Mo$toDecomposedVelocity(((Number) r8).floatValue(), r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final NestedScrollScope r9 = (NestedScrollScope) this.L$0;
        final ScrollingLogic2D r4 = this.this$0;
        final long r5 = this.$available;
        ScrollScope r6 = new ScrollingLogic2D$doFlingAnimation$2$flingScope$1(r4, r9, r5);
        ScrollingLogic2D r10 = this.this$0;
        long r7 = this.$available;
        Ref.LongRef r11 = this.$result;
        FlingBehavior r12 = ScrollingLogic2D.access$getFlingBehavior$p(r10);
        float r13 = Scrollable2DKt.m660access$getMagnitudeTH1AsA0(r7);
        this.L$0 = r11;
        this.J$0 = r7;
        this.label = 1;
        r8 = r12.performFling(r6, r13, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r7;
        r3 = r11;
        goto L12
    }
}
