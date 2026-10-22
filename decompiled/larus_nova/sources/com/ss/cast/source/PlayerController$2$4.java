package com.ss.cast.source;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
class PlayerController$2$4 extends HashMap<String, String> {
    final /* synthetic */ l this$1;
    final /* synthetic */ int val$errCode;
    final /* synthetic */ String val$errMsg;

    public PlayerController$2$4(l r100, String r101, int r102) {
        this.val$errMsg = r101;
        this.val$errCode = r102;
        put("state", "failure");
        put(LocationMonitorConst.ERR_MSG, r101);
        put("err_code", String.valueOf(r102));
        throw null;
    }
}
