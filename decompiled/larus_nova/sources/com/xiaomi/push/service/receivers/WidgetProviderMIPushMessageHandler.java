package com.xiaomi.push.service.receivers;

import android.content.Context;
import com.bytedance.push.PushSupporter;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;

/* JADX INFO: loaded from: classes41.dex */
public class WidgetProviderMIPushMessageHandler extends MIPushMessageHandler {
    public WidgetProviderMIPushMessageHandler() {
    }

    @Override // com.xiaomi.push.service.receivers.MIPushMessageHandler, com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context r100, MiPushCommandMessage r101) {
        PushSupporter.logger().i("MiPush", "onCommandResult on widgetProvider");
        super.onCommandResult(r100, r101);
    }
}
