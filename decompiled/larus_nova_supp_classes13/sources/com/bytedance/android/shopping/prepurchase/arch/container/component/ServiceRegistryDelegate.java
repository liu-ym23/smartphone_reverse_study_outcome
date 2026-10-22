package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.utils.j0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ServiceRegistryDelegate implements j {
    public final Lazy a;
    public final j b;
    public final Function0<List<Class<?>>> c;
    public final String d;

    public static boolean g(Class r1) {
        if (com.bytedance.android.shopping.prepurchase.arch.container.intf.j.class.isAssignableFrom(r1) == false) goto L5;
    L12:
        return true;
    L5:
        if (l.class.isAssignableFrom(r1) == true) goto L12;
        if (com.bytedance.android.shopping.prepurchase.arch.container.ability.i.class.isAssignableFrom(r1) == true) goto L12;
        if (com.bytedance.android.shopping.prepurchase.arch.container.ability.f.class.isAssignableFrom(r1) == true) goto L12;
        return false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.a(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void b(T r2) {
        Intrinsics.checkNotNullParameter(r2, "inst");
        this.b.b(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.c(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T getService(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "service");
        if (j0.a == false) goto L12;
        if (((List) this.a.getValue()).contains(r4) == true) goto L12;
        if (g(r4) == true) goto L12;
        throw new IllegalArgumentException("please register " + r4 + " to \"" + this.d + "#dependencies()\" function");
    L12:
        return (T) this.b.getService(r4);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final j d(String r2, Function0<? extends List<? extends Class<?>>> r3) {
        Intrinsics.checkNotNullParameter(r2, "componentName");
        Intrinsics.checkNotNullParameter(r3, "block");
        return this.b.d(r2, r3);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> Object e(Class<T> r3, Continuation<? super T> r4) {
        if (j0.a == false) goto L12;
        if (((List) this.a.getValue()).contains(r3) == true) goto L12;
        if (g(r3) == true) goto L12;
        throw new IllegalArgumentException("please register " + r3 + " to \"" + this.d + "#dependencies()\" function");
    L12:
        return this.b.e(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ServiceRegistryDelegate(j r2, Function0<? extends List<? extends Class<?>>> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "registry");
        Intrinsics.checkNotNullParameter(r3, "block");
        Intrinsics.checkNotNullParameter(r4, "componentName");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = LazyKt.lazy(new ServiceRegistryDelegate$dependencies$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void f(Class<T> r2, T r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "inst");
        this.b.f(r2, r3, r4);
    }
}
