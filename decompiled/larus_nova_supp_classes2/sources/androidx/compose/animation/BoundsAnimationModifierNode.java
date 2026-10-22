package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.ApproachIntrinsicMeasureScope;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00126\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\tH\u0016¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u00020+H\u0016J\u0014\u0010,\u001a\u00020\u0010*\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b5\u00106R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRJ\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/animation/BoundsAnimationModifierNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "onChooseMeasureConstraints", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animatedSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "animateMotionFrameOfReference", "", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function2;Z)V", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "setLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "setBoundsTransform", "(Landroidx/compose/animation/BoundsTransform;)V", "getOnChooseMeasureConstraints", "()Lkotlin/jvm/functions/Function2;", "setOnChooseMeasureConstraints", "(Lkotlin/jvm/functions/Function2;)V", "getAnimateMotionFrameOfReference", "()Z", "setAnimateMotionFrameOfReference", "(Z)V", "directManipulationParentsDirty", "boundsAnimation", "Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "isMeasurementApproachInProgress", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "isPlacementApproachInProgress", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoundsAnimationModifierNode extends Modifier.Node implements ApproachLayoutModifierNode {
    public static final int $stable = 8;
    private boolean animateMotionFrameOfReference;
    private final BoundsTransformDeferredAnimation boundsAnimation;
    private BoundsTransform boundsTransform;
    private boolean directManipulationParentsDirty;
    private LookaheadScope lookaheadScope;
    private Function2<? super IntSize, ? super Constraints, Constraints> onChooseMeasureConstraints;

    public final /* synthetic */ int maxApproachIntrinsicHeight(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$maxApproachIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxApproachIntrinsicWidth(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$maxApproachIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final /* synthetic */ MeasureResult m152measure3p2s80s(MeasureScope r1, Measurable r2, long r3) {
        return ApproachLayoutModifierNode.-CC.$default$measure-3p2s80s(this, r1, r2, r3);
    }

    public final /* synthetic */ int minApproachIntrinsicHeight(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$minApproachIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minApproachIntrinsicWidth(ApproachIntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return ApproachLayoutModifierNode.-CC.$default$minApproachIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifierNode.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public void onAttach() {
        this.directManipulationParentsDirty = true;
    }

    public final boolean getAnimateMotionFrameOfReference() {
        return this.animateMotionFrameOfReference;
    }

    public final BoundsTransform getBoundsTransform() {
        return this.boundsTransform;
    }

    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    public final Function2<IntSize, Constraints, Constraints> getOnChooseMeasureConstraints() {
        return this.onChooseMeasureConstraints;
    }

    public static final /* synthetic */ BoundsTransformDeferredAnimation access$getBoundsAnimation$p(BoundsAnimationModifierNode r0) {
        return r0.boundsAnimation;
    }

    /* JADX INFO: renamed from: isMeasurementApproachInProgress-ozmzZPI, reason: not valid java name */
    public boolean m151isMeasurementApproachInProgressozmzZPI(long r2) {
        this.boundsAnimation.m157updateTargetSizeuvyYCjk(IntSizeKt.toSize-ozmzZPI(r2));
        return !this.boundsAnimation.isIdle();
    }

    public final void setAnimateMotionFrameOfReference(boolean r1) {
        this.animateMotionFrameOfReference = r1;
    }

    public final void setBoundsTransform(BoundsTransform r1) {
        this.boundsTransform = r1;
    }

    public final void setLookaheadScope(LookaheadScope r1) {
        this.lookaheadScope = r1;
    }

    public final void setOnChooseMeasureConstraints(Function2<? super IntSize, ? super Constraints, Constraints> r1) {
        this.onChooseMeasureConstraints = r1;
    }

    public boolean isPlacementApproachInProgress(Placeable.PlacementScope r8, LayoutCoordinates r9) {
        this.boundsAnimation.updateTargetOffsetAndAnimate(this.lookaheadScope, r8, getCoroutineScope(), this.directManipulationParentsDirty, this.animateMotionFrameOfReference, this.boundsTransform);
        this.directManipulationParentsDirty = this.animateMotionFrameOfReference;
        return !this.boundsAnimation.isIdle();
    }

    /* JADX INFO: renamed from: approachMeasure-3p2s80s, reason: not valid java name */
    public MeasureResult m150approachMeasure3p2s80s(ApproachMeasureScope r10, Measurable r11, long r12) {
        if (this.boundsAnimation.m154getCurrentSizeNHjbRc() != 9205357640488583168L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        long r1 = IntSizeKt.toSize-ozmzZPI(r10.getLookaheadSize-YbymL2g());
    L9:
        Rect r2 = this.boundsAnimation.getValue();
        if (r2 == null) goto L12;
        r1 = r2.getSize-NH-jbRc();
    L12:
        long r3 = IntSizeKt.roundToIntSize-uvyYCjk(r1);
        long r13 = ((Constraints) this.onChooseMeasureConstraints.invoke(IntSize.box-impl(r3), Constraints.box-impl(r12))).unbox-impl();
        final Placeable r14 = r11.measure-BRTryo0(r13);
        long r15 = ConstraintsKt.constrain-4WqzIAM(r13, r3);
        return MeasureScope.-CC.layout$default(r10, (int) (r15 >> 32), (int) (r15 & 4294967295L), null, new BoundsAnimationModifierNode$approachMeasure$1(this, r14), 4, null);
    L8:
        r1 = this.boundsAnimation.m154getCurrentSizeNHjbRc();
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public BoundsAnimationModifierNode(LookaheadScope r1, BoundsTransform r2, Function2<? super IntSize, ? super Constraints, Constraints> r3, boolean r4) {
        this.lookaheadScope = r1;
        this.boundsTransform = r2;
        this.onChooseMeasureConstraints = r3;
        this.animateMotionFrameOfReference = r4;
        this.directManipulationParentsDirty = true;
        this.boundsAnimation = new BoundsTransformDeferredAnimation();
    }
}
