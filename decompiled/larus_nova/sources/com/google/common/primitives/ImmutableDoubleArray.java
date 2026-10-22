package com.google.common.primitives;

import com.google.common.base.m;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
@Immutable
public final class ImmutableDoubleArray implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImmutableDoubleArray f275637b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f275638a;
    private final double[] array;
    private final int end;

    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object r100) {
            if (indexOf(r100) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof AsList) == false) goto L7;
            return this.parent.equals(((AsList) r100).parent);
        L7:
            if ((r100 instanceof List) == true) goto L9;
            return false;
        L9:
            List r101 = (List) r100;
            if (size() == r101.size()) goto L12;
            return false;
        L12:
            int r102 = ImmutableDoubleArray.access$100(this.parent);
            Iterator r103 = r101.iterator();
        L14:
            if (r103.hasNext() == false) goto L22;
            Object r104 = r103.next();
            if ((r104 instanceof Double) == false) goto L21;
            int r105 = r102 + 1;
            if (ImmutableDoubleArray.access$500(ImmutableDoubleArray.access$000(this.parent)[r102], ((Double) r104).doubleValue()) == false) goto L21;
            r102 = r105;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int r100) {
            return Double.valueOf(this.parent.get(r100));
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Double) r100).doubleValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Double) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Double) r100).doubleValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        public AsList(ImmutableDoubleArray r100, a r101) {
            this.parent = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int r100, int r101) {
            return this.parent.subArray(r100, r101).asList();
        }
    }

    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double[] f275639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275640b;

        public b(int r100) {
            this.f275640b = 0;
            this.f275639a = new double[r100];
        }

        public final void a(int r100) {
            int r101 = this.f275640b + r100;
            double[] r102 = this.f275639a;
            if (r101 <= r102.length) goto L14;
            int r103 = r102.length;
            if (r101 < 0) goto L13;
            int r104 = (r103 + (r103 >> 1)) + 1;
            if (r104 >= r101) goto L9;
            r104 = Integer.highestOneBit(r101 - 1) << 1;
        L9:
            if (r104 >= 0) goto L11;
            r104 = Integer.MAX_VALUE;
        L11:
            this.f275639a = Arrays.copyOf(r102, r104);
            return;
        L13:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    static {
        f275637b = new ImmutableDoubleArray(new double[0], 0, 0);
    }

    public static b builder() {
        return new b(10);
    }

    public List<Double> asList() {
        return new AsList(this, null);
    }

    public int hashCode() {
        int r100 = this.f275638a;
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

    public boolean isEmpty() {
        if (this.end != this.f275638a) goto L5;
        return true;
    L5:
        return false;
    }

    public int length() {
        return this.end - this.f275638a;
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.f275638a, this.end);
    }

    public ImmutableDoubleArray trimmed() {
        if (this.f275638a <= 0) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return new ImmutableDoubleArray(toArray());
    L12:
        return this;
    L5:
        if (this.end < this.array.length) goto L8;
        r100 = false;
        goto L9
    }

    public Object readResolve() {
        if (isEmpty() == false) goto L6;
        return f275637b;
    L6:
        return this;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "[]";
    L6:
        StringBuilder r100 = new StringBuilder(length() * 5);
        r100.append('[');
        r100.append(this.array[this.f275638a]);
        int r101 = this.f275638a;
    L7:
        r101 = r101 + 1;
        if (r101 >= this.end) goto L10;
        r100.append(", ");
        r100.append(this.array[r101]);
        goto L7
    L10:
        r100.append(']');
        return r100.toString();
    }

    public Object writeReplace() {
        return trimmed();
    }

    public static /* synthetic */ ImmutableDoubleArray access$200() {
        return f275637b;
    }

    public static ImmutableDoubleArray of() {
        return f275637b;
    }

    public ImmutableDoubleArray(double[] r100) {
        this(r100, 0, r100.length);
    }

    public static /* synthetic */ double[] access$000(ImmutableDoubleArray r100) {
        return r100.array;
    }

    public static /* synthetic */ int access$100(ImmutableDoubleArray r100) {
        return r100.f275638a;
    }

    public static b builder(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        m.d(r101, "Invalid initialCapacity: %s", r100);
        return new b(r100);
    L4:
        r101 = false;
        goto L5
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> r100) {
        boolean r101 = r100 instanceof Collection;
        if (r101 == true) goto L5;
        b r102 = builder();
        r102.getClass();
        if (r101 == false) goto L12;
        Collection r103 = (Collection) r100;
        r102.a(r103.size());
        Iterator r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        Double r105 = (Double) r104.next();
        double[] r106 = r102.f275639a;
        int r107 = r102.f275640b;
        r102.f275640b = r107 + 1;
        r106[r107] = r105.doubleValue();
    L16:
        int r108 = r102.f275640b;
        if (r108 == 0) goto L23;
        int r109 = 0;
        return new ImmutableDoubleArray(r102.f275639a, r109, r108, null);
    L23:
        return access$200();
    L12:
        Iterator<Double> r110 = r100.iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        double r111 = r110.next().doubleValue();
        r102.a(1);
        double[] r112 = r102.f275639a;
        int r113 = r102.f275640b;
        r112[r113] = r111;
        r102.f275640b = r113 + 1;
        goto L14
    L5:
        return copyOf((Collection) r100);
    }

    public static ImmutableDoubleArray of(double r100) {
        return new ImmutableDoubleArray(new double[]{r100}, 0, 1);
    }

    public boolean contains(double r100) {
        if (indexOf(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableDoubleArray) == true) goto L8;
        return false;
    L8:
        ImmutableDoubleArray r101 = (ImmutableDoubleArray) r100;
        if (length() == r101.length()) goto L11;
        return false;
    L11:
        int r102 = 0;
    L13:
        if (r102 >= length()) goto L18;
        if (a(get(r102), r101.get(r102)) == false) goto L16;
        r102 = r102 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public double get(int r100) {
        m.j(r100, length());
        return this.array[this.f275638a + r100];
    }

    public int indexOf(double r100) {
        int r101 = this.f275638a;
    L4:
        if (r101 >= this.end) goto L10;
        if (a(this.array[r101], r100) == true) goto L8;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101 - this.f275638a;
    L10:
        return -1;
    }

    public int lastIndexOf(double r100) {
        int r101 = this.end;
    L3:
        r101 = r101 - 1;
        if (r101 < this.f275638a) goto L10;
        if (a(this.array[r101], r100) == false) goto L3;
        return r101 - this.f275638a;
    L10:
        return -1;
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> r100) {
        if (r100.isEmpty() == true) goto L15;
        int r101 = Doubles.f275634a;
        if ((r100 instanceof Doubles.DoubleArrayAsList) == false) goto L8;
        double[] r102 = ((Doubles.DoubleArrayAsList) r100).toDoubleArray();
    L13:
        return new ImmutableDoubleArray(r102);
    L8:
        Object[] r103 = r100.toArray();
        int r104 = r103.length;
        double[] r105 = new double[r104];
        int r106 = 0;
    L9:
        if (r106 >= r104) goto L11;
        Object r107 = r103[r106];
        r107.getClass();
        r105[r106] = ((Number) r107).doubleValue();
        r106 = r106 + 1;
        goto L9
    L11:
        r102 = r105;
        goto L13
    L15:
        return f275637b;
    }

    public static ImmutableDoubleArray copyOf(double[] r100) {
        if (r100.length != 0) goto L6;
        return f275637b;
    L6:
        return new ImmutableDoubleArray(Arrays.copyOf(r100, r100.length));
    }

    public static boolean a(double r100, double r101) {
        if (Double.doubleToLongBits(r100) != Double.doubleToLongBits(r101)) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean access$500(double r100, double r101) {
        return a(r100, r101);
    }

    public static ImmutableDoubleArray of(double r100, double... r101) {
        if (r101.length > 2147483646) goto L5;
        boolean r102 = true;
    L6:
        m.c(r102, "the total number of elements must fit in an int");
        int r103 = r101.length + 1;
        double[] r104 = new double[r103];
        r104[0] = r100;
        System.arraycopy(r101, 0, r104, 1, r101.length);
        return new ImmutableDoubleArray(r104, 0, r103);
    L5:
        r102 = false;
        goto L6
    }

    public ImmutableDoubleArray subArray(int r100, int r101) {
        m.n(r100, r101, length());
        if (r100 == r101) goto L7;
        double[] r102 = this.array;
        int r103 = this.f275638a;
        return new ImmutableDoubleArray(r102, r100 + r103, r103 + r101);
    L7:
        return f275637b;
    }

    public static ImmutableDoubleArray of(double r100, double r101) {
        return new ImmutableDoubleArray(new double[]{r100, r101}, 0, 2);
    }

    public ImmutableDoubleArray(double[] r100, int r101, int r102) {
        this.array = r100;
        this.f275638a = r101;
        this.end = r102;
    }

    public static ImmutableDoubleArray of(double r100, double r101, double r102) {
        return new ImmutableDoubleArray(new double[]{r100, r101, r102}, 0, 3);
    }

    public /* synthetic */ ImmutableDoubleArray(double[] r100, int r101, int r102, a r103) {
        this(r100, r101, r102);
    }

    public static ImmutableDoubleArray of(double r100, double r101, double r102, double r110) {
        return new ImmutableDoubleArray(new double[]{r100, r101, r102, r110}, 0, 4);
    }

    public static ImmutableDoubleArray of(double r100, double r101, double r102, double r110, double r111) {
        return new ImmutableDoubleArray(new double[]{r100, r101, r102, r110, r111}, 0, 5);
    }

    public static ImmutableDoubleArray of(double r100, double r101, double r102, double r110, double r111, double r112) {
        return new ImmutableDoubleArray(new double[]{r100, r101, r102, r110, r111, r112}, 0, 6);
    }
}
