package nuc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class o0<K, V> extends k1<K, V, Map<K, ? extends V>, HashMap<K, V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f520744c;

    @Override // nuc.a
    public final Object a() {
        return new HashMap();
    }

    @Override // nuc.k1, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520744c;
    }

    @Override // nuc.a
    public final int b(Object r100) {
        HashMap r101 = (HashMap) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.size() * 2;
    }

    @Override // nuc.a
    public final Iterator d(Object r100) {
        Map r101 = (Map) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.entrySet().iterator();
    }

    @Override // nuc.a
    public final int e(Object r100) {
        Map r101 = (Map) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.size();
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new HashMap(null);
    }

    @Override // nuc.a
    public final Object j(Object r100) {
        HashMap r101 = (HashMap) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101;
    }

    public o0(juc.d<K> r100, juc.d<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "kSerializer");
        Intrinsics.checkNotNullParameter(r101, "vSerializer");
        super(r100, r101);
        this.f520744c = new n0(r100.getDescriptor(), r101.getDescriptor());
    }

    @Override // nuc.a
    public final void c(Object r100, int r101) {
        Intrinsics.checkNotNullParameter((HashMap) r100, "<this>");
    }
}
