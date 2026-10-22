package com.larus.init.task.bootprotector;

import android.app.Application;
import android.util.EventsUtils;
import bf6.d;
import bg9.i;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/init/task/bootprotector/InitBootProtectorCheckingTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitBootProtectorCheckingTask extends d implements i {
    public final String a;
    public final String b;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        FLogger.a.i(this.a, "InitBootProtectorCheckingTask runInternal");
        IBootProtectorLauncher.a r0 = IBootProtectorLauncher.a;
        AppHost.Companion r1 = AppHost.a;
        Application r2 = r1.getApplication();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "baseContext");
        IBootProtectorLauncher r3 = IBootProtectorLauncher.a.c();
        if (r3 == null) goto L5;
        r3.g(r2);
    L5:
        Application r4 = r1.getApplication();
        Intrinsics.checkNotNullParameter(r4, "baseContext");
        IBootProtectorLauncher r5 = IBootProtectorLauncher.a.c();
        if (r5 == null) goto L9;
        r5.j(r4);
        return;
    }

    public InitBootProtectorCheckingTask() {
        this.a = "InitBootProtectorCheckingTask";
        this.b = "Infra";
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
        return this.b;
    }
}
