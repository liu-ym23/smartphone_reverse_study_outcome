package com.ss.android.cert.manager.web;

import com.ss.android.cert.manager.web.jsb.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IUserIdentityJsbDefine {
    void closeUserIdentityFlow(IBridgeContext r100, JSONObject r101);

    void notifyConfirmStatus(IBridgeContext r100, JSONObject r101);
}
