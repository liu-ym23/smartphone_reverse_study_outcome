package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\\\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001ah\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001aT\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a`\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001aQ\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001626\u0010\u0017\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00150\u0018H\u0086\b\u001a5\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u001f2\u001d\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020!\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\"\u001a\u0093\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u0002H\u00022!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,2#\b\u0002\u0010-\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u0010/\u001a¡\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u0002H\u00022\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,2#\b\u0002\u0010-\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u00101\u001a&\u00102\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u0002H\u0086@¢\u0006\u0002\u00104\u001aR\u00105\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u0002082\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u00109\u001a\u0002H\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0082@¢\u0006\u0002\u0010:\u001a6\u00105\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u00022\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0086@¢\u0006\u0002\u0010<\u001aN\u0010=\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u00022\u0006\u00106\u001a\u00020\u001c2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,H\u0086@¢\u0006\u0002\u0010>\u001a^\u0010?\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010@\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001c2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(H\u0002¢\u0006\u0002\u0010A\u001a\u0014\u0010B\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cH\u0002\u001aF\u0010D\u001a\u00020\u0015\"\u0004\b\u0000\u0010E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002HE0(2\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002HE\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150G\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018H\u0082@¢\u0006\u0002\u0010H\u001a\u0014\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020J\"\u0004\b\u0000\u0010\u0002H\u0002\u001aU\u0010W\u001a\u00020X\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010Y\u001a\u00020Z2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0000\u001aM\u0010[\u001a\u00020\\\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(H\u0002\u001a\u0017\u0010_\u001a\u00020\u00152\f\u0010`\u001a\b\u0012\u0004\u0012\u00020S0(H\u0082\b\"\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001c0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010M\u001a\u00020NX\u0080\u0004¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010P\"\u000e\u0010R\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010V\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"anchoredDraggable", "Landroidx/compose/ui/Modifier;", "T", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "reverseDirection", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "startDragImmediately", "AlwaysDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "forEach", "", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "key", "", "position", "DraggableAnchors", "", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "Lkotlin/ExtensionFunctionType;", "AnchoredDraggableState", "initialValue", "positionalThreshold", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "anchors", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "snapTo", "targetValue", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "velocity", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "latestTarget", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "currentOffset", "(Landroidx/compose/foundation/gestures/DraggableAnchors;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "coerceToTarget", "target", "restartable", "I", "inputs", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyDraggableAnchors", "Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", "GetOrNan", "", "AnchoredDraggableMinFlingVelocity", "Landroidx/compose/ui/unit/Dp;", "getAnchoredDraggableMinFlingVelocity", "()F", "F", "ConfigurationMovedToModifier", "", "SettleWithVelocityDeprecated", "StartDragImmediatelyDeprecated", "ConfirmValueChangeDeprecated", "anchoredDraggableFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "density", "Landroidx/compose/ui/unit/Density;", "AnchoredDraggableLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "NoOpDecayAnimationSpec", "DEBUG", "debugLog", "generateMsg", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableKt {
    private static final Function1<PointerInputChange, Boolean> AlwaysDrag = null;
    private static final float AnchoredDraggableMinFlingVelocity = 0.0f;
    private static final String ConfigurationMovedToModifier = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.";
    private static final String ConfirmValueChangeDeprecated = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.";
    private static final boolean DEBUG = false;
    private static final Function1<Integer, Float> GetOrNan = null;
    private static final DecayAnimationSpec<Float> NoOpDecayAnimationSpec = null;
    private static final String SettleWithVelocityDeprecated = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.";
    private static final String StartDragImmediatelyDeprecated = "startDragImmediately has been removed without replacement. Modifier.anchoredDraggable sets startDragImmediately to true by default when animations are running.";

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4", f = "AnchoredDraggable.kt", i = {}, l = {1361}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public AnonymousClass4(AnchoredDraggableState<T> r1, AnimationSpec<Float> r2, Continuation<? super AnonymousClass4> r3) {
            this.$this_animateTo = r1;
            this.$animationSpec = r2;
            super(4, r3);
        }

        public final Object invoke(AnchoredDragScope r4, DraggableAnchors<T> r5, T r6, Continuation<? super Unit> r7) {
            AnonymousClass4 r0 = new AnonymousClass4(this.$this_animateTo, this.$animationSpec, r7);
            r0.L$0 = r4;
            r0.L$1 = r5;
            r0.L$2 = r6;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, r3, (Continuation) r4);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            AnchoredDragScope r5 = (AnchoredDragScope) this.L$0;
            DraggableAnchors r6 = (DraggableAnchors) this.L$1;
            Object r7 = this.L$2;
            AnchoredDraggableState<T> r3 = this.$this_animateTo;
            float r4 = r3.getLastVelocity();
            AnimationSpec<Float> r8 = this.$animationSpec;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (AnchoredDraggableKt.access$animateTo(r3, r4, r5, r6, r7, r8, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {0, 0}, l = {1397}, m = "animateToWithDecay", n = {"remainingVelocity", "velocity"}, s = {"L$0", "F$0"})
    public static final class C01301<T> extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C01301(Continuation<? super C01301> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AnchoredDraggableKt.animateToWithDecay(null, null, MenuKt.ClosedAlphaTarget, null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", f = "AnchoredDraggable.kt", i = {}, l = {1408, 1426, 1450}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ DecayAnimationSpec<Float> $decayAnimationSpec;
        final /* synthetic */ Ref.FloatRef $remainingVelocity;
        final /* synthetic */ AnimationSpec<Float> $snapAnimationSpec;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateToWithDecay;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public AnonymousClass2(AnchoredDraggableState<T> r1, float r2, AnimationSpec<Float> r3, Ref.FloatRef r4, DecayAnimationSpec<Float> r5, Continuation<? super AnonymousClass2> r6) {
            this.$this_animateToWithDecay = r1;
            this.$velocity = r2;
            this.$snapAnimationSpec = r3;
            this.$remainingVelocity = r4;
            this.$decayAnimationSpec = r5;
            super(4, r6);
        }

        public static /* synthetic */ Unit a(float r0, Ref.FloatRef r1, AnchoredDragScope r2, Ref.FloatRef r3, AnimationScope r4) {
            return invokeSuspend$lambda$2(r0, r1, r2, r3, r4);
        }

        public final Object invoke(AnchoredDragScope r9, DraggableAnchors<T> r10, T r11, Continuation<? super Unit> r12) {
            AnonymousClass2 r7 = new AnonymousClass2(this.$this_animateToWithDecay, this.$velocity, this.$snapAnimationSpec, this.$remainingVelocity, this.$decayAnimationSpec, r12);
            r7.L$0 = r9;
            r7.L$1 = r10;
            r7.L$2 = r11;
            return r7.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, r3, (Continuation) r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object r26) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            boolean r3 = true;
            if (r0 == 0) goto L12;
            if (r0 == 1) goto L11;
            if (r0 == 2) goto L10;
            if (r0 != 3) goto L9;
            ResultKt.throwOnFailure(r26);
        L47:
            this.$remainingVelocity.element = MenuKt.ClosedAlphaTarget;
        L53:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r26);
            goto L53
        L11:
            ResultKt.throwOnFailure(r26);
        L51:
            this.$remainingVelocity.element = MenuKt.ClosedAlphaTarget;
            goto L53
        L12:
            ResultKt.throwOnFailure(r26);
            final AnchoredDragScope r4 = (AnchoredDragScope) this.L$0;
            DraggableAnchors r5 = (DraggableAnchors) this.L$1;
            Object r6 = this.L$2;
            final float r1 = r5.positionOf(r6);
            if (Float.isNaN(r1) == true) goto L53;
            final Ref.FloatRef r10 = new Ref.FloatRef();
            if (Float.isNaN(this.$this_animateToWithDecay.getOffset()) == false) goto L17;
            float r11 = MenuKt.ClosedAlphaTarget;
        L18:
            r10.element = r11;
            if (r11 != r1) goto L21;
            boolean r13 = true;
        L22:
            if (r13 == true) goto L53;
            float r14 = this.$velocity;
            if (((r1 - r11) * r14) >= MenuKt.ClosedAlphaTarget) goto L26;
        L48:
            AnchoredDraggableState<T> r2 = this.$this_animateToWithDecay;
            AnimationSpec<Float> r12 = this.$snapAnimationSpec;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (AnchoredDraggableKt.access$animateTo(r2, r14, r4, r5, r6, r12, this) != r8) goto L51;
            return r8;
        L26:
            if (r14 != MenuKt.ClosedAlphaTarget) goto L28;
            boolean r15 = true;
        L29:
            if (r15 == true) goto L48;
            float r16 = DecayAnimationSpecKt.calculateTargetValue(this.$decayAnimationSpec, r11, r14);
            float r17 = this.$velocity;
            if (r17 <= MenuKt.ClosedAlphaTarget) goto L37;
            if (r16 >= r1) goto L40;
        L39:
            r3 = false;
        L40:
            if (r3 == false) goto L44;
            AnimationState r7 = AnimationStateKt.AnimationState$default(r10.element, r17, 0, 0, false, 28, null);
            DecayAnimationSpec<Float> r9 = this.$decayAnimationSpec;
            final Ref.FloatRef r18 = this.$remainingVelocity;
            Function1 r19 = new h(r1, r10, r4, r18);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (SuspendAnimationKt.animateDecay$default(r7, r9, false, r19, this, 2, null) != r8) goto L53;
            return r8;
        L44:
            AnchoredDraggableState<T> r20 = this.$this_animateToWithDecay;
            AnimationSpec<Float> r110 = this.$snapAnimationSpec;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (AnchoredDraggableKt.access$animateTo(r20, r17, r4, r5, r6, r110, this) != r8) goto L47;
            return r8;
        L37:
            if (r16 > r1) goto L39;
        L28:
            r15 = false;
            goto L29
        L21:
            r13 = false;
            goto L22
        L17:
            r11 = this.$this_animateToWithDecay.getOffset();
            goto L18
        }

        private static final Unit invokeSuspend$lambda$2(float r1, Ref.FloatRef r2, AnchoredDragScope r3, Ref.FloatRef r4, AnimationScope r5) {
            if (((Number) r5.getValue()).floatValue() >= r1) goto L7;
            if (r2.element <= r1) goto L7;
        L10:
            float r6 = AnchoredDraggableKt.access$coerceToTarget(((Number) r5.getValue()).floatValue(), r1);
            r3.dragTo(r6, ((Number) r5.getVelocity()).floatValue());
            if (Float.isNaN(((Number) r5.getVelocity()).floatValue()) == false) goto L13;
            float r7 = MenuKt.ClosedAlphaTarget;
        L14:
            r4.element = r7;
            r2.element = r6;
            r5.cancelAnimation();
        L17:
            return Unit.INSTANCE;
        L13:
            r7 = ((Number) r5.getVelocity()).floatValue();
        L7:
            if (((Number) r5.getValue()).floatValue() > r1) goto L9;
        L15:
            r3.dragTo(((Number) r5.getValue()).floatValue(), ((Number) r5.getVelocity()).floatValue());
            r4.element = ((Number) r5.getVelocity()).floatValue();
            r2.element = ((Number) r5.getValue()).floatValue();
            goto L17
        L9:
            if (r2.element >= r1) goto L15;
            goto L10
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {}, l = {1561}, m = "restartable", n = {}, s = {})
    public static final class C01311<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C01311(Continuation<? super C01311> r1) {
            super(r1);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return AnchoredDraggableKt.access$restartable(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {1563}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Function0<I> $inputs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", i = {}, l = {1570}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00162 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C00162(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r1, I r2, CoroutineScope r3, Continuation<? super C00162> r4) {
                    this.$block = r1;
                    this.$latestInputs = r2;
                    this.$$this$coroutineScope = r3;
                    super(2, r4);
                }

                public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                    return new C00162(this.$block, this.$latestInputs, this.$$this$coroutineScope, r5);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                    return invoke((CoroutineScope) r1, (Continuation) r2);
                }

                public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                    return create(r1, r2).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object r4) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    ResultKt.throwOnFailure(r4);
                L11:
                    CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r4);
                    Function2<I, Continuation<? super Unit>, Object> r5 = this.$block;
                    I r2 = this.$latestInputs;
                    this.label = 1;
                    if (r5.invoke(r2, this) != r0) goto L11;
                    return r0;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Ref.ObjectRef<Job> r1, CoroutineScope r2, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r3) {
                this.$previousDrag = r1;
                this.$$this$coroutineScope = r2;
                this.$block = r3;
            }

            public final Object emit(I r7, Continuation<? super Unit> r8) {
                if ((r8 instanceof AnchoredDraggableKt$restartable$2$1$emit$1) == false) goto L7;
                AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (AnchoredDraggableKt$restartable$2$1$emit$1) r8;
                int r1 = r0.label;
                if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
                r0.label = r1 - RtlSpacingHelper.UNDEFINED;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                Job r10 = (Job) r0.L$1;
                Object r11 = r0.L$0;
                ResultKt.throwOnFailure(r9);
                Object r12 = r11;
            L19:
                Ref.ObjectRef<Job> r13 = this.$previousDrag;
                CoroutineScope r4 = this.$$this$coroutineScope;
                r13.element = BuildersKt.launch$default(r4, null, CoroutineStart.UNDISPATCHED, new C00162(this.$block, r12, r4, null), 1, null);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                Job r14 = (Job) this.$previousDrag.element;
                r12 = r7;
                if (r14 == null) goto L19;
                r14.cancel(new AnchoredDragFinishedSignal());
                r0.L$0 = r7;
                r0.L$1 = r14;
                r0.label = 1;
                r12 = r7;
                if (r14.join(r0) != r2) goto L19;
                return r2;
            L7:
                r0 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, r8);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C01322(Function0<? extends I> r1, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super C01322> r3) {
            this.$inputs = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C01322 r0 = new C01322(this.$inputs, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            Ref.ObjectRef r2 = new Ref.ObjectRef();
            Flow r3 = SnapshotStateKt.snapshotFlow(this.$inputs);
            AnonymousClass1 r4 = new AnonymousClass1(r2, r8, this.$block);
            this.label = 1;
            if (r3.collect(r4, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01332<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public C01332(Continuation<? super C01332> r2) {
            super(4, r2);
        }

        public final Object invoke(AnchoredDragScope r2, DraggableAnchors<T> r3, T r4, Continuation<? super Unit> r5) {
            C01332 r0 = new C01332(r5);
            r0.L$0 = r2;
            r0.L$1 = r3;
            r0.L$2 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            return invoke((AnchoredDragScope) r1, (DraggableAnchors) r2, r3, (Continuation) r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r5);
            AnchoredDragScope r6 = (AnchoredDragScope) this.L$0;
            float r0 = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (Float.isNaN(r0) == true) goto L8;
            AnchoredDragScope.CC.dragTo$default(r6, r0, MenuKt.ClosedAlphaTarget, 2, null);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final boolean AlwaysDrag$lambda$0(PointerInputChange r0) {
        return true;
    }

    private static final boolean AnchoredDraggableState$lambda$2(Object r0) {
        return true;
    }

    private static final boolean AnchoredDraggableState$lambda$4(Object r0) {
        return true;
    }

    private static final float GetOrNan$lambda$10(int r0) {
        return Float.NaN;
    }

    public static /* synthetic */ boolean a(Object r0) {
        return AnchoredDraggableState$lambda$2(r0);
    }

    public static /* synthetic */ boolean b(PointerInputChange r0) {
        return AlwaysDrag$lambda$0(r0);
    }

    public static /* synthetic */ float c(int r0) {
        return GetOrNan$lambda$10(r0);
    }

    public static /* synthetic */ boolean d(Object r0) {
        return AnchoredDraggableState$lambda$4(r0);
    }

    private static final void debugLog(Function0<String> r0) {
    }

    public static /* synthetic */ Unit e(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
        return animateTo$lambda$8$lambda$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ float f(Density r0) {
        return anchoredDraggableFlingBehavior$lambda$12(r0);
    }

    static {
        AlwaysDrag = new e();
        GetOrNan = new f();
        AnchoredDraggableMinFlingVelocity = Dp.constructor-impl(125);
        NoOpDecayAnimationSpec = DecayAnimationSpecKt.generateDecayAnimationSpec(new AnchoredDraggableKt$NoOpDecayAnimationSpec$1());
    }

    private static final <T> DefaultDraggableAnchors<T> emptyDraggableAnchors() {
        return new DefaultDraggableAnchors(CollectionsKt.emptyList(), new float[0]);
    }

    public static final /* synthetic */ DefaultDraggableAnchors access$emptyDraggableAnchors() {
        return emptyDraggableAnchors();
    }

    public static final /* synthetic */ Function1 access$getAlwaysDrag$p() {
        return AlwaysDrag;
    }

    public static final /* synthetic */ Function1 access$getGetOrNan$p() {
        return GetOrNan;
    }

    public static final /* synthetic */ DecayAnimationSpec access$getNoOpDecayAnimationSpec$p() {
        return NoOpDecayAnimationSpec;
    }

    public static final float getAnchoredDraggableMinFlingVelocity() {
        return AnchoredDraggableMinFlingVelocity;
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> r2) {
        DraggableAnchorsConfig r0 = new DraggableAnchorsConfig();
        r2.invoke(r0);
        return new DefaultDraggableAnchors(r0.buildKeys$foundation_release(), r0.buildPositions$foundation_release());
    }

    private static final float anchoredDraggableFlingBehavior$lambda$12(Density r1) {
        return r1.toPx-0680j_4(Dp.constructor-impl(125));
    }

    public static final /* synthetic */ float access$coerceToTarget(float r0, float r1) {
        return coerceToTarget(r0, r1);
    }

    private static final float coerceToTarget(float r2, float r3) {
        if (r3 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return MenuKt.ClosedAlphaTarget;
    L9:
        if (r3 <= MenuKt.ClosedAlphaTarget) goto L12;
        return RangesKt.coerceAtMost(r2, r3);
    L12:
        return RangesKt.coerceAtLeast(r2, r3);
    L5:
        r1 = false;
        goto L6
    }

    public static final <T> void forEach(DraggableAnchors<T> r4, Function2<? super T, ? super Float, Unit> r5) {
        int r0 = r4.getSize();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        T r2 = r4.anchorAt(r1);
        if (r2 == null) goto L8;
        r5.invoke(r2, Float.valueOf(r4.positionAt(r1)));
        r1 = r1 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException(("There was no key at index " + r1 + ". Please report a bug.").toString());
    }

    private static final <T> SnapLayoutInfoProvider AnchoredDraggableLayoutInfoProvider(final AnchoredDraggableState<T> r1, final Function1<? super Float, Float> r2, final Function0<Float> r3) {
        return new AnonymousClass1(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$restartable(Function0 r0, Function2 r1, Continuation r2) {
        return restartable(r0, r1, r2);
    }

    private static final <I> Object restartable(Function0<? extends I> r4, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof C01311) == false) goto L7;
        C01311 r0 = (C01311) r6;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: AnchoredDragFinishedSignal -> L21
    L22:
        goto L20
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        C01322 r8 = new C01322(r4, r5, null);     // Catch: AnchoredDragFinishedSignal -> L21
        r0.label = 1;     // Catch: AnchoredDragFinishedSignal -> L21
        if (CoroutineScopeKt.coroutineScope(r8, r0) != r2) goto L22;
        return r2;
    L20:
        return Unit.INSTANCE;
    L7:
        r0 = new C01311(r6);
        goto L8
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> r7, T r8, Continuation<? super Unit> r9) {
        Object r10 = AnchoredDraggableState.anchoredDrag$default(r7, r8, null, new C01332(null), r9, 2, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> TargetedFlingBehavior anchoredDraggableFlingBehavior(AnchoredDraggableState<T> r2, final Density r3, Function1<? super Float, Float> r4, AnimationSpec<Float> r5) {
        DecayAnimationSpec<Float> r0 = NoOpDecayAnimationSpec;
        return SnapFlingBehaviorKt.snapFlingBehavior(AnchoredDraggableLayoutInfoProvider(r2, r4, new d(r3)), r0, r5);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> r7, T r8, AnimationSpec<Float> r9, Continuation<? super Unit> r10) {
        Object r11 = AnchoredDraggableState.anchoredDrag$default(r7, r8, null, new AnonymousClass4(r7, r9, null), r10, 2, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit animateTo$lambda$8$lambda$7(AnchoredDragScope r0, Ref.FloatRef r1, float r2, float r3) {
        r0.dragTo(r2, r3);
        r1.element = r2;
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$computeTarget(DraggableAnchors r0, float r1, float r2, Function1 r3, Function0 r4) {
        return computeTarget(r0, r1, r2, r3, r4);
    }

    private static final <T> T computeTarget(DraggableAnchors<T> r5, float r6, float r7, Function1<? super Float, Float> r8, Function0<Float> r9) {
        if ((!Float.isNaN(r6)) == false) goto L36;
        boolean r3 = false;
        if (Math.abs(r7) <= MenuKt.ClosedAlphaTarget) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r0 == true) goto L16;
        T r10 = r5.closestAnchor(r6);
        Intrinsics.checkNotNull(r10);
        return r10;
    L16:
        if (Math.abs(r7) < Math.abs(((Number) r9.invoke()).floatValue())) goto L18;
        T r11 = r5.closestAnchor(r6, r2);
        Intrinsics.checkNotNull(r11);
        return r11;
    L18:
        T r12 = r5.closestAnchor(r6, false);
        Intrinsics.checkNotNull(r12);
        float r13 = r5.positionOf(r12);
        T r1 = r5.closestAnchor(r6, true);
        Intrinsics.checkNotNull(r1);
        float r14 = r5.positionOf(r1);
        float r15 = Math.abs(((Number) r8.invoke(Float.valueOf(Math.abs(r13 - r14)))).floatValue());
        if (r2 == true) goto L23;
        r13 = r14;
    L23:
        if (Math.abs(r13 - r6) < r15) goto L25;
        r3 = true;
    L25:
        if (r3 != true) goto L28;
        if (r2 == true) goto L32;
    L39:
        return r12;
    L32:
        return r1;
    L28:
        if (r3 == true) goto L34;
        if (r2 == false) goto L32;
    L34:
        throw new NoWhenBranchMatchedException();
    L10:
        if (r7 <= MenuKt.ClosedAlphaTarget) goto L12;
        r2 = true;
        goto L13
    L7:
        r0 = false;
        goto L8
    L36:
        throw new IllegalArgumentException("The offset provided to computeTarget must not be NaN.".toString());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T r1, Function1<? super Float, Float> r2, Function0<Float> r3, AnimationSpec<Float> r4, DecayAnimationSpec<Float> r5, Function1<? super T, Boolean> r6) {
        AnchoredDraggableState<T> r0 = new AnchoredDraggableState(r1, r6);
        r0.setPositionalThreshold$foundation_release(r2);
        r0.setVelocityThreshold$foundation_release(r3);
        r0.setSnapAnimationSpec$foundation_release(r4);
        r0.setDecayAnimationSpec$foundation_release(r5);
        return r0;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState r0, Object r1, AnimationSpec r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L9;
        if (r0.getUsePreModifierChangeBehavior$foundation_release() == false) goto L7;
        r2 = r0.getSnapAnimationSpec();
        goto L9
    L7:
        r2 = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
    L9:
        return animateTo(r0, r1, r2, r3);
    }

    public static final <T> Object animateToWithDecay(AnchoredDraggableState<T> r16, T r17, float r18, AnimationSpec<Float> r19, DecayAnimationSpec<Float> r20, Continuation<? super Float> r21) {
        if ((r21 instanceof C01301) == false) goto L7;
        C01301 r1 = (C01301) r21;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        C01301 r12 = r1;
        Object r0 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r12.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        float r4 = r12.F$0;
        Ref.FloatRef r5 = (Ref.FloatRef) r12.L$0;
        ResultKt.throwOnFailure(r0);
    L19:
        return Boxing.boxFloat(r4 - r5.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Ref.FloatRef r14 = new Ref.FloatRef();
        r14.element = r18;
        AnonymousClass2 r11 = new AnonymousClass2(r16, r18, r19, r14, r20, null);
        r12.L$0 = r14;
        r12.F$0 = r18;
        r12.label = 1;
        if (AnchoredDraggableState.anchoredDrag$default(r16, r17, null, r11, r12, 2, null) != r15) goto L17;
        return r15;
    L17:
        r5 = r14;
        r4 = r18;
    L7:
        r1 = new C01301(r21);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T r1, DraggableAnchors<T> r2, Function1<? super Float, Float> r3, Function0<Float> r4, AnimationSpec<Float> r5, DecayAnimationSpec<Float> r6, Function1<? super T, Boolean> r7) {
        AnchoredDraggableState<T> r0 = new AnchoredDraggableState(r1, r2, r7);
        r0.setPositionalThreshold$foundation_release(r3);
        r0.setVelocityThreshold$foundation_release(r4);
        r0.setSnapAnimationSpec$foundation_release(r5);
        r0.setDecayAnimationSpec$foundation_release(r6);
        return r0;
    }

    public static final /* synthetic */ Object access$animateTo(AnchoredDraggableState r0, float r1, AnchoredDragScope r2, DraggableAnchors r3, Object r4, AnimationSpec r5, Continuation r6) {
        return animateTo(r0, r1, r2, r3, r4, r5, r6);
    }

    public static final <T> Modifier anchoredDraggable(Modifier r12, AnchoredDraggableState<T> r13, Orientation r14, boolean r15, MutableInteractionSource r16, OverscrollEffect r17, FlingBehavior r18) {
        return r12.then(new AnchoredDraggableElement(r13, r14, r15, null, r16, null, r17, r18, 32, null));
    }

    private static final <T> Object animateTo(AnchoredDraggableState<T> r6, float r7, final AnchoredDragScope r8, DraggableAnchors<T> r9, T r10, AnimationSpec<Float> r11, Continuation<? super Unit> r12) {
        float r1 = r9.positionOf(r10);
        final Ref.FloatRef r13 = new Ref.FloatRef();
        if (Float.isNaN(r6.getOffset()) == false) goto L5;
        float r14 = MenuKt.ClosedAlphaTarget;
    L6:
        r13.element = r14;
        if (Float.isNaN(r1) == true) goto L17;
        float r0 = r13.element;
        if (r0 != r1) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == true) goto L17;
        Object r16 = SuspendAnimationKt.animate(r0, r1, r7, r11, new b(r8, r13), r12);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r16;
    L11:
        r15 = false;
    L17:
        return Unit.INSTANCE;
    L5:
        r14 = r6.getOffset();
        goto L6
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object r6, Function1 r7, Function0 r8, AnimationSpec r9, DecayAnimationSpec r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 32) == 0) goto L6;
        r11 = new g();
    L6:
        return AnchoredDraggableState(r6, r7, r8, r9, r10, r11);
    }

    public static final <T> Modifier anchoredDraggable(Modifier r12, AnchoredDraggableState<T> r13, boolean r14, Orientation r15, boolean r16, MutableInteractionSource r17, OverscrollEffect r18, FlingBehavior r19) {
        return r12.then(new AnchoredDraggableElement(r13, r15, r16, Boolean.valueOf(r14), r17, null, r18, r19, 32, null));
    }

    public static /* synthetic */ Object animateToWithDecay$default(AnchoredDraggableState r6, Object r7, float r8, AnimationSpec r9, DecayAnimationSpec r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 4) != 0) goto L5;
    L8:
        AnimationSpec r3 = r9;
        if ((r12 & 8) == 0) goto L16;
        if (r6.getUsePreModifierChangeBehavior$foundation_release() == false) goto L13;
        DecayAnimationSpec<Float> r14 = r6.getDecayAnimationSpec();
    L14:
        r10 = r14;
        goto L16
    L13:
        r14 = AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec();
    L16:
        return animateToWithDecay(r6, r7, r8, r3, r10, r11);
    L5:
        if (r6.getUsePreModifierChangeBehavior$foundation_release() == false) goto L7;
        r9 = r6.getSnapAnimationSpec();
        goto L8
    L7:
        r9 = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
        goto L8
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier r10, AnchoredDraggableState<T> r11, Orientation r12, boolean r13, MutableInteractionSource r14, OverscrollEffect r15, boolean r16, FlingBehavior r17) {
        return r10.then(new AnchoredDraggableElement(r11, r12, r13, null, r14, Boolean.valueOf(r16), r15, r17));
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object r7, DraggableAnchors r8, Function1 r9, Function0 r10, AnimationSpec r11, DecayAnimationSpec r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 64) == 0) goto L6;
        r13 = new c();
    L6:
        return AnchoredDraggableState(r7, r8, r9, r10, r11, r12, r13);
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier r10, AnchoredDraggableState<T> r11, boolean r12, Orientation r13, boolean r14, MutableInteractionSource r15, OverscrollEffect r16, boolean r17, FlingBehavior r18) {
        return r10.then(new AnchoredDraggableElement(r11, r13, r14, Boolean.valueOf(r12), r15, Boolean.valueOf(r17), r16, r18));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r7, AnchoredDraggableState r8, Orientation r9, boolean r10, MutableInteractionSource r11, OverscrollEffect r12, FlingBehavior r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r14 & 8) == 0) goto L9;
        MutableInteractionSource r4 = null;
    L11:
        if ((r14 & 16) == 0) goto L13;
        OverscrollEffect r5 = null;
    L15:
        if ((r14 & 32) == 0) goto L17;
        FlingBehavior r6 = null;
    L19:
        return anchoredDraggable(r7, r8, r9, r3, r4, r5, r6);
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r9, AnchoredDraggableState r10, Orientation r11, boolean r12, MutableInteractionSource r13, OverscrollEffect r14, boolean r15, FlingBehavior r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r17 & 8) == 0) goto L9;
        MutableInteractionSource r5 = null;
    L11:
        if ((r17 & 16) == 0) goto L13;
        OverscrollEffect r6 = null;
    L15:
        if ((r17 & 32) == 0) goto L17;
        boolean r7 = r10.isAnimationRunning();
    L19:
        if ((r17 & 64) == 0) goto L21;
        FlingBehavior r8 = null;
    L23:
        return anchoredDraggable(r9, r10, r11, r4, r5, r6, r7, r8);
    L21:
        r8 = r16;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r9, AnchoredDraggableState r10, boolean r11, Orientation r12, boolean r13, MutableInteractionSource r14, OverscrollEffect r15, FlingBehavior r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r17 & 16) == 0) goto L9;
        MutableInteractionSource r6 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        OverscrollEffect r7 = null;
    L15:
        if ((r17 & 64) == 0) goto L17;
        FlingBehavior r8 = null;
    L19:
        return anchoredDraggable(r9, r10, r11, r12, r5, r6, r7, r8);
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r11, AnchoredDraggableState r12, boolean r13, Orientation r14, boolean r15, MutableInteractionSource r16, OverscrollEffect r17, boolean r18, FlingBehavior r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        boolean r6 = true;
    L7:
        if ((r20 & 16) == 0) goto L9;
        MutableInteractionSource r7 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        OverscrollEffect r8 = null;
    L15:
        if ((r20 & 64) == 0) goto L17;
        boolean r9 = r12.isAnimationRunning();
    L19:
        if ((r20 & 128) == 0) goto L21;
        FlingBehavior r10 = null;
    L23:
        return anchoredDraggable(r11, r12, r13, r14, r6, r7, r8, r9, r10);
    L21:
        r10 = r19;
        goto L23
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }
}
