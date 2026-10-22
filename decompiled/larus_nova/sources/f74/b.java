package f74;

import android.text.TextUtils;
import com.bytedance.map.api.MapGlobalConfig;
import com.bytedance.map.api.monitor.IMonitorDepend;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.common.applog.AppLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements IMonitorDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f475755a;

    public b() {
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final Map<String, String> getCommonParams() {
        return null;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final String getSessionId() {
        return null;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final List<String> getConfigUrls() {
        ArrayList r100 = new ArrayList();
        r100.add("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
        return r100;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final List<String> getReportUrls() {
        ArrayList r100 = new ArrayList();
        r100.add(ReportConstant.DEFAULT_URL_REPORT);
        return r100;
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final String getAppId() {
        if (TextUtils.isEmpty(MapGlobalConfig.getAppId()) == false) goto L5;
        return "1128";
    L5:
        return MapGlobalConfig.getAppId();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final String getAppVersion() {
        return MapGlobalConfig.getAppVersion();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final String getChannel() {
        return MapGlobalConfig.getChannel();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final String getDeviceId() {
        if (TextUtils.isEmpty(MapGlobalConfig.getDeviceId()) == true) goto L7;
        return MapGlobalConfig.getDeviceId();
    L7:
        return AppLog.v();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final String getPackageName() {
        return MapGlobalConfig.getPackageName();
    }

    @Override // com.bytedance.map.api.monitor.IMonitorDepend
    public final String getUpdateVersion() {
        return MapGlobalConfig.getUpdateVersion();
    }
}
