package com.bytedance.ee.bear.drive.biz.cache;

import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.config.strategy.j;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a, reason: collision with other inner class name */
    public static final class C0118a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a$a, reason: collision with other inner class name */
        public static final class C0119a<T> implements Consumer {
            public static final C0119a<T> a = null;

            static {
                a = new C0119a();
            }

            public C0119a() {
            }

            public final void accept(Object r6) {
                com.bytedance.ee.bear.drive.services.c r7 = (com.bytedance.ee.bear.drive.services.c) r6;
                tt5.a.h("CacheUtils", "removeAllWithManualCache start");
                tt5.a.h("CacheUtils", "retCleanable = " + r7.h1() + ", retManual=" + r7.d5(2));
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a$b */
        public static final class b<T> implements Consumer {
            public static final b<T> a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                com.bytedance.ee.bear.drive.services.c r2 = (com.bytedance.ee.bear.drive.services.c) r1;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a$c */
        public static final class c<T> implements Consumer {
            public static final c<T> a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final void accept(Object r3) {
                tt5.a.f("CacheUtils", (Throwable) r3, false);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a$d */
        public static final class d<T> implements Consumer {
            public final /* synthetic */ Runnable a;

            public d(Runnable r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Boolean r2 = (Boolean) r1;
                Runnable r3 = this.a;
                if (r3 == null) goto L6;
                r3.run();
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a$e */
        public static final class e<T> implements Consumer {
            public final /* synthetic */ Runnable a;

            public e(Runnable r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                Throwable r5 = (Throwable) r4;
                Runnable r0 = this.a;
                if (r0 == null) goto L5;
                r0.run();
            L5:
                tt5.a.e("CacheUtils", "removeCache() error", r5, false);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a$f */
        public static final class f<T> implements Consumer {
            public static final f<T> a = null;

            static {
                a = new f();
            }

            public f() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Boolean r2 = (Boolean) r1;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.cache.a$a$g */
        public static final class g<T> implements Consumer {
            public static final g<T> a = null;

            static {
                a = new g();
            }

            public g() {
            }

            public final void accept(Object r3) {
                tt5.a.f("DriveComponent", (Throwable) r3, false);
            }
        }

        public static void a() {
            Flowable.just(org.koin.java.a.c(com.bytedance.ee.bear.drive.services.c.class, null, null, 6)).observeOn(fo5.d.b()).doOnNext(C0119a.a).subscribe(b.a, c.a);
        }

        public C0118a() {
        }

        @JvmStatic
        public static void c(w75.a r3, a95.a r4) {
            Intrinsics.checkNotNullParameter(r3, "fileModel");
            Intrinsics.checkNotNullParameter(r4, "driveUserComponentAbility");
            tt5.a.h("DriveComponent", "start save wps fileInfo cache");
            w75.c r0 = f85.c.a(r3);
            v85.c.a r1 = new v85.c.a();
            r1.a = 0;
            r1.b = t.d(r0);
            r1.c = r3.c().a;
            r1.d = r3.c().b;
            r1.c(r3.a());
            r1.d(r3.b());
            r1.g = r3.r;
            r1.h = r0.h();
            r1.i = r3.c().k;
            r1.j = r3.f;
            r1.k = r0.getExtra();
            r1.l = DiagramData$RESULT.SUCCESS;
            r1.n = r3.c().g;
            r1.o = r3.e();
            v85.c r5 = new v85.c(r1);
            t.l().m(r5, r4.b).subscribeOn(fo5.d.b()).subscribe(f.a, g.a);
        }

        @JvmStatic
        public static Disposable b(DriveViewModel r3, Runnable r4, a95.a r5) {
            Intrinsics.checkNotNullParameter(r3, "viewModel");
            Intrinsics.checkNotNullParameter(r5, "userComponentAbility");
            com.bytedance.ee.bear.drive.config.strategy.d r0 = j.b(r3);
            String r1 = r3.getOpenEntity().getFileId();
            w75.c r2 = r3.getIFileModel();
            if (r2 == null) goto L5;
            String r6 = r2.h();
        L6:
            String r7 = r0.i(r3.getFileModel());
            o75.b.a().getCacheManager().getClass();
            return t.p(r7, r1, r6, r5).subscribe(new d(r4), new e(r4));
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
        new C0118a();
    }
}
