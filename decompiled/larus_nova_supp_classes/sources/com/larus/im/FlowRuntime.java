package com.larus.im;

import com.flow.kmp.common.platform.PlatformLoggerLevel;
import com.flow.kmp.common.util.CoroutineExtKt;
import gd9.a0;
import gd9.c;
import gd9.g;
import gd9.h;
import gd9.l;
import gd9.p;
import gd9.q;
import gd9.v;
import gd9.w;
import gd9.y;
import gd9.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class FlowRuntime {
    public static volatile q a;
    public static final buc.a b = null;
    public static final ReentrantLock c = null;
    public static final List<Runnable> d = null;
    public static final a e = null;

    public static final class a implements q {
        public a() {
        }

        @Override // gd9.q
        public final l a() {
            q r0 = FlowRuntime.a;
            Intrinsics.checkNotNull(r0);
            return r0.a();
        }

        @Override // gd9.q
        public final y b() {
            q r0 = FlowRuntime.a;
            Intrinsics.checkNotNull(r0);
            return r0.b();
        }

        @Override // gd9.q
        public final v c() {
            q r0 = FlowRuntime.a;
            Intrinsics.checkNotNull(r0);
            return r0.c();
        }

        @Override // gd9.q
        public final a0 d() {
            q r0 = FlowRuntime.a;
            if (r0 == null) goto L7;
            a0 r1 = r0.d();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return new b();
        }

        @Override // gd9.q
        public final h e() {
            q r0 = FlowRuntime.a;
            if (r0 == null) goto L7;
            h r1 = r0.e();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return new a();
        }

        @Override // gd9.q
        public final w f() {
            q r0 = FlowRuntime.a;
            Intrinsics.checkNotNull(r0);
            return r0.f();
        }

        @Override // gd9.q
        public final g g() {
            q r0 = FlowRuntime.a;
            if (r0 == null) goto L7;
            g r1 = r0.g();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return c.a;
        }

        @Override // gd9.q
        public final p h() {
            q r0 = FlowRuntime.a;
            Intrinsics.checkNotNull(r0);
            return r0.h();
        }

        @Override // gd9.q
        public final z i() {
            q r0 = FlowRuntime.a;
            Intrinsics.checkNotNull(r0);
            return r0.i();
        }
    }

    static {
        b = buc.b.a(false);
        c = new ReentrantLock();
        d = new ArrayList();
        e = new a();
    }

    public static a b() {
        if (b.c() == true) goto L6;
        wt7.c r0 = wt7.a.a;
        wt7.b.a(PlatformLoggerLevel.ERROR, "FlowRuntime", "not init runtime");
    L6:
        return e;
    }

    public static boolean d() {
        ReentrantLock r0 = c;
        r0.lock();
        boolean r1 = b.c();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static l a() {
        return b().a();
    }

    public static void c(q r4) {
        Intrinsics.checkNotNullParameter(r4, "depend");
        ReentrantLock r0 = c;
        r0.lock();
    L13:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (b.a(false, true) == false) goto L6;
        a = r4;     // Catch: Throwable -> L13
        CoroutineExtKt.a(new FlowRuntime$init$1$1(null));     // Catch: Throwable -> L13
    L11:
        r0.unlock();
        return;
    L6:
        q r5 = a;     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        h r6 = r5.e();     // Catch: Throwable -> L13
        if (r6 == null) goto L11;
        r6.e("FlowRuntime", "has already init");     // Catch: Throwable -> L13
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L13
        goto L11
    }

    public static void e(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        ReentrantLock r0 = c;
        r0.lock();
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (b.c() == true) goto L6;
        ((ArrayList) d).add(r2);     // Catch: Throwable -> L9
    L6:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r0.unlock();
    }
}
