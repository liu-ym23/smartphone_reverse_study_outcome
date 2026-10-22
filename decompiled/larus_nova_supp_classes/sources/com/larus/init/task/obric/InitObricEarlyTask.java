package com.larus.init.task.obric;

import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.login.api.LoginService;
import com.larus.login.api.TouristManager;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.debug.api.IObricDebugService;
import com.obric.assistant.processesmanager.IObricProcessesManager;
import com.obric.assistant.product.api.IObricProduct;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.t1;
import com.obric.assistant.zeus.plugin.IZeusPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/init/task/obric/InitObricEarlyTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "installDownloadedPlugins", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitObricEarlyTask extends d implements i {
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
        FLogger r0 = FLogger.a;
        r0.i("InitObricEarlyTask", "runInternal: called");
        ObricFeatureServiceDelegate r1 = ObricFeatureServiceDelegate.b;
        if (r1.c() == false) goto L39;
        AppHost.Companion r2 = AppHost.a;
        q0.b(r2.getApplication());
        boolean r3 = q0.c(r2.getApplication());
        if (FlowRuntime.a().isTestChannel() == false) goto L9;
        IObricDebugService r4 = (IObricDebugService) ServiceManager.get().getServiceForReal(IObricDebugService.class);
        if (r4 == null) goto L9;
        r2.getApplication();
        r4.d();
    L9:
        IObricProduct.a.getClass();
        IObricProduct r5 = IObricProduct.a.a();
        if (r5 == null) goto L12;
        r5.a();
    L12:
        IObricProcessesManager.a.getClass();
        if (r1.c() == false) goto L15;
        IObricProcessesManager r6 = (IObricProcessesManager) ServiceManager.get().getService(IObricProcessesManager.class);
    L16:
        if (r6 == null) goto L18;
        r6.init();
    L18:
        if (r3 == false) goto L45;
        IObricReporter.a.getClass();
        IObricReporter r7 = IObricReporter.a.a();
        if (r7 == null) goto L41;
        r7.f();
    L41:
        IZeusPluginService r8 = (IZeusPluginService) ServiceManager.get().getService(IZeusPluginService.class);     // Catch: Throwable -> L26
        if (r8 == null) goto L28;
        r8.f();     // Catch: Throwable -> L26
    L28:
        TouristManager r9 = TouristManager.a;
        monitor-enter(r9);
        TouristManager.b = null;     // Catch: Throwable -> L36
        TouristManager.c = true;     // Catch: Throwable -> L36
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r9);
        if (t1.a.b() == false) goto L35;
        FLogger.a.i("InitObricEarlyTask", "runInternal: setCustomLogoutMessage");
        LoginService.a.N(AppHost.a.getApplication().getApplicationContext().getString(2131912241));
        return;
    L35:
        LoginService.a.N(null);
        return;
    L36:
        th = move-exception;
        throw th;
    L26:
        th = move-exception;
        FLogger.a.e("InitObricEarlyTask", "installFromDownloadDir failed", th);
        goto L28
    L45:
        return;
    L15:
        r6 = null;
        goto L16
    L39:
        r0.i("InitObricEarlyTask", "runInternal: not obric");
    }

    public InitObricEarlyTask() {
        this.a = "Infra";
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        i.a.a(this);     // Catch: Throwable -> L4
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
