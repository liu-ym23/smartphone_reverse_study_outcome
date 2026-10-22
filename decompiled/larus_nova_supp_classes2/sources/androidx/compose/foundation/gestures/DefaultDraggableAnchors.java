package androidx.compose.foundation.gestures;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0017\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0013\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", "T", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "keys", "", "anchors", "", "<init>", "(Ljava/util/List;[F)V", "positionOf", "", "anchor", "(Ljava/lang/Object;)F", "hasPositionFor", "", "(Ljava/lang/Object;)Z", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "(FZ)Ljava/lang/Object;", "minPosition", "maxPosition", "size", "", "getSize", "()I", "anchorAt", "index", "(I)Ljava/lang/Object;", "positionAt", "equals", "other", "", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultDraggableAnchors<T> implements DraggableAnchors<T> {
    private final float[] anchors;
    private final List<T> keys;
    private final int size;

    public int hashCode() {
        return (((this.keys.hashCode() * 31) + Arrays.hashCode(this.anchors)) * 31) + getSize();
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float maxPosition() {
        Float r0 = ArraysKt.maxOrNull(this.anchors);
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return r0.floatValue();
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float minPosition() {
        Float r0 = ArraysKt.minOrNull(this.anchors);
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return r0.floatValue();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("DraggableAnchors(anchors={");
        int r1 = getSize();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        StringBuilder r3 = new StringBuilder();
        r3.append(anchorAt(r2));
        r3.append('=');
        r3.append(positionAt(r2));
        r0.append(r3.toString());
        if (r2 >= (getSize() - 1)) goto L7;
        r0.append(", ");
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r0.append("})");
        return r0.toString();
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public int getSize() {
        return this.size;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public T anchorAt(int r2) {
        return (T) CollectionsKt.getOrNull(this.keys, r2);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public T closestAnchor(float r10) {
        float[] r0 = this.anchors;
        int r1 = r0.length;
        int r2 = -1;
        float r3 = Float.POSITIVE_INFINITY;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r1) goto L9;
        int r7 = r5 + 1;
        float r6 = Math.abs(r10 - r0[r4]);
        if (r6 > r3) goto L7;
        r2 = r5;
        r3 = r6;
    L7:
        r4 = r4 + 1;
        r5 = r7;
        goto L3
    L9:
        return (T) ListProtector.get(this.keys, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DefaultDraggableAnchors) == true) goto L8;
        return false;
    L8:
        DefaultDraggableAnchors r6 = (DefaultDraggableAnchors) r5;
        if (Intrinsics.areEqual(this.keys, r6.keys) == true) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.anchors, r6.anchors) == true) goto L15;
        return false;
    L15:
        if (getSize() == r6.getSize()) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public boolean hasPositionFor(T r2) {
        if (this.keys.indexOf(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float positionAt(int r5) {
        float[] r0 = this.anchors;
        Function1 r1 = AnchoredDraggableKt.access$getGetOrNan$p();
        boolean r2 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r2 == false) goto L10;
        return r0[r5];
    L10:
        return ((Number) r1.invoke(Integer.valueOf(r5))).floatValue();
    L5:
        if (r5 >= r0.length) goto L7;
        r2 = true;
        goto L7
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float positionOf(T r5) {
        int r6 = this.keys.indexOf(r5);
        float[] r0 = this.anchors;
        Function1 r1 = AnchoredDraggableKt.access$getGetOrNan$p();
        boolean r2 = false;
        if (r6 >= 0) goto L5;
    L7:
        if (r2 == false) goto L10;
        return r0[r6];
    L10:
        return ((Number) r1.invoke(Integer.valueOf(r6))).floatValue();
    L5:
        if (r6 >= r0.length) goto L7;
        r2 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultDraggableAnchors(List<? extends T> r3, float[] r4) {
        this.keys = r3;
        this.anchors = r4;
        if (r3.size() != r4.length) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("DraggableAnchors were constructed with inconsistent key-value sizes. Keys: " + r3 + " | Anchors: " + ArraysKt.toList(r4));
    L8:
        this.size = r4.length;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public T closestAnchor(float r11, boolean r12) {
        float[] r0 = this.anchors;
        int r1 = r0.length;
        int r2 = -1;
        int r4 = 0;
        int r5 = 0;
        float r6 = Float.POSITIVE_INFINITY;
    L3:
        if (r4 >= r1) goto L16;
        float r7 = r0[r4];
        int r8 = r5 + 1;
        if (r12 == false) goto L7;
        float r9 = r7 - r11;
    L9:
        if (r9 >= MenuKt.ClosedAlphaTarget) goto L12;
        r9 = Float.POSITIVE_INFINITY;
    L12:
        if (r9 > r6) goto L14;
        r2 = r5;
        r6 = r9;
    L14:
        r4 = r4 + 1;
        r5 = r8;
        goto L3
    L7:
        r9 = r11 - r7;
        goto L9
    L16:
        return (T) ListProtector.get(this.keys, r2);
    }
}
