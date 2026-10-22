package l84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocationResp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m0 implements LocationUploadCallback {
    public final /* synthetic */ long a;
    public final /* synthetic */ BDLocation b;
    public final /* synthetic */ l0 c;

    @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
    public final void onError(String r5) {
        Logger.i("StationaryScene UpLoadCacheLocationInfo error: " + r5);
        LocationTraceLogger r0 = this.c.c.getLocationTraceLogger();
        LocationMonitor.locationTraceLogEnd(r0, "total_duration");
        r0.locationErrorReport(new BDLocationException(r5, "", "1001"));
    }

    public m0(l0 r1, long r2, BDLocation r4) {
        this.c = r1;
        this.a = r2;
        this.b = r4;
    }

    @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
    public final void onSuccess(LocationResp r7, boolean r8, WifiInfo r9) {
        LocationTraceLogger r10 = this.c.c.getLocationTraceLogger();
        LocationMonitor.locationTraceLogEnd(r10, "total_duration");
        LocationMonitor.locationTracePutMetricData(r10, LocationMonitorConst.UPLOAD_STATIONARY_CACHE_INFO_DURATION, System.currentTimeMillis() - this.a);
        if (r7 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        int r0 = -1001;
        String r1 = "error";
        if (r11 == false) goto L12;
        r10.locationSuccessReport(this.b, this.c.c);
    L20:
        StringBuilder r12 = new StringBuilder("StationaryScene UpLoadCacheLocationInfo success: ");
        r12.append(r11);
        r12.append("-resultCode: ");
        if (r7 == null) goto L24;
        r0 = r7.resultCode;
    L24:
        r12.append(r0);
        r12.append("-resultMsg: ");
        if (r7 == null) goto L28;
        r1 = r7.resultMsg;
    L28:
        r12.append(r1);
        Logger.i(r12.toString());
        return;
    L12:
        if (r7 != null) goto L14;
        String r3 = "error";
    L15:
        StringBuilder r4 = new StringBuilder();
        if (r7 != null) goto L18;
        int r5 = -1001;
    L19:
        r4.append(r5);
        r4.append("");
        r10.locationErrorReport(new BDLocationException(r3, "", r4.toString()));
        goto L20
    L18:
        r5 = r7.resultCode;
        goto L19
    L14:
        r3 = r7.resultMsg;
        goto L15
    L5:
        if (r7.resultCode != 0) goto L7;
        r11 = true;
        goto L8
    }
}
