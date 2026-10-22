package kotlin.ranges;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0086\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", SoloKtvContext.SOLO_PAGE_FIRST, "getFirst-s-VKNKU", "()J", "J", "last", "getLast-s-VKNKU", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    public static final Companion Companion = null;
    private final long first;
    private final long last;
    private final long step;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: fromClosedRange-7ftBX0g, reason: not valid java name */
        public final ULongProgression m10687fromClosedRange7ftBX0g(long r110, long r111, long r112) {
            return new ULongProgression(r110, r111, r112, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ULongProgression(long r100, long r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public boolean isEmpty() {
        long r100 = this.step;
        long r101 = this.first;
        int r102 = Long.compare(r101 ^ Long.MIN_VALUE, this.last ^ Long.MIN_VALUE);
        if (r100 <= 0) goto L6;
        if (r102 > 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L6:
        if (r102 >= 0) goto L8;
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r100 = new StringBuilder();
        r100.append(ULong.m9669toStringimpl(this.first));
        r100.append(DownloadConstants.VULNERABILITY_PATH);
        r100.append(ULong.m9669toStringimpl(this.last));
        r100.append(" step ");
        long r101 = this.step;
    L6:
        r100.append(r101);
        return r100.toString();
    L5:
        r100 = new StringBuilder();
        r100.append(ULong.m9669toStringimpl(this.first));
        r100.append(" downTo ");
        r100.append(ULong.m9669toStringimpl(this.last));
        r100.append(" step ");
        r101 = -this.step;
        goto L6
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r100 = this.first;
        int r101 = ((int) ULong.m9623constructorimpl(r100 ^ ULong.m9623constructorimpl(r100 >>> 32))) * 31;
        long r102 = this.last;
        int r103 = (r101 + ((int) ULong.m9623constructorimpl(r102 ^ ULong.m9623constructorimpl(r102 >>> 32)))) * 31;
        long r104 = this.step;
        return ((int) (r104 ^ (r104 >>> 32))) + r103;
    }

    /* JADX INFO: renamed from: getFirst-s-VKNKU, reason: not valid java name */
    public final long m10685getFirstsVKNKU() {
        return this.first;
    }

    /* JADX INFO: renamed from: getLast-s-VKNKU, reason: not valid java name */
    public final long m10686getLastsVKNKU() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ULongProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ULongProgression r101 = (ULongProgression) r100;
        if (this.first != r101.first) goto L15;
        if (this.last != r101.last) goto L15;
        if (this.step != r101.step) goto L15;
    L14:
        return true;
    L7:
        if (((ULongProgression) r100).isEmpty() == true) goto L14;
        goto L8
    }

    private ULongProgression(long r100, long r101, long r102) {
        if (r102 == 0) goto L11;
        if (r102 == Long.MIN_VALUE) goto L9;
        this.first = r100;
        this.last = UProgressionUtilKt.m10661getProgressionLastElement7ftBX0g(r100, r101, r102);
        this.step = r102;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }
}
