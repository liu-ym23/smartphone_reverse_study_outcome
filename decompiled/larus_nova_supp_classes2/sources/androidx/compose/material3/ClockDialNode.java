package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010\u0019J'\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020#H\u0016J3\u00100\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b1\u00102R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Landroidx/compose/material3/ClockDialNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "state", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "offsetX", "offsetY", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "center", "getCenter-nOcc-ac", "()J", "setCenter--gyyYBs", "(J)V", "center$delegate", "Landroidx/compose/runtime/MutableState;", "maxDist", "getMaxDist", "()F", "pointerInputTapNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputDragNode", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "updateNode", "updateNode-JwYzU44", "(Landroidx/compose/material3/AnalogTimePickerState;ZILandroidx/compose/animation/core/AnimationSpec;)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClockDialNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private AnimationSpec<Float> animationSpec;
    private boolean autoSwitchToMinute;
    private final MutableState center$delegate;
    private float offsetX;
    private float offsetY;
    private final SuspendingPointerInputModifierNode pointerInputDragNode;
    private final SuspendingPointerInputModifierNode pointerInputTapNode;
    private int selection;
    private AnalogTimePickerState state;

    public /* synthetic */ ClockDialNode(AnalogTimePickerState r1, boolean r2, int r3, AnimationSpec r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final /* synthetic */ long m2433getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.-CC.$default$getTouchBoundsExpansion-RZrCHBk(this);
    }

    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.-CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.-CC.$default$onDensityChange(this);
    }

    public final /* synthetic */ void onPlaced(LayoutCoordinates r1) {
        LayoutAwareModifierNode.-CC.$default$onPlaced(this, r1);
    }

    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.-CC.$default$onViewConfigurationChange(this);
    }

    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.-CC.$default$sharePointerInputWithSiblings(this);
    }

    /* JADX INFO: renamed from: getCenter-nOcc-ac, reason: not valid java name */
    private final long m2431getCenternOccac() {
        return ((IntOffset) this.center$delegate.getValue()).unbox-impl();
    }

    public void onCancelPointerInput() {
        this.pointerInputTapNode.onCancelPointerInput();
        this.pointerInputDragNode.onCancelPointerInput();
    }

    private final float getMaxDist() {
        Density r0 = DelegatableNodeKt.requireDensity(this);
        return (r0.toPx-0680j_4(TimePickerKt.access$getMaxDistance$p()) * r0.roundToPx-0680j_4(this.state.m2285getCurrentDiameterD9Ej5fM())) / r0.roundToPx-0680j_4(TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM());
    }

    public static final /* synthetic */ AnimationSpec access$getAnimationSpec$p(ClockDialNode r0) {
        return r0.animationSpec;
    }

    public static final /* synthetic */ boolean access$getAutoSwitchToMinute$p(ClockDialNode r0) {
        return r0.autoSwitchToMinute;
    }

    /* JADX INFO: renamed from: access$getCenter-nOcc-ac, reason: not valid java name */
    public static final /* synthetic */ long m2430access$getCenternOccac(ClockDialNode r2) {
        return r2.m2431getCenternOccac();
    }

    public static final /* synthetic */ float access$getMaxDist(ClockDialNode r0) {
        return r0.getMaxDist();
    }

    public static final /* synthetic */ float access$getOffsetX$p(ClockDialNode r0) {
        return r0.offsetX;
    }

    public static final /* synthetic */ float access$getOffsetY$p(ClockDialNode r0) {
        return r0.offsetY;
    }

    public static final /* synthetic */ AnalogTimePickerState access$getState$p(ClockDialNode r0) {
        return r0.state;
    }

    /* JADX INFO: renamed from: setCenter--gyyYBs, reason: not valid java name */
    private final void m2432setCentergyyYBs(long r2) {
        this.center$delegate.setValue(IntOffset.box-impl(r2));
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void m2435onRemeasuredozmzZPI(long r4) {
        m2432setCentergyyYBs(IntSizeKt.getCenter-ozmzZPI(r4));
        this.state.m2287setCurrentDiameter0680j_4(DelegatableNodeKt.requireDensity(this).toDp-u2uoSUM((int) (r4 >> 32)));
    }

    public static final /* synthetic */ void access$setOffsetX$p(ClockDialNode r0, float r1) {
        r0.offsetX = r1;
    }

    public static final /* synthetic */ void access$setOffsetY$p(ClockDialNode r0, float r1) {
        r0.offsetY = r1;
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m2434onPointerEventH0pRuoY(PointerEvent r2, PointerEventPass r3, long r4) {
        this.pointerInputTapNode.onPointerEvent-H0pRuoY(r2, r3, r4);
        this.pointerInputDragNode.onPointerEvent-H0pRuoY(r2, r3, r4);
    }

    private ClockDialNode(AnalogTimePickerState r1, boolean r2, int r3, AnimationSpec<Float> r4) {
        this.state = r1;
        this.autoSwitchToMinute = r2;
        this.selection = r3;
        this.animationSpec = r4;
        this.center$delegate = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), null, 2, null);
        this.pointerInputTapNode = delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputTapNode$1(this)));
        this.pointerInputDragNode = delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputDragNode$1(this)));
    }

    /* JADX INFO: renamed from: updateNode-JwYzU44, reason: not valid java name */
    public final void m2436updateNodeJwYzU44(AnalogTimePickerState r7, boolean r8, int r9, AnimationSpec<Float> r10) {
        this.state = r7;
        this.autoSwitchToMinute = r8;
        this.animationSpec = r10;
        if (TimePickerSelectionMode.m3435equalsimpl0(this.selection, r9) == true) goto L6;
        this.selection = r9;
        BuildersKt.launch$default(getCoroutineScope(), null, null, new ClockDialNode$updateNode$1(r7, r10, null), 3, null);
        return;
    }
}
