package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.AbstractMutableSet;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes5.dex */
public final class SmartSet<T> extends AbstractMutableSet<T> {
    public static final Companion Companion = null;
    private Object data;
    private int size;

    /* JADX INFO: loaded from: classes42.dex */
    public static final class ArrayIterator<T> implements Iterator<T>, KMutableIterator {
        private final Iterator<T> arrayIterator;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.arrayIterator.next();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        public ArrayIterator(T[] r100) {
            Intrinsics.checkNotNullParameter(r100, "array");
            this.arrayIterator = ArrayIteratorKt.iterator(r100);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final <T> SmartSet<T> create() {
            return new SmartSet(null);
        }

        @JvmStatic
        public final <T> SmartSet<T> create(Collection<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, "set");
            SmartSet<T> r101 = new SmartSet(null);
            r101.addAll(r100);
            return r101;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class SingletonIterator<T> implements Iterator<T>, KMutableIterator {
        private final T element;
        private boolean hasNext;

        @Override // java.util.Iterator
        public T next() {
            if (this.hasNext == false) goto L7;
            this.hasNext = false;
            return this.element;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            remove();
        }

        public SingletonIterator(T r100) {
            this.element = r100;
            this.hasNext = true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker r100) {
        this();
    }

    @JvmStatic
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() != 0) goto L6;
        return Collections.emptySet().iterator();
    L6:
        if (size() != 1) goto L9;
        return new SingletonIterator(this.data);
    L9:
        if (size() >= 5) goto L11;
        Object r100 = this.data;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return new ArrayIterator((Object[]) r100);
    L11:
        Object r101 = this.data;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return TypeIntrinsics.asMutableSet(r101).iterator();
    }

    private SmartSet() {
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r100) {
        if (size() != 0) goto L6;
        this.data = r100;
    L24:
        setSize(size() + 1);
        return true;
    L6:
        if (size() != 1) goto L12;
        if (Intrinsics.areEqual(this.data, r100) == false) goto L10;
        return false;
    L10:
        this.data = new Object[]{this.data, r100};
        goto L24
    L12:
        if (size() >= 5) goto L21;
        Object r101 = this.data;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        Object[] r102 = (Object[]) r101;
        if (ArraysKt.contains(r102, r100) == false) goto L17;
        return false;
    L17:
        if (size() != 4) goto L19;
        LinkedHashSet r103 = SetsKt.linkedSetOf(Arrays.copyOf(r102, r102.length));
        r103.add(r100);
        Object r104 = r103;
    L20:
        this.data = r104;
        goto L24
    L19:
        Object[] r105 = Arrays.copyOf(r102, size() + 1);
        r105[r105.length - 1] = r100;
        r104 = r105;
        goto L20
    L21:
        Object r106 = this.data;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        if (TypeIntrinsics.asMutableSet(r106).add(r100) == true) goto L24;
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r100) {
        if (size() != 0) goto L6;
        return false;
    L6:
        if (size() != 1) goto L9;
        return Intrinsics.areEqual(this.data, r100);
    L9:
        if (size() >= 5) goto L11;
        Object r101 = this.data;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ArraysKt.contains((Object[]) r101, r100);
    L11:
        Object r102 = this.data;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((Set) r102).contains(r100);
    }

    public void setSize(int r100) {
        this.size = r100;
    }
}
