package nuc;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class w1<K, V> extends y0<K, V, Pair<? extends K, ? extends V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final luc.i f520794c;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520794c;
    }

    @Override // nuc.y0
    public final Object a(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.getFirst();
    }

    @Override // nuc.y0
    public final Object b(Object r100) {
        Pair r101 = (Pair) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.getSecond();
    }

    public w1(final juc.d<K> r100, final juc.d<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "keySerializer");
        Intrinsics.checkNotNullParameter(r101, "valueSerializer");
        super(r100, r101);
        this.f520794c = luc.n.c("kotlin.Pair", new luc.f[0], new v1(r100, r101));
    }

    @Override // nuc.y0
    public final Object c(Object r100, Object r101) {
        return TuplesKt.to(r100, r101);
    }
}
