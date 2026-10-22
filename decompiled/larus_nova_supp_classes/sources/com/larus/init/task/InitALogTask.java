package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.bytedance.common.utility.Logger;
import com.flow.performance.quality.appinit.AppLaunchTracer;
import com.larus.apm.api.IApm;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.e10;
import com.larus.settings.value.nj;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitALogTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitALogTask extends d implements bg9.i {
    public final String a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        AppHost.Companion r0 = AppHost.a;
        boolean r1 = r0.isTestChannel();
        if (r1 == false) goto L5;
        int r2 = 120;
    L6:
        e10 r3 = e10.a;
        int r4 = l0.a;
        int r5 = ((Number) l0.a(Integer.valueOf(r2), new nj(r2))).intValue();
        IApm r6 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r6 == null) goto L9;
        r6.a(r1, r5, r0.getApplication());
    L9:
        AppLaunchTracer r7 = AppLaunchTracer.a;
        boolean r8 = r0.isDebug();
        a r9 = new a();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r9, "reporter");
        if (AppLaunchTracer.b.compareAndSet(false, true) == false) goto L22;
        ju7.c r10 = (ju7.c) AppLaunchTracer.c.getValue();
        int r11 = iu7.a.a;
        ku7.a r12 = ku7.a.a;
        monitor-enter(r12);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (ku7.a.e == r8) goto L16;
        Lazy r13 = ku7.c.a;     // Catch: Throwable -> L19
        ku7.c.a("[GlobalConfigAgent] debug mode change: " + ku7.a.e + " -> " + r8);     // Catch: Throwable -> L19
    L16:
        ku7.a.e = r8;     // Catch: Throwable -> L19
        monitor-exit(r12);
        iu7.a.a(r7);
        iu7.a.b(r9);
        iu7.a.c(com.bytedance.apm.d.l());
    L22:
        if (r1 == false) goto L27;
        Logger.setLogLevel(2);
        return;
    L27:
        return;
    L5:
        r2 = 40;
        goto L6
    }

    public InitALogTask() {
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
