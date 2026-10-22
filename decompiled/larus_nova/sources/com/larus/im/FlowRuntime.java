package com.larus.im;

import com.flow.kmp.common.platform.PlatformLoggerLevel;
import com.flow.kmp.common.util.CoroutineExtKt;
import gd9.a0;
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
import ouc.d0;

/* JADX INFO: loaded from: classes.dex */
public final class FlowRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile q f346398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final buc.a f346399b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f346400c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Runnable> f346401d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f346402e = null;

    public static final class a implements q {

        /* JADX INFO: renamed from: com.larus.im.FlowRuntime$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes29.dex */
        public static final class C4333a implements gd9.h {
            public C4333a() {
            }

            @Override // gd9.h
            public final void d(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "tag");
            }

            @Override // gd9.h
            public final void e(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "tag");
            }

            @Override // gd9.h
            public final void e(String r100, String r101, Throwable r102) {
                Intrinsics.checkNotNullParameter(r100, "tag");
            }

            @Override // gd9.h
            public final void i(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "tag");
            }

            @Override // gd9.h
            public final void v(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "tag");
            }

            @Override // gd9.h
            public final void w(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "tag");
            }

            @Override // gd9.h
            public final void w(String r100, String r101, Throwable r102) {
                Intrinsics.checkNotNullParameter(r100, "tag");
            }
        }

        /* JADX INFO: loaded from: classes29.dex */
        public static final class b implements a0 {
            public b() {
            }

            @Override // gd9.a0
            public final void a(String r100, d0 r101) {
                Intrinsics.checkNotNullParameter(r100, "event");
            }

            @Override // gd9.a0
            public final void b(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "tag");
                Intrinsics.checkNotNullParameter(r101, "param");
            }
        }

        public a() {
        }

        @Override // gd9.q
        public final gd9.l a() {
            q r100 = FlowRuntime.f346398a;
            Intrinsics.checkNotNull(r100);
            return r100.a();
        }

        @Override // gd9.q
        public final y b() {
            q r100 = FlowRuntime.f346398a;
            Intrinsics.checkNotNull(r100);
            return r100.b();
        }

        @Override // gd9.q
        public final v c() {
            q r100 = FlowRuntime.f346398a;
            Intrinsics.checkNotNull(r100);
            return r100.c();
        }

        @Override // gd9.q
        public final a0 d() {
            q r100 = FlowRuntime.f346398a;
            if (r100 == null) goto L7;
            a0 r101 = r100.d();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new b();
        }

        @Override // gd9.q
        public final gd9.h e() {
            q r100 = FlowRuntime.f346398a;
            if (r100 == null) goto L7;
            gd9.h r101 = r100.e();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new C4333a();
        }

        @Override // gd9.q
        public final w f() {
            q r100 = FlowRuntime.f346398a;
            Intrinsics.checkNotNull(r100);
            return r100.f();
        }

        @Override // gd9.q
        public final gd9.g g() {
            q r100 = FlowRuntime.f346398a;
            if (r100 == null) goto L7;
            gd9.g r101 = r100.g();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return gd9.c.f480956a;
        }

        @Override // gd9.q
        public final p h() {
            q r100 = FlowRuntime.f346398a;
            Intrinsics.checkNotNull(r100);
            return r100.h();
        }

        @Override // gd9.q
        public final z i() {
            q r100 = FlowRuntime.f346398a;
            Intrinsics.checkNotNull(r100);
            return r100.i();
        }
    }

    static {
        f346399b = buc.b.a(false);
        f346400c = new ReentrantLock();
        f346401d = new ArrayList();
        f346402e = new a();
    }

    public static a b() {
        if (f346399b.c() == true) goto L6;
        wt7.c r100 = wt7.a.f561230a;
        wt7.b.a(PlatformLoggerLevel.ERROR, "FlowRuntime", "not init runtime");
    L6:
        return f346402e;
    }

    public static boolean d() {
        ReentrantLock r100 = f346400c;
        r100.lock();
        boolean r101 = f346399b.c();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public static gd9.l a() {
        return b().a();
    }

    public static void c(q r100) {
        Intrinsics.checkNotNullParameter(r100, "depend");
        ReentrantLock r101 = f346400c;
        r101.lock();
    L13:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if (f346399b.a(false, true) == false) goto L6;
        f346398a = r100;     // Catch: Throwable -> L13
        CoroutineExtKt.a(new FlowRuntime$init$1$1(null));     // Catch: Throwable -> L13
    L11:
        r101.unlock();
        return;
    L6:
        q r102 = f346398a;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        gd9.h r103 = r102.e();     // Catch: Throwable -> L13
        if (r103 == null) goto L11;
        r103.e("FlowRuntime", "has already init");     // Catch: Throwable -> L13
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        goto L11
    }

    public static void e(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ReentrantLock r101 = f346400c;
        r101.lock();
    L9:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if (f346399b.c() == true) goto L6;
        ((ArrayList) f346401d).add(r100);     // Catch: Throwable -> L9
    L6:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r101.unlock();
    }
}
