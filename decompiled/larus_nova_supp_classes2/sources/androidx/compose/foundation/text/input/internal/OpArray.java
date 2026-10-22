package androidx.compose.foundation.text.input.internal;

import androidx.autofill.HintConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0083@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016Jo\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2K\u0010\u001b\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u001cH\u0086\b¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006&"}, d2 = {"Landroidx/compose/foundation/text/input/internal/OpArray;", "", "values", "", "constructor-impl", "([I)[I", "size", "", "(I)[I", "getSize-impl", "([I)I", "set", "", "index", "offset", "srcLen", "destLen", "set-impl", "([IIIII)V", "copyOf", "newSize", "copyOf-pSmdads", "([II)[I", "forEach", "max", "reversed", "", "block", "Lkotlin/Function3;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "forEach-impl", "([IIZLkotlin/jvm/functions/Function3;)V", "equals", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
final class OpArray {
    private final int[] values;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OpArray m1615boximpl(int[] r1) {
        return new OpArray(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int[] m1617constructorimpl(int[] r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1619equalsimpl(int[] r2, Object r3) {
        if ((r3 instanceof OpArray) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2, ((OpArray) r3).m1627unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1620equalsimpl0(int[] r0, int[] r1) {
        return Intrinsics.areEqual(r0, r1);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1624hashCodeimpl(int[] r0) {
        return Arrays.hashCode(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1626toStringimpl(int[] r2) {
        return "OpArray(values=" + Arrays.toString(r2) + ')';
    }

    public boolean equals(Object r2) {
        return m1619equalsimpl(this.values, r2);
    }

    public int hashCode() {
        return m1624hashCodeimpl(this.values);
    }

    public String toString() {
        return m1626toStringimpl(this.values);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m1627unboximpl() {
        return this.values;
    }

    private /* synthetic */ OpArray(int[] r1) {
        this.values = r1;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m1616constructorimpl(int r0) {
        return m1617constructorimpl(new int[r0 * 3]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static final int m1623getSizeimpl(int[] r0) {
        return r0.length / 3;
    }

    /* JADX INFO: renamed from: copyOf-pSmdads, reason: not valid java name */
    public static final int[] m1618copyOfpSmdads(int[] r0, int r1) {
        return m1617constructorimpl(Arrays.copyOf(r0, r1 * 3));
    }

    /* JADX INFO: renamed from: forEach-impl, reason: not valid java name */
    public static final void m1621forEachimpl(int[] r3, int r4, boolean r5, Function3<? super Integer, ? super Integer, ? super Integer, Unit> r6) {
        if (r4 >= 0) goto L4;
        return;
    L4:
        if (r5 == true) goto L6;
        int r7 = 0;
    L10:
        if (r7 >= r4) goto L12;
        int r0 = r7 * 3;
        r6.invoke(Integer.valueOf(r3[r0]), Integer.valueOf(r3[r0 + 1]), Integer.valueOf(r3[r0 + 2]));
        r7 = r7 + 1;
        goto L10
    L12:
        return;
    L6:
        r4 = r4 - 1;
        if ((-1) >= r4) goto L15;
        int r8 = r4 * 3;
        r6.invoke(Integer.valueOf(r3[r8]), Integer.valueOf(r3[r8 + 1]), Integer.valueOf(r3[r8 + 2]));
        goto L6
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m1625setimpl(int[] r0, int r1, int r2, int r3, int r4) {
        int r5 = r1 * 3;
        r0[r5] = r2;
        r0[r5 + 1] = r3;
        r0[r5 + 2] = r4;
    }

    /* JADX INFO: renamed from: forEach-impl$default, reason: not valid java name */
    public static /* synthetic */ void m1622forEachimpl$default(int[] r1, int r2, boolean r3, Function3 r4, int r5, Object r6) {
        int r7 = 0;
        if ((r5 & 2) == 0) goto L5;
        r3 = false;
    L5:
        if (r2 >= 0) goto L7;
        return;
    L7:
        if (r3 == true) goto L9;
    L12:
        if (r7 >= r2) goto L14;
        int r8 = r7 * 3;
        r4.invoke(Integer.valueOf(r1[r8]), Integer.valueOf(r1[r8 + 1]), Integer.valueOf(r1[r8 + 2]));
        r7 = r7 + 1;
        goto L12
    L14:
        return;
    L9:
        r2 = r2 - 1;
        if ((-1) >= r2) goto L17;
        int r9 = r2 * 3;
        r4.invoke(Integer.valueOf(r1[r9]), Integer.valueOf(r1[r9 + 1]), Integer.valueOf(r1[r9 + 2]));
        goto L9
    }
}
