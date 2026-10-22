package com.ss.android.lark.keyboard.event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f429304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o.a f429305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends q>, Function2<g, ?, Unit>> f429306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends m>, Function3<g, ?, ?, Unit>> f429307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f<q> f429308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f<m> f429309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Function2<g, j, Boolean>> f429310g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final void a() {
        this.f429305b.dispose();
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final void b(Function2<? super g, ? super j, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f429310g).add(r100);
    }

    public p(Object r100, KeyboardEventCenter$handleFactory$1.a r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "disposable");
        this.f429304a = r100;
        this.f429305b = r101;
        this.f429306c = new ConcurrentHashMap();
        this.f429307d = new ConcurrentHashMap();
        this.f429308e = new f();
        this.f429309f = new f();
        this.f429310g = new ArrayList();
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final <E extends q> void c(Class<E> r100, Function2<? super g, ? super E, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f429308e.b(r100);
        this.f429306c.put(r100, r101);
    }

    @Override // com.ss.android.lark.keyboard.event.l
    public final <S extends m> void d(Class<S> r100, Function3<? super g, ? super S, ? super S, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f429309f.b(r100);
        this.f429307d.put(r100, r101);
    }
}
