package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0010\u0010\r\u001a\u00020\u0007H\u0086\n¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u0007H\u0086\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\u0088\u0001\u0002¨\u0006\u0019"}, d2 = {"Landroidx/collection/IntIntPair;", "", "packedValue", "", "constructor-impl", "(J)J", "first", "", "second", "(II)J", "getFirst-impl", "(J)I", "getSecond-impl", "component1", "component1-impl", "component2", "component2-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class IntIntPair {
    public final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m93boximpl(long r1) {
        return new IntIntPair(r1);
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m94component1impl(long r1) {
        return (int) (r1 >> 32);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m95component2impl(long r2) {
        return (int) (r2 & 4294967295L);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m97constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m98equalsimpl(long r4, Object r6) {
        if ((r6 instanceof IntIntPair) == true) goto L6;
        return false;
    L6:
        if (r4 == ((IntIntPair) r6).m104unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m99equalsimpl0(long r1, long r3) {
        if (r1 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getFirst-impl, reason: not valid java name */
    public static final int m100getFirstimpl(long r1) {
        return (int) (r1 >> 32);
    }

    /* JADX INFO: renamed from: getSecond-impl, reason: not valid java name */
    public static final int m101getSecondimpl(long r2) {
        return (int) (r2 & 4294967295L);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m102hashCodeimpl(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    public boolean equals(Object r3) {
        return m98equalsimpl(this.packedValue, r3);
    }

    public int hashCode() {
        return m102hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m104unboximpl() {
        return this.packedValue;
    }

    public String toString() {
        return m103toStringimpl(this.packedValue);
    }

    private /* synthetic */ IntIntPair(long r1) {
        this.packedValue = r1;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m103toStringimpl(long r2) {
        return "(" + m100getFirstimpl(r2) + ", " + m101getSecondimpl(r2) + ')';
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m96constructorimpl(int r4, int r5) {
        long r0 = ((long) r4) << 32;
        return m97constructorimpl((((long) r5) & 4294967295L) | r0);
    }
}
