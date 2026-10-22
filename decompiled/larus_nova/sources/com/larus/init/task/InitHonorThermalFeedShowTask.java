package com.larus.init.task;

import android.os.Build;
import com.bytedance.common.utility.Logger;
import com.huawei.hms.android.SystemUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.ServiceType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/InitHonorThermalFeedShowTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitHonorThermalFeedShowTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351045a;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        com.flow.performance.thermal.d r100 = com.flow.performance.thermal.d.f274201b;
        monitor-enter(r100);
        Logger.e("HonorThermalMonitor", "[HonorThermalMonitor]initThermalMonitor start ");     // Catch: Throwable -> L21
        if (com.flow.performance.thermal.d.f274205f == true) goto L18;
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L21
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        if (r102 == false) goto L18;
        AppHost.Companion r103 = AppHost.f326268a;     // Catch: Throwable -> L21
        if (r103.isOversea() == true) goto L18;
        com.flow.performance.thermal.d.f274205f = true;     // Catch: Throwable -> L21
        Logger.e("HonorThermalMonitor", "[HonorThermalMonitor]initThermalMonitor inner");     // Catch: Throwable -> L21
        r103.a().j(new com.flow.performance.thermal.e());     // Catch: Throwable -> L21
        r100.a();     // Catch: Throwable -> L21
        monitor-exit(r100);
    L19:
        com.flow.performance.thermal.o.f274221b.a();
        return;
    L9:
        if (StringsKt.contains$default(r101.toUpperCase(Locale.getDefault()), SystemUtils.PRODUCT_HONOR, false, 2, null) == false) goto L11;
        r102 = true;
    L18:
        monitor-exit(r100);
    L21:
        th = move-exception;
        throw th;
    }

    public InitHonorThermalFeedShowTask() {
        this.f351045a = ServiceType.BASIC_TEC;
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
        return this.f351045a;
    }
}
