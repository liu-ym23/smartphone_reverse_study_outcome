package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class e0 extends d0<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterable[] f275461b;

    public class a extends com.google.common.collect.a<Iterator<Object>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e0 f275462c;

        @Override // com.google.common.collect.a
        public final Iterator<Object> a(int r100) {
            return this.f275462c.f275461b[r100].iterator();
        }

        public a(e0 r100, int r101) {
            this.f275462c = r100;
            super(r101, 0);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        return new Iterators.c(new a(this, this.f275461b.length));
    }

    public e0(Iterable[] r100) {
        this.f275461b = r100;
    }
}
