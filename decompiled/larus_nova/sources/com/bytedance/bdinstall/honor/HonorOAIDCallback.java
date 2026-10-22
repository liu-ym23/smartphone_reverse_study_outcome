package com.bytedance.bdinstall.honor;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.bdinstall.oaid.impl.IOAIDCallBack;
import com.bytedance.bdinstall.t;

/* JADX INFO: loaded from: classes8.dex */
public class HonorOAIDCallback extends IOAIDCallBack.Stub {
    private volatile String oaid;

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void basicTypes(int r100, long r101, boolean r102, float r103, double r104, String r105) throws RemoteException {
    }

    public HonorOAIDCallback() {
        this.oaid = "";
    }

    public String getOaid() {
        return this.oaid;
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void handleResult(int r100, Bundle r101) throws RemoteException {
        t.a("honor# OAIDCallBack handleResult retCode= " + r100 + " retInfo= " + r101);
        if (r100 != 0) goto L7;
        if (r101 == null) goto L8;
        this.oaid = r101.getString("oa_id_flag");
        t.a("honor# OAIDCallBack handleResult success " + this.oaid);
        return;
    L8:
        return;
    }
}
