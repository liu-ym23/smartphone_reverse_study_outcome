package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.c;
import com.heytap.mcssdk.utils.d;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.DataMessage;

/* JADX INFO: loaded from: classes23.dex */
public class CompatibleDataMessageCallbackService extends Service implements IDataMessageCallBackService {
    public CompatibleDataMessageCallbackService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        PushService.getInstance().innerInit(getApplicationContext());
        c.a(getApplicationContext(), r100, this);
        return 2;
    }

    @Override // com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(Context r100, DataMessage r101) {
        d.b("Receive CompatibleDataMessageCallbackService:messageTitle: " + r101.getTitle() + " ------content:" + r101.getContent() + "------describe:" + r101.getDescription());
    }
}
