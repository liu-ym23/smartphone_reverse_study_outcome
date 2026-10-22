package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: classes5.dex */
public class o1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0.b<p1<T>> f457886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f457887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f457888c;

    public void a() {
        this.f457887b = true;
    }

    public void b() {
    }

    public void j() {
        this.f457888c = true;
    }

    public o1() {
        this.f457886a = new a0.b(null);
    }

    public final void c(o1<T> r100) {
        p1<T> r101 = this.f457886a.f1239a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void e(o1<T> r100) {
        p1<T> r101 = this.f457886a.f1239a;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    public final void f(o1<T> r100) {
        p1<T> r101 = this.f457886a.f1239a;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    public final void i(o1<T> r100) {
        p1<T> r101 = this.f457886a.f1239a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public void d(o1<T> r100, ExceptionResult r101) {
        p1<T> r102 = this.f457886a.f1239a;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    public final void h(o1<T> r100, T r101) {
        p1<T> r102 = this.f457886a.f1239a;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    public final void g(y r100, int r101, long r102) {
        p1<T> r103 = this.f457886a.f1239a;
        if (r103 == null) goto L6;
        r103.d(r100, r101, r102);
        return;
    }
}
