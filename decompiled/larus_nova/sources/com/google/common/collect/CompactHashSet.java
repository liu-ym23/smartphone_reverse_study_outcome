package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient Object f274980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    public transient int[] f274981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f274982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f274983d;

    @CheckForNull
    transient Object[] elements;

    public class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f274986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ CompactHashSet f274987d;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f274985b < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final E next() {
            if (CompactHashSet.access$000(this.f274987d) != this.f274984a) goto L11;
            if (hasNext() == false) goto L9;
            int r100 = this.f274985b;
            this.f274986c = r100;
            E r101 = (E) CompactHashSet.access$100(this.f274987d, r100);
            this.f274985b = this.f274987d.getSuccessor(this.f274985b);
            return r101;
        L9:
            throw new NoSuchElementException();
        L11:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (CompactHashSet.access$000(this.f274987d) != this.f274984a) goto L11;
            if (this.f274986c < 0) goto L7;
            boolean r100 = true;
        L8:
            o.e(r100);
            this.f274984a += 32;
            CompactHashSet r101 = this.f274987d;
            r101.remove(CompactHashSet.access$100(r101, this.f274986c));
            this.f274985b = this.f274987d.adjustAfterRemove(this.f274985b, this.f274986c);
            this.f274986c = -1;
            return;
        L7:
            r100 = false;
            goto L8
        L11:
            throw new ConcurrentModificationException();
        }

        public a(CompactHashSet r100) {
            this.f274987d = r100;
            this.f274984a = CompactHashSet.access$000(r100);
            this.f274985b = r100.firstEntryIndex();
            this.f274986c = -1;
        }
    }

    public int adjustAfterRemove(int r100, int r101) {
        return r100 - 1;
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet();
    }

    public final Object[] a() {
        Object[] r100 = this.elements;
        Objects.requireNonNull(r100);
        return r100;
    }

    public final int[] c() {
        int[] r100 = this.f274981b;
        Objects.requireNonNull(r100);
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Set<E> convertToHashFloodingResistantImplementation() {
        LinkedHashSet r100 = new LinkedHashSet(((1 << (this.f274982c & 31)) - 1) + 1, 1.0f);
        int r101 = firstEntryIndex();
    L3:
        if (r101 < 0) goto L5;
        r100.add(a()[r101]);
        r101 = getSuccessor(r101);
        goto L3
    L5:
        this.f274980a = r100;
        this.f274981b = null;
        this.elements = null;
        incrementModCount();
        return r100;
    }

    @CheckForNull
    public Set<E> delegateOrNull() {
        Object r100 = this.f274980a;
        if ((r100 instanceof Set) == true) goto L5;
        return null;
    L5:
        return (Set) r100;
    }

    public void incrementModCount() {
        this.f274982c += 32;
    }

    public boolean needsAllocArrays() {
        if (this.f274980a != null) goto L5;
        return true;
    L5:
        return false;
    }

    public CompactHashSet() {
        init(3);
    }

    public int allocArrays() {
        com.google.common.base.m.p(needsAllocArrays(), "Arrays already allocated");
        int r100 = this.f274982c;
        int r101 = q.e(r100);
        this.f274980a = q.a(r101);
        this.f274982c = ((32 - Integer.numberOfLeadingZeros(r101 - 1)) & 31) | (this.f274982c & (-32));
        this.f274981b = new int[r100];
        this.elements = new Object[r100];
        return r100;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        incrementModCount();
        Set<E> r100 = delegateOrNull();
        if (r100 == null) goto L8;
        this.f274982c = Ints.b(size(), 3);
        r100.clear();
        this.f274980a = null;
        this.f274983d = 0;
        return;
    L8:
        Arrays.fill(a(), 0, this.f274983d, null);
        Object r101 = this.f274980a;
        Objects.requireNonNull(r101);
        if ((r101 instanceof byte[]) == false) goto L12;
        Arrays.fill((byte[]) r101, (byte) 0);
    L15:
        Arrays.fill(c(), 0, this.f274983d, 0);
        this.f274983d = 0;
        return;
    L12:
        if ((r101 instanceof short[]) == false) goto L14;
        Arrays.fill((short[]) r101, 0);
        goto L15
    L14:
        Arrays.fill((int[]) r101, 0);
        goto L15
    }

    public int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUsingHashFloodingResistance() {
        if (delegateOrNull() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> r100 = delegateOrNull();
        if (r100 == null) goto L7;
        return r100.iterator();
    L7:
        return new a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> r100 = delegateOrNull();
        if (r100 == null) goto L6;
        return r100.size();
    L6:
        return this.f274983d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r100 = delegateOrNull();
        if (r100 == null) goto L10;
        return r100.toArray();
    L10:
        return Arrays.copyOf(a(), this.f274983d);
    L5:
        return new Object[0];
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        Set<E> r100 = delegateOrNull();
        if (r100 == null) goto L9;
        LinkedHashSet r101 = new LinkedHashSet(size(), 1.0f);
        r101.addAll(r100);
        this.f274980a = r101;
        return;
    L9:
        int r102 = this.f274983d;
        if (r102 >= c().length) goto L12;
        resizeEntries(r102);
    L12:
        int r103 = q.e(r102);
        int r104 = (1 << (this.f274982c & 31)) - 1;
        if (r103 >= r104) goto L16;
        d(r104, r103, 0, 0);
        return;
    }

    public CompactHashSet(int r100) {
        init(r100);
    }

    public static /* synthetic */ int access$000(CompactHashSet r100) {
        return r100.f274982c;
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> r100) {
        CompactHashSet<E> r101 = createWithExpectedSize(r100.size());
        r101.addAll(r100);
        return r101;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int r100) {
        return new CompactHashSet(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        int r101 = r100.readInt();
        if (r101 < 0) goto L9;
        init(r101);
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        add(r100.readObject());
        r102 = r102 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException("Invalid size: " + r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeInt(size());
        Iterator<E> r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.writeObject(r101.next());
        goto L4
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(@ParametricNullness E r110) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        Set<E> r100 = delegateOrNull();
        if (r100 != null) goto L8;
        int[] r101 = c();
        Object[] r102 = a();
        int r103 = this.f274983d;
        int r104 = r103 + 1;
        int r105 = u0.c(r110);
        int r106 = (1 << (this.f274982c & 31)) - 1;
        int r107 = r105 & r106;
        Object r111 = this.f274980a;
        Objects.requireNonNull(r111);
        int r112 = q.c(r111, r107);
        if (r112 != 0) goto L17;
        if (r104 <= r106) goto L16;
        if (r106 >= 32) goto L14;
        int r113 = 4;
    L15:
        r106 = d(r106, r113 * (r106 + 1), r105, r103);
    L35:
        int r108 = c().length;
        if (r104 <= r108) goto L40;
        int r109 = Math.min(1073741823, (Math.max(1, r108 >>> 1) + r108) | 1);
        if (r109 == r108) goto L40;
        resizeEntries(r109);
    L40:
        insertEntry(r103, r110, r105, r106);
        this.f274983d = r104;
        incrementModCount();
        return true;
    L14:
        r113 = 2;
        goto L15
    L16:
        Object r114 = this.f274980a;
        Objects.requireNonNull(r114);
        q.d(r114, r107, r104);
        goto L35
    L17:
        int r115 = ~r106;
        int r116 = r105 & r115;
        boolean r117 = false;
        int r118 = 0;
    L18:
        int r119 = r112 - 1;
        int r120 = r101[r119];
        int r121 = r120 & r115;
        if (r121 == r116) goto L21;
    L23:
        int r122 = r120 & r106;
        int r123 = r118 + 1;
        if (r122 == 0) goto L26;
        r112 = r122;
        r118 = r123;
        r117 = false;
        goto L18
    L26:
        if (r123 >= 9) goto L28;
        if (r104 <= r106) goto L34;
        if (r106 >= 32) goto L32;
        int r124 = 4;
    L33:
        r106 = d(r106, r124 * (r106 + 1), r105, r103);
        goto L35
    L32:
        r124 = 2;
        goto L33
    L34:
        r101[r119] = (r104 & r106) | r121;
        goto L35
    L28:
        return convertToHashFloodingResistantImplementation().add(r110);
    L21:
        if (com.google.common.base.k.a(r110, r102[r119]) == false) goto L23;
        return r117;
    L8:
        return r100.add(r110);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r100) {
        if (needsAllocArrays() == false) goto L5;
        return false;
    L5:
        Set<E> r101 = delegateOrNull();
        if (r101 != null) goto L8;
        int r102 = u0.c(r100);
        int r103 = (1 << (this.f274982c & 31)) - 1;
        Object r104 = this.f274980a;
        Objects.requireNonNull(r104);
        int r105 = q.c(r104, r102 & r103);
        if (r105 != 0) goto L12;
        return false;
    L12:
        int r106 = ~r103;
        int r107 = r102 & r106;
    L13:
        int r108 = r105 - 1;
        int r109 = c()[r108];
        if ((r109 & r106) == r107) goto L16;
    L18:
        r105 = r109 & r103;
        if (r105 != 0) goto L13;
        return false;
    L16:
        if (com.google.common.base.k.a(r100, a()[r108]) == false) goto L18;
        return true;
    L8:
        return r101.contains(r100);
    }

    public int getSuccessor(int r100) {
        int r101 = r100 + 1;
        if (r101 < this.f274983d) goto L7;
        return -1;
    L7:
        return r101;
    }

    public void init(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        com.google.common.base.m.c(r101, "Expected size must be >= 0");
        this.f274982c = Ints.b(r100, 1);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object r110) {
        if (needsAllocArrays() == false) goto L5;
        return false;
    L5:
        Set<E> r100 = delegateOrNull();
        if (r100 != null) goto L8;
        int r101 = (1 << (this.f274982c & 31)) - 1;
        Object r102 = this.f274980a;
        Objects.requireNonNull(r102);
        int r111 = q.b(r110, null, r101, r102, c(), a(), null);
        if (r111 != (-1)) goto L12;
        return false;
    L12:
        moveLastEntry(r111, r101);
        this.f274983d--;
        incrementModCount();
        return true;
    L8:
        return r100.remove(r110);
    }

    public void resizeEntries(int r100) {
        this.f274981b = Arrays.copyOf(c(), r100);
        this.elements = Arrays.copyOf(a(), r100);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r100) {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r101 = delegateOrNull();
        if (r101 != null) goto L23;
        Object[] r102 = a();
        int r103 = this.f274983d;
        com.google.common.base.m.n(0, r103 + 0, r102.length);
        if (r100.length >= r103) goto L19;
        if (r100.length == 0) goto L17;
        r100 = (T[]) Arrays.copyOf(r100, 0);
    L17:
        r100 = (T[]) Arrays.copyOf(r100, r103);
    L21:
        System.arraycopy(r102, 0, r100, 0, r103);
        return r100;
    L19:
        if (r100.length <= r103) goto L21;
        r100[r103] = null;
        goto L21
    L23:
        return (T[]) r101.toArray(r100);
    L5:
        if (r100.length <= 0) goto L7;
        r100[0] = null;
    L7:
        return r100;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... r100) {
        CompactHashSet<E> r101 = createWithExpectedSize(r100.length);
        Collections.addAll(r101, r100);
        return r101;
    }

    public static Object access$100(CompactHashSet r100, int r101) {
        return r100.a()[r101];
    }

    public void moveLastEntry(int r100, int r101) {
        Object r102 = this.f274980a;
        Objects.requireNonNull(r102);
        int[] r103 = c();
        Object[] r104 = a();
        int r105 = size() - 1;
        if (r100 >= r105) goto L11;
        Object r106 = r104[r105];
        r104[r100] = r106;
        r104[r105] = null;
        r103[r100] = r103[r105];
        r103[r105] = 0;
        int r107 = u0.c(r106) & r101;
        int r108 = q.c(r102, r107);
        int r109 = r105 + 1;
        if (r108 != r109) goto L7;
        q.d(r102, r107, r100 + 1);
        return;
    L7:
        int r110 = r108 - 1;
        int r111 = r103[r110];
        int r112 = r111 & r101;
        if (r112 == r109) goto L9;
        r108 = r112;
        goto L7
    L9:
        r103[r110] = ((r100 + 1) & r101) | (r111 & (~r101));
        return;
    L11:
        r104[r100] = null;
        r103[r100] = 0;
    }

    public final int d(int r100, int r110, int r111, int r112) {
        Object r101 = q.a(r110);
        int r113 = r110 - 1;
        if (r112 == 0) goto L5;
        q.d(r101, r111 & r113, r112 + 1);
    L5:
        Object r114 = this.f274980a;
        Objects.requireNonNull(r114);
        int[] r115 = c();
        int r102 = 0;
    L6:
        if (r102 > r100) goto L11;
        int r103 = q.c(r114, r102);
    L8:
        if (r103 == 0) goto L10;
        int r104 = r103 - 1;
        int r105 = r115[r104];
        int r106 = ((~r100) & r105) | r102;
        int r107 = r106 & r113;
        int r108 = q.c(r101, r107);
        q.d(r101, r107, r103);
        r115[r104] = ((~r113) & r106) | (r108 & r113);
        r103 = r105 & r100;
        goto L8
    L10:
        r102 = r102 + 1;
        goto L6
    L11:
        this.f274980a = r101;
        this.f274982c = ((32 - Integer.numberOfLeadingZeros(r113)) & 31) | (this.f274982c & (-32));
        return r113;
    }

    public void insertEntry(int r100, @ParametricNullness E r101, int r102, int r103) {
        int r104 = (r102 & (~r103)) | (r103 & 0);
        c()[r100] = r104;
        a()[r100] = r101;
    }
}
