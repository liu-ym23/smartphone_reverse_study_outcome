package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\f\u0010\u0015\u001a\u00020\r*\u00020\u0016H\u0016R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/PreferKeepClearElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/PreferKeepClearNode;", "clearRect", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getClearRect", "()Lkotlin/jvm/functions/Function1;", "create", "update", "", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PreferKeepClearElement extends ModifierNodeElement<PreferKeepClearNode> {
    private final Function1<LayoutCoordinates, Rect> clearRect;

    public PreferKeepClearNode create() {
        return new PreferKeepClearNode(this.clearRect);
    }

    public int hashCode() {
        Function1<LayoutCoordinates, Rect> r0 = this.clearRect;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final Function1<LayoutCoordinates, Rect> getClearRect() {
        return this.clearRect;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Modifier.Node m450create() {
        return create();
    }

    public PreferKeepClearElement(Function1<? super LayoutCoordinates, Rect> r1) {
        this.clearRect = r1;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof PreferKeepClearNode) == true) goto L6;
        return false;
    L6:
        if (this.clearRect != ((PreferKeepClearNode) r3).getRect()) goto L9;
        return true;
    L9:
        return false;
    }

    public void inspectableProperties(InspectorInfo r3) {
        r3.setName("preferKeepClearBounds");
        if (this.clearRect == null) goto L6;
        r3.getProperties().set("clearRect", this.clearRect);
        return;
    }

    public void update(PreferKeepClearNode r2) {
        r2.setRect(this.clearRect);
    }

    public /* bridge */ /* synthetic */ void update(Modifier.Node r1) {
        update((PreferKeepClearNode) r1);
    }
}
