package com.bytedance.common.profilesdk;

import com.bytedance.common.profilesdk.deximage.Deximage;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import hg4.a;
import hg4.b;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class DeximageMonitor {
    private static ExecutorService monitorService;

    public static /* synthetic */ void a(int r100, long r101) {
        lambda$monitorCompose$1(r100, r101);
    }

    public static /* synthetic */ void b(int r100) {
        lambda$monitorProfileCommit$4(r100);
    }

    static {
        monitorService = PThreadExecutorsUtils.newFixedThreadPool(1, new AnonymousClass1());
    }

    public static synchronized SDKMonitor getSdkMonitor() {
        monitor-enter(DeximageMonitor.class);
        SDKMonitor r100 = SDKMonitorUtils.getInstance("12468");     // Catch: Throwable -> L7
        monitor-exit(DeximageMonitor.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$monitorProfileCommit$4(int r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L6
        r101.put("commit_result", r100);     // Catch: Exception -> L6
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L6
        SDKMonitor r103 = getSdkMonitor();     // Catch: Exception -> L6
        if (r103 == null) goto L11;
        r103.monitorEvent("profile_commit", r101, r102, null);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e("", e);
    }

    private static /* synthetic */ void lambda$monitorCompose$1(int r100, long r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L6
        r102.put("result", r100);     // Catch: Exception -> L6
        r102.put("message", Deximage.composeMessage(r100));     // Catch: Exception -> L6
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L6
        r103.put("duration", r101);     // Catch: Exception -> L6
        SDKMonitor r104 = getSdkMonitor();     // Catch: Exception -> L6
        if (r104 == null) goto L11;
        r104.monitorEvent("deximage_compose", r102, r103, null);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e("", e);
    }

    public static void monitorCompose(final long r100, final int r101) {
        monitorService.execute(new b(r101, r100));
    }

    public static void monitorProfileCommit(long r100, final int r101) {
        monitorService.execute(new a(r101));
    }
}
