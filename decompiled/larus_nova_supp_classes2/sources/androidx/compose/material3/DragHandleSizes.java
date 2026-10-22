package androidx.compose.material3;

import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DragHandleSizes;", "", "size", "Landroidx/compose/ui/unit/DpSize;", "pressedSize", "draggedSize", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-MYxV2XQ", "()J", "J", "getPressedSize-MYxV2XQ", "getDraggedSize-MYxV2XQ", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DragHandleSizes {
    public static final int $stable = 0;
    private final long draggedSize;
    private final long pressedSize;
    private final long size;

    public /* synthetic */ DragHandleSizes(long r1, long r3, long r5, DefaultConstructorMarker r7) {
        this(r1, r3, r5);
    }

    public int hashCode() {
        return (((DpSize.hashCode-impl(this.size) * 31) + DpSize.hashCode-impl(this.pressedSize)) * 31) + DpSize.hashCode-impl(this.draggedSize);
    }

    /* JADX INFO: renamed from: getDraggedSize-MYxV2XQ, reason: not valid java name */
    public final long m2639getDraggedSizeMYxV2XQ() {
        return this.draggedSize;
    }

    /* JADX INFO: renamed from: getPressedSize-MYxV2XQ, reason: not valid java name */
    public final long m2640getPressedSizeMYxV2XQ() {
        return this.pressedSize;
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name */
    public final long m2641getSizeMYxV2XQ() {
        return this.size;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L20:
        return false;
    L8:
        if ((r7 instanceof DragHandleSizes) == false) goto L20;
        DragHandleSizes r8 = (DragHandleSizes) r7;
        if (DpSize.equals-impl0(this.size, r8.size) == true) goto L14;
        return false;
    L14:
        if (DpSize.equals-impl0(this.pressedSize, r8.pressedSize) == true) goto L17;
        return false;
    L17:
        if (DpSize.equals-impl0(this.draggedSize, r8.draggedSize) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private DragHandleSizes(long r1, long r3, long r5) {
        this.size = r1;
        this.pressedSize = r3;
        this.draggedSize = r5;
    }
}
