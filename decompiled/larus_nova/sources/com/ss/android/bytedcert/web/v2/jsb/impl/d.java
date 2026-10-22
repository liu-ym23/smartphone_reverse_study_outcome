package com.ss.android.bytedcert.web.v2.jsb.impl;

import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements SDKCallBack.VideoRecordCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBridgeContext f407968a;

    public d(IBridgeContext r100) {
        this.f407968a = r100;
    }

    @Override // com.ss.android.bytedcert.callback.SDKCallBack.VideoRecordCallback
    public final void onFinish(BDResponse r100, String r101, String r102) {
        JSONObject r103 = r100.jsonBody;     // Catch: Exception -> L7
        if (r103 != null) goto L5;
        r103 = new JSONObject();     // Catch: Exception -> L7
    L5:
        r103.put("status_code", r100.errorCode);     // Catch: Exception -> L7
        r103.put("description", r100.errorMsg);     // Catch: Exception -> L7
        r103.put("preview_image", r102);     // Catch: Exception -> L7
        this.f407968a.onSuccess(r103);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
