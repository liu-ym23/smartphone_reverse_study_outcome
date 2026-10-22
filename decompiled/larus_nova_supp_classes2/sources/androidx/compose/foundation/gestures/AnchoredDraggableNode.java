package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BW\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0002JM\u0010#\u001a\u00020\u001e2=\u0010$\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001e0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0+\u0012\u0006\u0012\u0004\u0018\u00010,0%H\u0096@¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0016¢\u0006\u0004\b6\u00102J\u0016\u00107\u001a\u0002082\u0006\u00104\u001a\u000208H\u0082@¢\u0006\u0002\u00109J\b\u0010\u000e\u001a\u00020\bH\u0016J[\u0010:\u001a\u00020\u001e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\u0013\u0010;\u001a\u000200*\u000208H\u0002¢\u0006\u0004\b<\u0010=J\u0013\u0010>\u001a\u000205*\u000208H\u0002¢\u0006\u0004\b?\u0010=J\u0013\u0010@\u001a\u000208*\u000205H\u0002¢\u0006\u0004\bA\u0010BJ\u0013\u0010@\u001a\u000208*\u000200H\u0002¢\u0006\u0004\bC\u0010BJ\u0013\u0010D\u001a\u000205*\u000205H\u0002¢\u0006\u0004\bE\u0010FJ\u0013\u0010D\u001a\u000200*\u000200H\u0002¢\u0006\u0004\bG\u0010FR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006H"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "T", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "<init>", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Ljava/lang/Boolean;Landroidx/compose/foundation/gestures/FlingBehavior;)V", "Ljava/lang/Boolean;", "resolvedFlingBehavior", "getResolvedFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "setResolvedFlingBehavior", "(Landroidx/compose/foundation/gestures/FlingBehavior;)V", "density", "Landroidx/compose/ui/unit/Density;", "isReverseDirection", "()Z", "onAttach", "", "onDensityChange", "updateDensity", "updateFlingBehavior", "newFlingBehavior", "drag", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "fling", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "toFloat", "toFloat-TH1AsA0", "(J)F", "toFloat-k-4lQ0M", "reverseIfNeeded", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded-MK-Hz9U", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnchoredDraggableNode<T> extends DragGestureNode {
    private Density density;
    private FlingBehavior flingBehavior;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    public FlingBehavior resolvedFlingBehavior;
    private Boolean reverseDirection;
    private Boolean startDragImmediately;
    private AnchoredDraggableState<T> state;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        public AnonymousClass2(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r1, AnchoredDraggableNode<T> r2, Continuation<? super AnonymousClass2> r3) {
            this.$forEachDelta = r1;
            this.this$0 = r2;
            super(3, r3);
        }

        public static /* synthetic */ Unit a(AnchoredDraggableNode r0, AnchoredDragScope r1, DragEvent.DragDelta r2) {
            return invokeSuspend$lambda$1(r0, r1, r2);
        }

        public static /* synthetic */ Offset c(AnchoredDraggableNode r0, AnchoredDragScope r1, Offset r2) {
            return invokeSuspend$lambda$1$lambda$0(r0, r1, r2);
        }

        public final Object invoke(AnchoredDragScope r3, DraggableAnchors<T> r4, Continuation<? super Unit> r5) {
            AnonymousClass2 r6 = new AnonymousClass2(this.$forEachDelta, this.this$0, r5);
            r6.L$0 = r3;
            return r6.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, (Continuation) r3);
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
            final AnchoredDragScope r7 = (AnchoredDragScope) this.L$0;
            Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> r2 = this.$forEachDelta;
            final AnchoredDraggableNode<T> r3 = this.this$0;
            Function1 r4 = new i(r3, r7);
            this.label = 1;
            if (r2.invoke(r4, this) != r0) goto L12;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$1(final AnchoredDraggableNode r4, final AnchoredDragScope r5, DragEvent.DragDelta r6) {
            float r7 = AnchoredDraggableNode.m534access$toFloatk4lQ0M(r4, AnchoredDraggableNode.m532access$reverseIfNeededMKHz9U(r4, r6.m565getDeltaF1C5BW0()));
            if (AnchoredDraggableNode.access$getOverscrollEffect$p(r4) != null) goto L5;
            AnchoredDragScope.CC.dragTo$default(r5, AnchoredDraggableNode.access$getState$p(r4).newOffsetForDelta$foundation_release(r7), MenuKt.ClosedAlphaTarget, 2, null);
        L7:
            return Unit.INSTANCE;
        L5:
            OverscrollEffect r0 = AnchoredDraggableNode.access$getOverscrollEffect$p(r4);
            Intrinsics.checkNotNull(r0);
            Offset.box-impl(r0.mo320applyToScrollRhakbz0(AnchoredDraggableNode.m535access$toOffsettuRUvjQ(r4, r7), NestedScrollSource.Companion.getUserInput-WNlRxjI(), new j(r4, r5)));
            goto L7
        }

        private static final Offset invokeSuspend$lambda$1$lambda$0(AnchoredDraggableNode r4, AnchoredDragScope r5, Offset r6) {
            float r7 = AnchoredDraggableNode.access$getState$p(r4).newOffsetForDelta$foundation_release(AnchoredDraggableNode.m534access$toFloatk4lQ0M(r4, r6.unbox-impl()));
            long r0 = AnchoredDraggableNode.m535access$toOffsettuRUvjQ(r4, r7 - AnchoredDraggableNode.access$getState$p(r4).requireOffset());
            AnchoredDragScope.CC.dragTo$default(r5, r7, MenuKt.ClosedAlphaTarget, 2, null);
            return Offset.box-impl(r0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode", f = "AnchoredDraggable.kt", i = {1}, l = {456, 459}, m = "fling", n = {"leftoverVelocity"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        public AnonymousClass1(AnchoredDraggableNode<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AnchoredDraggableNode.access$fling(this.this$0, MenuKt.ClosedAlphaTarget, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2", f = "AnchoredDraggable.kt", i = {}, l = {470}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01342 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $leftoverVelocity;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        public C01342(AnchoredDraggableNode<T> r1, Ref.FloatRef r2, float r3, Continuation<? super C01342> r4) {
            this.this$0 = r1;
            this.$leftoverVelocity = r2;
            this.$velocity = r3;
            super(3, r4);
        }

        public final Object invoke(AnchoredDragScope r4, DraggableAnchors<T> r5, Continuation<? super Unit> r6) {
            C01342 r7 = new C01342(this.this$0, this.$leftoverVelocity, this.$velocity, r6);
            r7.L$0 = r4;
            return r7.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, (Continuation) r3);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Ref.FloatRef r2 = (Ref.FloatRef) this.L$0;
            ResultKt.throwOnFailure(r6);
        L12:
            r2.element = ((Number) r6).floatValue();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            final AnchoredDragScope r7 = (AnchoredDragScope) this.L$0;
            final AnchoredDraggableNode<T> r3 = this.this$0;
            ScrollScope r4 = new AnchoredDraggableNode$fling$2$scrollScope$1(r3, r7);
            FlingBehavior r8 = this.this$0.getResolvedFlingBehavior();
            Ref.FloatRef r5 = this.$leftoverVelocity;
            float r9 = this.$velocity;
            this.L$0 = r5;
            this.label = 1;
            r6 = r8.performFling(r4, r9, this);
            if (r6 != r0) goto L11;
            return r0;
        L11:
            r2 = r5;
            goto L12
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public void mo543onDragStartedk4lQ0M(long r1) {
    }

    private final boolean isReverseDirection() {
        Boolean r0 = this.reverseDirection;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        return r0.booleanValue();
    L5:
        if (DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl) goto L7;
    L9:
        return false;
    L7:
        if (this.orientation != Orientation.Horizontal) goto L9;
        return true;
    }

    public final FlingBehavior getResolvedFlingBehavior() {
        FlingBehavior r0 = this.resolvedFlingBehavior;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("resolvedFlingBehavior");
        return null;
    }

    public void onAttach() {
        updateFlingBehavior(this.flingBehavior);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        Boolean r0 = this.startDragImmediately;
        if (r0 == null) goto L6;
        return r0.booleanValue();
    L6:
        return this.state.isAnimationRunning();
    }

    private final void updateDensity() {
        Density r0 = DelegatableNodeKt.requireDensity(this);
        Density r1 = this.density;
        if (r1 != null) goto L5;
    L6:
        this.density = r0;
        updateFlingBehavior(this.flingBehavior);
        return;
    L5:
        if (Intrinsics.areEqual(r1, r0) == false) goto L6;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDensityChange() {
        onCancelPointerInput();
        if (isAttached() == false) goto L6;
        updateDensity();
        return;
    }

    public static final /* synthetic */ OverscrollEffect access$getOverscrollEffect$p(AnchoredDraggableNode r0) {
        return r0.overscrollEffect;
    }

    public static final /* synthetic */ AnchoredDraggableState access$getState$p(AnchoredDraggableNode r0) {
        return r0.state;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    private final long m537reverseIfNeededAH228Gc(long r2) {
        if (isReverseDirection() == false) goto L5;
        float r0 = -1.0f;
    L7:
        return Velocity.times-adjELrA(r2, r0);
    L5:
        r0 = 1.0f;
        goto L7
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    private final long m538reverseIfNeededMKHz9U(long r2) {
        if (isReverseDirection() == false) goto L5;
        float r0 = -1.0f;
    L7:
        return Offset.times-tuRUvjQ(r2, r0);
    L5:
        r0 = 1.0f;
        goto L7
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    private final float m539toFloatTH1AsA0(long r3) {
        if (this.orientation != Orientation.Vertical) goto L6;
        return Velocity.getY-impl(r3);
    L6:
        return Velocity.getX-impl(r3);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    private final float m540toFloatk4lQ0M(long r3) {
        if (this.orientation != Orientation.Vertical) goto L5;
        long r4 = r3 & 4294967295L;
    L7:
        return Float.intBitsToFloat((int) r4);
    L5:
        r4 = r3 >> 32;
        goto L7
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    private final long m541toOffsettuRUvjQ(float r7) {
        Orientation r0 = this.orientation;
        if (r0 != Orientation.Horizontal) goto L5;
        float r1 = r7;
    L7:
        if (r0 == Orientation.Vertical) goto L11;
        r7 = MenuKt.ClosedAlphaTarget;
    L11:
        return Offset.constructor-impl((Float.floatToRawIntBits(r1) << 32) | (((long) Float.floatToRawIntBits(r7)) & 4294967295L));
    L5:
        r1 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    private final long m542toVelocityadjELrA(float r5) {
        Orientation r0 = this.orientation;
        if (r0 != Orientation.Horizontal) goto L5;
        float r1 = r5;
    L7:
        if (r0 == Orientation.Vertical) goto L11;
        r5 = MenuKt.ClosedAlphaTarget;
    L11:
        return VelocityKt.Velocity(r1, r5);
    L5:
        r1 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    private final void updateFlingBehavior(FlingBehavior r4) {
        if (r4 != null) goto L4;
        AnchoredDraggableDefaults r5 = AnchoredDraggableDefaults.INSTANCE;
        AnimationSpec<Float> r0 = r5.getSnapAnimationSpec();
        Function1<Float, Float> r6 = r5.getPositionalThreshold();
        Density r1 = DelegatableNodeKt.requireDensity(this);
        this.density = r1;
        r4 = AnchoredDraggableKt.anchoredDraggableFlingBehavior(this.state, r1, r6, r0);
    L4:
        setResolvedFlingBehavior(r4);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* JADX INFO: renamed from: onDragStopped-TH1AsA0, reason: not valid java name */
    public void mo544onDragStoppedTH1AsA0(long r8) {
        if (isAttached() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(getCoroutineScope(), null, null, new AnchoredDraggableNode$onDragStopped$1(this, r8, null), 3, null);
    }

    public final void setResolvedFlingBehavior(FlingBehavior r1) {
        this.resolvedFlingBehavior = r1;
    }

    /* JADX INFO: renamed from: access$reverseIfNeeded-AH228Gc, reason: not valid java name */
    public static final /* synthetic */ long m531access$reverseIfNeededAH228Gc(AnchoredDraggableNode r0, long r1) {
        return r0.m537reverseIfNeededAH228Gc(r1);
    }

    /* JADX INFO: renamed from: access$reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public static final /* synthetic */ long m532access$reverseIfNeededMKHz9U(AnchoredDraggableNode r0, long r1) {
        return r0.m538reverseIfNeededMKHz9U(r1);
    }

    /* JADX INFO: renamed from: access$toFloat-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ float m533access$toFloatTH1AsA0(AnchoredDraggableNode r0, long r1) {
        return r0.m539toFloatTH1AsA0(r1);
    }

    /* JADX INFO: renamed from: access$toFloat-k-4lQ0M, reason: not valid java name */
    public static final /* synthetic */ float m534access$toFloatk4lQ0M(AnchoredDraggableNode r0, long r1) {
        return r0.m540toFloatk4lQ0M(r1);
    }

    /* JADX INFO: renamed from: access$toOffset-tuRUvjQ, reason: not valid java name */
    public static final /* synthetic */ long m535access$toOffsettuRUvjQ(AnchoredDraggableNode r0, float r1) {
        return r0.m541toOffsettuRUvjQ(r1);
    }

    /* JADX INFO: renamed from: access$toVelocity-adjELrA, reason: not valid java name */
    public static final /* synthetic */ long m536access$toVelocityadjELrA(AnchoredDraggableNode r0, float r1) {
        return r0.m542toVelocityadjELrA(r1);
    }

    private final Object fling(float r8, Continuation<? super Float> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        AnonymousClass1 r4 = r0;
        Object r10 = r4.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r4.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Ref.FloatRef r11 = (Ref.FloatRef) r4.L$0;
        ResultKt.throwOnFailure(r10);
    L27:
        return Boxing.boxFloat(r11.element);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
    L21:
        return r10;
    L16:
        ResultKt.throwOnFailure(r10);
        if (this.state.getUsePreModifierChangeBehavior$foundation_release() == false) goto L22;
        AnchoredDraggableState<T> r12 = this.state;
        r4.label = 1;
        r10 = r12.settle(r8, r4);
        if (r10 != r2) goto L21;
        return r2;
    L22:
        Ref.FloatRef r13 = new Ref.FloatRef();
        r13.element = r8;
        AnchoredDraggableState<T> r5 = this.state;
        C01342 r6 = new C01342(this, r13, r8, null);
        r4.L$0 = r13;
        r4.label = 2;
        if (AnchoredDraggableState.anchoredDrag$default(r5, null, r6, r4, 1, null) != r2) goto L25;
        return r2;
    L25:
        r11 = r13;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r7, Continuation<? super Unit> r8) {
        Object r9 = AnchoredDraggableState.anchoredDrag$default(this.state, null, new AnonymousClass2(r7, this, null), r8, 1, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$fling(AnchoredDraggableNode r0, float r1, Continuation r2) {
        return r0.fling(r1, r2);
    }

    public AnchoredDraggableNode(AnchoredDraggableState<T> r2, Orientation r3, boolean r4, Boolean r5, MutableInteractionSource r6, OverscrollEffect r7, Boolean r8, FlingBehavior r9) {
        super(AnchoredDraggableKt.access$getAlwaysDrag$p(), r4, r6, r3);
        this.state = r2;
        this.orientation = r3;
        this.reverseDirection = r5;
        this.overscrollEffect = r7;
        this.startDragImmediately = r8;
        this.flingBehavior = r9;
    }

    public final void update(AnchoredDraggableState<T> r10, Orientation r11, boolean r12, Boolean r13, MutableInteractionSource r14, OverscrollEffect r15, Boolean r16, FlingBehavior r17) {
        this.flingBehavior = r17;
        boolean r5 = true;
        if (Intrinsics.areEqual(this.state, r10) == true) goto L5;
        this.state = r10;
        updateFlingBehavior(r17);
        boolean r0 = true;
    L7:
        if (this.orientation == r11) goto L10;
        this.orientation = r11;
        r0 = true;
    L10:
        if (Intrinsics.areEqual(this.reverseDirection, r13) == true) goto L12;
        this.reverseDirection = r13;
    L13:
        this.startDragImmediately = r16;
        this.overscrollEffect = r15;
        DragGestureNode.update$default(this, null, r12, r14, r11, r5, 1, null);
        return;
    L12:
        r5 = r0;
        goto L13
    L5:
        r0 = false;
        goto L7
    }
}
