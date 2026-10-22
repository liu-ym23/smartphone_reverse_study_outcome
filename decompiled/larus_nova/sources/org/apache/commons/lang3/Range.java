package org.apache.commons.lang3;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.util.Comparator;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    public static final enum ComparableComparator extends Enum<ComparableComparator> implements Comparator {
        private static final /* synthetic */ ComparableComparator[] $VALUES = null;
        public static final ComparableComparator INSTANCE = null;

        static {
            ComparableComparator r100 = new ComparableComparator("INSTANCE", 0);
            INSTANCE = r100;
            $VALUES = new ComparableComparator[]{r100};
        }

        public static ComparableComparator[] values() {
            return (ComparableComparator[]) $VALUES.clone();
        }

        public static ComparableComparator valueOf(String r100) {
            return (ComparableComparator) a.a(ComparableComparator.class, r100);
        }

        private ComparableComparator(String r100, int r101) {
            super(r100, r101);
        }

        @Override // java.util.Comparator
        public int compare(Object r100, Object r101) {
            return ((Comparable) r100).compareTo(r101);
        }
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (((MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME + Range.class.hashCode()) * 37) + this.minimum.hashCode()) * 37;
        int r102 = this.maximum.hashCode() + r101;
        this.hashCode = r102;
        return r102;
    L6:
        return r100;
    }

    public boolean isNaturalOrdering() {
        if (this.comparator != ComparableComparator.INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        if (this.toString != null) goto L6;
        this.toString = "[" + this.minimum + DownloadConstants.VULNERABILITY_PATH + this.maximum + "]";
    L6:
        return this.toString;
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range is(Comparable r100) {
        return between(r100, r100, null);
    }

    public boolean contains(T r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.comparator.compare(r100, this.minimum) > (-1)) goto L8;
        return false;
    L8:
        if (this.comparator.compare(r100, this.maximum) >= 1) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean containsRange(Range<T> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (contains(r100.minimum) == true) goto L8;
        return false;
    L8:
        if (contains(r100.maximum) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int elementCompareTo(T r100) {
        Validate.notNull(r100, "Element is null", new Object[0]);
        if (isAfter(r100) == false) goto L7;
        return -1;
    L7:
        if (isBefore(r100) == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (r100.getClass() != Range.class) goto L17;
        Range r101 = (Range) r100;
        if (this.minimum.equals(r101.minimum) == true) goto L13;
    L15:
        return false;
    L13:
        if (this.maximum.equals(r101.maximum) == false) goto L15;
        return true;
    }

    public Range<T> intersectionWith(Range<T> r100) {
        if (isOverlappedBy(r100) == false) goto L18;
        if (equals(r100) == false) goto L8;
        return this;
    L8:
        if (getComparator().compare(this.minimum, r100.minimum) >= 0) goto L10;
        T r101 = r100.minimum;
    L12:
        if (getComparator().compare(this.maximum, r100.maximum) >= 0) goto L14;
        T r102 = this.maximum;
    L16:
        return between(r101, r102, getComparator());
    L14:
        r102 = r100.maximum;
        goto L16
    L10:
        r101 = this.minimum;
        goto L12
    L18:
        throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", new Object[]{r100}));
    }

    public boolean isAfter(T r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.comparator.compare(r100, this.minimum) >= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isAfterRange(Range<T> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return isAfter(r100.maximum);
    }

    public boolean isBefore(T r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.comparator.compare(r100, this.maximum) <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isBeforeRange(Range<T> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return isBefore(r100.minimum);
    }

    public boolean isEndedBy(T r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.comparator.compare(r100, this.maximum) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isOverlappedBy(Range<T> r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.contains(this.minimum) == false) goto L8;
    L11:
        return true;
    L8:
        if (r100.contains(this.maximum) == true) goto L11;
        if (contains(r100.minimum) == true) goto L11;
        return false;
    }

    public boolean isStartedBy(T r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.comparator.compare(r100, this.minimum) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString(String r100) {
        return String.format(r100, new Object[]{this.minimum, this.maximum, this.comparator});
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range between(Comparable r100, Comparable r101) {
        return between(r100, r101, null);
    }

    public static <T> Range<T> is(T r100, Comparator<T> r101) {
        return between(r100, r100, r101);
    }

    private Range(T r100, T r101, Comparator<T> r102) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        if (r102 != null) goto L7;
        this.comparator = ComparableComparator.INSTANCE;
    L9:
        if (this.comparator.compare(r100, r101) >= 1) goto L11;
        this.minimum = r100;
        this.maximum = r101;
        return;
    L11:
        this.minimum = r101;
        this.maximum = r100;
        return;
    L7:
        this.comparator = r102;
    L14:
        throw new IllegalArgumentException("Elements in a range must not be null: element1=" + r100 + ", element2=" + r101);
    }

    public static <T> Range<T> between(T r100, T r101, Comparator<T> r102) {
        return new Range(r100, r101, r102);
    }
}
