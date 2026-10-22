package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;

/* JADX INFO: loaded from: classes23.dex */
public class DataMessageUtil {
    private static final String TYPE = "type";

    public DataMessageUtil() {
    }

    public void appArrive(Context r100, String r101) {
        Intent r102 = new Intent();     // Catch: Exception -> L4
        r102.setAction(PushService.getInstance().getReceiveSdkAction(r100));     // Catch: Exception -> L4
        r102.setPackage(PushService.getInstance().getMcsPackageName(r100));     // Catch: Exception -> L4
        r102.putExtra(com.heytap.mcssdk.constant.b.f276355e, r100.getPackageName());     // Catch: Exception -> L4
        r102.putExtra(com.heytap.mcssdk.constant.b.f276353c, r101);     // Catch: Exception -> L4
        r102.putExtra("type", MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK);     // Catch: Exception -> L4
        r100.startService(r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.e("statisticMessage--Exception" + e.getMessage());
    }
}
