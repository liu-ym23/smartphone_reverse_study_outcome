package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/animation/core/StartOffset;", "", "value", "", "constructor-impl", "(J)J", "offsetMillis", "", "offsetType", "Landroidx/compose/animation/core/StartOffsetType;", "(II)J", "getOffsetMillis-impl", "(J)I", "getOffsetType-Eo1U57Q", "equals", "", "other", "hashCode", "toString", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class StartOffset {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m279boximpl(long r1) {
        return new StartOffset(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m281constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m283equalsimpl(long r4, Object r6) {
        if ((r6 instanceof StartOffset) == true) goto L6;
        return false;
    L6:
        if (r4 == ((StartOffset) r6).m289unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m284equalsimpl0(long r1, long r3) {
        if (r1 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m287hashCodeimpl(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m288toStringimpl(long r2) {
        return "StartOffset(value=" + r2 + ')';
    }

    public boolean equals(Object r3) {
        return m283equalsimpl(this.value, r3);
    }

    public int hashCode() {
        return m287hashCodeimpl(this.value);
    }

    public String toString() {
        return m288toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m289unboximpl() {
        return this.value;
    }

    private /* synthetic */ StartOffset(long r1) {
        this.value = r1;
    }

    /* JADX INFO: renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m285getOffsetMillisimpl(long r0) {
        return Math.abs((int) r0);
    }

    /* JADX INFO: renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m286getOffsetTypeEo1U57Q(long r4) {
        if (r4 <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L13;
        if (r5 == true) goto L12;
        return StartOffsetType.Companion.m297getDelayEo1U57Q();
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        return StartOffsetType.Companion.m298getFastForwardEo1U57Q();
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m280constructorimpl(int r0, int r1) {
        return m281constructorimpl(r0 * r1);
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m282constructorimpl$default(int r0, int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = StartOffsetType.Companion.m297getDelayEo1U57Q();
    L6:
        return m280constructorimpl(r0, r1);
    }
}
