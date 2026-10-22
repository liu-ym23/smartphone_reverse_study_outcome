package com.larus.home.impl.sdk;

import android.app.Application;
import android.content.Context;
import com.bytedance.ttcnpa.ITTCNPADepend;
import com.bytedance.ttcnpa.TTCNPA;
import com.bytedance.ttcnpa.Tt_cnpa_sdkKt;
import com.bytedance.ttcnpa.utils.CnpaThreadFactory;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.a4;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class t2 implements a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t2 f346243a = null;

    public static final class a implements ITTCNPADepend {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f346244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f346245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2<String, String, Unit> f346246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f346247d;

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public final void b() {
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public final void d() {
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public final void getIoExecutor() {
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public final void c() {
            FLogger.f375446a.i("TtcnpaInitServiceImpl", "ttcnpa onInitFinished");
            this.f346247d.invoke();
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public Application getContext() {
            return AppHost.f326268a.getApplication();
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public final String a() {
            return this.f346244a;
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public final String e() {
            return this.f346245b;
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public /* bridge */ /* synthetic */ Context getContext() {
            return getContext();
        }

        @Override // com.bytedance.ttcnpa.ITTCNPADepend
        public final void f(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "logType");
            Intrinsics.checkNotNullParameter(r101, "json");
            this.f346246c.invoke(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, String r101, Function2<? super String, ? super String, Unit> r102, Function0<Unit> r103) {
            this.f346244a = r100;
            this.f346245b = r101;
            this.f346246c = r102;
            this.f346247d = r103;
        }
    }

    static {
        f346243a = new t2();
    }

    public t2() {
    }

    @Override // com.larus.platform.api.a4
    public final boolean isInitialized() {
        TTCNPA.f271037a.getClass();
        return TTCNPA.f271038b;
    }

    @Override // com.larus.platform.api.a4
    public final void a(String r100, String r101, Function2<? super String, ? super String, Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "contentProducer");
        Intrinsics.checkNotNullParameter(r101, "contentPropagator");
        Intrinsics.checkNotNullParameter(r102, "monitorLogSend");
        Intrinsics.checkNotNullParameter(r103, "onInitFinished");
        TTCNPA r104 = TTCNPA.f271037a;
        r104.getClass();
        if (TTCNPA.f271038b == false) goto L6;
        r103.invoke();
        return;
    L6:
        final a r105 = new a(r100, r101, r102, r103);
        Intrinsics.checkNotNullParameter(r105, "depend");
        monitor-enter(r104);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (TTCNPA.f271039c == false) goto L13;
        monitor-exit(r104);
        return;
    L13:
        TTCNPA.f271039c = true;     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r105, "<set-?>");     // Catch: Throwable -> L25
        TTCNPA.f271040d = r105;     // Catch: Throwable -> L25
        TTCNPA.c().d();     // Catch: Throwable -> L25
        TTCNPA.c().getIoExecutor();     // Catch: Throwable -> L25
        TTCNPA.f271042f = new PThreadScheduledThreadPoolExecutor(1, new CnpaThreadFactory());     // Catch: Throwable -> L25
        String r106 = TTCNPA.c().a();     // Catch: Throwable -> L25
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        String r107 = TTCNPA.c().e();     // Catch: Throwable -> L25
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        TTCNPA.c().b();     // Catch: Throwable -> L25
        TTCNPA.f271041e = Tt_cnpa_sdkKt.a(r106, r107, true);     // Catch: Throwable -> L25
        ScheduledExecutorService r108 = TTCNPA.f271042f;     // Catch: Throwable -> L25
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mExecutor");     // Catch: Throwable -> L25
        r108 = null;
    L22:
        r108.submit(new yh7.b(r105));     // Catch: Throwable -> L25
        monitor-exit(r104);
    }
}
