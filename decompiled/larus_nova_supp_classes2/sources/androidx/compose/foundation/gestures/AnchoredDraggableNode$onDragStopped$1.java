package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", i = {}, l = {435, 437}, m = "invokeSuspend", n = {}, s = {})
public final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "availableVelocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", i = {0}, l = {439}, m = "invokeSuspend", n = {"availableVelocity"}, s = {"J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        public AnonymousClass1(AnchoredDraggableNode<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.J$0 = ((Velocity) r3).unbox-impl();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
            return m545invokesFctU(((Velocity) r3).unbox-impl(), (Continuation) r4);
        }

        /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m545invokesFctU(long r1, Continuation<? super Velocity> r3) {
            return create(Velocity.box-impl(r1), r3).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r2 = this.J$0;
            ResultKt.throwOnFailure(r6);
        L12:
            float r7 = ((Number) r6).floatValue();
            float r3 = AnchoredDraggableNode.access$getState$p(this.this$0).requireOffset();
            float r4 = AnchoredDraggableNode.access$getState$p(this.this$0).getAnchors().minPosition();
            if (r3 < AnchoredDraggableNode.access$getState$p(this.this$0).getAnchors().maxPosition()) goto L15;
        L16:
            r2 = AnchoredDraggableNode.m536access$toVelocityadjELrA(this.this$0, r7);
        L18:
            return Velocity.box-impl(r2);
        L15:
            if (r3 > r4) goto L18;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r5 = this.J$0;
            AnchoredDraggableNode<T> r8 = this.this$0;
            float r9 = AnchoredDraggableNode.m533access$toFloatTH1AsA0(r8, r5);
            this.J$0 = r5;
            this.label = 1;
            r6 = AnchoredDraggableNode.access$fling(r8, r9, this);
            if (r6 != r0) goto L11;
            return r0;
        L11:
            r2 = r5;
            goto L12
        }
    }

    public AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> r1, long r2, Continuation<? super AnchoredDraggableNode$onDragStopped$1> r4) {
        this.this$0 = r1;
        this.$velocity = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L18:
        Unit r9 = Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        goto L20
    L10:
        ResultKt.throwOnFailure(r8);
        AnchoredDraggableNode<T> r10 = this.this$0;
        float r11 = AnchoredDraggableNode.m533access$toFloatTH1AsA0(r10, AnchoredDraggableNode.m531access$reverseIfNeededAH228Gc(r10, this.$velocity));
        if (AnchoredDraggableNode.access$getOverscrollEffect$p(this.this$0) != null) goto L15;
        AnchoredDraggableNode<T> r2 = this.this$0;
        this.label = 1;
        if (AnchoredDraggableNode.access$fling(r2, r11, this) != r0) goto L20;
        return r0;
    L15:
        OverscrollEffect r3 = AnchoredDraggableNode.access$getOverscrollEffect$p(this.this$0);
        Intrinsics.checkNotNull(r3);
        long r4 = AnchoredDraggableNode.m536access$toVelocityadjELrA(this.this$0, r11);
        AnonymousClass1 r12 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (r3.mo319applyToFlingBMRW4eQ(r4, r12, this) != r0) goto L18;
        return r0;
    }
}
