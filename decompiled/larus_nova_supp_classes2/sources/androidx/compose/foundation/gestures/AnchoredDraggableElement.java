package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B[\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\f\u0010\u001e\u001a\u00020\u0017*\u00020\u001fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableElement;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "<init>", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Ljava/lang/Boolean;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;)V", "Ljava/lang/Boolean;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnchoredDraggableElement<T> extends ModifierNodeElement<AnchoredDraggableNode<T>> {
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final Boolean reverseDirection;
    private final Boolean startDragImmediately;
    private final AnchoredDraggableState<T> state;

    public AnchoredDraggableNode<T> create() {
        return new AnchoredDraggableNode(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.overscrollEffect, this.startDragImmediately, this.flingBehavior);
    }

    public int hashCode() {
        int r0 = ((this.state.hashCode() * 31) + this.orientation.hashCode()) * 31;
        if (this.enabled == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        Boolean r3 = this.reverseDirection;
        int r4 = 0;
        if (r3 == null) goto L9;
        int r5 = r3.hashCode();
    L10:
        int r6 = (r2 + r5) * 31;
        MutableInteractionSource r7 = this.interactionSource;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.startDragImmediately;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        OverscrollEffect r13 = this.overscrollEffect;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        FlingBehavior r16 = this.flingBehavior;
        if (r16 == null) goto L26;
        r4 = r16.hashCode();
    L26:
        return r15 + r4;
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
        r5 = 0;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m530create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AnchoredDraggableElement) == true) goto L8;
        return false;
    L8:
        AnchoredDraggableElement r6 = (AnchoredDraggableElement) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (this.orientation == r6.orientation) goto L15;
        return false;
    L15:
        if (this.enabled == r6.enabled) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reverseDirection, r6.reverseDirection) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.startDragImmediately, r6.startDragImmediately) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.overscrollEffect, r6.overscrollEffect) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.flingBehavior, r6.flingBehavior) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("anchoredDraggable");
        r4.getProperties().set("state", this.state);
        r4.getProperties().set("orientation", this.orientation);
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("reverseDirection", this.reverseDirection);
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("startDragImmediately", this.startDragImmediately);
        r4.getProperties().set("overscrollEffect", this.overscrollEffect);
        r4.getProperties().set("flingBehavior", this.flingBehavior);
    }

    public void update(AnchoredDraggableNode<T> r10) {
        r10.update(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.overscrollEffect, this.startDragImmediately, this.flingBehavior);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((AnchoredDraggableNode) r1);
    }

    public AnchoredDraggableElement(AnchoredDraggableState<T> r1, Orientation r2, boolean r3, Boolean r4, MutableInteractionSource r5, Boolean r6, OverscrollEffect r7, FlingBehavior r8) {
        this.state = r1;
        this.orientation = r2;
        this.enabled = r3;
        this.reverseDirection = r4;
        this.interactionSource = r5;
        this.startDragImmediately = r6;
        this.overscrollEffect = r7;
        this.flingBehavior = r8;
    }

    public /* synthetic */ AnchoredDraggableElement(AnchoredDraggableState r13, Orientation r14, boolean r15, Boolean r16, MutableInteractionSource r17, Boolean r18, OverscrollEffect r19, FlingBehavior r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 32) == 0) goto L5;
        Boolean r9 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        FlingBehavior r11 = null;
    L10:
        this(r13, r14, r15, r16, r17, r9, r19, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r9 = r18;
        goto L7
    }
}
