package com.larus.init.task.idle;

import bf6.b;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import gg9.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/larus/init/task/idle/InitLoadPluginsInIdleTask;", "Lcom/bytedance/lego/init/model/BaseIdleTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "ecommerceSettingsConfig", "Lcom/larus/platform/model/mainbot/ECommerceSettingsConfig;", "getEcommerceSettingsConfig", "()Lcom/larus/platform/model/mainbot/ECommerceSettingsConfig;", "ecommerceSettingsConfig$delegate", "Lkotlin/Lazy;", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitLoadPluginsInIdleTask extends b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f351336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351337b;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger.f375446a.d("load/plugins", "InitLoadPluginsInIdleTask");
    }

    public InitLoadPluginsInIdleTask() {
        this.f351336a = LazyKt.lazy(new a());
        this.f351337b = ServiceType.BASIC_TEC;
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
        return this.f351337b;
    }
}
