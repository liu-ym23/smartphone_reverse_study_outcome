package com.ss.android.lark.monitor.traffic;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.TakeTrafficDataRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RustSdkTrafficHandler f432478a;

    @Override // java.lang.Runnable
    public final void run() {
        RustSdkTrafficHandler.RustSDKTrafficCallback r100 = this.f432478a.f432469d;     // Catch: Throwable -> L6
        if (((com.ss.android.lark.monitor.c) ClaymoreServiceLoader.loadFirst(com.ss.android.lark.monitor.c.class)).isLogin() == false) goto L9;
        com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b r101 = com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.b.C5276b.f439683a;     // Catch: Throwable -> L6
        TakeTrafficDataRequest.Builder r102 = new TakeTrafficDataRequest.Builder();     // Catch: Throwable -> L6
        Log.i("AppStateSyncService", "start async take SdkTraffic data");     // Catch: Throwable -> L6
        SdkSender.asynSendRequestNonWrap(Command.TAKE_TRAFFIC_DATA, r102, r100, new com.ss.android.lark.rustinfrabridge.appstatesync.service.impl.c());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public e(RustSdkTrafficHandler r100) {
        this.f432478a = r100;
    }
}
