package com.larus.init.task.obric;

import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.performance.IObricCrashDumpHprofService;
import com.obric.assistant.performance.IObricMemoryReportService;
import com.obric.assistant.performance.IObricMemoryUploadService;
import com.obric.assistant.performance.IObricPerformanceMonitorService;
import com.obric.assistant.performance.IObricThresholdDumpHprofService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/obric/InitObricPerformanceTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitObricPerformanceTask extends d implements i {
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
        FLogger.a.i("InitObricPerformanceTask", "runInternal: init obric performance monitor");
        IObricPerformanceMonitorService.a.getClass();
        ObricFeatureServiceDelegate r0 = ObricFeatureServiceDelegate.b;
        IObricCrashDumpHprofService r2 = null;
        if (r0.c() == false) goto L5;
        IObricPerformanceMonitorService r1 = (IObricPerformanceMonitorService) ServiceManager.get().getService(IObricPerformanceMonitorService.class);
    L6:
        if (r1 == null) goto L8;
        r1.init();
    L8:
        IObricMemoryReportService.a.getClass();
        IObricMemoryReportService r3 = IObricMemoryReportService.a.a();
        if (r3 == null) goto L11;
        r3.init();
    L11:
        IObricMemoryUploadService.a.getClass();
        if (r0.c() == false) goto L14;
        IObricMemoryUploadService r4 = (IObricMemoryUploadService) ServiceManager.get().getService(IObricMemoryUploadService.class);
    L15:
        if (r4 == null) goto L17;
        r4.init();
    L17:
        IObricThresholdDumpHprofService.a.getClass();
        String r5 = AppHost.a.getBuildChannel();
        boolean r6 = r0.c();
        if (Intrinsics.areEqual(r5, "local_test") == false) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r6 == false) goto L27;
        if (r7 == false) goto L27;
        IObricThresholdDumpHprofService r8 = (IObricThresholdDumpHprofService) ServiceManager.get().getService(IObricThresholdDumpHprofService.class);
    L28:
        if (r8 == null) goto L30;
        r8.init();
    L30:
        IObricCrashDumpHprofService.a.getClass();
        if (r0.c() == false) goto L33;
        r2 = (IObricCrashDumpHprofService) ServiceManager.get().getService(IObricCrashDumpHprofService.class);
    L33:
        if (r2 == null) goto L36;
        r2.init();
        return;
    L36:
        return;
    L27:
        r8 = null;
        goto L28
    L20:
        if (Intrinsics.areEqual(r5, "auto_test") == true) goto L23;
        r7 = false;
        goto L24
    L14:
        r4 = null;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public InitObricPerformanceTask() {
        this.a = "OBRIC";
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
