package ed6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes19.dex */
public final class b<T> implements Iterable<T>, KMappedMarker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f472216d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f472217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f472218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator<? super T> f472219c;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void b(Object[] r100, int r101, Comparator r102) {
            if ((r101 % 2) != 0) goto L5;
            int r103 = (r101 / 2) - 1;
        L6:
            if (r103 >= 0) goto L9;
            return;
        L9:
            if (r102.compare(r100[r103], r100[r101]) <= 0) goto L12;
            Object r104 = r100[r101];
            r100[r101] = r100[r103];
            r100[r103] = r104;
            b(r100, r103, r102);
            return;
        L12:
            return;
        L5:
            r103 = r101 / 2;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(Object[] r100, int r101, int r102, Comparator r103) {
            int r104 = (r101 * 2) + 1;
            if (r104 < r102) goto L5;
            return;
        L5:
            int r105 = r104 + 1;
            if (r105 >= r102) goto L13;
            if (r103.compare(r100[r104], r100[r105]) < 0) goto L13;
            r104 = r105;
        L13:
            if (r103.compare(r100[r104], r100[r101]) >= 0) goto L16;
            Object r106 = r100[r101];
            r100[r101] = r100[r104];
            r100[r104] = r106;
            a(r100, r104, r102, r103);
            return;
        }
    }

    /* JADX INFO: renamed from: ed6.b$b, reason: collision with other inner class name */
    public static final class C5768b implements Iterator<T>, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f472220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f472221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f472222c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f472220a >= this.f472222c.f472218b) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final T next() {
            b r100 = this.f472222c;
            T[] r101 = r100.f472217a;
            if (r101 == null) goto L15;
            int r102 = this.f472220a;
            if (r102 >= r100.f472218b) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L11;
            r101 = null;
        L11:
            if (r101 == null) goto L15;
            this.f472221b = r102;
            this.f472220a = r102 + 1;
            return r101[r102];
        L7:
            r103 = false;
        L15:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int r100 = this.f472221b;
            if (r100 < 0) goto L7;
            this.f472222c.a(r100);
            this.f472220a = this.f472221b;
            this.f472221b = -1;
            return;
        L7:
            throw new IllegalStateException();
        }

        public C5768b(b r100) {
            this.f472222c = r100;
            this.f472221b = -1;
        }
    }

    static {
        f472216d = new a();
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        return new C5768b(this);
    }

    public final T poll() {
        T[] r100 = this.f472217a;
        if (r100 == null) goto L12;
        int r101 = this.f472218b;
        if (r101 != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L12;
        int r103 = r101 - 1;
        this.f472218b = r103;
        T r104 = r100[0];
        r100[0] = r100[r103];
        r100[r103] = null;
        a r105 = f472216d;
        Comparator<? super T> r106 = this.f472219c;
        r105.getClass();
        a.a(r100, 0, r103, r106);
        return r104;
    L7:
        r102 = false;
    L12:
        return null;
    }

    public b(Comparator<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "comparator");
        this.f472219c = r100;
    }

    public final void a(int r100) {
        T[] r101 = this.f472217a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 < 0) goto L19;
        int r102 = this.f472218b;
        if (r100 >= r102) goto L21;
        if (r102 != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        return;
    L14:
        int r104 = r102 - 1;
        this.f472218b = r104;
        if (r104 != r100) goto L17;
        r101[r100] = null;
        return;
    L17:
        T r105 = r101[r100];
        r101[r100] = r101[r104];
        r101[r104] = null;
        a r106 = f472216d;
        Comparator<? super T> r107 = this.f472219c;
        r106.getClass();
        a.a(r101, r100, r104, r107);
        a.b(r101, r100, this.f472219c);
        return;
    L11:
        r103 = false;
        goto L12
    L21:
        return;
    }

    public final boolean remove(T r100) {
        T[] r101 = this.f472217a;
        if (r101 == null) goto L11;
        int r102 = this.f472218b;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (Intrinsics.areEqual(r101[r103], r100) == true) goto L12;
        r103 = r103 + 1;
    L12:
        if (r103 != (-1)) goto L14;
        return false;
    L14:
        a(r103);
        return true;
    L11:
        r103 = -1;
        goto L12
    }
}
