package com.google.common.collect;

import com.google.common.base.Optional;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class d0<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Optional<Iterable<E>> f275453a;

    public class a extends d0<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f275454b;

        @Override // java.lang.Iterable
        public final Iterator<E> iterator() {
            return this.f275454b.iterator();
        }

        public a(Iterable r100, Iterable r101) {
            this.f275454b = r101;
            super(r100);
        }
    }

    public final Iterable<E> d() {
        return this.f275453a.or(this);
    }

    public d0() {
        this.f275453a = Optional.absent();
    }

    public final String toString() {
        Iterator<E> r100 = d().iterator();
        StringBuilder r101 = new StringBuilder("[");
        boolean r102 = true;
    L4:
        if (r100.hasNext() == false) goto L8;
        if (r102 == true) goto L7;
        r101.append(", ");
    L7:
        r101.append(r100.next());
        r102 = false;
        goto L4
    L8:
        r101.append(']');
        return r101.toString();
    }

    public d0(Iterable<E> r100) {
        this.f275453a = Optional.of(r100);
    }

    public static <E> d0<E> c(Iterable<E> r100) {
        if ((r100 instanceof d0) == false) goto L6;
        return (d0) r100;
    L6:
        return new a(r100, r100);
    }

    public final d0<E> a(com.google.common.base.n<? super E> r100) {
        Iterable<E> r101 = d();
        r101.getClass();
        r100.getClass();
        return c(new x0(r101, r100));
    }

    public static <E> d0<E> e(@ParametricNullness E r100, E... r101) {
        return c(new Lists.OnePlusArrayList(r100, r101));
    }
}
