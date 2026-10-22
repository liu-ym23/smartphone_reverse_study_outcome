package kotlin.ranges;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001cB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001d\u0010\b\u001a\u00020\u00038VX\u0097\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "endExclusive", "getEndExclusive-s-VKNKU$annotations", "()V", "getEndExclusive-s-VKNKU", "()J", "getEndInclusive-s-VKNKU", "getStart-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ULongRange extends ULongProgression implements ClosedRange<ULong>, OpenEndRange<ULong> {
    public static final Companion Companion = null;
    private static final ULongRange EMPTY = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ULongRange getEMPTY() {
            return ULongRange.access$getEMPTY$cp();
        }
    }

    public /* synthetic */ ULongRange(long r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU$annotations, reason: not valid java name */
    public static /* synthetic */ void m10689getEndExclusivesVKNKU$annotations() {
    }

    static {
        Companion = new Companion(null);
        EMPTY = new ULongRange(-1, 0, null);
    }

    @Override // kotlin.ranges.ULongProgression
    public String toString() {
        return ULong.m9669toStringimpl(m10685getFirstsVKNKU()) + DownloadConstants.VULNERABILITY_PATH + ULong.m9669toStringimpl(m10686getLastsVKNKU());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return ULong.m9617boximpl(m10691getEndExclusivesVKNKU());
    }

    /* JADX INFO: renamed from: getEndExclusive-s-VKNKU, reason: not valid java name */
    public long m10691getEndExclusivesVKNKU() {
        if (m10686getLastsVKNKU() == (-1)) goto L7;
        return ULong.m9623constructorimpl(m10686getLastsVKNKU() + ULong.m9623constructorimpl(((long) 1) & BodyPartID.bodyIdMax));
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return ULong.m9617boximpl(m10692getEndInclusivesVKNKU());
    }

    /* JADX INFO: renamed from: getEndInclusive-s-VKNKU, reason: not valid java name */
    public long m10692getEndInclusivesVKNKU() {
        return m10686getLastsVKNKU();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return ULong.m9617boximpl(m10693getStartsVKNKU());
    }

    /* JADX INFO: renamed from: getStart-s-VKNKU, reason: not valid java name */
    public long m10693getStartsVKNKU() {
        return m10685getFirstsVKNKU();
    }

    @Override // kotlin.ranges.ULongProgression
    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r100 = ((int) ULong.m9623constructorimpl(m10685getFirstsVKNKU() ^ ULong.m9623constructorimpl(m10685getFirstsVKNKU() >>> 32))) * 31;
        return ((int) ULong.m9623constructorimpl(m10686getLastsVKNKU() ^ ULong.m9623constructorimpl(m10686getLastsVKNKU() >>> 32))) + r100;
    }

    @Override // kotlin.ranges.ULongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        long r100 = m10685getFirstsVKNKU();
        if (Long.compare(r100 ^ Long.MIN_VALUE, m10686getLastsVKNKU() ^ Long.MIN_VALUE) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ ULongRange access$getEMPTY$cp() {
        return EMPTY;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r100) {
        return m10690containsVKZWuLQ(((ULong) r100).m9675unboximpl());
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m10690containsVKZWuLQ(long r100) {
        long r101 = r100 ^ Long.MIN_VALUE;
        if (Long.compare(m10685getFirstsVKNKU() ^ Long.MIN_VALUE, r101) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Long.compare(r101, m10686getLastsVKNKU() ^ Long.MIN_VALUE) > 0) goto L7;
        return true;
    }

    @Override // kotlin.ranges.ULongProgression
    public boolean equals(Object r100) {
        if ((r100 instanceof ULongRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ULongRange r101 = (ULongRange) r100;
        if (m10685getFirstsVKNKU() != r101.m10685getFirstsVKNKU()) goto L13;
        if (m10686getLastsVKNKU() != r101.m10686getLastsVKNKU()) goto L13;
    L12:
        return true;
    L7:
        if (((ULongRange) r100).isEmpty() == true) goto L12;
        goto L8
    }

    private ULongRange(long r100, long r110) {
        super(r100, r110, 1, null);
    }
}
