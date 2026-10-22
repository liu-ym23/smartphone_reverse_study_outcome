package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.AnchoredDragScope;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchors;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001f\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020 H\u0086@¢\u0006\u0002\u0010!J$\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0&H\u0087@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010)J\b\u0010B\u001a\u000204H\u0002J\r\u0010C\u001a\u00020\rH\u0000¢\u0006\u0002\bDJ.\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00032\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\r0&2\b\b\u0002\u0010F\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010GR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u001dR\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0,8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b1\u00102R/\u00105\u001a\u0004\u0018\u0001042\b\u00103\u001a\u0004\u0018\u0001048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010<\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R \u0010?\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011¨\u0006I"}, d2 = {"Landroidx/compose/material3/DrawerState;", "", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "getConfirmStateChange$material3", "()Lkotlin/jvm/functions/Function1;", "anchoredDraggableMotionSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getAnchoredDraggableMotionSpec$material3", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnchoredDraggableMotionSpec$material3", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getAnchoredDraggableState$material3$annotations", "()V", "getAnchoredDraggableState$material3", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "isOpen", "()Z", "isClosed", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/DrawerValue;", "isAnimationRunning", "open", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "animateTo", "targetValue", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Landroidx/compose/material3/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTargetValue", "offset", "Landroidx/compose/runtime/State;", "getOffset$annotations", "getOffset", "()Landroidx/compose/runtime/State;", "currentOffset", "getCurrentOffset", "()F", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$material3", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "openDrawerMotionSpec", "getOpenDrawerMotionSpec$material3", "setOpenDrawerMotionSpec$material3", "closeDrawerMotionSpec", "getCloseDrawerMotionSpec$material3", "setCloseDrawerMotionSpec$material3", "requireDensity", "requireOffset", "requireOffset$material3", "animationSpec", "velocity", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawerState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private FiniteAnimationSpec<Float> anchoredDraggableMotionSpec;
    private final AnchoredDraggableState<DrawerValue> anchoredDraggableState;
    private FiniteAnimationSpec<Float> closeDrawerMotionSpec;
    private final Function1<DrawerValue, Boolean> confirmStateChange;
    private final MutableState density$delegate;
    private final State<Float> offset;
    private FiniteAnimationSpec<Float> openDrawerMotionSpec;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/DrawerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DrawerState;", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ DrawerState a(Function1 r0, DrawerValue r1) {
            return Saver$lambda$1(r0, r1);
        }

        public static /* synthetic */ DrawerValue b(SaverScope r0, DrawerState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public final Saver<DrawerState, DrawerValue> Saver(final Function1<? super DrawerValue, Boolean> r3) {
            return SaverKt.Saver(new w9(), new x9(r3));
        }

        private static final DrawerValue Saver$lambda$0(SaverScope r0, DrawerState r1) {
            return r1.getCurrentValue();
        }

        private static final DrawerState Saver$lambda$1(Function1 r1, DrawerValue r2) {
            return new DrawerState(r2, r1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DrawerState$animateTo$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "Landroidx/compose/material3/DrawerValue;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.DrawerState$animateTo$3", f = "NavigationDrawer.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<DrawerValue>, DrawerValue, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;
        final /* synthetic */ DrawerState this$0;

        public AnonymousClass3(DrawerState r1, float r2, AnimationSpec<Float> r3, Continuation<? super AnonymousClass3> r4) {
            this.this$0 = r1;
            this.$velocity = r2;
            this.$animationSpec = r3;
            super(4, r4);
        }

        public static /* synthetic */ Unit a(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3);
        }

        public final Object invoke(AnchoredDragScope r5, DraggableAnchors<DrawerValue> r6, DrawerValue r7, Continuation<? super Unit> r8) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$velocity, this.$animationSpec, r8);
            r0.L$0 = r5;
            r0.L$1 = r6;
            r0.L$2 = r7;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, (DrawerValue) r3, (Continuation) r4);
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
            float r5 = ((DraggableAnchors) this.L$1).positionOf((DrawerValue) this.L$2);
            if (Float.isNaN(r5) == true) goto L18;
            final Ref.FloatRef r2 = new Ref.FloatRef();
            if (Float.isNaN(this.this$0.getCurrentOffset()) == false) goto L13;
            float r4 = MenuKt.ClosedAlphaTarget;
        L14:
            r2.element = r4;
            float r6 = this.$velocity;
            AnimationSpec<Float> r7 = this.$animationSpec;
            Function2 r8 = new y9(r12, r2);
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

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(DrawerValue r0) {
        return true;
    }

    public static /* synthetic */ float a(DrawerState r0) {
        return anchoredDraggableState$lambda$3(r0);
    }

    public static /* synthetic */ float b(float r0) {
        return anchoredDraggableState$lambda$1(r0);
    }

    public static /* synthetic */ boolean c(DrawerValue r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ void getAnchoredDraggableState$material3$annotations() {
    }

    @Deprecated(message = "Please access the offset through currentOffset, which returns the value directly instead of wrapping it in a state object.", replaceWith = @ReplaceWith(expression = "currentOffset", imports = {}))
    public static /* synthetic */ void getOffset$annotations() {
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final DrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getSettledValue();
    }

    public final Density getDensity$material3() {
        return (Density) this.density$delegate.getValue();
    }

    public final DrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final float requireOffset$material3() {
        return this.anchoredDraggableState.requireOffset();
    }

    private final Density requireDensity() {
        Density r0 = getDensity$material3();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the ModalNavigationDrawer or DismissibleNavigationDrawer composables?").toString());
    }

    public final boolean isClosed() {
        if (getCurrentValue() != DrawerValue.Closed) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOpen() {
        if (getCurrentValue() != DrawerValue.Open) goto L5;
        return true;
    L5:
        return false;
    }

    public final FiniteAnimationSpec<Float> getAnchoredDraggableMotionSpec$material3() {
        return this.anchoredDraggableMotionSpec;
    }

    public final AnchoredDraggableState<DrawerValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final FiniteAnimationSpec<Float> getCloseDrawerMotionSpec$material3() {
        return this.closeDrawerMotionSpec;
    }

    public final Function1<DrawerValue, Boolean> getConfirmStateChange$material3() {
        return this.confirmStateChange;
    }

    public final State<Float> getOffset() {
        return this.offset;
    }

    public final FiniteAnimationSpec<Float> getOpenDrawerMotionSpec$material3() {
        return this.openDrawerMotionSpec;
    }

    private static final float anchoredDraggableState$lambda$1(float r1) {
        return r1 * NavigationDrawerKt.access$getDrawerPositionalThreshold$p();
    }

    private static final float anchoredDraggableState$lambda$3(DrawerState r1) {
        return r1.requireDensity().toPx-0680j_4(NavigationDrawerKt.access$getDrawerVelocityThreshold$p());
    }

    public final Object close(Continuation<? super Unit> r8) {
        Object r9 = animateTo$default(this, DrawerValue.Closed, this.closeDrawerMotionSpec, MenuKt.ClosedAlphaTarget, r8, 4, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    public final Object open(Continuation<? super Unit> r8) {
        Object r9 = animateTo$default(this, DrawerValue.Open, this.openDrawerMotionSpec, MenuKt.ClosedAlphaTarget, r8, 4, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    public final void setAnchoredDraggableMotionSpec$material3(FiniteAnimationSpec<Float> r1) {
        this.anchoredDraggableMotionSpec = r1;
    }

    public final void setCloseDrawerMotionSpec$material3(FiniteAnimationSpec<Float> r1) {
        this.closeDrawerMotionSpec = r1;
    }

    public final void setDensity$material3(Density r2) {
        this.density$delegate.setValue(r2);
    }

    public final void setOpenDrawerMotionSpec$material3(FiniteAnimationSpec<Float> r1) {
        this.openDrawerMotionSpec = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DrawerState(DrawerValue r7, Function1<? super DrawerValue, Boolean> r8) {
        this.confirmStateChange = r8;
        TweenSpec r3 = NavigationDrawerKt.access$getAnchoredDraggableDefaultAnimationSpec$p();
        this.anchoredDraggableMotionSpec = r3;
        DecayAnimationSpec<Float> r4 = AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec();
        this.anchoredDraggableState = AnchoredDraggableKt.AnchoredDraggableState(r7, new t9(), new u9(this), r3, r4, r8);
        this.offset = new DrawerState$offset$1(this);
        this.density$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.openDrawerMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        this.closeDrawerMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
    }

    public final Object snapTo(DrawerValue r2, Continuation<? super Unit> r3) {
        Object r4 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Deprecated(message = "This method has been replaced by the open and close methods. The animation spec is now an implementation detail of ModalDrawer.")
    public final Object animateTo(DrawerValue r8, AnimationSpec<Float> r9, Continuation<? super Unit> r10) {
        Object r11 = animateTo$default(this, r8, r9, MenuKt.ClosedAlphaTarget, r10, 4, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public /* synthetic */ DrawerState(DrawerValue r1, Function1 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new v9();
    L5:
        this(r1, r2);
    }

    private final Object animateTo(DrawerValue r8, AnimationSpec<Float> r9, float r10, Continuation<? super Unit> r11) {
        Object r12 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, r8, null, new AnonymousClass3(this, r10, r9, null), r11, 2, null);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$animateTo(DrawerState r0, DrawerValue r1, AnimationSpec r2, float r3, Continuation r4) {
        return r0.animateTo(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object animateTo$default(DrawerState r0, DrawerValue r1, AnimationSpec r2, float r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = r0.anchoredDraggableState.getLastVelocity();
    L6:
        return r0.animateTo(r1, r2, r3, r4);
    }
}
