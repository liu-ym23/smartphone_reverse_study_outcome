package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.m;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Longs {

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
        public static final LexicographicalComparator INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f275650a = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }

        static {
            LexicographicalComparator r100 = new LexicographicalComparator();
            INSTANCE = r100;
            f275650a = new LexicographicalComparator[]{r100};
        }

        public LexicographicalComparator() {
            super("INSTANCE", 0);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f275650a.clone();
        }

        public static LexicographicalComparator valueOf(String r100) {
            return (LexicographicalComparator) r27.a.a(LexicographicalComparator.class, r100);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r100, long[] r110) {
            int r101 = Math.min(r100.length, r110.length);
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L14;
            long r103 = r100[r102];
            long r104 = r110[r102];
            if (r103 >= r104) goto L7;
            int r105 = -1;
        L10:
            if (r105 != 0) goto L11;
            r102 = r102 + 1;
            goto L3
        L11:
            return r105;
        L7:
            if (r103 <= r104) goto L9;
            r105 = 1;
            goto L10
        L9:
            r105 = 0;
            goto L10
        L14:
            return r100.length - r110.length;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(long[] r100, long[] r101) {
            return compare2(r100, r101);
        }
    }

    public static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r100 = this.start;
            int r101 = 1;
        L4:
            if (r100 >= this.end) goto L6;
            long r102 = this.array[r100];
            r101 = (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
            r100 = r100 + 1;
            goto L4
        L6:
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        public long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r100 = new StringBuilder(size() * 10);
            r100.append('[');
            r100.append(this.array[this.start]);
            int r101 = this.start;
        L3:
            r101 = r101 + 1;
            if (r101 >= this.end) goto L6;
            r100.append(", ");
            r100.append(this.array[r101]);
            goto L3
        L6:
            r100.append(']');
            return r100.toString();
        }

        public LongArrayAsList(long[] r100) {
            this(r100, 0, r100.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Long) == false) goto L14;
            long[] r101 = this.array;
            long r102 = ((Long) r100).longValue();
            int r103 = this.start;
            int r104 = this.end;
        L6:
            if (r103 >= r104) goto L11;
            if (r101[r103] == r102) goto L12;
            r103 = r103 + 1;
        L12:
            if (r103 == (-1)) goto L14;
            return true;
        L11:
            r103 = -1;
        L14:
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object r110) {
            if (r110 != this) goto L6;
            return true;
        L6:
            if ((r110 instanceof LongArrayAsList) == false) goto L18;
            LongArrayAsList r111 = (LongArrayAsList) r110;
            int r100 = size();
            if (r111.size() == r100) goto L10;
            return false;
        L10:
            int r101 = 0;
        L11:
            if (r101 >= r100) goto L16;
            if (this.array[this.start + r101] != r111.array[r111.start + r101]) goto L14;
            r101 = r101 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r110);
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int r100) {
            m.j(r100, size());
            return Long.valueOf(this.array[this.start + r100]);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Long) == false) goto L14;
            long[] r101 = this.array;
            long r102 = ((Long) r100).longValue();
            int r103 = this.start;
            int r104 = this.end;
        L5:
            if (r103 >= r104) goto L10;
            if (r101[r103] == r102) goto L11;
            r103 = r103 + 1;
        L11:
            if (r103 < 0) goto L14;
            return r103 - this.start;
        L10:
            r103 = -1;
        L14:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Long) == false) goto L14;
            long[] r101 = this.array;
            long r102 = ((Long) r100).longValue();
            int r103 = this.start;
            int r104 = this.end - 1;
        L5:
            if (r104 < r103) goto L10;
            if (r101[r104] == r102) goto L11;
            r104 = r104 - 1;
        L11:
            if (r104 < 0) goto L14;
            return r104 - this.start;
        L10:
            r104 = -1;
        L14:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        public Long set(int r100, Long r101) {
            m.j(r100, size());
            long[] r102 = this.array;
            int r103 = this.start + r100;
            long r104 = r102[r103];
            r101.getClass();
            r102[r103] = r101.longValue();
            return Long.valueOf(r104);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int r100, int r101) {
            m.n(r100, r101, size());
            if (r100 == r101) goto L5;
            long[] r102 = this.array;
            int r103 = this.start;
            return new LongArrayAsList(r102, r100 + r103, r103 + r101);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
            return set(r100, (Long) r101);
        }

        public LongArrayAsList(long[] r100, int r101, int r102) {
            this.array = r100;
            this.start = r101;
            this.end = r102;
        }
    }

    public static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Longs.stringConverter()";
        }

        static {
            INSTANCE = new LongConverter();
        }

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Long r100) {
            return doBackward2(r100);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Long doForward(String r100) {
            return doForward2(r100);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Long r100) {
            return r100.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Long doForward2(String r100) {
            return Long.decode(r100);
        }
    }

    public static long a(byte r100, byte r101, byte r102, byte r103, byte r104, byte r110, byte r111, byte r112) {
        long r105 = (((long) r100) & 255) << 56;
        return ((((((((((long) r101) & 255) << 48) | r105) | ((((long) r102) & 255) << 40)) | ((((long) r103) & 255) << 32)) | ((((long) r104) & 255) << 24)) | ((((long) r110) & 255) << 16)) | ((((long) r111) & 255) << 8)) | (((long) r112) & 255);
    }
}
