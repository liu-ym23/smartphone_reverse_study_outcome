package com.larus.init.task;

import android.os.SystemClock;
import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.nita.IChatNitaPreloadService;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.platform.service.o;
import com.larus.settings.value.e10;
import com.larus.settings.value.mj;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/larus/init/task/InitNitaAsyncTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "tag", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitNitaAsyncTask extends d implements bg9.i {
    public final String a;
    public final String b;
    public final String c;

    public InitNitaAsyncTask() {
        this.a = "InitNitaAsyncTask";
        this.b = "Message";
        this.c = "asyncThreadWhenFirst";
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
    public final void runInternal() {
        long r0 = SystemClock.elapsedRealtime();
        e10 r2 = e10.a;
        if (e10.D0().a() == true) goto L6;
        FLogger.a.i(this.a, "did not hit nita ab, do not init nita!");
        return;
    L6:
        Lazy r3 = we8.j.a;
        int r4 = we8.j.c;
        int r5 = AppHost.a.getApplication().getResources().getConfiguration().uiMode & 48;
        if (r5 != 0) goto L9;
    L14:
        int r6 = 1;
    L15:
        JSONObject r7 = new JSONObject();
        r7.put("app_mode", r4);
        r7.put("sys_mode", r5);
        r7.put("sys_mode_trans", r6);
        if (r4 == (-1)) goto L20;
        if (r4 == r6) goto L20;
        r7.put("skip", true);
        o.a.reportEvent("nita_init_monitor", r7);
        com.larus.bmhome.utils.c.a("nita_init_monitor", r7, true);
        return;
    L20:
        FLogger.a.i(this.a, "init inta!, appMode=" + r4 + " sysMode=" + r5 + " sysModeTrans=" + r6);
        int r8 = o37.d.a;
        o37.a.a = new mm9.o();
        if (e10.D0().b() == true) goto L38;
    L28:
        e10 r9 = e10.a;
        if (e10.D0().c() == false) goto L36;
        int r10 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new mj())).booleanValue() == true) goto L36;
        HomeService.a.S();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        FLogger.a.e(this.a, "exception=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    L36:
        r7.put("init_duration", SystemClock.elapsedRealtime() - r0);
        r7.put("skip", false);
        o.a.reportEvent("nita_init_monitor", r7);
        com.larus.bmhome.utils.c.a("nita_init_monitor", r7, true);
        return;
    L38:
        IChatNitaPreloadService r11 = (IChatNitaPreloadService) ServiceManager.get().getService(IChatNitaPreloadService.class);     // Catch: Exception -> L26
        if (r11 == null) goto L28;
        r11.b(new ii8.a(com.larus.platform.exp.a.e));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        FLogger.a.e(this.a, "exception=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L28
    L9:
        if (r5 == 16) goto L14;
        if (r5 == 32) goto L13;
        r6 = -1;
        goto L15
    L13:
        r6 = 2;
        goto L15
    }

    @Override // bg9.i
    public final String getScene() {
        return this.b;
    }

    @Override // bg9.i
    public final String v() {
        return this.c;
    }
}
