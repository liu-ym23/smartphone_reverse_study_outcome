package nuc;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class i1<K, V> extends y0<K, V, Map.Entry<? extends K, ? extends V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final luc.i f520707c;

    public static final class a<K, V> implements Map.Entry<K, V>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f520708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f520709b;

        @Override // java.util.Map.Entry
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f520708a, r101.f520708a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f520709b, r101.f520709b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K r100 = this.f520708a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            V r104 = this.f520709b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        @Override // java.util.Map.Entry
        public final V setValue(V r100) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final String toString() {
            return "MapEntry(key=" + this.f520708a + ", value=" + this.f520709b + ')';
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f520708a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f520709b;
        }

        public a(K r100, V r101) {
            this.f520708a = r100;
            this.f520709b = r101;
        }
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520707c;
    }

    @Override // nuc.y0
    public final Object a(Object r100) {
        Map.Entry r101 = (Map.Entry) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.getKey();
    }

    @Override // nuc.y0
    public final Object b(Object r100) {
        Map.Entry r101 = (Map.Entry) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.getValue();
    }

    public i1(final juc.d<K> r100, final juc.d<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "keySerializer");
        Intrinsics.checkNotNullParameter(r101, "valueSerializer");
        super(r100, r101);
        this.f520707c = luc.n.e("kotlin.collections.Map.Entry", luc.p.c.f510879a, new luc.f[0], new h1(r100, r101));
    }

    @Override // nuc.y0
    public final Object c(Object r100, Object r101) {
        return new a(r100, r101);
    }
}
