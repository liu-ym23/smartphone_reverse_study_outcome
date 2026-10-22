package com.bytedance.common.process.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push_common_lib.ICrossProcessAIDL;

/* JADX INFO: loaded from: classes3.dex */
public class BaseCrossProcessService extends Service {
    private final String TAG;
    private final ICrossProcessAIDL.Stub mBinder;
    private Context mContext;

    public BaseCrossProcessService() {
        this.TAG = "BaseCrossProcessService";
        this.mContext = this;
        this.mBinder = new AnonymousClass1(this);
    }

    public static /* synthetic */ Context access$000(BaseCrossProcessService r100) {
        return r100.mContext;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        ProcessEnum r101 = ToolUtils.getCurProcess(this.mContext);
        Bundle r102 = r100.getExtras();
        if (r102 == null) goto L8;
        String r103 = r102.getString("process");
        if (r102.getBoolean("is_from_on_bind") == true) goto L8;
        f.b("BaseCrossProcessService", r101 + " process service is called by " + r103);
        AppProvider.initApp(getApplication());
        CrossProcessHelper.getInstance().onServiceBind(r103);
    L8:
        return this.mBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        return 2;
    }
}
