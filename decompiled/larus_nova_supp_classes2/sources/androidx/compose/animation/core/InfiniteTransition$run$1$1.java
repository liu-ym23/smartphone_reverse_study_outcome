package androidx.compose.animation.core;

import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.InfiniteTransition$run$1$1", f = "InfiniteTransition.kt", i = {0, 0, 1, 1}, l = {172, 193}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "durationScale", "$this$LaunchedEffect", "durationScale"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class InfiniteTransition$run$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<State<Long>> $toolingOverride;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InfiniteTransition this$0;

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.InfiniteTransition$run$1$1$3", f = "InfiniteTransition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Float, Continuation<? super Boolean>, Object> {
        /* synthetic */ float F$0;
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass3 r0 = new AnonymousClass3(r3);
            r0.F$0 = ((Number) r2).floatValue();
            return r0;
        }

        public final Object invoke(float r1, Continuation<? super Boolean> r2) {
            return create(Float.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Number) r1).floatValue(), (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (this.F$0 <= MenuKt.ClosedAlphaTarget) goto L7;
            boolean r3 = true;
        L9:
            return Boxing.boxBoolean(r3);
        L7:
            r3 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public InfiniteTransition$run$1$1(MutableState<State<Long>> r1, InfiniteTransition r2, Continuation<? super InfiniteTransition$run$1$1> r3) {
        this.$toolingOverride = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public static /* synthetic */ float a(CoroutineScope r0) {
        return invokeSuspend$lambda$3(r0);
    }

    public static /* synthetic */ Unit c(MutableState r0, InfiniteTransition r1, Ref.FloatRef r2, CoroutineScope r3, long r4) {
        return invokeSuspend$lambda$2(r0, r1, r2, r3, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        InfiniteTransition$run$1$1 r0 = new InfiniteTransition$run$1$1(this.$toolingOverride, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final float invokeSuspend$lambda$3(CoroutineScope r0) {
        return SuspendAnimationKt.getDurationScale(r0.getCoroutineContext());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007d -> B:12:0x0042). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        final Ref.FloatRef r2 = (Ref.FloatRef) this.L$1;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
        final CoroutineScope r10 = r4;
    L11:
        InfiniteTransition$run$1$1 r5 = this;
    L12:
        final MutableState<State<Long>> r6 = r5.$toolingOverride;
        final InfiniteTransition r7 = r5.this$0;
        Function1 r8 = new m(r6, r7, r2, r10);
        r5.L$0 = r10;
        r5.L$1 = r2;
        r5.label = 1;
        if (InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r8, r5) != r0) goto L16;
        return r0;
    L16:
        if (r2.element != MenuKt.ClosedAlphaTarget) goto L23;
        if (1 == 0) goto L12;
        Flow r11 = SnapshotStateKt.snapshotFlow(new n(r10));
        AnonymousClass3 r12 = new AnonymousClass3(null);
        r5.L$0 = r10;
        r5.L$1 = r2;
        r5.label = 2;
        if (kotlinx.coroutines.flow.e.t(r11, r12, r5) != r0) goto L12;
        return r0;
    L23:
        if (0 == 0) goto L12;
        goto L12
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = (Ref.FloatRef) this.L$1;
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
        r10 = r13;
        r5 = this;
        goto L16
    L10:
        ResultKt.throwOnFailure(r9);
        r10 = (CoroutineScope) this.L$0;
        r2 = new Ref.FloatRef();
        r2.element = 1.0f;
        goto L11
    }

    private static final Unit invokeSuspend$lambda$2(MutableState r8, InfiniteTransition r9, Ref.FloatRef r10, CoroutineScope r11, long r12) {
        State r13 = (State) r8.getValue();
        if (r13 == null) goto L5;
        long r0 = ((Number) r13.getValue()).longValue();
    L6:
        boolean r14 = true;
        int r6 = 0;
        if (InfiniteTransition.access$getStartTimeNanos$p(r9) != Long.MIN_VALUE) goto L9;
    L13:
        InfiniteTransition.access$setStartTimeNanos$p(r9, r12);
        MutableVector r15 = InfiniteTransition.access$get_animations$p(r9);
        Object[] r16 = r15.content;
        int r17 = r15.getSize();
        int r2 = 0;
    L14:
        if (r2 >= r17) goto L16;
        ((InfiniteTransition.TransitionAnimationState) r16[r2]).reset$animation_core();
        r2 = r2 + 1;
        goto L14
    L16:
        r10.element = SuspendAnimationKt.getDurationScale(r11.getCoroutineContext());
    L18:
        if (r10.element == MenuKt.ClosedAlphaTarget) goto L21;
        r14 = false;
    L21:
        if (r14 == false) goto L25;
        MutableVector r18 = InfiniteTransition.access$get_animations$p(r9);
        Object[] r19 = r18.content;
        int r20 = r18.getSize();
    L23:
        if (r6 >= r20) goto L27;
        ((InfiniteTransition.TransitionAnimationState) r19[r6]).skipToEnd$animation_core();
        r6 = r6 + 1;
    L27:
        return Unit.INSTANCE;
    L25:
        InfiniteTransition.access$onFrame(r9, (long) ((r0 - InfiniteTransition.access$getStartTimeNanos$p(r9)) / r10.element));
        goto L27
    L9:
        if (r10.element != SuspendAnimationKt.getDurationScale(r11.getCoroutineContext())) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L18;
    L11:
        r3 = false;
        goto L12
    L5:
        r0 = r12;
        goto L6
    }
}
