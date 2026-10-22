package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B4\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\n\u0010\u000bBR\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u0005\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\n\u0010\u0010J\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010-\u001a\u00020.2\u0006\u0010#\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020.H\u0086@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010/R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0017\u0010'\u001a\u00020\u00068G¢\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010\u001eR\u0011\u0010+\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\"¨\u00065"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState;", "", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "<init>", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;)V", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getAnchoredDraggableState$material3", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getPositionalThreshold$material3", "()Lkotlin/jvm/functions/Function1;", "setPositionalThreshold$material3", "(Lkotlin/jvm/functions/Function1;)V", "useFlingBehavior", "getUseFlingBehavior$material3", "()Z", "offset", "getOffset$material3", "()F", "requireOffset", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SwipeToDismissBoxValue;", "targetValue", "getTargetValue", "settledValue", "getSettledValue", "progress", "getProgress$annotations", "()V", "getProgress", "dismissDirection", "getDismissDirection", "snapTo", "", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "direction", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeToDismissBoxState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState;
    public Function1<? super Float, Float> positionalThreshold;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J5\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f0\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeToDismissBoxState;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "density", "Landroidx/compose/ui/unit/Density;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ SwipeToDismissBoxState a(Function1 r0, SwipeToDismissBoxValue r1) {
            return Saver$lambda$3(r0, r1);
        }

        public static /* synthetic */ SwipeToDismissBoxValue b(SaverScope r0, SwipeToDismissBoxState r1) {
            return Saver$lambda$2(r0, r1);
        }

        public static /* synthetic */ SwipeToDismissBoxState c(Density r0, Function1 r1, Function1 r2, SwipeToDismissBoxValue r3) {
            return Saver$lambda$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ SwipeToDismissBoxValue d(SaverScope r0, SwipeToDismissBoxState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public final Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver(final Function1<? super Float, Float> r3) {
            return SaverKt.Saver(new ur(), new vr(r3));
        }

        private static final SwipeToDismissBoxValue Saver$lambda$0(SaverScope r0, SwipeToDismissBoxState r1) {
            return r1.getCurrentValue();
        }

        private static final SwipeToDismissBoxValue Saver$lambda$2(SaverScope r0, SwipeToDismissBoxState r1) {
            return r1.getCurrentValue();
        }

        private static final SwipeToDismissBoxState Saver$lambda$3(Function1 r1, SwipeToDismissBoxValue r2) {
            return new SwipeToDismissBoxState(r2, r1);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.", replaceWith = @ReplaceWith(expression = "Saver(positionalThreshold, density)", imports = {}))
        public final Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver(final Function1<? super SwipeToDismissBoxValue, Boolean> r3, final Function1<? super Float, Float> r4, final Density r5) {
            return SaverKt.Saver(new sr(), new tr(r5, r3, r4));
        }

        private static final SwipeToDismissBoxState Saver$lambda$1(Density r1, Function1 r2, Function1 r3, SwipeToDismissBoxValue r4) {
            return new SwipeToDismissBoxState(r4, r1, r2, r3);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    private static final boolean _init_$lambda$0(SwipeToDismissBoxValue r0) {
        return true;
    }

    public static /* synthetic */ boolean a(SwipeToDismissBoxValue r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ float b(Density r0) {
        return _init_$lambda$2(r0);
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    public final SwipeToDismissBoxValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final float getOffset$material3() {
        return this.anchoredDraggableState.getOffset();
    }

    public final Function1<Float, Float> getPositionalThreshold$material3() {
        Function1 r0 = this.positionalThreshold;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final SwipeToDismissBoxValue getSettledValue() {
        return this.anchoredDraggableState.getSettledValue();
    }

    public final SwipeToDismissBoxValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean getUseFlingBehavior$material3() {
        if (this.positionalThreshold == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final SwipeToDismissBoxValue getDismissDirection() {
        if (getOffset$material3() != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L15;
        if (Float.isNaN(getOffset$material3()) == true) goto L15;
        if (getOffset$material3() <= MenuKt.ClosedAlphaTarget) goto L17;
        return SwipeToDismissBoxValue.StartToEnd;
    L17:
        return SwipeToDismissBoxValue.EndToStart;
    L15:
        return SwipeToDismissBoxValue.Settled;
    L5:
        r0 = false;
        goto L6
    }

    public final AnchoredDraggableState<SwipeToDismissBoxValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    private static final float _init_$lambda$2(Density r1) {
        return r1.toPx-0680j_4(SwipeToDismissBoxKt.access$getDismissVelocityThreshold$p());
    }

    public final Object reset(Continuation<? super Unit> r7) {
        Object r8 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SwipeToDismissBoxValue.Settled, null, r7, 2, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public final void setPositionalThreshold$material3(Function1<? super Float, Float> r1) {
        this.positionalThreshold = r1;
    }

    public SwipeToDismissBoxState(SwipeToDismissBoxValue r2, Function1<? super Float, Float> r3) {
        this.anchoredDraggableState = new AnchoredDraggableState(r2);
        setPositionalThreshold$material3(r3);
    }

    public final Object dismiss(SwipeToDismissBoxValue r7, Continuation<? super Unit> r8) {
        Object r9 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, r7, null, r8, 2, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    public final Object snapTo(SwipeToDismissBoxValue r2, Continuation<? super Unit> r3) {
        Object r4 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.", replaceWith = @ReplaceWith(expression = "SwipeToDismissBoxState(initialValue, density, positionalThreshold)", imports = {}))
    public SwipeToDismissBoxState(SwipeToDismissBoxValue r8, final Density r9, Function1<? super SwipeToDismissBoxValue, Boolean> r10, Function1<? super Float, Float> r11) {
        AnchoredDraggableDefaults r0 = AnchoredDraggableDefaults.INSTANCE;
        AnimationSpec<Float> r4 = r0.getSnapAnimationSpec();
        DecayAnimationSpec<Float> r5 = r0.getDecayAnimationSpec();
        this.anchoredDraggableState = AnchoredDraggableKt.AnchoredDraggableState(r8, r11, new rr(r9), r4, r5, r10);
    }

    public /* synthetic */ SwipeToDismissBoxState(SwipeToDismissBoxValue r1, Density r2, Function1 r3, Function1 r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = new qr();
    L5:
        this(r1, r2, r3, r4);
    }
}
