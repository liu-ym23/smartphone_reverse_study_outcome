package nuc;

import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class q0<E> extends w<E, Set<? extends E>, HashSet<E>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f520758b;

    @Override // nuc.a
    public final Object a() {
        return new HashSet();
    }

    @Override // nuc.v, juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return this.f520758b;
    }

    public q0(juc.d<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "eSerializer");
        super(r100);
        this.f520758b = new p0(r100.getDescriptor());
    }

    @Override // nuc.a
    public final int b(Object r100) {
        HashSet r101 = (HashSet) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.size();
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new HashSet(null);
    }

    @Override // nuc.a
    public final Object j(Object r100) {
        HashSet r101 = (HashSet) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101;
    }

    @Override // nuc.a
    public final void c(Object r100, int r101) {
        Intrinsics.checkNotNullParameter((HashSet) r100, "<this>");
    }

    public void insert(HashSet<E> r100, int r101, E r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.add(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nuc.v
    public /* bridge */ /* synthetic */ void insert(Object r100, int r101, Object r102) {
        insert((HashSet) r100, r101, r102);
    }
}
