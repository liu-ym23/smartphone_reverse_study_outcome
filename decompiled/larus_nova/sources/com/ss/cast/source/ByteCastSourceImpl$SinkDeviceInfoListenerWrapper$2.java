package com.ss.cast.source;

import com.byted.cast.common.bean.SinkDeviceInfo;
import com.byted.cast.common.utils.GsonUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
class ByteCastSourceImpl$SinkDeviceInfoListenerWrapper$2 extends HashMap<String, String> {
    final /* synthetic */ ByteCastSourceImpl.p this$1;
    final /* synthetic */ SinkDeviceInfo val$sinkdeviceInfo;

    public ByteCastSourceImpl$SinkDeviceInfoListenerWrapper$2(ByteCastSourceImpl.p r100, SinkDeviceInfo r101) {
        this.val$sinkdeviceInfo = r101;
        put("device_info", GsonUtils.toJsonIgnoreException(r101));
        throw null;
    }
}
