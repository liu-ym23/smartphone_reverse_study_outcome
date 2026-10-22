package com.google.common.primitives;

import androidx.collection.SieveCacheKt;
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
public final class Ints extends b {

    public static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
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
            r101 = (r101 * 31) + this.array[r100];
            r100 = r100 + 1;
            goto L4
        L6:
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r100 = new StringBuilder(size() * 5);
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

        public IntArrayAsList(int[] r100) {
            this(r100, 0, r100.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Integer) == false) goto L14;
            int[] r101 = this.array;
            int r102 = ((Integer) r100).intValue();
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
        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof IntArrayAsList) == false) goto L18;
            IntArrayAsList r101 = (IntArrayAsList) r100;
            int r102 = size();
            if (r101.size() == r102) goto L10;
            return false;
        L10:
            int r103 = 0;
        L11:
            if (r103 >= r102) goto L16;
            if (this.array[this.start + r103] != r101.array[r101.start + r103]) goto L14;
            r103 = r103 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int r100) {
            m.j(r100, size());
            return Integer.valueOf(this.array[this.start + r100]);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Integer) == false) goto L14;
            int[] r101 = this.array;
            int r102 = ((Integer) r100).intValue();
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
            if ((r100 instanceof Integer) == false) goto L14;
            int[] r101 = this.array;
            int r102 = ((Integer) r100).intValue();
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

        public Integer set(int r100, Integer r101) {
            m.j(r100, size());
            int[] r102 = this.array;
            int r103 = this.start + r100;
            int r104 = r102[r103];
            r101.getClass();
            r102[r103] = r101.intValue();
            return Integer.valueOf(r104);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int r100, int r101) {
            m.n(r100, r101, size());
            if (r100 == r101) goto L5;
            int[] r102 = this.array;
            int r103 = this.start;
            return new IntArrayAsList(r102, r100 + r103, r103 + r101);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
            return set(r100, (Integer) r101);
        }

        public IntArrayAsList(int[] r100, int r101, int r102) {
            this.array = r100;
            this.start = r101;
            this.end = r102;
        }
    }

    public static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Ints.stringConverter()";
        }

        static {
            INSTANCE = new IntConverter();
        }

        private IntConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Integer r100) {
            return doBackward2(r100);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Integer doForward(String r100) {
            return doForward2(r100);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Integer r100) {
            return r100.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Integer doForward2(String r100) {
            return Integer.decode(r100);
        }
    }

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<int[]> {
        public static final LexicographicalComparator INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f275649a = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        static {
            LexicographicalComparator r100 = new LexicographicalComparator();
            INSTANCE = r100;
            f275649a = new LexicographicalComparator[]{r100};
        }

        public LexicographicalComparator() {
            super("INSTANCE", 0);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f275649a.clone();
        }

        public static LexicographicalComparator valueOf(String r100) {
            return (LexicographicalComparator) r27.a.a(LexicographicalComparator.class, r100);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r100, int[] r101) {
            int r102 = Math.min(r100.length, r101.length);
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            int r104 = r100[r103];
            int r105 = r101[r103];
            if (r104 >= r105) goto L7;
            int r106 = -1;
        L10:
            if (r106 != 0) goto L11;
            r103 = r103 + 1;
            goto L3
        L11:
            return r106;
        L7:
            if (r104 <= r105) goto L9;
            r106 = 1;
            goto L10
        L9:
            r106 = 0;
            goto L10
        L14:
            return r100.length - r101.length;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(int[] r100, int[] r101) {
            return compare2(r100, r101);
        }
    }

    public static int c(long r100) {
        if (r100 <= SieveCacheKt.NodeLinkMask) goto L7;
        return Integer.MAX_VALUE;
    L7:
        if (r100 >= SieveCacheKt.NodeMetaAndPreviousMask) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r100;
    }

    public static List<Integer> a(int... r100) {
        if (r100.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new IntArrayAsList(r100);
    }

    public static int b(int r100, int r101) {
        if (r101 > 1073741823) goto L5;
        boolean r102 = true;
    L6:
        m.e(r102, "min (%s) must be less than or equal to max (%s)", r101, 1073741823);
        return Math.min(Math.max(r100, r101), 1073741823);
    L5:
        r102 = false;
        goto L6
    }
}
