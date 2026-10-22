package com.bytedance.crypto.monitor;

import com.bytedance.crypto.monitor.proto.CloudSyncData;
import com.bytedance.crypto.monitor.proto.CryptoSDKInfo;
import com.bytedance.crypto.monitor.proto.ErrorTrace;
import com.bytedance.crypto.monitor.proto.NormalTrace;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes15.dex */
public class ErrorEvent {
    private static final String TAG = "ErrorEvent";

    public ErrorEvent() {
    }

    public static void eventTrace(int r100, int r101, String r102, String r103, int r104, long r105, Object r106) {
        LogUtils.i(TAG, "eventTrace, module: " + r100 + ", event: " + r101 + ", pkgName: " + r102 + ", appid: " + r103 + ", errCode: " + r104);
        ErrorTrace r107 = ErrorTrace.newBuilder().setModuleId(r100).setEventId(r101).setPackageName(r102).setErrCode(r104).build();
        if (r106 != null) goto L5;
    L7:
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addErrorTrace(r107).addNormalTrace(NormalTrace.newBuilder().setModuleId(r100).setEventId(r101).setPackageName(r102).setAppId(r103).setUserid(0).setErrCode(r104).setTotalCalls(1).setTimeConsumption(r105).setTotalDataSize(0)).build().toBuilder());
        return;
    L5:
        if ((r106 instanceof CloudSyncData) == false) goto L7;
        r107 = r107.toBuilder().setCloudSyncData((CloudSyncData) r106).build();
        goto L7
    }
}
