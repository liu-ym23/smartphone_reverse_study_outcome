package com.vivo.push.sdk.service;

import a87.i;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.push.utils.f;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.vivo.push.sdk.a;
import com.vivo.push.util.t;
import com.vv.VvPushAdapter;

/* JADX INFO: loaded from: classes41.dex */
public class CommandClientService extends CommandService {
    public static final String NEED_KILL_SMP = "need_kill_smp";
    public static final String SMP_PID = "smp_pid";
    private final String TAG;

    public CommandClientService() {
        this.TAG = "CommandClientService";
    }

    private void handleIntent(Intent r100) {
        if (r100 == null) goto L35;
        f.b("CommandClientService", "CommandClientService.handleIntent: intent is " + r100.toString());
        ComponentName r101 = r100.getComponent();
        if (r101 == null) goto L8;
        f.b("CommandClientService", "CommandClientService.handleIntent: component is " + r101.toString());
    L8:
        if (ToolUtils.isSmpProcess(this) == false) goto L23;
        i r102 = j77.i.f497636a;
        boolean r103 = VvPushAdapter.hasTryRegistered();
        f.b("CommandClientService", "[CommandClientService.onStartCommand]hasTryRegistered:" + r103);
        if (r103 == true) goto L22;
        f.b("CommandClientService", "CommandClientService.handleIntent: redirect to main process ");
        ComponentName r104 = new ComponentName(getPackageName(), MainCommandClientService.class.getName());
        f.b("CommandClientService", "CommandClientService.onStartCommand: main process component is " + r104.toString());
        r100.setComponent(r104);
        f.b("CommandClientService", "hasWaked:" + PushServiceManager.get().getIAllianceService().hasWaked());
        ComponentName r105 = startService(r100);     // Catch: Throwable -> L18
        StringBuilder r106 = new StringBuilder("startService result: ");     // Catch: Throwable -> L18
        if (r105 == null) goto L15;
        boolean r107 = true;
    L16:
        r106.append(r107);     // Catch: Throwable -> L18
        f.b("CommandClientService", r106.toString());     // Catch: Throwable -> L18
    L20:
        PushThreadHandlerManager.inst().postRunnable(new AnonymousClass2(this));
        return;
    L15:
        r107 = false;
    L18:
        th = move-exception;
        f.b("CommandClientService", "startService failed , try bind : " + th.getMessage());
        f.b("CommandClientService", "bindService result:" + bindService(r100, new AnonymousClass1(this), 1));
        goto L20
    L22:
        f.b("CommandClientService", "CommandClientService.onStartCommand: execute callback on smp process ");
    L23:
        t.c("CommandService", getClass().getSimpleName() + " -- onStartCommand " + getPackageName());
        if (a(r100.getAction()) == true) goto L31;
        t.a("CommandService", getPackageName() + " receive invalid action " + r100.getAction());
        return;
    L31:
        a.a().a(getClass().getName());     // Catch: Exception -> L28
        a.a().a(r100);     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        t.a("CommandService", "onStartCommand -- error", e);
        return;
    }

    @Override // com.vivo.push.sdk.service.CommandService
    public final boolean a(String r100) {
        return "com.vivo.pushclient.action.RECEIVE".equals(r100);
    }

    @Override // com.vivo.push.sdk.service.CommandService, android.app.Service
    public IBinder onBind(Intent r100) {
        f.b("CommandClientService", "CommandClientService.onBind: intent is " + r100.toString());
        if (ToolUtils.isMainProcess(this) == false) goto L6;
        handleIntent(r100);
    L6:
        return super.onBind(r100);
    }

    @Override // com.vivo.push.sdk.service.CommandService, android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        f.b("CommandClientService", "CommandClientService.onStartCommand: intent is " + r100);
        handleIntent(r100);
        stopSelf();
        return 2;
    }
}
