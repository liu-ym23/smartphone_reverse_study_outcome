package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DragHandleColors;", "", "color", "Landroidx/compose/ui/graphics/Color;", "pressedColor", "draggedColor", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getPressedColor-0d7_KjU", "getDraggedColor-0d7_KjU", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DragHandleColors {
    public static final int $stable = 0;
    private final long color;
    private final long draggedColor;
    private final long pressedColor;

    public /* synthetic */ DragHandleColors(long r1, long r3, long r5, DefaultConstructorMarker r7) {
        this(r1, r3, r5);
    }

    public int hashCode() {
        return (((Color.hashCode-impl(this.color) * 31) + Color.hashCode-impl(this.pressedColor)) * 31) + Color.hashCode-impl(this.draggedColor);
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2636getColor0d7_KjU() {
        return this.color;
    }

    /* JADX INFO: renamed from: getDraggedColor-0d7_KjU, reason: not valid java name */
    public final long m2637getDraggedColor0d7_KjU() {
        return this.draggedColor;
    }

    /* JADX INFO: renamed from: getPressedColor-0d7_KjU, reason: not valid java name */
    public final long m2638getPressedColor0d7_KjU() {
        return this.pressedColor;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L20:
        return false;
    L8:
        if ((r7 instanceof DragHandleColors) == false) goto L20;
        DragHandleColors r8 = (DragHandleColors) r7;
        if (Color.equals-impl0(this.color, r8.color) == true) goto L14;
        return false;
    L14:
        if (Color.equals-impl0(this.pressedColor, r8.pressedColor) == true) goto L17;
        return false;
    L17:
        if (Color.equals-impl0(this.draggedColor, r8.draggedColor) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private DragHandleColors(long r1, long r3, long r5) {
        this.color = r1;
        this.pressedColor = r3;
        this.draggedColor = r5;
    }
}
