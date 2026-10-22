package com.google.common.collect;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class z0 extends d0<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterable f275548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f275549c;

    public class a implements Iterator<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f275550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f275551b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f275551b.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public final Object next() {
            Object r100 = this.f275551b.next();
            this.f275550a = false;
            return r100;
        }

        @Override // java.util.Iterator
        public final void remove() {
            o.e(!this.f275550a);
            this.f275551b.remove();
        }

        public a(Iterator r100) {
            this.f275551b = r100;
            this.f275550a = true;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        Iterable r100 = this.f275548b;
        if ((r100 instanceof List) == false) goto L6;
        List r101 = (List) r100;
        return r101.subList(Math.min(r101.size(), this.f275549c), r101.size()).iterator();
    L6:
        Iterator r102 = r100.iterator();
        int r103 = this.f275549c;
        r102.getClass();
        int r104 = 0;
        if (r103 < 0) goto L9;
        boolean r105 = true;
    L10:
        com.google.common.base.m.c(r105, "numberToAdvance must be nonnegative");
    L11:
        if (r104 >= r103) goto L16;
        if (r102.hasNext() == false) goto L16;
        r102.next();
        r104 = r104 + 1;
    L16:
        return new a(r102);
    L9:
        r105 = false;
        goto L10
    }

    public z0(Iterable r100, int r101) {
        this.f275548b = r100;
        this.f275549c = r101;
    }
}
