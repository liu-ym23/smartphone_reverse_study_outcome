package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!Bw\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\f\u0010\u001f\u001a\u00020\u0010*\u00020 H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/foundation/gestures/Draggable2DElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/Draggable2DNode;", "state", "Landroidx/compose/foundation/gestures/Draggable2DState;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "startedPosition", "", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "<init>", "(Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "create", "update", "node", "equals", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Draggable2DElement extends ModifierNodeElement<Draggable2DNode> {
    public static final int $stable = 0;
    private static final Function1<PointerInputChange, Boolean> CanDrag = null;
    public static final Companion Companion = null;
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function1<Offset, Unit> onDragStarted;
    private final Function1<Velocity, Unit> onDragStopped;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final Draggable2DState state;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/gestures/Draggable2DElement$Companion;", "", "<init>", "()V", "CanDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Function1<PointerInputChange, Boolean> getCanDrag() {
            return Draggable2DElement.access$getCanDrag$cp();
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
        CanDrag = new k1();
    }

    public Draggable2DNode create() {
        return new Draggable2DNode(this.state, CanDrag, this.enabled, this.interactionSource, this.startDragImmediately, this.reverseDirection, this.onDragStarted, this.onDragStopped);
    }

    public int hashCode() {
        int r0 = this.state.hashCode() * 31;
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
    public /* bridge */ /* synthetic */ Modifier.Node m591create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Draggable2DElement.class == r5.getClass()) goto L11;
        return false;
    L11:
        Draggable2DElement r6 = (Draggable2DElement) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L15;
        return false;
    L15:
        if (this.enabled == r6.enabled) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.interactionSource, r6.interactionSource) == true) goto L21;
        return false;
    L21:
        if (this.startDragImmediately == r6.startDragImmediately) goto L24;
        return false;
    L24:
        if (this.onDragStarted == r6.onDragStarted) goto L27;
        return false;
    L27:
        if (this.onDragStopped == r6.onDragStopped) goto L30;
        return false;
    L30:
        if (this.reverseDirection == r6.reverseDirection) goto L32;
        return false;
    L32:
        return true;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("draggable2D");
        r4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        r4.getProperties().set("interactionSource", this.interactionSource);
        r4.getProperties().set("startDragImmediately", Boolean.valueOf(this.startDragImmediately));
        r4.getProperties().set("onDragStarted", this.onDragStarted);
        r4.getProperties().set("onDragStopped", this.onDragStopped);
        r4.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        r4.getProperties().set("state", this.state);
    }

    public void update(Draggable2DNode r10) {
        r10.update(this.state, CanDrag, this.enabled, this.interactionSource, this.startDragImmediately, this.reverseDirection, this.onDragStarted, this.onDragStopped);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((Draggable2DNode) r1);
    }

    public Draggable2DElement(Draggable2DState r1, boolean r2, MutableInteractionSource r3, boolean r4, Function1<? super Offset, Unit> r5, Function1<? super Velocity, Unit> r6, boolean r7) {
        this.state = r1;
        this.enabled = r2;
        this.interactionSource = r3;
        this.startDragImmediately = r4;
        this.onDragStarted = r5;
        this.onDragStopped = r6;
        this.reverseDirection = r7;
    }
}
