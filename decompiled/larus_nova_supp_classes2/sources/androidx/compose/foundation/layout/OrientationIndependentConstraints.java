package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0005J\u0015\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u000fJ\u0015\u0010\u001a\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001cJ5\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\b\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0012\u0010\t\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0012\u0010\n\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006("}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "value", "Landroidx/compose/ui/unit/Constraints;", "constructor-impl", "(J)J", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "(IIII)J", "c", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "J", "getMainAxisMin-impl", "(J)I", "getMainAxisMax-impl", "getCrossAxisMin-impl", "getCrossAxisMax-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "maxWidth", "maxWidth-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxHeight", "maxHeight-impl", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "hashCode", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class OrientationIndependentConstraints {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m925boximpl(long r1) {
        return new OrientationIndependentConstraints(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m927constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m931equalsimpl(long r4, Object r6) {
        if ((r6 instanceof OrientationIndependentConstraints) == true) goto L6;
        return false;
    L6:
        if (Constraints.equals-impl0(r4, ((OrientationIndependentConstraints) r6).m943unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m932equalsimpl0(long r0, long r2) {
        return Constraints.equals-impl0(r0, r2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m937hashCodeimpl(long r0) {
        return Constraints.hashCode-impl(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m942toStringimpl(long r2) {
        return "OrientationIndependentConstraints(value=" + Constraints.toString-impl(r2) + ')';
    }

    public boolean equals(Object r3) {
        return m931equalsimpl(this.value, r3);
    }

    public int hashCode() {
        return m937hashCodeimpl(this.value);
    }

    public String toString() {
        return m942toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m943unboximpl() {
        return this.value;
    }

    private /* synthetic */ OrientationIndependentConstraints(long r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m933getCrossAxisMaximpl(long r0) {
        return Constraints.getMaxHeight-impl(r0);
    }

    /* JADX INFO: renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m934getCrossAxisMinimpl(long r0) {
        return Constraints.getMinHeight-impl(r0);
    }

    /* JADX INFO: renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m935getMainAxisMaximpl(long r0) {
        return Constraints.getMaxWidth-impl(r0);
    }

    /* JADX INFO: renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m936getMainAxisMinimpl(long r0) {
        return Constraints.getMinWidth-impl(r0);
    }

    /* JADX INFO: renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m940stretchCrossAxisq4ezo7Y(long r4) {
        int r0 = Constraints.getMinWidth-impl(r4);
        int r1 = Constraints.getMaxWidth-impl(r4);
        if (Constraints.getMaxHeight-impl(r4) == Integer.MAX_VALUE) goto L5;
        int r2 = Constraints.getMaxHeight-impl(r4);
    L7:
        return m926constructorimpl(r0, r1, r2, Constraints.getMaxHeight-impl(r4));
    L5:
        r2 = Constraints.getMinHeight-impl(r4);
        goto L7
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m928constructorimpl(long r4, LayoutOrientation r6) {
        LayoutOrientation r0 = LayoutOrientation.Horizontal;
        if (r6 != r0) goto L5;
        int r1 = Constraints.getMinWidth-impl(r4);
    L6:
        if (r6 != r0) goto L8;
        int r2 = Constraints.getMaxWidth-impl(r4);
    L9:
        if (r6 != r0) goto L11;
        int r3 = Constraints.getMinHeight-impl(r4);
    L12:
        if (r6 != r0) goto L14;
        int r5 = Constraints.getMaxHeight-impl(r4);
    L16:
        return m926constructorimpl(r1, r2, r3, r5);
    L14:
        r5 = Constraints.getMaxWidth-impl(r4);
        goto L16
    L11:
        r3 = Constraints.getMinWidth-impl(r4);
        goto L12
    L8:
        r2 = Constraints.getMaxHeight-impl(r4);
        goto L9
    L5:
        r1 = Constraints.getMinHeight-impl(r4);
        goto L6
    }

    /* JADX INFO: renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m938maxHeightimpl(long r1, LayoutOrientation r3) {
        if (r3 != LayoutOrientation.Horizontal) goto L6;
        return Constraints.getMaxHeight-impl(r1);
    L6:
        return Constraints.getMaxWidth-impl(r1);
    }

    /* JADX INFO: renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m939maxWidthimpl(long r1, LayoutOrientation r3) {
        if (r3 != LayoutOrientation.Horizontal) goto L6;
        return Constraints.getMaxWidth-impl(r1);
    L6:
        return Constraints.getMaxHeight-impl(r1);
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m941toBoxConstraintsOenEA2s(long r2, LayoutOrientation r4) {
        if (r4 != LayoutOrientation.Horizontal) goto L6;
        return ConstraintsKt.Constraints(Constraints.getMinWidth-impl(r2), Constraints.getMaxWidth-impl(r2), Constraints.getMinHeight-impl(r2), Constraints.getMaxHeight-impl(r2));
    L6:
        return ConstraintsKt.Constraints(Constraints.getMinHeight-impl(r2), Constraints.getMaxHeight-impl(r2), Constraints.getMinWidth-impl(r2), Constraints.getMaxWidth-impl(r2));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m926constructorimpl(int r0, int r1, int r2, int r3) {
        return m927constructorimpl(ConstraintsKt.Constraints(r0, r1, r2, r3));
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m929copyyUG9Ft0(long r0, int r2, int r3, int r4, int r5) {
        return m926constructorimpl(r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m930copyyUG9Ft0$default(long r6, int r8, int r9, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r8 = Constraints.getMinWidth-impl(r6);
    L5:
        int r2 = r8;
        if ((r12 & 2) == 0) goto L8;
        r9 = Constraints.getMaxWidth-impl(r6);
    L8:
        int r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = Constraints.getMinHeight-impl(r6);
    L11:
        int r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r11 = Constraints.getMaxHeight-impl(r6);
    L15:
        return m929copyyUG9Ft0(r6, r2, r3, r4, r11);
    }
}
