package ktc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<K, V, L> extends ReferenceQueue<K> implements Runnable, Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<c<K>, V> f506166a;

    /* JADX INFO: renamed from: ktc.a$a, reason: collision with other inner class name */
    public class C6609a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<c<K>, V>> f506167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map.Entry<c<K>, V> f506168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public K f506169c;

        public final void a() {
        L3:
            if (this.f506167a.hasNext() == false) goto L7;
            Map.Entry<c<K>, V> r100 = this.f506167a.next();
            this.f506168b = r100;
            K r101 = r100.getKey().get();
            this.f506169c = r101;
            if (r101 == null) goto L3;
            return;
        L7:
            this.f506168b = null;
            this.f506169c = null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f506169c == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            K r100 = this.f506169c;
            if (r100 == null) goto L11;
            b r101 = new b(r100, this.f506168b);     // Catch: Throwable -> L7
            a();
            return r101;
        L7:
            th = move-exception;
            a();
            throw th;
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public C6609a(a r100, Iterator r101) {
            this.f506167a = r101;
            a();
        }
    }

    public class b implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f506170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map.Entry<c<K>, V> f506171b;

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f506171b.getValue();
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f506170a;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r100) {
            if (r100 == null) goto L6;
            return this.f506171b.setValue(r100);
        L6:
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Object r100, Map.Entry r101) {
            this.f506170a = r100;
            this.f506171b = r101;
        }
    }

    public static final class c<K> extends WeakReference<K> {
        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return String.valueOf(get());
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof c) == false) goto L10;
            if (((c) r100).get() != get()) goto L7;
            return true;
        L7:
            return false;
        L10:
            return r100.equals(this);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C6609a(this, this.f506166a.entrySet().iterator());
    }

    public final String toString() {
        return this.f506166a.toString();
    }

    public a(ConcurrentMap<c<K>, V> r100) {
        this.f506166a = r100;
    }
}
