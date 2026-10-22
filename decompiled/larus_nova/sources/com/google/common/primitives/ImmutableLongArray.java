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
public final class ImmutableLongArray implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImmutableLongArray f275645b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f275646a;
    private final long[] array;
    private final int end;

    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

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
            int r102 = ImmutableLongArray.access$100(this.parent);
            Iterator r103 = r101.iterator();
        L14:
            if (r103.hasNext() == false) goto L22;
            Object r104 = r103.next();
            if ((r104 instanceof Long) == false) goto L21;
            int r105 = r102 + 1;
            if (ImmutableLongArray.access$000(this.parent)[r102] != ((Long) r104).longValue()) goto L21;
            r102 = r105;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int r100) {
            return Long.valueOf(this.parent.get(r100));
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Long) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Long) r100).longValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object r100) {
            if ((r100 instanceof Long) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Long) r100).longValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }

        public AsList(ImmutableLongArray r100, a r101) {
            this.parent = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int r100, int r101) {
            return this.parent.subArray(r100, r101).asList();
        }
    }

    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long[] f275647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275648b;

        public b(int r100) {
            this.f275648b = 0;
            this.f275647a = new long[r100];
        }

        public final void a(int r100) {
            int r101 = this.f275648b + r100;
            long[] r102 = this.f275647a;
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
            this.f275647a = Arrays.copyOf(r102, r104);
            return;
        L13:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    static {
        f275645b = new ImmutableLongArray(new long[0], 0, 0);
    }

    public static b builder() {
        return new b(10);
    }

    public List<Long> asList() {
        return new AsList(this, null);
    }

    public int hashCode() {
        int r100 = this.f275646a;
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

    public boolean isEmpty() {
        if (this.end != this.f275646a) goto L5;
        return true;
    L5:
        return false;
    }

    public int length() {
        return this.end - this.f275646a;
    }

    public long[] toArray() {
        return Arrays.copyOfRange(this.array, this.f275646a, this.end);
    }

    public ImmutableLongArray trimmed() {
        if (this.f275646a <= 0) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return new ImmutableLongArray(toArray());
    L12:
        return this;
    L5:
        if (this.end < this.array.length) goto L8;
        r100 = false;
        goto L9
    }

    public Object readResolve() {
        if (isEmpty() == false) goto L6;
        return f275645b;
    L6:
        return this;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "[]";
    L6:
        StringBuilder r100 = new StringBuilder(length() * 5);
        r100.append('[');
        r100.append(this.array[this.f275646a]);
        int r101 = this.f275646a;
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

    public static /* synthetic */ ImmutableLongArray access$200() {
        return f275645b;
    }

    public static ImmutableLongArray of() {
        return f275645b;
    }

    public ImmutableLongArray(long[] r100) {
        this(r100, 0, r100.length);
    }

    public static /* synthetic */ long[] access$000(ImmutableLongArray r100) {
        return r100.array;
    }

    public static /* synthetic */ int access$100(ImmutableLongArray r100) {
        return r100.f275646a;
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

    public static ImmutableLongArray copyOf(Iterable<Long> r100) {
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
        Long r105 = (Long) r104.next();
        long[] r106 = r102.f275647a;
        int r107 = r102.f275648b;
        r102.f275648b = r107 + 1;
        r106[r107] = r105.longValue();
    L16:
        int r108 = r102.f275648b;
        if (r108 == 0) goto L23;
        int r109 = 0;
        return new ImmutableLongArray(r102.f275647a, r109, r108, null);
    L23:
        return access$200();
    L12:
        Iterator<Long> r110 = r100.iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        long r111 = r110.next().longValue();
        r102.a(1);
        long[] r112 = r102.f275647a;
        int r113 = r102.f275648b;
        r112[r113] = r111;
        r102.f275648b = r113 + 1;
        goto L14
    L5:
        return copyOf((Collection) r100);
    }

    public static ImmutableLongArray of(long r100) {
        return new ImmutableLongArray(new long[]{r100}, 0, 1);
    }

    public boolean contains(long r100) {
        if (indexOf(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableLongArray) == true) goto L8;
        return false;
    L8:
        ImmutableLongArray r101 = (ImmutableLongArray) r100;
        if (length() == r101.length()) goto L11;
        return false;
    L11:
        int r102 = 0;
    L13:
        if (r102 >= length()) goto L18;
        if (get(r102) != r101.get(r102)) goto L16;
        r102 = r102 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public long get(int r100) {
        m.j(r100, length());
        return this.array[this.f275646a + r100];
    }

    public int indexOf(long r100) {
        int r101 = this.f275646a;
    L4:
        if (r101 >= this.end) goto L10;
        if (this.array[r101] == r100) goto L8;
        r101 = r101 + 1;
        goto L4
    L8:
        return r101 - this.f275646a;
    L10:
        return -1;
    }

    public int lastIndexOf(long r100) {
        int r101 = this.end;
    L3:
        r101 = r101 - 1;
        int r102 = this.f275646a;
        if (r101 < r102) goto L10;
        if (this.array[r101] != r100) goto L3;
        return r101 - r102;
    L10:
        return -1;
    }

    public static ImmutableLongArray copyOf(Collection<Long> r100) {
        if (r100.isEmpty() == false) goto L6;
        return f275645b;
    L6:
        if ((r100 instanceof Longs.LongArrayAsList) == false) goto L8;
        long[] r101 = ((Longs.LongArrayAsList) r100).toLongArray();
    L13:
        return new ImmutableLongArray(r101);
    L8:
        Object[] r102 = r100.toArray();
        int r103 = r102.length;
        long[] r104 = new long[r103];
        int r105 = 0;
    L9:
        if (r105 >= r103) goto L11;
        Object r106 = r102[r105];
        r106.getClass();
        r104[r105] = ((Number) r106).longValue();
        r105 = r105 + 1;
        goto L9
    L11:
        r101 = r104;
        goto L13
    }

    public static ImmutableLongArray copyOf(long[] r100) {
        if (r100.length != 0) goto L6;
        return f275645b;
    L6:
        return new ImmutableLongArray(Arrays.copyOf(r100, r100.length));
    }

    public static ImmutableLongArray of(long r100, long... r101) {
        if (r101.length > 2147483646) goto L5;
        boolean r102 = true;
    L6:
        m.c(r102, "the total number of elements must fit in an int");
        int r103 = r101.length + 1;
        long[] r104 = new long[r103];
        r104[0] = r100;
        System.arraycopy(r101, 0, r104, 1, r101.length);
        return new ImmutableLongArray(r104, 0, r103);
    L5:
        r102 = false;
        goto L6
    }

    public ImmutableLongArray subArray(int r100, int r101) {
        m.n(r100, r101, length());
        if (r100 == r101) goto L7;
        long[] r102 = this.array;
        int r103 = this.f275646a;
        return new ImmutableLongArray(r102, r100 + r103, r103 + r101);
    L7:
        return f275645b;
    }

    public static ImmutableLongArray of(long r100, long r101) {
        return new ImmutableLongArray(new long[]{r100, r101}, 0, 2);
    }

    public ImmutableLongArray(long[] r100, int r101, int r102) {
        this.array = r100;
        this.f275646a = r101;
        this.end = r102;
    }

    public static ImmutableLongArray of(long r100, long r101, long r102) {
        return new ImmutableLongArray(new long[]{r100, r101, r102}, 0, 3);
    }

    public /* synthetic */ ImmutableLongArray(long[] r100, int r101, int r102, a r103) {
        this(r100, r101, r102);
    }

    public static ImmutableLongArray of(long r100, long r101, long r102, long r110) {
        return new ImmutableLongArray(new long[]{r100, r101, r102, r110}, 0, 4);
    }

    public static ImmutableLongArray of(long r100, long r101, long r102, long r110, long r111) {
        return new ImmutableLongArray(new long[]{r100, r101, r102, r110, r111}, 0, 5);
    }

    public static ImmutableLongArray of(long r100, long r101, long r102, long r110, long r111, long r112) {
        return new ImmutableLongArray(new long[]{r100, r101, r102, r110, r111, r112}, 0, 6);
    }
}
