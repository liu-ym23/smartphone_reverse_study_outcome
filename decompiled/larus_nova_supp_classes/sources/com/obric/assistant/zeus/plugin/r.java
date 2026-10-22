package com.obric.assistant.zeus.plugin;

import android.content.ComponentName;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.activity.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class r implements c {
    public volatile boolean a;

    public static final class a {
    }

    static {
    }

    public r() {
    }

    @Override // com.volcengine.zeus.activity.c
    public final void a(String r6, Intent r7) {
        boolean r1 = false;
        if (r7 == null) goto L5;
        r1 = r7.getBooleanExtra("__zeus_relaunch_from_callback", false);
    L5:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("zeus start activity failed, component = ");
        if (r7 == null) goto L8;
        ComponentName r4 = r7.getComponent();
    L9:
        r3.append(r4);
        r3.append(", isRelaunch = ");
        r3.append(r1);
        r2.w("ZeusStartActivityFallback", r3.toString());
        IObricLaunchService r5 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r5 == null) goto L12;
        r5.startLauncherIntent();
    L12:
        if (r7 != null) goto L14;
        return;
    L14:
        if (r1 == false) goto L17;
        return;
    L17:
        if (this.a == false) goto L19;
        return;
    L19:
        this.a = true;
        Intent r8 = new Intent(r7);
        r8.putExtra("__zeus_relaunch_from_callback", true);
        Zeus.runAfterLoad(r6, new b(r7, r8, this), 60000);
        return;
    L8:
        r4 = null;
        goto L9
    }
}
