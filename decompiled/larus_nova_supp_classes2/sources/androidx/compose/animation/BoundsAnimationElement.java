package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00126\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\f\u0010\u001f\u001a\u00020\u001d*\u00020 H\u0016J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J9\u0010#\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\bHÆ\u0003J\t\u0010$\u001a\u00020\u0010HÆ\u0003Ja\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u000628\b\u0002\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RA\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Landroidx/compose/animation/BoundsAnimationElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/BoundsAnimationModifierNode;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "resolveMeasureConstraints", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "animatedSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "animateMotionFrameOfReference", "", "<init>", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/animation/BoundsTransform;Lkotlin/jvm/functions/Function2;Z)V", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "getBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "getResolveMeasureConstraints", "()Lkotlin/jvm/functions/Function2;", "getAnimateMotionFrameOfReference", "()Z", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BoundsAnimationElement extends ModifierNodeElement<BoundsAnimationModifierNode> {
    public static final int $stable = 0;
    private final boolean animateMotionFrameOfReference;
    private final BoundsTransform boundsTransform;
    private final LookaheadScope lookaheadScope;
    private final Function2<IntSize, Constraints, Constraints> resolveMeasureConstraints;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BoundsAnimationElement copy$default(BoundsAnimationElement r0, LookaheadScope r1, BoundsTransform r2, Function2 r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.lookaheadScope;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.boundsTransform;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.resolveMeasureConstraints;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.animateMotionFrameOfReference;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final LookaheadScope component1() {
        return this.lookaheadScope;
    }

    public final BoundsTransform component2() {
        return this.boundsTransform;
    }

    public final Function2<IntSize, Constraints, Constraints> component3() {
        return this.resolveMeasureConstraints;
    }

    public final boolean component4() {
        return this.animateMotionFrameOfReference;
    }

    public final BoundsAnimationElement copy(LookaheadScope r2, BoundsTransform r3, Function2<? super IntSize, ? super Constraints, Constraints> r4, boolean r5) {
        return new BoundsAnimationElement(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BoundsAnimationElement) == true) goto L8;
        return false;
    L8:
        BoundsAnimationElement r6 = (BoundsAnimationElement) r5;
        if (Intrinsics.areEqual(this.lookaheadScope, r6.lookaheadScope) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.boundsTransform, r6.boundsTransform) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resolveMeasureConstraints, r6.resolveMeasureConstraints) == true) goto L18;
        return false;
    L18:
        if (this.animateMotionFrameOfReference == r6.animateMotionFrameOfReference) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.lookaheadScope.hashCode() * 31) + this.boundsTransform.hashCode()) * 31) + this.resolveMeasureConstraints.hashCode()) * 31;
        if (this.animateMotionFrameOfReference == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "BoundsAnimationElement(lookaheadScope=" + this.lookaheadScope + ", boundsTransform=" + this.boundsTransform + ", resolveMeasureConstraints=" + this.resolveMeasureConstraints + ", animateMotionFrameOfReference=" + this.animateMotionFrameOfReference + ')';
    }

    public BoundsAnimationModifierNode create() {
        return new BoundsAnimationModifierNode(this.lookaheadScope, this.boundsTransform, this.resolveMeasureConstraints, this.animateMotionFrameOfReference);
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

    public final Function2<IntSize, Constraints, Constraints> getResolveMeasureConstraints() {
        return this.resolveMeasureConstraints;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m149create() {
        return create();
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("boundsAnimation");
        r4.getProperties().set("lookaheadScope", this.lookaheadScope);
        r4.getProperties().set("boundsTransform", this.boundsTransform);
        r4.getProperties().set("onChooseMeasureConstraints", this.resolveMeasureConstraints);
        r4.getProperties().set("animateMotionFrameOfReference", Boolean.valueOf(this.animateMotionFrameOfReference));
    }

    public void update(BoundsAnimationModifierNode r2) {
        r2.setLookaheadScope(this.lookaheadScope);
        r2.setBoundsTransform(this.boundsTransform);
        r2.setOnChooseMeasureConstraints(this.resolveMeasureConstraints);
        r2.setAnimateMotionFrameOfReference(this.animateMotionFrameOfReference);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((BoundsAnimationModifierNode) r1);
    }

    public BoundsAnimationElement(LookaheadScope r1, BoundsTransform r2, Function2<? super IntSize, ? super Constraints, Constraints> r3, boolean r4) {
        this.lookaheadScope = r1;
        this.boundsTransform = r2;
        this.resolveMeasureConstraints = r3;
        this.animateMotionFrameOfReference = r4;
    }
}
