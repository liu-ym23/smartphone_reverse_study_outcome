package com.vivo;

import android.content.Context;
import com.bytedance.push.PushSupporter;

/* JADX INFO: loaded from: classes41.dex */
public class SmpVivoPushMessageReceiver extends VivoPushMessageReceiver {
    public SmpVivoPushMessageReceiver() {
    }

    @Override // com.vivo.VivoPushMessageReceiver, com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onReceiveRegId(Context r100, String r101) {
        PushSupporter.logger().i("VivoPushMessageReceiver", "SmpVivoPushMessageReceiver#onReceiveRegId token = " + r101);
        super.onReceiveRegId(r100, r101);
    }
}
