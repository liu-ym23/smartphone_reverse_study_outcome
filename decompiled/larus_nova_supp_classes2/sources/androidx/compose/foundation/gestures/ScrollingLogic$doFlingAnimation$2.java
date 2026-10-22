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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", i = {}, l = {837}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    public ScrollingLogic$doFlingAnimation$2(ScrollingLogic r1, Ref.LongRef r2, long r3, Continuation<? super ScrollingLogic$doFlingAnimation$2> r5) {
        this.this$0 = r1;
        this.$result = r2;
        this.$available = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ScrollingLogic$doFlingAnimation$2 r6 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((NestedScrollScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        Ref.LongRef r3 = (Ref.LongRef) this.L$2;
        ScrollingLogic r4 = (ScrollingLogic) this.L$1;
        ScrollingLogic r5 = (ScrollingLogic) this.L$0;
        ResultKt.throwOnFailure(r10);
    L12:
        r3.element = ScrollingLogic.m692access$updateQWom1Mo(r4, r2, r5.reverseIfNeeded(((Number) r10).floatValue()));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        final NestedScrollScope r11 = (NestedScrollScope) this.L$0;
        final ScrollingLogic r6 = this.this$0;
        ScrollScope r7 = new ScrollingLogic$doFlingAnimation$2$reverseScope$1(r6, r11);
        r4 = this.this$0;
        Ref.LongRef r12 = this.$result;
        long r8 = this.$available;
        FlingBehavior r9 = ScrollingLogic.access$getFlingBehavior$p(r4);
        long r13 = r12.element;
        float r14 = r4.reverseIfNeeded(ScrollingLogic.m691access$toFloatTH1AsA0(r4, r8));
        this.L$0 = r4;
        this.L$1 = r4;
        this.L$2 = r12;
        this.J$0 = r13;
        this.label = 1;
        Object r15 = r9.performFling(r7, r14, this);
        if (r15 != r0) goto L11;
        return r0;
    L11:
        r3 = r12;
        r10 = r15;
        r5 = r4;
        r2 = r13;
        goto L12
    }
}
