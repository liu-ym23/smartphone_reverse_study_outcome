package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÂ\u0003J\u0010\u0010\u0018\u001a\u00020\u0006HÂ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001d\u001a\u00020\nHÂ\u0003J\u0010\u0010\u001e\u001a\u00020\fHÂ\u0003¢\u0006\u0004\b\u001f\u0010 JL\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0004HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006+"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MarqueeModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "<init>", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "F", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component2-ZbEOnfQ", "()I", "component3", "component4", "component5", "component6", "component6-D9Ej5fM", "()F", "copy", "copy-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/foundation/MarqueeModifierElement;", "equals", "", "other", "", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MarqueeModifierElement extends ModifierNodeElement<MarqueeModifierNode> {
    private final int animationMode;
    private final int delayMillis;
    private final int initialDelayMillis;
    private final int iterations;
    private final MarqueeSpacing spacing;
    private final float velocity;

    public /* synthetic */ MarqueeModifierElement(int r1, int r2, int r3, int r4, MarqueeSpacing r5, float r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    private final int component1() {
        return this.iterations;
    }

    /* JADX INFO: renamed from: component2-ZbEOnfQ, reason: not valid java name */
    private final int m436component2ZbEOnfQ() {
        return this.animationMode;
    }

    private final int component3() {
        return this.delayMillis;
    }

    private final int component4() {
        return this.initialDelayMillis;
    }

    private final MarqueeSpacing component5() {
        return this.spacing;
    }

    /* JADX INFO: renamed from: component6-D9Ej5fM, reason: not valid java name */
    private final float m437component6D9Ej5fM() {
        return this.velocity;
    }

    /* JADX INFO: renamed from: copy-lWfNwf4$default, reason: not valid java name */
    public static /* synthetic */ MarqueeModifierElement m438copylWfNwf4$default(MarqueeModifierElement r4, int r5, int r6, int r7, int r8, MarqueeSpacing r9, float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.iterations;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.animationMode;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.delayMillis;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.initialDelayMillis;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.spacing;
    L17:
        MarqueeSpacing r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.velocity;
    L20:
        int r14 = r5;
        return r4.m439copylWfNwf4(r14, r13, r0, r1, r2, r10);
    }

    /* JADX INFO: renamed from: copy-lWfNwf4, reason: not valid java name */
    public final MarqueeModifierElement m439copylWfNwf4(int r10, int r11, int r12, int r13, MarqueeSpacing r14, float r15) {
        return new MarqueeModifierElement(r10, r11, r12, r13, r14, r15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarqueeModifierElement) == true) goto L8;
        return false;
    L8:
        MarqueeModifierElement r6 = (MarqueeModifierElement) r5;
        if (this.iterations == r6.iterations) goto L12;
        return false;
    L12:
        if (MarqueeAnimationMode.m429equalsimpl0(this.animationMode, r6.animationMode) == true) goto L15;
        return false;
    L15:
        if (this.delayMillis == r6.delayMillis) goto L18;
        return false;
    L18:
        if (this.initialDelayMillis == r6.initialDelayMillis) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.spacing, r6.spacing) == true) goto L24;
        return false;
    L24:
        if (Dp.equals-impl0(this.velocity, r6.velocity) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.iterations * 31) + MarqueeAnimationMode.m430hashCodeimpl(this.animationMode)) * 31) + this.delayMillis) * 31) + this.initialDelayMillis) * 31) + this.spacing.hashCode()) * 31) + Dp.hashCode-impl(this.velocity);
    }

    public String toString() {
        return "MarqueeModifierElement(iterations=" + this.iterations + ", animationMode=" + MarqueeAnimationMode.m431toStringimpl(this.animationMode) + ", delayMillis=" + this.delayMillis + ", initialDelayMillis=" + this.initialDelayMillis + ", spacing=" + this.spacing + ", velocity=" + Dp.toString-impl(this.velocity) + ')';
    }

    public MarqueeModifierNode create() {
        return new MarqueeModifierNode(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity, null);
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m440create() {
        return create();
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("basicMarquee");
        r4.getProperties().set("iterations", Integer.valueOf(this.iterations));
        r4.getProperties().set("animationMode", MarqueeAnimationMode.m426boximpl(this.animationMode));
        r4.getProperties().set("delayMillis", Integer.valueOf(this.delayMillis));
        r4.getProperties().set("initialDelayMillis", Integer.valueOf(this.initialDelayMillis));
        r4.getProperties().set("spacing", this.spacing);
        r4.getProperties().set("velocity", Dp.box-impl(this.velocity));
    }

    public void update(MarqueeModifierNode r8) {
        r8.m444updatelWfNwf4(this.iterations, this.animationMode, this.delayMillis, this.initialDelayMillis, this.spacing, this.velocity);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((MarqueeModifierNode) r1);
    }

    private MarqueeModifierElement(int r1, int r2, int r3, int r4, MarqueeSpacing r5, float r6) {
        this.iterations = r1;
        this.animationMode = r2;
        this.delayMillis = r3;
        this.initialDelayMillis = r4;
        this.spacing = r5;
        this.velocity = r6;
    }
}
