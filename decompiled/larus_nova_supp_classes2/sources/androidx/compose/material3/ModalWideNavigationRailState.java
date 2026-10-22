package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.internal.AnchoredDragScope;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001d\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\"\u0010#J0\u0010'\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010!\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010(R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Landroidx/compose/material3/ModalWideNavigationRailState;", "Landroidx/compose/material3/WideNavigationRailState;", "state", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/unit/Density;Landroidx/compose/animation/core/AnimationSpec;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "Landroidx/compose/material3/WideNavigationRailValue;", "getAnchoredDraggableState$material3", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/WideNavigationRailValue;", "targetValue", "getTargetValue", "isAnimating", "", "()Z", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "toggle", "snapTo", "(Landroidx/compose/material3/WideNavigationRailValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settle", "velocity", "settle$material3", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentOffset", "getCurrentOffset", "()F", "animateTo", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalWideNavigationRailState implements WideNavigationRailState {
    public static final int $stable = 8;
    private final /* synthetic */ WideNavigationRailState $$delegate_0;
    private final AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;

    /* JADX INFO: renamed from: androidx.compose.material3.ModalWideNavigationRailState$animateTo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/material3/WideNavigationRailValue;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ModalWideNavigationRailState$animateTo$2", f = "WideNavigationRailState.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<WideNavigationRailValue>, WideNavigationRailValue, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;
        final /* synthetic */ ModalWideNavigationRailState this$0;

        public AnonymousClass2(ModalWideNavigationRailState r1, float r2, AnimationSpec<Float> r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$velocity = r2;
            this.$animationSpec = r3;
            super(4, r4);
        }

        public static /* synthetic */ Unit a(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3);
        }

        public final Object invoke(AnchoredDragScope r5, DraggableAnchors<WideNavigationRailValue> r6, WideNavigationRailValue r7, Continuation<? super Unit> r8) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$velocity, this.$animationSpec, r8);
            r0.L$0 = r5;
            r0.L$1 = r6;
            r0.L$2 = r7;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, (WideNavigationRailValue) r3, (Continuation) r4);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            final AnchoredDragScope r12 = (AnchoredDragScope) this.L$0;
            float r5 = ((DraggableAnchors) this.L$1).positionOf((WideNavigationRailValue) this.L$2);
            if (Float.isNaN(r5) == true) goto L18;
            final Ref.FloatRef r2 = new Ref.FloatRef();
            if (Float.isNaN(this.this$0.getCurrentOffset()) == false) goto L13;
            float r4 = MenuKt.ClosedAlphaTarget;
        L14:
            r2.element = r4;
            float r6 = this.$velocity;
            AnimationSpec<Float> r7 = this.$animationSpec;
            Function2 r8 = new mf(r12, r2);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (SuspendAnimationKt.animate(r4, r5, r6, r7, r8, this) != r0) goto L18;
            return r0;
        L13:
            r4 = this.this$0.getCurrentOffset();
            goto L14
        }

        private static final Unit invokeSuspend$lambda$0(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
            r0.dragTo(r2, r3);
            r1.element = r2;
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ float a(float r0) {
        return anchoredDraggableState$lambda$0(r0);
    }

    private static final float anchoredDraggableState$lambda$0(float r1) {
        return r1 * 0.5f;
    }

    public static /* synthetic */ AnimationSpec b(ModalWideNavigationRailState r0) {
        return anchoredDraggableState$lambda$3(r0);
    }

    public static /* synthetic */ float c(Density r0) {
        return anchoredDraggableState$lambda$2(r0);
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getCurrentValue() {
        return (WideNavigationRailValue) this.anchoredDraggableState.getCurrentValue();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getTargetValue() {
        return (WideNavigationRailValue) this.anchoredDraggableState.getTargetValue();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public boolean isAnimating() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final AnchoredDraggableState<WideNavigationRailValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    private static final float anchoredDraggableState$lambda$2(Density r1) {
        return r1.toPx-0680j_4(Dp.constructor-impl(400));
    }

    private static final AnimationSpec anchoredDraggableState$lambda$3(ModalWideNavigationRailState r0) {
        return r0.animationSpec;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object collapse(Continuation<? super Unit> r8) {
        Object r9 = animateTo$default(this, WideNavigationRailValue.Collapsed, null, MenuKt.ClosedAlphaTarget, r8, 6, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object expand(Continuation<? super Unit> r8) {
        Object r9 = animateTo$default(this, WideNavigationRailValue.Expanded, null, MenuKt.ClosedAlphaTarget, r8, 6, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object toggle(Continuation<? super Unit> r9) {
        Object r10 = animateTo$default(this, WideNavigationRailStateKt.not(getTargetValue()), null, MenuKt.ClosedAlphaTarget, r9, 6, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final Object settle$material3(float r2, Continuation<? super Unit> r3) {
        Object r4 = this.anchoredDraggableState.settle(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object snapTo(WideNavigationRailValue r2, Continuation<? super Unit> r3) {
        Object r4 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public ModalWideNavigationRailState(WideNavigationRailState r9, final Density r10, AnimationSpec<Float> r11) {
        this.$$delegate_0 = r9;
        this.animationSpec = r11;
        this.anchoredDraggableState = new AnchoredDraggableState(r9.getTargetValue(), new jf(), new kf(r10), new lf(this), null, 16, null);
    }

    private final Object animateTo(WideNavigationRailValue r8, AnimationSpec<Float> r9, float r10, Continuation<? super Unit> r11) {
        Object r12 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, r8, null, new AnonymousClass2(this, r10, r9, null), r11, 2, null);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$animateTo(ModalWideNavigationRailState r0, WideNavigationRailValue r1, AnimationSpec r2, float r3, Continuation r4) {
        return r0.animateTo(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(ModalWideNavigationRailState r0, WideNavigationRailValue r1, AnimationSpec r2, float r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = r0.animationSpec;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = r0.anchoredDraggableState.getLastVelocity();
    L9:
        return r0.animateTo(r1, r2, r3, r4);
    }
}
