package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM$annotations", "()V", "getStart-D9Ej5fM", "()F", "F", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM$annotations", "getBottom-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PaddingValuesImpl implements PaddingValues {
    public static final int $stable = 0;
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float r1, float r2, float r3, float r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m979getBottomD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m980getEndD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m981getStartD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m982getTopD9Ej5fM$annotations() {
    }

    public int hashCode() {
        return (((((Dp.hashCode-impl(this.start) * 31) + Dp.hashCode-impl(this.top)) * 31) + Dp.hashCode-impl(this.end)) * 31) + Dp.hashCode-impl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + Dp.toString-impl(this.start) + ", top=" + Dp.toString-impl(this.top) + ", end=" + Dp.toString-impl(this.end) + ", bottom=" + Dp.toString-impl(this.bottom) + ')';
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    public float mo898calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public float mo901calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m983getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m984getEndD9Ej5fM() {
        return this.end;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m985getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m986getTopD9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public float mo899calculateLeftPaddingu2uoSUM(LayoutDirection r2) {
        if (r2 != LayoutDirection.Ltr) goto L6;
        return this.start;
    L6:
        return this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo900calculateRightPaddingu2uoSUM(LayoutDirection r2) {
        if (r2 != LayoutDirection.Ltr) goto L6;
        return this.end;
    L6:
        return this.start;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof PaddingValuesImpl) == true) goto L5;
        return false;
    L5:
        PaddingValuesImpl r5 = (PaddingValuesImpl) r4;
        if (Dp.equals-impl0(this.start, r5.start) == true) goto L8;
        return false;
    L8:
        if (Dp.equals-impl0(this.top, r5.top) == true) goto L10;
        return false;
    L10:
        if (Dp.equals-impl0(this.end, r5.end) == true) goto L12;
        return false;
    L12:
        if (Dp.equals-impl0(this.bottom, r5.bottom) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private PaddingValuesImpl(float r4, float r5, float r6, float r7) {
        this.start = r4;
        this.top = r5;
        this.end = r6;
        this.bottom = r7;
        boolean r0 = true;
        if (r4 < MenuKt.ClosedAlphaTarget) goto L5;
        boolean r8 = true;
    L7:
        if (r5 < MenuKt.ClosedAlphaTarget) goto L9;
        boolean r9 = true;
    L10:
        boolean r10 = r8 & r9;
        if (r6 < MenuKt.ClosedAlphaTarget) goto L13;
        boolean r11 = true;
    L14:
        boolean r12 = r10 & r11;
        if (r7 >= MenuKt.ClosedAlphaTarget) goto L19;
        r0 = false;
    L19:
        if ((r12 & r0) == true) goto L22;
        InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        return;
    L22:
        return;
    L13:
        r11 = false;
        goto L14
    L9:
        r9 = false;
        goto L10
    L5:
        r8 = false;
        goto L7
    }

    public /* synthetic */ PaddingValuesImpl(float r8, float r9, float r10, float r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r8 = Dp.constructor-impl(0);
    L5:
        float r2 = r8;
        if ((r12 & 2) == 0) goto L8;
        r9 = Dp.constructor-impl(0);
    L8:
        float r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = Dp.constructor-impl(0);
    L11:
        float r4 = r10;
        if ((r12 & 8) == 0) goto L14;
        r11 = Dp.constructor-impl(0);
    L14:
        this(r2, r3, r4, r11, null);
    }
}
