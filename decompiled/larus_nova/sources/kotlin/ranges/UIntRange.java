package kotlin.ranges;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001d\u0010\b\u001a\u00020\u00038VX\u0097\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-pVg5ArA$annotations", "()V", "getEndExclusive-pVg5ArA", "()I", "getEndInclusive-pVg5ArA", "getStart-pVg5ArA", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    public static final Companion Companion = null;
    private static final UIntRange EMPTY = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final UIntRange getEMPTY() {
            return UIntRange.access$getEMPTY$cp();
        }
    }

    public /* synthetic */ UIntRange(int r100, int r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA$annotations, reason: not valid java name */
    public static /* synthetic */ void m10680getEndExclusivepVg5ArA$annotations() {
    }

    static {
        DefaultConstructorMarker r100 = null;
        Companion = new Companion(r100);
        EMPTY = new UIntRange(-1, 0, r100);
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return UInt.m9590toStringimpl(m10676getFirstpVg5ArA()) + DownloadConstants.VULNERABILITY_PATH + UInt.m9590toStringimpl(m10677getLastpVg5ArA());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return UInt.m9538boximpl(m10682getEndExclusivepVg5ArA());
    }

    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA, reason: not valid java name */
    public int m10682getEndExclusivepVg5ArA() {
        if (m10677getLastpVg5ArA() == (-1)) goto L7;
        return UInt.m9544constructorimpl(m10677getLastpVg5ArA() + 1);
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return UInt.m9538boximpl(m10683getEndInclusivepVg5ArA());
    }

    /* JADX INFO: renamed from: getEndInclusive-pVg5ArA, reason: not valid java name */
    public int m10683getEndInclusivepVg5ArA() {
        return m10677getLastpVg5ArA();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return UInt.m9538boximpl(m10684getStartpVg5ArA());
    }

    /* JADX INFO: renamed from: getStart-pVg5ArA, reason: not valid java name */
    public int m10684getStartpVg5ArA() {
        return m10676getFirstpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (m10676getFirstpVg5ArA() * 31) + m10677getLastpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        int r100 = m10676getFirstpVg5ArA();
        if (Integer.compare(r100 ^ Integer.MIN_VALUE, m10677getLastpVg5ArA() ^ Integer.MIN_VALUE) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ UIntRange access$getEMPTY$cp() {
        return EMPTY;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r100) {
        return m10681containsWZ4Q5Ns(((UInt) r100).m9596unboximpl());
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m10681containsWZ4Q5Ns(int r100) {
        int r101 = r100 ^ Integer.MIN_VALUE;
        if (Integer.compare(m10676getFirstpVg5ArA() ^ Integer.MIN_VALUE, r101) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Integer.compare(r101, m10677getLastpVg5ArA() ^ Integer.MIN_VALUE) > 0) goto L7;
        return true;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object r100) {
        if ((r100 instanceof UIntRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        UIntRange r101 = (UIntRange) r100;
        if (m10676getFirstpVg5ArA() != r101.m10676getFirstpVg5ArA()) goto L13;
        if (m10677getLastpVg5ArA() != r101.m10677getLastpVg5ArA()) goto L13;
    L12:
        return true;
    L7:
        if (((UIntRange) r100).isEmpty() == true) goto L12;
        goto L8
    }

    private UIntRange(int r100, int r101) {
        super(r100, r101, 1, null);
    }
}
