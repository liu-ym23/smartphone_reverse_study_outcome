package com.google.common.primitives;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
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
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Doubles extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f275634a = 0;

    public static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
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
            double r102 = this.array[r100];
            int r103 = Doubles.f275634a;
            r101 = (r101 * 31) + Double.valueOf(r102).hashCode();
            r100 = r100 + 1;
            goto L4
        L6:
            return r101;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r100 = new StringBuilder(size() * 12);
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

        public DoubleArrayAsList(double[] r100) {
            this(r100, 0, r100.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Double) == false) goto L14;
            double[] r101 = this.array;
            double r102 = ((Double) r100).doubleValue();
            int r103 = this.start;
            int r104 = this.end;
            int r105 = Doubles.f275634a;
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
            if ((r110 instanceof DoubleArrayAsList) == false) goto L18;
            DoubleArrayAsList r111 = (DoubleArrayAsList) r110;
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
        public Double get(int r100) {
            m.j(r100, size());
            return Double.valueOf(this.array[this.start + r100]);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Double) == false) goto L14;
            double[] r101 = this.array;
            double r102 = ((Double) r100).doubleValue();
            int r103 = this.start;
            int r104 = this.end;
            int r105 = Doubles.f275634a;
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
            if ((r100 instanceof Double) == false) goto L14;
            double[] r101 = this.array;
            double r102 = ((Double) r100).doubleValue();
            int r103 = this.start;
            int r104 = this.end;
            int r105 = Doubles.f275634a;
            int r106 = r104 - 1;
        L5:
            if (r106 < r103) goto L10;
            if (r101[r106] == r102) goto L11;
            r106 = r106 - 1;
        L11:
            if (r106 < 0) goto L14;
            return r106 - this.start;
        L10:
            r106 = -1;
        L14:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        public Double set(int r100, Double r101) {
            m.j(r100, size());
            double[] r102 = this.array;
            int r103 = this.start + r100;
            double r104 = r102[r103];
            r101.getClass();
            r102[r103] = r101.doubleValue();
            return Double.valueOf(r104);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int r100, int r101) {
            m.n(r100, r101, size());
            if (r100 == r101) goto L5;
            double[] r102 = this.array;
            int r103 = this.start;
            return new DoubleArrayAsList(r102, r100 + r103, r103 + r101);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r100, Object r101) {
            return set(r100, (Double) r101);
        }

        public DoubleArrayAsList(double[] r100, int r101, int r102) {
            this.array = r100;
            this.start = r101;
            this.end = r102;
        }
    }

    public static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Doubles.stringConverter()";
        }

        static {
            INSTANCE = new DoubleConverter();
        }

        private DoubleConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Double r100) {
            return doBackward2(r100);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Double doForward(String r100) {
            return doForward2(r100);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Double r100) {
            return r100.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Double doForward2(String r100) {
            return CastDoubleProtector.valueOf(r100);
        }
    }

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<double[]> {
        public static final LexicographicalComparator INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f275635a = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }

        static {
            LexicographicalComparator r100 = new LexicographicalComparator();
            INSTANCE = r100;
            f275635a = new LexicographicalComparator[]{r100};
        }

        public LexicographicalComparator() {
            super("INSTANCE", 0);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f275635a.clone();
        }

        public static LexicographicalComparator valueOf(String r100) {
            return (LexicographicalComparator) r27.a.a(LexicographicalComparator.class, r100);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(double[] r100, double[] r101) {
            int r102 = Math.min(r100.length, r101.length);
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            int r104 = Double.compare(r100[r103], r101[r103]);
            if (r104 != 0) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return r100.length - r101.length;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(double[] r100, double[] r101) {
            return compare2(r100, r101);
        }
    }

    public static boolean a(double r100) {
        if (Double.NEGATIVE_INFINITY < r100) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= Double.POSITIVE_INFINITY) goto L7;
        return true;
    }

    static {
        PatternProtector.compile("[+-]?(?:NaN|Infinity|(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?|0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?)".replace("#", Marker.ANY_NON_NULL_MARKER));
    }
}
