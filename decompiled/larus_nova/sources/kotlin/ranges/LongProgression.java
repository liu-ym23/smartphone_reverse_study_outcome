package kotlin.ranges;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/LongProgression;", "", "", "start", "endInclusive", "step", "(JJJ)V", SoloKtvContext.SOLO_PAGE_FIRST, "getFirst", "()J", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "", "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LongProgression implements Iterable<Long>, KMappedMarker {
    public static final Companion Companion = null;
    private final long first;
    private final long last;
    private final long step;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LongProgression fromClosedRange(long r100, long r110, long r111) {
            return new LongProgression(r100, r110, r111);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public boolean isEmpty() {
        long r100 = this.step;
        long r101 = this.first;
        long r102 = this.last;
        if (r100 <= 0) goto L8;
        if (r101 > r102) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (r101 >= r102) goto L10;
        return true;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Long> iterator2() {
        return new LongProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.first);
        r100.append(DownloadConstants.VULNERABILITY_PATH);
        r100.append(this.last);
        r100.append(" step ");
        long r101 = this.step;
    L6:
        r100.append(r101);
        return r100.toString();
    L5:
        r100 = new StringBuilder();
        r100.append(this.first);
        r100.append(" downTo ");
        r100.append(this.last);
        r100.append(" step ");
        r101 = -this.step;
        goto L6
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r100 = 31;
        long r101 = this.first;
        long r102 = this.last;
        long r103 = r100 * (((r101 ^ (r101 >>> 32)) * r100) + (r102 ^ (r102 >>> 32)));
        long r104 = this.step;
        return (int) (r103 + (r104 ^ (r104 >>> 32)));
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Long> iterator() {
        return iterator2();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof LongProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        LongProgression r101 = (LongProgression) r100;
        if (this.first != r101.first) goto L15;
        if (this.last != r101.last) goto L15;
        if (this.step != r101.step) goto L15;
    L14:
        return true;
    L7:
        if (((LongProgression) r100).isEmpty() == true) goto L14;
        goto L8
    }

    public LongProgression(long r100, long r101, long r102) {
        if (r102 == 0) goto L11;
        if (r102 == Long.MIN_VALUE) goto L9;
        this.first = r100;
        this.last = ProgressionUtilKt.getProgressionLastElement(r100, r101, r102);
        this.step = r102;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }
}
