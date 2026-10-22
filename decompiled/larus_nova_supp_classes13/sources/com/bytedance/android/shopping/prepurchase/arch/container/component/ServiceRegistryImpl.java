package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ServiceRegistryImpl implements j {
    public final ConcurrentHashMap<Class<?>, Object> a;
    public final List<f> b;
    public final ConcurrentHashMap<Class<?>, CompletableDeferred<?>> c;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.function.Function
        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Class) r2, "it");
            return CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
    }

    public ServiceRegistryImpl() {
        this.a = new ConcurrentHashMap();
        this.b = new ArrayList();
        this.c = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void a(f r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        List<f> r0 = this.b;
        monitor-enter(r0);
        ((ArrayList) this.b).remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void b(final T r4) {
        Intrinsics.checkNotNullParameter(r4, "inst");
        ConcurrentHashMap<Class<?>, Object> r0 = this.a;
        Function1<Map.Entry<? extends Class<?>, ? extends Object>, Boolean> r1 = new ServiceRegistryImpl$unregisterService$1(r4);
        CollectionsKt.removeAll(r0.entrySet(), r1);
        List<f> r2 = this.b;
        monitor-enter(r2);
        Iterator<T> r3 = this.b.iterator();     // Catch: Throwable -> L11
    L6:
        if (r3.hasNext() == false) goto L8;
        ((f) r3.next()).a(r4);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r2);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void c(f r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        List<f> r0 = this.b;
        monitor-enter(r0);
        ((ArrayList) this.b).add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T getService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        Object r3 = this.a.get(r2);
        if ((r3 instanceof com.bytedance.android.shopping.prepurchase.arch.container.ability.a) == true) goto L6;
        r3 = null;
    L6:
        return (T) r3;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final j d(String r2, Function0<? extends List<? extends Class<?>>> r3) {
        Intrinsics.checkNotNullParameter(r2, "componentName");
        Intrinsics.checkNotNullParameter(r3, "block");
        return new ServiceRegistryDelegate(this, r3, r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> Object e(Class<T> r5, Continuation<? super T> r6) {
        if ((r6 instanceof ServiceRegistryImpl$awaitServiceAvailable$1) == false) goto L7;
        ServiceRegistryImpl$awaitServiceAvailable$1 r0 = (ServiceRegistryImpl$awaitServiceAvailable$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L31:
        if (r7 == null) goto L35;
        return (com.bytedance.android.shopping.prepurchase.arch.container.ability.a) r7;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r8 = getService(r5);
        if (r8 == null) goto L17;
        return r8;
    L17:
        monitor-enter(r5);
    L36:
        th = move-exception;
        throw th;
    L19:
        if (Build.VERSION.SDK_INT < 24) goto L21;
        CompletableDeferred<?> r9 = this.c.computeIfAbsent(r5, a.a);     // Catch: Throwable -> L36
    L27:
        monitor-exit(r5);
        r0.label = 1;
        r7 = r9.await(r0);
        if (r7 != r2) goto L31;
        return r2;
    L21:
        r9 = this.c.get(r5);     // Catch: Throwable -> L36
        if (r9 != null) goto L27;
        r9 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L36
        CompletableDeferred<?> r4 = this.c.putIfAbsent(r5, r9);     // Catch: Throwable -> L36
        if (r4 == null) goto L27;
        r9 = r4;
    L7:
        r0 = new ServiceRegistryImpl$awaitServiceAvailable$1(this, r6);
        goto L8
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void f(Class<T> r3, T r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Intrinsics.checkNotNullParameter(r4, "inst");
        CompletableDeferred<?> r0 = null;
        if (r5 == false) goto L5;
        this.a.put(r3, r4);
    L11:
        monitor-enter(r3);
        CompletableDeferred<?> r6 = this.c.remove(r3);     // Catch: Throwable -> L21
        if ((r6 instanceof CompletableDeferred) == false) goto L16;
        r0 = r6;
    L16:
        CompletableDeferred<?> r1 = r0;     // Catch: Throwable -> L21
        if (r1 == null) goto L19;
        r1.complete(r4);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r3);
        return;
    L21:
        th = move-exception;
        throw th;
    L5:
        Object r7 = this.a.putIfAbsent(r3, r4);
        if ((r7 instanceof com.bytedance.android.shopping.prepurchase.arch.container.ability.a) == true) goto L8;
        r7 = null;
    L8:
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r8 = (com.bytedance.android.shopping.prepurchase.arch.container.ability.a) r7;
        if (r8 == null) goto L11;
        r4 = (T) r8;
        goto L11
    }
}
