package com.bytedance.sdk.open.tt;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.douyin.ShareToContact;

/* JADX INFO: loaded from: classes22.dex */
public class d implements IDataHandler {
    public d() {
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int r100, Bundle r101, IApiEventHandler r102) {
        if (r101 == null) goto L19;
        if (r102 == null) goto L19;
        if (r100 != 5) goto L14;
        ShareToContact.Request r103 = new ShareToContact.Request(r101);
        if (r103.checkArgs() == false) goto L12;
        r102.onReq(r103);
        return true;
    L12:
        return false;
    L14:
        if (r100 != 6) goto L19;
        ShareToContact.Response r104 = new ShareToContact.Response(r101);
        if (r104.checkArgs() == false) goto L19;
        r102.onResp(r104);
        return true;
    L19:
        return false;
    }
}
