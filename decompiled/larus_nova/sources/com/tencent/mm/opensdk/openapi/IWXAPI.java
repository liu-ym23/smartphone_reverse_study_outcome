package com.tencent.mm.opensdk.openapi;

import android.content.Intent;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.ILog;

/* JADX INFO: loaded from: classes40.dex */
public interface IWXAPI {
    void detach();

    int getWXAppSupportAPI();

    boolean handleIntent(Intent r100, IWXAPIEventHandler r101);

    boolean isWXAppInstalled();

    boolean openWXApp();

    boolean registerApp(String r100);

    boolean registerApp(String r100, long r101);

    boolean sendReq(BaseReq r100);

    boolean sendReq(BaseReq r100, SendReqCallback r101);

    boolean sendResp(BaseResp r100);

    void setLogImpl(ILog r100);

    void unregisterApp();
}
