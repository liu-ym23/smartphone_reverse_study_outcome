package com.ss.android.lark.passportc.convention;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Provider<T> f438126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f438127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<C5239b, c<T>> f438128c;

    public static final class a<T> implements Provider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T f438129a;

        public a(T r100) {
            this.f438129a = r100;
        }

        @Override // javax.inject.Provider
        public final T get() {
            return this.f438129a;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passportc.convention.b$b, reason: collision with other inner class name */
    public static final class C5239b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<?> f438130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f438131b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5239b) == true) goto L8;
            return false;
        L8:
            C5239b r101 = (C5239b) r100;
            if (Intrinsics.areEqual(this.f438130a, r101.f438130a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f438131b, r101.f438131b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f438130a.hashCode() * 31) + this.f438131b.hashCode();
        }

        public final String toString() {
            return "ObserverKey(type=" + this.f438130a + ", observer=" + this.f438131b + ')';
        }

        public final Class<?> getType() {
            return this.f438130a;
        }

        public C5239b(Class<?> r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "observer");
            this.f438130a = r100;
            this.f438131b = r101;
        }
    }

    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<T, Unit> f438132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<T, Unit> f438133b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f438132a, r101.f438132a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f438133b, r101.f438133b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f438132a.hashCode() * 31) + this.f438133b.hashCode();
        }

        public final String toString() {
            return "ObserverPayload(doObserve=" + this.f438132a + ", undoObserve=" + this.f438133b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super T, Unit> r100, Function1<? super T, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "doObserve");
            Intrinsics.checkNotNullParameter(r101, "undoObserve");
            this.f438132a = r100;
            this.f438133b = r101;
        }
    }

    public static final class d implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<T> f438134a;

        public d(b<T> r100) {
            this.f438134a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
            if (Intrinsics.areEqual(r101.getDeclaringClass(), Object.class) == false) goto L7;
            if (r102 == null) goto L12;
            return r101.invoke(this, Arrays.copyOf(r102, r102.length));
        L12:
            return r101.invoke(this, new Object[0]);
        L7:
            if (r102 == null) goto L10;
            return r101.invoke(this.f438134a.c(), Arrays.copyOf(r102, r102.length));
        L10:
            return r101.invoke(this.f438134a.c(), new Object[0]);
        }
    }

    public static final class e<T> implements Provider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T f438135a;

        public e(T r100) {
            this.f438135a = r100;
        }

        @Override // javax.inject.Provider
        public final T get() {
            return this.f438135a;
        }
    }

    public b() {
        throw null;
    }

    public final T b() {
        d r100 = new d(this);
        return (T) Proxy.newProxyInstance(this.f438127b.getClassLoader(), new Class[]{this.f438127b}, r100);
    }

    public final T c() {
        return this.f438126a.get();
    }

    public final void d(C5239b r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        monitor-enter(this);
        c<T> r101 = this.f438128c.remove(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.f438133b.invoke(c());     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void e(T r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (Intrinsics.areEqual(this.f438126a.get(), r100) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<T> r101 = ((LinkedHashMap) this.f438128c).values().iterator();     // Catch: Throwable -> L18
    L9:
        if (r101.hasNext() == false) goto L11;
        ((c) r101.next()).f438133b.invoke(this.f438126a.get());     // Catch: Throwable -> L18
        goto L9
    L11:
        this.f438126a = new e(r100);     // Catch: Throwable -> L18
        Iterator<T> r102 = ((LinkedHashMap) this.f438128c).values().iterator();     // Catch: Throwable -> L18
    L13:
        if (r102.hasNext() == false) goto L15;
        ((c) r102.next()).f438132a.invoke(this.f438126a.get());     // Catch: Throwable -> L18
        goto L13
    L15:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
    }

    public b(T r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        a r102 = new a(r100);
        Intrinsics.checkNotNullParameter(r102, "instance");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        this.f438126a = r102;
        this.f438127b = r101;
        this.f438128c = new LinkedHashMap();
    }

    public final void a(C5239b r100, c<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f438128c.containsKey(r100) == true) goto L7;
        this.f438128c.put(r100, r101);     // Catch: Throwable -> L10
        r101.f438132a.invoke(c());     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
