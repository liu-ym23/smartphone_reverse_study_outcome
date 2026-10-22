package m84;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import l84.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static BDLocation a(LocationOption r2) throws BDLocationException {
        LocationTraceLogger r0 = new LocationTraceLogger();
        r0.begin("total_duration");
        r0.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        r2.setLocationTraceLogger(r0);
        LBSLightLocationTraceLogger r1 = new LBSLightLocationTraceLogger();
        r1.begin(LBSLightLocationTraceLogger.TOTAL);
        r1.begin(LBSLightLocationTraceLogger.PREPARE);
        r2.setLBSLightLocationTraceLogger(r1);
        return k.l().j(r2);
    }

    public static void b(LocationOption r3) {
        LocationTraceLogger r0 = new LocationTraceLogger();
        r0.begin("total_duration");
        r0.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        r3.setLocationTraceLogger(r0);
        LBSLightLocationTraceLogger r1 = new LBSLightLocationTraceLogger();
        r1.begin(LBSLightLocationTraceLogger.TOTAL);
        r1.begin(LBSLightLocationTraceLogger.PREPARE);
        r3.setLBSLightLocationTraceLogger(r1);
        k.l().v(new a(), r3, null, null);
    }

    public static void c(String r3, Object r4) {
        LocationOption r0 = new LocationOption();
        r0.setUploadSource(r3);
        r0.setMaxCacheTime(0);
        r0.setTriggerType(1);
        r0.setUpload(true);
        r0.setLocationTimeOutMs(0);
        r0.setLocateType(BDLocationConfig.getLocateType());
        r0.setBpeaCert(r4);
        r0.setBpeaAction("getLocation");
        b(r0);
    }
}
