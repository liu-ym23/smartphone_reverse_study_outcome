package androidx.compose.animation.core;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.collection.MutableObjectList;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 Z*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002YZB\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010=\u001a\u00020\u001fH\u0002J\u000e\u0010>\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010?J\u000e\u0010@\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010?J\u000e\u0010A\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010?J\u0018\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\u0018H\u0002J\u0016\u0010E\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010FJ\"\u0010G\u001a\u00020\u001f2\b\b\u0001\u0010!\u001a\u00020 2\b\b\u0002\u0010\u0007\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010HJ\u000e\u0010I\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010?J\u000e\u0010J\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010?J\b\u0010K\u001a\u00020\u001fH\u0002J*\u0010L\u001a\u00020\u001f2\b\b\u0002\u0010\u0007\u001a\u00028\u00002\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010NH\u0086@¢\u0006\u0002\u0010OJ\u001b\u0010P\u001a\u00020\u001f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\u001fH\u0010¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020\u001fH\u0000¢\u0006\u0002\bUJ\r\u0010V\u001a\u00020\u001fH\u0000¢\u0006\u0002\bWJ\b\u0010X\u001a\u00020\u001fH\u0002R+\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R+\u0010\r\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u0005R\u001c\u0010\u0011\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0005R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010!\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020 8G@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "<init>", "(Ljava/lang/Object;)V", "<set-?>", "targetState", "getTargetState", "()Ljava/lang/Object;", "setTargetState$animation_core", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "currentState", "getCurrentState", "setCurrentState$animation_core", "currentState$delegate", "composedTargetState", "getComposedTargetState$animation_core", "setComposedTargetState$animation_core", "Ljava/lang/Object;", "transition", "Landroidx/compose/animation/core/Transition;", "totalDurationNanos", "", "getTotalDurationNanos$animation_core", "()J", "setTotalDurationNanos$animation_core", "(J)V", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "", "", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core", "()Lkotlinx/coroutines/sync/Mutex;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "lastFrameTimeNanos", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "currentAnimation", "firstFrameLambda", "Lkotlin/Function1;", "durationScale", "animateOneFrameLambda", "endAllAnimations", "runAnimations", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "animateOneFrame", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForCompositionAfterTargetStateChange", "waitForComposition", "moveAnimationToInitialState", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core", "transitionRemoved", "transitionRemoved$animation_core", "observeTotalDuration", "observeTotalDuration$animation_core", "onTotalDurationChanged", "onTotalDurationChanged$animation_core", "seekToFraction", "SeekingAnimationState", "Companion", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SeekableTransitionState<S> extends TransitionState<S> {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private static final AnimationVector1D Target1 = null;
    private static final AnimationVector1D ZeroVelocity = null;
    private final Function1<Long, Unit> animateOneFrameLambda;
    private S composedTargetState;
    private kotlinx.coroutines.i<? super S> compositionContinuation;
    private final kotlinx.coroutines.sync.a compositionContinuationMutex;
    private SeekingAnimationState currentAnimation;
    private final MutableState currentState$delegate;
    private float durationScale;
    private final Function1<Long, Unit> firstFrameLambda;
    private final MutableFloatState fraction$delegate;
    private final MutableObjectList<SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos;
    private final MutatorMutex mutatorMutex;
    private final Function0<Unit> recalculateTotalDurationNanos;
    private final MutableState targetState$delegate;
    private long totalDurationNanos;
    private Transition<S> transition;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "<init>", "()V", "ZeroVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "Target1", "getTarget1", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.access$getTarget1$cp();
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.access$getZeroVelocity$cp();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010*\u001a\u00020+H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\t¨\u0006,"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "<init>", "()V", "progressNanos", "", "getProgressNanos", "()J", "setProgressNanos", "(J)V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "value", "", "getValue", "()F", "setValue", "(F)V", "start", "getStart", "()Landroidx/compose/animation/core/AnimationVector1D;", "setStart", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "initialVelocity", "getInitialVelocity", "setInitialVelocity", "durationNanos", "getDurationNanos", "setDurationNanos", "animationSpecDuration", "getAnimationSpecDuration", "setAnimationSpecDuration", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SeekingAnimationState {
        public static final int $stable = 8;
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start;
        private float value;

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }

        public SeekingAnimationState() {
            this.start = new AnimationVector1D(MenuKt.ClosedAlphaTarget);
        }

        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final float getValue() {
            return this.value;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        public final void setAnimationSpec(VectorizedAnimationSpec<AnimationVector1D> r1) {
            this.animationSpec = r1;
        }

        public final void setAnimationSpecDuration(long r1) {
            this.animationSpecDuration = r1;
        }

        public final void setComplete(boolean r1) {
            this.isComplete = r1;
        }

        public final void setDurationNanos(long r1) {
            this.durationNanos = r1;
        }

        public final void setInitialVelocity(AnimationVector1D r1) {
            this.initialVelocity = r1;
        }

        public final void setProgressNanos(long r1) {
            this.progressNanos = r1;
        }

        public final void setStart(AnimationVector1D r1) {
            this.start = r1;
        }

        public final void setValue(float r1) {
            this.value = r1;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", i = {}, l = {600}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", i = {0}, l = {2173, 613, 615, 669, 671}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            public AnonymousClass1(SeekableTransitionState<S> r1, S r2, Transition<S> r3, FiniteAnimationSpec<Float> r4, Continuation<? super AnonymousClass1> r5) {
                this.this$0 = r1;
                this.$targetState = r2;
                this.$transition = r3;
                this.$animationSpec = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r19) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L16;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                if (r2 == 3) goto L13;
                if (r2 == 4) goto L12;
                if (r2 != 5) goto L11;
                ResultKt.throwOnFailure(r19);
            L76:
                SeekableTransitionState.access$setFraction(this.this$0, MenuKt.ClosedAlphaTarget);
            L78:
                return Unit.INSTANCE;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r19);
            L73:
                this.this$0.setCurrentState$animation_core(this.$targetState);
                SeekableTransitionState<S> r3 = this.this$0;
                this.label = 5;
                if (SeekableTransitionState.access$waitForComposition(r3, this) != r0) goto L76;
                return r0;
            L13:
                ResultKt.throwOnFailure(r19);
            L33:
                if (Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState) == true) goto L78;
                if (this.this$0.getFraction() >= 1.0f) goto L70;
                SeekingAnimationState r4 = SeekableTransitionState.access$getCurrentAnimation$p(this.this$0);
                FiniteAnimationSpec<Float> r6 = this.$animationSpec;
                if (r6 == null) goto L39;
                VectorizedAnimationSpec<AnimationVector1D> r7 = r6.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
            L40:
                if (r4 != null) goto L42;
            L43:
                if (r4 == null) goto L45;
                VectorizedAnimationSpec<AnimationVector1D> r12 = r4.getAnimationSpec();
            L46:
                if (r12 == null) goto L51;
                long r13 = r4.getProgressNanos();
                AnimationVector1D r15 = r4.getStart();
                AnimationVector1D r16 = SeekableTransitionState.access$getCompanion$p().getTarget1();
                AnimationVector1D r5 = r4.getInitialVelocity();
                if (r5 != null) goto L50;
                r5 = SeekableTransitionState.access$getCompanion$p().getZeroVelocity();
            L50:
                AnimationVector1D r8 = (AnimationVector1D) r12.getVelocityFromNanos(r13, r15, r16, r5);
            L63:
                if (r4 != null) goto L65;
                r4 = new SeekingAnimationState();
            L65:
                r4.setAnimationSpec(r7);
                r4.setComplete(false);
                r4.setValue(this.this$0.getFraction());
                r4.getStart().set$animation_core(0, this.this$0.getFraction());
                r4.setDurationNanos(this.this$0.getTotalDurationNanos$animation_core());
                r4.setProgressNanos(0);
                r4.setInitialVelocity(r8);
                if (r7 == null) goto L68;
                long r9 = r7.getDurationNanos(r4.getStart(), SeekableTransitionState.access$getCompanion$p().getTarget1(), r8);
            L69:
                r4.setAnimationSpecDuration(r9);
                SeekableTransitionState.access$setCurrentAnimation$p(this.this$0, r4);
                goto L70
            L68:
                r9 = MathKt.roundToLong(this.this$0.getTotalDurationNanos$animation_core() * (1.0d - ((double) this.this$0.getFraction())));
                goto L69
            L51:
                if (r4 != null) goto L53;
            L62:
                r8 = SeekableTransitionState.access$getCompanion$p().getZeroVelocity();
                goto L63
            L53:
                if (r4.getProgressNanos() == 0) goto L62;
                long r14 = r4.getDurationNanos();
                if (r14 != Long.MIN_VALUE) goto L58;
                r14 = this.this$0.getTotalDurationNanos$animation_core();
            L58:
                float r10 = r14 / 1.0E9f;
                if (r10 > MenuKt.ClosedAlphaTarget) goto L61;
                r8 = SeekableTransitionState.access$getCompanion$p().getZeroVelocity();
                goto L63
            L61:
                r8 = new AnimationVector1D(1.0f / r10);
                goto L63
            L45:
                r12 = null;
                goto L46
            L42:
                if (Intrinsics.areEqual(r7, r4.getAnimationSpec()) == true) goto L70;
            L39:
                r7 = null;
            L70:
                SeekableTransitionState<S> r11 = this.this$0;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 4;
                if (SeekableTransitionState.access$runAnimations(r11, this) != r0) goto L73;
                return r0;
            L14:
                ResultKt.throwOnFailure(r19);
            L29:
                SeekableTransitionState<S> r17 = this.this$0;
                this.label = 3;
                if (SeekableTransitionState.access$waitForCompositionAfterTargetStateChange(r17, this) != r0) goto L33;
                return r0;
            L15:
                SeekableTransitionState<S> r18 = (SeekableTransitionState) this.L$1;
                kotlinx.coroutines.sync.a r20 = (kotlinx.coroutines.sync.a) this.L$0;
                ResultKt.throwOnFailure(r19);
            L82:
                S r21 = r18.getComposedTargetState$animation_core();     // Catch: Throwable -> L79
                r20.unlock(null);
                if (Intrinsics.areEqual(this.$targetState, r21) == true) goto L33;
                SeekableTransitionState<S> r22 = this.this$0;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (SeekableTransitionState.access$doOneFrame(r22, this) != r0) goto L29;
                return r0;
            L79:
                th = move-exception;
                r20.unlock(null);
                throw th;
            L16:
                ResultKt.throwOnFailure(r19);
                S r23 = this.this$0.getTargetState();
                if (Intrinsics.areEqual(this.$targetState, r23) == true) goto L19;
                SeekableTransitionState.access$moveAnimationToInitialState(this.this$0);
                SeekableTransitionState.access$setFraction(this.this$0, MenuKt.ClosedAlphaTarget);
                this.$transition.updateTarget$animation_core(this.$targetState);
                this.$transition.setPlayTimeNanos(0);
                this.this$0.setCurrentState$animation_core(r23);
                this.this$0.setTargetState$animation_core(this.$targetState);
            L19:
                kotlinx.coroutines.sync.a r24 = this.this$0.getCompositionContinuationMutex$animation_core();
                SeekableTransitionState<S> r110 = this.this$0;
                this.L$0 = r24;
                this.L$1 = r110;
                this.label = 1;
                if (r24.a(null, this) != r0) goto L22;
                return r0;
            L22:
                r20 = r24;
                r18 = r110;
                goto L82
            }
        }

        public AnonymousClass2(Transition<S> r1, SeekableTransitionState<S> r2, S r3, FiniteAnimationSpec<Float> r4, Continuation<? super AnonymousClass2> r5) {
            this.$transition = r1;
            this.this$0 = r2;
            this.$targetState = r3;
            this.$animationSpec = r4;
            super(1, r5);
        }

        public final Continuation<Unit> create(Continuation<?> r8) {
            return new AnonymousClass2(this.$transition, this.this$0, this.$targetState, this.$animationSpec, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            this.$transition.onTransitionEnd$animation_core();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AnonymousClass1 r11 = new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(r11, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$runAnimations$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {}, l = {354, 357}, m = "runAnimations", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        public AnonymousClass1(SeekableTransitionState<S> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SeekableTransitionState.access$runAnimations(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", f = "Transition.kt", i = {}, l = {489}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $fraction;
        final /* synthetic */ S $oldTargetState;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", f = "Transition.kt", i = {}, l = {511}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ float $fraction;
            final /* synthetic */ S $oldTargetState;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1", f = "Transition.kt", i = {}, l = {507}, m = "invokeSuspend", n = {}, s = {})
            public static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SeekableTransitionState<S> this$0;

                public C00061(SeekableTransitionState<S> r1, Continuation<? super C00061> r2) {
                    this.this$0 = r1;
                    super(2, r2);
                }

                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    return new C00061(this.this$0, r3);
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
                L12:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r4);
                    SeekableTransitionState<S> r5 = this.this$0;
                    this.label = 1;
                    if (SeekableTransitionState.access$runAnimations(r5, this) != r0) goto L12;
                    return r0;
                }
            }

            public AnonymousClass1(S r1, S r2, SeekableTransitionState<S> r3, Transition<S> r4, float r5, Continuation<? super AnonymousClass1> r6) {
                this.$targetState = r1;
                this.$oldTargetState = r2;
                this.this$0 = r3;
                this.$transition = r4;
                this.$fraction = r5;
                super(2, r6);
            }

            public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
                AnonymousClass1 r7 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, r10);
                r7.L$0 = r9;
                return r7;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r10);
            L25:
                SeekableTransitionState.access$seekToFraction(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                CoroutineScope r3 = (CoroutineScope) this.L$0;
                if (Intrinsics.areEqual(this.$targetState, this.$oldTargetState) == true) goto L11;
                SeekableTransitionState.access$moveAnimationToInitialState(this.this$0);
            L16:
                if (Intrinsics.areEqual(this.$targetState, this.$oldTargetState) == true) goto L18;
                this.$transition.updateTarget$animation_core(this.$targetState);
                this.$transition.setPlayTimeNanos(0);
                this.this$0.setTargetState$animation_core(this.$targetState);
                this.$transition.resetAnimationFraction$animation_core(this.$fraction);
            L18:
                SeekableTransitionState.access$setFraction(this.this$0, this.$fraction);
                if (SeekableTransitionState.access$getInitialValueAnimations$p(this.this$0).isNotEmpty() == false) goto L21;
                BuildersKt.launch$default(r3, null, null, new C00061(this.this$0, null), 3, null);
            L22:
                SeekableTransitionState<S> r11 = this.this$0;
                this.label = 1;
                if (SeekableTransitionState.access$waitForCompositionAfterTargetStateChange(r11, this) != r0) goto L25;
                return r0;
            L21:
                SeekableTransitionState.access$setLastFrameTimeNanos$p(this.this$0, Long.MIN_VALUE);
                goto L22
            L11:
                SeekableTransitionState.access$setCurrentAnimation$p(this.this$0, null);
                if (Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState) == false) goto L16;
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(S r1, S r2, SeekableTransitionState<S> r3, Transition<S> r4, float r5, Continuation<? super AnonymousClass3> r6) {
            this.$targetState = r1;
            this.$oldTargetState = r2;
            this.this$0 = r3;
            this.$transition = r4;
            this.$fraction = r5;
            super(1, r6);
        }

        public final Continuation<Unit> create(Continuation<?> r9) {
            return new AnonymousClass3(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
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
            AnonymousClass1 r12 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(r12, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", f = "Transition.kt", i = {}, l = {458}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01142 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        public C01142(SeekableTransitionState<S> r1, S r2, Transition<S> r3, Continuation<? super C01142> r4) {
            this.this$0 = r1;
            this.$targetState = r2;
            this.$transition = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new C01142(this.this$0, this.$targetState, this.$transition, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L23:
            this.$transition.onTransitionEnd$animation_core();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            SeekableTransitionState.access$endAllAnimations(this.this$0);
            SeekableTransitionState.access$setLastFrameTimeNanos$p(this.this$0, Long.MIN_VALUE);
            SeekableTransitionState.access$setFraction(this.this$0, MenuKt.ClosedAlphaTarget);
            S r9 = this.$targetState;
            if (Intrinsics.areEqual(r9, this.this$0.getCurrentState()) == false) goto L12;
            float r10 = -4.0f;
        L15:
            this.$transition.updateTarget$animation_core(this.$targetState);
            this.$transition.setPlayTimeNanos(0);
            this.this$0.setTargetState$animation_core(this.$targetState);
            SeekableTransitionState.access$setFraction(this.this$0, MenuKt.ClosedAlphaTarget);
            this.this$0.setCurrentState$animation_core(this.$targetState);
            this.$transition.resetAnimationFraction$animation_core(r10);
            if (r10 != (-3.0f)) goto L18;
            boolean r11 = true;
        L19:
            if (r11 == false) goto L23;
            SeekableTransitionState<S> r12 = this.this$0;
            this.label = 1;
            if (SeekableTransitionState.access$waitForCompositionAfterTargetStateChange(r12, this) != r0) goto L23;
            return r0;
        L18:
            r11 = false;
            goto L19
        L12:
            if (Intrinsics.areEqual(r9, this.this$0.getTargetState()) == false) goto L14;
            r10 = -5.0f;
            goto L15
        L14:
            r10 = -3.0f;
            goto L15
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 1}, l = {544, 2169}, m = "waitForComposition", n = {"expectedState", "expectedState"}, s = {"L$0", "L$0"})
    public static final class C01151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        public C01151(SeekableTransitionState<S> r1, Continuation<? super C01151> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SeekableTransitionState.access$waitForComposition(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 1}, l = {520, 2169}, m = "waitForCompositionAfterTargetStateChange", n = {"expectedState", "expectedState"}, s = {"L$0", "L$0"})
    public static final class C01161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        public C01161(SeekableTransitionState<S> r1, Continuation<? super C01161> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return SeekableTransitionState.access$waitForCompositionAfterTargetStateChange(this.this$0, this);
        }
    }

    public static /* synthetic */ Unit a(SeekableTransitionState r0) {
        return recalculateTotalDurationNanos$lambda$0(r0);
    }

    public static /* synthetic */ Unit b(SeekableTransitionState r0, long r1) {
        return firstFrameLambda$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit c(SeekableTransitionState r0, long r1) {
        return animateOneFrameLambda$lambda$4(r0, r1);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        ZeroVelocity = new AnimationVector1D(MenuKt.ClosedAlphaTarget);
        Target1 = new AnimationVector1D(1.0f);
    }

    private final void endAllAnimations() {
        Transition<S> r0 = this.transition;
        if (r0 == null) goto L5;
        r0.clearInitialAnimations$animation_core();
    L5:
        this.initialValueAnimations.clear();
        if (this.currentAnimation == null) goto L9;
        this.currentAnimation = null;
        setFraction(1.0f);
        seekToFraction();
        return;
    }

    private final void moveAnimationToInitialState() {
        Transition<S> r0 = this.transition;
        if (r0 != null) goto L5;
        return;
    L5:
        SeekingAnimationState r1 = this.currentAnimation;
        if (r1 == null) goto L8;
    L19:
        if (r1 == null) goto L21;
        r1.setDurationNanos(this.totalDurationNanos);
        this.initialValueAnimations.add(r1);
        r0.setInitialAnimations$animation_core(r1);
    L21:
        this.currentAnimation = null;
        return;
    L8:
        if (this.totalDurationNanos > 0) goto L10;
    L18:
        r1 = null;
        goto L19
    L10:
        if (getFraction() != 1.0f) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L18;
        if (Intrinsics.areEqual(getCurrentState(), getTargetState()) == true) goto L18;
        r1 = new SeekingAnimationState();
        r1.setValue(getFraction());
        long r5 = this.totalDurationNanos;
        r1.setDurationNanos(r5);
        r1.setAnimationSpecDuration(MathKt.roundToLong(r5 * (1.0d - ((double) getFraction()))));
        r1.getStart().set$animation_core(0, getFraction());
        goto L19
    L12:
        r2 = false;
        goto L13
    }

    private final void seekToFraction() {
        Transition<S> r0 = this.transition;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.seekAnimations$animation_core(MathKt.roundToLong(((double) getFraction()) * r0.getTotalDurationNanos()));
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState$delegate.getValue();
    }

    public final float getFraction() {
        return this.fraction$delegate.getFloatValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    public final void onTotalDurationChanged$animation_core() {
        long r0 = this.totalDurationNanos;
        observeTotalDuration$animation_core();
        long r2 = this.totalDurationNanos;
        if (r0 == r2) goto L16;
        SeekingAnimationState r1 = this.currentAnimation;
        if (r1 == null) goto L13;
        long r3 = r1.getProgressNanos();
        long r4 = this.totalDurationNanos;
        if (r3 <= r4) goto L9;
        endAllAnimations();
        return;
    L9:
        r1.setDurationNanos(r4);
        if (r1.getAnimationSpec() != null) goto L18;
        r1.setAnimationSpecDuration(MathKt.roundToLong((1.0d - ((double) r1.getStart().get$animation_core(0))) * this.totalDurationNanos));
        return;
    L18:
        return;
    L13:
        if (r2 == 0) goto L20;
        seekToFraction();
        return;
    L20:
        return;
    }

    public final void observeTotalDuration$animation_core() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.access$getSeekableTransitionStateTotalDurationChanged$p(), this.recalculateTotalDurationNanos);
    }

    public static final /* synthetic */ Companion access$getCompanion$p() {
        return Companion;
    }

    public static final /* synthetic */ AnimationVector1D access$getTarget1$cp() {
        return Target1;
    }

    public static final /* synthetic */ AnimationVector1D access$getZeroVelocity$cp() {
        return ZeroVelocity;
    }

    public final S getComposedTargetState$animation_core() {
        return this.composedTargetState;
    }

    public final kotlinx.coroutines.i<S> getCompositionContinuation$animation_core() {
        return this.compositionContinuation;
    }

    public final kotlinx.coroutines.sync.a getCompositionContinuationMutex$animation_core() {
        return this.compositionContinuationMutex;
    }

    public final long getTotalDurationNanos$animation_core() {
        return this.totalDurationNanos;
    }

    public SeekableTransitionState(S r4) {
        super(null);
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        this.currentState$delegate = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        this.composedTargetState = r4;
        this.recalculateTotalDurationNanos = new q(this);
        this.fraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.compositionContinuationMutex = kotlinx.coroutines.sync.b.a();
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList(0, 1, null);
        this.firstFrameLambda = new r(this);
        this.animateOneFrameLambda = new s(this);
    }

    public static final /* synthetic */ void access$endAllAnimations(SeekableTransitionState r0) {
        r0.endAllAnimations();
    }

    public static final /* synthetic */ SeekingAnimationState access$getCurrentAnimation$p(SeekableTransitionState r0) {
        return r0.currentAnimation;
    }

    public static final /* synthetic */ MutableObjectList access$getInitialValueAnimations$p(SeekableTransitionState r0) {
        return r0.initialValueAnimations;
    }

    public static final /* synthetic */ void access$moveAnimationToInitialState(SeekableTransitionState r0) {
        r0.moveAnimationToInitialState();
    }

    public static final /* synthetic */ void access$seekToFraction(SeekableTransitionState r0) {
        r0.seekToFraction();
    }

    private final Object animateOneFrame(Continuation<? super Unit> r3) {
        float r0 = SuspendAnimationKt.getDurationScale(r3.getContext());
        if (r0 > MenuKt.ClosedAlphaTarget) goto L6;
        endAllAnimations();
        return Unit.INSTANCE;
    L6:
        this.durationScale = r0;
        Object r4 = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r4;
    L10:
        return Unit.INSTANCE;
    }

    private final Object doOneFrame(Continuation<? super Unit> r6) {
        if (this.lastFrameTimeNanos != Long.MIN_VALUE) goto L9;
        Object r7 = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r7;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r8 = animateOneFrame(r6);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r8;
    L13:
        return Unit.INSTANCE;
    }

    private static final Unit recalculateTotalDurationNanos$lambda$0(SeekableTransitionState r2) {
        Transition<S> r0 = r2.transition;
        if (r0 == null) goto L5;
        long r1 = r0.getTotalDurationNanos();
    L6:
        r2.totalDurationNanos = r1;
        return Unit.INSTANCE;
    L5:
        r1 = 0;
        goto L6
    }

    private final Object runAnimations(Continuation<? super Unit> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 == 1) goto L12;
        if (r3 == 2) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r11);
    L35:
        if (this.initialValueAnimations.isNotEmpty() == false) goto L37;
    L41:
        r0.label = 2;
        if (animateOneFrame(r0) != r2) goto L35;
        return r2;
    L37:
        if (this.currentAnimation != null) goto L41;
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r11);
        if (this.initialValueAnimations.isEmpty() == false) goto L22;
        if (this.currentAnimation != null) goto L22;
        return Unit.INSTANCE;
    L22:
        if (SuspendAnimationKt.getDurationScale(r0.getContext()) != MenuKt.ClosedAlphaTarget) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == false) goto L29;
        endAllAnimations();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        return Unit.INSTANCE;
    L29:
        if (this.lastFrameTimeNanos != Long.MIN_VALUE) goto L35;
        Function1<Long, Unit> r13 = this.firstFrameLambda;
        r0.label = 1;
        if (MonotonicFrameClockKt.withFrameNanos(r13, r0) != r2) goto L35;
        return r2;
    L24:
        r12 = false;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    private final void setFraction(float r2) {
        this.fraction$delegate.setFloatValue(r2);
    }

    private final Object waitForComposition(Continuation<? super Unit> r7) {
        if ((r7 instanceof C01151) == false) goto L7;
        C01151 r0 = (C01151) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Object r4 = r0.L$0;
        ResultKt.throwOnFailure(r8);
    L26:
        if (Intrinsics.areEqual(r8, r4) == true) goto L28;
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        throw new CancellationException("targetState while waiting for composition");
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Object r5 = r0.L$0;
        ResultKt.throwOnFailure(r8);
        Object r9 = r5;
    L19:
        r0.L$0 = r9;
        r0.label = 2;
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r6.C();
        setCompositionContinuation$animation_core(r6);
        getCompositionContinuationMutex$animation_core().unlock(null);
        Object r10 = r6.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L22:
        if (r10 != r2) goto L24;
        return r2;
    L24:
        r4 = r9;
        r8 = r10;
        goto L26
    L16:
        ResultKt.throwOnFailure(r8);
        r9 = getTargetState();
        kotlinx.coroutines.sync.a r11 = this.compositionContinuationMutex;
        r0.L$0 = r9;
        r0.label = 1;
        if (r11.a(null, r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new C01151(this, r7);
        goto L8
    }

    private final Object waitForCompositionAfterTargetStateChange(Continuation<? super Unit> r7) {
        if ((r7 instanceof C01161) == false) goto L7;
        C01161 r0 = (C01161) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Object r4 = r0.L$0;
        ResultKt.throwOnFailure(r8);
    L29:
        if (Intrinsics.areEqual(r8, r4) == true) goto L31;
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        throw new CancellationException("snapTo() was canceled because state was changed to " + r8 + " instead of " + r4);
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Object r5 = r0.L$0;
        ResultKt.throwOnFailure(r8);
        Object r9 = r5;
    L20:
        if (Intrinsics.areEqual(r9, this.composedTargetState) == false) goto L22;
        this.compositionContinuationMutex.unlock(null);
        goto L31
    L22:
        r0.L$0 = r9;
        r0.label = 2;
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r6.C();
        setCompositionContinuation$animation_core(r6);
        getCompositionContinuationMutex$animation_core().unlock(null);
        Object r10 = r6.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L25:
        if (r10 != r2) goto L27;
        return r2;
    L27:
        r4 = r9;
        r8 = r10;
        goto L29
    L16:
        ResultKt.throwOnFailure(r8);
        r9 = getTargetState();
        kotlinx.coroutines.sync.a r11 = this.compositionContinuationMutex;
        r0.L$0 = r9;
        r0.label = 1;
        if (r11.a(null, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new C01161(this, r7);
        goto L8
    }

    public final void setComposedTargetState$animation_core(S r1) {
        this.composedTargetState = r1;
    }

    public final void setCompositionContinuation$animation_core(kotlinx.coroutines.i<? super S> r1) {
        this.compositionContinuation = r1;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core(S r2) {
        this.currentState$delegate.setValue(r2);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setTargetState$animation_core(S r2) {
        this.targetState$delegate.setValue(r2);
    }

    public final void setTotalDurationNanos$animation_core(long r1) {
        this.totalDurationNanos = r1;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core(Transition<S> r3) {
        Transition<S> r0 = this.transition;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + r3);
    L11:
        this.transition = r3;
        return;
    L5:
        if (Intrinsics.areEqual(r3, r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ Object access$animateOneFrame(SeekableTransitionState r0, Continuation r1) {
        return r0.animateOneFrame(r1);
    }

    public static final /* synthetic */ Object access$doOneFrame(SeekableTransitionState r0, Continuation r1) {
        return r0.doOneFrame(r1);
    }

    public static final /* synthetic */ Object access$runAnimations(SeekableTransitionState r0, Continuation r1) {
        return r0.runAnimations(r1);
    }

    public static final /* synthetic */ void access$setCurrentAnimation$p(SeekableTransitionState r0, SeekingAnimationState r1) {
        r0.currentAnimation = r1;
    }

    public static final /* synthetic */ void access$setFraction(SeekableTransitionState r0, float r1) {
        r0.setFraction(r1);
    }

    public static final /* synthetic */ void access$setLastFrameTimeNanos$p(SeekableTransitionState r0, long r1) {
        r0.lastFrameTimeNanos = r1;
    }

    public static final /* synthetic */ Object access$waitForComposition(SeekableTransitionState r0, Continuation r1) {
        return r0.waitForComposition(r1);
    }

    public static final /* synthetic */ Object access$waitForCompositionAfterTargetStateChange(SeekableTransitionState r0, Continuation r1) {
        return r0.waitForCompositionAfterTargetStateChange(r1);
    }

    private static final Unit animateOneFrameLambda$lambda$4(SeekableTransitionState r11, long r12) {
        long r0 = r12 - r11.lastFrameTimeNanos;
        r11.lastFrameTimeNanos = r12;
        long r13 = MathKt.roundToLong(r0 / ((double) r11.durationScale));
        boolean r2 = false;
        if (r11.initialValueAnimations.isNotEmpty() == false) goto L18;
        MutableObjectList<SeekingAnimationState> r1 = r11.initialValueAnimations;
        Object[] r4 = r1.content;
        int r3 = r1._size;
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        SeekingAnimationState r6 = (SeekingAnimationState) r4[r5];
        r11.recalculateAnimationValue(r6, r13);
        r6.setComplete(true);
        r5 = r5 + 1;
        goto L5
    L7:
        Transition<S> r7 = r11.transition;
        if (r7 == null) goto L10;
        r7.updateInitialValues$animation_core();
    L10:
        MutableObjectList<SeekingAnimationState> r8 = r11.initialValueAnimations;
        int r9 = r8._size;
        Object[] r10 = r8.content;
        IntRange r14 = RangesKt.until(0, r9);
        int r15 = r14.getFirst();
        int r16 = r14.getLast();
        int r17 = 0;
        if (r15 > r16) goto L17;
    L12:
        r10[r15 - r17] = r10[r15];
        if (((SeekingAnimationState) r10[r15]).isComplete() == false) goto L15;
        r17 = r17 + 1;
    L15:
        if (r15 == r16) goto L17;
        r15 = r15 + 1;
    L17:
        ArraysKt.fill(r10, null, r9 - r17, r9);
        r8._size -= r17;
    L18:
        SeekingAnimationState r18 = r11.currentAnimation;
        if (r18 == null) goto L27;
        r18.setDurationNanos(r11.totalDurationNanos);
        r11.recalculateAnimationValue(r18, r13);
        r11.setFraction(r18.getValue());
        if (r18.getValue() != 1.0f) goto L23;
        r2 = true;
    L23:
        if (r2 == false) goto L25;
        r11.currentAnimation = null;
    L25:
        r11.seekToFraction();
    L27:
        return Unit.INSTANCE;
    }

    private static final Unit firstFrameLambda$lambda$1(SeekableTransitionState r0, long r1) {
        r0.lastFrameTimeNanos = r1;
        return Unit.INSTANCE;
    }

    private final void recalculateAnimationValue(SeekingAnimationState r9, long r10) {
        long r3 = r9.getProgressNanos() + r10;
        r9.setProgressNanos(r3);
        long r11 = r9.getAnimationSpecDuration();
        if (r3 < r11) goto L5;
        r9.setValue(1.0f);
        return;
    L5:
        VectorizedAnimationSpec<AnimationVector1D> r2 = r9.getAnimationSpec();
        if (r2 == null) goto L11;
        AnimationVector1D r5 = r9.getStart();
        AnimationVector1D r6 = Target1;
        AnimationVector1D r12 = r9.getInitialVelocity();
        if (r12 != null) goto L10;
        r12 = ZeroVelocity;
    L10:
        r9.setValue(RangesKt.coerceIn(((AnimationVector1D) r2.getValueFromNanos(r3, r5, r6, r12)).get$animation_core(0), MenuKt.ClosedAlphaTarget, 1.0f));
        return;
    L11:
        float r4 = r3 / r11;
        r9.setValue((r9.getStart().get$animation_core(0) * (1 - r4)) + (r4 * 1.0f));
    }

    public final Object snapTo(S r7, Continuation<? super Unit> r8) {
        Transition<S> r0 = this.transition;
        if (r0 != null) goto L7;
        return Unit.INSTANCE;
    L7:
        if (Intrinsics.areEqual(getCurrentState(), r7) == true) goto L9;
    L12:
        Object r9 = MutatorMutex.mutate$default(this.mutatorMutex, null, new C01142(this, r7, r0, null), r8, 1, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r9;
    L16:
        return Unit.INSTANCE;
    L9:
        if (Intrinsics.areEqual(getTargetState(), r7) == false) goto L12;
        return Unit.INSTANCE;
    }

    public final Object animateTo(S r10, FiniteAnimationSpec<Float> r11, Continuation<? super Unit> r12) {
        Transition<S> r1 = this.transition;
        if (r1 == null) goto L5;
        Object r13 = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(r1, this, r10, r11, null), r12, 1, null);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r13;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object seekTo(float r13, S r14, Continuation<? super Unit> r15) {
        boolean r1 = false;
        if (MenuKt.ClosedAlphaTarget <= r13) goto L5;
    L7:
        if (r1 == true) goto L9;
        PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + r13);
    L9:
        Transition<S> r5 = this.transition;
        if (r5 == null) goto L12;
        Object r16 = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass3(r14, getTargetState(), this, r5, r13, null), r15, 1, null);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r16;
    L17:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L5:
        if (r13 > 1.0f) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SeekableTransitionState r0, Object r1, FiniteAnimationSpec r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getTargetState();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        return r0.animateTo(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object seekTo$default(SeekableTransitionState r0, float r1, Object r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.getTargetState();
    L6:
        return r0.seekTo(r1, r2, r3);
    }
}
