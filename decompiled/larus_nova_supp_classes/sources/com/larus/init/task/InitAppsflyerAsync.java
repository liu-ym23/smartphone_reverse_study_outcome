package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.account.base.api.ILoginService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.appsflyer.api.IAppsflyerService;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/larus/init/task/InitAppsflyerAsync;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "Lcom/larus/account/base/api/IAccountStatusListener;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "onUserDidOnline", "event", "Lcom/larus/account/base/api/AccountStatusEvent;", "onUserDidOffline", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitAppsflyerAsync extends d implements bg9.i, n38.j {
    public final String a;

    @Override // n38.j
    public final void a(n38.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        IAppsflyerService r0 = (IAppsflyerService) ServiceManager.get().getService(IAppsflyerService.class);
        if (r0 == null) goto L5;
        r0.c();
        AppHost.Companion r1 = AppHost.a;
        r1.getApplication();
        r0.init();
        r1.getApplication();
        r0.start();
    L5:
        ILoginService r2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r2 == null) goto L9;
        r2.f(this, Boolean.FALSE);
        return;
    }

    public InitAppsflyerAsync() {
        this.a = "Infra";
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

    @Override // n38.j
    public final void b(n38.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        IAppsflyerService r3 = (IAppsflyerService) ServiceManager.get().getService(IAppsflyerService.class);
        if (r3 == null) goto L5;
        r3.c();
    L5:
        IAppsflyerService r4 = (IAppsflyerService) ServiceManager.get().getService(IAppsflyerService.class);
        if (r4 == null) goto L9;
        r4.b();
        return;
    }
}
