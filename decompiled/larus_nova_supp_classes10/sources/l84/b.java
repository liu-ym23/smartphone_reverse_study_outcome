package l84;

import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ LBSLightLocationTraceLogger b;
    public final /* synthetic */ LocationOption c;
    public final /* synthetic */ List d;
    public final /* synthetic */ l0 e;

    public /* synthetic */ b(k r1, LBSLightLocationTraceLogger r2, LocationOption r3, List r4, l0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r0 = this.a;
        LBSLightLocationTraceLogger r2 = this.b;
        LocationOption r3 = this.c;
        List r10 = this.d;
        l0 r12 = this.e;
        r0.getClass();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r2, LBSLightLocationTraceLogger.SWITCH_THREAD_SECOND_TIME);
        Logger.i("performLBSLightSubmitV2 executed.");
        LBSLightLocationTraceLogger r13 = r3.getLBSLightLocationTraceLogger();
        LocInfoRspData r4 = ServerApi.doLightLocationSubmitV2(r3.startLocationTimestampInMillis, r3.getUploadSource(), r3.getTriggerType(), BDLocationConfig.isEnableLocationOptEncrypt(), r13, r10, r3.getLocateId());     // Catch: Throwable -> L24
        if (r4 == null) goto L35;
        BDLocation r5 = LocationUtil.locationResultToBDLocation(new BDLocation("network", LocationInfoConst.LIGHT), r4.location);     // Catch: Throwable -> L24
        if (r5 == null) goto L13;
        r5.setLocationSDKName(LocationInfoConst.LIGHT);     // Catch: Throwable -> L24
        if (r5.getGCJ02() != null) goto L13;
        if (LocationInfoConst.GCJ_O2.equals(r5.getCoordinateSystem()) == false) goto L13;
        r5.setGCJ02(new BDPoint(r5.getLatitude(), r5.getLongitude(), r5.getProvider(), LocationInfoConst.GCJ_O2));     // Catch: Throwable -> L24
    L13:
        if (TextUtils.isEmpty(r4.submitLogId) == true) goto L16;
        if (r5 == null) goto L16;
        r5.setSubmitLogId(r4.submitLogId);     // Catch: Throwable -> L24
    L16:
        r3.setLightLocation(r5);     // Catch: Throwable -> L24
        Boolean r1 = r3.getAcceptLightLocationResult();     // Catch: Throwable -> L24
        if (r1 != null) goto L19;
        boolean r6 = BDLocationConfig.enablePreLocationCallback();     // Catch: Throwable -> L24
    L20:
        Logger.i("location-trace-core enablePreLocationCallback: " + r6);     // Catch: Throwable -> L24
        if (r6 == false) goto L36;
        r12.a(r5);     // Catch: Throwable -> L24
        return;
    L36:
        return;
    L19:
        r6 = r1.booleanValue();     // Catch: Throwable -> L24
        goto L20
    L35:
        return;
    L24:
        th = move-exception;
        Logger.i("doLightLocationSubmitV2 failed: " + th);
        if (r13 != null) goto L28;
        return;
    L28:
        if (th.getMessage() != null) goto L30;
        String r7 = "empty";
    L31:
        r13.reportLBSLightLocationFailed(BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED, r7);
        return;
    L30:
        r7 = th.getMessage();
        goto L31
    }
}
