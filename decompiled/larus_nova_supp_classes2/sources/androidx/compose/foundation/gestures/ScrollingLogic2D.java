package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010!\u001a\u00020 *\u00020\u001a2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u0015\u0010&\u001a\u00020\f2\u0006\u0010*\u001a\u00020+¢\u0006\u0004\b,\u0010)J\u0017\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0002¢\u0006\u0004\b2\u00100J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020+H\u0086@¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020 H\u0002¢\u0006\u0004\b:\u0010)J\u0018\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020+H\u0096@¢\u0006\u0004\b=\u00107J\u0006\u0010>\u001a\u00020\fJA\u0010.\u001a\u0002042\b\b\u0002\u0010?\u001a\u00020@2'\u0010A\u001a#\b\u0001\u0012\u0004\u0012\u00020C\u0012\n\u0012\b\u0012\u0004\u0012\u0002040D\u0012\u0006\u0012\u0004\u0018\u00010E0B¢\u0006\u0002\bFH\u0086@¢\u0006\u0002\u0010GJ(\u0010H\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/Scrollable2DState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/Scrollable2DState;)V", "value", "isFlinging", "()Z", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/Scroll2DScope;JI)J", "shouldDispatchOverscroll", "offset", "shouldDispatchOverscroll-k-4lQ0M", "(J)Z", "velocity", "Landroidx/compose/ui/unit/Velocity;", "shouldDispatchOverscroll-TH1AsA0", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "onScrollStopped-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldCancelFling", "pixels", "shouldCancelFling-k-4lQ0M", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollingLogic2D implements ScrollLogic {
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private int latestScrollSource;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final ScrollingLogic2D$nestedScrollScope$1 nestedScrollScope;
    private Scroll2DScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1<Offset, Offset> performScrollForOverscroll;
    private Scrollable2DState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic2D$scroll$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$scroll$2", f = "Scrollable2D.kt", i = {}, l = {496}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<NestedScrollScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ScrollingLogic2D this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(ScrollingLogic2D r1, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(Scroll2DScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Scroll2DScope) r1, (Continuation) r2);
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
            Scroll2DScope r5 = (Scroll2DScope) this.L$0;
            ScrollingLogic2D.access$setOuterStateScope$p(this.this$0, r5);
            Function2<NestedScrollScope, Continuation<? super Unit>, Object> r6 = this.$block;
            ScrollingLogic2D$nestedScrollScope$1 r2 = ScrollingLogic2D.access$getNestedScrollScope$p(this.this$0);
            this.label = 1;
            if (r6.invoke(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Offset a(ScrollingLogic2D r0, Offset r1) {
        return performScrollForOverscroll$lambda$1(r0, r1);
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress() == true) goto L9;
        OverscrollEffect r0 = this.overscrollEffect;
        if (r0 == null) goto L7;
        boolean r1 = r0.isInProgress();
    L8:
        if (r1 == true) goto L9;
        return false;
    L7:
        r1 = false;
    L9:
        return true;
    }

    public final Scrollable2DState getScrollableState() {
        return this.scrollableState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    public boolean isFlinging() {
        return this.isFlinging;
    }

    public static final /* synthetic */ float access$doFlingAnimation_QWom1Mo$toMagnitudeFloat(long r0) {
        return doFlingAnimation_QWom1Mo$toMagnitudeFloat(r0);
    }

    public static final /* synthetic */ FlingBehavior access$getFlingBehavior$p(ScrollingLogic2D r0) {
        return r0.flingBehavior;
    }

    public static final /* synthetic */ int access$getLatestScrollSource$p(ScrollingLogic2D r0) {
        return r0.latestScrollSource;
    }

    public static final /* synthetic */ NestedScrollDispatcher access$getNestedScrollDispatcher$p(ScrollingLogic2D r0) {
        return r0.nestedScrollDispatcher;
    }

    public static final /* synthetic */ ScrollingLogic2D$nestedScrollScope$1 access$getNestedScrollScope$p(ScrollingLogic2D r0) {
        return r0.nestedScrollScope;
    }

    public static final /* synthetic */ Scroll2DScope access$getOuterStateScope$p(ScrollingLogic2D r0) {
        return r0.outerStateScope;
    }

    public static final /* synthetic */ OverscrollEffect access$getOverscrollEffect$p(ScrollingLogic2D r0) {
        return r0.overscrollEffect;
    }

    public static final /* synthetic */ Function1 access$getPerformScrollForOverscroll$p(ScrollingLogic2D r0) {
        return r0.performScrollForOverscroll;
    }

    public static final /* synthetic */ Function0 access$isScrollableNodeAttached$p(ScrollingLogic2D r0) {
        return r0.isScrollableNodeAttached;
    }

    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    private final long m707dispatchRawDeltaMKHz9U(long r2) {
        return this.scrollableState.mo562dispatchRawDeltaMKHz9U(r2);
    }

    private static final float doFlingAnimation_QWom1Mo$toMagnitudeFloat(long r6) {
        double r2 = 2;
        return (float) Math.sqrt(((float) Math.pow(Float.intBitsToFloat((int) (r6 >> 32)), r2)) + ((float) Math.pow(Float.intBitsToFloat((int) (r6 & 4294967295L)), r2)));
    }

    /* JADX INFO: renamed from: shouldCancelFling-k-4lQ0M, reason: not valid java name */
    private final boolean m709shouldCancelFlingk4lQ0M(long r2) {
        if (this.scrollableState.mo561canScrollk4lQ0M(r2) == true) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) this.isScrollableNodeAttached.invoke()).booleanValue() == false) goto L8;
        return false;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U */
    public long mo657performRawScrollMKHz9U(long r2) {
        if (this.scrollableState.isScrollInProgress() == false) goto L6;
        return Offset.Companion.getZero-F1C5BW0();
    L6:
        return m707dispatchRawDeltaMKHz9U(r2);
    }

    public final void setScrollableState(Scrollable2DState r1) {
        this.scrollableState = r1;
    }

    /* JADX INFO: renamed from: shouldDispatchOverscroll-TH1AsA0, reason: not valid java name */
    public final boolean m711shouldDispatchOverscrollTH1AsA0(long r6) {
        Scrollable2DState r0 = this.scrollableState;
        float r1 = Velocity.getX-impl(r6);
        float r7 = Velocity.getY-impl(r6);
        long r2 = Float.floatToRawIntBits(r1);
        return r0.mo561canScrollk4lQ0M(Offset.constructor-impl((((long) Float.floatToRawIntBits(r7)) & 4294967295L) | (r2 << 32)));
    }

    /* JADX INFO: renamed from: shouldDispatchOverscroll-k-4lQ0M, reason: not valid java name */
    public final boolean m712shouldDispatchOverscrollk4lQ0M(long r2) {
        return this.scrollableState.mo561canScrollk4lQ0M(r2);
    }

    public static final /* synthetic */ long access$doFlingAnimation_QWom1Mo$toDecomposedOffset(float r0, long r1) {
        return doFlingAnimation_QWom1Mo$toDecomposedOffset(r0, r1);
    }

    public static final /* synthetic */ long access$doFlingAnimation_QWom1Mo$toDecomposedVelocity(float r0, long r1) {
        return doFlingAnimation_QWom1Mo$toDecomposedVelocity(r0, r1);
    }

    public static final /* synthetic */ void access$setLatestScrollSource$p(ScrollingLogic2D r0, int r1) {
        r0.latestScrollSource = r1;
    }

    public static final /* synthetic */ void access$setOuterStateScope$p(ScrollingLogic2D r0, Scroll2DScope r1) {
        r0.outerStateScope = r1;
    }

    /* JADX INFO: renamed from: access$shouldCancelFling-k-4lQ0M, reason: not valid java name */
    public static final /* synthetic */ boolean m706access$shouldCancelFlingk4lQ0M(ScrollingLogic2D r0, long r1) {
        return r0.m709shouldCancelFlingk4lQ0M(r1);
    }

    private static final long doFlingAnimation_QWom1Mo$toDecomposedOffset(float r6, long r7) {
        if (Float.isNaN(Scrollable2DKt.m659access$getAngleTH1AsA0(r7)) == true) goto L7;
        float r0 = Math.abs(((float) Math.cos(Scrollable2DKt.m659access$getAngleTH1AsA0(r7))) * r6) * Math.signum(Velocity.getX-impl(r7));
        float r8 = Math.abs(((float) Math.sin(Scrollable2DKt.m659access$getAngleTH1AsA0(r7))) * r6) * Math.signum(Velocity.getY-impl(r7));
        return Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (Float.floatToRawIntBits(r8) & 4294967295L));
    L7:
        return Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (Float.floatToRawIntBits(r6) & 4294967295L));
    }

    private static final long doFlingAnimation_QWom1Mo$toDecomposedVelocity(float r3, long r4) {
        if (Float.isNaN(Scrollable2DKt.m659access$getAngleTH1AsA0(r4)) == false) goto L6;
        return VelocityKt.Velocity(MenuKt.ClosedAlphaTarget, r3);
    L6:
        return VelocityKt.Velocity(Math.abs(((float) Math.cos(Scrollable2DKt.m659access$getAngleTH1AsA0(r4))) * r3) * Math.signum(Velocity.getX-impl(r4)), Math.abs(((float) Math.sin(Scrollable2DKt.m659access$getAngleTH1AsA0(r4))) * r3) * Math.signum(Velocity.getY-impl(r4)));
    }

    private static final Offset performScrollForOverscroll$lambda$1(ScrollingLogic2D r3, Offset r4) {
        return Offset.box-impl(r3.m708performScroll3eAAhYA(r3.outerStateScope, r4.unbox-impl(), r3.latestScrollSource));
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo */
    public Object mo656doFlingAnimationQWom1Mo(long r13, Continuation<? super Velocity> r15) {
        if ((r15 instanceof ScrollingLogic2D$doFlingAnimation$1) == false) goto L7;
        ScrollingLogic2D$doFlingAnimation$1 r0 = (ScrollingLogic2D$doFlingAnimation$1) r15;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        Ref.LongRef r14 = (Ref.LongRef) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L23
    L21:
        this.isFlinging = false;
        return Velocity.box-impl(r14.element);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r16);
        Ref.LongRef r17 = new Ref.LongRef();
        r17.element = r13;
        this.isFlinging = true;
        MutatePriority r4 = MutatePriority.Default;     // Catch: Throwable -> L23
        ScrollingLogic2D$doFlingAnimation$2 r11 = new ScrollingLogic2D$doFlingAnimation$2(this, r13, r17, null);     // Catch: Throwable -> L23
        r0.L$0 = r17;     // Catch: Throwable -> L23
        r0.label = 1;     // Catch: Throwable -> L23
        if (scroll(r4, r11, r0) != r2) goto L20;
        return r2;
    L20:
        r14 = r17;
    L23:
        th = move-exception;
        this.isFlinging = false;
        throw th;
    L7:
        r0 = new ScrollingLogic2D$doFlingAnimation$1(this, r15);
        goto L8
    }

    /* JADX INFO: renamed from: onScrollStopped-sF-c-tU, reason: not valid java name */
    public final Object m710onScrollStoppedsFctU(long r4, Continuation<? super Unit> r6) {
        ScrollingLogic2D$onScrollStopped$performFling$1 r0 = new ScrollingLogic2D$onScrollStopped$performFling$1(this, null);
        OverscrollEffect r1 = this.overscrollEffect;
        if (r1 != null) goto L5;
    L11:
        Object r5 = r0.invoke(Velocity.box-impl(r4), r6);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r5;
    L15:
        return Unit.INSTANCE;
    L5:
        if (m711shouldDispatchOverscrollTH1AsA0(r4) == false) goto L11;
        Object r7 = r1.mo319applyToFlingBMRW4eQ(r4, r0, r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r7;
    L10:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    private final long m708performScroll3eAAhYA(Scroll2DScope r11, long r12, int r14) {
        long r0 = this.nestedScrollDispatcher.dispatchPreScroll-OzD1aCk(r12, r14);
        long r13 = Offset.minus-MK-Hz9U(r12, r0);
        long r8 = r11.mo563scrollByMKHz9U(r13);
        long r5 = Offset.minus-MK-Hz9U(r13, r8);
        long r15 = this.nestedScrollDispatcher.dispatchPostScroll-DzOQY0M(r8, r5, r14);
        return Offset.plus-MK-Hz9U(Offset.plus-MK-Hz9U(r0, r8), r15);
    }

    public final Object scroll(MutatePriority r4, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        Object r7 = this.scrollableState.scroll(r4, new AnonymousClass2(this, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$performScroll-3eAAhYA, reason: not valid java name */
    public static final /* synthetic */ long m705access$performScroll3eAAhYA(ScrollingLogic2D r0, Scroll2DScope r1, long r2, int r4) {
        return r0.m708performScroll3eAAhYA(r1, r2, r4);
    }

    public final boolean update(Scrollable2DState r2, OverscrollEffect r3, FlingBehavior r4, NestedScrollDispatcher r5) {
        if (Intrinsics.areEqual(this.scrollableState, r2) == true) goto L5;
        this.scrollableState = r2;
        boolean r6 = true;
    L6:
        this.overscrollEffect = r3;
        this.flingBehavior = r4;
        this.nestedScrollDispatcher = r5;
        return r6;
    L5:
        r6 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic2D$nestedScrollScope$1] */
    public ScrollingLogic2D(Scrollable2DState r1, OverscrollEffect r2, FlingBehavior r3, NestedScrollDispatcher r4, Function0<Boolean> r5) {
        this.scrollableState = r1;
        this.overscrollEffect = r2;
        this.flingBehavior = r3;
        this.nestedScrollDispatcher = r4;
        this.isScrollableNodeAttached = r5;
        this.latestScrollSource = NestedScrollSource.Companion.getUserInput-WNlRxjI();
        this.outerStateScope = Scrollable2DKt.access$getNoOpScrollScope$p();
        this.nestedScrollScope = new ScrollingLogic2D$nestedScrollScope$1(this);
        this.performScrollForOverscroll = new l2(this);
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic2D r0, MutatePriority r1, Function2 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return r0.scroll(r1, r2, r3);
    }
}
