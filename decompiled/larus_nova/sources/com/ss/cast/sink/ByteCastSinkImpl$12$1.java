package com.ss.cast.sink;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
class ByteCastSinkImpl$12$1 extends HashMap<String, String> {
    final /* synthetic */ e this$1;
    final /* synthetic */ int val$errCode;
    final /* synthetic */ String val$errMsg;

    public ByteCastSinkImpl$12$1(e r100, String r101, int r102) {
        this.val$errMsg = r101;
        this.val$errCode = r102;
        put("state", "failure");
        put(LocationMonitorConst.ERR_MSG, r101);
        put("err_code", String.valueOf(r102));
    }
}
