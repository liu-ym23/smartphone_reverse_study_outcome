package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/LimitInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getSides-JoeWqyM", "()I", "I", "getLeft", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getTop", "getRight", "getBottom", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LimitInsets implements WindowInsets {
    private final WindowInsets insets;
    private final int sides;

    public /* synthetic */ LimitInsets(WindowInsets r1, int r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + WindowInsetsSides.m1059hashCodeimpl(this.sides);
    }

    public String toString() {
        return "(" + this.insets + " only " + WindowInsetsSides.m1061toStringimpl(this.sides) + ')';
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    /* JADX INFO: renamed from: getSides-JoeWqyM, reason: not valid java name */
    public final int m909getSidesJoeWqyM() {
        return this.sides;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LimitInsets) == true) goto L8;
        return false;
    L8:
        LimitInsets r6 = (LimitInsets) r5;
        if (Intrinsics.areEqual(this.insets, r6.insets) == true) goto L11;
    L13:
        return false;
    L11:
        if (WindowInsetsSides.m1057equalsimpl0(this.sides, r6.sides) == false) goto L13;
        return true;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(Density r3) {
        if (WindowInsetsSides.m1058hasAnybkgdKaI$foundation_layout(this.sides, WindowInsetsSides.Companion.m1068getBottomJoeWqyM()) == true) goto L7;
        return 0;
    L7:
        return this.insets.getBottom(r3);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(Density r3) {
        if (WindowInsetsSides.m1058hasAnybkgdKaI$foundation_layout(this.sides, WindowInsetsSides.Companion.m1074getTopJoeWqyM()) == true) goto L7;
        return 0;
    L7:
        return this.insets.getTop(r3);
    }

    private LimitInsets(WindowInsets r1, int r2) {
        this.insets = r1;
        this.sides = r2;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(Density r3, LayoutDirection r4) {
        if (r4 != LayoutDirection.Ltr) goto L5;
        int r0 = WindowInsetsSides.Companion.m1064getAllowLeftInLtrJoeWqyM$foundation_layout();
    L7:
        if (WindowInsetsSides.m1058hasAnybkgdKaI$foundation_layout(this.sides, r0) == true) goto L11;
        return 0;
    L11:
        return this.insets.getLeft(r3, r4);
    L5:
        r0 = WindowInsetsSides.Companion.m1065getAllowLeftInRtlJoeWqyM$foundation_layout();
        goto L7
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(Density r3, LayoutDirection r4) {
        if (r4 != LayoutDirection.Ltr) goto L5;
        int r0 = WindowInsetsSides.Companion.m1066getAllowRightInLtrJoeWqyM$foundation_layout();
    L7:
        if (WindowInsetsSides.m1058hasAnybkgdKaI$foundation_layout(this.sides, r0) == true) goto L11;
        return 0;
    L11:
        return this.insets.getRight(r3, r4);
    L5:
        r0 = WindowInsetsSides.Companion.m1067getAllowRightInRtlJoeWqyM$foundation_layout();
        goto L7
    }
}
