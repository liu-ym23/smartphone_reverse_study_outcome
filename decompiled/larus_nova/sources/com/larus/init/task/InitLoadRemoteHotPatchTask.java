package com.larus.init.task;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.hotpatch.IHotPatch;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/init/task/InitLoadRemoteHotPatchTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "TAG", "", "scene", "getScene", "()Ljava/lang/String;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitLoadRemoteHotPatchTask extends bf6.d implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351052b;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a implements v48.e {
        public a() {
        }

        @Override // v48.e
        public final void onGetId(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
            Intrinsics.checkNotNullParameter(r102, "ssid");
            IHotPatch r103 = (IHotPatch) ServiceManager.get().getService(IHotPatch.class);
            if (r103 == null) goto L6;
            r103.a();
            return;
        }
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i(this.f351051a, "run InitLoadRemoteHotPatchTask");
        IApplog.Companion r100 = IApplog.f287053a;
        if (r100.getDeviceId().length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        IHotPatch r102 = (IHotPatch) ServiceManager.get().getService(IHotPatch.class);
        if (r102 == null) goto L15;
        r102.a();
        return;
    L15:
        return;
    L13:
        r100.j(new a());
        return;
    L8:
        r101 = false;
        goto L9
    }

    public InitLoadRemoteHotPatchTask() {
        this.f351051a = "LoadRemoteHotPatch";
        this.f351052b = ServiceType.BASIC_TEC;
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
        return this.f351052b;
    }
}
