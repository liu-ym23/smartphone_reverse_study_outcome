package com.bytedance.sdk.open.aweme.share;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;

/* JADX INFO: loaded from: classes22.dex */
public class ShareDataHandler implements IDataHandler {
    public ShareDataHandler() {
    }

    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int r100, Bundle r101, IApiEventHandler r102) {
        if (r101 == null) goto L19;
        if (r102 == null) goto L19;
        if (r100 != 3) goto L14;
        Share.Request r103 = new Share.Request(r101);
        if (r103.checkArgs() == false) goto L12;
        r102.onReq(r103);
        return true;
    L12:
        return false;
    L14:
        if (r100 != 4) goto L19;
        Share.Response r104 = new Share.Response(r101);
        if (r104.checkArgs() == false) goto L19;
        r102.onResp(r104);
        return true;
    L19:
        return false;
    }
}
