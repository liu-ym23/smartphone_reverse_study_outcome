package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u0000H\u0000¢\u0006\u0002\b J!\u0010!\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u0000H\u0000¢\u0006\u0002\b\"J\u000f\u0010#\u001a\u00020\u001eH\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R#\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u00000\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Landroidx/compose/animation/core/InfiniteTransition;", "", "label", "", "<init>", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "_animations", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "<set-?>", "", "refreshChildNeeded", "getRefreshChildNeeded", "()Z", "setRefreshChildNeeded", "(Z)V", "refreshChildNeeded$delegate", "Landroidx/compose/runtime/MutableState;", "startTimeNanos", "", "isRunning", "setRunning", "isRunning$delegate", "animations", "", "getAnimations", "()Ljava/util/List;", "addAnimation", "", "animation", "addAnimation$animation_core", "removeAnimation", "removeAnimation$animation_core", "run", "run$animation_core", "(Landroidx/compose/runtime/Composer;I)V", "onFrame", "playTimeNanos", "TransitionAnimationState", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InfiniteTransition {
    public static final int $stable = 8;
    private final MutableVector<TransitionAnimationState<?, ?>> _animations;
    private final MutableState isRunning$delegate;
    private final String label;
    private final MutableState refreshChildNeeded$delegate;
    private long startTimeNanos;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004BC\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ-\u00101\u001a\u0002022\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0000¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u0002022\u0006\u00106\u001a\u000200H\u0000¢\u0006\u0002\b7J\r\u00108\u001a\u000202H\u0000¢\u0006\u0002\b9J\r\u0010:\u001a\u000202H\u0000¢\u0006\u0002\b;R\u001c\u0010\u0005\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R<\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "label", "", "<init>", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;)V", "getInitialValue$animation_core", "()Ljava/lang/Object;", "setInitialValue$animation_core", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getTargetValue$animation_core", "setTargetValue$animation_core", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "value", "getValue", "setValue$animation_core", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation$animation_core", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "isFinished", "", "isFinished$animation_core", "()Z", "setFinished$animation_core", "(Z)V", "startOnTheNextFrame", "playTimeNanosOffset", "", "updateValues", "", "updateValues$animation_core", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;)V", "onPlayTimeChanged", "playTimeNanos", "onPlayTimeChanged$animation_core", "skipToEnd", "skipToEnd$animation_core", "reset", "reset$animation_core", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        private TargetBasedAnimation<T, V> animation;
        private AnimationSpec<T> animationSpec;
        private T initialValue;
        private boolean isFinished;
        private final String label;
        private long playTimeNanosOffset;
        private boolean startOnTheNextFrame;
        private T targetValue;
        final /* synthetic */ InfiniteTransition this$0;
        private final TwoWayConverter<T, V> typeConverter;
        private final MutableState value$delegate;

        public final void reset$animation_core() {
            this.startOnTheNextFrame = true;
        }

        public T getValue() {
            return (T) this.value$delegate.getValue();
        }

        public final void skipToEnd$animation_core() {
            setValue$animation_core(this.animation.getTargetValue());
            this.startOnTheNextFrame = true;
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            return this.animation;
        }

        public final AnimationSpec<T> getAnimationSpec() {
            return this.animationSpec;
        }

        public final T getInitialValue$animation_core() {
            return this.initialValue;
        }

        public final String getLabel() {
            return this.label;
        }

        public final T getTargetValue$animation_core() {
            return this.targetValue;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final boolean isFinished$animation_core() {
            return this.isFinished;
        }

        public final void onPlayTimeChanged$animation_core(long r3) {
            InfiniteTransition.access$setRefreshChildNeeded(this.this$0, false);
            if (this.startOnTheNextFrame == false) goto L5;
            this.startOnTheNextFrame = false;
            this.playTimeNanosOffset = r3;
        L5:
            long r4 = r3 - this.playTimeNanosOffset;
            setValue$animation_core(this.animation.getValueFromNanos(r4));
            TargetBasedAnimation<T, V> r0 = this.animation;
            r0.getClass();
            this.isFinished = Animation.CC.$default$isFinishedFromNanos(r0, r4);
        }

        public final void setAnimation$animation_core(TargetBasedAnimation<T, V> r1) {
            this.animation = r1;
        }

        public final void setFinished$animation_core(boolean r1) {
            this.isFinished = r1;
        }

        public final void setInitialValue$animation_core(T r1) {
            this.initialValue = r1;
        }

        public final void setTargetValue$animation_core(T r1) {
            this.targetValue = r1;
        }

        public void setValue$animation_core(T r2) {
            this.value$delegate.setValue(r2);
        }

        public final void updateValues$animation_core(T r10, T r11, AnimationSpec<T> r12) {
            this.initialValue = r10;
            this.targetValue = r11;
            this.animationSpec = r12;
            this.animation = new TargetBasedAnimation(r12, this.typeConverter, r10, r11, null, 16, null);
            InfiniteTransition.access$setRefreshChildNeeded(this.this$0, true);
            this.isFinished = false;
            this.startOnTheNextFrame = true;
        }

        public TransitionAnimationState(InfiniteTransition r9, T r10, T r11, TwoWayConverter<T, V> r12, AnimationSpec<T> r13, String r14) {
            this.this$0 = r9;
            this.initialValue = r10;
            this.targetValue = r11;
            this.typeConverter = r12;
            this.label = r14;
            this.value$delegate = SnapshotStateKt.mutableStateOf$default(r10, null, 2, null);
            this.animationSpec = r13;
            this.animation = new TargetBasedAnimation(r13, r12, this.initialValue, this.targetValue, null, 16, null);
        }
    }

    public static /* synthetic */ Unit a(InfiniteTransition r0, int r1, Composer r2, int r3) {
        return run$lambda$2(r0, r1, r2, r3);
    }

    private static final Unit run$lambda$2(InfiniteTransition r0, int r1, Composer r2, int r3) {
        r0.run$animation_core(r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private final boolean getRefreshChildNeeded() {
        return ((Boolean) this.refreshChildNeeded$delegate.getValue()).booleanValue();
    }

    private final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final List<TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations.asMutableList();
    }

    public final String getLabel() {
        return this.label;
    }

    public InfiniteTransition(String r5) {
        this.label = r5;
        this._animations = new MutableVector(new TransitionAnimationState[16], 0);
        this.refreshChildNeeded$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.startTimeNanos = Long.MIN_VALUE;
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    public static final /* synthetic */ long access$getStartTimeNanos$p(InfiniteTransition r2) {
        return r2.startTimeNanos;
    }

    public static final /* synthetic */ MutableVector access$get_animations$p(InfiniteTransition r0) {
        return r0._animations;
    }

    private final void onFrame(long r9) {
        MutableVector<TransitionAnimationState<?, ?>> r0 = this._animations;
        Object[] r1 = r0.content;
        int r2 = r0.getSize();
        int r4 = 0;
        boolean r5 = true;
    L3:
        if (r4 >= r2) goto L11;
        TransitionAnimationState r6 = (TransitionAnimationState) r1[r4];
        if (r6.isFinished$animation_core() == true) goto L8;
        r6.onPlayTimeChanged$animation_core(r9);
    L8:
        if (r6.isFinished$animation_core() == true) goto L10;
        r5 = false;
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        setRunning(!r5);
    }

    private final void setRefreshChildNeeded(boolean r2) {
        this.refreshChildNeeded$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setRunning(boolean r2) {
        this.isRunning$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void addAnimation$animation_core(TransitionAnimationState<?, ?> r2) {
        this._animations.add(r2);
        setRefreshChildNeeded(true);
    }

    public final void removeAnimation$animation_core(TransitionAnimationState<?, ?> r2) {
        this._animations.remove(r2);
    }

    public static final /* synthetic */ void access$onFrame(InfiniteTransition r0, long r1) {
        r0.onFrame(r1);
    }

    public static final /* synthetic */ void access$setRefreshChildNeeded(InfiniteTransition r0, boolean r1) {
        r0.setRefreshChildNeeded(r1);
    }

    public static final /* synthetic */ void access$setStartTimeNanos$p(InfiniteTransition r0, long r1) {
        r0.startTimeNanos = r1;
    }

    public final void run$animation_core(Composer r7, final int r8) {
        Composer r9 = r7.startRestartGroup(-318043801);
        if ((r8 & 6) == 0) goto L5;
        int r1 = r8;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r3 = true;
    L15:
        if (r9.shouldExecute(r3, r1 & 1) == true) goto L17;
        r9.skipToGroupEnd();
    L38:
        ScopeUpdateScope r10 = r9.endRestartGroup();
        if (r10 == null) goto L42;
        r10.updateScope(new l(this, r8));
        return;
    L42:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-318043801, r1, -1, "androidx.compose.animation.core.InfiniteTransition.run (InfiniteTransition.kt:164)");
    L19:
        Object r0 = r9.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r0 != r4.getEmpty()) goto L22;
        r0 = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        r9.updateRememberedValue(r0);
    L22:
        MutableState r2 = (MutableState) r0;
        if (isRunning() == false) goto L25;
    L28:
        r9.startReplaceGroup(-144783432);
        boolean r5 = r9.changedInstance(this);
        Object r6 = r9.rememberedValue();
        if (r5 == false) goto L31;
    L32:
        r6 = new InfiniteTransition$run$1$1(r2, this, null);
        r9.updateRememberedValue(r6);
    L33:
        EffectsKt.LaunchedEffect(this, (Function2) r6, r9, r1 & 14);
        r9.endReplaceGroup();
    L35:
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
        goto L38
    L31:
        if (r6 != r4.getEmpty()) goto L33;
    L25:
        if (getRefreshChildNeeded() == true) goto L28;
        r9.startReplaceGroup(-143396709);
        r9.endReplaceGroup();
        goto L35
    L13:
        r3 = false;
        goto L15
    L5:
        if (r9.changedInstance(this) == false) goto L7;
        int r11 = 4;
    L8:
        r1 = r11 | r8;
        goto L11
    L7:
        r11 = 2;
        goto L8
    }
}
