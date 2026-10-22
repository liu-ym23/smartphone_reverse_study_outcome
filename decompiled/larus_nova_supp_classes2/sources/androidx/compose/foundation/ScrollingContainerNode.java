package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BW\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010!\u001a\u0004\u0018\u00010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016JV\u0010&\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010 \u001a\u00020\tJ\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/foundation/ScrollingContainerNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseScrolling", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "useLocalOverscrollFactory", "userProvidedOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;ZLandroidx/compose/foundation/OverscrollEffect;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "scrollableNode", "Landroidx/compose/foundation/gestures/ScrollableNode;", "overscrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "localOverscrollFactory", "Landroidx/compose/foundation/OverscrollFactory;", "localOverscrollFactoryCreatedOverscrollEffect", "shouldReverseDirection", "getOverscrollEffect", "onAttach", "", "onDetach", "onLayoutDirectionChange", "update", "overscrollEffect", "attachOverscrollNodeIfNeeded", "onObservedReadsChanged", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollingContainerNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    private BringIntoViewSpec bringIntoViewSpec;
    private boolean enabled;
    private FlingBehavior flingBehavior;
    private MutableInteractionSource interactionSource;
    private OverscrollFactory localOverscrollFactory;
    private OverscrollEffect localOverscrollFactoryCreatedOverscrollEffect;
    private Orientation orientation;
    private DelegatableNode overscrollNode;
    private boolean reverseScrolling;
    private ScrollableNode scrollableNode;
    private final boolean shouldAutoInvalidate;
    private boolean shouldReverseDirection;
    private ScrollableState state;
    private boolean useLocalOverscrollFactory;
    private OverscrollEffect userProvidedOverscrollEffect;

    public static /* synthetic */ Unit a(ScrollingContainerNode r0) {
        return attachOverscrollNodeIfNeeded$lambda$2(r0);
    }

    private final void attachOverscrollNodeIfNeeded() {
        DelegatableNode r0 = this.overscrollNode;
        if (r0 == null) goto L5;
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.getNode().isAttached() == true) goto L21;
        delegate(r0);
        return;
    L21:
        return;
    L5:
        if (this.useLocalOverscrollFactory == false) goto L7;
        ObserverModifierNodeKt.observeReads(this, new p1(this));
    L7:
        OverscrollEffect r1 = getOverscrollEffect();
        if (r1 == null) goto L17;
        DelegatableNode r2 = r1.getNode();
        if (r2.getNode().isAttached() == true) goto L18;
        this.overscrollNode = delegate(r2);
        return;
    L18:
        return;
    }

    public final OverscrollEffect getOverscrollEffect() {
        if (this.useLocalOverscrollFactory == false) goto L6;
        return this.localOverscrollFactoryCreatedOverscrollEffect;
    L6:
        return this.userProvidedOverscrollEffect;
    }

    public void onDetach() {
        DelegatableNode r0 = this.overscrollNode;
        if (r0 == null) goto L6;
        undelegate(r0);
        return;
    }

    public final boolean shouldReverseDirection() {
        LayoutDirection r0 = LayoutDirection.Ltr;
        if (isAttached() == false) goto L6;
        r0 = DelegatableNodeKt.requireLayoutDirection(this);
    L6:
        return ScrollableDefaults.INSTANCE.reverseDirection(r0, this.orientation, this.reverseScrolling);
    }

    public void onAttach() {
        this.shouldReverseDirection = shouldReverseDirection();
        attachOverscrollNodeIfNeeded();
        if (this.scrollableNode != null) goto L6;
        this.scrollableNode = delegate(new ScrollableNode(this.state, getOverscrollEffect(), this.flingBehavior, this.orientation, this.enabled, this.shouldReverseDirection, this.interactionSource, this.bringIntoViewSpec));
        return;
    }

    public void onLayoutDirectionChange() {
        boolean r0 = shouldReverseDirection();
        if (this.shouldReverseDirection == r0) goto L6;
        this.shouldReverseDirection = r0;
        update(this.state, this.orientation, this.useLocalOverscrollFactory, getOverscrollEffect(), this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
        return;
    }

    public void onObservedReadsChanged() {
        OverscrollFactory r0 = (OverscrollFactory) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, OverscrollKt.getLocalOverscrollFactory());
        if (Intrinsics.areEqual(r0, this.localOverscrollFactory) == true) goto L11;
        this.localOverscrollFactory = r0;
        this.localOverscrollFactoryCreatedOverscrollEffect = null;
        DelegatableNode r1 = this.overscrollNode;
        if (r1 == null) goto L7;
        undelegate(r1);
    L7:
        this.overscrollNode = null;
        attachOverscrollNodeIfNeeded();
        ScrollableNode r2 = this.scrollableNode;
        if (r2 == null) goto L12;
        r2.update(this.state, this.orientation, getOverscrollEffect(), this.enabled, this.shouldReverseDirection, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
        return;
    L12:
        return;
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private static final Unit attachOverscrollNodeIfNeeded$lambda$2(ScrollingContainerNode r1) {
        OverscrollFactory r0 = (OverscrollFactory) CompositionLocalConsumerModifierNodeKt.currentValueOf(r1, OverscrollKt.getLocalOverscrollFactory());
        r1.localOverscrollFactory = r0;
        if (r0 == null) goto L5;
        OverscrollEffect r2 = r0.createOverscrollEffect();
    L6:
        r1.localOverscrollFactoryCreatedOverscrollEffect = r2;
        return Unit.INSTANCE;
    L5:
        r2 = null;
        goto L6
    }

    public ScrollingContainerNode(ScrollableState r1, Orientation r2, boolean r3, boolean r4, FlingBehavior r5, MutableInteractionSource r6, BringIntoViewSpec r7, boolean r8, OverscrollEffect r9) {
        this.state = r1;
        this.orientation = r2;
        this.enabled = r3;
        this.reverseScrolling = r4;
        this.flingBehavior = r5;
        this.interactionSource = r6;
        this.bringIntoViewSpec = r7;
        this.useLocalOverscrollFactory = r8;
        this.userProvidedOverscrollEffect = r9;
    }

    public final void update(ScrollableState r12, Orientation r13, boolean r14, OverscrollEffect r15, boolean r16, boolean r17, FlingBehavior r18, MutableInteractionSource r19, BringIntoViewSpec r20) {
        this.state = r12;
        this.orientation = r13;
        boolean r6 = true;
        if (this.useLocalOverscrollFactory == r14) goto L5;
        this.useLocalOverscrollFactory = r14;
        boolean r5 = true;
    L7:
        if (Intrinsics.areEqual(this.userProvidedOverscrollEffect, r15) == true) goto L9;
        this.userProvidedOverscrollEffect = r15;
    L10:
        if (r5 == true) goto L15;
        if (r6 == false) goto L19;
        if (r14 == false) goto L15;
    L19:
        this.enabled = r16;
        this.reverseScrolling = r17;
        this.flingBehavior = r18;
        this.interactionSource = r19;
        this.bringIntoViewSpec = r20;
        this.shouldReverseDirection = shouldReverseDirection();
        ScrollableNode r1 = this.scrollableNode;
        if (r1 == null) goto L23;
        r1.update(r12, r13, getOverscrollEffect(), r16, this.shouldReverseDirection, r18, r19, r20);
        return;
    L23:
        return;
    L15:
        DelegatableNode r2 = this.overscrollNode;
        if (r2 == null) goto L18;
        undelegate(r2);
    L18:
        this.overscrollNode = null;
        attachOverscrollNodeIfNeeded();
        goto L19
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = false;
        goto L7
    }
}
