package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001n\b\u0007\u0018\u0000 \u0082\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0082\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0083\u0001\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0016B4\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0017BD\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0018J\u0006\u0010N\u001a\u00020\u000bJ\u001d\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00028\u00002\u0006\u0010R\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010SJ#\u0010d\u001a\u00020e2\f\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010g\u001a\u00028\u0000¢\u0006\u0002\u0010hJ\u001c\u0010i\u001a\u00020e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0086@¢\u0006\u0002\u0010jJ\u0016\u0010i\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\u000bH\u0087@¢\u0006\u0002\u0010lJ\\\u0010p\u001a\u00020e2\b\b\u0002\u0010q\u001a\u00020r2B\u0010s\u001a>\b\u0001\u0012\u0004\u0012\u00020u\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0v\u0012\u0006\u0012\u0004\u0018\u00010\u00020t¢\u0006\u0002\bwH\u0086@¢\u0006\u0002\u0010xJy\u0010p\u001a\u00020e2\u0006\u0010C\u001a\u00028\u00002\b\b\u0002\u0010q\u001a\u00020r2W\u0010s\u001aS\b\u0001\u0012\u0004\u0012\u00020u\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(z\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(C\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0v\u0012\u0006\u0012\u0004\u0018\u00010\u00020y¢\u0006\u0002\bwH\u0086@¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000bH\u0000¢\u0006\u0002\b~J\u000e\u0010\u007f\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000bJ\u0017\u0010\u0080\u0001\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010\u0081\u0001R5\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\nX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R8\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R8\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0+2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0+8\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010&\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u00158@X\u0080\u0004¢\u0006\f\u0012\u0004\b3\u0010&\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00109\u001a\u00028\u00002\u0006\u00108\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0005R+\u0010?\u001a\u00028\u00002\u0006\u00108\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010>\u001a\u0004\b@\u0010;\"\u0004\bA\u0010\u0005R\u001b\u0010C\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bD\u0010;R+\u0010G\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0011\u0010O\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bO\u00105R!\u0010P\u001a\u00020\u000b8GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bV\u0010F\u0012\u0004\bT\u0010&\u001a\u0004\bU\u0010IR+\u0010W\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010M\u001a\u0004\bX\u0010I\"\u0004\bY\u0010KR/\u0010[\u001a\u0004\u0018\u00018\u00002\b\u00108\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010>\u001a\u0004\b\\\u0010;\"\u0004\b]\u0010\u0005R7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010>\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010o¨\u0006\u0083\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;)V", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setConfirmValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "getPositionalThreshold$foundation_release", "setPositionalThreshold$foundation_release", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setVelocityThreshold$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "value", "snapAnimationSpec", "getSnapAnimationSpec$annotations", "()V", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setSnapAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/AnimationSpec;)V", "Landroidx/compose/animation/core/DecayAnimationSpec;", "decayAnimationSpec", "getDecayAnimationSpec$annotations", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setDecayAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "usePreModifierChangeBehavior", "getUsePreModifierChangeBehavior$foundation_release$annotations", "getUsePreModifierChangeBehavior$foundation_release", "()Z", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "requireOffset", "isAnimationRunning", "progress", "from", "to", "(Ljava/lang/Object;Ljava/lang/Object;)F", "getProgress$annotations", "getProgress", "progress$delegate", "lastVelocity", "getLastVelocity", "setLastVelocity", "lastVelocity$delegate", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "updateAnchors", "", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "settle", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "anchoredDrag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "anchor", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newOffsetForDelta", "delta", "newOffsetForDelta$foundation_release", "dispatchRawDelta", "trySnapTo", "(Ljava/lang/Object;)Z", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState$anchoredDragScope$1 anchoredDragScope;
    private final MutableState anchors$delegate;
    private Function1<? super T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    public DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    public Function1<? super Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final MutableState settledValue$delegate;
    public AnimationSpec<Float> snapAnimationSpec;
    private final State targetValue$delegate;
    public Function0<Float> velocityThreshold;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u0001J:\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007J\u0087\u0001\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "T", "confirmValueChange", "Lkotlin/Function1;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "distance", "velocityThreshold", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private static final boolean Saver$lambda$2(Object r0) {
            return true;
        }

        private static final boolean Saver$lambda$5(Object r0) {
            return true;
        }

        public static /* synthetic */ Object a(SaverScope r0, AnchoredDraggableState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ AnchoredDraggableState b(Function1 r0, Object r1) {
            return Saver$lambda$4(r0, r1);
        }

        public static /* synthetic */ boolean c(Object r0) {
            return Saver$lambda$2(r0);
        }

        public static /* synthetic */ boolean d(Object r0) {
            return Saver$lambda$5(r0);
        }

        public static /* synthetic */ AnchoredDraggableState e(Function1 r0, Function0 r1, AnimationSpec r2, DecayAnimationSpec r3, Function1 r4, Object r5) {
            return Saver$lambda$7(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ Object f(SaverScope r0, AnchoredDraggableState r1) {
            return Saver$lambda$3(r0, r1);
        }

        public static /* synthetic */ AnchoredDraggableState g(Object r0) {
            return Saver$lambda$1(r0);
        }

        public static /* synthetic */ Object h(SaverScope r0, AnchoredDraggableState r1) {
            return Saver$lambda$6(r0, r1);
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver() {
            return SaverKt.Saver(new r(), new s());
        }

        private static final AnchoredDraggableState Saver$lambda$1(Object r1) {
            return new AnchoredDraggableState(r1);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final Function1<? super T, Boolean> r3) {
            return SaverKt.Saver(new p(), new q(r3));
        }

        private static final Object Saver$lambda$0(SaverScope r0, AnchoredDraggableState r1) {
            return r1.getCurrentValue();
        }

        private static final Object Saver$lambda$3(SaverScope r0, AnchoredDraggableState r1) {
            return r1.getCurrentValue();
        }

        private static final AnchoredDraggableState Saver$lambda$4(Function1 r1, Object r2) {
            return new AnchoredDraggableState(r2, r1);
        }

        private static final Object Saver$lambda$6(SaverScope r0, AnchoredDraggableState r1) {
            return r1.getCurrentValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Saver Saver$default(Companion r0, Function1 r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = new t();
        L6:
            return r0.Saver(r1);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> r9, final DecayAnimationSpec<Float> r10, final Function1<? super Float, Float> r11, final Function0<Float> r12, final Function1<? super T, Boolean> r13) {
            return SaverKt.Saver(new u(), new v(r11, r12, r9, r10, r13));
        }

        private static final AnchoredDraggableState Saver$lambda$7(Function1 r6, Function0 r7, AnimationSpec r8, DecayAnimationSpec r9, Function1 r10, Object r11) {
            return AnchoredDraggableKt.AnchoredDraggableState(r11, r6, r7, r8, r9, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Saver Saver$default(Companion r6, AnimationSpec r7, DecayAnimationSpec r8, Function1 r9, Function0 r10, Function1 r11, int r12, Object r13) {
            if ((r12 & 16) == 0) goto L6;
            r11 = new w();
        L6:
            return r6.Saver(r7, r8, r9, r10, r11);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2", f = "AnchoredDraggable.kt", i = {}, l = {1142}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "latestAnchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2", f = "AnchoredDraggable.kt", i = {}, l = {1143}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00172 extends SuspendLambda implements Function2<DraggableAnchors<T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C00172(Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r1, AnchoredDraggableState<T> r2, Continuation<? super C00172> r3) {
                this.$block = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                C00172 r0 = new C00172(this.$block, this.this$0, r5);
                r0.L$0 = r4;
                return r0;
            }

            public final Object invoke(DraggableAnchors<T> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((DraggableAnchors) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                DraggableAnchors r6 = (DraggableAnchors) this.L$0;
                Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> r2 = this.$block;
                AnchoredDraggableState$anchoredDragScope$1 r3 = AnchoredDraggableState.access$getAnchoredDragScope$p(this.this$0);
                this.label = 1;
                if (r2.invoke(r3, r6, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(AnchoredDraggableState<T> r1, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$block = r2;
            super(1, r3);
        }

        public static /* synthetic */ DraggableAnchors a(AnchoredDraggableState r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$block, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final DraggableAnchors invokeSuspend$lambda$0(AnchoredDraggableState r0) {
            return r0.getAnchors();
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            T r8 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset());
            if (r8 == null) goto L22;
            float r3 = this.this$0.getAnchors().positionOf(r8);
            if (Math.abs(this.this$0.getOffset() - r3) < 0.5f) goto L17;
            r2 = false;
        L17:
            if (r2 == false) goto L22;
            if (((Boolean) this.this$0.getConfirmValueChange$foundation_release().invoke(r8)).booleanValue() == false) goto L22;
            AnchoredDraggableState.access$setSettledValue(this.this$0, r8);
            AnchoredDraggableState.access$setCurrentValue(this.this$0, r8);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            final AnchoredDraggableState<T> r9 = this.this$0;
            Function0 r4 = new x(r9);
            C00172 r5 = new C00172(this.$block, r9, null);
            this.label = 1;
            if (AnchoredDraggableKt.access$restartable(r4, r5, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState", f = "AnchoredDraggable.kt", i = {}, l = {1187}, m = "anchoredDrag", n = {}, s = {})
    public static final class AnonymousClass3 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        public AnonymousClass3(AnchoredDraggableState<T> r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return this.this$0.anchoredDrag(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4", f = "AnchoredDraggable.kt", i = {}, l = {1189}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "<destruct>", "Lkotlin/Pair;", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2", f = "AnchoredDraggable.kt", i = {}, l = {1191}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends DraggableAnchors<T>, ? extends T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r1, AnchoredDraggableState<T> r2, Continuation<? super AnonymousClass2> r3) {
                this.$block = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                AnonymousClass2 r0 = new AnonymousClass2(this.$block, this.this$0, r5);
                r0.L$0 = r4;
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((Pair) r1, (Continuation) r2);
            }

            public final Object invoke(Pair<? extends DraggableAnchors<T>, ? extends T> r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
                Pair r7 = (Pair) this.L$0;
                DraggableAnchors r2 = (DraggableAnchors) r7.component1();
                Object r8 = r7.component2();
                Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> r3 = this.$block;
                AnchoredDraggableState$anchoredDragScope$1 r4 = AnchoredDraggableState.access$getAnchoredDragScope$p(this.this$0);
                this.label = 1;
                if (r3.invoke(r4, r2, r8, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(AnchoredDraggableState<T> r1, T r2, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super AnonymousClass4> r4) {
            this.this$0 = r1;
            this.$targetValue = r2;
            this.$block = r3;
            super(1, r4);
        }

        public static /* synthetic */ Pair a(AnchoredDraggableState r0) {
            return invokeSuspend$lambda$0(r0);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass4(this.this$0, this.$targetValue, this.$block, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        private static final Pair invokeSuspend$lambda$0(AnchoredDraggableState r1) {
            return TuplesKt.to(r1.getAnchors(), r1.getTargetValue());
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            if (((Boolean) this.this$0.getConfirmValueChange$foundation_release().invoke(this.$targetValue)).booleanValue() == false) goto L15;
            float r8 = this.this$0.getAnchors().positionOf(this.$targetValue);
            AnchoredDraggableState.access$getAnchoredDragScope$p(this.this$0).dragTo(r8, this.this$0.getLastVelocity());
            AnchoredDraggableState.access$setSettledValue(this.this$0, this.$targetValue);
            AnchoredDraggableState.access$setCurrentValue(this.this$0, this.$targetValue);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            AnchoredDraggableState.access$setDragTarget(this.this$0, this.$targetValue);
            final AnchoredDraggableState<T> r9 = this.this$0;
            Function0 r2 = new y(r9);
            AnonymousClass2 r3 = new AnonymousClass2(this.$block, r9, null);
            this.label = 1;
            if (AnchoredDraggableKt.access$restartable(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(Object r0) {
        return true;
    }

    private static final boolean _init_$lambda$1(Object r0) {
        return true;
    }

    public static /* synthetic */ boolean a(Object r0) {
        return _init_$lambda$1(r0);
    }

    public static /* synthetic */ Object b(AnchoredDraggableState r0) {
        return targetValue_delegate$lambda$4(r0);
    }

    public static /* synthetic */ float c(AnchoredDraggableState r0) {
        return progress_delegate$lambda$6(r0);
    }

    private static final boolean confirmValueChange$lambda$2(Object r0) {
        return true;
    }

    public static /* synthetic */ boolean d(Object r0) {
        return _init_$lambda$0(r0);
    }

    public static /* synthetic */ boolean e(Object r0) {
        return confirmValueChange$lambda$2(r0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getDecayAnimationSpec$annotations() {
    }

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(expression = "progress(state.settledValue, state.targetValue)", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getSnapAnimationSpec$annotations() {
    }

    public static /* synthetic */ void getUsePreModifierChangeBehavior$foundation_release$annotations() {
    }

    private final T getDragTarget() {
        return (T) this.dragTarget$delegate.getValue();
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors$delegate.getValue();
    }

    public final T getCurrentValue() {
        return (T) this.currentValue$delegate.getValue();
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        DecayAnimationSpec<Float> r0 = this.decayAnimationSpec;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("decayAnimationSpec");
        return null;
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        Function1 r0 = this.positionalThreshold;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public final T getSettledValue() {
        return (T) this.settledValue$delegate.getValue();
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        AnimationSpec<Float> r0 = this.snapAnimationSpec;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("snapAnimationSpec");
        return null;
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    public final boolean getUsePreModifierChangeBehavior$foundation_release() {
        if (this.positionalThreshold != null) goto L5;
    L11:
        return false;
    L5:
        if (this.velocityThreshold == null) goto L11;
        if (this.snapAnimationSpec == null) goto L11;
        if (this.decayAnimationSpec == null) goto L11;
        return true;
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        Function0<Float> r0 = this.velocityThreshold;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("velocityThreshold");
        return null;
    }

    public final boolean isAnimationRunning() {
        if (getDragTarget() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        if ((!Float.isNaN(getOffset())) == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
    L6:
        return getOffset();
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    public AnchoredDraggableState(T r4) {
        this.confirmValueChange = new k();
        this.dragMutex = new MutatorMutex();
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        this.settledValue$delegate = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new l(this));
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new m(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.dragTarget$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.access$emptyDraggableAnchors(), null, 2, null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public static final /* synthetic */ AnchoredDraggableState$anchoredDragScope$1 access$getAnchoredDragScope$p(AnchoredDraggableState r0) {
        return r0.anchoredDragScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final float progress_delegate$lambda$6(AnchoredDraggableState r5) {
        float r0 = r5.getAnchors().positionOf(r5.getSettledValue());
        float r1 = r5.getAnchors().positionOf(r5.getTargetValue()) - r0;
        float r2 = Math.abs(r1);
        if (Float.isNaN(r2) == false) goto L5;
        return 1.0f;
    L5:
        if (r2 <= 1.0E-6f) goto L15;
        float r6 = (r5.requireOffset() - r0) / r1;
        if (r6 >= 1.0E-6f) goto L10;
        return MenuKt.ClosedAlphaTarget;
    L10:
        if (r6 <= 0.999999f) goto L13;
        return 1.0f;
    L13:
        return r6;
    L15:
        return 1.0f;
    }

    private final void setAnchors(DraggableAnchors<T> r2) {
        this.anchors$delegate.setValue(r2);
    }

    private final void setCurrentValue(T r2) {
        this.currentValue$delegate.setValue(r2);
    }

    private final void setDragTarget(T r2) {
        this.dragTarget$delegate.setValue(r2);
    }

    private final void setLastVelocity(float r2) {
        this.lastVelocity$delegate.setFloatValue(r2);
    }

    private final void setOffset(float r2) {
        this.offset$delegate.setFloatValue(r2);
    }

    private final void setSettledValue(T r2) {
        this.settledValue$delegate.setValue(r2);
    }

    private static final Object targetValue_delegate$lambda$4(AnchoredDraggableState r2) {
        Object r0 = r2.getDragTarget();
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (Float.isNaN(r2.getOffset()) == true) goto L9;
        T r1 = r2.getAnchors().closestAnchor(r2.getOffset());
        if (r1 != null) goto L13;
        Object r3 = r2.getCurrentValue();
    L11:
        return r3;
    L13:
        return r1;
    L9:
        r3 = r2.getCurrentValue();
        goto L11
    }

    private final boolean trySnapTo(T r8) {
        MutatorMutex r0 = this.dragMutex;
        boolean r1 = r0.tryLock();
        if (r1 == true) goto L13;
    L12:
        return r1;
    L13:
        AnchoredDraggableState$anchoredDragScope$1 r2 = this.anchoredDragScope;     // Catch: Throwable -> L9
        float r3 = getAnchors().positionOf(r8);     // Catch: Throwable -> L9
        if (Float.isNaN(r3) == true) goto L7;
        AnchoredDragScope.CC.dragTo$default(r2, r3, MenuKt.ClosedAlphaTarget, 2, null);     // Catch: Throwable -> L9
        setDragTarget(null);     // Catch: Throwable -> L9
    L7:
        setCurrentValue(r8);     // Catch: Throwable -> L9
        setSettledValue(r8);     // Catch: Throwable -> L9
        r0.unlock();
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final float dispatchRawDelta(float r6) {
        float r7 = newOffsetForDelta$foundation_release(r6);
        float r0 = r7 - requireOffset();
        AnchoredDragScope.CC.dragTo$default(this.anchoredDragScope, r7, MenuKt.ClosedAlphaTarget, 2, null);
        return r0;
    }

    public final float newOffsetForDelta$foundation_release(float r3) {
        if (Float.isNaN(getOffset()) == false) goto L5;
        float r0 = MenuKt.ClosedAlphaTarget;
    L7:
        return RangesKt.coerceIn(r0 + r3, getAnchors().minPosition(), getAnchors().maxPosition());
    L5:
        r0 = getOffset();
        goto L7
    }

    public final void setConfirmValueChange$foundation_release(Function1<? super T, Boolean> r1) {
        this.confirmValueChange = r1;
    }

    public final void setDecayAnimationSpec$foundation_release(DecayAnimationSpec<Float> r1) {
        this.decayAnimationSpec = r1;
    }

    public final void setPositionalThreshold$foundation_release(Function1<? super Float, Float> r1) {
        this.positionalThreshold = r1;
    }

    public final void setSnapAnimationSpec$foundation_release(AnimationSpec<Float> r1) {
        this.snapAnimationSpec = r1;
    }

    public final void setVelocityThreshold$foundation_release(Function0<Float> r1) {
        this.velocityThreshold = r1;
    }

    public AnchoredDraggableState(T r1, DraggableAnchors<T> r2) {
        this(r1);
        setAnchors(r2);
        trySnapTo(r1);
    }

    public static final /* synthetic */ void access$setCurrentValue(AnchoredDraggableState r0, Object r1) {
        r0.setCurrentValue(r1);
    }

    public static final /* synthetic */ void access$setDragTarget(AnchoredDraggableState r0, Object r1) {
        r0.setDragTarget(r1);
    }

    public static final /* synthetic */ void access$setLastVelocity(AnchoredDraggableState r0, float r1) {
        r0.setLastVelocity(r1);
    }

    public static final /* synthetic */ void access$setOffset(AnchoredDraggableState r0, float r1) {
        r0.setOffset(r1);
    }

    public static final /* synthetic */ void access$setSettledValue(AnchoredDraggableState r0, Object r1) {
        r0.setSettledValue(r1);
    }

    public final float progress(T r4, T r5) {
        float r6 = getAnchors().positionOf(r4);
        float r7 = getAnchors().positionOf(r5);
        float r0 = (RangesKt.coerceIn(getOffset(), Math.min(r6, r7), Math.max(r6, r7)) - r6) / (r7 - r6);
        if (Float.isNaN(r0) == false) goto L5;
        return 1.0f;
    L5:
        if (r0 >= 1.0E-6f) goto L8;
        return MenuKt.ClosedAlphaTarget;
    L8:
        if (r0 <= 0.999999f) goto L11;
        return 1.0f;
    L11:
        return Math.abs(r0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.")
    public final Object settle(float r14, Continuation<? super Float> r15) {
        if (getUsePreModifierChangeBehavior$foundation_release() == true) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException("AnchoredDraggableState was configured through a constructor without providing positional and velocity threshold. This overload of settle has been deprecated. Please refer to AnchoredDraggableState#settle(animationSpec) for more information.");
    L5:
        T r2 = getCurrentValue();
        Object r6 = AnchoredDraggableKt.access$computeTarget(getAnchors(), requireOffset(), r14, getPositionalThreshold$foundation_release(), getVelocityThreshold$foundation_release());
        if (((Boolean) this.confirmValueChange.invoke(r6)).booleanValue() == false) goto L10;
        return AnchoredDraggableKt.animateToWithDecay$default(this, r6, r14, null, null, r15, 12, null);
    L10:
        return AnchoredDraggableKt.animateToWithDecay$default(this, r2, r14, null, null, r15, 12, null);
    }

    public final void updateAnchors(DraggableAnchors<T> r2, T r3) {
        if (Intrinsics.areEqual(getAnchors(), r2) == true) goto L8;
        setAnchors(r2);
        if (trySnapTo(r3) == true) goto L9;
        setDragTarget(r3);
        return;
    L9:
        return;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
    public AnchoredDraggableState(T r1, Function1<? super T, Boolean> r2) {
        this(r1);
        this.confirmValueChange = r2;
    }

    public final Object settle(AnimationSpec<Float> r4, Continuation<? super Unit> r5) {
        T r0 = getCurrentValue();
        T r1 = getAnchors().closestAnchor(requireOffset());
        if (r1 != null) goto L5;
    L11:
        Object r6 = AnchoredDraggableKt.animateTo(this, r0, r4, r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r6;
    L15:
        return Unit.INSTANCE;
    L5:
        if (((Boolean) this.confirmValueChange.invoke(r1)).booleanValue() == false) goto L11;
        Object r7 = AnchoredDraggableKt.animateTo(this, r1, r4, r5);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r7;
    L10:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.")
    public AnchoredDraggableState(T r1, DraggableAnchors<T> r2, Function1<? super T, Boolean> r3) {
        this(r1, r3);
        setAnchors(r2);
        trySnapTo(r1);
    }

    public final Object anchoredDrag(MutatePriority r4, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        Object r7 = this.dragMutex.mutate(r4, new AnonymousClass2(this, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public final Object anchoredDrag(T r6, MutatePriority r7, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r0 = (AnonymousClass3) r9;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
    L22:
        setDragTarget(null);
    L29:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
        if (getAnchors().hasPositionFor(r6) == false) goto L26;
        MutatorMutex r11 = this.dragMutex;     // Catch: Throwable -> L13
        AnonymousClass4 r4 = new AnonymousClass4(this, r6, r8, null);     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        if (r11.mutate(r7, r4, r0) != r2) goto L22;
        return r2;
    L26:
        if (((Boolean) this.confirmValueChange.invoke(r6)).booleanValue() == false) goto L29;
        setSettledValue(r6);
        setCurrentValue(r6);
    L13:
        th = move-exception;
        setDragTarget(null);
        throw th;
    L7:
        r0 = new AnonymousClass3(this, r9);
        goto L8
    }

    public /* synthetic */ AnchoredDraggableState(Object r1, DraggableAnchors r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = new o();
    L5:
        this(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState r0, DraggableAnchors r1, Object r2, int r3, Object r4) {
        if ((r3 & 2) != 0) goto L5;
    L10:
        r0.updateAnchors(r1, r2);
        return;
    L5:
        if (Float.isNaN(r0.getOffset()) == true) goto L9;
        r2 = r1.closestAnchor(r0.getOffset());
        if (r2 != null) goto L10;
        r2 = r0.getTargetValue();
        goto L10
    L9:
        r2 = r0.getTargetValue();
        goto L10
    }

    public AnchoredDraggableState(T r1, DraggableAnchors<T> r2, Function1<? super Float, Float> r3, Function0<Float> r4, AnimationSpec<Float> r5, Function1<? super T, Boolean> r6) {
        this(r1, r6);
        setAnchors(r2);
        setPositionalThreshold$foundation_release(r3);
        setVelocityThreshold$foundation_release(r4);
        setSnapAnimationSpec$foundation_release(r5);
        setDecayAnimationSpec$foundation_release(AnchoredDraggableKt.access$getNoOpDecayAnimationSpec$p());
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState r0, MutatePriority r1, Function3 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return r0.anchoredDrag(r1, r2, r3);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState r0, Object r1, MutatePriority r2, Function4 r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = MutatePriority.Default;
    L6:
        return r0.anchoredDrag(r1, r2, r3, r4);
    }

    public /* synthetic */ AnchoredDraggableState(Object r8, DraggableAnchors r9, Function1 r10, Function0 r11, AnimationSpec r12, Function1 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = new n();
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }
}
