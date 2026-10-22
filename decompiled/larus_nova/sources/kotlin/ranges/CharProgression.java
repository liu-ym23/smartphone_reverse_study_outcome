package kotlin.ranges;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/CharProgression;", "", "", "start", "endInclusive", "step", "", "(CCI)V", SoloKtvContext.SOLO_PAGE_FIRST, "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CharProgression implements Iterable<Character>, KMappedMarker {
    public static final Companion Companion = null;
    private final char first;
    private final char last;
    private final int step;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", "", "rangeEnd", "step", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CharProgression fromClosedRange(char r100, char r101, int r102) {
            return new CharProgression(r100, r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public boolean isEmpty() {
        if (this.step <= 0) goto L8;
        if (Intrinsics.compare(this.first, this.last) > 0) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (Intrinsics.compare(this.first, this.last) >= 0) goto L10;
        return true;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Character> iterator2() {
        return new CharProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.first);
        r100.append(DownloadConstants.VULNERABILITY_PATH);
        r100.append(this.last);
        r100.append(" step ");
        int r101 = this.step;
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
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public final char getFirst() {
        return this.first;
    }

    public final char getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Character> iterator() {
        return iterator2();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CharProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        CharProgression r101 = (CharProgression) r100;
        if (this.first != r101.first) goto L15;
        if (this.last != r101.last) goto L15;
        if (this.step != r101.step) goto L15;
    L14:
        return true;
    L7:
        if (((CharProgression) r100).isEmpty() == true) goto L14;
        goto L8
    }

    public CharProgression(char r100, char r101, int r102) {
        if (r102 == 0) goto L11;
        if (r102 == Integer.MIN_VALUE) goto L9;
        this.first = r100;
        this.last = (char) ProgressionUtilKt.getProgressionLastElement(r100, r101, r102);
        this.step = r102;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }
}
