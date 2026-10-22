package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\b\u0010\n\u001a\u00020\u0007H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/OverscrollModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "overscrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;)V", "onAttach", "", "onDetach", "update", "attachIfNeeded", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OverscrollModifierNode extends DelegatingNode {
    private DelegatableNode overscrollNode;

    private final void attachIfNeeded() {
        DelegatableNode r0 = this.overscrollNode;
        boolean r1 = false;
        if (r0 == null) goto L9;
        Modifier.Node r2 = r0.getNode();
        if (r2 == null) goto L9;
        if (r2.isAttached() == true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        DelegatableNode r3 = this.overscrollNode;
        Intrinsics.checkNotNull(r3);
        DelegatableNode r4 = delegate(r3);
    L12:
        this.overscrollNode = r4;
        return;
    L11:
        r4 = null;
        goto L12
    }

    public void onDetach() {
        DelegatableNode r0 = this.overscrollNode;
        if (r0 == null) goto L6;
        undelegate(r0);
        return;
    }

    public void onAttach() {
        attachIfNeeded();
    }

    public OverscrollModifierNode(DelegatableNode r1) {
        this.overscrollNode = r1;
    }

    public final void update(DelegatableNode r2) {
        DelegatableNode r0 = this.overscrollNode;
        if (r0 == null) goto L5;
        undelegate(r0);
    L5:
        this.overscrollNode = r2;
        attachIfNeeded();
    }
}
