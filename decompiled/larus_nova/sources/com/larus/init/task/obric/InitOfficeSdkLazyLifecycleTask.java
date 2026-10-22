package com.larus.init.task.obric;

import android.app.Application;
import bf6.d;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.init.task.x0;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/obric/InitOfficeSdkLazyLifecycleTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitOfficeSdkLazyLifecycleTask extends d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351442a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    public InitOfficeSdkLazyLifecycleTask() {
        this.f351442a = ServiceType.OFFICE;
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
    public final void runInternal() {
        if (x0.a() == true) goto L7;
        FLogger.f375446a.i("InitOfficeSdkLazyLifecycleTask", "skip: lazy path not enabled");
        return;
    L7:
        if (b.f351444a.compareAndSet(false, true) == true) goto L9;
        FLogger.f375446a.i("OfficeSdkLazyInitLifecycleRegistrar", "registerOnce skipped, already registered");
        return;
    L9:
        Application r100 = AppHost.f326268a.getApplication();
        r100.registerActivityLifecycleCallbacks(new com.larus.init.task.obric.a(r100));     // Catch: Exception -> L12
        FLogger.f375446a.i("OfficeSdkLazyInitLifecycleRegistrar", "activity lifecycle callback registered");     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        b.f351444a.set(false);
        FLogger.f375446a.e("OfficeSdkLazyInitLifecycleRegistrar", "register activity lifecycle callback failed", e);
        if (AppHost.f326268a.isTestChannel() == false) goto L19;
        throw e;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351442a;
    }
}
