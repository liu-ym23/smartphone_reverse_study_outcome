package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J2\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ'\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/foundation/gestures/TransformableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "lockRotationOnZoomPan", "enabled", "<init>", "(Landroidx/compose/foundation/gestures/TransformableState;Lkotlin/jvm/functions/Function1;ZZ)V", "updatedCanPan", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "onAttach", "", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputModifierMouse", "update", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TransformableNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    private Function1<? super Offset, Boolean> canPan;
    private final Channel<TransformEvent> channel;
    private boolean enabled;
    private boolean lockRotationOnZoomPan;
    private PointerInputModifierNode pointerInputModifierMouse;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private ScrollConfig scrollConfig;
    private TransformableState state;
    private final Function1<Offset, Boolean> updatedCanPan;

    public static /* synthetic */ boolean a(TransformableNode r0, Offset r1) {
        return updatedCanPan$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final /* synthetic */ long m724getTouchBoundsExpansionRZrCHBk() {
        return PointerInputModifierNode.-CC.$default$getTouchBoundsExpansion-RZrCHBk(this);
    }

    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.-CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public final /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.-CC.$default$onDensityChange(this);
    }

    public final /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.-CC.$default$onViewConfigurationChange(this);
    }

    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.-CC.$default$sharePointerInputWithSiblings(this);
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
        PointerInputModifierNode r0 = this.pointerInputModifierMouse;
        if (r0 == null) goto L6;
        r0.onCancelPointerInput();
        return;
    }

    public void onAttach() {
        super/*androidx.compose.ui.Modifier.Node*/.onAttach();
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(this);
    }

    public static final /* synthetic */ Channel access$getChannel$p(TransformableNode r0) {
        return r0.channel;
    }

    public static final /* synthetic */ boolean access$getEnabled$p(TransformableNode r0) {
        return r0.enabled;
    }

    public static final /* synthetic */ boolean access$getLockRotationOnZoomPan$p(TransformableNode r0) {
        return r0.lockRotationOnZoomPan;
    }

    public static final /* synthetic */ TransformableState access$getState$p(TransformableNode r0) {
        return r0.state;
    }

    public static final /* synthetic */ Function1 access$getUpdatedCanPan$p(TransformableNode r0) {
        return r0.updatedCanPan;
    }

    private static final boolean updatedCanPan$lambda$0(TransformableNode r0, Offset r1) {
        return ((Boolean) r0.canPan.invoke(r1)).booleanValue();
    }

    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m725onPointerEventH0pRuoY(PointerEvent r8, PointerEventPass r9, long r10) {
        final ScrollConfig r0 = this.scrollConfig;
        if (this.enabled == false) goto L15;
        List r1 = r8.getChanges();
        int r2 = r1.size();
        boolean r3 = false;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L10;
        if (PointerType.equals-impl0(((PointerInputChange) ListProtector.get(r1, r4)).getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA()) == true) goto L8;
        r4 = r4 + 1;
        goto L5
    L8:
        r3 = true;
    L10:
        if (r3 == false) goto L15;
        if (r0 == null) goto L15;
        if (this.pointerInputModifierMouse != null) goto L15;
        this.pointerInputModifierMouse = delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TransformableNode$onPointerEvent$2(this, r0)));
    L15:
        this.pointerInputNode.onPointerEvent-H0pRuoY(r8, r9, r10);
        PointerInputModifierNode r5 = this.pointerInputModifierMouse;
        if (r5 == null) goto L21;
        r5.onPointerEvent-H0pRuoY(r8, r9, r10);
        return;
    }

    public TransformableNode(TransformableState r1, Function1<? super Offset, Boolean> r2, boolean r3, boolean r4) {
        this.state = r1;
        this.canPan = r2;
        this.lockRotationOnZoomPan = r3;
        this.enabled = r4;
        this.updatedCanPan = new o2(this);
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.pointerInputNode = delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TransformableNode$pointerInputNode$1(this)));
    }

    public final void update(TransformableState r1, Function1<? super Offset, Boolean> r2, boolean r3, boolean r4) {
        this.canPan = r2;
        if (Intrinsics.areEqual(this.state, r1) == true) goto L5;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L14;
        this.state = r1;
        this.enabled = r4;
        this.lockRotationOnZoomPan = r3;
        this.pointerInputNode.resetPointerInputHandler();
        return;
    L14:
        return;
    L5:
        if (this.enabled != r4) goto L10;
        if (this.lockRotationOnZoomPan != r3) goto L10;
        r5 = false;
        goto L11
    }
}
