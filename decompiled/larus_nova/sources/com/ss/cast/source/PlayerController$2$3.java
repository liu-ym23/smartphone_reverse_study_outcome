package com.ss.cast.source;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
class PlayerController$2$3 extends HashMap<String, String> {
    final /* synthetic */ l this$1;
    final /* synthetic */ int val$err;
    final /* synthetic */ String val$errDesc;

    public PlayerController$2$3(l r100, String r101, int r102) {
        this.val$errDesc = r101;
        this.val$err = r102;
        put("state", "failure");
        put(LocationMonitorConst.ERR_MSG, r101);
        put("err_code", String.valueOf(r102));
        throw null;
    }
}
