package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.f.android.quality.base.QualityLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.business.debug.api.IDebugService;
import com.larus.common.apphost.AppHost;
import com.larus.init.IAppLogInitiator;
import com.larus.network.http.HttpExtKt;
import com.larus.nova.NovaApplication;
import com.larus.settings.value.e10;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitAppLog;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitAppLog extends d implements bg9.i {
    public final String a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        e10 r0 = e10.a;
        qv9.a r1 = e10.j0().a();
        if (r1 != null) goto L5;
        r1 = new qv9.a(0);
    L5:
        AppHost.Companion r2 = AppHost.a;
        if (r2.isTestChannel() == false) goto L15;
        IDebugService r3 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        boolean r28 = true;
    L17:
        if (r2.isTestChannel() == false) goto L20;
        if (r28 == true) goto L20;
    L22:
        boolean r13 = false;
    L24:
        if (r2.isTestChannel() == false) goto L27;
        if (r28 == true) goto L27;
    L29:
        boolean r14 = false;
    L31:
        if (r2.isDebug() == false) goto L35;
        if (r28 == true) goto L35;
        boolean r29 = false;
    L36:
        boolean r16 = r2.isTestChannel();
        IAppLogInitiator r5 = (IAppLogInitiator) ServiceManager.get().getService(IAppLogInitiator.class);
        if (r5 == null) goto L39;
        r5.a(new v48.a(r2.getAppId(), r2.getAppName(), r2.getVersionCode(), r2.getVersionName(), r2.getUpdateVersionCode(), r2.getBuildChannel(), HttpExtKt.e().a, r13, r14, r1.h(), r16, r1.d(), r1.c(), r1.a(), r1.b(), r1.i(), r1.l(), r1.k(), r1.j(), r29, r28));
    L39:
        IDebugService r6 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r6 == null) goto L42;
        r2.getApplication();
        r6.t();
    L42:
        int r7 = xp9.m.a;
        int r8 = rr9.a.a;
        boolean r9 = r2.isDebug();
        int r10 = qt7.a.a;
        com.f.android.quality.base.a r11 = com.f.android.quality.base.a.d;
        monitor-enter(r11);
    L53:
        th = move-exception;
        throw th;
    L45:
        if (com.f.android.quality.base.a.c == r9) goto L47;
        Lazy r12 = QualityLogger.a;     // Catch: Throwable -> L53
        QualityLogger.a("[GlobalConfigAgent] debug mode change: " + com.f.android.quality.base.a.c + " -> " + r9);     // Catch: Throwable -> L53
    L47:
        com.f.android.quality.base.a.c = r9;     // Catch: Throwable -> L53
        monitor-exit(r11);
        qt7.a.a(new rr9.a.b());
        qt7.a.b(new rr9.a.a());
        int r15 = d68.a.a;
        Intrinsics.checkNotNullParameter(new rr9.b(), "reporter");
        NovaApplication r17 = NovaApplication.e;
        NovaApplication r18 = NovaApplication.a.a();
        Intrinsics.checkNotNullParameter(r18, "app");
        ay9.b.a(r18, new xp9.j());
        if (r1.g() == false) goto L58;
        r2.a().j(new a());
        return;
    L58:
        return;
    L35:
        r29 = true;
    L27:
        if (r1.f() == false) goto L29;
        r14 = true;
    L20:
        if (r1.e() == false) goto L22;
        r13 = true;
        goto L24
    L10:
        if (r3.l() != true) goto L12;
        r4 = true;
    L15:
        r28 = false;
        goto L17
    }

    public InitAppLog() {
        this.a = "Infra";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.a;
    }
}
