package androidx.compose.material;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0010J\u001f\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0013\u0010\u0019\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Landroidx/compose/material/MapDraggableAnchors;", "T", "Landroidx/compose/material/DraggableAnchors;", "anchors", "", "", "<init>", "(Ljava/util/Map;)V", "positionOf", "value", "(Ljava/lang/Object;)F", "hasAnchorFor", "", "(Ljava/lang/Object;)Z", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minAnchor", "maxAnchor", "size", "", "getSize", "()I", "equals", "other", "", "hashCode", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MapDraggableAnchors<T> implements DraggableAnchors<T> {
    private final Map<T, Float> anchors;

    @Override // androidx.compose.material.DraggableAnchors
    public int getSize() {
        return this.anchors.size();
    }

    public int hashCode() {
        return this.anchors.hashCode() * 31;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float maxAnchor() {
        Float r0 = CollectionsKt.maxOrNull(this.anchors.values());
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return r0.floatValue();
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float minAnchor() {
        Float r0 = CollectionsKt.minOrNull(this.anchors.values());
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return r0.floatValue();
    }

    public String toString() {
        return "MapDraggableAnchors(" + this.anchors + ')';
    }

    public MapDraggableAnchors(Map<T, Float> r1) {
        this.anchors = r1;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public T closestAnchor(float r8) {
        Iterator<T> r0 = this.anchors.entrySet().iterator();
        if (r0.hasNext() == true) goto L5;
        T r1 = null;
    L14:
        Map.Entry r2 = (Map.Entry) r1;
        if (r2 != null) goto L17;
        return null;
    L17:
        return (T) r2.getKey();
    L5:
        r1 = r0.next();
        if (r0.hasNext() == false) goto L14;
        float r3 = Math.abs(r8 - ((Number) ((Map.Entry) r1).getValue()).floatValue());
    L9:
        T r4 = r0.next();
        float r5 = Math.abs(r8 - ((Number) ((Map.Entry) r4).getValue()).floatValue());
        if (Float.compare(r3, r5) <= 0) goto L13;
        r1 = r4;
        r3 = r5;
    L13:
        if (r0.hasNext() == true) goto L9;
        goto L14
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof MapDraggableAnchors) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.anchors, ((MapDraggableAnchors) r2).anchors);
    }

    @Override // androidx.compose.material.DraggableAnchors
    public boolean hasAnchorFor(T r2) {
        return this.anchors.containsKey(r2);
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float positionOf(T r2) {
        Float r3 = this.anchors.get(r2);
        if (r3 != null) goto L7;
        return Float.NaN;
    L7:
        return r3.floatValue();
    }

    @Override // androidx.compose.material.DraggableAnchors
    public T closestAnchor(float r10, boolean r11) {
        Iterator<T> r0 = this.anchors.entrySet().iterator();
        if (r0.hasNext() == true) goto L5;
        T r1 = null;
    L27:
        Map.Entry r2 = (Map.Entry) r1;
        if (r2 != null) goto L30;
        return null;
    L30:
        return (T) r2.getKey();
    L5:
        r1 = r0.next();
        if (r0.hasNext() == false) goto L27;
        float r3 = ((Number) ((Map.Entry) r1).getValue()).floatValue();
        if (r11 == false) goto L11;
        float r4 = r3 - r10;
    L13:
        if (r4 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L15;
        r4 = Float.POSITIVE_INFINITY;
    L15:
        T r6 = r0.next();
        float r7 = ((Number) ((Map.Entry) r6).getValue()).floatValue();
        if (r11 == false) goto L18;
        float r8 = r7 - r10;
    L20:
        if (r8 >= androidx.compose.material3.MenuKt.ClosedAlphaTarget) goto L23;
        r8 = Float.POSITIVE_INFINITY;
    L23:
        if (Float.compare(r4, r8) <= 0) goto L26;
        r1 = r6;
        r4 = r8;
    L26:
        if (r0.hasNext() == true) goto L15;
    L18:
        r8 = r10 - r7;
        goto L20
    L11:
        r4 = r10 - r3;
        goto L13
    }
}
