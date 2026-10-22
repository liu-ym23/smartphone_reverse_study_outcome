package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "F", "getMinHeight-D9Ej5fM", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnspecifiedConstraintsElement extends ModifierNodeElement<UnspecifiedConstraintsNode> {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsElement(float r1, float r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public UnspecifiedConstraintsNode create() {
        return new UnspecifiedConstraintsNode(this.minWidth, this.minHeight, null);
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.minWidth) * 31) + Dp.hashCode-impl(this.minHeight);
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1033getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1034getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m1035create() {
        return create();
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof UnspecifiedConstraintsElement) == true) goto L5;
        return false;
    L5:
        UnspecifiedConstraintsElement r5 = (UnspecifiedConstraintsElement) r4;
        if (Dp.equals-impl0(this.minWidth, r5.minWidth) == true) goto L8;
        return false;
    L8:
        if (Dp.equals-impl0(this.minHeight, r5.minHeight) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void inspectableProperties(InspectorInfo r4) {
        r4.setName("defaultMinSize");
        r4.getProperties().set("minWidth", Dp.box-impl(this.minWidth));
        r4.getProperties().set("minHeight", Dp.box-impl(this.minHeight));
    }

    public void update(UnspecifiedConstraintsNode r2) {
        r2.m1040setMinWidth0680j_4(this.minWidth);
        r2.m1039setMinHeight0680j_4(this.minHeight);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((UnspecifiedConstraintsNode) r1);
    }

    private UnspecifiedConstraintsElement(float r1, float r2) {
        this.minWidth = r1;
        this.minHeight = r2;
    }

    public /* synthetic */ UnspecifiedConstraintsElement(float r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Dp.Companion.getUnspecified-D9Ej5fM();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Dp.Companion.getUnspecified-D9Ej5fM();
    L8:
        this(r1, r2, null);
    }
}
