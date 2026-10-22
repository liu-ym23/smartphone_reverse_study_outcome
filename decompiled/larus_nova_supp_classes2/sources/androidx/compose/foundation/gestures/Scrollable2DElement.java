package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\f\u0010\"\u001a\u00020\u001b*\u00020#H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Landroidx/compose/foundation/gestures/Scrollable2DElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/Scrollable2DNode;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getState", "()Landroidx/compose/foundation/gestures/Scrollable2DState;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getEnabled", "()Z", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class Scrollable2DElement extends ModifierNodeElement<Scrollable2DNode> {
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final OverscrollEffect overscrollEffect;
    private final Scrollable2DState state;

    public Scrollable2DNode create() {
        return new Scrollable2DNode(this.state, this.overscrollEffect, this.flingBehavior, this.enabled, this.interactionSource);
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
        OverscrollEffect r1 = this.overscrollEffect;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.enabled == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        FlingBehavior r7 = this.flingBehavior;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        MutableInteractionSource r10 = this.interactionSource;
        if (r10 == null) goto L18;
        r2 = r10.hashCode();
    L18:
        return r9 + r2;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = 0;
        goto L6
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

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final Scrollable2DState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m658create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Scrollable2DElement) == true) goto L8;
        return false;
    L8:
        Scrollable2DElement r6 = (Scrollable2DElement) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.overscrollEffect, r6.overscrollEffect) == true) goto L15;
        return false;
    L15:
        if (this.enabled == r6.enabled) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.flingBehavior, r6.flingBehavior) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("scrollable2D");
        r4.getProperties().set("state", this.state);
        r4.getProperties().set("overscrollEffect", this.overscrollEffect);
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("flingBehavior", this.flingBehavior);
        r4.getProperties().set("interactionSource", this.interactionSource);
    }

    public void update(Scrollable2DNode r7) {
        r7.update(this.state, this.overscrollEffect, this.enabled, this.flingBehavior, this.interactionSource);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((Scrollable2DNode) r1);
    }

    public Scrollable2DElement(Scrollable2DState r1, OverscrollEffect r2, boolean r3, FlingBehavior r4, MutableInteractionSource r5) {
        this.state = r1;
        this.overscrollEffect = r2;
        this.enabled = r3;
        this.flingBehavior = r4;
        this.interactionSource = r5;
    }
}
