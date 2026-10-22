package com.ss.android.lark.chatbase.model;

import java.util.List;
import x4b.d;

/* JADX INFO: loaded from: classes35.dex */
public abstract class c<K, T, PageData, L extends List<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f416890a;

    public static class a<T> implements hya.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f416891a;

        public a(T r100) {
            this.f416891a = r100;
        }
    }

    public static abstract class b<T> implements hya.a<T> {
        public b() {
        }

        public abstract f5b.b b(Object r100);

        @Override // hya.a
        public final T a(T r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            return (T) b(r100);
        }
    }

    public abstract void b(x4b.a r100);

    public abstract L d();

    public abstract void e(x4b.a r100);

    public abstract void f(x4b.a r100);

    public final void c() {
        this.f416890a.f();
    }

    public c(d r100) {
        this.f416890a = r100;
    }
}
