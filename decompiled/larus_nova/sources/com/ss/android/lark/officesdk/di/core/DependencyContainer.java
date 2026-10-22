package com.ss.android.lark.officesdk.di.core;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class DependencyContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DependencyContainer f433166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f433167b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f433168c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.di.core.a f433169a;

        public a(com.ss.android.lark.officesdk.di.core.a r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f433169a = r100;
        }

        public final void a(Class r100, Class r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "providerClass");
            com.ss.android.lark.officesdk.di.core.a r102 = this.f433169a;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "providerClass");
            ReentrantReadWriteLock.ReadLock r103 = r102.f433176e.readLock();
            r103.lock();
            if (((com.ss.android.lark.officesdk.di.core.a.C5151a) ((LinkedHashMap) r102.f433173b).get(r100)) == null) goto L6;
            r103.unlock();
            return;
        L6:
            r103.unlock();
            ReentrantReadWriteLock.WriteLock r104 = r102.f433176e.writeLock();
            r104.lock();
            r102.f433173b.put(r100, new com.ss.android.lark.officesdk.di.core.a.C5151a(r101));     // Catch: Throwable -> L10
            r104.unlock();
            return;
        L10:
            th = move-exception;
            r104.unlock();
            throw th;
        L13:
            th = move-exception;
            r103.unlock();
            throw th;
        }
    }

    public DependencyContainer() {
    }

    static {
        f433166a = new DependencyContainer();
        f433167b = LazyKt.lazy(DependencyContainer$globalDependencyContext$2.INSTANCE);
        f433168c = LazyKt.lazy(DependencyContainer$bizDependencyContexts$2.INSTANCE);
    }

    public static b a(Class r100, DependencyContextUniqueId r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r101 == null) goto L9;
        com.ss.android.lark.officesdk.di.core.a r102 = (com.ss.android.lark.officesdk.di.core.a) ((Map) f433168c.getValue()).get(r101);
        if (r102 == null) goto L9;
        return r102.a(r100);
    L9:
        return ((com.ss.android.lark.officesdk.di.core.a) f433167b.getValue()).a(r100);
    }

    public final void b(DependencyContextUniqueId r100, Function1<? super a, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "init");
        if (r100 != null) goto L5;
        com.ss.android.lark.officesdk.di.core.a r102 = (com.ss.android.lark.officesdk.di.core.a) f433167b.getValue();
    L22:
        r101.invoke(new a(r102));
        return;
    L5:
        if (r100 == DependencyContextUniqueId.Global) goto L20;
        Lazy r103 = f433168c;
        r102 = (com.ss.android.lark.officesdk.di.core.a) ((Map) r103.getValue()).get(r100);
        if (r102 != null) goto L22;
        monitor-enter(this);
        Map r104 = (Map) r103.getValue();     // Catch: Throwable -> L16
        Object r105 = r104.get(r100);     // Catch: Throwable -> L16
        if (r105 != null) goto L13;
        r105 = new com.ss.android.lark.officesdk.di.core.a(r100, (com.ss.android.lark.officesdk.di.core.a) f433167b.getValue());     // Catch: Throwable -> L16
        r104.put(r100, r105);     // Catch: Throwable -> L16
    L13:
        r102 = (com.ss.android.lark.officesdk.di.core.a) r105;     // Catch: Throwable -> L16
        monitor-exit(this);
    L16:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalArgumentException("Global context cannot be created");
    }
}
