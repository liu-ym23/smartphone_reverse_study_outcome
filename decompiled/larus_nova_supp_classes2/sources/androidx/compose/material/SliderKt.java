package androidx.compose.material;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001aj\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00050\u00182\u0014\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f0\u0018H\u0002\u001a\u007f\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u001b\u001aK\u0010\u001c\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010!\u001ak\u0010\"\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010)\u001aC\u0010*\u001a\u00020\u0001*\u00020+2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0003¢\u0006\u0004\b/\u00100\u001aS\u00101\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003H\u0003¢\u0006\u0002\u00104\u001a.\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0002\u001a2\u00109\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0003\u0018\u00010:*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0004\bA\u0010B\u001a\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a0\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003H\u0002\u001a<\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003H\u0002\u001a \u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0002\u001aS\u0010O\u001a\u00020\u00012\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00030S2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010T\u001a\\\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001aj\u0010V\u001a\u00020\u0007*\u00020\u00072\u0006\u0010W\u001a\u00020X2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0018\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00050\u00182\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030S2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a.\u0010\\\u001a\u00020\u00012\u0006\u0010W\u001a\u00020X2\u0006\u00106\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010_\u001a\u0098\u0001\u0010`\u001a\u00020\u0007*\u00020\u00072\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00050\u00182\u001e\u0010c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010d0\u0018H\u0002\"\u0016\u0010e\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g\"\u0010\u0010i\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010j\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010k\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0016\u0010l\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bm\u0010g\"\u0010\u0010n\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010o\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u000e\u0010p\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SliderColors;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "slideOnKeyEvents", "isRtl", "onValueChangeState", "Landroidx/compose/runtime/State;", "onValueChangeFinishedState", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "tickFractions", "", "width", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "startInteractionSource", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "Landroidx/compose/ui/unit/Dp;", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", "scale", "a1", "b1", "x1", "a2", "b2", "x", "calcFraction", "a", "b", "pos", "CorrectValueSideEffect", "scaleToOffset", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "sliderSemantics", "sliderTapModifier", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "rawOffset", "gestureEndAction", "pressOffset", "animateToTarget", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "rawOffsetEnd", "onDrag", "Lkotlin/Function2;", "ThumbRadius", "getThumbRadius", "()F", "F", "ThumbRippleRadius", "ThumbDefaultElevation", "ThumbPressedElevation", "TrackHeight", "getTrackHeight", "SliderHeight", "SliderMinWidth", "DefaultSliderConstraints", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints = null;
    private static final float SliderHeight = 0.0f;
    private static final float SliderMinWidth = 0.0f;
    private static final TweenSpec<Float> SliderToTickAnimation = null;
    private static final float ThumbDefaultElevation = 0.0f;
    private static final float ThumbPressedElevation = 0.0f;
    private static final float ThumbRadius = 0.0f;
    private static final float ThumbRippleRadius = 0.0f;
    private static final float TrackHeight = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ int $steps;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ ClosedFloatingPointRange<Float> $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        public AnonymousClass2(ClosedFloatingPointRange<Float> r1, ClosedFloatingPointRange<Float> r2, List<Float> r3, Function0<Unit> r4, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> r5, MutableInteractionSource r6, MutableInteractionSource r7, boolean r8, int r9, SliderColors r10) {
            this.$valueRange = r1;
            this.$value = r2;
            this.$tickFractions = r3;
            this.$onValueChangeFinished = r4;
            this.$onValueChangeState = r5;
            this.$startInteractionSource = r6;
            this.$endInteractionSource = r7;
            this.$enabled = r8;
            this.$steps = r9;
            this.$colors = r10;
        }

        public static /* synthetic */ Unit a(State r0, float r1, float r2) {
            return invoke$lambda$10$lambda$9(r0, r1, r2);
        }

        public static /* synthetic */ Unit b(MutableFloatState r0, MutableFloatState r1, ClosedFloatingPointRange r2, Ref.FloatRef r3, Ref.FloatRef r4, State r5, ClosedFloatingPointRange r6, boolean r7, float r8) {
            return invoke$lambda$8$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        }

        public static /* synthetic */ Unit c(MutableFloatState r0, MutableFloatState r1, List r2, Ref.FloatRef r3, Ref.FloatRef r4, Function0 r5, CoroutineScope r6, State r7, ClosedFloatingPointRange r8, boolean r9) {
            return invoke$lambda$6$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        public static /* synthetic */ Unit d(State r0, float r1, float r2) {
            return invoke$lambda$12$lambda$11(r0, r1, r2);
        }

        private static final Unit invoke$lambda$10$lambda$9(State r0, float r1, float r2) {
            ((Function1) r0.getValue()).invoke(RangesKt.rangeTo(r2, r1));
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$12$lambda$11(State r0, float r1, float r2) {
            ((Function1) r0.getValue()).invoke(RangesKt.rangeTo(r1, r2));
            return Unit.INSTANCE;
        }

        public final void invoke(BoxWithConstraintsScope r32, Composer r33, int r34) {
            if ((r34 & 6) == 0) goto L5;
            int r2 = r34;
        L11:
            if ((r2 & 19) == 18) goto L13;
            boolean r3 = true;
        L15:
            if (r33.shouldExecute(r3, r2 & 1) == true) goto L17;
            r33.skipToGroupEnd();
            return;
        L17:
            if (ComposerKt.isTraceInProgress() == false) goto L20;
            ComposerKt.traceEventStart(652589923, r2, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:418)");
        L20:
            if (r33.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L22;
            boolean r19 = true;
        L23:
            float r9 = Constraints.getMaxWidth-impl(r32.mo838getConstraintsmsEJaDk());
            final Ref.FloatRef r10 = new Ref.FloatRef();
            final Ref.FloatRef r11 = new Ref.FloatRef();
            Density r1 = (Density) r33.consume(CompositionLocalsKt.getLocalDensity());
            r10.element = r9 - r1.toPx-0680j_4(SliderKt.getThumbRadius());
            r11.element = r1.toPx-0680j_4(SliderKt.getThumbRadius());
            ClosedFloatingPointRange<Float> r4 = this.$value;
            ClosedFloatingPointRange<Float> r5 = this.$valueRange;
            Object r6 = r33.rememberedValue();
            Composer.Companion r30 = Composer.Companion;
            if (r6 != r30.getEmpty()) goto L26;
            r6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(r5, r11, r10, ((Number) r4.getStart()).floatValue()));
            r33.updateRememberedValue(r6);
        L26:
            final MutableFloatState r16 = (MutableFloatState) r6;
            ClosedFloatingPointRange<Float> r7 = this.$value;
            ClosedFloatingPointRange<Float> r8 = this.$valueRange;
            Object r12 = r33.rememberedValue();
            if (r12 != r30.getEmpty()) goto L29;
            r12 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(r8, r11, r10, ((Number) r7.getEndInclusive()).floatValue()));
            r33.updateRememberedValue(r12);
        L29:
            final MutableFloatState r17 = (MutableFloatState) r12;
            boolean r13 = (r33.changed(this.$valueRange) | r33.changed(r11.element)) | r33.changed(r10.element);
            ClosedFloatingPointRange<Float> r14 = this.$valueRange;
            Object r15 = r33.rememberedValue();
            if (r13 == false) goto L32;
        L33:
            r15 = new SliderKt$RangeSlider$2$2$1(r14, r11, r10);
            r33.updateRememberedValue(r15);
        L34:
            SliderKt.access$CorrectValueSideEffect((KFunction) r15, this.$valueRange, RangesKt.rangeTo(r11.element, r10.element), r16, ((Number) this.$value.getStart()).floatValue(), r33, 3072);
            boolean r18 = (r33.changed(this.$valueRange) | r33.changed(r11.element)) | r33.changed(r10.element);
            ClosedFloatingPointRange<Float> r20 = this.$valueRange;
            Object r21 = r33.rememberedValue();
            if (r18 == false) goto L37;
        L38:
            r21 = new SliderKt$RangeSlider$2$3$1(r20, r11, r10);
            r33.updateRememberedValue(r21);
        L39:
            SliderKt.access$CorrectValueSideEffect((KFunction) r21, this.$valueRange, RangesKt.rangeTo(r11.element, r10.element), r17, ((Number) this.$value.getEndInclusive()).floatValue(), r33, 3072);
            Object r22 = r33.rememberedValue();
            if (r22 != r30.getEmpty()) goto L42;
            r22 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r33);
            r33.updateRememberedValue(r22);
        L42:
            final CoroutineScope r23 = (CoroutineScope) r22;
            boolean r24 = (((((r33.changedInstance(this.$tickFractions) | r33.changed(r11.element)) | r33.changed(r10.element)) | r33.changed(this.$onValueChangeFinished)) | r33.changedInstance(r23)) | r33.changed(this.$onValueChangeState)) | r33.changed(this.$valueRange);
            final List<Float> r25 = this.$tickFractions;
            final Function0<Unit> r26 = this.$onValueChangeFinished;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> r27 = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> r28 = this.$valueRange;
            Object r29 = r33.rememberedValue();
            if (r24 == false) goto L45;
        L46:
            r29 = new v9(r16, r17, r25, r11, r10, r26, r23, r27, r28);
            r33.updateRememberedValue(r29);
        L47:
            State r31 = SnapshotStateKt.rememberUpdatedState((Function1) r29, r33, 0);
            boolean r35 = (((r33.changed(this.$valueRange) | r33.changed(r11.element)) | r33.changed(r10.element)) | r33.changed(this.$value)) | r33.changed(this.$onValueChangeState);
            final ClosedFloatingPointRange<Float> r36 = this.$value;
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> r37 = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> r38 = this.$valueRange;
            Object r39 = r33.rememberedValue();
            if (r35 == false) goto L50;
        L51:
            r39 = new w9(r16, r17, r36, r11, r10, r37, r38);
            r33.updateRememberedValue(r39);
        L52:
            State r210 = SnapshotStateKt.rememberUpdatedState((Function2) r39, r33, 0);
            Modifier.Companion r211 = Modifier.Companion;
            Modifier r40 = SliderKt.access$rangeSliderPressDragModifier(r211, this.$startInteractionSource, this.$endInteractionSource, r16, r17, this.$enabled, r19, r9, this.$valueRange, r31, r210);
            final float r41 = RangesKt.coerceIn(((Number) this.$value.getStart()).floatValue(), ((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$value.getEndInclusive()).floatValue());
            final float r110 = RangesKt.coerceIn(((Number) this.$value.getEndInclusive()).floatValue(), ((Number) this.$value.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue());
            float r111 = SliderKt.access$calcFraction(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), r41);
            float r112 = SliderKt.access$calcFraction(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), r110);
            int r42 = (int) Math.floor(this.$steps * r112);
            int r43 = (int) Math.floor(this.$steps * (1.0f - r111));
            boolean r44 = this.$enabled;
            boolean r45 = r33.changed(this.$onValueChangeState) | r33.changed(r110);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> r46 = this.$onValueChangeState;
            Object r47 = r33.rememberedValue();
            if (r45 == false) goto L55;
        L56:
            r47 = new x9(r46, r110);
            r33.updateRememberedValue(r47);
        L57:
            Modifier r113 = SliderKt.access$sliderSemantics(r211, r41, r44, (Function1) r47, this.$onValueChangeFinished, RangesKt.rangeTo(((Number) this.$valueRange.getStart()).floatValue(), r110), r42);
            boolean r48 = this.$enabled;
            boolean r49 = r33.changed(this.$onValueChangeState) | r33.changed(r41);
            final State<Function1<ClosedFloatingPointRange<Float>, Unit>> r50 = this.$onValueChangeState;
            Object r51 = r33.rememberedValue();
            if (r49 == false) goto L60;
        L61:
            r51 = new y9(r50, r41);
            r33.updateRememberedValue(r51);
        L62:
            SliderKt.access$RangeSliderImpl(this.$enabled, r111, r112, this.$tickFractions, this.$colors, r10.element - r11.element, this.$startInteractionSource, this.$endInteractionSource, r40, r113, SliderKt.access$sliderSemantics(r211, r110, r48, (Function1) r51, this.$onValueChangeFinished, RangesKt.rangeTo(r41, ((Number) this.$valueRange.getEndInclusive()).floatValue()), r43), r33, 14155776, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L67;
            ComposerKt.traceEventEnd();
            return;
        L67:
            return;
        L60:
            if (r51 != r30.getEmpty()) goto L62;
        L55:
            if (r47 != r30.getEmpty()) goto L57;
        L50:
            if (r39 != r30.getEmpty()) goto L52;
        L45:
            if (r29 != r30.getEmpty()) goto L47;
        L37:
            if (r21 != r30.getEmpty()) goto L39;
        L32:
            if (r15 != r30.getEmpty()) goto L34;
        L22:
            r19 = false;
            goto L23
        L13:
            r3 = false;
            goto L15
        L5:
            if (r33.changed(r32) == false) goto L7;
            int r52 = 4;
        L8:
            r2 = r34 | r52;
            goto L11
        L7:
            r52 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            invoke((BoxWithConstraintsScope) r1, (Composer) r2, ((Number) r3).intValue());
            return Unit.INSTANCE;
        }

        public static final /* synthetic */ float access$invoke$scaleToOffset(ClosedFloatingPointRange r0, Ref.FloatRef r1, Ref.FloatRef r2, float r3) {
            return invoke$scaleToOffset(r0, r1, r2, r3);
        }

        public static final /* synthetic */ ClosedFloatingPointRange access$invoke$scaleToUserValue(Ref.FloatRef r0, Ref.FloatRef r1, ClosedFloatingPointRange r2, ClosedFloatingPointRange r3) {
            return invoke$scaleToUserValue(r0, r1, r2, r3);
        }

        private static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> r1, Ref.FloatRef r2, Ref.FloatRef r3, float r4) {
            return SliderKt.access$scale(((Number) r1.getStart()).floatValue(), ((Number) r1.getEndInclusive()).floatValue(), r4, r2.element, r3.element);
        }

        private static final ClosedFloatingPointRange<Float> invoke$scaleToUserValue(Ref.FloatRef r1, Ref.FloatRef r2, ClosedFloatingPointRange<Float> r3, ClosedFloatingPointRange<Float> r4) {
            return SliderKt.access$scale(r1.element, r2.element, r4, ((Number) r3.getStart()).floatValue(), ((Number) r3.getEndInclusive()).floatValue());
        }

        private static final Unit invoke$lambda$8$lambda$7(MutableFloatState r0, MutableFloatState r1, ClosedFloatingPointRange r2, Ref.FloatRef r3, Ref.FloatRef r4, State r5, ClosedFloatingPointRange r6, boolean r7, float r8) {
            if (r7 == false) goto L4;
            r0.setFloatValue(r0.getFloatValue() + r8);
            r1.setFloatValue(invoke$scaleToOffset(r6, r3, r4, ((Number) r2.getEndInclusive()).floatValue()));
            float r9 = r1.getFloatValue();
            ClosedFloatingPointRange r10 = RangesKt.rangeTo(RangesKt.coerceIn(r0.getFloatValue(), r3.element, r9), r9);
        L5:
            ((Function1) r5.getValue()).invoke(invoke$scaleToUserValue(r3, r4, r6, r10));
            return Unit.INSTANCE;
        L4:
            r1.setFloatValue(r1.getFloatValue() + r8);
            r0.setFloatValue(invoke$scaleToOffset(r6, r3, r4, ((Number) r2.getStart()).floatValue()));
            float r11 = r0.getFloatValue();
            r10 = RangesKt.rangeTo(r11, RangesKt.coerceIn(r1.getFloatValue(), r11, r4.element));
            goto L5
        }

        private static final Unit invoke$lambda$6$lambda$5(MutableFloatState r15, MutableFloatState r16, List r17, Ref.FloatRef r18, Ref.FloatRef r19, Function0 r20, CoroutineScope r21, State r22, ClosedFloatingPointRange r23, boolean r24) {
            if (r24 == false) goto L4;
            MutableFloatState r0 = r15;
        L5:
            float r1 = r0.getFloatValue();
            float r2 = SliderKt.access$snapValueToTick(r1, r17, r18.element, r19.element);
            if (r1 != r2) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L14;
            if (r20 == null) goto L13;
            r20.invoke();
        L13:
            return Unit.INSTANCE;
        L14:
            BuildersKt.launch$default(r21, null, null, new SliderKt$RangeSlider$2$gestureEndAction$1$1$1(r1, r2, r20, r24, r15, r16, r22, r18, r19, r23, null), 3, null);
            return Unit.INSTANCE;
        L8:
            r3 = false;
            goto L9
        L4:
            r0 = r16;
            goto L5
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02442 implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ SliderColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Function0<Unit> $onValueChangeFinished;
        final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
        final /* synthetic */ List<Float> $tickFractions;
        final /* synthetic */ float $value;
        final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        public C02442(ClosedFloatingPointRange<Float> r1, float r2, List<Float> r3, Function0<Unit> r4, MutableInteractionSource r5, boolean r6, SliderColors r7, State<? extends Function1<? super Float, Unit>> r8) {
            this.$valueRange = r1;
            this.$value = r2;
            this.$tickFractions = r3;
            this.$onValueChangeFinished = r4;
            this.$interactionSource = r5;
            this.$enabled = r6;
            this.$colors = r7;
            this.$onValueChangeState = r8;
        }

        public static /* synthetic */ Unit a(MutableFloatState r0, List r1, Ref.FloatRef r2, Ref.FloatRef r3, CoroutineScope r4, SliderDraggableState r5, Function0 r6, float r7) {
            return invoke$lambda$7$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7);
        }

        public static /* synthetic */ Unit b(MutableFloatState r0, MutableFloatState r1, Ref.FloatRef r2, Ref.FloatRef r3, State r4, ClosedFloatingPointRange r5, float r6) {
            return invoke$lambda$4$lambda$3(r0, r1, r2, r3, r4, r5, r6);
        }

        public final void invoke(BoxWithConstraintsScope r30, Composer r31, int r32) {
            if ((r32 & 6) == 0) goto L5;
            int r2 = r32;
        L11:
            if ((r2 & 19) == 18) goto L13;
            boolean r3 = true;
        L15:
            if (r31.shouldExecute(r3, r2 & 1) == true) goto L17;
            r31.skipToGroupEnd();
            return;
        L17:
            if (ComposerKt.isTraceInProgress() == false) goto L20;
            ComposerKt.traceEventStart(2085116814, r2, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:195)");
        L20:
            if (r31.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L22;
            boolean r19 = true;
        L23:
            float r13 = Constraints.getMaxWidth-impl(r30.mo838getConstraintsmsEJaDk());
            final Ref.FloatRef r15 = new Ref.FloatRef();
            final Ref.FloatRef r14 = new Ref.FloatRef();
            Density r1 = (Density) r31.consume(CompositionLocalsKt.getLocalDensity());
            r15.element = Math.max(r13 - r1.toPx-0680j_4(SliderKt.getThumbRadius()), androidx.compose.material3.MenuKt.ClosedAlphaTarget);
            r14.element = Math.min(r1.toPx-0680j_4(SliderKt.getThumbRadius()), r15.element);
            Object r4 = r31.rememberedValue();
            Composer.Companion r28 = Composer.Companion;
            if (r4 != r28.getEmpty()) goto L26;
            r4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r31);
            r31.updateRememberedValue(r4);
        L26:
            final CoroutineScope r10 = (CoroutineScope) r4;
            float r5 = this.$value;
            ClosedFloatingPointRange<Float> r6 = this.$valueRange;
            Object r7 = r31.rememberedValue();
            if (r7 != r28.getEmpty()) goto L29;
            r7 = PrimitiveSnapshotStateKt.mutableFloatStateOf(invoke$scaleToOffset(r6, r14, r15, r5));
            r31.updateRememberedValue(r7);
        L29:
            final MutableFloatState r16 = (MutableFloatState) r7;
            Object r8 = r31.rememberedValue();
            if (r8 != r28.getEmpty()) goto L32;
            r8 = PrimitiveSnapshotStateKt.mutableFloatStateOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
            r31.updateRememberedValue(r8);
        L32:
            final MutableFloatState r17 = (MutableFloatState) r8;
            boolean r9 = (r31.changed(r14.element) | r31.changed(r15.element)) | r31.changed(this.$valueRange);
            final State<Function1<Float, Unit>> r11 = this.$onValueChangeState;
            final ClosedFloatingPointRange<Float> r12 = this.$valueRange;
            Object r18 = r31.rememberedValue();
            if (r9 == false) goto L35;
        L36:
            SliderDraggableState r110 = new SliderDraggableState(new aa(r16, r17, r14, r15, r11, r12));
            r31.updateRememberedValue(r110);
            r18 = r110;
        L37:
            final SliderDraggableState r111 = (SliderDraggableState) r18;
            boolean r20 = (r31.changed(this.$valueRange) | r31.changed(r14.element)) | r31.changed(r15.element);
            ClosedFloatingPointRange<Float> r21 = this.$valueRange;
            Object r22 = r31.rememberedValue();
            if (r20 == false) goto L40;
        L41:
            r22 = new SliderKt$Slider$2$2$1(r21, r14, r15);
            r31.updateRememberedValue(r22);
        L42:
            SliderKt.access$CorrectValueSideEffect((KFunction) r22, this.$valueRange, RangesKt.rangeTo(r14.element, r15.element), r16, this.$value, r31, 3072);
            boolean r23 = ((((r31.changedInstance(this.$tickFractions) | r31.changed(r14.element)) | r31.changed(r15.element)) | r31.changedInstance(r10)) | r31.changedInstance(r111)) | r31.changed(this.$onValueChangeFinished);
            final List<Float> r24 = this.$tickFractions;
            final Function0<Unit> r25 = this.$onValueChangeFinished;
            Object r26 = r31.rememberedValue();
            if (r23 == false) goto L45;
        L46:
            r26 = new ba(r16, r24, r14, r15, r10, r111, r25);
            r31.updateRememberedValue(r26);
        L47:
            State r27 = SnapshotStateKt.rememberUpdatedState((Function1) r26, r31, 0);
            Modifier.Companion r29 = Modifier.Companion;
            Modifier r33 = SliderKt.access$sliderTapModifier(r29, r111, this.$interactionSource, r13, r19, r16, r27, r17, this.$enabled);
            Orientation r112 = Orientation.Horizontal;
            boolean r113 = r111.isDragging();
            boolean r114 = this.$enabled;
            MutableInteractionSource r115 = this.$interactionSource;
            boolean r34 = r31.changed(r27);
            Object r35 = r31.rememberedValue();
            if (r34 == false) goto L50;
        L51:
            r35 = new SliderKt$Slider$2$drag$1$1(r27, null);
            r31.updateRememberedValue(r35);
        L52:
            Modifier r36 = DraggableKt.draggable$default(r29, r111, r112, r114, r115, r113, null, (Function3) r35, r19, 32, null);
            SliderKt.access$SliderImpl(this.$enabled, SliderKt.access$calcFraction(((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue(), RangesKt.coerceIn(this.$value, ((Number) this.$valueRange.getStart()).floatValue(), ((Number) this.$valueRange.getEndInclusive()).floatValue())), this.$tickFractions, this.$colors, r15.element - r14.element, this.$interactionSource, r33.then(r36), r31, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L57;
            ComposerKt.traceEventEnd();
            return;
        L57:
            return;
        L50:
            if (r35 != r28.getEmpty()) goto L52;
        L45:
            if (r26 != r28.getEmpty()) goto L47;
        L40:
            if (r22 != r28.getEmpty()) goto L42;
        L35:
            if (r18 != r28.getEmpty()) goto L37;
        L22:
            r19 = false;
            goto L23
        L13:
            r3 = false;
            goto L15
        L5:
            if (r31.changed(r30) == false) goto L7;
            int r37 = 4;
        L8:
            r2 = r32 | r37;
            goto L11
        L7:
            r37 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            invoke((BoxWithConstraintsScope) r1, (Composer) r2, ((Number) r3).intValue());
            return Unit.INSTANCE;
        }

        public static final /* synthetic */ float access$invoke$scaleToOffset(ClosedFloatingPointRange r0, Ref.FloatRef r1, Ref.FloatRef r2, float r3) {
            return invoke$scaleToOffset(r0, r1, r2, r3);
        }

        private static final float invoke$scaleToOffset(ClosedFloatingPointRange<Float> r1, Ref.FloatRef r2, Ref.FloatRef r3, float r4) {
            return SliderKt.access$scale(((Number) r1.getStart()).floatValue(), ((Number) r1.getEndInclusive()).floatValue(), r4, r2.element, r3.element);
        }

        private static final float invoke$scaleToUserValue(Ref.FloatRef r1, Ref.FloatRef r2, ClosedFloatingPointRange<Float> r3, float r4) {
            return SliderKt.access$scale(r1.element, r2.element, r4, ((Number) r3.getStart()).floatValue(), ((Number) r3.getEndInclusive()).floatValue());
        }

        private static final Unit invoke$lambda$4$lambda$3(MutableFloatState r1, MutableFloatState r2, Ref.FloatRef r3, Ref.FloatRef r4, State r5, ClosedFloatingPointRange r6, float r7) {
            r1.setFloatValue((r1.getFloatValue() + r7) + r2.getFloatValue());
            r2.setFloatValue(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
            float r8 = RangesKt.coerceIn(r1.getFloatValue(), r3.element, r4.element);
            ((Function1) r5.getValue()).invoke(Float.valueOf(invoke$scaleToUserValue(r3, r4, r6, r8)));
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$7$lambda$6(MutableFloatState r7, List r8, Ref.FloatRef r9, Ref.FloatRef r10, CoroutineScope r11, SliderDraggableState r12, Function0 r13, float r14) {
            float r2 = r7.getFloatValue();
            float r3 = SliderKt.access$snapValueToTick(r2, r8, r9.element, r10.element);
            if (r2 != r3) goto L5;
            boolean r15 = true;
        L6:
            if (r15 == true) goto L9;
            BuildersKt.launch$default(r11, null, null, new SliderKt$Slider$2$gestureEndAction$1$1$1(r12, r2, r3, r14, r13, null), 3, null);
        L13:
            return Unit.INSTANCE;
        L9:
            if (r12.isDragging() == true) goto L13;
            if (r13 == null) goto L13;
            r13.invoke();
            goto L13
        L5:
            r15 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", i = {}, l = {1051}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02452 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        public C02452(float r1, float r2, float r3, Continuation<? super C02452> r4) {
            this.$current = r1;
            this.$target = r2;
            this.$velocity = r3;
            super(2, r4);
        }

        public static /* synthetic */ Unit a(DragScope r0, Ref.FloatRef r1, Animatable r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C02452 r0 = new C02452(this.$current, this.$target, this.$velocity, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(DragScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((DragScope) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            final DragScope r15 = (DragScope) this.L$0;
            final Ref.FloatRef r2 = new Ref.FloatRef();
            float r3 = this.$current;
            r2.element = r3;
            Animatable r7 = AnimatableKt.Animatable$default(r3, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null);
            Float r8 = Boxing.boxFloat(this.$target);
            TweenSpec r9 = SliderKt.access$getSliderToTickAnimation$p();
            Float r10 = Boxing.boxFloat(this.$velocity);
            Function1 r11 = new ca(r15, r2);
            this.label = 1;
            if (r7.animateTo(r8, r9, r10, r11, this) != r0) goto L12;
            return r0;
        }

        private static final Unit invokeSuspend$lambda$0(DragScope r2, Ref.FloatRef r3, Animatable r4) {
            r2.dragBy(((Number) r4.getValue()).floatValue() - r3.element);
            r3.element = ((Number) r4.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    private static final Unit CorrectValueSideEffect$lambda$36(Function1 r7, ClosedFloatingPointRange r8, ClosedFloatingPointRange r9, MutableState r10, float r11, int r12, Composer r13, int r14) {
        CorrectValueSideEffect(r7, r8, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit RangeSlider$lambda$9(ClosedFloatingPointRange r12, Function1 r13, Modifier r14, boolean r15, ClosedFloatingPointRange r16, int r17, Function0 r18, SliderColors r19, int r20, int r21, Composer r22, int r23) {
        RangeSlider(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit RangeSliderImpl$lambda$19(boolean r15, float r16, float r17, List r18, SliderColors r19, float r20, MutableInteractionSource r21, MutableInteractionSource r22, Modifier r23, Modifier r24, Modifier r25, int r26, int r27, Composer r28, int r29) {
        RangeSliderImpl(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r28, RecomposeScopeImplKt.updateChangedFlags(r26 | 1), RecomposeScopeImplKt.updateChangedFlags(r27));
        return Unit.INSTANCE;
    }

    private static final Unit Slider$lambda$3(float r13, Function1 r14, Modifier r15, boolean r16, ClosedFloatingPointRange r17, int r18, Function0 r19, MutableInteractionSource r20, SliderColors r21, int r22, int r23, Composer r24, int r25) {
        Slider(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit SliderImpl$lambda$12(boolean r10, float r11, List r12, SliderColors r13, float r14, MutableInteractionSource r15, Modifier r16, int r17, Composer r18, int r19) {
        SliderImpl(r10, r11, r12, r13, r14, r15, r16, r18, RecomposeScopeImplKt.updateChangedFlags(r17 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SliderThumb_PcYyNuk$lambda$23(BoxScope r10, Modifier r11, float r12, MutableInteractionSource r13, SliderColors r14, boolean r15, float r16, int r17, Composer r18, int r19) {
        m2150SliderThumbPcYyNuk(r10, r11, r12, r13, r14, r15, r16, r18, RecomposeScopeImplKt.updateChangedFlags(r17 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Track$lambda$29(Modifier r11, SliderColors r12, boolean r13, float r14, float r15, List r16, float r17, float r18, int r19, Composer r20, int r21) {
        Track(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(BoxScope r0, Modifier r1, float r2, MutableInteractionSource r3, SliderColors r4, boolean r5, float r6, int r7, Composer r8, int r9) {
        return SliderThumb_PcYyNuk$lambda$23(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ boolean b(ClosedFloatingPointRange r0, int r1, float r2, Function1 r3, Function0 r4, float r5) {
        return sliderSemantics$lambda$38$lambda$37(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit c(float r0, Function1 r1, Modifier r2, boolean r3, ClosedFloatingPointRange r4, int r5, Function0 r6, MutableInteractionSource r7, SliderColors r8, int r9, int r10, Composer r11, int r12) {
        return Slider$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    private static final float calcFraction(float r2, float r3, float r4) {
        float r5 = r3 - r2;
        float r0 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
        if (r5 != androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        float r6 = androidx.compose.material3.MenuKt.ClosedAlphaTarget;
    L10:
        if (r6 < androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L14;
        r0 = r6;
    L14:
        if (r0 <= 1.0f) goto L17;
        return 1.0f;
    L17:
        return r0;
    L8:
        r6 = (r4 - r2) / r5;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ Unit d(boolean r0, float r1, float r2, List r3, SliderColors r4, float r5, MutableInteractionSource r6, MutableInteractionSource r7, Modifier r8, Modifier r9, Modifier r10, int r11, int r12, Composer r13, int r14) {
        return RangeSliderImpl$lambda$19(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit e(String r0, SemanticsPropertyReceiver r1) {
        return RangeSliderImpl$lambda$18$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ Unit f(String r0, SemanticsPropertyReceiver r1) {
        return RangeSliderImpl$lambda$18$lambda$17$lambda$16(r0, r1);
    }

    public static /* synthetic */ Unit g(ClosedFloatingPointRange r0, Function1 r1, Modifier r2, boolean r3, ClosedFloatingPointRange r4, int r5, Function0 r6, SliderColors r7, int r8, int r9, Composer r10, int r11) {
        return RangeSlider$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit h(Modifier r0, SliderColors r1, boolean r2, float r3, float r4, List r5, float r6, float r7, int r8, Composer r9, int r10) {
        return Track$lambda$29(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit i(Ref.FloatRef r0, PointerInputChange r1, float r2) {
        return awaitSlop_8vUncbI$lambda$32(r0, r1, r2);
    }

    public static /* synthetic */ Unit j(Function1 r0, ClosedFloatingPointRange r1, ClosedFloatingPointRange r2, MutableState r3, float r4, int r5, Composer r6, int r7) {
        return CorrectValueSideEffect$lambda$36(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit k(float r0, State r1, float r2, float r3, float r4, State r5, List r6, State r7, State r8, DrawScope r9) {
        return Track$lambda$28$lambda$27(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit l(boolean r0, float r1, List r2, SliderColors r3, float r4, MutableInteractionSource r5, Modifier r6, int r7, Composer r8, int r9) {
        return SliderImpl$lambda$12(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ Unit m(boolean r0, ClosedFloatingPointRange r1, int r2, float r3, Function1 r4, Function0 r5, SemanticsPropertyReceiver r6) {
        return sliderSemantics$lambda$38(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit n(ClosedFloatingPointRange r0, Function1 r1, float r2, MutableState r3, ClosedFloatingPointRange r4) {
        return CorrectValueSideEffect$lambda$35$lambda$34(r0, r1, r2, r3, r4);
    }

    static {
        ThumbRadius = Dp.constructor-impl(10);
        ThumbRippleRadius = Dp.constructor-impl(24);
        ThumbDefaultElevation = Dp.constructor-impl(1);
        ThumbPressedElevation = Dp.constructor-impl(6);
        TrackHeight = Dp.constructor-impl(4);
        float r1 = Dp.constructor-impl(48);
        SliderHeight = r1;
        float r2 = Dp.constructor-impl(144);
        SliderMinWidth = r2;
        DefaultSliderConstraints = SizeKt.m1002heightInVpY3zN4$default(SizeKt.m1021widthInVpY3zN4$default(Modifier.Companion, r2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 2, null), androidx.compose.material3.MenuKt.ClosedAlphaTarget, r1, 1, null);
        SliderToTickAnimation = new TweenSpec(100, 0, null, 6, null);
    }

    public static final /* synthetic */ TweenSpec access$getSliderToTickAnimation$p() {
        return SliderToTickAnimation;
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    private static final List<Float> stepsToTickFractions(int r5) {
        if (r5 == 0) goto L10;
        int r0 = r5 + 2;
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        r1.add(Float.valueOf(r2 / (r5 + 1)));
        r2 = r2 + 1;
        goto L5
    L8:
        return r1;
    L10:
        return CollectionsKt.emptyList();
    }

    private static final Unit RangeSliderImpl$lambda$18$lambda$15$lambda$14(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    private static final Unit RangeSliderImpl$lambda$18$lambda$17$lambda$16(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$calcFraction(float r0, float r1, float r2) {
        return calcFraction(r0, r1, r2);
    }

    private static final Unit awaitSlop_8vUncbI$lambda$32(Ref.FloatRef r0, PointerInputChange r1, float r2) {
        r1.consume();
        r0.element = r2;
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$awaitSlop-8vUncbI, reason: not valid java name */
    public static final /* synthetic */ Object m2151access$awaitSlop8vUncbI(AwaitPointerEventScope r0, long r1, int r3, Continuation r4) {
        return m2152awaitSlop8vUncbI(r0, r1, r3, r4);
    }

    public static final /* synthetic */ float access$snapValueToTick(float r0, List r1, float r2, float r3) {
        return snapValueToTick(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    private static final Object m2152awaitSlop8vUncbI(AwaitPointerEventScope r8, long r9, int r11, Continuation<? super Pair<PointerInputChange, Float>> r12) {
        if ((r12 instanceof SliderKt$awaitSlop$1) == false) goto L7;
        SliderKt$awaitSlop$1 r0 = (SliderKt$awaitSlop$1) r12;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        SliderKt$awaitSlop$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.FloatRef r10 = (Ref.FloatRef) r6.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        PointerInputChange r14 = (PointerInputChange) r13;
        if (r14 != null) goto L23;
        return null;
    L23:
        return TuplesKt.to(r14, Boxing.boxFloat(r10.element));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        final Ref.FloatRef r15 = new Ref.FloatRef();
        Function2 r5 = new m9(r15);
        r6.L$0 = r15;
        r6.label = 1;
        Object r16 = DragGestureDetectorCopyKt.m2033awaitHorizontalPointerSlopOrCancellationgDDlDlE(r8, r9, r11, r5, r6);
        if (r16 != r2) goto L17;
        return r2;
    L17:
        r13 = r16;
        r10 = r15;
    L7:
        r0 = new SliderKt$awaitSlop$1(r12);
        goto L8
    }

    private static final float snapValueToTick(float r7, List<Float> r8, float r9, float r10) {
        if (r8.isEmpty() == false) goto L5;
        Object r11 = null;
    L13:
        Float r12 = (Float) r11;
        if (r12 != null) goto L16;
        return r7;
    L16:
        return MathHelpersKt.lerp(r9, r10, r12.floatValue());
    L5:
        Object r0 = ListProtector.get(r8, 0);
        float r1 = Math.abs(MathHelpersKt.lerp(r9, r10, ((Number) r0).floatValue()) - r7);
        int r2 = CollectionsKt.getLastIndex(r8);
        int r3 = 1;
        if (1 > r2) goto L12;
    L7:
        Object r4 = ListProtector.get(r8, r3);
        float r5 = Math.abs(MathHelpersKt.lerp(r9, r10, ((Number) r4).floatValue()) - r7);
        if (Float.compare(r1, r5) <= 0) goto L10;
        r0 = r4;
        r1 = r5;
    L10:
        if (r3 == r2) goto L12;
        r3 = r3 + 1;
    L12:
        r11 = r0;
        goto L13
    }

    private static final Unit CorrectValueSideEffect$lambda$35$lambda$34(ClosedFloatingPointRange r1, Function1 r2, float r3, MutableState r4, ClosedFloatingPointRange r5) {
        float r0 = (((Number) r1.getEndInclusive()).floatValue() - ((Number) r1.getStart()).floatValue()) / 1000;
        float r6 = ((Number) r2.invoke(Float.valueOf(r3))).floatValue();
        if (Math.abs(r6 - ((Number) r4.getValue()).floatValue()) <= r0) goto L8;
        if (r5.contains((Comparable) r4.getValue()) == false) goto L8;
        r4.setValue(Float.valueOf(r6));
    L8:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$animateToTarget(DraggableState r0, float r1, float r2, float r3, Continuation r4) {
        return animateToTarget(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ float access$scale(float r0, float r1, float r2, float r3, float r4) {
        return scale(r0, r1, r2, r3, r4);
    }

    private static final Object animateToTarget(DraggableState r6, float r7, float r8, float r9, Continuation<? super Unit> r10) {
        Object r11 = DraggableState.CC.drag$default(r6, null, new C02452(r7, r8, r9, null), r10, 1, null);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    private static final ClosedFloatingPointRange<Float> scale(float r1, float r2, ClosedFloatingPointRange<Float> r3, float r4, float r5) {
        return RangesKt.rangeTo(scale(r1, r2, ((Number) r3.getStart()).floatValue(), r4, r5), scale(r1, r2, ((Number) r3.getEndInclusive()).floatValue(), r4, r5));
    }

    public static final /* synthetic */ ClosedFloatingPointRange access$scale(float r0, float r1, ClosedFloatingPointRange r2, float r3, float r4) {
        return scale(r0, r1, r2, r3, r4);
    }

    private static final float scale(float r0, float r1, float r2, float r3, float r4) {
        return MathHelpersKt.lerp(r3, r4, calcFraction(r0, r1, r2));
    }

    private static final boolean sliderSemantics$lambda$38$lambda$37(ClosedFloatingPointRange r9, int r10, float r11, Function1 r12, Function0 r13, float r14) {
        float r15 = RangesKt.coerceIn(r14, ((Number) r9.getStart()).floatValue(), ((Number) r9.getEndInclusive()).floatValue());
        if (r10 <= 0) goto L14;
        int r16 = r10 + 1;
        if (r16 < 0) goto L14;
        float r3 = r15;
        float r4 = r3;
        int r2 = 0;
    L7:
        float r5 = MathHelpersKt.lerp(((Number) r9.getStart()).floatValue(), ((Number) r9.getEndInclusive()).floatValue(), r2 / r16);
        float r6 = r5 - r15;
        if (Math.abs(r6) > r3) goto L10;
        r3 = Math.abs(r6);
        r4 = r5;
    L10:
        if (r2 == r16) goto L12;
        r2 = r2 + 1;
        goto L7
    L12:
        r15 = r4;
    L14:
        if (r15 != r11) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L25;
        r12.invoke(Float.valueOf(r15));
        if (r13 == null) goto L22;
        r13.invoke();
    L22:
        return true;
    L25:
        return false;
    L16:
        r17 = false;
        goto L17
    }

    private static final void CorrectValueSideEffect(final Function1<? super Float, Float> r17, final ClosedFloatingPointRange<Float> r18, final ClosedFloatingPointRange<Float> r19, final MutableState<Float> r20, final float r21, Composer r22, final int r23) {
        Composer r1 = r22.startRestartGroup(-743965752);
        if ((r23 & 6) == 0) goto L5;
        int r4 = r23;
    L11:
        if ((r23 & 48) != 0) goto L19;
        if (r1.changed(r18) == false) goto L15;
        int r8 = 32;
    L16:
        r4 = r4 | r8;
        goto L19
    L15:
        r8 = 16;
    L19:
        if ((r23 & 384) != 0) goto L26;
        if (r1.changed(r19) == false) goto L23;
        int r9 = 256;
    L24:
        r4 = r4 | r9;
        goto L26
    L23:
        r9 = 128;
    L26:
        if ((r23 & 3072) != 0) goto L33;
        if (r1.changed(r20) == false) goto L30;
        int r10 = 2048;
    L31:
        r4 = r4 | r10;
        goto L33
    L30:
        r10 = 1024;
    L33:
        if ((r23 & 24576) == 0) goto L35;
    L39:
        boolean r16 = true;
        if ((r4 & 9363) == 9362) goto L42;
        boolean r11 = true;
    L44:
        if (r1.shouldExecute(r11, r4 & 1) == true) goto L46;
        r1.skipToGroupEnd();
    L79:
        ScopeUpdateScope r7 = r1.endRestartGroup();
        if (r7 == null) goto L83;
        r7.updateScope(new r9(r17, r18, r19, r20, r21, r23));
        return;
    L83:
        return;
    L46:
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventStart(-743965752, r4, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:927)");
    L49:
        if ((r4 & 112) != 32) goto L51;
        boolean r0 = true;
    L53:
        if ((r4 & 14) != 4) goto L55;
        boolean r3 = true;
    L56:
        boolean r2 = r0 | r3;
        if ((57344 & r4) != 16384) goto L59;
        boolean r5 = true;
    L60:
        boolean r6 = r2 | r5;
        if ((r4 & 7168) != 2048) goto L63;
        boolean r12 = true;
    L64:
        boolean r13 = r6 | r12;
        if ((r4 & 896) == 256) goto L68;
        r16 = false;
    L68:
        boolean r14 = r13 | r16;
        Object r15 = r1.rememberedValue();
        if (r14 == false) goto L71;
    L74:
        int r24 = 0;
        r15 = new q9(r18, r17, r21, r20, r19);
        r1.updateRememberedValue(r15);
    L75:
        EffectsKt.SideEffect((Function0) r15, r1, r24);
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
        goto L79
    L71:
        if (r15 == Composer.Companion.getEmpty()) goto L74;
        r24 = 0;
        goto L75
    L63:
        r12 = false;
        goto L64
    L59:
        r5 = false;
        goto L60
    L55:
        r3 = false;
        goto L56
    L51:
        r0 = false;
        goto L53
    L42:
        r11 = false;
        goto L44
    L35:
        if (r1.changed(r21) == false) goto L37;
        int r25 = 16384;
    L38:
        r4 = r4 | r25;
        goto L39
    L37:
        r25 = 8192;
        goto L38
    L5:
        if (r1.changedInstance(r17) == false) goto L7;
        int r26 = 4;
    L8:
        r4 = r26 | r23;
        goto L11
    L7:
        r26 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$CorrectValueSideEffect(Function1 r0, ClosedFloatingPointRange r1, ClosedFloatingPointRange r2, MutableState r3, float r4, Composer r5, int r6) {
        CorrectValueSideEffect(r0, r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ Modifier access$sliderSemantics(Modifier r0, float r1, boolean r2, Function1 r3, Function0 r4, ClosedFloatingPointRange r5, int r6) {
        return sliderSemantics(r0, r1, r2, r3, r4, r5, r6);
    }

    private static final Modifier sliderSemantics(Modifier r9, float r10, final boolean r11, final Function1<? super Float, Unit> r12, final Function0<Unit> r13, final ClosedFloatingPointRange<Float> r14, final int r15) {
        final float r6 = RangesKt.coerceIn(r10, ((Number) r14.getStart()).floatValue(), ((Number) r14.getEndInclusive()).floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(r9, false, new s9(r11, r14, r15, r6, r12, r13), 1, null), r10, r14, r15);
    }

    private static final Unit sliderSemantics$lambda$38(boolean r6, final ClosedFloatingPointRange r7, final int r8, final float r9, final Function1 r10, final Function0 r11, SemanticsPropertyReceiver r12) {
        if (r6 == true) goto L4;
        SemanticsPropertiesKt.disabled(r12);
    L4:
        SemanticsPropertiesKt.setProgress$default(r12, null, new h9(r7, r8, r9, r10, r11), 1, null);
        return Unit.INSTANCE;
    }

    private static final Modifier slideOnKeyEvents(Modifier r9, final boolean r10, final int r11, final ClosedFloatingPointRange<Float> r12, final float r13, final boolean r14, final State<? extends Function1<? super Float, Unit>> r15, final State<? extends Function0<Unit>> r16) {
        if (r11 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return KeyInputModifierKt.onKeyEvent(r9, new C02462(r10, r12, r11, r15, r13, r14, r16));
    L9:
        throw new IllegalArgumentException("steps should be >= 0".toString());
    L4:
        r0 = false;
        goto L5
    }

    private static final void SliderImpl(final boolean r27, final float r28, final List<Float> r29, final SliderColors r30, final float r31, final MutableInteractionSource r32, final Modifier r33, Composer r34, final int r35) {
        Composer r14 = r34.startRestartGroup(1679682785);
        if ((r35 & 6) == 0) goto L5;
        int r1 = r35;
    L11:
        if ((r35 & 48) != 0) goto L18;
        if (r14.changed(r28) == false) goto L15;
        int r3 = 32;
    L16:
        r1 = r1 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r35 & 384) != 0) goto L25;
        if (r14.changedInstance(r29) == false) goto L22;
        int r4 = 256;
    L23:
        r1 = r1 | r4;
        goto L25
    L22:
        r4 = 128;
    L25:
        if ((r35 & 3072) != 0) goto L32;
        if (r14.changed(r30) == false) goto L29;
        int r5 = 2048;
    L30:
        r1 = r1 | r5;
        goto L32
    L29:
        r5 = 1024;
    L32:
        if ((r35 & 24576) != 0) goto L39;
        if (r14.changed(r31) == false) goto L36;
        int r6 = 16384;
    L37:
        r1 = r1 | r6;
        goto L39
    L36:
        r6 = 8192;
    L39:
        if ((196608 & r35) != 0) goto L46;
        if (r14.changed(r32) == false) goto L43;
        int r7 = 131072;
    L44:
        r1 = r1 | r7;
        goto L46
    L43:
        r7 = 65536;
    L46:
        if ((1572864 & r35) == 0) goto L48;
    L52:
        int r8 = r1;
        if ((599187 & r8) == 599186) goto L55;
        boolean r2 = true;
    L57:
        if (r14.shouldExecute(r2, r8 & 1) == true) goto L59;
        r14.skipToGroupEnd();
    L77:
        ScopeUpdateScope r9 = r14.endRestartGroup();
        if (r9 == null) goto L81;
        r9.updateScope(new t9(r27, r28, r29, r30, r31, r32, r33, r35));
        return;
    L81:
        return;
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(1679682785, r8, -1, "androidx.compose.material.SliderImpl (Slider.kt:683)");
    L61:
        Modifier r0 = r33.then(DefaultSliderConstraints);
        MeasurePolicy r10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        int r11 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r12 = r14.getCurrentCompositionLocalMap();
        Modifier r13 = ComposedModifierKt.materializeModifier(r14, r0);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r15 = r16.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L64;
        ComposablesKt.invalidApplier();
    L64:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L67;
        r14.createNode(r15);
    L68:
        Composer r17 = Updater.constructor-impl(r14);
        Updater.set-impl(r17, r10, r16.getSetMeasurePolicy());
        Updater.set-impl(r17, r12, r16.getSetResolvedCompositionLocals());
        Function2 r18 = r16.getSetCompositeKeyHash();
        if (r17.getInserting() == false) goto L71;
    L72:
        r17.updateRememberedValue(Integer.valueOf(r11));
        r17.apply(Integer.valueOf(r11), r18);
    L73:
        Updater.set-impl(r17, r13, r16.getSetModifier());
        BoxScopeInstance r19 = BoxScopeInstance.INSTANCE;
        Density r20 = (Density) r14.consume(CompositionLocalsKt.getLocalDensity());
        float r110 = r20.toPx-0680j_4(TrackHeight);
        float r21 = ThumbRadius;
        float r111 = r20.toPx-0680j_4(r21);
        float r22 = r20.toDp-u2uoSUM(r31);
        float r112 = Dp.constructor-impl(r21 * 2);
        float r23 = Dp.constructor-impl(r22 * r28);
        Modifier.Companion r24 = Modifier.Companion;
        int r25 = r8 >> 6;
        int r26 = r8 << 9;
        Track(SizeKt.fillMaxSize$default(r24, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), r30, r27, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r28, r29, r111, r110, r14, ((((r25 & 112) | 3078) | ((r8 << 6) & 896)) | (r26 & 57344)) | (r26 & 458752));
        m2150SliderThumbPcYyNuk(r19, r24, r23, r32, r30, r27, r112, r14, (((r25 & 7168) | 1572918) | ((r8 << 3) & 57344)) | ((r8 << 15) & 458752));
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventEnd();
        goto L77
    L71:
        if (Intrinsics.areEqual(r17.rememberedValue(), Integer.valueOf(r11)) == true) goto L73;
    L67:
        r14.useNode();
        goto L68
    L55:
        r2 = false;
        goto L57
    L48:
        if (r14.changed(r33) == false) goto L50;
        int r36 = 1048576;
    L51:
        r1 = r1 | r36;
        goto L52
    L50:
        r36 = 524288;
        goto L51
    L5:
        if (r14.changed(r27) == false) goto L7;
        int r37 = 4;
    L8:
        r1 = r37 | r35;
        goto L11
    L7:
        r37 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    private static final void m2150SliderThumbPcYyNuk(final BoxScope r28, final Modifier r29, final float r30, final MutableInteractionSource r31, final SliderColors r32, final boolean r33, final float r34, Composer r35, final int r36) {
        Composer r3 = r35.startRestartGroup(428907178);
        if ((r36 & 6) == 0) goto L5;
        int r9 = r36;
    L11:
        if ((r36 & 48) != 0) goto L18;
        if (r3.changed(r29) == false) goto L15;
        int r11 = 32;
    L16:
        r9 = r9 | r11;
        goto L18
    L15:
        r11 = 16;
    L18:
        if ((r36 & 384) != 0) goto L26;
        if (r3.changed(r30) == false) goto L22;
        int r12 = 256;
    L23:
        r9 = r9 | r12;
        goto L26
    L22:
        r12 = 128;
    L26:
        if ((r36 & 3072) != 0) goto L33;
        if (r3.changed(r31) == false) goto L30;
        int r13 = 2048;
    L31:
        r9 = r9 | r13;
        goto L33
    L30:
        r13 = 1024;
    L33:
        if ((r36 & 24576) != 0) goto L40;
        if (r3.changed(r32) == false) goto L37;
        int r14 = 16384;
    L38:
        r9 = r9 | r14;
        goto L40
    L37:
        r14 = 8192;
    L40:
        if ((196608 & r36) != 0) goto L47;
        if (r3.changed(r33) == false) goto L44;
        int r15 = 131072;
    L45:
        r9 = r9 | r15;
        goto L47
    L44:
        r15 = 65536;
    L47:
        if ((1572864 & r36) != 0) goto L54;
        if (r3.changed(r34) == false) goto L51;
        int r16 = 1048576;
    L52:
        r9 = r9 | r16;
        goto L54
    L51:
        r16 = 524288;
    L54:
        if ((599187 & r9) == 599186) goto L56;
        boolean r17 = true;
    L58:
        if (r3.shouldExecute(r17, r9 & 1) == true) goto L60;
        r3.skipToGroupEnd();
    L98:
        ScopeUpdateScope r10 = r3.endRestartGroup();
        if (r10 == null) goto L102;
        r10.updateScope(new p9(r28, r29, r30, r31, r32, r33, r34, r36));
        return;
    L102:
        return;
    L60:
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventStart(428907178, r9, -1, "androidx.compose.material.SliderThumb (Slider.kt:787)");
    L62:
        Modifier r18 = PaddingKt.m964paddingqDBjuR0$default(Modifier.Companion, r30, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        Alignment.Companion r19 = Alignment.Companion;
        Modifier r110 = r28.align(r18, r19.getCenterStart());
        MeasurePolicy r111 = BoxKt.maybeCachedBoxMeasurePolicy(r19.getTopStart(), false);
        int r112 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r113 = r3.getCurrentCompositionLocalMap();
        Modifier r114 = ComposedModifierKt.materializeModifier(r3, r110);
        ComposeUiNode.Companion r115 = ComposeUiNode.Companion;
        Function0 r116 = r115.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L65;
        ComposablesKt.invalidApplier();
    L65:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L68;
        r3.createNode(r116);
    L69:
        Composer r0 = Updater.constructor-impl(r3);
        Updater.set-impl(r0, r111, r115.getSetMeasurePolicy());
        Updater.set-impl(r0, r113, r115.getSetResolvedCompositionLocals());
        Function2 r117 = r115.getSetCompositeKeyHash();
        if (r0.getInserting() == false) goto L72;
    L73:
        r0.updateRememberedValue(Integer.valueOf(r112));
        r0.apply(Integer.valueOf(r112), r117);
    L74:
        Updater.set-impl(r0, r114, r115.getSetModifier());
        BoxScopeInstance r1 = BoxScopeInstance.INSTANCE;
        Object r2 = r3.rememberedValue();
        Composer.Companion r118 = Composer.Companion;
        if (r2 != r118.getEmpty()) goto L77;
        r2 = SnapshotStateKt.mutableStateListOf();
        r3.updateRememberedValue(r2);
    L77:
        SnapshotStateList r4 = (SnapshotStateList) r2;
        if ((r9 & 7168) != 2048) goto L80;
        boolean r119 = true;
    L81:
        Object r120 = r3.rememberedValue();
        if (r119 == false) goto L84;
    L85:
        r120 = new SliderKt$SliderThumb$1$1$1(r31, r4, null);
        r3.updateRememberedValue(r120);
    L86:
        int r121 = r9 >> 9;
        EffectsKt.LaunchedEffect(r31, (Function2) r120, r3, r121 & 14);
        if ((!r4.isEmpty()) == false) goto L89;
        float r5 = ThumbPressedElevation;
    L90:
        Modifier r122 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m1016sizeVpY3zN4(r29, r34, r34), r31, RippleKt.m2139rippleH2RKhps$default(false, ThumbRippleRadius, 0, 4, null)), r31, false, 2, null);
        if (r33 == true) goto L94;
        r5 = Dp.constructor-impl(0);
    L94:
        SpacerKt.Spacer(BackgroundKt.m341backgroundbw27NRU(ShadowKt.shadow-s4CzXII$default(r122, r5, RoundedCornerShapeKt.getCircleShape(), false, 0, 0, 24, null), ((Color) r32.thumbColor(r33, r3, ((r9 >> 15) & 14) | (r121 & 112)).getValue()).unbox-impl(), RoundedCornerShapeKt.getCircleShape()), r3, 0);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
        goto L98
    L89:
        r5 = ThumbDefaultElevation;
        goto L90
    L84:
        if (r120 != r118.getEmpty()) goto L86;
    L80:
        r119 = false;
        goto L81
    L72:
        if (Intrinsics.areEqual(r0.rememberedValue(), Integer.valueOf(r112)) == true) goto L74;
    L68:
        r3.useNode();
        goto L69
    L56:
        r17 = false;
        goto L58
    L5:
        if (r3.changed(r28) == false) goto L7;
        int r20 = 4;
    L8:
        r9 = r20 | r36;
        goto L11
    L7:
        r20 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$SliderImpl(boolean r0, float r1, List r2, SliderColors r3, float r4, MutableInteractionSource r5, Modifier r6, Composer r7, int r8) {
        SliderImpl(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static final /* synthetic */ Modifier access$sliderTapModifier(Modifier r0, DraggableState r1, MutableInteractionSource r2, float r3, boolean r4, State r5, State r6, MutableState r7, boolean r8) {
        return sliderTapModifier(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Modifier sliderSemantics$default(Modifier r7, float r8, boolean r9, Function1 r10, Function0 r11, ClosedFloatingPointRange r12, int r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = null;
    L5:
        Function0 r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = RangesKt.rangeTo(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f);
    L8:
        ClosedFloatingPointRange r5 = r12;
        if ((r14 & 32) == 0) goto L11;
        int r6 = 0;
    L13:
        return sliderSemantics(r7, r8, r9, r10, r4, r5, r6);
    L11:
        r6 = r13;
        goto L13
    }

    private static final Modifier sliderTapModifier(Modifier r11, final DraggableState r12, final MutableInteractionSource r13, final float r14, final boolean r15, final State<Float> r16, final State<? extends Function1<? super Float, Unit>> r17, final MutableState<Float> r18, final boolean r19) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(r12, r13, r14, r15, r16, r17, r18, r19);
    L7:
        return ComposedModifierKt.composed(r11, r0, new C02472(r19, r12, r13, r14, r15, r18, r16, r17));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    private static final void Track(final Modifier r19, final SliderColors r20, final boolean r21, final float r22, final float r23, final List<Float> r24, final float r25, final float r26, Composer r27, final int r28) {
        Composer r13 = r27.startRestartGroup(1833126050);
        if ((r28 & 6) == 0) goto L5;
        int r4 = r28;
    L11:
        if ((r28 & 48) != 0) goto L18;
        if (r13.changed(r20) == false) goto L15;
        int r5 = 32;
    L16:
        r4 = r4 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r28 & 384) != 0) goto L25;
        if (r13.changed(r21) == false) goto L22;
        int r6 = 256;
    L23:
        r4 = r4 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r28 & 3072) != 0) goto L32;
        if (r13.changed(r22) == false) goto L29;
        int r7 = 2048;
    L30:
        r4 = r4 | r7;
        goto L32
    L29:
        r7 = 1024;
    L32:
        if ((r28 & 24576) != 0) goto L39;
        if (r13.changed(r23) == false) goto L36;
        int r8 = 16384;
    L37:
        r4 = r4 | r8;
        goto L39
    L36:
        r8 = 8192;
    L39:
        if ((196608 & r28) != 0) goto L46;
        if (r13.changedInstance(r24) == false) goto L43;
        int r9 = 131072;
    L44:
        r4 = r4 | r9;
        goto L46
    L43:
        r9 = 65536;
    L46:
        if ((1572864 & r28) != 0) goto L53;
        if (r13.changed(r25) == false) goto L50;
        int r10 = 1048576;
    L51:
        r4 = r4 | r10;
        goto L53
    L50:
        r10 = 524288;
    L53:
        if ((12582912 & r28) != 0) goto L61;
        if (r13.changed(r26) == false) goto L57;
        int r16 = 8388608;
    L58:
        r4 = r4 | r16;
        goto L61
    L57:
        r16 = 4194304;
    L61:
        if ((r4 & 4793491) == 4793490) goto L63;
        boolean r11 = true;
    L65:
        if (r13.shouldExecute(r11, r4 & 1) == true) goto L67;
        Composer r3 = r13;
        r3.skipToGroupEnd();
    L96:
        ScopeUpdateScope r12 = r3.endRestartGroup();
        if (r12 == null) goto L100;
        r12.updateScope(new o9(r19, r20, r21, r22, r23, r24, r25, r26, r28));
        return;
    L100:
        return;
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventStart(1833126050, r4, -1, "androidx.compose.material.Track (Slider.kt:833)");
    L69:
        int r0 = (((r4 >> 6) & 14) | 48) | ((r4 << 3) & 896);
        final State<Color> r14 = r20.trackColor(r21, false, r13, r0);
        final State<Color> r15 = r20.trackColor(r21, true, r13, r0);
        final State<Color> r17 = r20.tickColor(r21, false, r13, r0);
        final State<Color> r1 = r20.tickColor(r21, true, r13, r0);
        if ((r4 & 3670016) != 1048576) goto L72;
        boolean r18 = true;
    L73:
        boolean r29 = r18 | r13.changed(r14);
        if ((29360128 & r4) != 8388608) goto L76;
        boolean r2 = true;
    L77:
        boolean r30 = r2 | r29;
        if ((57344 & r4) != 16384) goto L80;
        boolean r31 = true;
    L81:
        boolean r32 = r30 | r31;
        if ((r4 & 7168) != 2048) goto L84;
        boolean r33 = true;
    L85:
        boolean r34 = ((((r32 | r33) | r13.changed(r15)) | r13.changedInstance(r24)) | r13.changed(r17)) | r13.changed(r1);
        Object r35 = r13.rememberedValue();
        if (r34 == false) goto L88;
    L91:
        r3 = r13;
        Function1 r36 = new n9(r25, r14, r26, r23, r22, r15, r24, r17, r1);
        r3.updateRememberedValue(r36);
        r35 = r36;
    L92:
        CanvasKt.Canvas(r19, (Function1) r35, r3, r4 & 14);
        if (ComposerKt.isTraceInProgress() == false) goto L96;
        ComposerKt.traceEventEnd();
        goto L96
    L88:
        if (r35 == Composer.Companion.getEmpty()) goto L91;
        r3 = r13;
        goto L92
    L84:
        r33 = false;
        goto L85
    L80:
        r31 = false;
        goto L81
    L76:
        r2 = false;
        goto L77
    L72:
        r18 = false;
        goto L73
    L63:
        r11 = false;
        goto L65
    L5:
        if (r13.changed(r19) == false) goto L7;
        int r37 = 4;
    L8:
        r4 = r37 | r28;
        goto L11
    L7:
        r37 = 2;
        goto L8
    }

    private static final Unit Track$lambda$28$lambda$27(float r32, State r33, float r34, float r35, float r36, State r37, List r38, State r39, State r40, DrawScope r41) {
        if (r41.getLayoutDirection() != LayoutDirection.Rtl) goto L5;
        boolean r0 = true;
    L6:
        long r6 = 4294967295L;
        float r1 = Float.intBitsToFloat((int) (r41.getCenter-F1C5BW0() & 4294967295L));
        long r4 = Offset.constructor-impl((Float.floatToRawIntBits(r32) << 32) | (((long) Float.floatToRawIntBits(r1)) & 4294967295L));
        float r8 = Float.intBitsToFloat((int) (r41.getSize-NH-jbRc() >> 32)) - r32;
        float r9 = Float.intBitsToFloat((int) (r41.getCenter-F1C5BW0() & 4294967295L));
        long r10 = Float.floatToRawIntBits(r8);
        long r11 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r9)) & 4294967295L) | (r10 << 32));
        if (r0 == false) goto L9;
        long r12 = r11;
    L10:
        if (r0 == true) goto L13;
        r4 = r11;
    L13:
        long r13 = ((Color) r33.getValue()).unbox-impl();
        StrokeCap.Companion r2 = StrokeCap.Companion;
        long r310 = r12;
        DrawScope.-CC.drawLine-NGM6Ib0$default(r41, r13, r310, r4, r34, r2.getRound-KaPHkGw(), null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        int r14 = (int) (r310 >> 32);
        int r15 = (int) (r4 >> 32);
        float r16 = Float.intBitsToFloat(r14) + ((Float.intBitsToFloat(r15) - Float.intBitsToFloat(r14)) * r35);
        float r17 = Float.intBitsToFloat((int) (r41.getCenter-F1C5BW0() & 4294967295L));
        long r18 = Float.floatToRawIntBits(r16);
        long r22 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r17)) & 4294967295L) | (r18 << 32));
        float r3 = Float.intBitsToFloat(r14) + ((Float.intBitsToFloat(r15) - Float.intBitsToFloat(r14)) * r36);
        float r5 = Float.intBitsToFloat((int) (r41.getCenter-F1C5BW0() & 4294967295L));
        long r19 = Float.floatToRawIntBits(r3);
        DrawScope.-CC.drawLine-NGM6Ib0$default(r41, ((Color) r37.getValue()).unbox-impl(), Offset.constructor-impl((((long) Float.floatToRawIntBits(r5)) & 4294967295L) | (r19 << 32)), r22, r34, r2.getRound-KaPHkGw(), null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r20 = r38.iterator();
    L15:
        if (r20.hasNext() == false) goto L27;
        Object r21 = r20.next();
        float r110 = ((Number) r21).floatValue();
        if (r110 <= r35) goto L19;
    L22:
        boolean r111 = true;
    L23:
        Boolean r112 = Boolean.valueOf(r111);
        Object r113 = r7.get(r112);
        if (r113 != null) goto L26;
        r113 = new ArrayList();
        r7.put(r112, r113);
    L26:
        ((List) r113).add(r21);
        goto L15
    L19:
        if (r110 < r36) goto L22;
        r111 = false;
        goto L23
    L27:
        Iterator r23 = r7.entrySet().iterator();
    L29:
        if (r23.hasNext() == false) goto L39;
        Map.Entry r24 = (Map.Entry) r23.next();
        boolean r25 = ((Boolean) r24.getKey()).booleanValue();
        List r26 = (List) r24.getValue();
        ArrayList r114 = new ArrayList(r26.size());
        int r115 = r26.size();
        int r116 = 0;
    L31:
        if (r116 >= r115) goto L33;
        float r117 = Float.intBitsToFloat((int) (OffsetKt.lerp-Wko1d7g(r310, r4, ((Number) ListProtector.get(r26, r116)).floatValue()) >> 32));
        float r118 = Float.intBitsToFloat((int) (r41.getCenter-F1C5BW0() & r6));
        r114.add(Offset.box-impl(Offset.constructor-impl((Float.floatToRawIntBits(r117) << 32) | (((long) Float.floatToRawIntBits(r118)) & 4294967295L))));
        r116 = r116 + 1;
        r6 = 4294967295L;
        goto L31
    L33:
        long r30 = r6;
        int r119 = PointMode.Companion.getPoints-r_lszbg();
        if (r25 == false) goto L36;
        State r27 = r39;
    L37:
        DrawScope.-CC.drawPoints-F8ZwMP8$default(r41, r114, r119, ((Color) r27.getValue()).unbox-impl(), r34, StrokeCap.Companion.getRound-KaPHkGw(), null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        r6 = r30;
        goto L29
    L36:
        r27 = r40;
        goto L37
    L39:
        return Unit.INSTANCE;
    L9:
        r12 = r4;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static final void RangeSlider(final ClosedFloatingPointRange<Float> r39, final Function1<? super ClosedFloatingPointRange<Float>, Unit> r40, Modifier r41, boolean r42, ClosedFloatingPointRange<Float> r43, int r44, Function0<Unit> r45, SliderColors r46, Composer r47, final int r48, final int r49) {
        Composer r1 = r47.startRestartGroup(-1556183027);
        if ((r49 & 1) == 0) goto L6;
        int r6 = r48 | 6;
    L14:
        if ((r49 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L23:
        int r7 = r49 & 4;
        if (r7 == 0) goto L27;
        r6 = r6 | 384;
    L33:
        Modifier r8 = r41;
    L34:
        int r11 = r49 & 8;
        if (r11 == 0) goto L38;
        r6 = r6 | 3072;
    L44:
        boolean r12 = r42;
    L46:
        if ((r48 & 24576) == 0) goto L48;
        ClosedFloatingPointRange<Float> r13 = r43;
    L56:
        int r14 = r49 & 32;
        if (r14 == 0) goto L60;
        r6 = r6 | 196608;
    L66:
        int r16 = r49 & 64;
        if (r16 == 0) goto L69;
        r6 = r6 | 1572864;
        Function0<Unit> r5 = r45;
    L77:
        if ((r48 & 12582912) == 0) goto L79;
        SliderColors r4 = r46;
    L87:
        boolean r36 = false;
        if ((r6 & 4793491) == 4793490) goto L90;
        boolean r0 = true;
    L92:
        if (r1.shouldExecute(r0, r6 & 1) == false) goto L151;
        r1.startDefaults();
        if ((r48 & 1) != 0) goto L96;
    L105:
        if (r7 == 0) goto L107;
        r8 = Modifier.Companion;
    L107:
        if (r11 == 0) goto L109;
        boolean r2 = true;
    L111:
        if ((r49 & 16) == 0) goto L113;
        ClosedFloatingPointRange<Float> r9 = RangesKt.rangeTo(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f);
        r6 = r6 & (-57345);
    L114:
        if (r14 == 0) goto L116;
        int r37 = 0;
    L117:
        if (r16 == 0) goto L120;
        r5 = null;
    L120:
        if ((r49 & 128) == 0) goto L122;
        int r10 = 131072;
        boolean r3 = true;
        int r15 = r6 & (-29360129);
        SliderColors r17 = SliderDefaults.INSTANCE.m2149colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r1, 0, 6, 1023);
    L123:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventStart(-1556183027, r15, -1, "androidx.compose.material.RangeSlider (Slider.kt:404)");
    L126:
        Object r18 = r1.rememberedValue();
        Composer.Companion r19 = Composer.Companion;
        if (r18 != r19.getEmpty()) goto L129;
        r18 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r18);
    L129:
        MutableInteractionSource r110 = (MutableInteractionSource) r18;
        Object r111 = r1.rememberedValue();
        if (r111 != r19.getEmpty()) goto L132;
        r111 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r111);
    L132:
        MutableInteractionSource r112 = (MutableInteractionSource) r111;
        if (r37 < 0) goto L135;
        boolean r113 = true;
    L136:
        if (r113 == false) goto L150;
        State r114 = SnapshotStateKt.rememberUpdatedState(r40, r1, (r15 >> 3) & 14);
        if ((r15 & 458752) != r10) goto L140;
        r36 = true;
    L140:
        Object r20 = r1.rememberedValue();
        if (r36 == false) goto L143;
    L144:
        r20 = stepsToTickFractions(r37);
        r1.updateRememberedValue(r20);
    L145:
        List r115 = (List) r20;
        Modifier r21 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(r8);
        float r116 = ThumbRadius;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.m1010requiredSizeInqDBjuR0$default(r21, Dp.constructor-impl(4 * r116), Dp.constructor-impl(r116 * 2), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 12, null), null, false, ComposableLambdaKt.rememberComposableLambda(652589923, r3, new AnonymousClass2(r9, r39, r115, r5, r114, r110, r112, r2, r37, r17), r1, 54), r1, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
    L148:
        final boolean r22 = r2;
        final Modifier r23 = r8;
        final SliderColors r24 = r17;
        final int r25 = r37;
        ClosedFloatingPointRange<Float> r38 = r9;
        final Function0<Unit> r26 = r5;
        final ClosedFloatingPointRange<Float> r27 = r38;
    L152:
        ScopeUpdateScope r117 = r1.endRestartGroup();
        if (r117 == null) goto L156;
        r117.updateScope(new i9(r39, r40, r23, r22, r27, r25, r26, r24, r48, r49));
        return;
    L156:
        return;
    L143:
        if (r20 != r19.getEmpty()) goto L145;
    L150:
        throw new IllegalArgumentException("steps should be >= 0".toString());
    L135:
        r113 = false;
        goto L136
    L122:
        r3 = true;
        r10 = 131072;
        r15 = r6;
        r17 = r46;
        goto L123
    L116:
        r37 = r44;
        goto L117
    L113:
        r9 = r13;
        goto L114
    L109:
        r2 = r12;
        goto L111
    L96:
        if (r1.getDefaultsInvalid() == true) goto L105;
        r1.skipToGroupEnd();
        if ((r49 & 16) == 0) goto L102;
        r6 = r6 & (-57345);
    L102:
        if ((r49 & 128) == 0) goto L104;
        r6 = r6 & (-29360129);
    L104:
        r37 = r44;
        r15 = r6;
        r2 = r12;
        r9 = r13;
        r3 = true;
        r17 = r4;
        r10 = 131072;
        goto L123
    L151:
        r1.skipToGroupEnd();
        r25 = r44;
        r26 = r5;
        r23 = r8;
        r22 = r12;
        r27 = r13;
        r24 = r46;
        goto L152
    L90:
        r0 = false;
        goto L92
    L79:
        if ((r49 & 128) != 0) goto L83;
        r4 = r46;
        if (r1.changed(r4) == false) goto L84;
        int r118 = 8388608;
    L85:
        r6 = r6 | r118;
    L84:
        r118 = 4194304;
        goto L85
    L83:
        r4 = r46;
        goto L84
    L69:
        r5 = r45;
        if ((r48 & 1572864) != 0) goto L77;
        if (r1.changedInstance(r5) == false) goto L74;
        int r119 = 1048576;
    L75:
        r6 = r6 | r119;
        goto L77
    L74:
        r119 = 524288;
        goto L75
    L60:
        if ((r48 & 196608) != 0) goto L66;
        if (r1.changed(r44) == false) goto L64;
        int r120 = 131072;
    L65:
        r6 = r6 | r120;
        goto L66
    L64:
        r120 = 65536;
        goto L65
    L48:
        if ((r49 & 16) != 0) goto L52;
        r13 = r43;
        if (r1.changed(r13) == false) goto L53;
        int r121 = 16384;
    L54:
        r6 = r6 | r121;
    L53:
        r121 = 8192;
        goto L54
    L52:
        r13 = r43;
        goto L53
    L38:
        if ((r48 & 3072) != 0) goto L44;
        r12 = r42;
        if (r1.changed(r12) == false) goto L42;
        int r122 = 2048;
    L43:
        r6 = r6 | r122;
        goto L46
    L42:
        r122 = 1024;
        goto L43
    L27:
        if ((r48 & 384) != 0) goto L33;
        r8 = r41;
        if (r1.changed(r8) == false) goto L31;
        int r123 = 256;
    L32:
        r6 = r6 | r123;
        goto L34
    L31:
        r123 = 128;
        goto L32
    L17:
        if ((r48 & 48) != 0) goto L23;
        if (r1.changedInstance(r40) == false) goto L21;
        int r28 = 32;
    L22:
        r6 = r6 | r28;
        goto L23
    L21:
        r28 = 16;
        goto L22
    L6:
        if ((r48 & 6) == 0) goto L8;
        r6 = r48;
        goto L14
    L8:
        if (r1.changed(r39) == false) goto L10;
        int r29 = 4;
    L11:
        r6 = r29 | r48;
        goto L14
    L10:
        r29 = 2;
        goto L11
    }

    public static final /* synthetic */ Modifier access$rangeSliderPressDragModifier(Modifier r0, MutableInteractionSource r1, MutableInteractionSource r2, State r3, State r4, boolean r5, boolean r6, float r7, ClosedFloatingPointRange r8, State r9, State r10) {
        return rangeSliderPressDragModifier(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier r11, final MutableInteractionSource r12, final MutableInteractionSource r13, final State<Float> r14, final State<Float> r15, boolean r16, final boolean r17, final float r18, ClosedFloatingPointRange<Float> r19, final State<? extends Function1<? super Boolean, Unit>> r20, final State<? extends Function2<? super Boolean, ? super Float, Unit>> r21) {
        if (r16 == false) goto L5;
        return SuspendingPointerInputFilterKt.pointerInput(r11, new Object[]{r12, r13, Float.valueOf(r18), Boolean.valueOf(r17), r19}, new AnonymousClass1(r12, r13, r14, r15, r21, r17, r18, r20));
    L5:
        return r11;
    }

    public static final void Slider(final float r40, final Function1<? super Float, Unit> r41, Modifier r42, boolean r43, ClosedFloatingPointRange<Float> r44, int r45, Function0<Unit> r46, MutableInteractionSource r47, SliderColors r48, Composer r49, final int r50, final int r51) {
        Composer r1 = r49.startRestartGroup(-1962335196);
        if ((r51 & 1) == 0) goto L6;
        int r5 = r50 | 6;
    L14:
        if ((r51 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L23:
        int r6 = r51 & 4;
        if (r6 == 0) goto L27;
        r5 = r5 | 384;
    L33:
        Modifier r7 = r42;
    L34:
        int r8 = r51 & 8;
        if (r8 == 0) goto L38;
        r5 = r5 | 3072;
    L44:
        boolean r9 = r43;
    L46:
        if ((r50 & 24576) == 0) goto L48;
        ClosedFloatingPointRange<Float> r12 = r44;
    L56:
        int r13 = r51 & 32;
        if (r13 == 0) goto L60;
        r5 = r5 | 196608;
    L66:
        int r14 = r45;
    L67:
        int r16 = r51 & 64;
        if (r16 == 0) goto L71;
        r5 = r5 | 1572864;
    L77:
        int r4 = r51 & 128;
        if (r4 == 0) goto L81;
        r5 = r5 | 12582912;
    L88:
        if ((r50 & 100663296) != 0) goto L98;
        if ((r51 & 256) != 0) goto L95;
        if (r1.changed(r48) == false) goto L95;
        int r17 = 67108864;
    L96:
        r5 = r5 | r17;
    L95:
        r17 = 33554432;
    L98:
        boolean r37 = false;
        if ((r5 & 38347923) == 38347922) goto L101;
        boolean r0 = true;
    L103:
        if (r1.shouldExecute(r0, r5 & 1) == false) goto L170;
        r1.startDefaults();
        if ((r50 & 1) != 0) goto L107;
    L117:
        if (r6 == 0) goto L119;
        r7 = Modifier.Companion;
    L119:
        if (r8 == 0) goto L122;
        r9 = true;
    L122:
        if ((r51 & 16) == 0) goto L124;
        ClosedFloatingPointRange<Float> r2 = RangesKt.rangeTo(androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1.0f);
        r5 = r5 & (-57345);
    L125:
        if (r13 == 0) goto L127;
        final int r10 = 0;
    L128:
        final MutableInteractionSource r11 = null;
        if (r16 == 0) goto L131;
        Function0<Unit> r38 = null;
    L132:
        if (r4 != 0) goto L136;
        r11 = r47;
    L136:
        if ((r51 & 256) == 0) goto L138;
        int r15 = 131072;
        Function0<Unit> r3 = r38;
        int r18 = r5 & (-234881025);
        SliderColors r19 = SliderDefaults.INSTANCE.m2149colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r1, 0, 6, 1023);
    L139:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L142;
        ComposerKt.traceEventStart(-1962335196, r18, -1, "androidx.compose.material.Slider (Slider.kt:164)");
    L142:
        if (r11 != null) goto L147;
        r1.startReplaceGroup(-1127477833);
        Object r110 = r1.rememberedValue();
        if (r110 != Composer.Companion.getEmpty()) goto L146;
        r110 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r110);
    L146:
        r1.endReplaceGroup();
        MutableInteractionSource r111 = (MutableInteractionSource) r110;
    L148:
        if (r10 < 0) goto L150;
        boolean r112 = true;
    L151:
        if (r112 == false) goto L169;
        State r20 = SnapshotStateKt.rememberUpdatedState(r41, r1, (r18 >> 3) & 14);
        State r113 = SnapshotStateKt.rememberUpdatedState(r3, r1, (r18 >> 18) & 14);
        if ((r18 & 458752) != r15) goto L155;
        boolean r21 = true;
    L156:
        Object r114 = r1.rememberedValue();
        if (r21 == false) goto L159;
    L160:
        r114 = stepsToTickFractions(r10);
        r1.updateRememberedValue(r114);
    L161:
        List r22 = (List) r114;
        Modifier r115 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(r7);
        float r116 = ThumbRadius;
        float r23 = 2;
        Modifier r24 = FocusableKt.focusable(sliderSemantics(SizeKt.m1010requiredSizeInqDBjuR0$default(r115, Dp.constructor-impl(r116 * r23), Dp.constructor-impl(r116 * r23), androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 12, null), r40, r9, r41, r3, r2, r10), r9, r111);
        if (r1.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L164;
        r37 = true;
    L164:
        ClosedFloatingPointRange<Float> r410 = r2;
        BoxWithConstraintsKt.BoxWithConstraints(slideOnKeyEvents(r24, r9, r10, r2, r40, r37, r20, r113), null, false, ComposableLambdaKt.rememberComposableLambda(2085116814, true, new C02442(r2, r40, r22, r3, r111, r9, r19, r20), r1, 54), r1, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventEnd();
    L167:
        final boolean r25 = r9;
        final SliderColors r26 = r19;
        final ClosedFloatingPointRange<Float> r27 = r410;
        Modifier r39 = r7;
        final Function0<Unit> r28 = r3;
        final Modifier r29 = r39;
    L171:
        ScopeUpdateScope r117 = r1.endRestartGroup();
        if (r117 == null) goto L175;
        r117.updateScope(new u9(r40, r41, r29, r25, r27, r10, r28, r11, r26, r50, r51));
        return;
    L175:
        return;
    L159:
        if (r114 != Composer.Companion.getEmpty()) goto L161;
    L155:
        r21 = false;
        goto L156
    L169:
        throw new IllegalArgumentException("steps should be >= 0".toString());
    L150:
        r112 = false;
        goto L151
    L147:
        r1.startReplaceGroup(-313465568);
        r1.endReplaceGroup();
        r111 = r11;
        goto L148
    L138:
        r15 = 131072;
        r18 = r5;
        r3 = r38;
    L116:
        r19 = r48;
        goto L139
    L131:
        r38 = r46;
        goto L132
    L127:
        r10 = r14;
        goto L128
    L124:
        r2 = r12;
        goto L125
    L107:
        if (r1.getDefaultsInvalid() == true) goto L117;
        r1.skipToGroupEnd();
        if ((r51 & 16) == 0) goto L113;
        r5 = r5 & (-57345);
    L113:
        if ((r51 & 256) == 0) goto L115;
        r5 = r5 & (-234881025);
    L115:
        r3 = r46;
        r11 = r47;
        r2 = r12;
        r10 = r14;
        r15 = 131072;
        r18 = r5;
        goto L116
    L170:
        r1.skipToGroupEnd();
        r11 = r47;
        r29 = r7;
        r25 = r9;
        r27 = r12;
        r10 = r14;
        r28 = r46;
        r26 = r48;
        goto L171
    L101:
        r0 = false;
        goto L103
    L81:
        if ((r50 & 12582912) != 0) goto L88;
        if (r1.changed(r47) == false) goto L85;
        int r118 = 8388608;
    L86:
        r5 = r5 | r118;
        goto L88
    L85:
        r118 = 4194304;
        goto L86
    L71:
        if ((r50 & 1572864) != 0) goto L77;
        if (r1.changedInstance(r46) == false) goto L75;
        int r119 = 1048576;
    L76:
        r5 = r5 | r119;
        goto L77
    L75:
        r119 = 524288;
        goto L76
    L60:
        if ((196608 & r50) != 0) goto L66;
        r14 = r45;
        if (r1.changed(r14) == false) goto L64;
        int r120 = 131072;
    L65:
        r5 = r5 | r120;
        goto L67
    L64:
        r120 = 65536;
        goto L65
    L48:
        if ((r51 & 16) != 0) goto L52;
        r12 = r44;
        if (r1.changed(r12) == false) goto L53;
        int r121 = 16384;
    L54:
        r5 = r5 | r121;
    L53:
        r121 = 8192;
        goto L54
    L52:
        r12 = r44;
        goto L53
    L38:
        if ((r50 & 3072) != 0) goto L44;
        r9 = r43;
        if (r1.changed(r9) == false) goto L42;
        int r122 = 2048;
    L43:
        r5 = r5 | r122;
        goto L46
    L42:
        r122 = 1024;
        goto L43
    L27:
        if ((r50 & 384) != 0) goto L33;
        r7 = r42;
        if (r1.changed(r7) == false) goto L31;
        int r30 = 256;
    L32:
        r5 = r5 | r30;
        goto L34
    L31:
        r30 = 128;
        goto L32
    L17:
        if ((r50 & 48) != 0) goto L23;
        if (r1.changedInstance(r41) == false) goto L21;
        int r31 = 32;
    L22:
        r5 = r5 | r31;
        goto L23
    L21:
        r31 = 16;
        goto L22
    L6:
        if ((r50 & 6) == 0) goto L8;
        r5 = r50;
        goto L14
    L8:
        if (r1.changed(r40) == false) goto L10;
        int r32 = 4;
    L11:
        r5 = r32 | r50;
        goto L14
    L10:
        r32 = 2;
        goto L11
    }

    private static final void RangeSliderImpl(final boolean r28, final float r29, final float r30, final List<Float> r31, final SliderColors r32, final float r33, final MutableInteractionSource r34, final MutableInteractionSource r35, final Modifier r36, final Modifier r37, final Modifier r38, Composer r39, final int r40, final int r41) {
        Composer r6 = r39.startRestartGroup(-278895713);
        if ((r40 & 6) == 0) goto L5;
        int r1 = r40;
    L11:
        if ((r40 & 48) != 0) goto L18;
        if (r6.changed(r29) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r40 & 384) != 0) goto L25;
        if (r6.changed(r30) == false) goto L22;
        int r5 = 256;
    L23:
        r1 = r1 | r5;
        goto L25
    L22:
        r5 = 128;
    L25:
        if ((r40 & 3072) != 0) goto L33;
        if (r6.changedInstance(r31) == false) goto L29;
        int r16 = 2048;
    L30:
        r1 = r1 | r16;
        goto L33
    L29:
        r16 = 1024;
    L33:
        if ((r40 & 24576) != 0) goto L41;
        if (r6.changed(r32) == false) goto L37;
        int r17 = 16384;
    L38:
        r1 = r1 | r17;
        goto L41
    L37:
        r17 = 8192;
    L41:
        if ((r40 & 196608) != 0) goto L48;
        if (r6.changed(r33) == false) goto L45;
        int r18 = 131072;
    L46:
        r1 = r1 | r18;
        goto L48
    L45:
        r18 = 65536;
    L48:
        if ((r40 & 1572864) != 0) goto L55;
        if (r6.changed(r34) == false) goto L52;
        int r19 = 1048576;
    L53:
        r1 = r1 | r19;
        goto L55
    L52:
        r19 = 524288;
    L55:
        if ((r40 & 12582912) != 0) goto L62;
        if (r6.changed(r35) == false) goto L59;
        int r110 = 8388608;
    L60:
        r1 = r1 | r110;
        goto L62
    L59:
        r110 = 4194304;
    L62:
        if ((r40 & 100663296) != 0) goto L69;
        if (r6.changed(r36) == false) goto L66;
        int r111 = 67108864;
    L67:
        r1 = r1 | r111;
        goto L69
    L66:
        r111 = 33554432;
    L69:
        if ((r40 & 805306368) != 0) goto L76;
        if (r6.changed(r37) == false) goto L73;
        int r112 = 536870912;
    L74:
        r1 = r1 | r112;
        goto L76
    L73:
        r112 = 268435456;
    L76:
        if ((r41 & 6) == 0) goto L78;
        int r0 = r41;
    L84:
        if ((r1 & 306783379) == 306783378) goto L86;
    L89:
        boolean r2 = true;
    L91:
        if (r6.shouldExecute(r2, r1 & 1) == true) goto L93;
        Composer r9 = r6;
        r9.skipToGroupEnd();
    L121:
        ScopeUpdateScope r15 = r9.endRestartGroup();
        if (r15 == null) goto L125;
        r15.updateScope(new l9(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r41));
        return;
    L125:
        return;
    L93:
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventStart(-278895713, r1, r0, "androidx.compose.material.RangeSliderImpl (Slider.kt:724)");
    L95:
        Strings.Companion r3 = Strings.Companion;
        final String r7 = Strings_androidKt.m2174getString4foXLRw(r3.m2172getSliderRangeStartUdPEhr4(), r6, 6);
        final String r8 = Strings_androidKt.m2174getString4foXLRw(r3.m2171getSliderRangeEndUdPEhr4(), r6, 6);
        Modifier r10 = r36.then(DefaultSliderConstraints);
        Alignment.Companion r113 = Alignment.Companion;
        MeasurePolicy r11 = BoxKt.maybeCachedBoxMeasurePolicy(r113.getTopStart(), false);
        int r12 = ComposablesKt.getCurrentCompositeKeyHash(r6, 0);
        CompositionLocalMap r13 = r6.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r6, r10);
        ComposeUiNode.Companion r20 = ComposeUiNode.Companion;
        Function0 r21 = r20.getConstructor();
        if ((r6.getApplier() instanceof Applier) == true) goto L98;
        ComposablesKt.invalidApplier();
    L98:
        r6.startReusableNode();
        if (r6.getInserting() == false) goto L101;
        r6.createNode(r21);
    L102:
        Composer r22 = Updater.constructor-impl(r6);
        Updater.set-impl(r22, r11, r20.getSetMeasurePolicy());
        Updater.set-impl(r22, r13, r20.getSetResolvedCompositionLocals());
        Function2 r23 = r20.getSetCompositeKeyHash();
        if (r22.getInserting() == false) goto L105;
    L106:
        r22.updateRememberedValue(Integer.valueOf(r12));
        r22.apply(Integer.valueOf(r12), r23);
    L107:
        Updater.set-impl(r22, r14, r20.getSetModifier());
        BoxScopeInstance r24 = BoxScopeInstance.INSTANCE;
        Density r25 = (Density) r6.consume(CompositionLocalsKt.getLocalDensity());
        float r26 = r25.toPx-0680j_4(TrackHeight);
        float r27 = ThumbRadius;
        float r210 = r25.toPx-0680j_4(r27);
        float r42 = r25.toDp-u2uoSUM(r33);
        float r211 = Dp.constructor-impl(r27 * 2);
        float r212 = Dp.constructor-impl(r42 * r29);
        float r213 = Dp.constructor-impl(r42 * r30);
        Modifier.Companion r43 = Modifier.Companion;
        int r44 = r1 >> 9;
        int r45 = r1 << 6;
        int r310 = r1;
        Track(SizeKt.fillMaxSize$default(r24.align(r43, r113.getCenterStart()), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), r32, r28, r29, r30, r31, r210, r26, r6, ((((r45 & 896) | (r44 & 112)) | (r45 & 7168)) | (r45 & 57344)) | (r45 & 458752));
        r9 = r6;
        boolean r46 = r9.changed(r7);
        Object r47 = r9.rememberedValue();
        if (r46 == false) goto L110;
    L111:
        r47 = new j9(r7);
        r9.updateRememberedValue(r47);
    L112:
        int r114 = r310 & 57344;
        int r115 = (r310 << 15) & 458752;
        m2150SliderThumbPcYyNuk(r24, FocusableKt.focusable(SemanticsModifierKt.semantics(r43, true, (Function1) r47), true, r34).then(r37), r212, r34, r32, r28, r211, r9, (((r44 & 7168) | 1572870) | r114) | r115);
        boolean r48 = r9.changed(r8);
        Object r49 = r9.rememberedValue();
        if (r48 == false) goto L115;
    L116:
        r49 = new k9(r8);
        r9.updateRememberedValue(r49);
    L117:
        m2150SliderThumbPcYyNuk(r24, FocusableKt.focusable(SemanticsModifierKt.semantics(r43, true, (Function1) r49), true, r35).then(r38), r213, r35, r32, r28, r211, r9, ((((r310 >> 12) & 7168) | 1572870) | r114) | r115);
        r9.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L121;
        ComposerKt.traceEventEnd();
        goto L121
    L115:
        if (r49 != Composer.Companion.getEmpty()) goto L117;
    L110:
        if (r47 != Composer.Companion.getEmpty()) goto L112;
    L105:
        if (Intrinsics.areEqual(r22.rememberedValue(), Integer.valueOf(r12)) == true) goto L107;
    L101:
        r6.useNode();
        goto L102
    L86:
        if ((r0 & 3) != 2) goto L89;
        r2 = false;
        goto L91
    L78:
        if (r6.changed(r38) == false) goto L80;
        int r116 = 4;
    L81:
        r0 = r41 | r116;
        goto L84
    L80:
        r116 = 2;
        goto L81
    L5:
        if (r6.changed(r28) == false) goto L7;
        int r50 = 4;
    L8:
        r1 = r50 | r40;
        goto L11
    L7:
        r50 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$RangeSliderImpl(boolean r0, float r1, float r2, List r3, SliderColors r4, float r5, MutableInteractionSource r6, MutableInteractionSource r7, Modifier r8, Modifier r9, Modifier r10, Composer r11, int r12, int r13) {
        RangeSliderImpl(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }
}
