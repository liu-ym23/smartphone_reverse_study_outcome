package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/layout/VerticalAlignNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "setVertical", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VerticalAlignNode extends Modifier.Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private Alignment.Vertical vertical;

    public final Alignment.Vertical getVertical() {
        return this.vertical;
    }

    public VerticalAlignNode(Alignment.Vertical r1) {
        this.vertical = r1;
    }

    public final void setVertical(Alignment.Vertical r1) {
        this.vertical = r1;
    }

    public RowColumnParentData modifyParentData(Density r8, Object r9) {
        if ((r9 instanceof RowColumnParentData) == false) goto L5;
        RowColumnParentData r10 = (RowColumnParentData) r9;
    L6:
        if (r10 != null) goto L8;
        r10 = new RowColumnParentData(MenuKt.ClosedAlphaTarget, false, null, null, 15, null);
    L8:
        r10.setCrossAxisAlignment(CrossAxisAlignment.Companion.vertical$foundation_layout(this.vertical));
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    /* JADX INFO: renamed from: modifyParentData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1042modifyParentData(Density r1, Object r2) {
        return modifyParentData(r1, r2);
    }
}
