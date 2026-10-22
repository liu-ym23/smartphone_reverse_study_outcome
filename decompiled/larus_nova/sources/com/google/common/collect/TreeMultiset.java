package com.google.common.collect;

import androidx.collection.SieveCacheKt;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class TreeMultiset<E> extends h<E> implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient e<d<E>> f275374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient GeneralRange<E> f275375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient d<E> f275376f;

    public static abstract enum Aggregate extends Enum<Aggregate> {
        public static final Aggregate DISTINCT = null;
        public static final Aggregate SIZE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Aggregate[] f275377a = null;

        public Aggregate() {
            throw null;
        }

        public abstract int nodeAggregate(d<?> r100);

        public abstract long treeAggregate(@CheckForNull d<?> r100);

        static {
            final String r100 = "SIZE";
            final int r101 = 0;
            Aggregate r102 = new AnonymousClass1(r100, r101);
            SIZE = r102;
            final String r103 = "DISTINCT";
            final int r104 = 1;
            Aggregate r105 = new AnonymousClass2(r103, r104);
            DISTINCT = r105;
            f275377a = new Aggregate[]{r102, r105};
        }

        public static Aggregate[] values() {
            return (Aggregate[]) f275377a.clone();
        }

        public static Aggregate valueOf(String r100) {
            return (Aggregate) r27.a.a(Aggregate.class, r100);
        }

        public Aggregate(String r100, int r101, y2 r102) {
            super(r100, r101);
        }
    }

    public class a implements Iterator<y1.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public d<E> f275378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public y1.a<E> f275379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TreeMultiset f275380c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275378a != null) goto L6;
            return false;
        L6:
            if (TreeMultiset.access$1400(this.f275380c).tooHigh(this.f275378a.f275385a) == false) goto L9;
            this.f275378a = null;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f275379b == null) goto L5;
            boolean r100 = true;
        L6:
            com.google.common.base.m.p(r100, "no calls to next() since the last call to remove()");
            this.f275380c.setCount(this.f275379b.getElement(), 0);
            this.f275379b = null;
            return;
        L5:
            r100 = false;
            goto L6
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (hasNext() == false) goto L10;
            TreeMultiset r100 = this.f275380c;
            d<E> r101 = this.f275378a;
            Objects.requireNonNull(r101);
            y1.a<E> r102 = TreeMultiset.access$1500(r100, r101);
            this.f275379b = r102;
            if (this.f275378a.s() != TreeMultiset.access$1600(this.f275380c)) goto L7;
            this.f275378a = null;
        L8:
            return r102;
        L7:
            this.f275378a = this.f275378a.s();
            goto L8
        L10:
            throw new NoSuchElementException();
        }

        public a(TreeMultiset r100) {
            this.f275380c = r100;
            this.f275378a = TreeMultiset.access$1300(r100);
        }
    }

    public class b implements Iterator<y1.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public d<E> f275381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public y1.a<E> f275382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TreeMultiset f275383c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f275381a != null) goto L6;
            return false;
        L6:
            if (TreeMultiset.access$1400(this.f275383c).tooLow(this.f275381a.f275385a) == false) goto L9;
            this.f275381a = null;
            return false;
        L9:
            return true;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f275382b == null) goto L5;
            boolean r100 = true;
        L6:
            com.google.common.base.m.p(r100, "no calls to next() since the last call to remove()");
            this.f275383c.setCount(this.f275382b.getElement(), 0);
            this.f275382b = null;
            return;
        L5:
            r100 = false;
            goto L6
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (hasNext() == false) goto L10;
            Objects.requireNonNull(this.f275381a);
            y1.a<E> r100 = TreeMultiset.access$1500(this.f275383c, this.f275381a);
            this.f275382b = r100;
            if (this.f275381a.h() != TreeMultiset.access$1600(this.f275383c)) goto L7;
            this.f275381a = null;
        L8:
            return r100;
        L7:
            this.f275381a = this.f275381a.h();
            goto L8
        L10:
            throw new NoSuchElementException();
        }

        public b(TreeMultiset r100) {
            this.f275383c = r100;
            this.f275381a = TreeMultiset.access$1700(r100);
            this.f275382b = null;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275384a = null;

        static {
            int[] r100 = new int[BoundType.values().length];
            f275384a = r100;
            r100[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f275384a[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public final E f275385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f275387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f275388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f275389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @CheckForNull
        public d<E> f275390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @CheckForNull
        public d<E> f275391g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @CheckForNull
        public d<E> f275392h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @CheckForNull
        public d<E> f275393i;

        @CheckForNull
        public final d<E> f() {
            int r100 = this.f275386b;
            this.f275386b = 0;
            TreeMultiset.access$1900(h(), s());
            d<E> r101 = this.f275390f;
            if (r101 == null) goto L5;
            d<E> r102 = this.f275391g;
            if (r102 != null) goto L10;
            return r101;
        L10:
            if (r101.f275389e < r102.f275389e) goto L13;
            d<E> r103 = h();
            r103.f275390f = this.f275390f.m(r103);
            r103.f275391g = this.f275391g;
            r103.f275387c = this.f275387c - 1;
            r103.f275388d = this.f275388d - ((long) r100);
            return r103.i();
        L13:
            d<E> r104 = s();
            r104.f275391g = this.f275391g.n(r104);
            r104.f275390f = this.f275390f;
            r104.f275387c = this.f275387c - 1;
            r104.f275388d = this.f275388d - ((long) r100);
            return r104.i();
        L5:
            return this.f275391g;
        }

        public final d<E> h() {
            d<E> r100 = this.f275392h;
            Objects.requireNonNull(r100);
            return r100;
        }

        public final d<E> i() {
            d<E> r100 = this.f275390f;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            d<E> r103 = this.f275391g;
            if (r103 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = r102 - r104;
            if (r105 != (-2)) goto L13;
            Objects.requireNonNull(r103);
            d<E> r106 = this.f275391g;
            d<E> r107 = r106.f275390f;
            if (r107 != null) goto L32;
            int r108 = 0;
        L33:
            d<E> r109 = r106.f275391g;
            if (r109 == null) goto L38;
            r101 = r109.f275389e;
        L38:
            if ((r108 - r101) <= 0) goto L41;
            this.f275391g = r106.p();
        L41:
            return o();
        L32:
            r108 = r107.f275389e;
            goto L33
        L13:
            if (r105 == 2) goto L16;
            k();
            return this;
        L16:
            Objects.requireNonNull(r100);
            d<E> r110 = this.f275390f;
            d<E> r111 = r110.f275390f;
            if (r111 != null) goto L19;
            int r112 = 0;
        L20:
            d<E> r113 = r110.f275391g;
            if (r113 == null) goto L25;
            r101 = r113.f275389e;
        L25:
            if ((r112 - r101) >= 0) goto L28;
            this.f275390f = r110.o();
        L28:
            return p();
        L19:
            r112 = r111.f275389e;
            goto L20
        L9:
            r104 = r103.f275389e;
            goto L10
        L5:
            r102 = r100.f275389e;
            goto L6
        }

        public final void j() {
            this.f275387c = (TreeMultiset.distinctElements(this.f275390f) + 1) + TreeMultiset.distinctElements(this.f275391g);
            long r100 = this.f275386b;
            d<E> r101 = this.f275390f;
            long r102 = 0;
            if (r101 != null) goto L5;
            long r103 = 0;
        L6:
            long r104 = r100 + r103;
            d<E> r105 = this.f275391g;
            if (r105 == null) goto L10;
            r102 = r105.f275388d;
        L10:
            this.f275388d = r104 + r102;
            k();
            return;
        L5:
            r103 = r101.f275388d;
            goto L6
        }

        public final void k() {
            d<E> r100 = this.f275390f;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            d<E> r103 = this.f275391g;
            if (r103 == null) goto L10;
            r101 = r103.f275389e;
        L10:
            this.f275389e = Math.max(r102, r101) + 1;
            return;
        L5:
            r102 = r100.f275389e;
            goto L6
        }

        public final d<E> o() {
            if (this.f275391g == null) goto L5;
            boolean r100 = true;
        L6:
            com.google.common.base.m.o(r100);
            d<E> r101 = this.f275391g;
            this.f275391g = r101.f275390f;
            r101.f275390f = this;
            r101.f275388d = this.f275388d;
            r101.f275387c = this.f275387c;
            j();
            r101.k();
            return r101;
        L5:
            r100 = false;
            goto L6
        }

        public final d<E> p() {
            if (this.f275390f == null) goto L5;
            boolean r100 = true;
        L6:
            com.google.common.base.m.o(r100);
            d<E> r101 = this.f275390f;
            this.f275390f = r101.f275391g;
            r101.f275391g = this;
            r101.f275388d = this.f275388d;
            r101.f275387c = this.f275387c;
            j();
            r101.k();
            return r101;
        L5:
            r100 = false;
            goto L6
        }

        public final d<E> s() {
            d<E> r100 = this.f275393i;
            Objects.requireNonNull(r100);
            return r100;
        }

        public final String toString() {
            return new Multisets.ImmutableEntry(this.f275385a, this.f275386b).toString();
        }

        public d() {
            this.f275385a = null;
            this.f275386b = 1;
        }

        @CheckForNull
        public final d<E> m(d<E> r100) {
            d<E> r101 = this.f275391g;
            if (r101 == null) goto L5;
            this.f275391g = r101.m(r100);
            this.f275387c--;
            this.f275388d -= (long) r100.f275386b;
            return i();
        L5:
            return this.f275390f;
        }

        @CheckForNull
        public final d<E> n(d<E> r100) {
            d<E> r101 = this.f275390f;
            if (r101 == null) goto L5;
            this.f275390f = r101.n(r100);
            this.f275387c--;
            this.f275388d -= (long) r100.f275386b;
            return i();
        L5:
            return this.f275391g;
        }

        public d(@ParametricNullness E r100, int r101) {
            if (r101 <= 0) goto L5;
            boolean r102 = true;
        L6:
            com.google.common.base.m.b(r102);
            this.f275385a = r100;
            this.f275386b = r101;
            this.f275388d = r101;
            this.f275387c = 1;
            this.f275389e = 1;
            this.f275390f = null;
            this.f275391g = null;
            return;
        L5:
            r102 = false;
            goto L6
        }

        public final void b(@ParametricNullness Object r100, int r101) {
            this.f275390f = new d(r100, r101);
            TreeMultiset.access$1800(h(), this.f275390f, this);
            this.f275389e = Math.max(2, this.f275389e);
            this.f275387c++;
            this.f275388d += (long) r101;
        }

        public final void c(@ParametricNullness Object r100, int r101) {
            d<E> r102 = new d(r100, r101);
            this.f275391g = r102;
            TreeMultiset.access$1800(this, r102, s());
            this.f275389e = Math.max(2, this.f275389e);
            this.f275387c++;
            this.f275388d += (long) r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final d<E> d(Comparator<? super E> r100, @ParametricNullness E r101) {
            int r102 = r100.compare(r101, this.f275385a);
            if (r102 >= 0) goto L9;
            d<E> r103 = this.f275390f;
            if (r103 != null) goto L8;
            return this;
        L8:
            return (d) com.google.common.base.j.a(r103.d(r100, r101), this);
        L9:
            if (r102 != 0) goto L11;
            return this;
        L11:
            d<E> r104 = this.f275391g;
            if (r104 != null) goto L15;
            return null;
        L15:
            return r104.d(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int e(Comparator<? super E> r100, @ParametricNullness E r101) {
            int r102 = r100.compare(r101, this.f275385a);
            if (r102 >= 0) goto L9;
            d<E> r103 = this.f275390f;
            if (r103 != null) goto L8;
            return 0;
        L8:
            return r103.e(r100, r101);
        L9:
            if (r102 <= 0) goto L16;
            d<E> r104 = this.f275391g;
            if (r104 != null) goto L14;
            return 0;
        L14:
            return r104.e(r100, r101);
        L16:
            return this.f275386b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final d<E> g(Comparator<? super E> r100, @ParametricNullness E r101) {
            int r102 = r100.compare(r101, this.f275385a);
            if (r102 <= 0) goto L9;
            d<E> r103 = this.f275391g;
            if (r103 != null) goto L8;
            return this;
        L8:
            return (d) com.google.common.base.j.a(r103.g(r100, r101), this);
        L9:
            if (r102 != 0) goto L11;
            return this;
        L11:
            d<E> r104 = this.f275390f;
            if (r104 != null) goto L15;
            return null;
        L15:
            return r104.g(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final d<E> a(Comparator<? super E> r100, @ParametricNullness E r101, int r110, int[] r111) {
            int r102 = r100.compare(r101, this.f275385a);
            boolean r103 = true;
            if (r102 >= 0) goto L16;
            d<E> r104 = this.f275390f;
            if (r104 != null) goto L8;
            r111[0] = 0;
            b(r101, r110);
            return this;
        L8:
            int r105 = r104.f275389e;
            d<E> r106 = r104.a(r100, r101, r110, r111);
            this.f275390f = r106;
            if (r111[0] != 0) goto L11;
            this.f275387c++;
        L11:
            this.f275388d += (long) r110;
            if (r106.f275389e != r105) goto L15;
            return this;
        L15:
            return i();
        L16:
            if (r102 <= 0) goto L29;
            d<E> r107 = this.f275391g;
            if (r107 != null) goto L21;
            r111[0] = 0;
            c(r101, r110);
            return this;
        L21:
            int r108 = r107.f275389e;
            d<E> r109 = r107.a(r100, r101, r110, r111);
            this.f275391g = r109;
            if (r111[0] != 0) goto L24;
            this.f275387c++;
        L24:
            this.f275388d += (long) r110;
            if (r109.f275389e != r108) goto L28;
            return this;
        L28:
            return i();
        L29:
            int r112 = this.f275386b;
            r111[0] = r112;
            long r113 = r110;
            if ((((long) r112) + r113) <= SieveCacheKt.NodeLinkMask) goto L33;
            r103 = false;
        L33:
            com.google.common.base.m.b(r103);
            this.f275386b += r110;
            this.f275388d += r113;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final d<E> l(Comparator<? super E> r100, @ParametricNullness E r101, int r102, int[] r103) {
            int r104 = r100.compare(r101, this.f275385a);
            if (r104 >= 0) goto L17;
            d<E> r105 = this.f275390f;
            if (r105 != null) goto L8;
            r103[0] = 0;
            return this;
        L8:
            this.f275390f = r105.l(r100, r101, r102, r103);
            int r106 = r103[0];
            if (r106 <= 0) goto L13;
            if (r102 < r106) goto L12;
            this.f275387c--;
            this.f275388d -= (long) r106;
            goto L13
        L12:
            this.f275388d -= (long) r102;
        L13:
            if (r106 != 0) goto L16;
            return this;
        L16:
            return i();
        L17:
            if (r104 <= 0) goto L29;
            d<E> r107 = this.f275391g;
            if (r107 != null) goto L22;
            r103[0] = 0;
            return this;
        L22:
            this.f275391g = r107.l(r100, r101, r102, r103);
            int r108 = r103[0];
            if (r108 <= 0) goto L28;
            if (r102 < r108) goto L26;
            this.f275387c--;
            this.f275388d -= (long) r108;
            goto L28
        L26:
            this.f275388d -= (long) r102;
        L28:
            return i();
        L29:
            int r109 = this.f275386b;
            r103[0] = r109;
            if (r102 >= r109) goto L32;
            this.f275386b = r109 - r102;
            this.f275388d -= (long) r102;
            return this;
        L32:
            return f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final d<E> r(Comparator<? super E> r100, @ParametricNullness E r101, int r102, int[] r103) {
            int r104 = r100.compare(r101, this.f275385a);
            if (r104 >= 0) goto L21;
            d<E> r105 = this.f275390f;
            if (r105 != null) goto L10;
            r103[0] = 0;
            if (r102 <= 0) goto L9;
            b(r101, r102);
        L9:
            return this;
        L10:
            this.f275390f = r105.r(r100, r101, r102, r103);
            if (r102 == 0) goto L13;
        L15:
            if (r102 > 0) goto L17;
        L19:
            this.f275388d += (long) (r102 - r103[0]);
            return i();
        L17:
            if (r103[0] != 0) goto L19;
            this.f275387c++;
            goto L19
        L13:
            if (r103[0] == 0) goto L15;
            this.f275387c--;
            goto L19
        L21:
            if (r104 <= 0) goto L39;
            d<E> r106 = this.f275391g;
            if (r106 != null) goto L28;
            r103[0] = 0;
            if (r102 <= 0) goto L27;
            c(r101, r102);
        L27:
            return this;
        L28:
            this.f275391g = r106.r(r100, r101, r102, r103);
            if (r102 == 0) goto L31;
        L33:
            if (r102 > 0) goto L35;
        L37:
            this.f275388d += (long) (r102 - r103[0]);
            return i();
        L35:
            if (r103[0] != 0) goto L37;
            this.f275387c++;
            goto L37
        L31:
            if (r103[0] == 0) goto L33;
            this.f275387c--;
            goto L37
        L39:
            int r107 = this.f275386b;
            r103[0] = r107;
            if (r102 == 0) goto L42;
            this.f275388d += (long) (r102 - r107);
            this.f275386b = r102;
            return this;
        L42:
            return f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public final d<E> q(Comparator<? super E> r100, @ParametricNullness E r110, int r111, int r112, int[] r113) {
            int r101 = r100.compare(r110, this.f275385a);
            if (r101 >= 0) goto L22;
            d<E> r102 = this.f275390f;
            if (r102 != null) goto L11;
            r113[0] = 0;
            if (r111 != 0) goto L10;
            if (r112 <= 0) goto L10;
            b(r110, r112);
        L10:
            return this;
        L11:
            this.f275390f = r102.q(r100, r110, r111, r112, r113);
            int r103 = r113[0];
            if (r103 != r111) goto L21;
            if (r112 != 0) goto L16;
            if (r103 == 0) goto L16;
            this.f275387c--;
        L19:
            this.f275388d += (long) (r112 - r103);
        L16:
            if (r112 <= 0) goto L19;
            if (r103 != 0) goto L19;
            this.f275387c++;
        L21:
            return i();
        L22:
            if (r101 <= 0) goto L41;
            d<E> r104 = this.f275391g;
            if (r104 != null) goto L30;
            r113[0] = 0;
            if (r111 != 0) goto L29;
            if (r112 <= 0) goto L29;
            c(r110, r112);
        L29:
            return this;
        L30:
            this.f275391g = r104.q(r100, r110, r111, r112, r113);
            int r105 = r113[0];
            if (r105 != r111) goto L40;
            if (r112 != 0) goto L35;
            if (r105 == 0) goto L35;
            this.f275387c--;
        L38:
            this.f275388d += (long) (r112 - r105);
        L35:
            if (r112 <= 0) goto L38;
            if (r105 != 0) goto L38;
            this.f275387c++;
        L40:
            return i();
        L41:
            int r106 = this.f275386b;
            r113[0] = r106;
            if (r111 != r106) goto L47;
            if (r112 == 0) goto L45;
            this.f275388d += (long) (r112 - r106);
            this.f275386b = r112;
            goto L47
        L45:
            return f();
        L47:
            return this;
        }
    }

    public static final class e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public T f275394a;

        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@CheckForNull d r100, @CheckForNull d r101) {
            if (this.f275394a != r100) goto L7;
            this.f275394a = r101;
            return;
        L7:
            throw new ConcurrentModificationException();
        }
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset(Ordering.natural());
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.f275375e.hasLowerBound() == false) goto L5;
    L11:
        Iterators.b(entryIterator());
        return;
    L5:
        if (this.f275375e.hasUpperBound() == true) goto L11;
        d<E> r100 = this.f275376f.s();
    L7:
        d<E> r101 = this.f275376f;
        if (r100 == r101) goto L10;
        d<E> r102 = r100.s();
        r100.f275386b = 0;
        r100.f275390f = null;
        r100.f275391g = null;
        r100.f275392h = null;
        r100.f275393i = null;
        r100 = r102;
        goto L7
    L10:
        r101.f275393i = r101;
        r101.f275392h = r101;
        this.f275374d.f275394a = null;
    }

    @Override // com.google.common.collect.h
    public Iterator<y1.a<E>> descendingEntryIterator() {
        return new b(this);
    }

    @Override // com.google.common.collect.d
    public int distinctElements() {
        return Ints.c(d(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.d
    public Iterator<y1.a<E>> entryIterator() {
        return new a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public int size() {
        return Ints.c(d(Aggregate.SIZE));
    }

    @Override // com.google.common.collect.h, com.google.common.collect.n2, com.google.common.collect.l2
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.n2
    public /* bridge */ /* synthetic */ n2 descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        return new z1(entryIterator());
    }

    @Override // com.google.common.collect.h, com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.n2
    @CheckForNull
    public /* bridge */ /* synthetic */ y1.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.y1
    public Iterator<E> iterator() {
        return Multisets.d(this);
    }

    @Override // com.google.common.collect.h, com.google.common.collect.n2
    @CheckForNull
    public /* bridge */ /* synthetic */ y1.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.n2
    @CheckForNull
    public /* bridge */ /* synthetic */ y1.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.h, com.google.common.collect.n2
    @CheckForNull
    public /* bridge */ /* synthetic */ y1.a pollLastEntry() {
        return super.pollLastEntry();
    }

    public TreeMultiset(Comparator<? super E> r100) {
        super(r100);
        this.f275375e = GeneralRange.all(r100);
        d<E> r101 = new d();
        this.f275376f = r101;
        r101.f275393i = r101;
        r101.f275392h = r101;
        this.f275374d = new e();
    }

    public static d access$1300(TreeMultiset r100) {
        d<E> r101 = r100.f275374d.f275394a;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100.f275375e.hasLowerBound() == false) goto L15;
        E r102 = r100.f275375e.getLowerEndpoint();
        d<E> r103 = r101.d(r100.comparator(), r102);
        if (r103 != null) goto L11;
        return null;
    L11:
        if (r100.f275375e.getLowerBoundType() != BoundType.OPEN) goto L17;
        if (r100.comparator().compare(r102, r103.f275385a) != 0) goto L17;
        r103 = r103.s();
    L17:
        if (r103 != r100.f275376f) goto L19;
        return null;
    L19:
        if (r100.f275375e.contains(r103.f275385a) == true) goto L22;
        return null;
    L22:
        return r103;
    L15:
        r103 = r100.f275376f.s();
        goto L17
    }

    public static /* synthetic */ GeneralRange access$1400(TreeMultiset r100) {
        return r100.f275375e;
    }

    public static /* synthetic */ d access$1600(TreeMultiset r100) {
        return r100.f275376f;
    }

    public static d access$1700(TreeMultiset r100) {
        d<E> r101 = r100.f275374d.f275394a;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100.f275375e.hasUpperBound() == false) goto L15;
        E r102 = r100.f275375e.getUpperEndpoint();
        d<E> r103 = r101.g(r100.comparator(), r102);
        if (r103 != null) goto L11;
        return null;
    L11:
        if (r100.f275375e.getUpperBoundType() != BoundType.OPEN) goto L17;
        if (r100.comparator().compare(r102, r103.f275385a) != 0) goto L17;
        r103 = r103.h();
    L17:
        if (r103 != r100.f275376f) goto L19;
        return null;
    L19:
        if (r100.f275375e.contains(r103.f275385a) == true) goto L22;
        return null;
    L22:
        return r103;
    L15:
        r103 = r100.f275376f.h();
        goto L17
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> r100) {
        if (r100 != null) goto L5;
        return new TreeMultiset(Ordering.natural());
    L5:
        return new TreeMultiset(r100);
    }

    public static int distinctElements(@CheckForNull d<?> r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.f275387c;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        Comparator r101 = (Comparator) r100.readObject();
        j2.a(h.class, "comparator").a(this, r101);
        j2.a(TreeMultiset.class, FilterData.FilterOptionItem.Type.RANGE).a(this, GeneralRange.all(r101));
        j2.a(TreeMultiset.class, "rootReference").a(this, new e());
        d<E> r102 = new d();
        j2.a(TreeMultiset.class, "header").a(this, r102);
        r102.f275393i = r102;
        r102.f275392h = r102;
        j2.d(this, r100, r100.readInt());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(elementSet().comparator());
        j2.g(this, r100);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.y1
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object r100) {
        return super.contains(r100);
    }

    @Override // com.google.common.collect.y1
    public int count(@CheckForNull Object r100) {
        d<E> r101 = this.f275374d.f275394a;     // Catch: Throwable -> L10
        if (this.f275375e.contains(r100) == false) goto L9;
        if (r101 == null) goto L9;
        return r101.e(comparator(), r100);
    L9:
        return 0;
    }

    public final long d(Aggregate r100) {
        d<E> r101 = this.f275374d.f275394a;
        long r102 = r100.treeAggregate(r101);
        if (this.f275375e.hasLowerBound() == false) goto L6;
        r102 = r102 - c(r100, r101);
    L6:
        if (this.f275375e.hasUpperBound() == true) goto L8;
        return r102;
    L8:
        return r102 - a(r100, r101);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> r100) {
        TreeMultiset<E> r101 = create();
        a1.a(r101, r100);
        return r101;
    }

    public static y1.a access$1500(TreeMultiset r100, d r101) {
        r100.getClass();
        return new y2(r100, r101);
    }

    public static void access$1900(d r100, d r101) {
        r100.f275393i = r101;
        r101.f275392h = r100;
    }

    public final long a(Aggregate r100, @CheckForNull d<E> r101) {
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = comparator().compare(this.f275375e.getUpperEndpoint(), r101.f275385a);
        if (r102 > 0) goto L8;
        if (r102 != 0) goto L21;
        int r103 = c.f275384a[this.f275375e.getUpperBoundType().ordinal()];
        if (r103 != 1) goto L13;
        long r104 = r100.nodeAggregate(r101);
        long r105 = r100.treeAggregate(r101.f275391g);
    L20:
        return r104 + r105;
    L13:
        if (r103 != 2) goto L17;
        return r100.treeAggregate(r101.f275391g);
    L17:
        throw new AssertionError();
    L21:
        r104 = r100.treeAggregate(r101.f275391g) + ((long) r100.nodeAggregate(r101));
        r105 = a(r100, r101.f275390f);
        goto L20
    L8:
        return a(r100, r101.f275391g);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public int add(@ParametricNullness E r100, int r101) {
        o.b(r101, "occurrences");
        if (r101 == 0) goto L5;
        com.google.common.base.m.b(this.f275375e.contains(r100));
        d<E> r102 = this.f275374d.f275394a;
        if (r102 != null) goto L10;
        comparator().compare(r100, r100);
        d<E> r103 = new d(r100, r101);
        d<E> r104 = this.f275376f;
        r104.f275393i = r103;
        r103.f275392h = r104;
        r103.f275393i = r104;
        r104.f275392h = r103;
        this.f275374d.a(r102, r103);
        return 0;
    L10:
        int[] r105 = new int[1];
        d<E> r106 = r102.a(comparator(), r100, r101, r105);
        this.f275374d.a(r102, r106);
        return r105[0];
    L5:
        return count(r100);
    }

    public final long c(Aggregate r100, @CheckForNull d<E> r101) {
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = comparator().compare(this.f275375e.getLowerEndpoint(), r101.f275385a);
        if (r102 < 0) goto L8;
        if (r102 != 0) goto L21;
        int r103 = c.f275384a[this.f275375e.getLowerBoundType().ordinal()];
        if (r103 != 1) goto L13;
        long r104 = r100.nodeAggregate(r101);
        long r105 = r100.treeAggregate(r101.f275390f);
    L20:
        return r104 + r105;
    L13:
        if (r103 != 2) goto L17;
        return r100.treeAggregate(r101.f275390f);
    L17:
        throw new AssertionError();
    L21:
        r104 = r100.treeAggregate(r101.f275390f) + ((long) r100.nodeAggregate(r101));
        r105 = c(r100, r101.f275391g);
        goto L20
    L8:
        return c(r100, r101.f275390f);
    }

    @Override // com.google.common.collect.n2
    public n2<E> headMultiset(@ParametricNullness E r100, BoundType r101) {
        return new TreeMultiset(this.f275374d, this.f275375e.intersect(GeneralRange.upTo(comparator(), r100, r101)), this.f275376f);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public int remove(@CheckForNull Object r100, int r101) {
        o.b(r101, "occurrences");
        if (r101 == 0) goto L5;
        d<E> r102 = this.f275374d.f275394a;
        int[] r103 = new int[1];
        if (this.f275375e.contains(r100) == false) goto L14;
        if (r102 == null) goto L14;
        d<E> r104 = r102.l(comparator(), r100, r101, r103);     // Catch: Throwable -> L15
        this.f275374d.a(r102, r104);
        return r103[0];
    L14:
        return 0;
    L5:
        return count(r100);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public int setCount(@ParametricNullness E r100, int r101) {
        o.b(r101, "count");
        boolean r102 = true;
        if (this.f275375e.contains(r100) == true) goto L9;
        if (r101 == 0) goto L7;
        r102 = false;
    L7:
        com.google.common.base.m.b(r102);
        return 0;
    L9:
        d<E> r103 = this.f275374d.f275394a;
        if (r103 != null) goto L14;
        if (r101 <= 0) goto L13;
        add(r100, r101);
    L13:
        return 0;
    L14:
        int[] r104 = new int[1];
        d<E> r105 = r103.r(comparator(), r100, r101, r104);
        this.f275374d.a(r103, r105);
        return r104[0];
    }

    @Override // com.google.common.collect.n2
    public n2<E> tailMultiset(@ParametricNullness E r100, BoundType r101) {
        return new TreeMultiset(this.f275374d, this.f275375e.intersect(GeneralRange.downTo(comparator(), r100, r101)), this.f275376f);
    }

    public TreeMultiset(e<d<E>> r100, GeneralRange<E> r101, d<E> r102) {
        super(r101.comparator());
        this.f275374d = r100;
        this.f275375e = r101;
        this.f275376f = r102;
    }

    public static void access$1800(d r100, d r101, d r102) {
        r100.f275393i = r101;
        r101.f275392h = r100;
        r101.f275393i = r102;
        r102.f275392h = r101;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.y1
    public boolean setCount(@ParametricNullness E r110, int r111, int r112) {
        o.b(r112, "newCount");
        o.b(r111, "oldCount");
        com.google.common.base.m.b(this.f275375e.contains(r110));
        d<E> r100 = this.f275374d.f275394a;
        if (r100 != null) goto L9;
        if (r111 != 0) goto L8;
        if (r112 <= 0) goto L7;
        add(r110, r112);
    L7:
        return true;
    L8:
        return false;
    L9:
        int[] r101 = new int[1];
        d<E> r113 = r100.q(comparator(), r110, r111, r112, r101);
        this.f275374d.a(r100, r113);
        if (r101[0] != r111) goto L13;
        return true;
    L13:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.h, com.google.common.collect.n2
    public /* bridge */ /* synthetic */ n2 subMultiset(@ParametricNullness Object r100, BoundType r101, @ParametricNullness Object r102, BoundType r103) {
        return super.subMultiset(r100, r101, r102, r103);
    }
}
