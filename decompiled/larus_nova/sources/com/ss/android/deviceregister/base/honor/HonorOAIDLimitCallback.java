package com.ss.android.deviceregister.base.honor;

import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.cloudservice.oaid.IOAIDCallBack;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public class HonorOAIDLimitCallback extends IOAIDCallBack.Stub {
    private volatile boolean isLimit;

    @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
    public void basicTypes(int r100, long r101, boolean r102, float r103, double r104, String r105) throws RemoteException {
    }

    public HonorOAIDLimitCallback() {
        this.isLimit = false;
    }

    public boolean isLimit() {
        return this.isLimit;
    }

    @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
    public void handleResult(int r100, Bundle r101) throws RemoteException {
        Objects.toString(r101);
        if (r100 != 0) goto L7;
        if (r101 == null) goto L8;
        this.isLimit = r101.getBoolean("oa_id_limit_state");
        return;
    L8:
        return;
    }
}
