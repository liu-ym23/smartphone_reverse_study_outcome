package com.ss.cast.source.api;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
class ByteCastSource$5$2 extends HashMap<String, String> {
    final /* synthetic */ h this$1;
    final /* synthetic */ int val$extra;
    final /* synthetic */ int val$what;

    public ByteCastSource$5$2(h r100, int r101, int r102) {
        this.val$extra = r101;
        this.val$what = r102;
        put("state", "failure");
        put(LocationMonitorConst.ERR_MSG, String.valueOf(r101));
        put("err_code", String.valueOf(r102));
    }
}
