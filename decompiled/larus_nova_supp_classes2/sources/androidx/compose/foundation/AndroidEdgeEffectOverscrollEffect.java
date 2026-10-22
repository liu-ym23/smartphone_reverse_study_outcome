package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.collection.SieveCacheKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0$H\u0016¢\u0006\u0004\b%\u0010&J<\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000201H\u0000¢\u0006\u0004\b5\u00106J\u000f\u00109\u001a\u00020\rH\u0000¢\u0006\u0004\b:\u0010;J\r\u0010B\u001a\u00020\u0013H\u0000¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0013H\u0002J\u0017\u0010E\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bN\u0010LJ\u0017\u0010O\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bP\u0010LJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bR\u0010LR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u00102\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001bR\u0010\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006S"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "scrollCycleInProgress", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containerSize", "Landroidx/compose/ui/geometry/Size;", "isInProgress", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "animateToReleaseIfNeeded", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "pullTop", "", "scroll", "pullTop-k-4lQ0M", "(J)F", "pullBottom", "pullBottom-k-4lQ0M", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;
    private final Density density;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private boolean invalidationEnabled;
    private final DelegatableNode node;
    private long pointerId;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private long pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public /* synthetic */ AndroidEdgeEffectOverscrollEffect(Context r1, Density r2, long r3, PaddingValues r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r5);
    }

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final /* synthetic */ Modifier getEffectModifier() {
        return OverscrollEffect.CC.$default$getEffectModifier(this);
    }

    private final void animateToReleaseIfNeeded() {
        EdgeEffectWrapper r0 = this.edgeEffectWrapper;
        EdgeEffect r1 = EdgeEffectWrapper.access$getTopEffect$p(r0);
        boolean r2 = true;
        if (r1 == null) goto L5;
        r1.onRelease();
        boolean r3 = !r1.isFinished();
    L6:
        EdgeEffect r4 = EdgeEffectWrapper.access$getBottomEffect$p(r0);
        if (r4 == null) goto L14;
        r4.onRelease();
        if (r4.isFinished() == false) goto L13;
        if (r3 == true) goto L13;
        r3 = false;
    L13:
        r3 = true;
    L14:
        EdgeEffect r5 = EdgeEffectWrapper.access$getLeftEffect$p(r0);
        if (r5 == null) goto L22;
        r5.onRelease();
        if (r5.isFinished() == false) goto L21;
        if (r3 == true) goto L21;
        r3 = false;
    L21:
        r3 = true;
    L22:
        EdgeEffect r6 = EdgeEffectWrapper.access$getRightEffect$p(r0);
        if (r6 == null) goto L30;
        r6.onRelease();
        if (r6.isFinished() == false) goto L29;
        if (r3 == true) goto L29;
        r2 = false;
    L29:
        r3 = r2;
    L30:
        if (r3 == false) goto L33;
        invalidateOverscroll$foundation_release();
        return;
    L33:
        return;
    L5:
        r3 = false;
        goto L6
    }

    /* JADX INFO: renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m321displacementF1C5BW0$foundation_release() {
        long r0 = this.pointerPosition;
        if ((SieveCacheKt.InvalidMapping & r0) == 9205357640488583168L) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = SizeKt.getCenter-uvyYCjk(this.containerSize);
    L9:
        float r3 = Float.intBitsToFloat((int) (r0 >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        float r1 = Float.intBitsToFloat((int) (r0 & 4294967295L)) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        long r6 = Float.floatToRawIntBits(r3);
        return Offset.constructor-impl((((long) Float.floatToRawIntBits(r1)) & 4294967295L) | (r6 << 32));
    L5:
        r2 = false;
        goto L6
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled == false) goto L6;
        this.redrawSignal.setValue(Unit.INSTANCE);
        return;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper r0 = this.edgeEffectWrapper;
        EdgeEffect r1 = EdgeEffectWrapper.access$getTopEffect$p(r0);
        if (r1 != null) goto L5;
    L10:
        EdgeEffect r2 = EdgeEffectWrapper.access$getBottomEffect$p(r0);
        if (r2 != null) goto L13;
    L18:
        EdgeEffect r3 = EdgeEffectWrapper.access$getLeftEffect$p(r0);
        if (r3 != null) goto L21;
    L26:
        EdgeEffect r4 = EdgeEffectWrapper.access$getRightEffect$p(r0);
        if (r4 != null) goto L29;
    L34:
        return false;
    L29:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r4) != MenuKt.ClosedAlphaTarget) goto L31;
        boolean r5 = true;
    L32:
        if (r5 == true) goto L34;
        return true;
    L31:
        r5 = false;
        goto L32
    L21:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r3) != MenuKt.ClosedAlphaTarget) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == true) goto L26;
        return true;
    L23:
        r6 = false;
        goto L24
    L13:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r2) != MenuKt.ClosedAlphaTarget) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == true) goto L18;
        return true;
    L15:
        r7 = false;
        goto L16
    L5:
        if (EdgeEffectCompat.INSTANCE.getDistanceCompat(r1) != MenuKt.ClosedAlphaTarget) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L10;
        return true;
    L7:
        r8 = false;
        goto L8
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.node;
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    public static final /* synthetic */ long access$getPointerId$p(AndroidEdgeEffectOverscrollEffect r2) {
        return r2.pointerId;
    }

    /* JADX INFO: renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m314pullBottomk4lQ0M(long r9) {
        float r0 = Float.intBitsToFloat((int) (m321displacementF1C5BW0$foundation_release() >> 32));
        int r10 = (int) (r9 & 4294967295L);
        float r11 = Float.intBitsToFloat(r10) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect r3 = this.edgeEffectWrapper.getOrCreateBottomEffect();
        EdgeEffectCompat r4 = EdgeEffectCompat.INSTANCE;
        boolean r5 = true;
        float r12 = (-r4.onPullDistanceCompat(r3, -r11, 1 - r0)) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        if (r4.getDistanceCompat(r3) == MenuKt.ClosedAlphaTarget) goto L6;
        r5 = false;
    L6:
        if (r5 == false) goto L8;
        return r12;
    L8:
        return Float.intBitsToFloat(r10);
    }

    /* JADX INFO: renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m315pullLeftk4lQ0M(long r8) {
        float r0 = Float.intBitsToFloat((int) (m321displacementF1C5BW0$foundation_release() & 4294967295L));
        int r9 = (int) (r8 >> 32);
        float r10 = Float.intBitsToFloat(r9) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect r2 = this.edgeEffectWrapper.getOrCreateLeftEffect();
        EdgeEffectCompat r3 = EdgeEffectCompat.INSTANCE;
        boolean r4 = true;
        float r11 = r3.onPullDistanceCompat(r2, r10, 1 - r0) * Float.intBitsToFloat((int) (this.containerSize >> 32));
        if (r3.getDistanceCompat(r2) == MenuKt.ClosedAlphaTarget) goto L6;
        r4 = false;
    L6:
        if (r4 == false) goto L8;
        return r11;
    L8:
        return Float.intBitsToFloat(r9);
    }

    /* JADX INFO: renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m316pullRightk4lQ0M(long r7) {
        float r0 = Float.intBitsToFloat((int) (m321displacementF1C5BW0$foundation_release() & 4294967295L));
        int r8 = (int) (r7 >> 32);
        float r9 = Float.intBitsToFloat(r8) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect r2 = this.edgeEffectWrapper.getOrCreateRightEffect();
        EdgeEffectCompat r3 = EdgeEffectCompat.INSTANCE;
        float r10 = (-r3.onPullDistanceCompat(r2, -r9, r0)) * Float.intBitsToFloat((int) (this.containerSize >> 32));
        if (r3.getDistanceCompat(r2) != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r10;
    L8:
        return Float.intBitsToFloat(r8);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m317pullTopk4lQ0M(long r8) {
        float r0 = Float.intBitsToFloat((int) (m321displacementF1C5BW0$foundation_release() >> 32));
        int r9 = (int) (r8 & 4294967295L);
        float r10 = Float.intBitsToFloat(r9) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect r3 = this.edgeEffectWrapper.getOrCreateTopEffect();
        EdgeEffectCompat r4 = EdgeEffectCompat.INSTANCE;
        float r11 = r4.onPullDistanceCompat(r3, r10, r0) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        if (r4.getDistanceCompat(r3) != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return r11;
    L8:
        return Float.intBitsToFloat(r9);
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m318releaseOppositeOverscrollk4lQ0M(long r11) {
        boolean r3 = false;
        if (this.edgeEffectWrapper.isLeftAnimating() == false) goto L7;
        int r0 = (int) (r11 >> 32);
        if (Float.intBitsToFloat(r0) >= MenuKt.ClosedAlphaTarget) goto L7;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Float.intBitsToFloat(r0));
        boolean r1 = this.edgeEffectWrapper.isLeftAnimating();
    L9:
        if (this.edgeEffectWrapper.isRightAnimating() == false) goto L20;
        int r2 = (int) (r11 >> 32);
        if (Float.intBitsToFloat(r2) <= MenuKt.ClosedAlphaTarget) goto L20;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Float.intBitsToFloat(r2));
        if (r1 == false) goto L15;
    L18:
        r1 = true;
        goto L20
    L15:
        if (this.edgeEffectWrapper.isRightAnimating() == true) goto L18;
        r1 = false;
    L20:
        if (this.edgeEffectWrapper.isTopAnimating() == false) goto L31;
        int r4 = (int) (r11 & 4294967295L);
        if (Float.intBitsToFloat(r4) >= MenuKt.ClosedAlphaTarget) goto L31;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Float.intBitsToFloat(r4));
        if (r1 == false) goto L26;
    L29:
        r1 = true;
        goto L31
    L26:
        if (this.edgeEffectWrapper.isTopAnimating() == true) goto L29;
        r1 = false;
    L31:
        if (this.edgeEffectWrapper.isBottomAnimating() == false) goto L41;
        int r12 = (int) (r11 & 4294967295L);
        if (Float.intBitsToFloat(r12) <= MenuKt.ClosedAlphaTarget) goto L42;
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Float.intBitsToFloat(r12));
        if (r1 == false) goto L37;
    L38:
        r3 = true;
    L40:
        return r3;
    L37:
        if (this.edgeEffectWrapper.isBottomAnimating() == false) goto L40;
    L42:
        return r1;
    L41:
        return r1;
    L7:
        r1 = false;
        goto L9
    }

    public final void setInvalidationEnabled$foundation_release(boolean r1) {
        this.invalidationEnabled = r1;
    }

    /* JADX INFO: renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m322updateSizeuvyYCjk$foundation_release(long r10) {
        boolean r0 = Size.equals-impl0(this.containerSize, Size.Companion.getZero-NH-jbRc());
        boolean r1 = !Size.equals-impl0(r10, this.containerSize);
        this.containerSize = r10;
        if (r1 == false) goto L5;
        EdgeEffectWrapper r2 = this.edgeEffectWrapper;
        int r4 = MathKt.roundToInt(Float.intBitsToFloat((int) (r10 >> 32)));
        r2.m399updateSizeozmzZPI(IntSize.constructor-impl((((long) MathKt.roundToInt(Float.intBitsToFloat((int) (r10 & 4294967295L)))) & 4294967295L) | (((long) r4) << 32)));
    L5:
        if (r0 == true) goto L9;
        if (r1 == false) goto L10;
        animateToReleaseIfNeeded();
        return;
    L10:
        return;
    }

    public static final /* synthetic */ void access$setPointerId$p(AndroidEdgeEffectOverscrollEffect r0, long r1) {
        r0.pointerId = r1;
    }

    public static final /* synthetic */ void access$setPointerPosition$p(AndroidEdgeEffectOverscrollEffect r0, long r1) {
        r0.pointerPosition = r1;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    public Object mo319applyToFlingBMRW4eQ(long r12, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) == false) goto L7;
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 r0 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) r15;
        int r1 = r0.label;
        if ((r1 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r0.label = r1 - RtlSpacingHelper.UNDEFINED;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        long r13 = r0.J$0;
        ResultKt.throwOnFailure(r16);
    L51:
        long r17 = Velocity.minus-AH228Gc(r13, ((Velocity) r16).unbox-impl());
        this.scrollCycleInProgress = false;
        if (Velocity.getX-impl(r17) <= MenuKt.ClosedAlphaTarget) goto L55;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.getX-impl(r17)));
    L58:
        if (Velocity.getY-impl(r17) <= MenuKt.ClosedAlphaTarget) goto L61;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.getY-impl(r17)));
    L63:
        animateToReleaseIfNeeded();
        return Unit.INSTANCE;
    L61:
        if (Velocity.getY-impl(r17) >= MenuKt.ClosedAlphaTarget) goto L63;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.getY-impl(r17)));
        goto L63
    L55:
        if (Velocity.getX-impl(r17) >= MenuKt.ClosedAlphaTarget) goto L58;
        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.getX-impl(r17)));
        goto L58
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
    L22:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r16);
        if (Size.isEmpty-impl(this.containerSize) == false) goto L24;
        Velocity r18 = Velocity.box-impl(r12);
        r0.label = 1;
        if (r14.invoke(r18, r0) != r2) goto L22;
        return r2;
    L24:
        if (this.edgeEffectWrapper.isLeftStretched() == false) goto L29;
        if (Velocity.getX-impl(r12) >= MenuKt.ClosedAlphaTarget) goto L29;
        float r19 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateLeftEffect(), Velocity.getX-impl(r12), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
    L35:
        if (this.edgeEffectWrapper.isTopStretched() == false) goto L40;
        if (Velocity.getY-impl(r12) >= MenuKt.ClosedAlphaTarget) goto L40;
        float r4 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateTopEffect(), Velocity.getY-impl(r12), Float.intBitsToFloat((int) (4294967295L & this.containerSize)), this.density);
    L45:
        long r6 = VelocityKt.Velocity(r19, r4);
        if (Velocity.equals-impl0(r6, Velocity.Companion.getZero-9UxMQ8M()) == true) goto L48;
        invalidateOverscroll$foundation_release();
    L48:
        r13 = Velocity.minus-AH228Gc(r12, r6);
        Velocity r110 = Velocity.box-impl(r13);
        r0.J$0 = r13;
        r0.label = 2;
        r16 = r14.invoke(r110, r0);
        if (r16 != r2) goto L51;
        return r2;
    L40:
        if (this.edgeEffectWrapper.isBottomStretched() == true) goto L42;
    L44:
        r4 = MenuKt.ClosedAlphaTarget;
        goto L45
    L42:
        if (Velocity.getY-impl(r12) <= MenuKt.ClosedAlphaTarget) goto L44;
        r4 = -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateBottomEffect(), -Velocity.getY-impl(r12), Float.intBitsToFloat((int) (4294967295L & this.containerSize)), this.density);
    L29:
        if (this.edgeEffectWrapper.isRightStretched() == true) goto L31;
    L33:
        r19 = MenuKt.ClosedAlphaTarget;
        goto L35
    L31:
        if (Velocity.getX-impl(r12) <= MenuKt.ClosedAlphaTarget) goto L33;
        r19 = -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateRightEffect(), -Velocity.getX-impl(r12), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
    L7:
        r0 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, r15);
        goto L8
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    public long mo320applyToScrollRhakbz0(long r23, int r25, Function1<? super Offset, Offset> r26) {
        if (Size.isEmpty-impl(this.containerSize) == false) goto L7;
        return ((Offset) r26.invoke(Offset.box-impl(r23))).unbox-impl();
    L7:
        if (this.scrollCycleInProgress == false) goto L9;
    L21:
        float r4 = AndroidOverscroll_androidKt.m337access$destretchMultiplierGyEprt8(r25);
        long r6 = Offset.times-tuRUvjQ(r23, r4);
        int r11 = (int) (r23 & 4294967295L);
        if (Float.intBitsToFloat(r11) != MenuKt.ClosedAlphaTarget) goto L24;
        boolean r10 = true;
    L25:
        if (r10 == false) goto L28;
    L26:
        float r12 = MenuKt.ClosedAlphaTarget;
    L54:
        int r15 = (int) (r23 >> 32);
        if (Float.intBitsToFloat(r15) != MenuKt.ClosedAlphaTarget) goto L57;
        boolean r14 = true;
    L58:
        if (r14 == false) goto L61;
    L59:
        float r5 = MenuKt.ClosedAlphaTarget;
    L88:
        long r7 = Offset.constructor-impl((Float.floatToRawIntBits(r5) << 32) | (((long) Float.floatToRawIntBits(r12)) & 4294967295L));
        Offset.Companion r8 = Offset.Companion;
        if (Offset.equals-impl0(r7, r8.getZero-F1C5BW0()) == true) goto L91;
        invalidateOverscroll$foundation_release();
    L91:
        long r16 = Offset.minus-MK-Hz9U(r23, r7);
        long r9 = ((Offset) r26.invoke(Offset.box-impl(r16))).unbox-impl();
        long r13 = Offset.minus-MK-Hz9U(r16, r9);
        if (Float.intBitsToFloat((int) (r16 >> 32)) != MenuKt.ClosedAlphaTarget) goto L94;
        boolean r3 = true;
    L96:
        if (r3 == false) goto L103;
        if (Float.intBitsToFloat((int) (r16 & 4294967295L)) != MenuKt.ClosedAlphaTarget) goto L100;
        boolean r17 = true;
    L101:
        if (r17 == false) goto L103;
    L122:
        if (NestedScrollSource.equals-impl0(r25, NestedScrollSource.Companion.getUserInput-WNlRxjI()) == false) goto L143;
        int r18 = (int) (r13 >> 32);
        if (Float.intBitsToFloat(r18) <= 0.5f) goto L129;
        m315pullLeftk4lQ0M(r13);
    L126:
        boolean r19 = true;
    L132:
        int r20 = (int) (4294967295L & r13);
        if (Float.intBitsToFloat(r20) <= 0.5f) goto L137;
        m317pullTopk4lQ0M(r13);
    L135:
        boolean r21 = true;
    L140:
        if (r19 == true) goto L142;
        if (r21 == false) goto L143;
    L142:
        boolean r22 = true;
    L145:
        if (Offset.equals-impl0(r16, r8.getZero-F1C5BW0()) == false) goto L147;
    L153:
        if (r22 == false) goto L156;
        invalidateOverscroll$foundation_release();
    L156:
        return Offset.plus-MK-Hz9U(r7, r9);
    L147:
        if (m318releaseOppositeOverscrollk4lQ0M(r23) == true) goto L151;
        if (r22 == true) goto L151;
        boolean r24 = false;
    L152:
        r22 = r24;
    L151:
        r24 = true;
        goto L152
    L137:
        if (Float.intBitsToFloat(r20) >= (-0.5f)) goto L139;
        m314pullBottomk4lQ0M(r13);
        goto L135
    L139:
        r21 = false;
        goto L140
    L129:
        if (Float.intBitsToFloat(r18) >= (-0.5f)) goto L131;
        m316pullRightk4lQ0M(r13);
        goto L126
    L131:
        r19 = false;
    L143:
        r22 = false;
        goto L145
    L100:
        r17 = false;
    L103:
        if (Float.intBitsToFloat((int) (r9 >> 32)) != MenuKt.ClosedAlphaTarget) goto L105;
        boolean r27 = true;
    L106:
        if (r27 == true) goto L108;
    L112:
        EdgeEffectWrapper r28 = this.edgeEffectWrapper;
        if (r28.isLeftStretched() == false) goto L115;
    L120:
        animateToReleaseIfNeeded();
        goto L122
    L115:
        if (r28.isTopStretched() == true) goto L120;
        if (r28.isRightStretched() == true) goto L120;
        if (r28.isBottomStretched() == false) goto L122;
    L108:
        if (Float.intBitsToFloat((int) (r9 & 4294967295L)) != MenuKt.ClosedAlphaTarget) goto L110;
        boolean r29 = true;
    L111:
        if (r29 == true) goto L122;
    L110:
        r29 = false;
        goto L111
    L105:
        r27 = false;
        goto L106
    L94:
        r3 = false;
        goto L96
    L61:
        if (this.edgeEffectWrapper.isLeftStretched() == false) goto L75;
        if (Float.intBitsToFloat(r15) >= MenuKt.ClosedAlphaTarget) goto L75;
        float r110 = m315pullLeftk4lQ0M(r6);
        if (this.edgeEffectWrapper.isLeftStretched() == true) goto L68;
        this.edgeEffectWrapper.getOrCreateLeftEffect().finish();
    L68:
        if (r110 != Float.intBitsToFloat((int) (r6 >> 32))) goto L70;
        boolean r30 = true;
    L71:
        if (r30 == false) goto L73;
        r5 = Float.intBitsToFloat(r15);
        goto L88
    L73:
        r5 = r110 / r4;
        goto L88
    L70:
        r30 = false;
    L75:
        if (this.edgeEffectWrapper.isRightStretched() == false) goto L59;
        if (Float.intBitsToFloat(r15) <= MenuKt.ClosedAlphaTarget) goto L59;
        float r31 = m316pullRightk4lQ0M(r6);
        if (this.edgeEffectWrapper.isRightStretched() == true) goto L82;
        this.edgeEffectWrapper.getOrCreateRightEffect().finish();
    L82:
        if (r31 != Float.intBitsToFloat((int) (r6 >> 32))) goto L84;
        boolean r32 = true;
    L85:
        if (r32 == false) goto L87;
        r5 = Float.intBitsToFloat(r15);
        goto L88
    L87:
        r5 = r31 / r4;
        goto L88
    L84:
        r32 = false;
        goto L85
    L57:
        r14 = false;
        goto L58
    L28:
        if (this.edgeEffectWrapper.isTopStretched() == false) goto L42;
        if (Float.intBitsToFloat(r11) >= MenuKt.ClosedAlphaTarget) goto L42;
        float r111 = m317pullTopk4lQ0M(r6);
        if (this.edgeEffectWrapper.isTopStretched() == true) goto L35;
        this.edgeEffectWrapper.getOrCreateTopEffect().finish();
    L35:
        if (r111 != Float.intBitsToFloat((int) (r6 & 4294967295L))) goto L37;
        boolean r112 = true;
    L38:
        if (r112 == false) goto L40;
        r12 = Float.intBitsToFloat(r11);
    L40:
        r12 = r111 / r4;
        goto L54
    L37:
        r112 = false;
    L42:
        if (this.edgeEffectWrapper.isBottomStretched() == false) goto L26;
        if (Float.intBitsToFloat(r11) <= MenuKt.ClosedAlphaTarget) goto L26;
        r111 = m314pullBottomk4lQ0M(r6);
        if (this.edgeEffectWrapper.isBottomStretched() == true) goto L49;
        this.edgeEffectWrapper.getOrCreateBottomEffect().finish();
    L49:
        if (r111 != Float.intBitsToFloat((int) (r6 & 4294967295L))) goto L51;
        boolean r113 = true;
    L52:
        if (r113 == false) goto L40;
        r12 = Float.intBitsToFloat(r11);
        goto L54
    L51:
        r113 = false;
        goto L52
    L24:
        r10 = false;
        goto L25
    L9:
        if (this.edgeEffectWrapper.isLeftStretched() == false) goto L12;
        m315pullLeftk4lQ0M(Offset.Companion.getZero-F1C5BW0());
    L12:
        if (this.edgeEffectWrapper.isRightStretched() == false) goto L15;
        m316pullRightk4lQ0M(Offset.Companion.getZero-F1C5BW0());
    L15:
        if (this.edgeEffectWrapper.isTopStretched() == false) goto L18;
        m317pullTopk4lQ0M(Offset.Companion.getZero-F1C5BW0());
    L18:
        if (this.edgeEffectWrapper.isBottomStretched() == false) goto L20;
        m314pullBottomk4lQ0M(Offset.Companion.getZero-F1C5BW0());
    L20:
        this.scrollCycleInProgress = true;
        goto L21
    }

    private AndroidEdgeEffectOverscrollEffect(Context r3, Density r4, long r5, PaddingValues r7) {
        this.density = r4;
        this.pointerPosition = Offset.Companion.getUnspecified-F1C5BW0();
        EdgeEffectWrapper r6 = new EdgeEffectWrapper(r3, ColorKt.toArgb-8_81llA(r5));
        this.edgeEffectWrapper = r6;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.getZero-NH-jbRc();
        this.pointerId = PointerId.constructor-impl(-1);
        SuspendingPointerInputModifierNode r8 = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AndroidEdgeEffectOverscrollEffect$pointerInputNode$1(this));
        this.pointerInputNode = r8;
        if (Build.VERSION.SDK_INT < 31) goto L5;
        DelegatableNode r9 = new StretchOverscrollNode(r8, this, r6);
    L6:
        this.node = r9;
        return;
    L5:
        r9 = new GlowOverscrollNode(r8, this, r6, r7);
        goto L6
    }
}
