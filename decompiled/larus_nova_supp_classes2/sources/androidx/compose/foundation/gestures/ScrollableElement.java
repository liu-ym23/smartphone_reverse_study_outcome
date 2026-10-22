package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0013\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\f\u0010,\u001a\u00020%*\u00020-H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006."}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/ScrollableNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "getState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getEnabled", "()Z", "getReverseDirection", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollableElement extends ModifierNodeElement<ScrollableNode> {
    private final BringIntoViewSpec bringIntoViewSpec;
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState state;

    public ScrollableNode create() {
        return new ScrollableNode(this.state, this.overscrollEffect, this.flingBehavior, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.bringIntoViewSpec);
    }

    public int hashCode() {
        int r0 = ((this.state.hashCode() * 31) + this.orientation.hashCode()) * 31;
        OverscrollEffect r1 = this.overscrollEffect;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.enabled == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.reverseDirection == true) goto L14;
        r5 = 1237;
    L14:
        int r8 = (r7 + r5) * 31;
        FlingBehavior r9 = this.flingBehavior;
        if (r9 == null) goto L17;
        int r10 = r9.hashCode();
    L18:
        int r11 = (r8 + r10) * 31;
        MutableInteractionSource r12 = this.interactionSource;
        if (r12 == null) goto L21;
        int r13 = r12.hashCode();
    L22:
        int r14 = (r11 + r13) * 31;
        BringIntoViewSpec r15 = this.bringIntoViewSpec;
        if (r15 == null) goto L26;
        r2 = r15.hashCode();
    L26:
        return r14 + r2;
    L21:
        r13 = 0;
        goto L22
    L17:
        r10 = 0;
        goto L18
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final BringIntoViewSpec getBringIntoViewSpec() {
        return this.bringIntoViewSpec;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final ScrollableState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m666create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ScrollableElement) == true) goto L8;
        return false;
    L8:
        ScrollableElement r6 = (ScrollableElement) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (this.orientation == r6.orientation) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.overscrollEffect, r6.overscrollEffect) == true) goto L18;
        return false;
    L18:
        if (this.enabled == r6.enabled) goto L21;
        return false;
    L21:
        if (this.reverseDirection == r6.reverseDirection) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.flingBehavior, r6.flingBehavior) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bringIntoViewSpec, r6.bringIntoViewSpec) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("scrollable");
        r4.getProperties().set("orientation", this.orientation);
        r4.getProperties().set("state", this.state);
        r4.getProperties().set("overscrollEffect", this.overscrollEffect);
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        r4.getProperties().set("flingBehavior", this.flingBehavior);
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("bringIntoViewSpec", this.bringIntoViewSpec);
    }

    public void update(ScrollableNode r10) {
        r10.update(this.state, this.orientation, this.overscrollEffect, this.enabled, this.reverseDirection, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((ScrollableNode) r1);
    }

    public ScrollableElement(ScrollableState r1, Orientation r2, OverscrollEffect r3, boolean r4, boolean r5, FlingBehavior r6, MutableInteractionSource r7, BringIntoViewSpec r8) {
        this.state = r1;
        this.orientation = r2;
        this.overscrollEffect = r3;
        this.enabled = r4;
        this.reverseDirection = r5;
        this.flingBehavior = r6;
        this.interactionSource = r7;
        this.bringIntoViewSpec = r8;
    }
}
