package androidx.compose.material3;

import androidx.camera.video.AudioStats;
import androidx.collection.IntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0002J\u001c\u0010)\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ.\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010-J\b\u00105\u001a\u00020\u001bH\u0002J\f\u00109\u001a\u00020\u0016*\u00020\u0016H\u0002J\f\u0010<\u001a\u00020/*\u00020\u0016H\u0002J\f\u0010=\u001a\u00020/*\u00020\u0016H\u0002J\u0010\u0010>\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u00020/2\u0006\u0010.\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\u00020\u0005X\u0096\u000f¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010C\u001a\u00020DX\u0096\u000f¢\u0006\f\u001a\u0004\bE\u00102\"\u0004\bF\u00104¨\u0006G"}, d2 = {"Landroidx/compose/material3/AnalogTimePickerState;", "Landroidx/compose/material3/TimePickerState;", "state", "userOverride", "Landroidx/compose/ui/node/Ref;", "", "<init>", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/node/Ref;)V", "getState", "()Landroidx/compose/material3/TimePickerState;", "getUserOverride", "()Landroidx/compose/ui/node/Ref;", "<set-?>", "Landroidx/compose/ui/unit/Dp;", "currentDiameter", "getCurrentDiameter-D9Ej5fM", "()F", "setCurrentDiameter-0680j_4", "(F)V", "currentDiameter$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "", "getCurrentAngle", "hourAngle", "minuteAngle", "animateToCurrent", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUpdated", "clockFaceValues", "Landroidx/collection/IntList;", "getClockFaceValues", "()Landroidx/collection/IntList;", "endValueForAnimation", "new", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "onGestureEnd", "rotateTo", "angle", "animate", "(FLandroidx/compose/animation/core/AnimationSpec;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "minute", "getMinute", "()I", "setMinute", "(I)V", "updateBaseStateMinute", "hour", "getHour", "setHour", "normalize", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "toHour", "toMinute", "offsetAngle", "is24hour", "()Z", "set24hour", "(Z)V", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnalogTimePickerState implements TimePickerState {
    public static final int $stable = 8;
    private Animatable<Float, AnimationVector1D> anim;
    private final MutableState currentDiameter$delegate;
    private float hourAngle;
    private float minuteAngle;
    private final MutatorMutex mutex;
    private final TimePickerState state;
    private final Ref<Boolean> userOverride;

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2", f = "TimePicker.kt", i = {}, l = {754}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $end;
        int label;
        final /* synthetic */ AnalogTimePickerState this$0;

        public AnonymousClass2(AnalogTimePickerState r1, float r2, AnimationSpec<Float> r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$end = r2;
            this.$animationSpec = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass2(this.this$0, this.$end, this.$animationSpec, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super AnimationResult<Float, AnimationVector1D>> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            return r12;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            Animatable r3 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r4 = Boxing.boxFloat(this.$end);
            AnimationSpec<Float> r5 = this.$animationSpec;
            this.label = 1;
            r12 = Animatable.animateTo$default(r3, r4, r5, null, null, this, 12, null);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2", f = "TimePicker.kt", i = {}, l = {804}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02532 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $end;
        int label;
        final /* synthetic */ AnalogTimePickerState this$0;

        public C02532(AnalogTimePickerState r1, float r2, AnimationSpec<Float> r3, Continuation<? super C02532> r4) {
            this.this$0 = r1;
            this.$end = r2;
            this.$animationSpec = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new C02532(this.this$0, this.$end, this.$animationSpec, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super AnimationResult<Float, AnimationVector1D>> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            return r12;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            Animatable r3 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r4 = Boxing.boxFloat(this.$end);
            AnimationSpec<Float> r5 = this.$animationSpec;
            this.label = 1;
            r12 = Animatable.animateTo$default(r3, r4, r5, null, null, this, 12, null);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$rotateTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$rotateTo$2", f = "TimePicker.kt", i = {}, l = {823, 826}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02542 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ float $angle;
        final /* synthetic */ boolean $animate;
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        int label;
        final /* synthetic */ AnalogTimePickerState this$0;

        public C02542(AnalogTimePickerState r1, float r2, boolean r3, AnimationSpec<Float> r4, Continuation<? super C02542> r5) {
            this.this$0 = r1;
            this.$angle = r2;
            this.$animate = r3;
            this.$animationSpec = r4;
            super(1, r5);
        }

        public final Continuation<Unit> create(Continuation<?> r8) {
            return new C02542(this.this$0, this.$angle, this.$animate, this.$animationSpec, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<Object> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
            return r12;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L28:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r12);
            if (TimePickerSelectionMode.m3435equalsimpl0(this.this$0.mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L17;
            AnalogTimePickerState r13 = this.this$0;
            int r4 = 12;
            AnalogTimePickerState.access$setHourAngle$p(r13, (AnalogTimePickerState.access$toHour(r13, this.$angle) % 12) * 0.5235988f);
            TimePickerState r14 = this.this$0.getState();
            AnalogTimePickerState r2 = this.this$0;
            int r3 = AnalogTimePickerState.access$toHour(r2, AnalogTimePickerState.access$getHourAngle$p(r2)) % 12;
            if (TimePickerKt.isPm(this.this$0) == true) goto L16;
            r4 = 0;
        L16:
            r14.setHour(r3 + r4);
        L19:
            if (this.$animate == true) goto L24;
            Animatable r15 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r5 = Boxing.boxFloat(AnalogTimePickerState.access$offsetAngle(this.this$0, this.$angle));
            this.label = 1;
            if (r15.snapTo(r5, this) != r0) goto L28;
            return r0;
        L24:
            AnalogTimePickerState r16 = this.this$0;
            float r17 = AnalogTimePickerState.access$endValueForAnimation(r16, AnalogTimePickerState.access$offsetAngle(r16, this.$angle));
            Animatable r6 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r7 = Boxing.boxFloat(r17);
            AnimationSpec<Float> r8 = this.$animationSpec;
            this.label = 2;
            Object r18 = Animatable.animateTo$default(r6, r7, r8, null, null, this, 12, null);
            if (r18 != r0) goto L29;
            return r0;
        L29:
            return r18;
        L17:
            AnalogTimePickerState r19 = this.this$0;
            AnalogTimePickerState.access$setMinuteAngle$p(r19, AnalogTimePickerState.access$toMinute(r19, this.$angle) * 0.10471976f);
            TimePickerState r110 = this.this$0.getState();
            AnalogTimePickerState r9 = this.this$0;
            r110.setMinute(AnalogTimePickerState.access$toMinute(r9, AnalogTimePickerState.access$getMinuteAngle$p(r9)));
            goto L19
        }
    }

    private final float normalize(float r7) {
        double r0 = ((double) r7) % 6.283185307179586d;
        if (r0 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r0 = r0 + 6.283185307179586d;
    L6:
        return (float) r0;
    }

    private final float offsetAngle(float r2) {
        float r3 = r2 + 1.5707964f;
        if (r3 < MenuKt.ClosedAlphaTarget) goto L5;
        return r3;
    L5:
        return r3 + 6.2831855f;
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: getSelection-yecRtBI, reason: not valid java name */
    public int mo2286getSelectionyecRtBI() {
        return this.state.mo2286getSelectionyecRtBI();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.state.is24hour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean r2) {
        this.state.set24hour(r2);
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: setSelection-6_8s6DQ, reason: not valid java name */
    public void mo2288setSelection6_8s6DQ(int r2) {
        this.state.mo2288setSelection6_8s6DQ(r2);
    }

    private final void updateBaseStateMinute() {
        Snapshot.Companion r0 = Snapshot.Companion;
        Snapshot r1 = r0.getCurrentThreadSnapshot();
        if (r1 == null) goto L5;
        Function1 r2 = r1.getReadObserver();
    L6:
        Snapshot r3 = r0.makeCurrentNonObservable(r1);
        this.state.setMinute(getMinute());     // Catch: Throwable -> L10
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r0.restoreNonObservable(r1, r3, r2);
        return;
    L10:
        th = move-exception;
        r0.restoreNonObservable(r1, r3, r2);
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    public final float getCurrentAngle() {
        return this.anim.getValue().floatValue();
    }

    /* JADX INFO: renamed from: getCurrentDiameter-D9Ej5fM, reason: not valid java name */
    public final float m2285getCurrentDiameterD9Ej5fM() {
        return ((Dp) this.currentDiameter$delegate.getValue()).unbox-impl();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.state.getMinute();
    }

    private final boolean isUpdated() {
        int r0 = mo2286getSelectionyecRtBI();
        TimePickerSelectionMode.Companion r1 = TimePickerSelectionMode.Companion;
        if (TimePickerSelectionMode.m3435equalsimpl0(r0, r1.m3439getHouryecRtBI()) == false) goto L11;
        if (normalize(this.anim.getTargetValue().floatValue()) != normalize(this.hourAngle)) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        return false;
    L7:
        r2 = false;
    L11:
        if (TimePickerSelectionMode.m3435equalsimpl0(mo2286getSelectionyecRtBI(), r1.m3440getMinuteyecRtBI()) == true) goto L13;
    L18:
        return true;
    L13:
        if (normalize(this.anim.getTargetValue().floatValue()) != normalize(this.minuteAngle)) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        return false;
    L15:
        r3 = false;
        goto L16
    }

    public final IntList getClockFaceValues() {
        if (TimePickerSelectionMode.m3435equalsimpl0(mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI()) == false) goto L6;
        return TimePickerKt.access$getMinutes$p();
    L6:
        return TimePickerKt.access$getHours$p();
    }

    public final TimePickerState getState() {
        return this.state;
    }

    public final Ref<Boolean> getUserOverride() {
        return this.userOverride;
    }

    public static final /* synthetic */ Animatable access$getAnim$p(AnalogTimePickerState r0) {
        return r0.anim;
    }

    public static final /* synthetic */ float access$getHourAngle$p(AnalogTimePickerState r0) {
        return r0.hourAngle;
    }

    public static final /* synthetic */ float access$getMinuteAngle$p(AnalogTimePickerState r0) {
        return r0.minuteAngle;
    }

    private final float endValueForAnimation(float r3) {
        float r0 = this.anim.getValue().floatValue() - r3;
    L4:
        if (r0 <= 3.1415927f) goto L7;
        r0 = r0 - 6.2831855f;
    L7:
        if (r0 > (-3.1415927f)) goto L10;
        r0 = r0 + 6.2831855f;
        goto L7
    L10:
        return this.anim.getValue().floatValue() - r0;
    }

    private final int toHour(float r5) {
        return ((int) ((r5 + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    private final int toMinute(float r5) {
        return ((int) ((r5 + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    /* JADX INFO: renamed from: setCurrentDiameter-0680j_4, reason: not valid java name */
    public final void m2287setCurrentDiameter0680j_4(float r2) {
        this.currentDiameter$delegate.setValue(Dp.box-impl(r2));
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int r4) {
        this.hourAngle = ((r4 % 12) * 0.5235988f) - 1.5707964f;
        this.state.setHour(r4);
        if (TimePickerSelectionMode.m3435equalsimpl0(mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L6;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, MenuKt.ClosedAlphaTarget, 2, null);
        return;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int r4) {
        this.minuteAngle = (r4 * 0.10471976f) - 1.5707964f;
        this.state.setMinute(r4);
        if (TimePickerSelectionMode.m3435equalsimpl0(mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI()) == false) goto L5;
        this.anim = AnimatableKt.Animatable$default(this.minuteAngle, MenuKt.ClosedAlphaTarget, 2, null);
    L5:
        updateBaseStateMinute();
    }

    public AnalogTimePickerState(TimePickerState r4, Ref<Boolean> r5) {
        this.state = r4;
        this.userOverride = r5;
        this.currentDiameter$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), null, 2, null);
        this.hourAngle = ((r4.getHour() % 12) * 0.5235988f) - 1.5707964f;
        this.minuteAngle = (r4.getMinute() * 0.10471976f) - 1.5707964f;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, MenuKt.ClosedAlphaTarget, 2, null);
        this.mutex = new MutatorMutex();
    }

    public static final /* synthetic */ float access$endValueForAnimation(AnalogTimePickerState r0, float r1) {
        return r0.endValueForAnimation(r1);
    }

    public static final /* synthetic */ float access$offsetAngle(AnalogTimePickerState r0, float r1) {
        return r0.offsetAngle(r1);
    }

    public static final /* synthetic */ void access$setHourAngle$p(AnalogTimePickerState r0, float r1) {
        r0.hourAngle = r1;
    }

    public static final /* synthetic */ void access$setMinuteAngle$p(AnalogTimePickerState r0, float r1) {
        r0.minuteAngle = r1;
    }

    public static final /* synthetic */ int access$toHour(AnalogTimePickerState r0, float r1) {
        return r0.toHour(r1);
    }

    public static final /* synthetic */ int access$toMinute(AnalogTimePickerState r0, float r1) {
        return r0.toMinute(r1);
    }

    public final Object animateToCurrent(AnimationSpec<Float> r6, Continuation<? super Unit> r7) {
        if (isUpdated() == true) goto L7;
        return Unit.INSTANCE;
    L7:
        if (TimePickerSelectionMode.m3435equalsimpl0(mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L9;
        float r0 = endValueForAnimation(this.hourAngle);
    L10:
        Object r8 = this.mutex.mutate(MutatePriority.PreventUserInput, new AnonymousClass2(this, r0, r6, null), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r8;
    L14:
        return Unit.INSTANCE;
    L9:
        r0 = endValueForAnimation(this.minuteAngle);
        goto L10
    }

    public final Object onGestureEnd(AnimationSpec<Float> r6, Continuation<? super Unit> r7) {
        if (TimePickerSelectionMode.m3435equalsimpl0(mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L5;
        float r0 = this.hourAngle;
    L6:
        float r1 = endValueForAnimation(r0);
        Object r8 = this.mutex.mutate(MutatePriority.PreventUserInput, new C02532(this, r1, r6, null), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r8;
    L10:
        return Unit.INSTANCE;
    L5:
        r0 = this.minuteAngle;
        goto L6
    }

    public /* synthetic */ AnalogTimePickerState(TimePickerState r1, Ref r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = new Ref();
    L5:
        this(r1, r2);
    }

    public final Object rotateTo(float r10, AnimationSpec<Float> r11, boolean r12, Continuation<? super Unit> r13) {
        this.userOverride.setValue(Boxing.boxBoolean(false));
        Object r14 = this.mutex.mutate(MutatePriority.UserInput, new C02542(this, r10, r12, r11, null), r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object rotateTo$default(AnalogTimePickerState r0, float r1, AnimationSpec r2, boolean r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.rotateTo(r1, r2, r3, r4);
    }
}
