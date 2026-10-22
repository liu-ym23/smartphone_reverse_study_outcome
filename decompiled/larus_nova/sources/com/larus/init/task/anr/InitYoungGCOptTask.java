package com.larus.init.task.anr;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.jato.api.IJato;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qt9.c5;
import qt9.e0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/init/task/anr/InitYoungGCOptTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", "", "scene", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitYoungGCOptTask extends bf6.d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351170b;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f351169a, "InitYoungGCOptTask start --->");
        com.larus.init.task.firstframe.jato.a.f351302e.a();
        if (Build.VERSION.SDK_INT < 29) goto L15;
        ht9.a r101 = ht9.a.f487150a;
        Application r102 = AppHost.f326268a.getApplication();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        ht9.a.a(r102);
        c5 r103 = new c5(ht9.a.f487157h);
        r100.i("JatoOptHelper", "youngGCOptConfig: " + r103);
        if (r103.a() != 0.0f) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L48;
        r100.e("JatoOptHelper", "youngGCOpt DISABLED!");
        goto L15
    L48:
        r100.i("JatoOptHelper", "youngGCOpt start");     // Catch: Throwable -> L13
        IJato.f351658a.e(r103.a());     // Catch: Throwable -> L13
        r100.i("JatoOptHelper", "youngGCOpt finish");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        com.larus.init.task.firstframe.jato.a.g("youngGCOpt");
        FLogger.f375446a.e("JatoOptHelper", "youngGCOpt had an error !!! ", th);
        goto L15
    L8:
        r104 = false;
    L15:
        FLogger r105 = FLogger.f375446a;
        r105.i(this.f351169a, "InitYoungGCOptTask finish <---");
        r105.i(this.f351169a, "InitClassVisibleInitTask start --->");
        com.larus.init.task.firstframe.jato.a.f351302e.a();
        int r106 = Build.VERSION.SDK_INT;
        if (r106 >= 30) goto L18;
    L30:
        FLogger r107 = FLogger.f375446a;
        r107.i(this.f351169a, "InitClassVisibleInitTask finish <---");
        r107.i(this.f351169a, "InitRemoveGCWaitingTask start --->");
        com.larus.init.task.firstframe.jato.a.f351302e.a();
        int r108 = Build.VERSION.SDK_INT;
        if (r108 >= 29) goto L33;
    L42:
        FLogger.f375446a.i(this.f351169a, "InitRemoveGCWaitingTask finish <---");
        return;
    L33:
        if (r108 > 34) goto L42;
        ht9.a r109 = ht9.a.f487150a;
        Application r110 = AppHost.f326268a.getApplication();
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ht9.a.a(r110);
        boolean r111 = ht9.a.f487153d;
        r107.i("JatoOptHelper", "enableRemoveGCWaitingBlockOpt: " + r111);
        if (r111 == true) goto L46;
        r107.e("JatoOptHelper", "removeGCWaitingBlock DISABLED!");
        goto L42
    L46:
        r107.i("JatoOptHelper", "removeGCWaitingBlock start");     // Catch: Throwable -> L40
        IJato.f351658a.i();     // Catch: Throwable -> L40
        r107.i("JatoOptHelper", "removeGCWaitingBlock finish");     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        com.larus.init.task.firstframe.jato.a.g("removeGCWaitingBlock");
        FLogger.f375446a.e("JatoOptHelper", "removeGCWaitingBlock had an error !!! ", th);
        goto L42
    L18:
        if (r106 > 33) goto L30;
        if (Process.is64Bit() == false) goto L30;
        ht9.a r112 = ht9.a.f487150a;
        Application r113 = AppHost.f326268a.getApplication();
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        ht9.a.a(r113);
        e0 r114 = new e0(ht9.a.f487154e, ht9.a.f487155f, ht9.a.f487156g);
        r105.i("JatoOptHelper", "classVisiblyInitializedOptConfig: " + r114);
        if (r114.a() == true) goto L44;
        r105.e("JatoOptHelper", "classVisibleInitializedOpt DISABLED!");
        goto L30
    L44:
        r105.i("JatoOptHelper", "classVisibleInitializedOpt start");     // Catch: Throwable -> L28
        IJato.f351658a.a(r114.b(), r114.c());     // Catch: Throwable -> L28
        r105.i("JatoOptHelper", "classVisibleInitializedOpt finish");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        com.larus.init.task.firstframe.jato.a.g("classVisibleInitializedOpt");
        FLogger.f375446a.e("JatoOptHelper", "classVisibleInitializedOpt had an error !!! ", th);
        goto L30
    }

    public InitYoungGCOptTask() {
        this.f351169a = "YoungGCTask";
        this.f351170b = ServiceType.BASIC_TEC;
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
        return this.f351170b;
    }
}
