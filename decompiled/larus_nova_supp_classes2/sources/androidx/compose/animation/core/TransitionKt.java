package androidx.compose.animation.core;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a3\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00152\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0016\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00172\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0018\u001aa\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0 R\b\u0012\u0004\u0012\u0002H\"0\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0%2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010&\u001a\\\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\"0\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u0010(\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00020\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010-\u001aA\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0006\u0010/\u001a\u0002H\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u00100\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00101\u001a¦\u0001\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000203\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0%2*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0002060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u0002H\u00020\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010:\u001am\u0010;\u001a\b\u0012\u0004\u0012\u0002H\u000203\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0006\u0010<\u001a\u0002H\u00022\u0006\u0010=\u001a\u0002H\u00022\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u0002062\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0%2\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010?\u001ai\u0010@\u001a\u00020\f\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u001c\u0010A\u001a\u0018\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0BR\b\u0012\u0004\u0012\u0002H\"0\u00012\u0006\u0010<\u001a\u0002H\u00022\u0006\u0010=\u001a\u0002H\u00022\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u000206H\u0003¢\u0006\u0002\u0010C\u001a\u0082\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001a03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001a0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001a\u0082\u0001\u0010F\u001a\b\u0012\u0004\u0012\u00020G03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020G060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020G0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001a\u0082\u0001\u0010H\u001a\b\u0012\u0004\u0012\u00020I03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020I060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020I0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001a\u0082\u0001\u0010J\u001a\b\u0012\u0004\u0012\u00020K03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020K060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020K0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001a\u0082\u0001\u0010L\u001a\b\u0012\u0004\u0012\u00020M03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020M060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020M0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001a\u0082\u0001\u0010N\u001a\b\u0012\u0004\u0012\u00020\b03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001a\u0082\u0001\u0010O\u001a\b\u0012\u0004\u0012\u00020P03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020P060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020P0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001a\u0082\u0001\u0010Q\u001a\b\u0012\u0004\u0012\u00020R03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020R060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\u00108\u001a\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020R0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u001e\u0010\t\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001b\u0010\r\u001a\u00020\u000e8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"updateTransition", "Landroidx/compose/animation/core/Transition;", "T", "targetState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "AnimationDebugDurationScale", "", "SeekableTransitionStateTotalDurationChanged", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", "", "SeekableStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "Lkotlin/Lazy;", "rememberTransition", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "NoReset", "", "ResetNoSnap", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "V", "S", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createChildTransition", "transformToChildState", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "parentState", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "animateValue", "Landroidx/compose/runtime/State;", "transitionSpec", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "state", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "UpdateInitialAndTargetValues", "transitionAnimation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)V", "animateFloat", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDp", "Landroidx/compose/ui/unit/Dp;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateInt", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animation-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;
    private static final float NoReset = -1.0f;
    private static final float ResetAnimationSnap = -3.0f;
    private static final float ResetAnimationSnapCurrent = -4.0f;
    private static final float ResetAnimationSnapTarget = -5.0f;
    private static final float ResetNoSnap = -2.0f;
    private static final Lazy SeekableStateObserver$delegate = null;
    private static final Function1<SeekableTransitionState<?>, Unit> SeekableTransitionStateTotalDurationChanged = null;

    private static final Unit UpdateInitialAndTargetValues$lambda$32(Transition r7, Transition.TransitionAnimationState r8, Object r9, Object r10, FiniteAnimationSpec r11, int r12, Composer r13, int r14) {
        UpdateInitialAndTargetValues(r7, r8, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ SnapshotStateObserver a() {
        return SeekableStateObserver_delegate$lambda$7();
    }

    public static /* synthetic */ Unit b(Function0 r0) {
        return SeekableStateObserver_delegate$lambda$7$lambda$5(r0);
    }

    public static /* synthetic */ DisposableEffectResult c(Transition r0, DisposableEffectScope r1) {
        return updateTransition$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ DisposableEffectResult d(Transition r0, Transition r1, DisposableEffectScope r2) {
        return createChildTransitionInternal$lambda$22$lambda$21(r0, r1, r2);
    }

    public static /* synthetic */ DisposableEffectResult e(Transition r0, Transition.DeferredAnimation r1, DisposableEffectScope r2) {
        return createDeferredAnimation$lambda$17$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ DisposableEffectResult f(Transition r0, DisposableEffectScope r1) {
        return rememberTransition$lambda$13$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit g(Transition r0, Transition.TransitionAnimationState r1, Object r2, Object r3, FiniteAnimationSpec r4, int r5, Composer r6, int r7) {
        return UpdateInitialAndTargetValues$lambda$32(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ DisposableEffectResult h(Transition r0, Transition.TransitionAnimationState r1, DisposableEffectScope r2) {
        return createTransitionAnimation$lambda$31$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ Unit i(SeekableTransitionState r0) {
        return SeekableTransitionStateTotalDurationChanged$lambda$4(r0);
    }

    static {
        SeekableTransitionStateTotalDurationChanged = new l0();
        SeekableStateObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new m0());
    }

    private static final SnapshotStateObserver SeekableStateObserver_delegate$lambda$7() {
        SnapshotStateObserver r0 = new SnapshotStateObserver(new k0());
        r0.start();
        return r0;
    }

    public static final SnapshotStateObserver getSeekableStateObserver() {
        return (SnapshotStateObserver) SeekableStateObserver$delegate.getValue();
    }

    public static final /* synthetic */ Function1 access$getSeekableTransitionStateTotalDurationChanged$p() {
        return SeekableTransitionStateTotalDurationChanged;
    }

    private static final Unit SeekableStateObserver_delegate$lambda$7$lambda$5(Function0 r0) {
        r0.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit SeekableTransitionStateTotalDurationChanged$lambda$4(SeekableTransitionState r0) {
        r0.onTotalDurationChanged$animation_core();
        return Unit.INSTANCE;
    }

    private static final DisposableEffectResult rememberTransition$lambda$13$lambda$12(final Transition r0, DisposableEffectScope r1) {
        return new TransitionKt$rememberTransition$lambda$13$lambda$12$$inlined$onDispose$1(r0);
    }

    private static final DisposableEffectResult updateTransition$lambda$3$lambda$2(final Transition r0, DisposableEffectScope r1) {
        return new TransitionKt$updateTransition$lambda$3$lambda$2$$inlined$onDispose$1(r0);
    }

    private static final DisposableEffectResult createChildTransitionInternal$lambda$22$lambda$21(final Transition r0, final Transition r1, DisposableEffectScope r2) {
        r0.addTransition$animation_core(r1);
        return new TransitionKt$createChildTransitionInternal$lambda$22$lambda$21$$inlined$onDispose$1(r0, r1);
    }

    private static final DisposableEffectResult createDeferredAnimation$lambda$17$lambda$16(final Transition r0, final Transition.DeferredAnimation r1, DisposableEffectScope r2) {
        return new TransitionKt$createDeferredAnimation$lambda$17$lambda$16$$inlined$onDispose$1(r0, r1);
    }

    private static final DisposableEffectResult createTransitionAnimation$lambda$31$lambda$30(final Transition r0, final Transition.TransitionAnimationState r1, DisposableEffectScope r2) {
        r0.addAnimation$animation_core(r1);
        return new TransitionKt$createTransitionAnimation$lambda$31$lambda$30$$inlined$onDispose$1(r0, r1);
    }

    public static final <T> Transition<T> rememberTransition(TransitionState<T> r9, String r10, Composer r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1643203617, r12, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:804)");
    L8:
        int r14 = (r12 & 14) ^ 6;
        boolean r1 = true;
        if (r14 <= 4) goto L13;
        if (r11.changed(r9) == false) goto L13;
    L14:
        boolean r4 = true;
    L16:
        Object r5 = r11.rememberedValue();
        if (r4 == false) goto L19;
    L20:
        Snapshot.Companion r6 = Snapshot.Companion;
        Snapshot r7 = r6.getCurrentThreadSnapshot();
        if (r7 == null) goto L23;
        Function1 r8 = r7.getReadObserver();
    L24:
        Snapshot r15 = r6.makeCurrentNonObservable(r7);
        Transition r16 = new Transition(r9, r10);     // Catch: Throwable -> L53
        r6.restoreNonObservable(r7, r15, r8);
        r11.updateRememberedValue(r16);
        r5 = r16;
    L27:
        final Transition<T> r17 = (Transition) r5;
        if ((r9 instanceof SeekableTransitionState) == false) goto L43;
        r11.startReplaceGroup(-1357588631);
        SeekableTransitionState r18 = (SeekableTransitionState) r9;
        Object r19 = r18.getCurrentState();
        Object r110 = r18.getTargetState();
        if (r14 <= 4) goto L34;
        if (r11.changed(r9) == false) goto L34;
    L37:
        Object r111 = r11.rememberedValue();
        if (r1 == false) goto L40;
    L41:
        r111 = new TransitionKt$rememberTransition$1$1(r9, null);
        r11.updateRememberedValue(r111);
    L42:
        EffectsKt.LaunchedEffect(r19, r110, (Function2) r111, r11, 0);
        r11.endReplaceGroup();
    L44:
        boolean r20 = r11.changed(r17);
        Object r112 = r11.rememberedValue();
        if (r20 == false) goto L47;
    L48:
        r112 = new i0(r17);
        r11.updateRememberedValue(r112);
    L49:
        EffectsKt.DisposableEffect(r17, (Function1) r112, r11, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L52;
        ComposerKt.traceEventEnd();
    L52:
        return r17;
    L47:
        if (r112 != Composer.Companion.getEmpty()) goto L49;
    L40:
        if (r111 != Composer.Companion.getEmpty()) goto L42;
    L34:
        if ((r12 & 6) == 4) goto L37;
        r1 = false;
        goto L37
    L43:
        r11.startReplaceGroup(-1357127072);
        r17.animateTo$animation_core(r9.getTargetState(), r11, 0);
        r11.endReplaceGroup();
    L53:
        th = move-exception;
        r6.restoreNonObservable(r7, r15, r8);
        throw th;
    L23:
        r8 = null;
        goto L24
    L19:
        if (r5 != Composer.Companion.getEmpty()) goto L27;
    L13:
        if ((r12 & 6) == 4) goto L14;
        r4 = false;
        goto L16
    }

    public static final <T> Transition<T> updateTransition(T r2, String r3, Composer r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(2029166765, r5, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:87)");
    L8:
        Object r7 = r4.rememberedValue();
        Composer.Companion r0 = Composer.Companion;
        if (r7 != r0.getEmpty()) goto L11;
        r7 = new Transition(r2, r3);
        r4.updateRememberedValue(r7);
    L11:
        final Transition<T> r8 = (Transition) r7;
        r8.animateTo$animation_core(r2, r4, ((r5 & 8) | 48) | (r5 & 14));
        Object r9 = r4.rememberedValue();
        if (r9 != r0.getEmpty()) goto L14;
        r9 = new q0(r8);
        r4.updateRememberedValue(r9);
    L14:
        EffectsKt.DisposableEffect(r8, (Function1) r9, r4, 54);
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventEnd();
    L17:
        return r8;
    }

    @Deprecated(message = "Use rememberTransition() instead", replaceWith = @ReplaceWith(expression = "rememberTransition(transitionState, label)", imports = {}))
    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> r2, String r3, Composer r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(882913843, r5, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:863)");
    L8:
        int r7 = r5 & 14;
        Transition<T> r8 = rememberTransition(r2, r3, r4, (r5 & 112) | r7, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r8;
    }

    public static final <S, T> Transition<T> createChildTransition(Transition<S> r7, String r8, Function3<? super S, ? super Composer, ? super Integer, ? extends T> r9, Composer r10, int r11, int r12) {
        boolean r0 = true;
        if ((r12 & 1) == 0) goto L5;
        r8 = "ChildTransition";
    L5:
        String r4 = r8;
        int r13 = r11 & 14;
        if ((r13 ^ 6) <= 4) goto L10;
        if (r10.changed(r7) == false) goto L10;
    L13:
        Object r14 = r10.rememberedValue();
        if (r0 == false) goto L16;
    L17:
        r14 = r7.getCurrentState();
        r10.updateRememberedValue(r14);
    L19:
        if (r7.isSeeking() == false) goto L21;
        r14 = r7.getCurrentState();
    L21:
        int r1 = (r11 >> 3) & 112;
        return createChildTransitionInternal(r7, r9.invoke(r14, r10, Integer.valueOf(r1)), r9.invoke(r7.getTargetState(), r10, Integer.valueOf(r1)), r4, r10, r13 | ((r11 << 6) & 7168));
    L16:
        if (r14 != Composer.Companion.getEmpty()) goto L19;
    L10:
        if ((r11 & 6) == 4) goto L13;
        r0 = false;
        goto L13
    }

    public static final <S, T> Transition<T> createChildTransitionInternal(final Transition<S> r8, T r9, T r10, String r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-198307638, r13, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1780)");
    L5:
        int r0 = (r13 & 14) ^ 6;
        boolean r1 = true;
        if (r0 <= 4) goto L10;
        if (r12.changed(r8) == false) goto L10;
    L11:
        boolean r4 = true;
    L13:
        Object r5 = r12.rememberedValue();
        if (r4 == false) goto L16;
    L17:
        r5 = new Transition(new MutableTransitionState(r9), r8, r8.getLabel() + " > " + r11);
        r12.updateRememberedValue(r5);
    L18:
        final Transition<T> r6 = (Transition) r5;
        if (r0 <= 4) goto L23;
        if (r12.changed(r8) == false) goto L23;
    L26:
        boolean r14 = r12.changed(r6) | r1;
        Object r15 = r12.rememberedValue();
        if (r14 == false) goto L29;
    L30:
        r15 = new n0(r8, r6);
        r12.updateRememberedValue(r15);
    L31:
        EffectsKt.DisposableEffect(r6, (Function1) r15, r12, 0);
        if (r8.isSeeking() == false) goto L34;
        r6.seek(r9, r10, r8.getLastSeekedTimeNanos$animation_core());
    L36:
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r6;
    L34:
        r6.updateTarget$animation_core(r10);
        r6.setSeeking$animation_core(false);
        goto L36
    L29:
        if (r15 != Composer.Companion.getEmpty()) goto L31;
    L23:
        if ((r13 & 6) == 4) goto L26;
        r1 = false;
        goto L26
    L16:
        if (r5 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r13 & 6) == 4) goto L11;
        r4 = false;
        goto L13
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(final Transition<S> r5, TwoWayConverter<T, V> r6, String r7, Composer r8, int r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r7 = "DeferredAnimation";
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(-1714122528, r9, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1738)");
    L8:
        int r11 = (r9 & 14) ^ 6;
        boolean r0 = true;
        if (r11 <= 4) goto L13;
        if (r8.changed(r5) == false) goto L13;
    L14:
        boolean r3 = true;
    L16:
        Object r4 = r8.rememberedValue();
        if (r3 == false) goto L19;
    L20:
        r4 = new Transition.DeferredAnimation(r5, r6, r7);
        r8.updateRememberedValue(r4);
    L21:
        final Transition<S>.DeferredAnimation<T, V> r12 = (Transition.DeferredAnimation) r4;
        if (r11 <= 4) goto L26;
        if (r8.changed(r5) == false) goto L26;
    L29:
        boolean r13 = r8.changedInstance(r12) | r0;
        Object r14 = r8.rememberedValue();
        if (r13 == false) goto L32;
    L33:
        r14 = new j0(r5, r12);
        r8.updateRememberedValue(r14);
    L34:
        EffectsKt.DisposableEffect(r12, (Function1) r14, r8, 0);
        if (r5.isSeeking() == false) goto L38;
        r12.setupSeeking$animation_core();
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventEnd();
    L40:
        return r12;
    L32:
        if (r14 != Composer.Companion.getEmpty()) goto L34;
    L26:
        if ((r9 & 6) == 4) goto L29;
        r0 = false;
        goto L29
    L19:
        if (r4 != Composer.Companion.getEmpty()) goto L21;
    L13:
        if ((r9 & 6) == 4) goto L14;
        r3 = false;
        goto L16
    }

    private static final <S, T, V extends AnimationVector> void UpdateInitialAndTargetValues(final Transition<S> r8, final Transition<S>.TransitionAnimationState<T, V> r9, final T r10, final T r11, final FiniteAnimationSpec<T> r12, Composer r13, final int r14) {
        Composer r15 = r13.startRestartGroup(867041821);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L11:
        if ((r14 & 48) != 0) goto L18;
        if (r15.changed(r9) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r14 & 384) != 0) goto L28;
        if ((r14 & 512) != 0) goto L22;
        boolean r3 = r15.changed(r10);
    L23:
        if (r3 == false) goto L25;
        int r4 = 256;
    L26:
        r1 = r1 | r4;
        goto L28
    L25:
        r4 = 128;
        goto L26
    L22:
        r3 = r15.changedInstance(r10);
    L28:
        if ((r14 & 3072) != 0) goto L38;
        if ((r14 & 4096) != 0) goto L32;
        boolean r5 = r15.changed(r11);
    L33:
        if (r5 == false) goto L35;
        int r6 = 2048;
    L36:
        r1 = r1 | r6;
        goto L38
    L35:
        r6 = 1024;
        goto L36
    L32:
        r5 = r15.changedInstance(r11);
    L38:
        if ((r14 & 24576) != 0) goto L48;
        if ((32768 & r14) != 0) goto L42;
        boolean r7 = r15.changed(r12);
    L43:
        if (r7 == false) goto L45;
        int r16 = 16384;
    L46:
        r1 = r1 | r16;
        goto L48
    L45:
        r16 = 8192;
        goto L46
    L42:
        r7 = r15.changedInstance(r12);
    L48:
        if ((r1 & 9363) == 9362) goto L50;
        boolean r17 = true;
    L52:
        if (r15.shouldExecute(r17, r1 & 1) == true) goto L54;
        r15.skipToGroupEnd();
    L64:
        ScopeUpdateScope r18 = r15.endRestartGroup();
        if (r18 == null) goto L68;
        r18.updateScope(new p0(r8, r9, r10, r11, r12, r14));
        return;
    L68:
        return;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L57;
        ComposerKt.traceEventStart(867041821, r1, -1, "androidx.compose.animation.core.UpdateInitialAndTargetValues (Transition.kt:1907)");
    L57:
        if (r8.isSeeking() == false) goto L59;
        r9.updateInitialAndTargetValue$animation_core(r10, r11, r12);
    L61:
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventEnd();
        goto L64
    L59:
        r9.updateTargetValue$animation_core(r11, r12);
        goto L61
    L50:
        r17 = false;
        goto L52
    L5:
        if (r15.changed(r8) == false) goto L7;
        int r19 = 4;
    L8:
        r1 = r19 | r14;
        goto L11
    L7:
        r19 = 2;
        goto L8
    }

    public static final <S> State<Dp> animateDp(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, Dp> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> r2 = AnonymousClass1.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "DpAnimation";
    L10:
        TwoWayConverter<Dp, AnimationVector1D> r5 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S> State<Float> animateFloat(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, Float> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> r2 = C01171.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "FloatAnimation";
    L10:
        TwoWayConverter<Float, AnimationVector1D> r5 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S> State<Integer> animateInt(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, Integer> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> r2 = C01181.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "IntAnimation";
    L10:
        TwoWayConverter<Integer, AnimationVector1D> r5 = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S> State<IntOffset> animateIntOffset(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, IntOffset> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> r2 = C01191.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "IntOffsetAnimation";
    L10:
        TwoWayConverter<IntOffset, AnimationVector2D> r5 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S> State<IntSize> animateIntSize(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, IntSize> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> r2 = C01201.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "IntSizeAnimation";
    L10:
        TwoWayConverter<IntSize, AnimationVector2D> r5 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S> State<Offset> animateOffset(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, Offset> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> r2 = C01211.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "OffsetAnimation";
    L10:
        TwoWayConverter<Offset, AnimationVector2D> r5 = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S> State<Rect> animateRect(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, Rect> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> r2 = C01221.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "RectAnimation";
    L10:
        TwoWayConverter<Rect, AnimationVector4D> r5 = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S> State<Size> animateSize(Transition<S> r16, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> r17, String r18, Function3<? super S, ? super Composer, ? super Integer, Size> r19, Composer r20, int r21, int r22) {
        if ((r22 & 1) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> r2 = C01231.INSTANCE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r6 = "SizeAnimation";
    L10:
        TwoWayConverter<Size, AnimationVector2D> r5 = VectorConvertersKt.getVectorConverter(Size.Companion);
        int r4 = r21 << 3;
        int r3 = (((r21 & 14) | (r4 & 896)) | (r4 & 7168)) | (r4 & 57344);
        if (r16.isSeeking() == true) goto L35;
        r20.startReplaceGroup(1666599280);
        if (((r3 & 14) ^ 6) <= 4) goto L17;
        if (r20.changed(r16) == false) goto L17;
    L18:
        boolean r7 = true;
    L20:
        Object r12 = r20.rememberedValue();
        if (r7 == false) goto L23;
    L24:
        Snapshot.Companion r8 = Snapshot.Companion;
        Snapshot r13 = r8.getCurrentThreadSnapshot();
        if (r13 == null) goto L27;
        Function1 r14 = r13.getReadObserver();
    L28:
        Snapshot r15 = r8.makeCurrentNonObservable(r13);
        S r110 = r16.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        r20.updateRememberedValue(r110);
        r12 = r110;
    L31:
        r20.endReplaceGroup();
    L36:
        int r9 = (r3 >> 9) & 112;
        Object r111 = r19.invoke(r12, r20, Integer.valueOf(r9));
        int r112 = r3 & 14;
        int r113 = r112 ^ 6;
        if (r113 <= 4) goto L41;
        if (r20.changed(r16) == false) goto L41;
    L42:
        boolean r114 = true;
    L44:
        Object r10 = r20.rememberedValue();
        if (r114 == false) goto L47;
    L48:
        r10 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r16));
        r20.updateRememberedValue(r10);
    L49:
        Object r11 = r19.invoke(((State) r10).getValue(), r20, Integer.valueOf(r9));
        if (r113 <= 4) goto L54;
        if (r20.changed(r16) == false) goto L54;
    L55:
        boolean r23 = true;
    L57:
        Object r1 = r20.rememberedValue();
        if (r23 == false) goto L60;
    L61:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r16));
        r20.updateRememberedValue(r1);
    L63:
        return createTransitionAnimation(r16, r111, r11, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r20, Integer.valueOf((r3 >> 3) & 112)), r5, r6, r20, (((r3 << 9) & 57344) | r112) | (458752 & (r3 << 6)));
    L60:
        if (r1 != Composer.Companion.getEmpty()) goto L63;
    L54:
        if ((r3 & 6) == 4) goto L55;
        r23 = false;
        goto L57
    L47:
        if (r10 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r3 & 6) == 4) goto L42;
        r114 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.restoreNonObservable(r13, r15, r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r14 = null;
        goto L28
    L23:
        if (r12 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r3 & 6) == 4) goto L18;
        r7 = false;
        goto L20
    L35:
        r20.startReplaceGroup(1666853325);
        r20.endReplaceGroup();
        r12 = r16.getCurrentState();
        goto L36
    L9:
        r6 = r18;
        goto L10
    L5:
        r2 = r17;
        goto L7
    }

    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> r14, TwoWayConverter<T, V> r15, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> r16, String r17, Function3<? super S, ? super Composer, ? super Integer, ? extends T> r18, Composer r19, int r20, int r21) {
        if ((r21 & 2) == 0) goto L5;
        Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> r2 = C01241.INSTANCE;
    L7:
        if ((r21 & 4) == 0) goto L9;
        String r6 = "ValueAnimation";
    L10:
        boolean r5 = false;
        if (r14.isSeeking() == true) goto L35;
        r19.startReplaceGroup(1666599280);
        if (((r20 & 14) ^ 6) <= 4) goto L17;
        if (r19.changed(r14) == false) goto L17;
    L18:
        boolean r4 = true;
    L20:
        Object r9 = r19.rememberedValue();
        if (r4 == false) goto L23;
    L24:
        Snapshot.Companion r7 = Snapshot.Companion;
        Snapshot r10 = r7.getCurrentThreadSnapshot();
        if (r10 == null) goto L27;
        Function1 r11 = r10.getReadObserver();
    L28:
        Snapshot r12 = r7.makeCurrentNonObservable(r10);
        S r13 = r14.getCurrentState();     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        r7.restoreNonObservable(r10, r12, r11);
        InlineMarker.finallyEnd(1);
        r19.updateRememberedValue(r13);
        r9 = r13;
    L31:
        r19.endReplaceGroup();
    L36:
        int r8 = (r20 >> 9) & 112;
        Object r22 = r18.invoke(r9, r19, Integer.valueOf(r8));
        int r110 = r20 & 14;
        int r111 = r110 ^ 6;
        if (r111 <= 4) goto L41;
        if (r19.changed(r14) == false) goto L41;
    L42:
        boolean r112 = true;
    L44:
        Object r113 = r19.rememberedValue();
        if (r112 == false) goto L47;
    L48:
        r113 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(r14));
        r19.updateRememberedValue(r113);
    L49:
        Object r23 = r18.invoke(((State) r113).getValue(), r19, Integer.valueOf(r8));
        if (r111 <= 4) goto L54;
        if (r19.changed(r14) == false) goto L54;
    L55:
        r5 = true;
    L56:
        Object r1 = r19.rememberedValue();
        if (r5 == false) goto L59;
    L60:
        r1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(r14));
        r19.updateRememberedValue(r1);
    L62:
        return createTransitionAnimation(r14, r22, r23, (FiniteAnimationSpec) r2.invoke(((State) r1).getValue(), r19, Integer.valueOf((r20 >> 3) & 112)), r15, r6, r19, ((57344 & (r20 << 9)) | r110) | (458752 & (r20 << 6)));
    L59:
        if (r1 != Composer.Companion.getEmpty()) goto L62;
    L54:
        if ((r20 & 6) != 4) goto L56;
    L47:
        if (r113 != Composer.Companion.getEmpty()) goto L49;
    L41:
        if ((r20 & 6) == 4) goto L42;
        r112 = false;
    L32:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r7.restoreNonObservable(r10, r12, r11);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r11 = null;
        goto L28
    L23:
        if (r9 != Composer.Companion.getEmpty()) goto L31;
    L17:
        if ((r20 & 6) == 4) goto L18;
        r4 = false;
        goto L20
    L35:
        r19.startReplaceGroup(1666853325);
        r19.endReplaceGroup();
        r9 = r14.getCurrentState();
        goto L36
    L9:
        r6 = r17;
        goto L10
    L5:
        r2 = r16;
        goto L7
    }

    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(final Transition<S> r18, T r19, T r20, FiniteAnimationSpec<T> r21, TwoWayConverter<T, V> r22, String r23, Composer r24, int r25) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-304821198, r25, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1869)");
    L5:
        int r7 = r25 & 14;
        int r10 = r7 ^ 6;
        if (r10 <= 4) goto L10;
        if (r24.changed(r18) == false) goto L10;
    L11:
        boolean r1 = true;
    L13:
        Object r2 = r24.rememberedValue();
        if (r1 == false) goto L16;
    L17:
        Snapshot.Companion r14 = Snapshot.Companion;
        Snapshot r15 = r14.getCurrentThreadSnapshot();
        if (r15 == null) goto L20;
        Function1 r3 = r15.getReadObserver();
    L21:
        Function1 r6 = r3;
        Snapshot r5 = r14.makeCurrentNonObservable(r15);
        Snapshot r12 = r5;
        Function1 r13 = r6;
        Transition.TransitionAnimationState r4 = new Transition.TransitionAnimationState(r18, r19, AnimationStateKt.createZeroVectorFrom(r22, r20), r22, r23);     // Catch: Throwable -> L43
        r14.restoreNonObservable(r15, r12, r13);
        r24.updateRememberedValue(r4);
        r2 = r4;
    L26:
        final Transition.TransitionAnimationState r11 = (Transition.TransitionAnimationState) r2;
        int r8 = (r25 >> 3) & 8;
        int r9 = r25 << 3;
        int r16 = ((r8 << 6) | r7) | (r9 & 896);
        UpdateInitialAndTargetValues(r18, r11, r19, r20, r21, r24, (((r8 << 9) | r16) | (r9 & 7168)) | (57344 & r9));
        if (r10 <= 4) goto L31;
        if (r24.changed(r18) == false) goto L31;
    L32:
        boolean r17 = true;
    L34:
        boolean r26 = r17 | r24.changed(r11);
        Object r27 = r24.rememberedValue();
        if (r26 == false) goto L37;
    L38:
        r27 = new o0(r18, r11);
        r24.updateRememberedValue(r27);
    L39:
        EffectsKt.DisposableEffect(r11, (Function1) r27, r24, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
    L42:
        return r11;
    L37:
        if (r27 != Composer.Companion.getEmpty()) goto L39;
    L31:
        if ((r25 & 6) == 4) goto L32;
        r17 = false;
    L43:
        th = th;
    L47:
        r14.restoreNonObservable(r15, r12, r13);
        throw th;
    L45:
        th = th;
        r12 = r5;
        r13 = r6;
        goto L47
    L20:
        r3 = null;
        goto L21
    L16:
        if (r2 != Composer.Companion.getEmpty()) goto L26;
    L10:
        if ((r25 & 6) == 4) goto L11;
        r1 = false;
        goto L13
    }
}
