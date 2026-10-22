package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'Bµ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012<\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016\u0012<\u0010\u0017\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0002H\u0016J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\f\u0010%\u001a\u00020\u0014*\u00020&H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dRF\u0010\u0017\u001a8\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\b\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001a\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/foundation/gestures/DraggableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/DraggableNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "reverseDirection", "<init>", "(Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", "create", "update", "node", "equals", "other", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DraggableElement extends ModifierNodeElement<DraggableNode> {
    public static final int $stable = 0;
    private static final Function1<PointerInputChange, Boolean> CanDrag = null;
    public static final Companion Companion = null;
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted;
    private final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> onDragStopped;
    private final Orientation orientation;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final DraggableState state;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/gestures/DraggableElement$Companion;", "", "<init>", "()V", "CanDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Function1<PointerInputChange, Boolean> getCanDrag() {
            return DraggableElement.access$getCanDrag$cp();
        }
    }

    private static final boolean CanDrag$lambda$0(PointerInputChange r0) {
        return true;
    }

    public static /* synthetic */ boolean a(PointerInputChange r0) {
        return CanDrag$lambda$0(r0);
    }

    static {
        Companion = new Companion(null);
        CanDrag = new p1();
    }

    public DraggableNode create() {
        return new DraggableNode(this.state, CanDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    public int hashCode() {
        int r0 = ((this.state.hashCode() * 31) + this.orientation.hashCode()) * 31;
        int r2 = 1231;
        if (this.enabled == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        MutableInteractionSource r4 = this.interactionSource;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.startDragImmediately == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((((r6 + r7) * 31) + this.onDragStarted.hashCode()) * 31) + this.onDragStopped.hashCode()) * 31;
        if (this.reverseDirection == true) goto L19;
        r2 = 1237;
    L19:
        return r8 + r2;
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public static final /* synthetic */ Function1 access$getCanDrag$cp() {
        return CanDrag;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m593create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (DraggableElement.class == r5.getClass()) goto L11;
        return false;
    L11:
        DraggableElement r6 = (DraggableElement) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L15;
        return false;
    L15:
        if (this.orientation == r6.orientation) goto L18;
        return false;
    L18:
        if (this.enabled == r6.enabled) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L24;
        return false;
    L24:
        if (this.startDragImmediately == r6.startDragImmediately) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.onDragStarted, r6.onDragStarted) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.onDragStopped, r6.onDragStopped) == true) goto L33;
        return false;
    L33:
        if (this.reverseDirection == r6.reverseDirection) goto L35;
        return false;
    L35:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("draggable");
        r4.getProperties().set("orientation", this.orientation);
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("startDragImmediately", Boolean.valueOf(this.startDragImmediately));
        r4.getProperties().set("onDragStarted", this.onDragStarted);
        r4.getProperties().set("onDragStopped", this.onDragStopped);
        r4.getProperties().set("state", this.state);
    }

    public void update(DraggableNode r11) {
        r11.update(this.state, CanDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((DraggableNode) r1);
    }

    public DraggableElement(DraggableState r1, Orientation r2, boolean r3, MutableInteractionSource r4, boolean r5, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r6, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> r7, boolean r8) {
        this.state = r1;
        this.orientation = r2;
        this.enabled = r3;
        this.interactionSource = r4;
        this.startDragImmediately = r5;
        this.onDragStarted = r6;
        this.onDragStopped = r7;
        this.reverseDirection = r8;
    }
}
