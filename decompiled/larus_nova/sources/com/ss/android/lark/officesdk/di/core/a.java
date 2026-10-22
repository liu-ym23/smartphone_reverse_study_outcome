package com.ss.android.lark.officesdk.di.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f433172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends b>, C5151a> f433173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<? extends b>, Object> f433174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends c<?>>, c<?>> f433175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantReadWriteLock f433176e;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.di.core.a$a, reason: collision with other inner class name */
    public static final class C5151a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends c<?>> f433177a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5151a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f433177a, ((C5151a) r100).f433177a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f433177a.hashCode();
        }

        public final String toString() {
            return "ProviderInfo(providerClass=" + this.f433177a + ')';
        }

        public C5151a(Class<? extends c<?>> r100) {
            Intrinsics.checkNotNullParameter(r100, "providerClass");
            this.f433177a = r100;
        }
    }

    public final <T extends b> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        ReentrantReadWriteLock.ReadLock r101 = this.f433176e.readLock();
        r101.lock();
    L44:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if (((C5151a) ((LinkedHashMap) this.f433173b).get(r100)) == null) goto L13;
        Object r102 = ((LinkedHashMap) this.f433174c).get(r100);     // Catch: Throwable -> L44
        if ((r102 instanceof b) == false) goto L9;
        T r103 = (T) r102;     // Catch: Throwable -> L44
    L10:
        if (r103 == null) goto L13;
        r101.unlock();
        return r103;
    L9:
        r103 = null;
    L13:
        r101.unlock();
        ReentrantReadWriteLock.WriteLock r104 = this.f433176e.writeLock();
        r104.lock();
        Object r105 = ((LinkedHashMap) this.f433174c).get(r100);     // Catch: Throwable -> L41
        if ((r105 instanceof b) == false) goto L18;
        T r106 = (T) r105;     // Catch: Throwable -> L41
    L19:
        if (r106 == null) goto L22;
        r104.unlock();
        return r106;
    L22:
        C5151a r107 = (C5151a) ((LinkedHashMap) this.f433173b).get(r100);     // Catch: Throwable -> L41
        if (r107 == null) goto L37;
        Class<? extends c<?>> r108 = r107.f433177a;     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type java.lang.Class<out com.ss.android.lark.officesdk.di.core.IDependencyProvider<T of com.ss.android.lark.officesdk.di.core.DependencyContext.getDependency>>");     // Catch: Throwable -> L41
        Object r109 = ((LinkedHashMap) this.f433175d).get(r108);     // Catch: Throwable -> L41
        if ((r109 instanceof c) == false) goto L27;
        c<?> r110 = (c) r109;     // Catch: Throwable -> L41
    L28:
        if (r110 != null) goto L30;
        r110 = r108.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L41
        this.f433175d.put(r108, r110);     // Catch: Throwable -> L41
    L30:
        if (r110 == null) goto L32;
        T r111 = (T) r110.create();
    L33:
        if (r111 == null) goto L37;
        this.f433174c.put((Class<? extends b>) r100, r111);     // Catch: Throwable -> L41
        r104.unlock();
        return r111;
    L32:
        r111 = null;
        goto L33
    L27:
        r110 = null;
    L37:
        r104.unlock();
        a r112 = this.f433172a;
        if (r112 != null) goto L40;
        return null;
    L40:
        return (T) r112.a(r100);
    L18:
        r106 = null;
    L41:
        th = move-exception;
        r104.unlock();
        throw th;
    }

    public a(DependencyContextUniqueId r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        this.f433172a = r101;
        this.f433173b = new LinkedHashMap();
        this.f433174c = new LinkedHashMap();
        this.f433175d = new LinkedHashMap();
        this.f433176e = new ReentrantReadWriteLock();
    }
}
