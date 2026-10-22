package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001SBR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00121\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ%\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010 \u001a\u00020\r*\u00020\u0016H\u0002J\u000e\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)J;\u0010*\u001a\u00020\r*\u00020\u00032'\u0010+\u001a#\b\u0001\u0012\u0004\u0012\u00020,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\b-H\u0082@¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b0\u00101J\u0014\u00102\u001a\u0004\u0018\u00010#*\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0018\u00103\u001a\u00020#*\b\u0012\u0004\u0012\u00020#0\"H\u0082@¢\u0006\u0002\u00104J$\u00105\u001a\b\u0012\u0004\u0012\u0002H706\"\u0004\b\u0000\u001072\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H709H\u0002J\u001b\u0010:\u001a\u00020\u001e*\u00020\u00032\u0006\u0010;\u001a\u00020<H\u0002¢\u0006\u0004\b=\u0010>J\u0010\u0010A\u001a\u00020\r2\u0006\u0010;\u001a\u00020#H\u0002J*\u0010B\u001a\u00020\r*\u00020\u00032\u0006\u0010;\u001a\u00020#2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DH\u0082@¢\u0006\u0002\u0010FJY\u0010G\u001a\u00020\r*\u00020,2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020J0I2\u0006\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020M2!\u0010N\u001a\u001d\u0012\u0013\u0012\u00110D¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u001e0OH\u0082@¢\u0006\u0002\u0010QJ\u0014\u0010B\u001a\u00020D*\u00020,2\u0006\u0010R\u001a\u00020DH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\u0006\u001a-\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\u00020\u001e*\u00020\u00168Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic;", "", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "mouseWheelScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onScrollStopped", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Velocity;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "velocity", "Lkotlin/coroutines/Continuation;", "", "density", "Landroidx/compose/ui/unit/Density;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/unit/Density;)V", "Lkotlin/jvm/functions/Function2;", "updateDensity", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "isConsumed", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "consume", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "isScrolling", "receivingMouseWheelEventsJob", "Lkotlinx/coroutines/Job;", "startReceivingMouseWheelEvents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "userScroll", "block", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMouseWheel", "onMouseWheel-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "sumOrNull", "busyReceive", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "untilNull", "Lkotlin/sequences/Sequence;", "E", "builderAction", "Lkotlin/Function0;", "canConsumeDelta", "scrollDelta", "Landroidx/compose/ui/geometry/Offset;", "canConsumeDelta-Uv8p0NA", "(Landroidx/compose/foundation/gestures/ScrollingLogic;J)Z", "velocityTracker", "Landroidx/compose/foundation/gestures/MouseWheelVelocityTracker;", "trackVelocity", "dispatchMouseWheelScroll", "threshold", "", "speed", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateMouseWheelScroll", "animationState", "Landroidx/compose/animation/core/AnimationState;", "Landroidx/compose/animation/core/AnimationVector1D;", "targetValue", "durationMillis", "", "shouldCancelAnimation", "Lkotlin/Function1;", "lastValue", "(Landroidx/compose/foundation/gestures/NestedScrollScope;Landroidx/compose/animation/core/AnimationState;FILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "MouseWheelScrollDelta", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MouseWheelScrollingLogic {
    public static final int $stable = 8;
    private final Channel<MouseWheelScrollDelta> channel;
    private Density density;
    private boolean isScrolling;
    private final ScrollConfig mouseWheelScrollConfig;
    private final Function2<Velocity, Continuation<? super Unit>, Object> onScrollStopped;
    private Job receivingMouseWheelEventsJob;
    private final ScrollingLogic scrollingLogic;
    private final MouseWheelVelocityTracker velocityTracker;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002J\u0010\u0010\u0012\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J.\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "", "value", "Landroidx/compose/ui/geometry/Offset;", "timeMillis", "", "shouldApplyImmediately", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-F1C5BW0", "()J", "J", "getTimeMillis", "getShouldApplyImmediately", "()Z", "plus", "other", "component1", "component1-F1C5BW0", "component2", "component3", "copy", "copy-9KIMszo", "(JJZ)Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "equals", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MouseWheelScrollDelta {
        private final boolean shouldApplyImmediately;
        private final long timeMillis;
        private final long value;

        public /* synthetic */ MouseWheelScrollDelta(long r1, long r3, boolean r5, DefaultConstructorMarker r6) {
            this(r1, r3, r5);
        }

        /* JADX INFO: renamed from: copy-9KIMszo$default, reason: not valid java name */
        public static /* synthetic */ MouseWheelScrollDelta m608copy9KIMszo$default(MouseWheelScrollDelta r6, long r7, long r9, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.value;
        L5:
            long r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r9 = r6.timeMillis;
        L8:
            long r3 = r9;
            if ((r12 & 4) == 0) goto L12;
            r11 = r6.shouldApplyImmediately;
        L12:
            return r6.m610copy9KIMszo(r1, r3, r11);
        }

        /* JADX INFO: renamed from: component1-F1C5BW0, reason: not valid java name */
        public final long m609component1F1C5BW0() {
            return this.value;
        }

        public final long component2() {
            return this.timeMillis;
        }

        public final boolean component3() {
            return this.shouldApplyImmediately;
        }

        /* JADX INFO: renamed from: copy-9KIMszo, reason: not valid java name */
        public final MouseWheelScrollDelta m610copy9KIMszo(long r9, long r11, boolean r13) {
            return new MouseWheelScrollDelta(r9, r11, r13, null);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof MouseWheelScrollDelta) == true) goto L8;
            return false;
        L8:
            MouseWheelScrollDelta r9 = (MouseWheelScrollDelta) r8;
            if (Offset.equals-impl0(this.value, r9.value) == true) goto L12;
            return false;
        L12:
            if (this.timeMillis == r9.timeMillis) goto L15;
            return false;
        L15:
            if (this.shouldApplyImmediately == r9.shouldApplyImmediately) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = Offset.hashCode-impl(this.value) * 31;
            long r1 = this.timeMillis;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            if (this.shouldApplyImmediately == false) goto L5;
            int r3 = 1231;
        L7:
            return r2 + r3;
        L5:
            r3 = 1237;
            goto L7
        }

        public String toString() {
            return "MouseWheelScrollDelta(value=" + Offset.toString-impl(this.value) + ", timeMillis=" + this.timeMillis + ", shouldApplyImmediately=" + this.shouldApplyImmediately + ')';
        }

        public final boolean getShouldApplyImmediately() {
            return this.shouldApplyImmediately;
        }

        public final long getTimeMillis() {
            return this.timeMillis;
        }

        /* JADX INFO: renamed from: getValue-F1C5BW0, reason: not valid java name */
        public final long m611getValueF1C5BW0() {
            return this.value;
        }

        public final MouseWheelScrollDelta plus(MouseWheelScrollDelta r9) {
            return new MouseWheelScrollDelta(Offset.plus-MK-Hz9U(this.value, r9.value), Math.max(this.timeMillis, r9.timeMillis), this.shouldApplyImmediately, null);
        }

        private MouseWheelScrollDelta(long r1, long r3, boolean r5) {
            this.value = r1;
            this.timeMillis = r3;
            this.shouldApplyImmediately = r5;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$busyReceive$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$busyReceive$2", f = "MouseWheelScrollable.kt", i = {0}, l = {170}, m = "invokeSuspend", n = {"job"}, s = {"L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MouseWheelScrollDelta>, Object> {
        final /* synthetic */ Channel<MouseWheelScrollDelta> $this_busyReceive;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Channel<MouseWheelScrollDelta> r1, Continuation<? super AnonymousClass2> r2) {
            this.$this_busyReceive = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$this_busyReceive, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super MouseWheelScrollDelta> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            Job r2 = (Job) this.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L8
        L17:
            MouseWheelScrollDelta r13 = (MouseWheelScrollDelta) r12;     // Catch: Throwable -> L8
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
            return r13;
        L8:
            Throwable th = th;
        L22:
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r12);
            Job r14 = BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new MouseWheelScrollingLogic$busyReceive$2$job$1(null), 3, null);
            Channel<MouseWheelScrollDelta> r3 = this.$this_busyReceive;     // Catch: Throwable -> L20
            this.L$0 = r14;     // Catch: Throwable -> L20
            this.label = 1;     // Catch: Throwable -> L20
            Object r4 = r3.receive(this);     // Catch: Throwable -> L20
            if (r4 != r0) goto L16;
            return r0;
        L16:
            r2 = r14;
            r12 = r4;
        L20:
            th = move-exception;
            r2 = r14;
            th = th;
            goto L22
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic", f = "MouseWheelScrollable.kt", i = {0, 0, 0}, l = {244, 295}, m = "dispatchMouseWheelScroll", n = {"$this$dispatchMouseWheelScroll", "targetValue", "speed"}, s = {"L$0", "L$1", "F$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MouseWheelScrollingLogic this$0;

        public AnonymousClass1(MouseWheelScrollingLogic r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(this.this$0, null, null, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3", f = "MouseWheelScrollable.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {253, 266, 283}, m = "invokeSuspend", n = {"$this$userScroll", "requiredAnimation", "$this$userScroll", "requiredAnimation", "durationMillis", "$this$userScroll", "requiredAnimation"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> $animationState;
        final /* synthetic */ float $speed;
        final /* synthetic */ Ref.ObjectRef<MouseWheelScrollDelta> $targetScrollDelta;
        final /* synthetic */ Ref.FloatRef $targetValue;
        final /* synthetic */ ScrollingLogic $this_dispatchMouseWheelScroll;
        final /* synthetic */ float $threshold;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ MouseWheelScrollingLogic this$0;

        public AnonymousClass3(Ref.FloatRef r1, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> r2, Ref.ObjectRef<MouseWheelScrollDelta> r3, float r4, MouseWheelScrollingLogic r5, float r6, ScrollingLogic r7, Continuation<? super AnonymousClass3> r8) {
            this.$targetValue = r1;
            this.$animationState = r2;
            this.$targetScrollDelta = r3;
            this.$threshold = r4;
            this.this$0 = r5;
            this.$speed = r6;
            this.$this_dispatchMouseWheelScroll = r7;
            super(2, r8);
        }

        public static /* synthetic */ boolean a(MouseWheelScrollingLogic r0, Ref.ObjectRef r1, Ref.FloatRef r2, ScrollingLogic r3, Ref.BooleanRef r4, float r5) {
            return invokeSuspend$lambda$0(r0, r1, r2, r3, r4, r5);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            AnonymousClass3 r9 = new AnonymousClass3(this.$targetValue, this.$animationState, this.$targetScrollDelta, this.$threshold, this.this$0, this.$speed, this.$this_dispatchMouseWheelScroll, r12);
            r9.L$0 = r11;
            return r9;
        }

        public final Object invoke(NestedScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((NestedScrollScope) r1, (Continuation) r2);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x015f -> B:30:0x0161). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x016a -> B:13:0x006a). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r27) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            int r4 = 2;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            Ref.BooleanRef r3 = (Ref.BooleanRef) this.L$2;
            Ref.BooleanRef r6 = (Ref.BooleanRef) this.L$1;
            NestedScrollScope r7 = (NestedScrollScope) this.L$0;
            ResultKt.throwOnFailure(r27);
            Object r5 = r27;
            AnonymousClass3 r15 = this;
            NestedScrollScope r13 = r7;
        L30:
            r3.element = ((Boolean) r5).booleanValue();
        L37:
            r3 = r6;
            r4 = 2;
        L14:
            if (r3.element == false) goto L39;
            r3.element = false;
            float r8 = r15.$targetValue.element - ((Number) ((AnimationState) r15.$animationState.element).getValue()).floatValue();
            if (((MouseWheelScrollDelta) r15.$targetScrollDelta.element).getShouldApplyImmediately() == false) goto L18;
        L32:
            MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(r15.this$0, r13, r8);
            MouseWheelScrollingLogic r14 = r15.this$0;
            Ref.ObjectRef<MouseWheelScrollDelta> r9 = r15.$targetScrollDelta;
            Ref.FloatRef r10 = r15.$targetValue;
            ScrollingLogic r11 = r15.$this_dispatchMouseWheelScroll;
            Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> r12 = r15.$animationState;
            r15.L$0 = r13;
            r15.L$1 = r3;
            r15.L$2 = r3;
            r15.label = 1;
            AnonymousClass3 r16 = r15;
            Object r17 = MouseWheelScrollingLogic.access$dispatchMouseWheelScroll$waitNextScrollDelta(r14, r9, r10, r11, r12, 50, r16);
            if (r17 != r1) goto L35;
            return r1;
        L35:
            r6 = r3;
            r15 = r16;
            r3.element = ((Boolean) r17).booleanValue();
            goto L37
        L18:
            if (Math.abs(r8) < r15.$threshold) goto L32;
            float r18 = Math.signum(r8) * r15.$threshold;
            MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(r15.this$0, r13, r18);
            Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> r19 = r15.$animationState;
            Object r20 = r19.element;
            r19.element = AnimationStateKt.copy$default((AnimationState) r20, ((Number) ((AnimationState) r20).getValue()).floatValue() + r18, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
            int r110 = RangesKt.coerceAtMost(MathKt.roundToInt(Math.abs(r15.$targetValue.element - ((Number) ((AnimationState) r15.$animationState.element).getValue()).floatValue()) / r15.$speed), 100);
            final MouseWheelScrollingLogic r111 = r15.this$0;
            AnimationState r112 = (AnimationState) r15.$animationState.element;
            final Ref.FloatRef r21 = r15.$targetValue;
            float r113 = r21.element;
            final Ref.ObjectRef<MouseWheelScrollDelta> r22 = r15.$targetScrollDelta;
            final ScrollingLogic r114 = r15.$this_dispatchMouseWheelScroll;
            final Ref.BooleanRef r115 = r3;
            Function1 r116 = new v1(r111, r22, r21, r114, r115);
            r15.L$0 = r13;
            r15.L$1 = r3;
            r15.L$2 = null;
            r15.I$0 = r110;
            r15.label = r4;
            if (MouseWheelScrollingLogic.access$animateMouseWheelScroll(r111, r13, r112, r113, r110, r116, r15) != r1) goto L23;
            return r1;
        L23:
            AnonymousClass3 r23 = r15;
        L25:
            if (r3.element == true) goto L31;
            r23.L$0 = r13;
            r23.L$1 = r3;
            r23.L$2 = r3;
            r23.label = 3;
            r5 = MouseWheelScrollingLogic.access$dispatchMouseWheelScroll$waitNextScrollDelta(r23.this$0, r23.$targetScrollDelta, r23.$targetValue, r23.$this_dispatchMouseWheelScroll, r23.$animationState, 50 - ((long) r110), r23);
            if (r5 != r1) goto L29;
            return r1;
        L29:
            r15 = r23;
            r6 = r3;
            goto L30
        L31:
            r15 = r23;
            goto L14
        L39:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r24 = this.I$0;
            Ref.BooleanRef r25 = (Ref.BooleanRef) this.L$1;
            NestedScrollScope r26 = (NestedScrollScope) this.L$0;
            ResultKt.throwOnFailure(r27);
            r110 = r24;
            r3 = r25;
            r13 = r26;
            r23 = this;
            goto L25
        L11:
            Ref.BooleanRef r28 = (Ref.BooleanRef) this.L$2;
            r6 = (Ref.BooleanRef) this.L$1;
            NestedScrollScope r29 = (NestedScrollScope) this.L$0;
            ResultKt.throwOnFailure(r27);
            r15 = this;
            r13 = r29;
            r28.element = ((Boolean) r27).booleanValue();
            goto L37
        L12:
            ResultKt.throwOnFailure(r27);
            NestedScrollScope r30 = (NestedScrollScope) this.L$0;
            Ref.BooleanRef r31 = new Ref.BooleanRef();
            r31.element = true;
            r15 = this;
            r13 = r30;
            r3 = r31;
            goto L14
        }

        private static final boolean invokeSuspend$lambda$0(MouseWheelScrollingLogic r2, Ref.ObjectRef r3, Ref.FloatRef r4, ScrollingLogic r5, Ref.BooleanRef r6, float r7) {
            MouseWheelScrollDelta r0 = MouseWheelScrollingLogic.access$sumOrNull(r2, MouseWheelScrollingLogic.access$getChannel$p(r2));
            if (r0 == null) goto L5;
            MouseWheelScrollingLogic.access$trackVelocity(r2, r0);
            MouseWheelScrollDelta r8 = ((MouseWheelScrollDelta) r3.element).plus(r0);
            r3.element = r8;
            float r9 = r5.m701toFloatk4lQ0M(r5.m699reverseIfNeededMKHz9U(r8.m611getValueF1C5BW0()));
            r4.element = r9;
            r6.element = !MouseWheelScrollableKt.access$isLowScrollingDelta(r9 - r7);
        L5:
            if (r0 != null) goto L9;
            return false;
        L9:
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1", f = "MouseWheelScrollable.kt", i = {0, 1}, l = {107, 110}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    public static final class C01421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MouseWheelScrollingLogic this$0;

        public C01421(MouseWheelScrollingLogic r1, Continuation<? super C01421> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01421 r0 = new C01421(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0083 -> B:34:0x0035). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 != 0) goto L33;
            ResultKt.throwOnFailure(r13);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
        L17:
            C01421 r2 = this;
        L34:
            if (JobKt.isActive(r14.getCoroutineContext()) == false) goto L28;
            Channel r5 = MouseWheelScrollingLogic.access$getChannel$p(r2.this$0);     // Catch: Throwable -> L30
            r2.L$0 = r14;     // Catch: Throwable -> L30
            r2.label = 1;     // Catch: Throwable -> L30
            Object r6 = r5.receive(r2);     // Catch: Throwable -> L30
            if (r6 != r0) goto L23;
            return r0;
        L23:
            CoroutineScope r11 = r14;
            r13 = r6;
        L24:
            MouseWheelScrollDelta r7 = (MouseWheelScrollDelta) r13;     // Catch: Throwable -> L30
            float r8 = MouseWheelScrollingLogic.access$getDensity$p(r2.this$0).toPx-0680j_4(MouseWheelScrollableKt.access$getAnimationThreshold$p());     // Catch: Throwable -> L30
            float r9 = MouseWheelScrollingLogic.access$getDensity$p(r2.this$0).toPx-0680j_4(MouseWheelScrollableKt.access$getAnimationSpeed$p());     // Catch: Throwable -> L30
            MouseWheelScrollingLogic r10 = r2.this$0;     // Catch: Throwable -> L30
            ScrollingLogic r12 = MouseWheelScrollingLogic.access$getScrollingLogic$p(r10);     // Catch: Throwable -> L30
            r2.L$0 = r11;     // Catch: Throwable -> L30
            r2.label = 2;     // Catch: Throwable -> L30
            if (MouseWheelScrollingLogic.access$dispatchMouseWheelScroll(r10, r12, r7, r8, r9, r2) != r0) goto L27;
            return r0;
        L27:
            r14 = r11;
            goto L34
        L28:
            MouseWheelScrollingLogic.access$setReceivingMouseWheelEventsJob$p(r2.this$0, null);
            return Unit.INSTANCE;
        L30:
            th = th;
        L31:
            MouseWheelScrollingLogic.access$setReceivingMouseWheelEventsJob$p(r2.this$0, null);
            throw th;
        L33:
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
            r14 = r3;
            goto L17
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
            r11 = r4;
            r2 = this;
        L14:
            th = th;
            r2 = this;
            goto L31
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$untilNull$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "E", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$untilNull$1", f = "MouseWheelScrollable.kt", i = {0}, l = {179}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
    public static final class C01431<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<E> $builderAction;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C01431(Function0<? extends E> r1, Continuation<? super C01431> r2) {
            this.$builderAction = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01431 r0 = new C01431(this.$builderAction, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((SequenceScope) r1, (Continuation) r2);
        }

        public final Object invoke(SequenceScope<? super E> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0039 -> B:15:0x003d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003c -> B:15:0x003d). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Object r2 = this.L$1;
            SequenceScope r3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r6);
            C01431<E> r7 = this;
        L15:
            if (r2 == null) goto L17;
        L9:
            r2 = r7.$builderAction.invoke();
            if (r2 == null) goto L14;
            r7.L$0 = r3;
            r7.L$1 = r2;
            r7.label = 1;
            if (r3.yield(r2, r7) != r0) goto L15;
            return r0;
        L14:
            r2 = null;
            goto L15
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            r3 = (SequenceScope) this.L$0;
            r7 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic", f = "MouseWheelScrollable.kt", i = {}, l = {122}, m = "userScroll", n = {}, s = {})
    public static final class C01441 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MouseWheelScrollingLogic this$0;

        public C01441(MouseWheelScrollingLogic r1, Continuation<? super C01441> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= RtlSpacingHelper.UNDEFINED;
            return MouseWheelScrollingLogic.access$userScroll(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$userScroll$2", f = "MouseWheelScrollable.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01452 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<NestedScrollScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ ScrollingLogic $this_userScroll;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C01452(ScrollingLogic r1, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super C01452> r3) {
            this.$this_userScroll = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01452(this.$this_userScroll, this.$block, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
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
            ScrollingLogic r6 = this.$this_userScroll;
            MutatePriority r2 = MutatePriority.UserInput;
            Function2<NestedScrollScope, Continuation<? super Unit>, Object> r3 = this.$block;
            this.label = 1;
            if (r6.scroll(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ MouseWheelScrollDelta a(Channel r0) {
        return sumOrNull$lambda$4(r0);
    }

    public static /* synthetic */ Unit b(Ref.FloatRef r0, MouseWheelScrollingLogic r1, NestedScrollScope r2, Function1 r3, AnimationScope r4) {
        return animateMouseWheelScroll$lambda$7(r0, r1, r2, r3, r4);
    }

    public static final /* synthetic */ Channel access$getChannel$p(MouseWheelScrollingLogic r0) {
        return r0.channel;
    }

    public static final /* synthetic */ Density access$getDensity$p(MouseWheelScrollingLogic r0) {
        return r0.density;
    }

    public static final /* synthetic */ ScrollingLogic access$getScrollingLogic$p(MouseWheelScrollingLogic r0) {
        return r0.scrollingLogic;
    }

    private final void consume(PointerEvent r4) {
        List r5 = r4.getChanges();
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((PointerInputChange) ListProtector.get(r5, r1)).consume();
        r1 = r1 + 1;
        goto L3
    }

    private final boolean isConsumed(PointerEvent r5) {
        List r6 = r5.getChanges();
        int r0 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (((PointerInputChange) ListProtector.get(r6, r2)).isConsumed() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    private final MouseWheelScrollDelta sumOrNull(final Channel<MouseWheelScrollDelta> r3) {
        Iterator r4 = untilNull(new s1(r3)).iterator();
        MouseWheelScrollDelta r0 = null;
    L4:
        if (r4.hasNext() == false) goto L9;
        MouseWheelScrollDelta r1 = (MouseWheelScrollDelta) r4.next();
        if (r0 == null) goto L7;
        r0 = r0.plus(r1);
        goto L4
    L7:
        r0 = r1;
        goto L4
    L9:
        return r0;
    }

    private static final MouseWheelScrollDelta sumOrNull$lambda$4(Channel r0) {
        return (MouseWheelScrollDelta) kotlinx.coroutines.channels.g.b(r0.tryReceive-PtdJZtk());
    }

    private final void trackVelocity(MouseWheelScrollDelta r6) {
        this.velocityTracker.m612addDeltaUv8p0NA(r6.getTimeMillis(), r6.m611getValueF1C5BW0());
    }

    private final <E> Sequence<E> untilNull(Function0<? extends E> r3) {
        return SequencesKt.sequence(new C01431(r3, null));
    }

    public final void startReceivingMouseWheelEvents(CoroutineScope r8) {
        if (this.receivingMouseWheelEventsJob != null) goto L6;
        this.receivingMouseWheelEventsJob = BuildersKt.launch$default(r8, null, null, new C01421(this, null), 3, null);
        return;
    }

    public final void updateDensity(Density r1) {
        this.density = r1;
    }

    public static final /* synthetic */ void access$setReceivingMouseWheelEventsJob$p(MouseWheelScrollingLogic r0, Job r1) {
        r0.receivingMouseWheelEventsJob = r1;
    }

    public static final /* synthetic */ MouseWheelScrollDelta access$sumOrNull(MouseWheelScrollingLogic r0, Channel r1) {
        return r0.sumOrNull(r1);
    }

    public static final /* synthetic */ void access$trackVelocity(MouseWheelScrollingLogic r0, MouseWheelScrollDelta r1) {
        r0.trackVelocity(r1);
    }

    private final Object busyReceive(Channel<MouseWheelScrollDelta> r3, Continuation<? super MouseWheelScrollDelta> r4) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(r3, null), r4);
    }

    /* JADX INFO: renamed from: canConsumeDelta-Uv8p0NA, reason: not valid java name */
    private final boolean m605canConsumeDeltaUv8p0NA(ScrollingLogic r3, long r4) {
        float r5 = r3.m701toFloatk4lQ0M(r3.m699reverseIfNeededMKHz9U(r4));
        if (r5 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return false;
    L9:
        if (r5 <= MenuKt.ClosedAlphaTarget) goto L12;
        return r3.getScrollableState().getCanScrollForward();
    L12:
        return r3.getScrollableState().getCanScrollBackward();
    L5:
        r1 = false;
        goto L6
    }

    private final float dispatchMouseWheelScroll(NestedScrollScope r4, float r5) {
        ScrollingLogic r0 = this.scrollingLogic;
        return r0.m701toFloatk4lQ0M(r0.m699reverseIfNeededMKHz9U(r4.mo614scrollByOzD1aCk(r0.m702toOffsettuRUvjQ(r0.reverseIfNeeded(r5)), NestedScrollSource.Companion.getUserInput-WNlRxjI())));
    }

    /* JADX INFO: renamed from: onMouseWheel-O0kMr_c, reason: not valid java name */
    private final boolean m606onMouseWheelO0kMr_c(PointerEvent r10, long r11) {
        long r3 = this.mouseWheelScrollConfig.mo546calculateMouseWheelScroll8xgXZGE(this.density, r10, r11);
        if (m605canConsumeDeltaUv8p0NA(this.scrollingLogic, r3) == false) goto L13;
        Channel<MouseWheelScrollDelta> r12 = this.channel;
        long r5 = ((PointerInputChange) CollectionsKt.first(r10.getChanges())).getUptimeMillis();
        if (this.mouseWheelScrollConfig.isSmoothScrollingEnabled() == true) goto L7;
    L10:
        boolean r7 = true;
    L11:
        Object r13 = r12.trySend-JP2dKIU(new MouseWheelScrollDelta(r3, r5, r7, null));
        kotlinx.coroutines.channels.g.c r14 = kotlinx.coroutines.channels.g.b;
        return !(r13 instanceof kotlinx.coroutines.channels.g.c);
    L7:
        if (this.mouseWheelScrollConfig.isPreciseWheelScroll(r10) == true) goto L10;
        r7 = false;
        goto L11
    L13:
        return this.isScrolling;
    }

    public static final /* synthetic */ Object access$busyReceive(MouseWheelScrollingLogic r0, Channel r1, Continuation r2) {
        return r0.busyReceive(r1, r2);
    }

    public static final /* synthetic */ float access$dispatchMouseWheelScroll(MouseWheelScrollingLogic r0, NestedScrollScope r1, float r2) {
        return r0.dispatchMouseWheelScroll(r1, r2);
    }

    private final Object userScroll(ScrollingLogic r5, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C01441) == false) goto L7;
        C01441 r0 = (C01441) r7;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        this.isScrolling = false;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        this.isScrolling = true;
        C01452 r9 = new C01452(r5, r6, null);
        r0.label = 1;
        if (SupervisorKt.supervisorScope(r9, r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new C01441(this, r7);
        goto L8
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public final void m607onPointerEventH0pRuoY(PointerEvent r5, PointerEventPass r6, long r7) {
        if (r6 == PointerEventPass.Main) goto L5;
        return;
    L5:
        if (PointerEventType.equals-impl0(r5.getType-7fucELk(), PointerEventType.Companion.getScroll-7fucELk()) == false) goto L20;
        List r8 = r5.getChanges();
        int r0 = r8.size();
        boolean r1 = false;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L12;
        if (((PointerInputChange) ListProtector.get(r8, r2)).isConsumed() == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        r1 = true;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        if (m606onMouseWheelO0kMr_c(r5, r7) == false) goto L22;
        consume(r5);
        return;
    L22:
        return;
    }

    public MouseWheelScrollingLogic(ScrollingLogic r1, ScrollConfig r2, Function2<? super Velocity, ? super Continuation<? super Unit>, ? extends Object> r3, Density r4) {
        this.scrollingLogic = r1;
        this.mouseWheelScrollConfig = r2;
        this.onScrollStopped = r3;
        this.density = r4;
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.velocityTracker = new MouseWheelVelocityTracker();
    }

    public static final /* synthetic */ Object access$userScroll(MouseWheelScrollingLogic r0, ScrollingLogic r1, Function2 r2, Continuation r3) {
        return r0.userScroll(r1, r2, r3);
    }

    private static final Unit animateMouseWheelScroll$lambda$7(Ref.FloatRef r2, MouseWheelScrollingLogic r3, NestedScrollScope r4, Function1 r5, AnimationScope r6) {
        float r0 = ((Number) r6.getValue()).floatValue() - r2.element;
        if (MouseWheelScrollableKt.access$isLowScrollingDelta(r0) == true) goto L10;
        if (MouseWheelScrollableKt.access$isLowScrollingDelta(r0 - r3.dispatchMouseWheelScroll(r4, r0)) == true) goto L8;
        r6.cancelAnimation();
        return Unit.INSTANCE;
    L8:
        r2.element += r0;
    L10:
        if (((Boolean) r5.invoke(Float.valueOf(r2.element))).booleanValue() == false) goto L13;
        r6.cancelAnimation();
    L13:
        return Unit.INSTANCE;
    }

    private final Object dispatchMouseWheelScroll(ScrollingLogic r26, MouseWheelScrollDelta r27, float r28, float r29, Continuation<? super Unit> r30) {
        ScrollingLogic r10 = r26;
        if ((r30 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r30;
        int r3 = r2.label;
        if ((r3 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r2.label = r3 - RtlSpacingHelper.UNDEFINED;
    L8:
        AnonymousClass1 r11 = r2;
        Object r1 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r11.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L34:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r0 = r11.F$0;
        Ref.FloatRef r5 = (Ref.FloatRef) r11.L$1;
        ScrollingLogic r6 = (ScrollingLogic) r11.L$0;
        ResultKt.throwOnFailure(r1);
        r10 = r6;
    L27:
        long r7 = this.velocityTracker.m613calculateVelocity9UxMQ8M();
        if (Velocity.equals-impl0(r7, Velocity.Companion.getZero-9UxMQ8M()) == false) goto L30;
        r7 = r10.m703toVelocityadjELrA((r10.reverseIfNeeded(Math.signum(r5.element)) * Math.min(Math.abs(r5.element) / 100, r0)) * 1000);
    L30:
        Function2<Velocity, Continuation<? super Unit>, Object> r8 = this.onScrollStopped;
        Velocity r9 = Velocity.box-impl(r7);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 2;
        if (r8.invoke(r9, r11) != r12) goto L34;
        return r12;
    L16:
        ResultKt.throwOnFailure(r1);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = r27;
        trackVelocity(r27);
        MouseWheelScrollDelta r14 = sumOrNull(this.channel);
        if (r14 == null) goto L19;
        trackVelocity(r14);
        r13.element = ((MouseWheelScrollDelta) r13.element).plus(r14);
    L19:
        Ref.FloatRef r15 = new Ref.FloatRef();
        float r16 = r10.m701toFloatk4lQ0M(r10.m699reverseIfNeededMKHz9U(((MouseWheelScrollDelta) r13.element).m611getValueF1C5BW0()));
        r15.element = r16;
        if (MouseWheelScrollableKt.access$isLowScrollingDelta(r16) == true) goto L22;
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        r17.element = AnimationStateKt.AnimationState$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
        AnonymousClass3 r18 = new AnonymousClass3(r15, r17, r13, r28, this, r29, r26, null);
        r11.L$0 = r10;
        r11.L$1 = r15;
        r0 = r29;
        r11.F$0 = r0;
        r11.label = 1;
        if (userScroll(r10, r18, r11) != r12) goto L26;
        return r12;
    L26:
        r5 = r15;
        goto L27
    L22:
        return Unit.INSTANCE;
    L7:
        r2 = new AnonymousClass1(this, r30);
        goto L8
    }

    public static final /* synthetic */ Object access$dispatchMouseWheelScroll(MouseWheelScrollingLogic r0, ScrollingLogic r1, MouseWheelScrollDelta r2, float r3, float r4, Continuation r5) {
        return r0.dispatchMouseWheelScroll(r1, r2, r3, r4, r5);
    }

    private final Object animateMouseWheelScroll(final NestedScrollScope r9, AnimationState<Float, AnimationVector1D> r10, float r11, int r12, final Function1<? super Float, Boolean> r13, Continuation<? super Unit> r14) {
        final Ref.FloatRef r0 = new Ref.FloatRef();
        r0.element = r10.getValue().floatValue();
        Object r15 = SuspendAnimationKt.animateTo(r10, Boxing.boxFloat(r11), AnimationSpecKt.tween$default(r12, 0, EasingKt.getLinearEasing(), 2, null), true, new t1(r0, this, r9, r13), r14);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r15;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$animateMouseWheelScroll(MouseWheelScrollingLogic r0, NestedScrollScope r1, AnimationState r2, float r3, int r4, Function1 r5, Continuation r6) {
        return r0.animateMouseWheelScroll(r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ Object access$dispatchMouseWheelScroll$waitNextScrollDelta(MouseWheelScrollingLogic r0, Ref.ObjectRef r1, Ref.FloatRef r2, ScrollingLogic r3, Ref.ObjectRef r4, long r5, Continuation r7) {
        return dispatchMouseWheelScroll$waitNextScrollDelta(r0, r1, r2, r3, r4, r5, r7);
    }

    private static final Object dispatchMouseWheelScroll$waitNextScrollDelta(MouseWheelScrollingLogic r21, Ref.ObjectRef<MouseWheelScrollDelta> r22, Ref.FloatRef r23, ScrollingLogic r24, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> r25, long r26, Continuation<? super Boolean> r28) {
        MouseWheelScrollingLogic r0 = r21;
        if ((r28 instanceof MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1) == false) goto L7;
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1 r4 = (MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1) r28;
        int r5 = r4.label;
        if ((r5 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r4.label = r5 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        boolean r8 = false;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> r1 = (Ref.ObjectRef) r4.L$4;
        ScrollingLogic r2 = (ScrollingLogic) r4.L$3;
        Ref.FloatRef r9 = (Ref.FloatRef) r4.L$2;
        Ref.ObjectRef<MouseWheelScrollDelta> r10 = (Ref.ObjectRef) r4.L$1;
        MouseWheelScrollingLogic r11 = (MouseWheelScrollingLogic) r4.L$0;
        ResultKt.throwOnFailure(r3);
        Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> r12 = r1;
        ScrollingLogic r13 = r2;
        Ref.FloatRef r14 = r9;
        r0 = r11;
    L22:
        MouseWheelScrollDelta r15 = (MouseWheelScrollDelta) r3;
        if (r15 == null) goto L26;
        MouseWheelScrollDelta r16 = MouseWheelScrollDelta.m608copy9KIMszo$default(r15, 0, 0, ((MouseWheelScrollDelta) r10.element).getShouldApplyImmediately(), 3, null);
        r10.element = r16;
        r14.element = r13.m701toFloatk4lQ0M(r13.m699reverseIfNeededMKHz9U(r16.m611getValueF1C5BW0()));
        r12.element = AnimationStateKt.AnimationState$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, 0, false, 30, null);
        r0.trackVelocity(r15);
        r8 = !MouseWheelScrollableKt.access$isLowScrollingDelta(r14.element);
    L26:
        return Boxing.boxBoolean(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        if (r26 < 0) goto L17;
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$2 r17 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$2(r0, null);
        r4.L$0 = r0;
        r4.L$1 = r22;
        r14 = r23;
        r4.L$2 = r14;
        r13 = r24;
        r4.L$3 = r13;
        r12 = r25;
        r4.L$4 = r12;
        r4.label = 1;
        r3 = TimeoutKt.c(r26, r17, r4);
        if (r3 != r6) goto L21;
        return r6;
    L21:
        r10 = r22;
        goto L22
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r4 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$1(r28);
        goto L8
    }
}
