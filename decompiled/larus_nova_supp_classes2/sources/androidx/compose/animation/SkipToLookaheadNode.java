package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u001c\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\u001c\u0010'\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\u001c\u0010(\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010)\u001a\u00020#H\u0016J\u001c\u0010*\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010)\u001a\u00020#H\u0016R/\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006+"}, d2 = {"Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "scaleToBounds$delegate", "Landroidx/compose/runtime/MutableState;", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled$delegate", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "maxIntrinsicHeight", "width", "minIntrinsicHeight", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private final MutableState isEnabled$delegate;
    private Constraints lookaheadConstraints;
    private long lookaheadSize;
    private final MutableState scaleToBounds$delegate;

    public final ScaleToBoundsImpl getScaleToBounds() {
        return (ScaleToBoundsImpl) this.scaleToBounds$delegate.getValue();
    }

    public final Function0<Boolean> isEnabled() {
        return (Function0) this.isEnabled$delegate.getValue();
    }

    public static final /* synthetic */ long access$getLookaheadSize$p(SkipToLookaheadNode r2) {
        return r2.lookaheadSize;
    }

    public final void setEnabled(Function0<Boolean> r2) {
        this.isEnabled$delegate.setValue(r2);
    }

    public final void setScaleToBounds(ScaleToBoundsImpl r2) {
        this.scaleToBounds$delegate.setValue(r2);
    }

    public SkipToLookaheadNode(ScaleToBoundsImpl r3, Function0<Boolean> r4) {
        this.scaleToBounds$delegate = SnapshotStateKt.mutableStateOf$default(r3, null, 2, null);
        this.isEnabled$delegate = SnapshotStateKt.mutableStateOf$default(r4, null, 2, null);
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        if (r3.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m148isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize & 4294967295L);
    L8:
        return r4.maxIntrinsicHeight(r5);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        if (r3.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m148isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize >> 32);
    L8:
        return r4.maxIntrinsicWidth(r5);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m225measure3p2s80s(final MeasureScope r19, Measurable r20, long r21) {
        if (r19.isLookingAhead() == false) goto L6;
        this.lookaheadConstraints = Constraints.box-impl(r21);
    L6:
        if (((Boolean) isEnabled().invoke()).booleanValue() == true) goto L10;
        final Placeable r0 = r20.measure-BRTryo0(r21);
        return MeasureScope.-CC.layout$default(r19, r0.getWidth(), r0.getHeight(), null, new SkipToLookaheadNode$measure$1$1(r0), 4, null);
    L10:
        if (r19.isLookingAhead() == false) goto L12;
        Placeable r1 = r20.measure-BRTryo0(r21);
        int r4 = r1.getWidth();
        long r7 = ((long) r4) << 32;
        this.lookaheadSize = IntSize.constructor-impl((((long) r1.getHeight()) & 4294967295L) | r7);
    L13:
        final Placeable r5 = r1;
        final long r8 = ConstraintsKt.constrain-4WqzIAM(r21, this.lookaheadSize);
        return MeasureScope.-CC.layout$default(r19, (int) (r8 >> 32), (int) (r8 & 4294967295L), null, new SkipToLookaheadNode$measure$2(this, r5, r8, r19), 4, null);
    L12:
        Constraints r2 = this.lookaheadConstraints;
        Intrinsics.checkNotNull(r2);
        r1 = r20.measure-BRTryo0(r2.unbox-impl());
        goto L13
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        if (r3.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m148isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize & 4294967295L);
    L8:
        return r4.minIntrinsicHeight(r5);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r3, IntrinsicMeasurable r4, int r5) {
        if (r3.isLookingAhead() == true) goto L8;
        if (AnimationModifierKt.m148isValidozmzZPI(this.lookaheadSize) == false) goto L8;
        return (int) (this.lookaheadSize >> 32);
    L8:
        return r4.minIntrinsicWidth(r5);
    }
}
