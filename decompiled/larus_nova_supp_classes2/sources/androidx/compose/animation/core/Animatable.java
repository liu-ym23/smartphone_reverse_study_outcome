package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B;\b\u0007\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB1\b\u0017\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\rJ#\u0010>\u001a\u00020?2\n\b\u0002\u0010,\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010.\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010@Je\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0006\u0010'\u001a\u00028\u00002\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D2\b\b\u0002\u0010E\u001a\u00028\u00002'\b\u0002\u0010F\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0086@¢\u0006\u0002\u0010IJY\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0006\u0010E\u001a\u00028\u00002\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000K2'\b\u0002\u0010F\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0086@¢\u0006\u0002\u0010LJ]\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O2\u0006\u0010E\u001a\u00028\u00002%\u0010F\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0082@¢\u0006\u0002\u0010PJ\u0015\u0010Q\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020?H\u0002J\u0016\u0010T\u001a\u00020?2\u0006\u0010'\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010UJ\u000e\u0010V\u001a\u00020?H\u0086@¢\u0006\u0002\u0010WJ\f\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000YR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R+\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010'\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b-\u0010\u0019R$\u0010.\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b/\u0010\u0019R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u00106\u001a\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u00109\u0012\u0004\b7\u00108R\u0016\u0010:\u001a\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u00109\u0012\u0004\b;\u00108R\u0010\u0010<\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u0010\u0010=\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u00109¨\u0006Z"}, d2 = {"Landroidx/compose/animation/core/Animatable;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThreshold", "label", "", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/Object;", "getLabel", "()Ljava/lang/String;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core", "()Landroidx/compose/animation/core/AnimationState;", "value", "getValue", "()Ljava/lang/Object;", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "velocity", "getVelocity", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "targetValue", "getTargetValue", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "lowerBound", "getLowerBound", "upperBound", "getUpperBound", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core", "()Landroidx/compose/animation/core/SpringSpec;", "negativeInfinityBounds", "getNegativeInfinityBounds$annotations", "()V", "Landroidx/compose/animation/core/AnimationVector;", "positiveInfinityBounds", "getPositiveInfinityBounds$annotations", "lowerBoundVector", "upperBoundVector", "updateBounds", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "animateTo", "Landroidx/compose/animation/core/AnimationResult;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "initialVelocity", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runAnimation", "animation", "Landroidx/compose/animation/core/Animation;", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Animatable<T, V extends AnimationVector> {
    public static final int $stable = 8;
    private final SpringSpec<T> defaultSpringSpec;
    private final AnimationState<T, V> internalState;
    private final MutableState isRunning$delegate;
    private final String label;
    private T lowerBound;
    private V lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final V negativeInfinityBounds;
    private final V positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final TwoWayConverter<T, V> typeConverter;
    private T upperBound;
    private V upperBoundVector;
    private final T visibilityThreshold;

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$runAnimation$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", i = {0, 0}, l = {308}, m = "invokeSuspend", n = {"endState", "clampingNeeded"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<T, V>>, Object> {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ Function1<Animatable<T, V>, Unit> $block;
        final /* synthetic */ T $initialVelocity;
        final /* synthetic */ long $startTime;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Animatable<T, V> r1, T r2, Animation<T, V> r3, long r4, Function1<? super Animatable<T, V>, Unit> r6, Continuation<? super AnonymousClass2> r7) {
            this.this$0 = r1;
            this.$initialVelocity = r2;
            this.$animation = r3;
            this.$startTime = r4;
            this.$block = r6;
            super(1, r7);
        }

        public static /* synthetic */ Unit a(Animatable r0, AnimationState r1, Function1 r2, Ref.BooleanRef r3, AnimationScope r4) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r10) {
            return new AnonymousClass2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super AnimationResult<T, V>> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$1;
            AnimationState r3 = (AnimationState) this.L$0;
            ResultKt.throwOnFailure(r19);     // Catch: CancellationException -> L21
        L16:
            if (r2.element == false) goto L18;
            AnimationEndReason r4 = AnimationEndReason.BoundReached;     // Catch: CancellationException -> L21
        L19:
            Animatable.access$endAnimation(this.this$0);     // Catch: CancellationException -> L21
            return new AnimationResult(r3, r4);
        L18:
            r4 = AnimationEndReason.Finished;     // Catch: CancellationException -> L21
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r19);
            this.this$0.getInternalState$animation_core().setVelocityVector$animation_core((AnimationVector) this.this$0.getTypeConverter().getConvertToVector().invoke(this.$initialVelocity));     // Catch: CancellationException -> L21
            Animatable.access$setTargetValue(this.this$0, this.$animation.getTargetValue());     // Catch: CancellationException -> L21
            Animatable.access$setRunning(this.this$0, true);     // Catch: CancellationException -> L21
            final AnimationState r8 = AnimationStateKt.copy$default(this.this$0.getInternalState$animation_core(), null, null, 0, Long.MIN_VALUE, false, 23, null);     // Catch: CancellationException -> L21
            final Ref.BooleanRef r9 = new Ref.BooleanRef();     // Catch: CancellationException -> L21
            Animation<T, V> r5 = this.$animation;     // Catch: CancellationException -> L21
            long r6 = this.$startTime;     // Catch: CancellationException -> L21
            final Animatable<T, V> r7 = this.this$0;     // Catch: CancellationException -> L21
            final Function1<Animatable<T, V>, Unit> r10 = this.$block;     // Catch: CancellationException -> L21
            Function1 r11 = new a(r7, r8, r10, r9);     // Catch: CancellationException -> L21
            this.L$0 = r8;     // Catch: CancellationException -> L21
            this.L$1 = r9;     // Catch: CancellationException -> L21
            this.label = 1;     // Catch: CancellationException -> L21
            if (SuspendAnimationKt.animate(r8, r5, r6, r11, this) != r0) goto L14;
            return r0;
        L14:
            r3 = r8;
            r2 = r9;
        L21:
            e = move-exception;
            Animatable.access$endAnimation(this.this$0);
            throw e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final Unit invokeSuspend$lambda$0(Animatable r2, AnimationState r3, Function1 r4, Ref.BooleanRef r5, AnimationScope r6) {
            SuspendAnimationKt.updateState(r6, r2.getInternalState$animation_core());
            Object r0 = Animatable.access$clampToBounds(r2, r6.getValue());
            if (Intrinsics.areEqual(r0, r6.getValue()) == true) goto L8;
            r2.getInternalState$animation_core().setValue$animation_core(r0);
            r3.setValue$animation_core(r0);
            if (r4 == null) goto L7;
            r4.invoke(r2);
        L7:
            r6.cancelAnimation();
            r5.element = true;
        L11:
            return Unit.INSTANCE;
        L8:
            if (r4 == null) goto L11;
            r4.invoke(r2);
            goto L11
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.Animatable$snapTo$2", f = "Animatable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01102 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        public C01102(Animatable<T, V> r1, T r2, Continuation<? super C01102> r3) {
            this.this$0 = r1;
            this.$targetValue = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new C01102(this.this$0, this.$targetValue, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            Animatable.access$endAnimation(this.this$0);
            Object r3 = Animatable.access$clampToBounds(this.this$0, this.$targetValue);
            this.this$0.getInternalState$animation_core().setValue$animation_core(r3);
            Animatable.access$setTargetValue(this.this$0, r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$stop$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.Animatable$stop$2", f = "Animatable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01112 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        public C01112(Animatable<T, V> r1, Continuation<? super C01112> r2) {
            this.this$0 = r1;
            super(1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r3) {
            return new C01112(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            Animatable.access$endAnimation(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static /* synthetic */ void getNegativeInfinityBounds$annotations() {
    }

    private static /* synthetic */ void getPositiveInfinityBounds$annotations() {
    }

    private final void endAnimation() {
        AnimationState<T, V> r0 = this.internalState;
        r0.getVelocityVector().reset$animation_core();
        r0.setLastFrameTimeNanos$animation_core(Long.MIN_VALUE);
        setRunning(false);
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final T getVelocity() {
        return (T) this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    public final V getVelocityVector() {
        return (V) this.internalState.getVelocityVector();
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final State<T> asState() {
        return this.internalState;
    }

    public final SpringSpec<T> getDefaultSpringSpec$animation_core() {
        return this.defaultSpringSpec;
    }

    public final AnimationState<T, V> getInternalState$animation_core() {
        return this.internalState;
    }

    public final String getLabel() {
        return this.label;
    }

    public final T getLowerBound() {
        return this.lowerBound;
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getUpperBound() {
        return this.upperBound;
    }

    public static final /* synthetic */ void access$endAnimation(Animatable r0) {
        r0.endAnimation();
    }

    private final T clampToBounds(T r7) {
        if (Intrinsics.areEqual(this.lowerBoundVector, this.negativeInfinityBounds) == true) goto L5;
    L7:
        AnimationVector r0 = (AnimationVector) this.typeConverter.getConvertToVector().invoke(r7);
        int r1 = r0.getSize$animation_core();
        int r2 = 0;
        boolean r3 = false;
    L8:
        if (r2 >= r1) goto L15;
        if (r0.get$animation_core(r2) >= this.lowerBoundVector.get$animation_core(r2)) goto L12;
    L13:
        r0.set$animation_core(r2, RangesKt.coerceIn(r0.get$animation_core(r2), this.lowerBoundVector.get$animation_core(r2), this.upperBoundVector.get$animation_core(r2)));
        r3 = true;
    L14:
        r2 = r2 + 1;
        goto L8
    L12:
        if (r0.get$animation_core(r2) <= this.upperBoundVector.get$animation_core(r2)) goto L14;
    L15:
        if (r3 == true) goto L17;
        return r7;
    L17:
        return (T) this.typeConverter.getConvertFromVector().invoke(r0);
    L5:
        if (Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds) == false) goto L7;
        return r7;
    }

    private final void setRunning(boolean r2) {
        this.isRunning$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setTargetValue(T r2) {
        this.targetValue$delegate.setValue(r2);
    }

    public final Object stop(Continuation<? super Unit> r7) {
        Object r8 = MutatorMutex.mutate$default(this.mutatorMutex, null, new C01112(this, null), r7, 1, null);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$clampToBounds(Animatable r0, Object r1) {
        return r0.clampToBounds(r1);
    }

    public static final /* synthetic */ void access$setRunning(Animatable r0, boolean r1) {
        r0.setRunning(r1);
    }

    public static final /* synthetic */ void access$setTargetValue(Animatable r0, Object r1) {
        r0.setTargetValue(r1);
    }

    public final Object snapTo(T r7, Continuation<? super Unit> r8) {
        Object r9 = MutatorMutex.mutate$default(this.mutatorMutex, null, new C01102(this, r7, null), r8, 1, null);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r9;
    L6:
        return Unit.INSTANCE;
    }

    public final void updateBounds(T r8, T r9) {
        if (r8 == null) goto L5;
        V r0 = (V) this.typeConverter.getConvertToVector().invoke(r8);
        if (r0 == null) goto L5;
    L6:
        if (r9 == null) goto L9;
        V r1 = (V) this.typeConverter.getConvertToVector().invoke(r9);
        if (r1 == null) goto L9;
    L10:
        int r2 = r0.getSize$animation_core();
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L19;
        if (r0.get$animation_core(r4) > r1.get$animation_core(r4)) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L18;
        PreconditionsKt.throwIllegalStateException("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + r0 + " is greater than upper bound " + r1 + " on index " + r4);
    L18:
        r4 = r4 + 1;
        goto L11
    L15:
        r5 = false;
        goto L16
    L19:
        this.lowerBoundVector = r0;
        this.upperBoundVector = r1;
        this.upperBound = r9;
        this.lowerBound = r8;
        if (isRunning() == true) goto L28;
        T r10 = clampToBounds(getValue());
        if (Intrinsics.areEqual(r10, getValue()) == true) goto L29;
        this.internalState.setValue$animation_core(r10);
        return;
    L29:
        return;
    L28:
        return;
    L9:
        r1 = this.positiveInfinityBounds;
    L5:
        r0 = this.negativeInfinityBounds;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility", replaceWith = @ReplaceWith(expression = "Animatable(initialValue, typeConverter, visibilityThreshold, \"Animatable\")", imports = {}))
    public /* synthetic */ Animatable(Object r2, TwoWayConverter r3, Object r4) {
        this(r2, r3, r4, "Animatable");
    }

    public Animatable(T r12, TwoWayConverter<T, V> r13, T r14, String r15) {
        this.typeConverter = r13;
        this.visibilityThreshold = r14;
        this.label = r15;
        this.internalState = new AnimationState(r13, r12, null, 0, 0, false, 60, null);
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(r12, null, 2, null);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r14, 3, null);
        AnimationVector r16 = getVelocityVector();
        if ((r16 instanceof AnimationVector1D) == false) goto L6;
        V r17 = AnimatableKt.access$getNegativeInfinityBounds1D$p();
    L12:
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.negativeInfinityBounds = r17;
        AnimationVector r18 = getVelocityVector();
        if ((r18 instanceof AnimationVector1D) == false) goto L16;
        V r19 = AnimatableKt.access$getPositiveInfinityBounds1D$p();
    L22:
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.positiveInfinityBounds = r19;
        this.lowerBoundVector = r17;
        this.upperBoundVector = r19;
        return;
    L16:
        if ((r18 instanceof AnimationVector2D) == false) goto L19;
        r19 = AnimatableKt.access$getPositiveInfinityBounds2D$p();
        goto L22
    L19:
        if ((r18 instanceof AnimationVector3D) == false) goto L21;
        r19 = AnimatableKt.access$getPositiveInfinityBounds3D$p();
        goto L22
    L21:
        r19 = AnimatableKt.access$getPositiveInfinityBounds4D$p();
        goto L22
    L6:
        if ((r16 instanceof AnimationVector2D) == false) goto L9;
        r17 = AnimatableKt.access$getNegativeInfinityBounds2D$p();
        goto L12
    L9:
        if ((r16 instanceof AnimationVector3D) == false) goto L11;
        r17 = AnimatableKt.access$getNegativeInfinityBounds3D$p();
        goto L12
    L11:
        r17 = AnimatableKt.access$getNegativeInfinityBounds4D$p();
        goto L12
    }

    private final Object runAnimation(Animation<T, V> r16, T r17, Function1<? super Animatable<T, V>, Unit> r18, Continuation<? super AnimationResult<T, V>> r19) {
        long r4 = this.internalState.getLastFrameTimeNanos();
        return MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(this, r17, r16, r4, r18, null), r19, 1, null);
    }

    public final Object animateDecay(T r5, DecayAnimationSpec<T> r6, Function1<? super Animatable<T, V>, Unit> r7, Continuation<? super AnimationResult<T, V>> r8) {
        T r0 = getValue();
        AnimationVector r1 = (AnimationVector) this.typeConverter.getConvertToVector().invoke(r5);
        return runAnimation(new DecayAnimation(r6, this.typeConverter, r0, r1), r5, r7, r8);
    }

    public /* synthetic */ Animatable(Object r1, TwoWayConverter r2, Object r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$runAnimation(Animatable r0, Animation r1, Object r2, Function1 r3, Continuation r4) {
        return r0.runAnimation(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateBounds$default(Animatable r0, Object r1, Object r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.lowerBound;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = r0.upperBound;
    L8:
        r0.updateBounds(r1, r2);
    }

    public final Object animateTo(T r3, AnimationSpec<T> r4, T r5, Function1<? super Animatable<T, V>, Unit> r6, Continuation<? super AnimationResult<T, V>> r7) {
        T r0 = getValue();
        return runAnimation(AnimationKt.TargetBasedAnimation(r4, this.typeConverter, r0, r3, r5), r5, r6, r7);
    }

    public /* synthetic */ Animatable(Object r1, TwoWayConverter r2, Object r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = "Animatable";
    L8:
        this(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateDecay$default(Animatable r0, Object r1, DecayAnimationSpec r2, Function1 r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.animateDecay(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(Animatable r6, Object r7, AnimationSpec r8, Object r9, Function1 r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = r6.defaultSpringSpec;
    L5:
        AnimationSpec r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = r6.getVelocity();
    L8:
        Object r3 = r9;
        if ((r12 & 8) == 0) goto L12;
        r10 = null;
    L12:
        return r6.animateTo(r7, r2, r3, r10, r11);
    }
}
