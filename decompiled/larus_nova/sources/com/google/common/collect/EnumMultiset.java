package com.google.common.collect;

import androidx.collection.SieveCacheKt;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class EnumMultiset<E extends Enum<E>> extends d<E> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Class<E> f275014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient E[] f275015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int[] f275016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int f275017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient long f275018g;

    public class a extends EnumMultiset<E>.c<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EnumMultiset f275019d;

        public a(EnumMultiset r100) {
            this.f275019d = r100;
            super(r100);
        }

        @Override // com.google.common.collect.EnumMultiset.c
        public final Object a(int r100) {
            return EnumMultiset.access$000(this.f275019d)[r100];
        }
    }

    public class b extends EnumMultiset<E>.c<y1.a<E>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ EnumMultiset f275020d;

        public b(EnumMultiset r100) {
            this.f275020d = r100;
            super(r100);
        }

        @Override // com.google.common.collect.EnumMultiset.c
        public final Object a(int r100) {
            return new u(this, r100);
        }
    }

    public abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f275021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EnumMultiset f275023c;

        public abstract T a(int r100);

        @Override // java.util.Iterator
        public final boolean hasNext() {
        L3:
            if (this.f275021a >= EnumMultiset.access$000(this.f275023c).length) goto L9;
            int[] r100 = EnumMultiset.access$100(this.f275023c);
            int r101 = this.f275021a;
            if (r100[r101] > 0) goto L6;
            this.f275021a = r101 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f275022b < 0) goto L5;
            boolean r100 = true;
        L6:
            o.e(r100);
            if (EnumMultiset.access$100(this.f275023c)[this.f275022b] <= 0) goto L9;
            EnumMultiset.access$210(this.f275023c);
            EnumMultiset r101 = this.f275023c;
            EnumMultiset.access$322(r101, EnumMultiset.access$100(r101)[this.f275022b]);
            EnumMultiset.access$100(this.f275023c)[this.f275022b] = 0;
        L9:
            this.f275022b = -1;
            return;
        L5:
            r100 = false;
            goto L6
        }

        @Override // java.util.Iterator
        public final T next() {
            if (hasNext() == false) goto L7;
            T r100 = a(this.f275021a);
            int r101 = this.f275021a;
            this.f275022b = r101;
            this.f275021a = r101 + 1;
            return r100;
        L7:
            throw new NoSuchElementException();
        }

        public c(EnumMultiset r100) {
            this.f275023c = r100;
            this.f275021a = 0;
            this.f275022b = -1;
        }
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.f275016e, 0);
        this.f275018g = 0;
        this.f275017f = 0;
    }

    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.d
    public Iterator<y1.a<E>> entryIterator() {
        return new b(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public int size() {
        return Ints.c(this.f275018g);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.y1
    public Iterator<E> iterator() {
        return Multisets.d(this);
    }

    @Override // com.google.common.collect.d
    public int distinctElements() {
        return this.f275017f;
    }

    public EnumMultiset(Class<E> r100) {
        this.f275014c = r100;
        com.google.common.base.m.b(r100.isEnum());
        E[] r101 = r100.getEnumConstants();
        this.f275015d = r101;
        this.f275016e = new int[r101.length];
    }

    public static /* synthetic */ Enum[] access$000(EnumMultiset r100) {
        return r100.f275015d;
    }

    public static /* synthetic */ int[] access$100(EnumMultiset r100) {
        return r100.f275016e;
    }

    public static /* synthetic */ int access$210(EnumMultiset r100) {
        int r101 = r100.f275017f;
        r100.f275017f = r101 - 1;
        return r101;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r100) {
        Iterator<E> r101 = r100.iterator();
        com.google.common.base.m.c(r101.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> r102 = new EnumMultiset(r101.next().getDeclaringClass());
        a1.a(r102, r100);
        return r102;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        Class<E> r101 = (Class) r100.readObject();
        this.f275014c = r101;
        E[] r102 = r101.getEnumConstants();
        this.f275015d = r102;
        this.f275016e = new int[r102.length];
        j2.d(this, r100, r100.readInt());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(this.f275014c);
        j2.g(this, r100);
    }

    public final void a(Object r100) {
        r100.getClass();
        if (c(r100) == false) goto L6;
        return;
    L6:
        throw new ClassCastException("Expected an " + this.f275014c + " but got " + r100);
    }

    public final boolean c(@CheckForNull Object r100) {
        if ((r100 instanceof Enum) == false) goto L10;
        Enum r101 = (Enum) r100;
        int r102 = r101.ordinal();
        E[] r103 = this.f275015d;
        if (r102 < r103.length) goto L7;
        return false;
    L7:
        if (r103[r102] != r101) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r100) {
        return super.contains(r100);
    }

    @Override // com.google.common.collect.y1
    public int count(@CheckForNull Object r100) {
        if (r100 != null) goto L4;
        return 0;
    L4:
        if (c(r100) == true) goto L7;
        return 0;
    L7:
        return this.f275016e[((Enum) r100).ordinal()];
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> r100) {
        return new EnumMultiset(r100);
    }

    public static /* synthetic */ long access$322(EnumMultiset r100, long r101) {
        long r102 = r100.f275018g - r101;
        r100.f275018g = r102;
        return r102;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r100, Class<E> r101) {
        EnumMultiset<E> r102 = create(r101);
        a1.a(r102, r100);
        return r102;
    }

    public int add(E r100, int r110) {
        a(r100);
        o.b(r110, "occurrences");
        if (r110 == 0) goto L5;
        int r101 = r100.ordinal();
        int r102 = this.f275016e[r101];
        long r103 = r110;
        long r104 = ((long) r102) + r103;
        if (r104 > SieveCacheKt.NodeLinkMask) goto L9;
        boolean r105 = true;
    L10:
        com.google.common.base.m.f(r105, "too many occurrences: %s", r104);
        this.f275016e[r101] = (int) r104;
        if (r102 != 0) goto L13;
        this.f275017f++;
    L13:
        this.f275018g += r103;
        return r102;
    L9:
        r105 = false;
        goto L10
    L5:
        return count(r100);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public int remove(@CheckForNull Object r100, int r101) {
        if (r100 != null) goto L5;
    L18:
        return 0;
    L5:
        if (c(r100) == false) goto L18;
        Enum r102 = (Enum) r100;
        o.b(r101, "occurrences");
        if (r101 == 0) goto L10;
        int r103 = r102.ordinal();
        int[] r104 = this.f275016e;
        int r105 = r104[r103];
        if (r105 != 0) goto L14;
        return 0;
    L14:
        if (r105 > r101) goto L16;
        r104[r103] = 0;
        this.f275017f--;
        this.f275018g -= (long) r105;
    L17:
        return r105;
    L16:
        r104[r103] = r105 - r101;
        this.f275018g -= (long) r101;
        goto L17
    L10:
        return count(r100);
    }

    public int setCount(E r100, int r101) {
        a(r100);
        o.b(r101, "count");
        int r102 = r100.ordinal();
        int[] r103 = this.f275016e;
        int r104 = r103[r102];
        r103[r102] = r101;
        this.f275018g += (long) (r101 - r104);
        if (r104 != 0) goto L6;
        if (r101 <= 0) goto L6;
        this.f275017f++;
    L9:
        return r104;
    L6:
        if (r104 <= 0) goto L9;
        if (r101 != 0) goto L9;
        this.f275017f--;
        goto L9
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ int add(Object r100, int r101) {
        return add((Enum) r100, r101);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ int setCount(Object r100, int r101) {
        return setCount((Enum) r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ boolean setCount(@ParametricNullness Object r100, int r101, int r102) {
        return super.setCount(r100, r101, r102);
    }
}
