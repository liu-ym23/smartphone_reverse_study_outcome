package com.ss.android.lark.contact.base.service;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.r0;
import com.ss.android.lark.utils.s0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418914a = 0;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.contact.base.service.c0$a$a, reason: collision with other inner class name */
        public static final class C4929a extends s0.c<z8b.a> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ ApiUtils.a<z8b.a> f418915j;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ss.android.lark.utils.s0.c
            public final z8b.a c() {
                final s0.b r100 = new s0.b();
                int r101 = c0.f418914a;
                a0.g(true);
                int r102 = d.f418917a;
                d.b(new InviteExternalService$Companion$getInvitationInfo$1(r100));
                if (r100.f444767b.get() == true) goto L9;
                r100.f444766a.await();     // Catch: InterruptedException -> L6
            L6:
                e = move-exception;
                e.printStackTrace();
            L9:
                return (z8b.a) r100.f444768c;
            }

            public C4929a(ApiUtils.a<z8b.a> r100) {
                this.f418915j = r100;
            }

            @Override // com.ss.android.lark.utils.s0.c
            public final void d(z8b.a r100) {
                ApiUtils.a<z8b.a> r101 = this.f418915j;
                r101.consume(r100);
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ApiUtils.a<z8b.a> f418916a;

            public b(ApiUtils.a<z8b.a> r100) {
                this.f418916a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f418916a.consume(null);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @JvmStatic
        public static void a(Context r100, ApiUtils.a r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "consumer");
            C4929a r102 = new C4929a(r101);
            b r103 = new b(r101);
            r102.f444775g = 10000;
            r102.f444776h = r103;
            ViewUtils.runOnUiThread(new r0(r100, r102));
        }
    }

    static {
    }
}
