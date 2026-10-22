package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/LayoutWeightElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/LayoutWeightNode;", "weight", "", "fill", "", "<init>", "(FZ)V", "getWeight", "()F", "getFill", "()Z", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "other", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LayoutWeightElement extends ModifierNodeElement<LayoutWeightNode> {
    public static final int $stable = 0;
    private final boolean fill;
    private final float weight;

    public LayoutWeightNode create() {
        return new LayoutWeightNode(this.weight, this.fill);
    }

    public int hashCode() {
        int r0 = Float.floatToIntBits(this.weight) * 31;
        if (this.fill == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final float getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m906create() {
        return create();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LayoutWeightElement) == false) goto L8;
        LayoutWeightElement r6 = (LayoutWeightElement) r5;
    L10:
        if (r6 != null) goto L13;
        return false;
    L13:
        if (this.weight != r6.weight) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
    L20:
        return false;
    L18:
        if (this.fill != r6.fill) goto L20;
        return true;
    L15:
        r2 = false;
        goto L16
    L8:
        r6 = null;
        goto L10
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("weight");
        r4.setValue(Float.valueOf(this.weight));
        r4.getProperties().set("weight", Float.valueOf(this.weight));
        r4.getProperties().set("fill", Boolean.valueOf(this.fill));
    }

    public void update(LayoutWeightNode r2) {
        r2.setWeight(this.weight);
        r2.setFill(this.fill);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((LayoutWeightNode) r1);
    }

    public LayoutWeightElement(float r1, boolean r2) {
        this.weight = r1;
        this.fill = r2;
    }
}
