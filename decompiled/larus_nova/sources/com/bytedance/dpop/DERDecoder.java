package com.bytedance.dpop;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class DERDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f204767a = 0;

    public static final class DERInteger extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f204768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f204769b;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            return ((BigInteger) this.f204769b.getValue()).toString(16);
        }

        public DERInteger(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f204768a = r100;
            this.f204769b = LazyKt.lazy(new DERDecoder$DERInteger$bigInteger$2(this));
        }
    }

    public static abstract class a {
        public a() {
        }
    }

    public static final class b extends a implements List<a>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f204770a;

        public static final class a {
        }

        static {
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ void add(int r100, a r101) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ /* synthetic */ boolean add(Object r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final boolean addAll(int r100, Collection<? extends a> r101) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean addAll(Collection<? extends a> r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean containsAll(Collection<? extends Object> r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            return this.f204770a.containsAll(r100);
        }

        @Override // java.util.List, java.util.Collection
        public final boolean isEmpty() {
            return this.f204770a.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public final Iterator<a> iterator() {
            return this.f204770a.iterator();
        }

        @Override // java.util.List
        public final ListIterator<a> listIterator() {
            return this.f204770a.listIterator();
        }

        @Override // java.util.List
        public final ListIterator<a> listIterator(int r100) {
            return this.f204770a.listIterator(r100);
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ a remove(int r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean remove(Object r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean removeAll(Collection<? extends Object> r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final void replaceAll(UnaryOperator<a> r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final boolean retainAll(Collection<? extends Object> r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final /* bridge */ /* synthetic */ a set(int r100, a r101) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final void sort(Comparator<? super a> r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public final List<a> subList(int r100, int r101) {
            return this.f204770a.subList(r100, r101);
        }

        @Override // java.util.List, java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public final <T> T[] toArray(T[] r100) {
            Intrinsics.checkNotNullParameter(r100, "array");
            return (T[]) CollectionToArray.toArray(this, r100);
        }

        @Override // java.util.List, java.util.Collection
        public final int size() {
            return this.f204770a.size();
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder("[");
            Iterator<T> r101 = this.f204770a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r100.append(((a) r101.next()).toString());
            r100.append(',');
            goto L4
        L6:
            r100.append(']');
            return r100.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends a> r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            this.f204770a = r100;
        }

        @Override // java.util.List, java.util.Collection
        public final boolean contains(Object r100) {
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "element");
            return this.f204770a.contains(r101);
        }

        @Override // java.util.List
        public final a get(int r100) {
            return (a) ListProtector.get(this.f204770a, r100);
        }

        @Override // java.util.List
        public final int indexOf(Object r100) {
            if ((r100 instanceof a) == true) goto L6;
            return -1;
        L6:
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "element");
            return this.f204770a.indexOf(r101);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object r100) {
            if ((r100 instanceof a) == true) goto L6;
            return -1;
        L6:
            a r101 = (a) r100;
            Intrinsics.checkNotNullParameter(r101, "element");
            return this.f204770a.lastIndexOf(r101);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte f204771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f204772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f204773c;

        public final String toString() {
            return "Unknown(" + this.f204771a + ',' + this.f204772b + ',' + com.bytedance.dpop.b.a(this.f204773c) + ')';
        }

        public final byte getType() {
            return this.f204771a;
        }

        public c(byte r100, int r101, byte[] r102) {
            Intrinsics.checkNotNullParameter(r102, "content");
            this.f204771a = r100;
            this.f204772b = r101;
            this.f204773c = r102;
        }
    }

    static {
    }

    public static a a(ByteBuffer r100) {
        int r101 = r100.remaining();
        if (r101 <= 0) goto L28;
        if (r101 <= 2) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L26;
        byte r103 = r100.get();
        int r104 = r100.get();
        if (((byte) (r104 & com.alipay.sdk.m.n.a.f25611g)) != 0) goto L24;
        if (r103 != 2) goto L14;
        byte[] r105 = new byte[r104];
        r100.get(r105, 0, r104);
        return new DERInteger(r105);
    L14:
        if (r103 != 48) goto L21;
        ArrayList r106 = new ArrayList();
        int r107 = r100.remaining();
    L17:
        if ((r107 - r100.remaining()) >= r104) goto L32;
        if (r104 <= 2) goto L32;
        r106.add(a(r100));
    L32:
        return new b(r106);
    L21:
        byte[] r108 = new byte[r104];
        r100.get(r108, 0, r104);
        return new c(r103, r104, r108);
    L24:
        throw new UnsupportedOperationException("length does not supported(" + Integer.toString(r104, CharsKt.checkRadix(CharsKt.checkRadix(16))) + ')');
    L26:
        throw new IllegalArgumentException(("remaining:" + r101 + " < 3!").toString());
    L7:
        r102 = false;
        goto L8
    L28:
        throw new IllegalStateException("buffer overflow");
    }
}
