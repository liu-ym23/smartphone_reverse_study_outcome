package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import l76.d;
import o76.e;
import o76.f;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<e> f249898a;

    /* JADX INFO: renamed from: com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.a$a, reason: collision with other inner class name */
    public static final class C3560a {
    }

    static {
    }

    public final void c() {
        this.f249898a.clear();
    }

    @Override // o76.e
    public final boolean f() {
        Iterator<T> r100 = this.f249898a.iterator();
        boolean r101 = false;
    L4:
        if (r100.hasNext() == false) goto L12;
        e r102 = (e) r100.next();     // Catch: Exception -> L10
        if (r101 == true) goto L4;
        r101 = r102.f();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L12:
        return r101;
    }

    public a() {
        this.f249898a = new CopyOnWriteArrayList();
    }

    @Override // o76.e
    public final boolean a(n76.b r100) {
        Iterator<T> r101 = this.f249898a.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L12;
        e r103 = (e) r101.next();     // Catch: Exception -> L10
        if (r102 == true) goto L4;
        r102 = r103.a(r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L12:
        return r102;
    }

    @Override // o76.e
    public final boolean b(n76.b r100) {
        Iterator<T> r101 = this.f249898a.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L12;
        e r103 = (e) r101.next();     // Catch: Exception -> L10
        if (r102 == true) goto L4;
        r102 = r103.b(r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L12:
        return r102;
    }

    @Override // o76.e
    public final boolean d(n76.b r100) {
        Iterator<T> r101 = this.f249898a.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L12;
        e r103 = (e) r101.next();     // Catch: Exception -> L10
        if (r102 == true) goto L4;
        r102 = r103.d(r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L12:
        return r102;
    }

    @Override // o76.e
    public final boolean g(n76.b r100) {
        Iterator<T> r101 = this.f249898a.iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L12;
        e r103 = (e) r101.next();     // Catch: Exception -> L10
        if (r102 == true) goto L4;
        r102 = r103.g(r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L12:
        return r102;
    }

    @Override // o76.f
    public final void h(e r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f249898a.remove(r100);
    }

    @Override // o76.e
    public final k l(k r100) {
        Iterator<T> r101 = this.f249898a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        r100 = ((e) r101.next()).l(r100);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        d.f507797a.a("MusicPlayerOperationInterceptorDispatcher", e.getMessage());
        goto L4
    L10:
        return r100;
    }

    @Override // o76.f
    public final void m(e r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        if (this.f249898a.contains(r100) == true) goto L6;
        this.f249898a.add(r100);
        return;
    }
}
