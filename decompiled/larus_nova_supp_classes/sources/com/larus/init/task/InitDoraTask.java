package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.settings.value.e10;
import com.larus.settings.value.kh;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/init/task/InitDoraTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "registerDoraLinkCallback", "reportDeviceKeepAlive", "reportDoraState", "doraService", "Lcom/larus/dora/api/IDoraService;", "getReportData", "Lorg/json/JSONObject;", "setPerfAndStabilityMonitorTag", "key", "value", "monitorEvent", "initCompanionDeviceManager", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitDoraTask extends d implements bg9.i {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        r0.R0(new y(r0));
    L5:
        IDoraAVLinkService r1 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r1 == null) goto L8;
        r1.H();
    L8:
        if (r0 == null) goto L10;
        r0.G(new z(this, r0));
    L10:
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L13;
        r2.c1();
    L13:
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L18;
        boolean r4 = true;
        if (r3.hasDoraDevice() != true) goto L18;
    L19:
        if (r4 == false) goto L24;
        FLogger.a.i("InitDoraTask", "initCompanionDeviceManager");
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L23;
        r5.r0();
        r5.u0();
    L23:
        ThreadPlus.submitRunnable(new v());
    L24:
        e10 r6 = e10.a;
        int r7 = l0.a;
        if (((Boolean) l0.a(Boolean.TRUE, new kh())).booleanValue() == false) goto L30;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L31;
        r8.A();
        return;
    L31:
        return;
    L30:
        return;
    L18:
        r4 = false;
        goto L19
    }

    public InitDoraTask() {
        this.a = "DORA";
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

    public static final void c(InitDoraTask r2, String r3, String r4) {
        r2.getClass();
        FLogger.a.i("InitDoraTask", "setPerfAndStabilityMonitorTag, key:" + r3 + ", value:" + r4 + ' ');
        t0.a(new w(r3, r4));
    }
}
