package com.ss.cast.source;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
class ByteCastSourceImpl$SinkDeviceInfoListenerWrapper$3 extends HashMap<String, String> {
    final /* synthetic */ ByteCastSourceImpl.p this$1;
    final /* synthetic */ int val$errCode;
    final /* synthetic */ String val$errMsg;

    public ByteCastSourceImpl$SinkDeviceInfoListenerWrapper$3(ByteCastSourceImpl.p r100, int r101, String r102) {
        this.val$errCode = r101;
        this.val$errMsg = r102;
        put("err_code", String.valueOf(r101));
        put(LocationMonitorConst.ERR_MSG, r102);
        throw null;
    }
}
