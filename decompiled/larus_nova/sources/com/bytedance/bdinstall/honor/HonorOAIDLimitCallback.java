package com.bytedance.bdinstall.honor;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.bdinstall.oaid.impl.IOAIDCallBack;
import com.bytedance.bdinstall.t;

/* JADX INFO: loaded from: classes8.dex */
public class HonorOAIDLimitCallback extends IOAIDCallBack.Stub {
    private volatile boolean isLimit;

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void basicTypes(int r100, long r101, boolean r102, float r103, double r104, String r105) throws RemoteException {
    }

    public HonorOAIDLimitCallback() {
        this.isLimit = false;
    }

    public boolean isLimit() {
        return this.isLimit;
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void handleResult(int r100, Bundle r101) throws RemoteException {
        t.a("honor# OAIDLimitCallback handleResult retCode= " + r100 + " retInfo= " + r101);
        if (r100 != 0) goto L7;
        if (r101 == null) goto L8;
        this.isLimit = r101.getBoolean("oa_id_limit_state");
        t.a("honor# OAIDLimitCallback handleResult success isLimit? " + this.isLimit);
        return;
    L8:
        return;
    }
}
