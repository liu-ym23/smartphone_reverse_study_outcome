package v67;

import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.push.interfaze.IClientIntelligenceService;
import com.bytedance.push.interfaze.IMonitor;
import com.bytedance.push.interfaze.IPushMsgHandler;
import com.bytedance.push.interfaze.IThirdSupportService;
import com.bytedance.push.log.ILogger;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface u {
    IClientIntelligenceService getClientIntelligenceService();

    Map<String, String> getCommonParams();

    com.bytedance.push.c getConfiguration();

    k getIProfileIdService();

    ILogger getLogger();

    f getMessageCallbackService();

    g getMessageSpreadOutService();

    IMonitor getMonitor();

    IMultiProcessEventSenderService getMultiProcessEventSenderService();

    IMultiProcessMonitor getMultiProcessMonitor();

    h getNotificationService();

    i getNotificationSwitchReport();

    j getProcessManagerService();

    IPushMsgHandler getPushHandler();

    m getPushNotificationManagerService();

    n getPushRedbadgeManager();

    IPushSdkMonitorService getPushSdkMonitorService();

    s getSenderService();

    t getSignalReportService();

    e getStatisticsService();

    v getSystemBroadcastService();

    IThirdSupportService getThirdService();

    w getTokenRetryService();

    void init(com.bytedance.push.c r100, d77.a r101);

    void init(n67.a r100);

    void requestSettings(boolean r100);

    void setFrontierSetting(JSONObject r100);
}
