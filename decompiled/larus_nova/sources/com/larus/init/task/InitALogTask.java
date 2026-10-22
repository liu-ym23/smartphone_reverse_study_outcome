package com.larus.init.task;

import com.bytedance.common.utility.Logger;
import com.flow.performance.quality.appinit.AppLaunchTracer;
import com.larus.apm.api.IApm;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.ServiceType;
import com.larus.settings.value.e10;
import com.larus.settings.value.nj;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitALogTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitALogTask extends bf6.d implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351003a;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a implements ju7.a {
        public a() {
        }

        @Override // ju7.a
        public final void onReport(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r101, "params");
            JSONObject r102 = new JSONObject(r101);
            com.larus.platform.service.o.f365780a.reportEvent(r100, r102);
            com.larus.bmhome.utils.c.a(r100, r102, true);
        }
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        AppHost.Companion r100 = AppHost.f326268a;
        boolean r101 = r100.isTestChannel();
        if (r101 == false) goto L5;
        int r102 = 120;
    L6:
        e10 r103 = e10.f368561a;
        int r104 = com.larus.utils.l0.f375430a;
        int r105 = ((Number) com.larus.utils.l0.a(Integer.valueOf(r102), new nj(r102))).intValue();
        IApm r106 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r106 == null) goto L9;
        r106.a(r101, r105, r100.getApplication());
    L9:
        AppLaunchTracer r107 = AppLaunchTracer.f274169a;
        boolean r108 = r100.isDebug();
        a r109 = new a();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r109, "reporter");
        if (AppLaunchTracer.f274170b.compareAndSet(false, true) == false) goto L22;
        ju7.c r110 = (ju7.c) AppLaunchTracer.f274171c.getValue();
        int r111 = iu7.a.f495802a;
        ku7.a r112 = ku7.a.f506216a;
        monitor-enter(r112);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (ku7.a.f506220e == r108) goto L16;
        Lazy r113 = ku7.c.f506221a;     // Catch: Throwable -> L19
        ku7.c.a("[GlobalConfigAgent] debug mode change: " + ku7.a.f506220e + " -> " + r108);     // Catch: Throwable -> L19
    L16:
        ku7.a.f506220e = r108;     // Catch: Throwable -> L19
        monitor-exit(r112);
        iu7.a.a(r107);
        iu7.a.b(r109);
        iu7.a.c(com.bytedance.apm.d.l());
    L22:
        if (r101 == false) goto L27;
        Logger.setLogLevel(2);
        return;
    L27:
        return;
    L5:
        r102 = 40;
        goto L6
    }

    public InitALogTask() {
        this.f351003a = ServiceType.BASIC_TEC;
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
        return this.f351003a;
    }
}
