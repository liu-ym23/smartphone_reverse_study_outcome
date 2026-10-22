package androidx.compose.foundation.draganddrop;

import androidx.autofill.HintConstants;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B2\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J1\u0010\u0011\u001a\u00020\u00102!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropTargetNode;", "Landroidx/compose/ui/node/DelegatingNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)V", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "onAttach", "", "update", "onDetach", "createAndAttachDragAndDropModifierNode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DragAndDropTargetNode extends DelegatingNode {
    private DragAndDropTargetModifierNode dragAndDropNode;
    private Function1<? super DragAndDropEvent, Boolean> shouldStartDragAndDrop;
    private DragAndDropTarget target;

    public static /* synthetic */ boolean a(DragAndDropTargetNode r0, DragAndDropEvent r1) {
        return createAndAttachDragAndDropModifierNode$lambda$1(r0, r1);
    }

    private final void createAndAttachDragAndDropModifierNode() {
        this.dragAndDropNode = delegate(DragAndDropNodeKt.DragAndDropTargetModifierNode(new e(this), this.target));
    }

    public void onDetach() {
        DragAndDropTargetModifierNode r0 = this.dragAndDropNode;
        Intrinsics.checkNotNull(r0);
        undelegate(r0);
    }

    public void onAttach() {
        createAndAttachDragAndDropModifierNode();
    }

    public DragAndDropTargetNode(Function1<? super DragAndDropEvent, Boolean> r1, DragAndDropTarget r2) {
        this.shouldStartDragAndDrop = r1;
        this.target = r2;
    }

    private static final boolean createAndAttachDragAndDropModifierNode$lambda$1(DragAndDropTargetNode r0, DragAndDropEvent r1) {
        return ((Boolean) r0.shouldStartDragAndDrop.invoke(r1)).booleanValue();
    }

    public final void update(Function1<? super DragAndDropEvent, Boolean> r1, DragAndDropTarget r2) {
        this.shouldStartDragAndDrop = r1;
        if (Intrinsics.areEqual(r2, this.target) == true) goto L9;
        DragAndDropTargetModifierNode r3 = this.dragAndDropNode;
        if (r3 == null) goto L7;
        undelegate(r3);
    L7:
        this.target = r2;
        createAndAttachDragAndDropModifierNode();
        return;
    }
}
