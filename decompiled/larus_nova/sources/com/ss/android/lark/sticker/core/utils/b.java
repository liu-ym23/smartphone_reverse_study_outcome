package com.ss.android.lark.sticker.core.utils;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.statistics.Statistics;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.a0;
import z5c.k3;
import z5c.l3;
import z5c.s2;
import z5c.z;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f440837a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.utils.b$a$a, reason: collision with other inner class name */
        public static final class C5303a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5303a f440838a = null;

            static {
                f440838a = new C5303a();
            }

            public C5303a() {
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.utils.b$a$b, reason: collision with other inner class name */
        public static final class C5304b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5304b f440839a = null;

            static {
                f440839a = new C5304b();
            }

            public C5304b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f440840a = null;

            static {
                f440840a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.sticker.core.utils.b$b, reason: collision with other inner class name */
    public static final class RunnableC5305b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f440841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f440842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f440843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f440844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f440845e;

        public RunnableC5305b(int r100, a r101, long r102, int r103, String r104) {
            this.f440841a = r100;
            this.f440842b = r101;
            this.f440843c = r102;
            this.f440844d = r103;
            this.f440845e = r104;
        }

        public final void a() {
            int r100 = this.f440841a;
            a r101 = this.f440842b;
            long r102 = this.f440843c;
            int r103 = this.f440844d;
            String r104 = this.f440845e;
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
            s5c.a r106 = l3.f570247e.a(String.valueOf(r100));     // Catch: Throwable -> L18
            r101.getClass();     // Catch: Throwable -> L18
            if ((r101 instanceof a.C5303a) == false) goto L7;
            s5c.a r107 = k3.f570235c;     // Catch: Throwable -> L18
        L12:
            d r108 = d.b.b(r106, r107).plus(z.f570426c.a(String.valueOf(r102))).plus(a0.f570149c.a(String.valueOf(r103)));     // Catch: Throwable -> L18
            if (r104 == null) goto L15;
            r108 = r108.plus(s2.f570366c.a(r104));     // Catch: Throwable -> L18
        L15:
            Statistics.sendEvent("sticker_add_customized_sticker", r108.toJson());     // Catch: Throwable -> L18
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
            return;
        L7:
            if ((r101 instanceof a.C5304b) == false) goto L10;
            r107 = k3.f570236d;     // Catch: Throwable -> L18
            goto L12
        L10:
            if ((r101 instanceof a.c) == false) goto L17;
            r107 = k3.f570237e;     // Catch: Throwable -> L18
            goto L12
        L17:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public b() {
    }

    public static void a(a r100, int r110, long r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "source");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC5305b(r112, r100, r111, r110, r113));
    }
}
