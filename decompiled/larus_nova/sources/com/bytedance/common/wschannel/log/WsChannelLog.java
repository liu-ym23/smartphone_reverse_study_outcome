package com.bytedance.common.wschannel.log;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.message.log.PushLog;

/* JADX INFO: loaded from: classes15.dex */
public class WsChannelLog {
    public static void onEventV3Bundle(Context r100, String r101, Bundle r102) {
        PushLog.onEventV3Bundle(r100, r101, r102);     // Catch: Throwable -> L4
        return;
    }
}
