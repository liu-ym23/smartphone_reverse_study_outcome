package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\f\u0010\u0017\u001a\u00020\u0010*\u00020\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\r¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollNode;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "", "isVertical", "<init>", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "getScrollState", "()Landroidx/compose/foundation/ScrollState;", "getReverseScrolling", "()Z", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollingLayoutElement extends ModifierNodeElement<ScrollNode> {
    public static final int $stable = 0;
    private final boolean isVertical;
    private final boolean reverseScrolling;
    private final ScrollState scrollState;

    public ScrollNode create() {
        return new ScrollNode(this.scrollState, this.reverseScrolling, this.isVertical);
    }

    public int hashCode() {
        int r0 = this.scrollState.hashCode() * 31;
        int r2 = 1231;
        if (this.reverseScrolling == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.isVertical == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final ScrollState getScrollState() {
        return this.scrollState;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m453create() {
        return create();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ScrollingLayoutElement) == true) goto L5;
        return false;
    L5:
        ScrollingLayoutElement r5 = (ScrollingLayoutElement) r4;
        if (Intrinsics.areEqual(this.scrollState, r5.scrollState) == true) goto L8;
        return false;
    L8:
        if (this.reverseScrolling == r5.reverseScrolling) goto L10;
        return false;
    L10:
        if (this.isVertical != r5.isVertical) goto L15;
        return true;
    L15:
        return false;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("scroll");
        r4.getProperties().set("state", this.scrollState);
        r4.getProperties().set("reverseScrolling", Boolean.valueOf(this.reverseScrolling));
        r4.getProperties().set("isVertical", Boolean.valueOf(this.isVertical));
    }

    public void update(ScrollNode r2) {
        r2.setState(this.scrollState);
        r2.setReverseScrolling(this.reverseScrolling);
        r2.setVertical(this.isVertical);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((ScrollNode) r1);
    }

    public ScrollingLayoutElement(ScrollState r1, boolean r2, boolean r3) {
        this.scrollState = r1;
        this.reverseScrolling = r2;
        this.isVertical = r3;
    }
}
