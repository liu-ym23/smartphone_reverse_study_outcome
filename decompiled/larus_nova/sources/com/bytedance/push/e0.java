package com.bytedance.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.trace.Constants;
import com.bytedance.android.service.manager.push.trace.PushTraceExternalService;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.push.third.PushManager;
import com.ss.android.message.NotifyService;
import com.ss.android.message.util.ToolUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements v67.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Boolean> f266850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i87.e f266851b;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f266852a;

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
        }

        public a(Context r100) {
            this.f266852a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            this.f266852a.unbindService(this);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public e0() {
        this.f266850a = new ConcurrentHashMap();
        this.f266851b = new i87.e(this);
    }

    public static void a(Context r100) {
        com.ss.android.pushmanager.setting.b.b().getClass();
        int r101 = com.ss.android.pushmanager.setting.b.c().v();
        if (r101 <= (-1)) goto L14;
        com.bytedance.push.utils.f.g("", "registerAliPush: aliPushType = " + r101);
        if (PushManager.inst().needDisableChannelInvoke(r100, r101) == false) goto L8;
        return;
    L8:
        if (com.bytedance.push.third.a.isServerSupportChannel(r101) == false) goto L15;
        if (r100 == null) goto L16;
        PushManager.inst().registerPush(r100, r101);
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void c(Context r100) {
        PushTraceExternalService r101 = PushServiceManager.get().getPushTraceExternalService();
        PushTraceSceneType r102 = PushTraceSceneType.ALLIANCE_WAKEUP;
        r101.getTraceScene(r102).enterNode(Constants.NODE_TRY_START_PUSH_PROCESS, "try to start the push process");
        boolean r103 = false;
        if (ToolUtils.isSmpProcess(r100) == true) goto L5;
    L8:
        boolean r104 = true;
    L9:
        e77.c r105 = (e77.c) PushSupporter.get().getProcessManagerService();
        r105.b();
        boolean r106 = r105.f471200d;
        if (r104 == false) goto L13;
        if (r106 == false) goto L13;
        r103 = true;
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(r102).enterNode(Constants.NODE_START_PUSH_PROCESS, "Start the push process");
        Intent r107 = new Intent(r100, NotifyService.class);
    L21:
        com.bytedance.push.utils.f.e("SenderService", "start NotifyService failure");
        return;
    L17:
        if (((zfc.a.b) rgc.b.a(zfc.a.b.class)).f() == true) goto L24;
    L19:
        r100.bindService(r107, new a(r100), 1);     // Catch: Throwable -> L21
        return;
    L24:
        r100.startService(r107);     // Catch: Throwable -> L23
        goto L19
    L5:
        if (PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp() == true) goto L8;
        r104 = false;
        goto L9
    }

    public final boolean b(Context r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        com.ss.android.pushmanager.setting.b.b().getClass();
        if (com.ss.android.pushmanager.setting.b.e() == false) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
        return false;
    L13:
        Context r103 = r100.getApplicationContext();
        if (com.bytedance.push.third.a.isServerSupportChannel(r101) == false) goto L42;
        if (r103 != null) goto L17;
        boolean r104 = false;
    L18:
        if (r104 == false) goto L42;
        if (PushManager.inst().needDisableChannelInvoke(r103, r101) == false) goto L23;
        return false;
    L23:
        monitor-enter(this);
        Map<Integer, Boolean> r105 = this.f266850a;     // Catch: Throwable -> L39
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;     // Catch: Throwable -> L39
        Boolean r107 = (Boolean) r106.get(Integer.valueOf(r101));     // Catch: Throwable -> L39
        if (r107 != null) goto L27;
    L30:
        Map<Integer, Boolean> r108 = this.f266850a;     // Catch: Throwable -> L39
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108;     // Catch: Throwable -> L39
        r109.put(Integer.valueOf(r101), Boolean.TRUE);     // Catch: Throwable -> L39
        monitor-exit(this);     // Catch: Throwable -> L39
        if (com.bytedance.push.third.a.isServerSupportChannel(r101) == false) goto L44;
        if (r103 == null) goto L45;
        PushManager.inst().registerPush(r103, r101);
        return true;
    L45:
        return false;
    L44:
        return false;
    L27:
        if (r107.booleanValue() == false) goto L30;
        monitor-exit(this);     // Catch: Throwable -> L39
        return true;
    L39:
        th = move-exception;
        throw th;
    L17:
        r104 = PushManager.inst().isPushAvailable(r103, r101);
    L42:
        return false;
    L8:
        if (com.ss.android.pushmanager.setting.b.d().G() == false) goto L10;
        r102 = true;
        goto L11
    }
}
