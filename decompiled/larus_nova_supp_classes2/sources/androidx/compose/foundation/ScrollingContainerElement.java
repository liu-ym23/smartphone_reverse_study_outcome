package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\f\u0010\u0019\u001a\u00020\u0017*\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/ScrollingContainerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollingContainerNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseScrolling", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "useLocalOverscrollFactory", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;ZLandroidx/compose/foundation/OverscrollEffect;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollingContainerElement extends ModifierNodeElement<ScrollingContainerNode> {
    private final BringIntoViewSpec bringIntoViewSpec;
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseScrolling;
    private final ScrollableState state;
    private final boolean useLocalOverscrollFactory;

    public ScrollingContainerNode create() {
        return new ScrollingContainerNode(this.state, this.orientation, this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec, this.useLocalOverscrollFactory, this.overscrollEffect);
    }

    public int hashCode() {
        int r0 = ((this.state.hashCode() * 31) + this.orientation.hashCode()) * 31;
        int r2 = 1231;
        if (this.enabled == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.reverseScrolling == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        FlingBehavior r6 = this.flingBehavior;
        int r7 = 0;
        if (r6 == null) goto L13;
        int r8 = r6.hashCode();
    L14:
        int r9 = (r5 + r8) * 31;
        MutableInteractionSource r10 = this.interactionSource;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        BringIntoViewSpec r13 = this.bringIntoViewSpec;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.useLocalOverscrollFactory == true) goto L26;
        r2 = 1237;
    L26:
        int r16 = (r15 + r2) * 31;
        OverscrollEffect r17 = this.overscrollEffect;
        if (r17 == null) goto L30;
        r7 = r17.hashCode();
    L30:
        return r16 + r7;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m452create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L38:
        return false;
    L8:
        if (ScrollingContainerElement.class != r5.getClass()) goto L38;
        ScrollingContainerElement r6 = (ScrollingContainerElement) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L14;
        return false;
    L14:
        if (this.orientation == r6.orientation) goto L17;
        return false;
    L17:
        if (this.enabled == r6.enabled) goto L20;
        return false;
    L20:
        if (this.reverseScrolling == r6.reverseScrolling) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.flingBehavior, r6.flingBehavior) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.bringIntoViewSpec, r6.bringIntoViewSpec) == true) goto L32;
        return false;
    L32:
        if (this.useLocalOverscrollFactory == r6.useLocalOverscrollFactory) goto L35;
        return false;
    L35:
        if (Intrinsics.areEqual(this.overscrollEffect, r6.overscrollEffect) == true) goto L37;
        return false;
    L37:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("scrollingContainer");
        r4.getProperties().set("state", this.state);
        r4.getProperties().set("orientation", this.orientation);
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("reverseScrolling", Boolean.valueOf(this.reverseScrolling));
        r4.getProperties().set("flingBehavior", this.flingBehavior);
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("bringIntoViewSpec", this.bringIntoViewSpec);
        r4.getProperties().set("useLocalOverscrollFactory", Boolean.valueOf(this.useLocalOverscrollFactory));
        r4.getProperties().set("overscrollEffect", this.overscrollEffect);
    }

    public void update(ScrollingContainerNode r11) {
        r11.update(this.state, this.orientation, this.useLocalOverscrollFactory, this.overscrollEffect, this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((ScrollingContainerNode) r1);
    }

    public ScrollingContainerElement(ScrollableState r1, Orientation r2, boolean r3, boolean r4, FlingBehavior r5, MutableInteractionSource r6, BringIntoViewSpec r7, boolean r8, OverscrollEffect r9) {
        this.state = r1;
        this.orientation = r2;
        this.enabled = r3;
        this.reverseScrolling = r4;
        this.flingBehavior = r5;
        this.interactionSource = r6;
        this.bringIntoViewSpec = r7;
        this.useLocalOverscrollFactory = r8;
        this.overscrollEffect = r9;
    }
}
