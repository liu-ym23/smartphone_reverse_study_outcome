package androidx.compose.animation.core;

import androidx.autofill.HintConstants;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B1\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB#\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0010\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\fB#\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u000eJ\b\u0010T\u001a\u00020'H\u0002J\u001d\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020YH\u0000¢\u0006\u0002\bZJ\u001d\u0010U\u001a\u00020V2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020%H\u0000¢\u0006\u0002\bZJ\u0015\u0010]\u001a\u00020V2\u0006\u0010W\u001a\u00020'H\u0000¢\u0006\u0002\b^J\r\u0010_\u001a\u00020VH\u0000¢\u0006\u0002\b`J\r\u0010a\u001a\u00020VH\u0000¢\u0006\u0002\bbJ'\u0010c\u001a\u00020V2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u00100\u001a\u00020'H\u0007¢\u0006\u0004\bd\u0010eJ\u0019\u0010f\u001a\u00020%2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bhJ\u0019\u0010i\u001a\u00020%2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bjJ'\u0010k\u001a\u00020%2\u0018\u0010l\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bmJ'\u0010n\u001a\u00020V2\u0018\u0010l\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001a\u00020V2\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\bq\u0010\u001aJ\u0017\u0010r\u001a\u00020V2\u0006\u0010\u0017\u001a\u00028\u0000H\u0001¢\u0006\u0004\bs\u0010tJ\u0015\u0010u\u001a\u00020V2\u0006\u00100\u001a\u00020'H\u0000¢\u0006\u0002\bvJ\u0015\u0010w\u001a\u00020V2\u0006\u0010x\u001a\u00020yH\u0000¢\u0006\u0002\bzJ\u0015\u0010{\u001a\u00020V2\u0006\u0010|\u001a\u00020YH\u0000¢\u0006\u0002\b}J\r\u0010~\u001a\u00020VH\u0000¢\u0006\u0002\b\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020VH\u0000¢\u0006\u0003\b\u0081\u0001J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0083\u0001\u001a\u00020VH\u0002J)\u0010n\u001a\u00020V2\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0085\u0001R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00008G¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R+\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR7\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b$\u0010&R+\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00100\u001a\u00020'2\u0006\u0010/\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R+\u00103\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010.\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R+\u00107\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\u001c\u001a\u0004\b8\u0010&\"\u0004\b9\u0010:R&\u0010<\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u00000=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000=X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000A8F¢\u0006\u0006\u001a\u0004\bB\u0010CR)\u0010D\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u00000A8F¢\u0006\u0006\u001a\u0004\bE\u0010CR+\u0010F\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8G@AX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u001c\u001a\u0004\bF\u0010&\"\u0004\bG\u0010:R\u001a\u0010I\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010,R\u001a\u0010L\u001a\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010&R\u001b\u0010P\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bQ\u0010*¨\u0006\u008a\u0001²\u0006\u000b\u0010\u008b\u0001\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/animation/core/Transition;", "S", "", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "parentTransition", "label", "", "<init>", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "getParentTransition", "()Landroidx/compose/animation/core/Transition;", "getLabel", "()Ljava/lang/String;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "<set-?>", "targetState", "getTargetState", "setTargetState$animation_core", "(Ljava/lang/Object;)V", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/Transition$Segment;", "segment", "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "isRunning", "", "()Z", "", "_playTimeNanos", "get_playTimeNanos", "()J", "set_playTimeNanos", "(J)V", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "value", "playTimeNanos", "getPlayTimeNanos", "setPlayTimeNanos", "startTimeNanos", "getStartTimeNanos$animation_core", "setStartTimeNanos$animation_core", "startTimeNanos$delegate", "updateChildrenNeeded", "getUpdateChildrenNeeded", "setUpdateChildrenNeeded", "(Z)V", "updateChildrenNeeded$delegate", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "_transitions", "transitions", "", "getTransitions", "()Ljava/util/List;", "animations", "getAnimations", "isSeeking", "setSeeking$animation_core", "isSeeking$delegate", "lastSeekedTimeNanos", "getLastSeekedTimeNanos$animation_core", "setLastSeekedTimeNanos$animation_core", "hasInitialValueAnimations", "getHasInitialValueAnimations$annotations", "()V", "getHasInitialValueAnimations", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "calculateTotalDurationNanos", "onFrame", "", "frameTimeNanos", "durationScale", "", "onFrame$animation_core", "scaledPlayTimeNanos", "scaleToEnd", "onTransitionStart", "onTransitionStart$animation_core", "onDisposed", "onDisposed$animation_core", "onTransitionEnd", "onTransitionEnd$animation_core", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "addTransition", "transition", "addTransition$animation_core", "removeTransition", "removeTransition$animation_core", "addAnimation", "animation", "addAnimation$animation_core", "removeAnimation", "removeAnimation$animation_core", "updateTarget", "updateTarget$animation_core", "animateTo", "animateTo$animation_core", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "seekAnimations", "seekAnimations$animation_core", "setInitialAnimations", "animationState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialAnimations$animation_core", "resetAnimationFraction", "fraction", "resetAnimationFraction$animation_core", "clearInitialAnimations", "clearInitialAnimations$animation_core", "updateInitialValues", "updateInitialValues$animation_core", "toString", "onChildAnimationUpdated", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "TransitionAnimationState", "SegmentImpl", "Segment", "DeferredAnimation", "animation-core", "runFrameLoop"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Transition<S> {
    public static final int $stable = 0;
    private final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;
    private final MutableLongState _playTimeNanos$delegate;
    private final SnapshotStateList<Transition<?>> _transitions;
    private final MutableState isSeeking$delegate;
    private final String label;
    private long lastSeekedTimeNanos;
    private final Transition<?> parentTransition;
    private final MutableState segment$delegate;
    private final MutableLongState startTimeNanos$delegate;
    private final MutableState targetState$delegate;
    private final State totalDurationNanos$delegate;
    private final TransitionState<S> transitionState;
    private final MutableState updateChildrenNeeded$delegate;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001'B%\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJT\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a2#\u0010\u001b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001e0\u001c¢\u0006\u0002\b\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00028\u00010\u001cJ\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR{\u0010\u0012\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0010R\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00112.\u0010\u000f\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0010R\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "state", "setupSeeking", "", "setupSeeking$animation_core", "DeferredAnimationData", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class DeferredAnimation<T, V extends AnimationVector> {
        private final MutableState data$delegate;
        private final String label;
        final /* synthetic */ Transition<S> this$0;
        private final TwoWayConverter<T, V> typeConverter;

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bm\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\nR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R7\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001e\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "animation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "state", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "setTransitionSpec", "(Lkotlin/jvm/functions/Function1;)V", "getTargetValueByState", "setTargetValueByState", "updateAnimationStates", "", "segment", "value", "getValue", "()Ljava/lang/Object;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            private final Transition<S>.TransitionAnimationState<T, V> animation;
            private Function1<? super S, ? extends T> targetValueByState;
            final /* synthetic */ Transition<S>.DeferredAnimation<T, V> this$0;
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public T getValue() {
                updateAnimationStates(this.this$0.this$0.getSegment());
                return this.animation.getValue();
            }

            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            public final Function1<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            public final void setTargetValueByState(Function1<? super S, ? extends T> r1) {
                this.targetValueByState = r1;
            }

            public final void setTransitionSpec(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> r1) {
                this.transitionSpec = r1;
            }

            public final void updateAnimationStates(Segment<S> r5) {
                Object r0 = this.targetValueByState.invoke(r5.getTargetState());
                if (this.this$0.this$0.isSeeking() == false) goto L5;
                Object r1 = this.targetValueByState.invoke(r5.getInitialState());
                this.animation.updateInitialAndTargetValue$animation_core((T) r1, (T) r0, (FiniteAnimationSpec) this.transitionSpec.invoke(r5));
                return;
            L5:
                this.animation.updateTargetValue$animation_core((T) r0, (FiniteAnimationSpec) this.transitionSpec.invoke(r5));
            }

            public DeferredAnimationData(DeferredAnimation r1, Transition<S>.TransitionAnimationState<T, V> r2, Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> r3, Function1<? super S, ? extends T> r4) {
                this.this$0 = r1;
                this.animation = r2;
                this.transitionSpec = r3;
                this.targetValueByState = r4;
            }
        }

        public final Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> getData$animation_core() {
            return (DeferredAnimationData) this.data$delegate.getValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void setupSeeking$animation_core() {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> r0 = getData$animation_core();
            if (r0 == null) goto L6;
            Transition<S> r1 = this.this$0;
            r0.getAnimation().updateInitialAndTargetValue$animation_core(r0.getTargetValueByState().invoke(r1.getSegment().getInitialState()), r0.getTargetValueByState().invoke(r1.getSegment().getTargetState()), (FiniteAnimationSpec) r0.getTransitionSpec().invoke(r1.getSegment()));
            return;
        }

        public final String getLabel() {
            return this.label;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final void setData$animation_core(Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> r2) {
            this.data$delegate.setValue(r2);
        }

        public final State<T> animate(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> r9, Function1<? super S, ? extends T> r10) {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> r0 = getData$animation_core();
            if (r0 != null) goto L5;
            Transition<S> r2 = this.this$0;
            r0 = new DeferredAnimationData(this, new TransitionAnimationState(r2, r10.invoke(r2.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, r10.invoke(this.this$0.getCurrentState())), this.typeConverter, this.label), r9, r10);
            Transition<S> r1 = this.this$0;
            setData$animation_core(r0);
            r1.addAnimation$animation_core(r0.getAnimation());
        L5:
            Transition<S> r3 = this.this$0;
            r0.setTargetValueByState(r10);
            r0.setTransitionSpec(r9);
            r0.updateAnimationStates(r3.getSegment());
            return r0;
        }

        public DeferredAnimation(Transition r1, TwoWayConverter<T, V> r2, String r3) {
            this.this$0 = r1;
            this.typeConverter = r2;
            this.label = r3;
            this.data$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/Transition$Segment;", "S", "", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Segment<S> {

        /* JADX INFO: renamed from: androidx.compose.animation.core.Transition$Segment$-CC, reason: invalid class name */
        public final /* synthetic */ class CC<S> {
            public static boolean $default$isTransitioningTo(Segment r1, Object r2, Object r3) {
                if (Intrinsics.areEqual(r2, r1.getInitialState()) == true) goto L5;
            L7:
                return false;
            L5:
                if (Intrinsics.areEqual(r3, r1.getTargetState()) == false) goto L7;
                return true;
            }

            public static /* synthetic */ boolean access$isTransitioningTo$jd(Segment r0, Object r1, Object r2) {
                return $default$isTransitioningTo(r0, r1, r2);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            public static <S> boolean isTransitioningTo(Segment<S> r0, S r1, S r2) {
                return CC.access$isTransitioningTo$jd(r0, r1, r2);
            }
        }

        S getInitialState();

        S getTargetState();

        boolean isTransitioningTo(S r1, S r2);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitialState", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        @Override // androidx.compose.animation.core.Transition.Segment
        public final /* synthetic */ boolean isTransitioningTo(Object r1, Object r2) {
            return Segment.CC.$default$isTransitioningTo(this, r1, r2);
        }

        public int hashCode() {
            S r0 = getInitialState();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            S r4 = getTargetState();
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getTargetState() {
            return this.targetState;
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof Segment) == false) goto L9;
            Segment r4 = (Segment) r3;
            if (Intrinsics.areEqual(getInitialState(), r4.getInitialState()) == false) goto L9;
            if (Intrinsics.areEqual(getTargetState(), r4.getTargetState()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        public SegmentImpl(S r1, S r2) {
            this.initialState = r1;
            this.targetState = r2;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B5\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020F2\u0006\u0010R\u001a\u000200H\u0000¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020P2\u0006\u0010Q\u001a\u00020FH\u0000¢\u0006\u0002\bUJ\r\u0010V\u001a\u00020PH\u0000¢\u0006\u0002\bWJ!\u0010Y\u001a\u00020P2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010Z\u001a\u000200H\u0002¢\u0006\u0002\u0010[J\r\u0010\\\u001a\u00020PH\u0000¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020P2\u0006\u0010_\u001a\u000207H\u0000¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020*H\u0000¢\u0006\u0002\bcJ\r\u0010d\u001a\u00020PH\u0000¢\u0006\u0002\beJ\b\u0010f\u001a\u00020\nH\u0016J%\u0010g\u001a\u00020P2\u0006\u0010\u0012\u001a\u00028\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bH\u0000¢\u0006\u0004\bh\u0010iJ-\u0010j\u001a\u00020P2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0012\u001a\u00028\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bH\u0000¢\u0006\u0004\bk\u0010lR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RC\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\"2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\"8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R+\u00101\u001a\u0002002\u0006\u0010\u0011\u001a\u0002008@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0018\u001a\u0004\b2\u00103\"\u0004\b4\u00105R+\u00108\u001a\u0002072\u0006\u0010\u0011\u001a\u0002078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010?\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010@\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u00018V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0018\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\u0010\u0010D\u001a\u00028\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010ER+\u0010G\u001a\u00020F2\u0006\u0010\u0011\u001a\u00020F8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010N\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "<init>", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "Landroidx/compose/runtime/MutableState;", "defaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "initialValueAnimation", "", "isFinished", "isFinished$animation_core", "()Z", "setFinished$animation_core", "(Z)V", "isFinished$delegate", "", "resetSnapValue", "getResetSnapValue$animation_core", "()F", "setResetSnapValue$animation_core", "(F)V", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "useOnlyInitialValue", "value", "getValue", "setValue$animation_core", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "", "durationNanos", "getDurationNanos$animation_core", "()J", "setDurationNanos$animation_core", "(J)V", "durationNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "isSeeking", "onPlayTimeChanged", "", "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core", "seekTo", "seekTo$animation_core", "updateInitialValue", "updateInitialValue$animation_core", "interruptionSpec", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "resetAnimation", "resetAnimation$animation_core", "resetAnimationValue", "fraction", "resetAnimationValue$animation_core", "setInitialValueAnimation", "animationState", "setInitialValueAnimation$animation_core", "clearInitialAnimation", "clearInitialAnimation$animation_core", "toString", "updateTargetValue", "updateTargetValue$animation_core", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        private final MutableState animation$delegate;
        private final MutableState animationSpec$delegate;
        private final SpringSpec<T> defaultSpring;
        private final MutableLongState durationNanos$delegate;
        private TargetBasedAnimation<T, V> initialValueAnimation;
        private SeekableTransitionState.SeekingAnimationState initialValueState;
        private final FiniteAnimationSpec<T> interruptionSpec;
        private final MutableState isFinished$delegate;
        private boolean isSeeking;
        private final String label;
        private final MutableFloatState resetSnapValue$delegate;
        private final MutableState targetValue$delegate;
        final /* synthetic */ Transition<S> this$0;
        private final TwoWayConverter<T, V> typeConverter;
        private boolean useOnlyInitialValue;
        private final MutableState value$delegate;
        private V velocityVector;

        public final void clearInitialAnimation$animation_core() {
            this.initialValueAnimation = null;
            this.initialValueState = null;
            this.useOnlyInitialValue = false;
        }

        private final T getTargetValue() {
            return (T) this.targetValue$delegate.getValue();
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        public final long getDurationNanos$animation_core() {
            return this.durationNanos$delegate.getLongValue();
        }

        public final float getResetSnapValue$animation_core() {
            return this.resetSnapValue$delegate.getFloatValue();
        }

        public T getValue() {
            return (T) this.value$delegate.getValue();
        }

        public final boolean isFinished$animation_core() {
            return ((Boolean) this.isFinished$delegate.getValue()).booleanValue();
        }

        public final void resetAnimation$animation_core() {
            setResetSnapValue$animation_core(-2.0f);
        }

        public String toString() {
            return "current value: " + getValue() + ", target: " + getTargetValue() + ", spec: " + getAnimationSpec();
        }

        public final void updateInitialValue$animation_core() {
            SeekableTransitionState.SeekingAnimationState r0 = this.initialValueState;
            if (r0 != null) goto L5;
            return;
        L5:
            TargetBasedAnimation<T, V> r1 = this.initialValueAnimation;
            if (r1 != null) goto L8;
            return;
        L8:
            long r2 = MathKt.roundToLong(r0.getDurationNanos() * ((double) r0.getValue()));
            T r3 = r1.getValueFromNanos(r2);
            if (this.useOnlyInitialValue == false) goto L11;
            getAnimation().setMutableTargetValue$animation_core(r3);
        L11:
            getAnimation().setMutableInitialValue$animation_core(r3);
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            if (getResetSnapValue$animation_core() != (-2.0f)) goto L14;
            boolean r4 = true;
        L15:
            if (r4 == false) goto L17;
        L20:
            setValue$animation_core(r3);
        L22:
            if (r2 < r0.getDurationNanos()) goto L24;
            this.initialValueState = null;
            this.initialValueAnimation = null;
            return;
        L24:
            r0.setComplete(false);
            return;
        L17:
            if (this.useOnlyInitialValue == true) goto L20;
            seekTo$animation_core(this.this$0.getPlayTimeNanos());
            goto L22
        L14:
            r4 = false;
            goto L15
        }

        public final SeekableTransitionState.SeekingAnimationState getInitialValueState$animation_core() {
            return this.initialValueState;
        }

        public final String getLabel() {
            return this.label;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        private final void setAnimation(TargetBasedAnimation<T, V> r2) {
            this.animation$delegate.setValue(r2);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> r2) {
            this.animationSpec$delegate.setValue(r2);
        }

        private final void setTargetValue(T r2) {
            this.targetValue$delegate.setValue(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void resetAnimationValue$animation_core(float r5) {
            boolean r1 = true;
            if (r5 != (-4.0f)) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L8;
        L14:
            TargetBasedAnimation<T, V> r6 = this.initialValueAnimation;
            if (r6 == null) goto L17;
            getAnimation().setMutableInitialValue$animation_core(r6.getTargetValue());
            this.initialValueState = null;
            this.initialValueAnimation = null;
        L17:
            if (r5 == (-4.0f)) goto L20;
            r1 = false;
        L20:
            if (r1 == false) goto L22;
            Object r7 = getAnimation().getInitialValue();
        L23:
            getAnimation().setMutableInitialValue$animation_core(r7);
            getAnimation().setMutableTargetValue$animation_core(r7);
            setValue$animation_core(r7);
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            return;
        L22:
            r7 = getAnimation().getTargetValue();
            goto L23
        L8:
            if (r5 != (-5.0f)) goto L10;
            boolean r4 = true;
        L11:
            if (r4 == true) goto L14;
            setResetSnapValue$animation_core(r5);
            return;
        L10:
            r4 = false;
            goto L11
        L5:
            r3 = false;
            goto L6
        }

        public final void seekTo$animation_core(long r4) {
            if (getResetSnapValue$animation_core() != (-1.0f)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            return;
        L8:
            this.isSeeking = true;
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue()) == false) goto L11;
            setValue$animation_core(getAnimation().getTargetValue());
            return;
        L11:
            setValue$animation_core(getAnimation().getValueFromNanos(r4));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(r4);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void setDurationNanos$animation_core(long r2) {
            this.durationNanos$delegate.setLongValue(r2);
        }

        public final void setFinished$animation_core(boolean r2) {
            this.isFinished$delegate.setValue(Boolean.valueOf(r2));
        }

        public final void setInitialValueAnimation$animation_core(SeekableTransitionState.SeekingAnimationState r8) {
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue()) == true) goto L5;
            this.initialValueAnimation = getAnimation();
            this.initialValueState = r8;
        L5:
            setAnimation(new TargetBasedAnimation(this.interruptionSpec, this.typeConverter, getValue(), getValue(), AnimationVectorsKt.newInstance(this.velocityVector)));
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = true;
        }

        public final void setInitialValueState$animation_core(SeekableTransitionState.SeekingAnimationState r1) {
            this.initialValueState = r1;
        }

        public final void setResetSnapValue$animation_core(float r2) {
            this.resetSnapValue$delegate.setFloatValue(r2);
        }

        public void setValue$animation_core(T r2) {
            this.value$delegate.setValue(r2);
        }

        private final void updateAnimation(T r8, boolean r9) {
            TargetBasedAnimation<T, V> r0 = this.initialValueAnimation;
            if (r0 == null) goto L5;
            T r1 = r0.getTargetValue();
        L7:
            if (Intrinsics.areEqual(r1, getTargetValue()) == false) goto L10;
            setAnimation(new TargetBasedAnimation(this.interruptionSpec, this.typeConverter, r8, r8, AnimationVectorsKt.newInstance(this.velocityVector)));
            this.useOnlyInitialValue = true;
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            return;
        L10:
            if (r9 == true) goto L12;
        L17:
            AnimationSpec r10 = getAnimationSpec();
        L19:
            if (this.this$0.getPlayTimeNanos() <= 0) goto L22;
            r10 = AnimationSpecKt.delayed(r10, this.this$0.getPlayTimeNanos());
        L22:
            setAnimation(new TargetBasedAnimation(r10, this.typeConverter, r8, getTargetValue(), this.velocityVector));
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            Transition.access$onChildAnimationUpdated(this.this$0);
            return;
        L12:
            if (this.isSeeking == true) goto L17;
            if ((getAnimationSpec() instanceof SpringSpec) == false) goto L16;
            r10 = getAnimationSpec();
            goto L19
        L16:
            r10 = this.interruptionSpec;
            goto L19
        L5:
            r1 = null;
            goto L7
        }

        public final void onPlayTimeChanged$animation_core(long r1, boolean r3) {
            if (r3 == false) goto L4;
            r1 = getAnimation().getDurationNanos();
        L4:
            setValue$animation_core(getAnimation().getValueFromNanos(r1));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(r1);
            TargetBasedAnimation<T, V> r4 = getAnimation();
            r4.getClass();
            if (Animation.CC.$default$isFinishedFromNanos(r4, r1) == false) goto L8;
            setFinished$animation_core(true);
            return;
        }

        public final void updateTargetValue$animation_core(T r6, FiniteAnimationSpec<T> r7) {
            if (this.useOnlyInitialValue == false) goto L11;
            TargetBasedAnimation<T, V> r0 = this.initialValueAnimation;
            if (r0 == null) goto L7;
            T r1 = r0.getTargetValue();
        L9:
            if (Intrinsics.areEqual(r6, r1) == false) goto L11;
            return;
        L7:
            r1 = null;
        L11:
            boolean r2 = true;
            if (Intrinsics.areEqual(getTargetValue(), r6) == true) goto L14;
        L19:
            setTargetValue(r6);
            setAnimationSpec(r7);
            if (getResetSnapValue$animation_core() != (-3.0f)) goto L22;
            boolean r8 = true;
        L23:
            if (r8 == false) goto L25;
            T r9 = r6;
        L26:
            updateAnimation(r9, !isFinished$animation_core());
            if (getResetSnapValue$animation_core() != (-3.0f)) goto L29;
            boolean r10 = true;
        L30:
            setFinished$animation_core(r10);
            if (getResetSnapValue$animation_core() < MenuKt.ClosedAlphaTarget) goto L34;
            setValue$animation_core(getAnimation().getValueFromNanos((long) (getAnimation().getDurationNanos() * getResetSnapValue$animation_core())));
        L39:
            this.useOnlyInitialValue = false;
            setResetSnapValue$animation_core(-1.0f);
            return;
        L34:
            if (getResetSnapValue$animation_core() == (-3.0f)) goto L37;
            r2 = false;
        L37:
            if (r2 == false) goto L39;
            setValue$animation_core(r6);
            goto L39
        L29:
            r10 = false;
            goto L30
        L25:
            r9 = getValue();
            goto L26
        L22:
            r8 = false;
            goto L23
        L14:
            if (getResetSnapValue$animation_core() != (-1.0f)) goto L16;
            boolean r3 = true;
        L17:
            if (r3 == false) goto L19;
            return;
        L16:
            r3 = false;
            goto L17
        }

        public final void updateInitialAndTargetValue$animation_core(T r2, T r3, FiniteAnimationSpec<T> r4) {
            setTargetValue(r3);
            setAnimationSpec(r4);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), r2) == true) goto L5;
        L7:
            updateAnimation$default(this, r2, false, 2, null);
            return;
        L5:
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), r3) == false) goto L7;
        }

        public TransitionAnimationState(Transition r9, T r10, V r11, TwoWayConverter<T, V> r12, String r13) {
            this.this$0 = r9;
            this.typeConverter = r12;
            this.label = r13;
            this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(r10, null, 2, null);
            SpringSpec<T> r0 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, 7, null);
            this.defaultSpring = r0;
            this.animationSpec$delegate = SnapshotStateKt.mutableStateOf$default(r0, null, 2, null);
            this.animation$delegate = SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), r12, r10, getTargetValue(), r11), null, 2, null);
            this.isFinished$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.resetSnapValue$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1.0f);
            this.value$delegate = SnapshotStateKt.mutableStateOf$default(r10, null, 2, null);
            this.velocityVector = r11;
            this.durationNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(getAnimation().getDurationNanos());
            Float r14 = VisibilityThresholdsKt.getVisibilityThresholdMap().get(r12);
            if (r14 == null) goto L8;
            float r15 = r14.floatValue();
            AnimationVector r16 = (AnimationVector) r12.getConvertToVector().invoke(r10);
            int r17 = r16.getSize$animation_core();
            int r18 = 0;
        L5:
            if (r18 >= r17) goto L7;
            r16.set$animation_core(r18, r15);
            r18 = r18 + 1;
            goto L5
        L7:
            Object r19 = this.typeConverter.getConvertFromVector().invoke(r16);
        L9:
            this.interruptionSpec = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r19, 3, null);
            return;
        L8:
            r19 = null;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateAnimation$default(TransitionAnimationState r0, Object r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.getValue();
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = false;
        L8:
            r0.updateAnimation(r1, r2);
        }
    }

    public static /* synthetic */ boolean a(Transition r0) {
        return animateTo$lambda$13$lambda$12(r0);
    }

    private static final Unit animateTo$lambda$18(Transition r0, Object r1, int r2, Composer r3, int r4) {
        r0.animateTo$animation_core(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ long b(Transition r2) {
        return totalDurationNanos_delegate$lambda$2(r2);
    }

    public static /* synthetic */ DisposableEffectResult c(CoroutineScope r0, Transition r1, DisposableEffectScope r2) {
        return animateTo$lambda$17$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(Transition r0, Object r1, int r2, Composer r3, int r4) {
        return animateTo$lambda$18(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void getHasInitialValueAnimations$annotations() {
    }

    private final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded(true);
        if (isSeeking() == false) goto L10;
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r0 = this._animations;
        int r1 = r0.size();
        long r3 = 0;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        TransitionAnimationState r6 = (TransitionAnimationState) ListProtector.get(r0, r5);
        r3 = Math.max(r3, r6.getDurationNanos$animation_core());
        r6.seekTo$animation_core(this.lastSeekedTimeNanos);
        r5 = r5 + 1;
        goto L5
    L7:
        setUpdateChildrenNeeded(false);
        return;
    }

    private final long calculateTotalDurationNanos() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r0 = this._animations;
        int r1 = r0.size();
        long r2 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L5;
        r2 = Math.max(r2, ((TransitionAnimationState) ListProtector.get(r0, r5)).getDurationNanos$animation_core());
        r5 = r5 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r3 = this._transitions;
        int r6 = r3.size();
    L6:
        if (r4 >= r6) goto L8;
        r2 = Math.max(r2, ((Transition) ListProtector.get(r3, r4)).calculateTotalDurationNanos());
        r4 = r4 + 1;
        goto L6
    L8:
        return r2;
    }

    private final boolean getUpdateChildrenNeeded() {
        return ((Boolean) this.updateChildrenNeeded$delegate.getValue()).booleanValue();
    }

    private final long get_playTimeNanos() {
        return this._playTimeNanos$delegate.getLongValue();
    }

    public final void clearInitialAnimations$animation_core() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r0 = this._animations;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        ((TransitionAnimationState) ListProtector.get(r0, r3)).clearInitialAnimation$animation_core();
        r3 = r3 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r4 = this._transitions;
        int r5 = r4.size();
    L6:
        if (r2 >= r5) goto L8;
        ((Transition) ListProtector.get(r4, r2)).clearInitialAnimations$animation_core();
        r2 = r2 + 1;
        goto L6
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final boolean getHasInitialValueAnimations() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r0 = this._animations;
        int r1 = r0.size();
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L12;
        if (((TransitionAnimationState) ListProtector.get(r0, r3)).getInitialValueState$animation_core() == null) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L10;
        r3 = r3 + 1;
        goto L4
    L10:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L22;
        SnapshotStateList<Transition<?>> r4 = this._transitions;
        int r6 = r4.size();
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L20;
        if (((Transition) ListProtector.get(r4, r7)).getHasInitialValueAnimations() == true) goto L18;
        r7 = r7 + 1;
        goto L15
    L18:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L22;
        return false;
    L20:
        r8 = false;
    L22:
        return true;
    L8:
        r5 = false;
        goto L9
    L12:
        r2 = false;
        goto L13
    }

    public final long getPlayTimeNanos() {
        Transition<?> r0 = this.parentTransition;
        if (r0 == null) goto L6;
        return r0.getPlayTimeNanos();
    L6:
        return get_playTimeNanos();
    }

    public final Segment<S> getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final long getStartTimeNanos$animation_core() {
        return this.startTimeNanos$delegate.getLongValue();
    }

    public final S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos$delegate.getValue()).longValue();
    }

    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    public final void onTransitionEnd$animation_core() {
        setStartTimeNanos$animation_core(Long.MIN_VALUE);
        TransitionState<S> r0 = this.transitionState;
        if ((r0 instanceof MutableTransitionState) == false) goto L5;
        ((MutableTransitionState) r0).setCurrentState$animation_core(getTargetState());
    L5:
        setPlayTimeNanos(0);
        int r1 = 0;
        this.transitionState.setRunning$animation_core(false);
        SnapshotStateList<Transition<?>> r2 = this._transitions;
        int r3 = r2.size();
    L6:
        if (r1 >= r3) goto L8;
        ((Transition) ListProtector.get(r2, r1)).onTransitionEnd$animation_core();
        r1 = r1 + 1;
        goto L6
    }

    public final void updateInitialValues$animation_core() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r0 = this._animations;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        ((TransitionAnimationState) ListProtector.get(r0, r3)).updateInitialValue$animation_core();
        r3 = r3 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r4 = this._transitions;
        int r5 = r4.size();
    L6:
        if (r2 >= r5) goto L8;
        ((Transition) ListProtector.get(r4, r2)).updateInitialValues$animation_core();
        r2 = r2 + 1;
        goto L6
    }

    public final boolean isRunning() {
        if (getStartTimeNanos$animation_core() == Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onDisposed$animation_core() {
        onTransitionEnd$animation_core();
        this.transitionState.transitionRemoved$animation_core();
    }

    public String toString() {
        List<Transition<S>.TransitionAnimationState<?, ?>> r0 = getAnimations();
        int r1 = r0.size();
        String r2 = "Transition animation values: ";
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r2 = r2 + ((TransitionAnimationState) ListProtector.get(r0, r3)) + ", ";
        r3 = r3 + 1;
        goto L3
    L5:
        return r2;
    }

    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getLastSeekedTimeNanos$animation_core() {
        return this.lastSeekedTimeNanos;
    }

    public final Transition<?> getParentTransition() {
        return this.parentTransition;
    }

    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    public static final /* synthetic */ void access$onChildAnimationUpdated(Transition r0) {
        r0.onChildAnimationUpdated();
    }

    private static final boolean animateTo$lambda$13$lambda$12(Transition r2) {
        if (Intrinsics.areEqual(r2.getTargetState(), r2.getCurrentState()) == true) goto L5;
    L10:
        return true;
    L5:
        if (r2.isRunning() == true) goto L10;
        if (r2.getUpdateChildrenNeeded() == true) goto L10;
        return false;
    }

    private static final boolean animateTo$lambda$14(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private final void setSegment(Segment<S> r2) {
        this.segment$delegate.setValue(r2);
    }

    private final void setUpdateChildrenNeeded(boolean r2) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void set_playTimeNanos(long r2) {
        this._playTimeNanos$delegate.setLongValue(r2);
    }

    private static final long totalDurationNanos_delegate$lambda$2(Transition r2) {
        return r2.calculateTotalDurationNanos();
    }

    public final boolean addAnimation$animation_core(Transition<S>.TransitionAnimationState<?, ?> r2) {
        return this._animations.add(r2);
    }

    public final boolean addTransition$animation_core(Transition<?> r2) {
        return this._transitions.add(r2);
    }

    public final void onTransitionStart$animation_core(long r1) {
        setStartTimeNanos$animation_core(r1);
        this.transitionState.setRunning$animation_core(true);
    }

    public final void removeAnimation$animation_core(Transition<S>.DeferredAnimation<?, ?> r1) {
        Transition<S>.DeferredAnimationData<?, ?>.DeferredAnimationData<?, V> r2 = r1.getData$animation_core();
        if (r2 == 0) goto L8;
        Transition<S>.TransitionAnimationState<?, ?> r3 = r2.getAnimation();
        if (r3 == null) goto L9;
        removeAnimation$animation_core(r3);
        return;
    L9:
        return;
    }

    public final boolean removeTransition$animation_core(Transition<?> r2) {
        return this._transitions.remove(r2);
    }

    public final void resetAnimationFraction$animation_core(float r6) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r0 = this._animations;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        ((TransitionAnimationState) ListProtector.get(r0, r3)).resetAnimationValue$animation_core(r6);
        r3 = r3 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r4 = this._transitions;
        int r5 = r4.size();
    L6:
        if (r2 >= r5) goto L8;
        ((Transition) ListProtector.get(r4, r2)).resetAnimationFraction$animation_core(r6);
        r2 = r2 + 1;
        goto L6
    }

    public final void seekAnimations$animation_core(long r7) {
        if (getStartTimeNanos$animation_core() != Long.MIN_VALUE) goto L5;
        setStartTimeNanos$animation_core(r7);
    L5:
        setPlayTimeNanos(r7);
        int r0 = 0;
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r1 = this._animations;
        int r2 = r1.size();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        ((TransitionAnimationState) ListProtector.get(r1, r3)).seekTo$animation_core(r7);
        r3 = r3 + 1;
        goto L6
    L8:
        SnapshotStateList<Transition<?>> r4 = this._transitions;
        int r5 = r4.size();
    L9:
        if (r0 >= r5) goto L14;
        Transition r6 = (Transition) ListProtector.get(r4, r0);
        if (Intrinsics.areEqual(r6.getTargetState(), r6.getCurrentState()) == true) goto L13;
        r6.seekAnimations$animation_core(r7);
    L13:
        r0 = r0 + 1;
        goto L9
    }

    public final void setInitialAnimations$animation_core(SeekableTransitionState.SeekingAnimationState r6) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r0 = this._animations;
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        ((TransitionAnimationState) ListProtector.get(r0, r3)).setInitialValueAnimation$animation_core(r6);
        r3 = r3 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r4 = this._transitions;
        int r5 = r4.size();
    L6:
        if (r2 >= r5) goto L8;
        ((Transition) ListProtector.get(r4, r2)).setInitialAnimations$animation_core(r6);
        r2 = r2 + 1;
        goto L6
    }

    public final void setLastSeekedTimeNanos$animation_core(long r1) {
        this.lastSeekedTimeNanos = r1;
    }

    public final void setPlayTimeNanos(long r2) {
        if (this.parentTransition != null) goto L6;
        set_playTimeNanos(r2);
        return;
    }

    public final void setSeeking$animation_core(boolean r2) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setStartTimeNanos$animation_core(long r2) {
        this.startTimeNanos$delegate.setLongValue(r2);
    }

    public final void setTargetState$animation_core(S r2) {
        this.targetState$delegate.setValue(r2);
    }

    public final void updateTarget$animation_core(S r4) {
        if (Intrinsics.areEqual(getTargetState(), r4) == true) goto L13;
        setSegment(new SegmentImpl(getTargetState(), r4));
        if (Intrinsics.areEqual(getCurrentState(), getTargetState()) == true) goto L7;
        this.transitionState.setCurrentState$animation_core(getTargetState());
    L7:
        setTargetState$animation_core(r4);
        if (isRunning() == true) goto L10;
        setUpdateChildrenNeeded(true);
    L10:
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r5 = this._animations;
        int r0 = r5.size();
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L15;
        ((TransitionAnimationState) ListProtector.get(r5, r1)).resetAnimation$animation_core();
        r1 = r1 + 1;
        goto L11
    L15:
        return;
    }

    public final void removeAnimation$animation_core(Transition<S>.TransitionAnimationState<?, ?> r2) {
        this._animations.remove(r2);
    }

    public Transition(MutableTransitionState<S> r2, String r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.compose.animation.core.TransitionState<S of androidx.compose.animation.core.Transition>");
        this(r2, null, r3);
    }

    public final void onFrame$animation_core(long r9, boolean r11) {
        boolean r4 = true;
        if (getStartTimeNanos$animation_core() != Long.MIN_VALUE) goto L6;
        onTransitionStart$animation_core(r9);
    L8:
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r1 = this._animations;
        int r2 = r1.size();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L17;
        TransitionAnimationState r5 = (TransitionAnimationState) ListProtector.get(r1, r3);
        if (r5.isFinished$animation_core() == true) goto L14;
        r5.onPlayTimeChanged$animation_core(r9, r11);
    L14:
        if (r5.isFinished$animation_core() == true) goto L16;
        r4 = false;
    L16:
        r3 = r3 + 1;
        goto L9
    L17:
        SnapshotStateList<Transition<?>> r6 = this._transitions;
        int r7 = r6.size();
        int r8 = 0;
    L18:
        if (r8 >= r7) goto L26;
        Transition r10 = (Transition) ListProtector.get(r6, r8);
        if (Intrinsics.areEqual(r10.getTargetState(), r10.getCurrentState()) == true) goto L23;
        r10.onFrame$animation_core(r9, r11);
    L23:
        if (Intrinsics.areEqual(r10.getTargetState(), r10.getCurrentState()) == true) goto L25;
        r4 = false;
    L25:
        r8 = r8 + 1;
        goto L18
    L26:
        if (r4 == false) goto L35;
        onTransitionEnd$animation_core();
        return;
    L35:
        return;
    L6:
        if (this.transitionState.isRunning$animation_core() == true) goto L8;
        this.transitionState.setRunning$animation_core(true);
        goto L8
    }

    public Transition(S r2, String r3) {
        this(new MutableTransitionState(r2), null, r3);
    }

    public final void onFrame$animation_core(long r6, float r8) {
        if (getStartTimeNanos$animation_core() != Long.MIN_VALUE) goto L5;
        onTransitionStart$animation_core(r6);
    L5:
        long r7 = r6 - getStartTimeNanos$animation_core();
        boolean r1 = true;
        if (r8 != MenuKt.ClosedAlphaTarget) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r7 = MathKt.roundToLong(r7 / ((double) r8));
    L12:
        setPlayTimeNanos(r7);
        if (r8 == MenuKt.ClosedAlphaTarget) goto L16;
        r1 = false;
    L16:
        onFrame$animation_core(r7, r1);
        return;
    L8:
        r3 = false;
        goto L9
    }

    public Transition(TransitionState<S> r2, String r3) {
        this(r2, null, r3);
    }

    public Transition(TransitionState<S> r4, Transition<?> r5, String r6) {
        this.transitionState = r4;
        this.parentTransition = r5;
        this.label = r6;
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.segment$delegate = SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this._playTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(0);
        this.startTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        Boolean r7 = Boolean.FALSE;
        this.updateChildrenNeeded$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking$delegate = SnapshotStateKt.mutableStateOf$default(r7, null, 2, null);
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new g0(this));
        r4.transitionConfigured$animation_core(this);
    }

    private static final DisposableEffectResult animateTo$lambda$17$lambda$16(CoroutineScope r6, Transition r7, DisposableEffectScope r8) {
        BuildersKt.launch$default(r6, null, CoroutineStart.UNDISPATCHED, new Transition$animateTo$1$1$1(r7, null), 1, null);
        return new Transition$animateTo$lambda$17$lambda$16$$inlined$onDispose$1();
    }

    public final void animateTo$animation_core(final S r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(-1493585151);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L14:
        if ((r10 & 48) == 0) goto L16;
    L20:
        boolean r5 = false;
        if ((r1 & 19) == 18) goto L23;
        boolean r2 = true;
    L25:
        if (r11.shouldExecute(r2, r1 & 1) == true) goto L27;
        r11.skipToGroupEnd();
    L61:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L65;
        r12.updateScope(new f0(this, r8, r10));
        return;
    L65:
        return;
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(-1493585151, r1, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1180)");
    L30:
        if (isSeeking() == true) goto L56;
        r11.startReplaceGroup(466120769);
        updateTarget$animation_core(r8);
        int r0 = r1 & 112;
        if (r0 != 32) goto L34;
        boolean r3 = true;
    L35:
        Object r4 = r11.rememberedValue();
        if (r3 == false) goto L38;
    L39:
        r4 = SnapshotStateKt.derivedStateOf(new d0(this));
        r11.updateRememberedValue(r4);
    L41:
        if (animateTo$lambda$14((State) r4) == false) goto L54;
        r11.startReplaceGroup(466528884);
        Object r6 = r11.rememberedValue();
        Composer.Companion r7 = Composer.Companion;
        if (r6 != r7.getEmpty()) goto L45;
        r6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r11);
        r11.updateRememberedValue(r6);
    L45:
        final CoroutineScope r13 = (CoroutineScope) r6;
        boolean r14 = r11.changedInstance(r13);
        if (r0 != 32) goto L48;
        r5 = true;
    L48:
        boolean r15 = r14 | r5;
        Object r16 = r11.rememberedValue();
        if (r15 == false) goto L51;
    L52:
        r16 = new e0(r13, this);
        r11.updateRememberedValue(r16);
    L53:
        EffectsKt.DisposableEffect(r13, this, (Function1) r16, r11, r0);
        r11.endReplaceGroup();
    L55:
        r11.endReplaceGroup();
    L58:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
        goto L61
    L51:
        if (r16 != r7.getEmpty()) goto L53;
    L54:
        r11.startReplaceGroup(467771457);
        r11.endReplaceGroup();
        goto L55
    L38:
        if (r4 != Composer.Companion.getEmpty()) goto L41;
    L34:
        r3 = false;
        goto L35
    L56:
        r11.startReplaceGroup(467781377);
        r11.endReplaceGroup();
        goto L58
    L23:
        r2 = false;
        goto L25
    L16:
        if (r11.changed(this) == false) goto L18;
        int r17 = 32;
    L19:
        r1 = r1 | r17;
        goto L20
    L18:
        r17 = 16;
        goto L19
    L5:
        if ((r10 & 8) != 0) goto L7;
        boolean r18 = r11.changed(r8);
    L8:
        if (r18 == false) goto L10;
        int r19 = 4;
    L11:
        r1 = r19 | r10;
        goto L14
    L10:
        r19 = 2;
        goto L11
    L7:
        r18 = r11.changedInstance(r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void seek(S r6, S r7, long r8) {
        setStartTimeNanos$animation_core(Long.MIN_VALUE);
        int r1 = 0;
        this.transitionState.setRunning$animation_core(false);
        if (isSeeking() == false) goto L9;
        if (Intrinsics.areEqual(getCurrentState(), r6) == false) goto L9;
        if (Intrinsics.areEqual(getTargetState(), r7) == false) goto L9;
    L14:
        SnapshotStateList<Transition<?>> r9 = this._transitions;
        int r10 = r9.size();
        int r0 = 0;
    L15:
        if (r0 >= r10) goto L20;
        Transition r2 = (Transition) ListProtector.get(r9, r0);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
        if (r2.isSeeking() == false) goto L19;
        r2.seek(r2.getCurrentState(), r2.getTargetState(), r8);
    L19:
        r0 = r0 + 1;
        goto L15
    L20:
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r11 = this._animations;
        int r12 = r11.size();
    L21:
        if (r1 >= r12) goto L23;
        ((TransitionAnimationState) ListProtector.get(r11, r1)).seekTo$animation_core(r8);
        r1 = r1 + 1;
        goto L21
    L23:
        this.lastSeekedTimeNanos = r8;
        return;
    L9:
        if (Intrinsics.areEqual(getCurrentState(), r6) == true) goto L13;
        TransitionState<S> r3 = this.transitionState;
        if ((r3 instanceof MutableTransitionState) == false) goto L13;
        ((MutableTransitionState) r3).setCurrentState$animation_core(r6);
    L13:
        setTargetState$animation_core(r7);
        setSeeking$animation_core(true);
        setSegment(new SegmentImpl(r6, r7));
        goto L14
    }

    public /* synthetic */ Transition(MutableTransitionState r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public /* synthetic */ Transition(TransitionState r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public /* synthetic */ Transition(TransitionState r1, Transition r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
