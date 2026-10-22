package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/layout/LayoutWeightNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "weight", "", "fill", "", "<init>", "(FZ)V", "getWeight", "()F", "setWeight", "(F)V", "getFill", "()Z", "setFill", "(Z)V", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LayoutWeightNode extends Modifier.Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private boolean fill;
    private float weight;

    public final boolean getFill() {
        return this.fill;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setFill(boolean r1) {
        this.fill = r1;
    }

    public final void setWeight(float r1) {
        this.weight = r1;
    }

    public LayoutWeightNode(float r1, boolean r2) {
        this.weight = r1;
        this.fill = r2;
    }

    public RowColumnParentData modifyParentData(Density r8, Object r9) {
        if ((r9 instanceof RowColumnParentData) == false) goto L5;
        RowColumnParentData r10 = (RowColumnParentData) r9;
    L6:
        if (r10 != null) goto L8;
        r10 = new RowColumnParentData(MenuKt.ClosedAlphaTarget, false, null, null, 15, null);
    L8:
        r10.setWeight(this.weight);
        r10.setFill(this.fill);
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    /* JADX INFO: renamed from: modifyParentData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m907modifyParentData(Density r1, Object r2) {
        return modifyParentData(r1, r2);
    }
}
