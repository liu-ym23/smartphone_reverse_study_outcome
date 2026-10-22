package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "contentWidth", "<init>", "(FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "getWidth-D9Ej5fM", "getContentWidth-D9Ej5fM", "right", "getRight-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TabPosition {
    public static final int $stable = 0;
    private final float contentWidth;
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float r1, float r2, float r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m3254getRightD9Ej5fM() {
        return Dp.constructor-impl(this.left + this.width);
    }

    public int hashCode() {
        return (((Dp.hashCode-impl(this.left) * 31) + Dp.hashCode-impl(this.width)) * 31) + Dp.hashCode-impl(this.contentWidth);
    }

    public String toString() {
        return "TabPosition(left=" + Dp.toString-impl(this.left) + ", right=" + Dp.toString-impl(m3254getRightD9Ej5fM()) + ", width=" + Dp.toString-impl(this.width) + ", contentWidth=" + Dp.toString-impl(this.contentWidth) + ')';
    }

    /* JADX INFO: renamed from: getContentWidth-D9Ej5fM, reason: not valid java name */
    public final float m3252getContentWidthD9Ej5fM() {
        return this.contentWidth;
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m3253getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m3255getWidthD9Ej5fM() {
        return this.width;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TabPosition) == true) goto L8;
        return false;
    L8:
        TabPosition r6 = (TabPosition) r5;
        if (Dp.equals-impl0(this.left, r6.left) == true) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.width, r6.width) == true) goto L15;
        return false;
    L15:
        if (Dp.equals-impl0(this.contentWidth, r6.contentWidth) == true) goto L17;
        return false;
    L17:
        return true;
    }

    private TabPosition(float r1, float r2, float r3) {
        this.left = r1;
        this.width = r2;
        this.contentWidth = r3;
    }
}
