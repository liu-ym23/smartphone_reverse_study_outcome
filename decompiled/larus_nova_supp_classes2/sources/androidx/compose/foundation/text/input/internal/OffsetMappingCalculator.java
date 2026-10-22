package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "", "<init>", "()V", "ops", "Landroidx/compose/foundation/text/input/internal/OpArray;", "[I", "opsSize", "", "recordEditOperation", "", "sourceStart", "sourceEnd", "newLength", "mapFromSource", "Landroidx/compose/ui/text/TextRange;", "offset", "mapFromSource--jx7JFs", "(I)J", "mapFromDest", "mapFromDest--jx7JFs", "map", "fromSource", "", "map-fzxv0v0", "(IZ)J", "mapStep", "opOffset", "untransformedLen", "transformedLen", "mapStep-C6u-MEY", "(IIIIZ)J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OffsetMappingCalculator {
    public static final int $stable = 8;
    private int[] ops;
    private int opsSize;

    public OffsetMappingCalculator() {
        this.ops = OpArray.m1616constructorimpl(10);
    }

    /* JADX INFO: renamed from: mapFromDest--jx7JFs, reason: not valid java name */
    public final long m1613mapFromDestjx7JFs(int r3) {
        return m1611mapfzxv0v0(r3, false);
    }

    /* JADX INFO: renamed from: mapFromSource--jx7JFs, reason: not valid java name */
    public final long m1614mapFromSourcejx7JFs(int r3) {
        return m1611mapfzxv0v0(r3, true);
    }

    /* JADX INFO: renamed from: map-fzxv0v0, reason: not valid java name */
    private final long m1611mapfzxv0v0(int r13, boolean r14) {
        int[] r0 = this.ops;
        int r1 = this.opsSize;
        boolean r2 = !r14;
        if (r1 < 0) goto L14;
        if (r2 == false) goto L10;
        int r3 = r1 - 1;
        int r4 = r13;
    L7:
        if ((-1) >= r3) goto L9;
        int r5 = r3 * 3;
        int r8 = r0[r5];
        int r9 = r0[r5 + 1];
        int r10 = r0[r5 + 2];
        long r6 = m1612mapStepC6uMEY(r4, r8, r9, r10, r14);
        long r7 = m1612mapStepC6uMEY(r13, r8, r9, r10, r14);
        int r15 = Math.min(TextRange.getStart-impl(r6), TextRange.getStart-impl(r7));
        r3 = r3 - 1;
        r4 = r15;
        r13 = Math.max(TextRange.getEnd-impl(r6), TextRange.getEnd-impl(r7));
        goto L7
    L9:
        int r16 = r13;
        r13 = r4;
    L16:
        return TextRangeKt.TextRange(r13, r16);
    L10:
        int r11 = 0;
        int r12 = r13;
    L11:
        if (r11 >= r1) goto L13;
        int r17 = r11 * 3;
        int r18 = r0[r17];
        int r19 = r0[r17 + 1];
        int r110 = r0[r17 + 2];
        long r20 = m1612mapStepC6uMEY(r12, r18, r19, r110, r14);
        long r21 = m1612mapStepC6uMEY(r13, r18, r19, r110, r14);
        int r111 = Math.min(TextRange.getStart-impl(r20), TextRange.getStart-impl(r21));
        r11 = r11 + 1;
        r12 = r111;
        r13 = Math.max(TextRange.getEnd-impl(r20), TextRange.getEnd-impl(r21));
        goto L11
    L13:
        r16 = r13;
        r13 = r12;
        goto L16
    L14:
        r16 = r13;
        goto L16
    }

    public final void recordEditOperation(int r5, int r6, int r7) {
        if (r7 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Expected newLen to be ≥ 0, was " + r7);
    L8:
        int r8 = Math.min(r5, r6);
        int r9 = Math.max(r8, r6) - r8;
        if (r9 >= 2) goto L12;
        if (r9 != r7) goto L12;
        return;
    L12:
        int r2 = this.opsSize + 1;
        if (r2 <= OpArray.m1623getSizeimpl(this.ops)) goto L15;
        this.ops = OpArray.m1618copyOfpSmdads(this.ops, Math.max(r2 * 2, OpArray.m1623getSizeimpl(this.ops) * 2));
    L15:
        OpArray.m1625setimpl(this.ops, this.opsSize, r8, r9, r7);
        this.opsSize = r2;
        return;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: mapStep-C6u-MEY, reason: not valid java name */
    private final long m1612mapStepC6uMEY(int r2, int r3, int r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        int r0 = r4;
    L5:
        if (r6 == false) goto L7;
        r4 = r5;
    L7:
        if (r2 < r3) goto L20;
        if (r2 != r3) goto L14;
        if (r0 != 0) goto L22;
        return TextRangeKt.TextRange(r3, r4 + r3);
    L22:
        return TextRangeKt.TextRange(r3);
    L14:
        if (r2 >= (r3 + r0)) goto L19;
        if (r4 != 0) goto L24;
        return TextRangeKt.TextRange(r3);
    L24:
        return TextRangeKt.TextRange(r3, r4 + r3);
    L19:
        return TextRangeKt.TextRange((r2 - r0) + r4);
    L20:
        return TextRangeKt.TextRange(r2);
    L4:
        r0 = r5;
        goto L5
    }
}
