package com.ss.android.lark.scaffold.internal;

import com.ss.android.lark.scaffold.Component;
import com.ss.android.lark.scaffold.PagePlugin;
import com.ss.android.lark.scaffold.internal.registry.ComponentRegistry;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l3c.d;
import l3c.e;
import l3c.g;
import l3c.h;
import l3c.j;
import l3c.k;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.scaffold.internal.registry.c f439752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentRegistry f439753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.scaffold.internal.registry.b f439754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.scaffold.internal.registry.a f439755d;

    @Override // l3c.j
    public final void a(Function1<? super d, ? extends l3c.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        c.a();
        this.f439753b.a(r100);
    }

    @Override // l3c.j
    public final void b(Function1<? super l3c.b, ? extends Component> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        c.a();
        ComponentRegistry r101 = this.f439753b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "block");
        r101.f439762e.add(new ComponentRegistry.e(r100));
    }

    @Override // l3c.j
    public final void d(Function1<? super h, ? extends List<? extends PagePlugin>> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        c.a();
        com.ss.android.lark.scaffold.internal.registry.b r101 = this.f439754c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "block");
        r101.f439771c.add(new com.ss.android.lark.scaffold.internal.registry.b.a.C5279a(r100));
    }

    @Override // l3c.j
    public final void f(Function1<? super d, ? extends List<? extends l3c.c>> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        c.a();
        ComponentRegistry r101 = this.f439753b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "block");
        r101.f439761d.add(r100);
    }

    @Override // l3c.j
    public final void c(int r100, Function1<? super l3c.b, ? extends Component> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        c.a();
        ComponentRegistry r102 = this.f439753b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "block");
        r102.f439762e.add(new ComponentRegistry.g(r100, r101));
    }

    @Override // l3c.j
    public final <T> void e(Class<T> r100, Function1<? super e, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "block");
        c.a();
        com.ss.android.lark.scaffold.internal.registry.a r102 = this.f439755d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "block");
        r102.f439767a.put(r100, r101);
    }

    @Override // l3c.j
    public final <T extends g> void g(Class<T> r100, Function1<? super k, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "block");
        c.a();
        com.ss.android.lark.scaffold.internal.registry.c r102 = this.f439752a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "block");
        r102.f439773a.put(r100, r101);
    }

    public b(com.ss.android.lark.scaffold.internal.registry.c r100, ComponentRegistry r101, com.ss.android.lark.scaffold.internal.registry.b r102, com.ss.android.lark.scaffold.internal.registry.a r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModelRegistry");
        Intrinsics.checkNotNullParameter(r101, "componentRegistry");
        Intrinsics.checkNotNullParameter(r102, "pluginRegistry");
        Intrinsics.checkNotNullParameter(r103, "dispatcherRegistry");
        this.f439752a = r100;
        this.f439753b = r101;
        this.f439754c = r102;
        this.f439755d = r103;
    }
}
