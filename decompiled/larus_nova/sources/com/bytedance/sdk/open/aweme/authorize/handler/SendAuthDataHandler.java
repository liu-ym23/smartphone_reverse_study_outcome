package com.bytedance.sdk.open.aweme.authorize.handler;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;

/* JADX INFO: loaded from: classes22.dex */
public class SendAuthDataHandler implements IDataHandler {
    public SendAuthDataHandler() {
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int r100, Bundle r101, IApiEventHandler r102) {
        if (r101 == null) goto L28;
        if (r102 == null) goto L28;
        if (r100 != 1) goto L23;
        Authorization.Request r103 = new Authorization.Request(r101);
        if (r103.checkArgs() == false) goto L21;
        String r104 = r103.scope;
        if (r104 == null) goto L13;
        r103.scope = r104.replace(" ", "");
    L13:
        String r105 = r103.optionalScope1;
        if (r105 == null) goto L16;
        r103.optionalScope1 = r105.replace(" ", "");
    L16:
        String r106 = r103.optionalScope0;
        if (r106 == null) goto L19;
        r103.optionalScope0 = r106.replace(" ", "");
    L19:
        r102.onReq(r103);
        return true;
    L21:
        return false;
    L23:
        if (r100 != 2) goto L28;
        BaseResp r107 = new Authorization.Response(r101);
        if (r107.checkArgs() == false) goto L28;
        r102.onResp(r107);
        return true;
    L28:
        return false;
    }
}
