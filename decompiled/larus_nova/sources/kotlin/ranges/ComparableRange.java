package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lkotlin/ranges/ComparableRange;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndInclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    private final T endInclusive;
    private final T start;

    public String toString() {
        return getStart() + DownloadConstants.VULNERABILITY_PATH + getEndInclusive();
    }

    public int hashCode() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.ranges.ClosedRange
    public T getEndInclusive() {
        return this.endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    public T getStart() {
        return this.start;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean contains(T r100) {
        return ClosedRange.DefaultImpls.contains(this, r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ComparableRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ComparableRange r101 = (ComparableRange) r100;
        if (Intrinsics.areEqual(getStart(), r101.getStart()) == false) goto L13;
        if (Intrinsics.areEqual(getEndInclusive(), r101.getEndInclusive()) == false) goto L13;
    L12:
        return true;
    L7:
        if (((ComparableRange) r100).isEmpty() == true) goto L12;
        goto L8
    }

    public ComparableRange(T r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "start");
        Intrinsics.checkNotNullParameter(r101, "endInclusive");
        this.start = r100;
        this.endInclusive = r101;
    }
}
