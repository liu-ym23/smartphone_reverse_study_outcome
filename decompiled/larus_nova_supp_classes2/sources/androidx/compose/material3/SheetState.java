package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eBC\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0011J\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010'\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010(\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J0\u0010)\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060+2\b\b\u0002\u0010,\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b-\u0010.J\u0018\u0010/\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\tH\u0080@¢\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b3\u00104R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\f\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R \u00105\u001a\b\u0012\u0004\u0012\u00020\u000606X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010;\u001a\b\u0012\u0004\u0012\u00020\t0<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR \u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010H¨\u0006M"}, d2 = {"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "density", "Landroidx/compose/ui/unit/Density;", "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "getSkipPartiallyExpanded$material3", "()Z", "getConfirmValueChange$material3", "()Lkotlin/jvm/functions/Function1;", "getSkipHiddenState$material3", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "targetValue", "getTargetValue", "isVisible", "isAnimationRunning", "requireOffset", "hasExpandedState", "getHasExpandedState", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "partialExpand", "show", "hide", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "velocity", "animateTo$material3", "(Landroidx/compose/material3/SheetValue;Landroidx/compose/animation/core/FiniteAnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material3", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settle", "settle$material3", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggableMotionSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getAnchoredDraggableMotionSpec$material3", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnchoredDraggableMotionSpec$material3", "(Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setAnchoredDraggableState$material3", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "offset", "getOffset$material3", "()F", "showMotionSpec", "getShowMotionSpec$material3", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setShowMotionSpec$material3", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "hideMotionSpec", "getHideMotionSpec$material3", "setHideMotionSpec$material3", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SheetState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private AnimationSpec<Float> anchoredDraggableMotionSpec;
    private AnchoredDraggableState<SheetValue> anchoredDraggableState;
    private final Function1<SheetValue, Boolean> confirmValueChange;
    private FiniteAnimationSpec<Float> hideMotionSpec;
    private FiniteAnimationSpec<Float> showMotionSpec;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\tJ@\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "density", "Landroidx/compose/ui/unit/Density;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ float a(Density r0) {
            return Saver$lambda$3(r0);
        }

        public static /* synthetic */ SheetState b(boolean r0, Function0 r1, Function0 r2, Function1 r3, boolean r4, SheetValue r5) {
            return Saver$lambda$1(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ SheetValue c(SaverScope r0, SheetState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ float d(Density r0) {
            return Saver$lambda$5(r0);
        }

        private static final float Saver$lambda$3(Density r1) {
            return r1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.m2334getPositionalThresholdD9Ej5fM$material3());
        }

        private static final float Saver$lambda$5(Density r1) {
            return r1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.m2337getVelocityThresholdD9Ej5fM$material3());
        }

        private static final SheetValue Saver$lambda$0(SaverScope r0, SheetState r1) {
            return r1.getCurrentValue();
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
        public final /* synthetic */ Saver Saver(boolean r7, Function1 r8, final Density r9, boolean r10) {
            return Saver(r7, new fo(r9), new go(r9), r8, r10);
        }

        public final Saver<SheetState, SheetValue> Saver(final boolean r9, final Function0<Float> r10, final Function0<Float> r11, final Function1<? super SheetValue, Boolean> r12, final boolean r13) {
            return SaverKt.Saver(new ho(), new io(r9, r10, r11, r12, r13));
        }

        private static final SheetState Saver$lambda$1(boolean r8, Function0 r9, Function0 r10, Function1 r11, boolean r12, SheetValue r13) {
            return new SheetState(r8, r9, r10, r13, r11, r12);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(SheetValue r0) {
        return true;
    }

    private static final boolean _init_$lambda$7(SheetValue r0) {
        return true;
    }

    public static /* synthetic */ float a(Density r0) {
        return _init_$lambda$9(r0);
    }

    public static /* synthetic */ boolean b(SheetValue r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ AnimationSpec c(SheetState r0) {
        return anchoredDraggableState$lambda$6(r0);
    }

    public static /* synthetic */ float d(Density r0) {
        return _init_$lambda$11(r0);
    }

    public static /* synthetic */ boolean e(SheetValue r0) {
        return _init_$lambda$7(r0);
    }

    public static /* synthetic */ float f(Function0 r0, float r1) {
        return anchoredDraggableState$lambda$5(r0, r1);
    }

    public final SheetValue getCurrentValue() {
        return (SheetValue) this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.PartiallyExpanded);
    }

    public final float getOffset$material3() {
        return this.anchoredDraggableState.getOffset();
    }

    public final SheetValue getTargetValue() {
        return (SheetValue) this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isVisible() {
        if (this.anchoredDraggableState.getCurrentValue() == SheetValue.Hidden) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnimationSpec<Float> getAnchoredDraggableMotionSpec$material3() {
        return this.anchoredDraggableMotionSpec;
    }

    public final AnchoredDraggableState<SheetValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final Function1<SheetValue, Boolean> getConfirmValueChange$material3() {
        return this.confirmValueChange;
    }

    public final FiniteAnimationSpec<Float> getHideMotionSpec$material3() {
        return this.hideMotionSpec;
    }

    public final FiniteAnimationSpec<Float> getShowMotionSpec$material3() {
        return this.showMotionSpec;
    }

    public final boolean getSkipHiddenState$material3() {
        return this.skipHiddenState;
    }

    public final boolean getSkipPartiallyExpanded$material3() {
        return this.skipPartiallyExpanded;
    }

    private static final float _init_$lambda$11(Density r1) {
        return r1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.m2337getVelocityThresholdD9Ej5fM$material3());
    }

    private static final float _init_$lambda$9(Density r1) {
        return r1.toPx-0680j_4(BottomSheetDefaults.INSTANCE.m2334getPositionalThresholdD9Ej5fM$material3());
    }

    private static final AnimationSpec anchoredDraggableState$lambda$6(SheetState r0) {
        return r0.anchoredDraggableMotionSpec;
    }

    public final Object expand(Continuation<? super Unit> r9) {
        Function1<SheetValue, Boolean> r0 = this.confirmValueChange;
        SheetValue r2 = SheetValue.Expanded;
        if (((Boolean) r0.invoke(r2)).booleanValue() == false) goto L10;
        Object r10 = animateTo$material3$default(this, r2, this.showMotionSpec, MenuKt.ClosedAlphaTarget, r9, 4, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r10;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> r9) {
        if ((!this.skipHiddenState) == false) goto L14;
        Function1<SheetValue, Boolean> r0 = this.confirmValueChange;
        SheetValue r2 = SheetValue.Hidden;
        if (((Boolean) r0.invoke(r2)).booleanValue() == false) goto L12;
        Object r10 = animateTo$material3$default(this, r2, this.hideMotionSpec, MenuKt.ClosedAlphaTarget, r9, 4, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r10;
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
    }

    public final Object partialExpand(Continuation<? super Unit> r9) {
        if ((!this.skipPartiallyExpanded) == false) goto L14;
        Function1<SheetValue, Boolean> r0 = this.confirmValueChange;
        SheetValue r2 = SheetValue.PartiallyExpanded;
        if (((Boolean) r0.invoke(r2)).booleanValue() == false) goto L12;
        Object r10 = animateTo$material3$default(this, r2, this.hideMotionSpec, MenuKt.ClosedAlphaTarget, r9, 4, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r10;
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
    }

    public final void setAnchoredDraggableMotionSpec$material3(AnimationSpec<Float> r1) {
        this.anchoredDraggableMotionSpec = r1;
    }

    public final void setAnchoredDraggableState$material3(AnchoredDraggableState<SheetValue> r1) {
        this.anchoredDraggableState = r1;
    }

    public final void setHideMotionSpec$material3(FiniteAnimationSpec<Float> r1) {
        this.hideMotionSpec = r1;
    }

    public final void setShowMotionSpec$material3(FiniteAnimationSpec<Float> r1) {
        this.showMotionSpec = r1;
    }

    public final Object show(Continuation<? super Unit> r9) {
        if (getHasPartiallyExpandedState() == false) goto L5;
        SheetValue r0 = SheetValue.PartiallyExpanded;
    L6:
        SheetValue r2 = r0;
        if (((Boolean) this.confirmValueChange.invoke(r2)).booleanValue() == false) goto L14;
        Object r10 = animateTo$material3$default(this, r2, this.showMotionSpec, MenuKt.ClosedAlphaTarget, r9, 4, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r10;
    L12:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L5:
        r0 = SheetValue.Expanded;
        goto L6
    }

    private static final float anchoredDraggableState$lambda$5(Function0 r0, float r1) {
        return ((Number) r0.invoke()).floatValue();
    }

    public final Object settle$material3(float r2, Continuation<? super Unit> r3) {
        Object r4 = this.anchoredDraggableState.settle(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final Object snapTo$material3(SheetValue r2, Continuation<? super Unit> r3) {
        Object r4 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo$material3(SheetValue r8, FiniteAnimationSpec<Float> r9, float r10, Continuation<? super Unit> r11) {
        Object r12 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, r8, null, new SheetState$animateTo$2(this, r10, r9, null), r11, 2, null);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    public /* synthetic */ SheetState(boolean r8, final Density r9, SheetValue r10, Function1 r11, boolean r12) {
        this(r8, new zn(r9), new ao(r9), r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SheetState(boolean r9, final Function0<Float> r10, Function0<Float> r11, SheetValue r12, Function1<? super SheetValue, Boolean> r13, boolean r14) {
        this.skipPartiallyExpanded = r9;
        this.confirmValueChange = r13;
        this.skipHiddenState = r14;
        if (r9 == true) goto L5;
    L12:
        if (r14 == true) goto L14;
    L21:
        this.anchoredDraggableMotionSpec = SheetDefaultsKt.access$getBottomSheetAnimationSpec$p();
        this.anchoredDraggableState = new AnchoredDraggableState(r12, new co(r10), r11, new Cdo(this), r13);
        this.showMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        this.hideMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        return;
    L14:
        if (r12 == SheetValue.Hidden) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == true) goto L21;
        throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
    L16:
        r15 = false;
        goto L17
    L5:
        if (r12 == SheetValue.PartiallyExpanded) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == true) goto L12;
        throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
    L7:
        r16 = false;
        goto L8
    }

    public /* synthetic */ SheetState(boolean r7, Density r8, SheetValue r9, Function1 r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = SheetValue.Hidden;
    L5:
        SheetValue r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = new eo();
    L8:
        Function1 r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        boolean r5 = false;
    L12:
        this(r7, r8, r3, r4, r5);
        return;
    L11:
        r5 = r11;
        goto L12
    }

    public static /* synthetic */ Object animateTo$material3$default(SheetState r0, SheetValue r1, FiniteAnimationSpec r2, float r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = r0.anchoredDraggableState.getLastVelocity();
    L6:
        return r0.animateTo$material3(r1, r2, r3, r4);
    }

    public /* synthetic */ SheetState(boolean r8, Function0 r9, Function0 r10, SheetValue r11, Function1 r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = SheetValue.Hidden;
    L5:
        SheetValue r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = new bo();
    L8:
        Function1 r5 = r12;
        if ((r14 & 32) == 0) goto L11;
        boolean r6 = false;
    L12:
        this(r8, r9, r10, r4, r5, r6);
        return;
    L11:
        r6 = r13;
        goto L12
    }
}
