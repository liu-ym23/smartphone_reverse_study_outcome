package androidx.compose.foundation.gestures;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.compose.foundation.ComposeFoundationFlags;
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
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00018\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u001b\u001a\u00020\u001c*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u00020'*\u00020\u001d¢\u0006\u0004\b(\u0010\u001fJ\u0013\u0010#\u001a\u00020\u001d*\u00020'H\u0002¢\u0006\u0004\b)\u0010%J\u0013\u0010*\u001a\u00020'*\u00020'H\u0002¢\u0006\u0004\b+\u0010\"J\u001b\u0010,\u001a\u00020'*\u00020'2\u0006\u0010-\u001a\u00020\u001dH\u0002¢\u0006\u0004\b.\u0010/J\n\u00100\u001a\u00020\u001d*\u00020\u001dJ\u0011\u00100\u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b1\u0010\"J#\u0010<\u001a\u00020\u001c*\u0002062\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u000203H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u001cH\u0016¢\u0006\u0004\bE\u0010\"J\u0017\u0010F\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u001cH\u0002¢\u0006\u0004\bG\u0010\"J \u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020\u000bH\u0086@¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u001dH\u0002J\u0018\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020'H\u0096@¢\u0006\u0004\bR\u0010SJ\u0006\u0010T\u001a\u00020\u000bJA\u0010D\u001a\u00020I2\b\b\u0002\u0010U\u001a\u00020V2'\u0010W\u001a#\b\u0001\u0012\u0004\u0012\u00020Y\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0Z\u0012\u0006\u0012\u0004\u0018\u00010[0X¢\u0006\u0002\b\\H\u0086@¢\u0006\u0002\u0010]J8\u0010,\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010^\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u001a¨\u0006_"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "onScrollChangedDispatcher", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "value", "isFlinging", "()Z", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "", "toOffset-tuRUvjQ", "(F)J", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat-TH1AsA0", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "update", "newValue", "update-QWom1Mo", "(JF)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "performRawScroll", "scroll", "performRawScroll-MK-Hz9U", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "isMouseWheel", "onScrollStopped-BMRW4eQ", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldCancelFling", "pixels", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollingLogic implements ScrollLogic {
    public static final int $stable = 8;
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private int latestScrollSource;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope;
    private OnScrollChangedDispatcher onScrollChangedDispatcher;
    private Orientation orientation;
    private ScrollScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1<Offset, Offset> performScrollForOverscroll;
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$scroll$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$scroll$2", f = "Scrollable.kt", i = {}, l = {861}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<NestedScrollScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ScrollingLogic this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(ScrollingLogic r1, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$block = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(ScrollScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ScrollScope) r1, (Continuation) r2);
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
            ScrollScope r5 = (ScrollScope) this.L$0;
            ScrollingLogic.access$setOuterStateScope$p(this.this$0, r5);
            Function2<NestedScrollScope, Continuation<? super Unit>, Object> r6 = this.$block;
            ScrollingLogic$nestedScrollScope$1 r2 = ScrollingLogic.access$getNestedScrollScope$p(this.this$0);
            this.label = 1;
            if (r6.invoke(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Offset a(ScrollingLogic r0, Offset r1) {
        return performScrollForOverscroll$lambda$1(r0, r1);
    }

    private final boolean getShouldDispatchOverscroll() {
        if (this.scrollableState.getCanScrollForward() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.scrollableState.getCanScrollBackward() == true) goto L8;
        return false;
    }

    public final boolean isVertical() {
        if (this.orientation != Orientation.Vertical) goto L5;
        return true;
    L5:
        return false;
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

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    public boolean isFlinging() {
        return this.isFlinging;
    }

    public static final /* synthetic */ FlingBehavior access$getFlingBehavior$p(ScrollingLogic r0) {
        return r0.flingBehavior;
    }

    public static final /* synthetic */ int access$getLatestScrollSource$p(ScrollingLogic r0) {
        return r0.latestScrollSource;
    }

    public static final /* synthetic */ NestedScrollDispatcher access$getNestedScrollDispatcher$p(ScrollingLogic r0) {
        return r0.nestedScrollDispatcher;
    }

    public static final /* synthetic */ ScrollingLogic$nestedScrollScope$1 access$getNestedScrollScope$p(ScrollingLogic r0) {
        return r0.nestedScrollScope;
    }

    public static final /* synthetic */ ScrollScope access$getOuterStateScope$p(ScrollingLogic r0) {
        return r0.outerStateScope;
    }

    public static final /* synthetic */ OverscrollEffect access$getOverscrollEffect$p(ScrollingLogic r0) {
        return r0.overscrollEffect;
    }

    public static final /* synthetic */ Function1 access$getPerformScrollForOverscroll$p(ScrollingLogic r0) {
        return r0.performScrollForOverscroll;
    }

    public static final /* synthetic */ boolean access$getShouldDispatchOverscroll(ScrollingLogic r0) {
        return r0.getShouldDispatchOverscroll();
    }

    public static final /* synthetic */ Function0 access$isScrollableNodeAttached$p(ScrollingLogic r0) {
        return r0.isScrollableNodeAttached;
    }

    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    private final long m693dispatchRawDeltaMKHz9U(long r2) {
        return m702toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m701toFloatk4lQ0M(r2)))));
    }

    private final boolean shouldCancelFling(float r3) {
        if (r3 <= MenuKt.ClosedAlphaTarget) goto L7;
        if (this.scrollableState.getCanScrollForward() == true) goto L7;
    L12:
        return true;
    L7:
        if (r3 >= MenuKt.ClosedAlphaTarget) goto L11;
        if (this.scrollableState.getCanScrollBackward() == false) goto L12;
    L11:
        if (((Boolean) this.isScrollableNodeAttached.invoke()).booleanValue() == false) goto L12;
        return false;
    }

    /* JADX INFO: renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m695singleAxisVelocityAH228Gc(long r9) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Velocity.copy-OhffZ5M$default(r9, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1, null);
    L6:
        return Velocity.copy-OhffZ5M$default(r9, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    private final float m696toFloatTH1AsA0(long r3) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Velocity.getX-impl(r3);
    L6:
        return Velocity.getY-impl(r3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U */
    public long mo657performRawScrollMKHz9U(long r2) {
        if (this.scrollableState.isScrollInProgress() == false) goto L6;
        return Offset.Companion.getZero-F1C5BW0();
    L6:
        return m693dispatchRawDeltaMKHz9U(r2);
    }

    public final float reverseIfNeeded(float r2) {
        if (this.reverseDirection == true) goto L5;
        return r2;
    L5:
        return r2 * (-1);
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m699reverseIfNeededMKHz9U(long r2) {
        if (this.reverseDirection == true) goto L5;
        return r2;
    L5:
        return Offset.times-tuRUvjQ(r2, -1.0f);
    }

    public final void setScrollableState(ScrollableState r1) {
        this.scrollableState = r1;
    }

    /* JADX INFO: renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m700singleAxisOffsetMKHz9U(long r9) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Offset.copy-dBAh8RU$default(r9, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1, null);
    L6:
        return Offset.copy-dBAh8RU$default(r9, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m701toFloatk4lQ0M(long r3) {
        if (this.orientation != Orientation.Horizontal) goto L5;
        long r4 = r3 >> 32;
    L7:
        return Float.intBitsToFloat((int) r4);
    L5:
        r4 = r3 & 4294967295L;
        goto L7
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m702toOffsettuRUvjQ(float r9) {
        if (r9 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return Offset.Companion.getZero-F1C5BW0();
    L9:
        if (this.orientation != Orientation.Horizontal) goto L12;
        return Offset.constructor-impl((Float.floatToRawIntBits(r9) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
    L12:
        return Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r9)) & 4294967295L));
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m703toVelocityadjELrA(float r4) {
        if (r4 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return Velocity.Companion.getZero-9UxMQ8M();
    L9:
        if (this.orientation != Orientation.Horizontal) goto L12;
        return VelocityKt.Velocity(r4, MenuKt.ClosedAlphaTarget);
    L12:
        return VelocityKt.Velocity(MenuKt.ClosedAlphaTarget, r4);
    L5:
        r1 = false;
        goto L6
    }

    public static final /* synthetic */ void access$setLatestScrollSource$p(ScrollingLogic r0, int r1) {
        r0.latestScrollSource = r1;
    }

    public static final /* synthetic */ void access$setOuterStateScope$p(ScrollingLogic r0, ScrollScope r1) {
        r0.outerStateScope = r1;
    }

    public static final /* synthetic */ boolean access$shouldCancelFling(ScrollingLogic r0, float r1) {
        return r0.shouldCancelFling(r1);
    }

    /* JADX INFO: renamed from: access$toFloat-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ float m691access$toFloatTH1AsA0(ScrollingLogic r0, long r1) {
        return r0.m696toFloatTH1AsA0(r1);
    }

    private static final Offset performScrollForOverscroll$lambda$1(ScrollingLogic r3, Offset r4) {
        return Offset.box-impl(r3.m694performScroll3eAAhYA(r3.outerStateScope, r4.unbox-impl(), r3.latestScrollSource));
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    private final long m697updateQWom1Mo(long r9, float r11) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Velocity.copy-OhffZ5M$default(r9, r11, MenuKt.ClosedAlphaTarget, 2, null);
    L6:
        return Velocity.copy-OhffZ5M$default(r9, MenuKt.ClosedAlphaTarget, r11, 1, null);
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo */
    public Object mo656doFlingAnimationQWom1Mo(long r13, Continuation<? super Velocity> r15) {
        if ((r15 instanceof ScrollingLogic$doFlingAnimation$1) == false) goto L7;
        ScrollingLogic$doFlingAnimation$1 r0 = (ScrollingLogic$doFlingAnimation$1) r15;
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
        ScrollingLogic$doFlingAnimation$2 r11 = new ScrollingLogic$doFlingAnimation$2(this, r17, r13, null);     // Catch: Throwable -> L23
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
        r0 = new ScrollingLogic$doFlingAnimation$1(this, r15);
        goto L8
    }

    /* JADX INFO: renamed from: access$update-QWom1Mo, reason: not valid java name */
    public static final /* synthetic */ long m692access$updateQWom1Mo(ScrollingLogic r0, long r1, float r3) {
        return r0.m697updateQWom1Mo(r1, r3);
    }

    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    private final long m694performScroll3eAAhYA(ScrollScope r11, long r12, int r14) {
        long r0 = this.nestedScrollDispatcher.dispatchPreScroll-OzD1aCk(r12, r14);
        long r13 = Offset.minus-MK-Hz9U(r12, r0);
        long r2 = m699reverseIfNeededMKHz9U(m702toOffsettuRUvjQ(r11.scrollBy(m701toFloatk4lQ0M(m699reverseIfNeededMKHz9U(m700singleAxisOffsetMKHz9U(r13))))));
        if (ComposeFoundationFlags.isOnScrollChangedCallbackEnabled == false) goto L5;
        this.onScrollChangedDispatcher.mo616dispatchScrollDeltaInfok4lQ0M(r2);
    L5:
        long r7 = Offset.minus-MK-Hz9U(r13, r2);
        long r15 = this.nestedScrollDispatcher.dispatchPostScroll-DzOQY0M(r2, r7, r14);
        return Offset.plus-MK-Hz9U(Offset.plus-MK-Hz9U(r0, r2), r15);
    }

    /* JADX INFO: renamed from: onScrollStopped-BMRW4eQ, reason: not valid java name */
    public final Object m698onScrollStoppedBMRW4eQ(long r3, boolean r5, Continuation<? super Unit> r6) {
        if (r5 == true) goto L4;
    L7:
        long r4 = m695singleAxisVelocityAH228Gc(r3);
        ScrollingLogic$onScrollStopped$performFling$1 r7 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        OverscrollEffect r0 = this.overscrollEffect;
        if (r0 != null) goto L10;
    L16:
        Object r8 = r7.invoke(Velocity.box-impl(r4), r6);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r8;
    L20:
        return Unit.INSTANCE;
    L10:
        if (getShouldDispatchOverscroll() == false) goto L16;
        Object r9 = r0.mo319applyToFlingBMRW4eQ(r4, r7, r6);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r9;
    L15:
        return Unit.INSTANCE;
    L4:
        if (ScrollableKt.access$getShouldBeTriggeredByMouseWheel(this.flingBehavior) == true) goto L7;
        return Unit.INSTANCE;
    }

    public final Object scroll(MutatePriority r4, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
        Object r7 = this.scrollableState.scroll(r4, new AnonymousClass2(this, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$performScroll-3eAAhYA, reason: not valid java name */
    public static final /* synthetic */ long m690access$performScroll3eAAhYA(ScrollingLogic r0, ScrollScope r1, long r2, int r4) {
        return r0.m694performScroll3eAAhYA(r1, r2, r4);
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic r0, MutatePriority r1, Function2 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = MutatePriority.Default;
    L6:
        return r0.scroll(r1, r2, r3);
    }

    public final boolean update(ScrollableState r3, Orientation r4, OverscrollEffect r5, boolean r6, FlingBehavior r7, NestedScrollDispatcher r8) {
        boolean r1 = true;
        if (Intrinsics.areEqual(this.scrollableState, r3) == true) goto L5;
        this.scrollableState = r3;
        boolean r9 = true;
    L6:
        this.overscrollEffect = r5;
        if (this.orientation == r4) goto L10;
        this.orientation = r4;
        r9 = true;
    L10:
        if (this.reverseDirection == r6) goto L12;
        this.reverseDirection = r6;
    L13:
        this.flingBehavior = r7;
        this.nestedScrollDispatcher = r8;
        return r1;
    L12:
        r1 = r9;
        goto L13
    L5:
        r9 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState r1, OverscrollEffect r2, FlingBehavior r3, Orientation r4, boolean r5, NestedScrollDispatcher r6, OnScrollChangedDispatcher r7, Function0<Boolean> r8) {
        this.scrollableState = r1;
        this.overscrollEffect = r2;
        this.flingBehavior = r3;
        this.orientation = r4;
        this.reverseDirection = r5;
        this.nestedScrollDispatcher = r6;
        this.onScrollChangedDispatcher = r7;
        this.isScrollableNodeAttached = r8;
        this.latestScrollSource = NestedScrollSource.Companion.getUserInput-WNlRxjI();
        this.outerStateScope = ScrollableKt.access$getNoOpScrollScope$p();
        this.nestedScrollScope = new ScrollingLogic$nestedScrollScope$1(this);
        this.performScrollForOverscroll = new k2(this);
    }
}
