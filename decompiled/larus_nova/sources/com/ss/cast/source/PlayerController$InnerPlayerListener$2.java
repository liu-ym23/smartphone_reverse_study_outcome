package com.ss.cast.source;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
class PlayerController$InnerPlayerListener$2 extends HashMap<String, String> {
    final /* synthetic */ k.b this$1;
    final /* synthetic */ int val$extra;
    final /* synthetic */ int val$what;

    public PlayerController$InnerPlayerListener$2(k.b r100, int r101, int r102) {
        this.val$extra = r101;
        this.val$what = r102;
        put("state", "failure");
        put(LocationMonitorConst.ERR_MSG, String.valueOf(r101));
        put("err_code", String.valueOf(r102));
    }
}
