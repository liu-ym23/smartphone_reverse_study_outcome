package com.bytedance.push.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.android.service.manager.alliance.SmpProcessInitCallback;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.a0;
import com.bytedance.push.b;
import com.bytedance.push.utils.f;
import com.ss.android.message.util.ToolUtils;

/* JADX INFO: loaded from: classes21.dex */
public class BaseSignalReceiver extends BroadcastReceiver {
    public BaseSignalReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, final Intent r101) {
        f.b("BaseSignalReceiver", "[onReceive]" + r101.getAction());
        if (ToolUtils.isSmpProcess(r100) == false) goto L5;
        a0 r102 = b.f266751a;
        SmpProcessInitCallback r103 = new AnonymousClass1(this, r101);
        r102.getClass();
        PushServiceManager.get().getIAllianceService().onSmpProcessStart(r100, this, IAllianceService.LAUNCH_FROM_SIGNAL, r103);
        return;
    L5:
        PushSupporter.get().getSignalReportService().onReceiveSignal(r101);
    }
}
