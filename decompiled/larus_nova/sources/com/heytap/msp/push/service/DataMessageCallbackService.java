package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.DataMessage;

/* JADX INFO: loaded from: classes23.dex */
public class DataMessageCallbackService extends Service implements IDataMessageCallBackService {
    public DataMessageCallbackService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent r100, int r101, int r102) {
        f.a(new AnonymousClass1(this, r100));
        return 2;
    }

    @Override // com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(Context r100, DataMessage r101) {
        d.b("Receive DataMessageCallbackService:messageTitle: " + r101.getTitle() + " ------content:" + r101.getContent() + "------describe:" + r101.getDescription());
    }
}
