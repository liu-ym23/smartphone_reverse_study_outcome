package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.business.accessbility.api.IAccessibilityService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitAccessibilityAsyncTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", XmlPullParser.NO_NAMESPACE, "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitAccessibilityAsyncTask extends d implements bg9.i {
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
        AppHost.Companion r0 = AppHost.a;
        if (r0.isOversea() == false) goto L7;
        FLogger.a.i("InitAccessibilityAsyncTask", "Oversea not support accessibility sdk");
        return;
    L7:
        if (z2.a.isAccessibilitySdkInitEnable() == true) goto L10;
        FLogger.a.i("InitAccessibilityAsyncTask", "No accessibility sdk support");
        return;
    L10:
        IAccessibilityService r1 = (IAccessibilityService) ServiceManager.get().getService(IAccessibilityService.class);
        if (r1 == null) goto L20;
        FLogger.a.i("InitAccessibilityAsyncTask", "InitAccessibilityAsyncTask start");
        r1.b(r0.getApplication().getApplicationContext());     // Catch: Throwable -> L15
        r1.start();     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        FLogger.a.e("InitAccessibilityAsyncTask", "InitAccessibilityAsyncTask error", th);
        return;
    }

    public InitAccessibilityAsyncTask() {
        this.a = "Basic";
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
}
