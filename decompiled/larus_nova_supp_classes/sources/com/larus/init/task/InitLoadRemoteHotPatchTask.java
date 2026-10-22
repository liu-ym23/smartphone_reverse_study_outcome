package com.larus.init.task;

import android.util.EventsUtils;
import bf6.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.hotpatch.IHotPatch;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitLoadRemoteHotPatchTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", XmlPullParser.NO_NAMESPACE, "scene", "getScene", "()Ljava/lang/String;", "runInternal", XmlPullParser.NO_NAMESPACE, "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class InitLoadRemoteHotPatchTask extends d implements bg9.i {
    public final String a;
    public final String b;

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        if (AppHost.a.isOversea() == false) goto L5;
        return;
    L5:
        FLogger.a.i(this.a, "run InitLoadRemoteHotPatchTask");
        IApplog.Companion r0 = IApplog.a;
        if (r0.getDeviceId().length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        IHotPatch r2 = (IHotPatch) ServiceManager.get().getService(IHotPatch.class);
        if (r2 == null) goto L15;
        r2.a();
        return;
    L15:
        return;
    L13:
        r0.j(new a());
        return;
    L8:
        r1 = false;
        goto L9
    }

    public InitLoadRemoteHotPatchTask() {
        this.a = "LoadRemoteHotPatch";
        this.b = "Infra";
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
        return this.b;
    }
}
