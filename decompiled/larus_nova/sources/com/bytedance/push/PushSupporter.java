package com.bytedance.push;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alliance.IsSupportWakeUp;
import com.bytedance.android.service.manager.push.interfaze.IMultiProcessEventSenderService;
import com.bytedance.android.service.manager.push.monitor.IMultiProcessMonitor;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.client.intelligence.ClientIntelligenceServiceImpl;
import com.bytedance.push.event.sync.SignalReportServiceImpl;
import com.bytedance.push.interfaze.IClientIntelligenceService;
import com.bytedance.push.interfaze.IMonitor;
import com.bytedance.push.interfaze.IPushMsgHandler;
import com.bytedance.push.interfaze.IThirdSupportService;
import com.bytedance.push.log.ILogger;
import com.bytedance.push.monitor.MultiProcessMonitor;
import com.bytedance.push.monitor.PushSdkMonitorServiceImpl;
import com.bytedance.push.notification.PushMsgHandler;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.sys.broadcast.SystemBroadcastServiceImpl;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PushSupporter implements v67.u {
    private static PushSupporter supporter;
    private n67.a mAbsBDPushConfiguration;
    private volatile d77.a mCommonParamProvider;
    private volatile c mConfiguration;
    private volatile JSONObject mFrontierSetting;
    private volatile IClientIntelligenceService mIClientIntelligenceService;
    private volatile v67.t mIEventSyncService;
    private volatile v67.f mIMessageCallbackService;
    private volatile IMultiProcessMonitor mIMultiProcessMonitor;
    private volatile v67.j mIProcessManagerService;
    private volatile v67.k mIProfileIdService;
    private volatile v67.m mIPushNotificationManagerService;
    private volatile IPushSdkMonitorService mIPushSdkMonitorService;
    private volatile v67.v mISystemBroadcastService;
    private volatile v67.w mITokenRetryService;
    private x67.b mLogger;
    private volatile v67.g mMessageSpreadOutService;
    private volatile IMonitor mMonitor;
    private volatile v67.h mNotificationService;
    private volatile v67.i mNotificationSwitchReport;
    private volatile IPushMsgHandler mPushHandler;
    private volatile v67.n mRedbadgeManager;
    private volatile e0 mSenderService;
    private volatile f0 mThirdService;
    private volatile IMultiProcessEventSenderService multiProcessEventSenderService;

    static {
        supporter = new PushSupporter();
    }

    @Override // v67.u
    public IClientIntelligenceService getClientIntelligenceService() {
        if (this.mIClientIntelligenceService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIClientIntelligenceService != null) goto L8;
        this.mIClientIntelligenceService = new ClientIntelligenceServiceImpl(getConfiguration().f266761a);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIClientIntelligenceService;
    }

    public d77.a getCommonParamProvider() {
        if (this.mCommonParamProvider != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mCommonParamProvider != null) goto L8;
        this.mCommonParamProvider = new d77.a(getConfiguration());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mCommonParamProvider;
    }

    @Override // v67.u
    public c getConfiguration() {
        if (this.mConfiguration != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mConfiguration != null) goto L8;
        this.mConfiguration = c.O;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mConfiguration;
    }

    @Override // v67.u
    public v67.k getIProfileIdService() {
        if (this.mIProfileIdService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIProfileIdService != null) goto L8;
        this.mIProfileIdService = new f77.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIProfileIdService;
    }

    @Override // v67.u
    public v67.f getMessageCallbackService() {
        if (this.mIMessageCallbackService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIMessageCallbackService != null) goto L8;
        this.mIMessageCallbackService = new c77.c();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIMessageCallbackService;
    }

    @Override // v67.u
    public v67.g getMessageSpreadOutService() {
        if (this.mMessageSpreadOutService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mMessageSpreadOutService != null) goto L8;
        this.mMessageSpreadOutService = new f87.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mMessageSpreadOutService;
    }

    @Override // v67.u
    public IMonitor getMonitor() {
        if (this.mMonitor != null) goto L17;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.mMonitor == null) goto L8;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        goto L17
    L8:
        if (ToolUtils.isMainProcess(getConfiguration().f266761a) == false) goto L10;
        this.mMonitor = new z67.f();     // Catch: Throwable -> L13
        goto L11
    L10:
        this.mMonitor = new z67.g();     // Catch: Throwable -> L13
    L17:
        return this.mMonitor;
    }

    @Override // v67.u
    public IMultiProcessEventSenderService getMultiProcessEventSenderService() {
        if (this.multiProcessEventSenderService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.multiProcessEventSenderService != null) goto L8;
        this.multiProcessEventSenderService = new MultiProcessEventSenderService();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.multiProcessEventSenderService;
    }

    @Override // v67.u
    public IMultiProcessMonitor getMultiProcessMonitor() {
        if (this.mIMultiProcessMonitor != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIMultiProcessMonitor != null) goto L8;
        this.mIMultiProcessMonitor = new MultiProcessMonitor();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIMultiProcessMonitor;
    }

    @Override // v67.u
    public v67.h getNotificationService() {
        if (this.mNotificationService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mNotificationService != null) goto L8;
        this.mNotificationService = new com.bytedance.push.notification.n(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mNotificationService;
    }

    @Override // v67.u
    public v67.i getNotificationSwitchReport() {
        if (this.mNotificationSwitchReport != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mNotificationSwitchReport != null) goto L8;
        this.mNotificationSwitchReport = new k();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mNotificationSwitchReport;
    }

    @Override // v67.u
    public v67.j getProcessManagerService() {
        if (this.mIProcessManagerService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIProcessManagerService != null) goto L8;
        this.mIProcessManagerService = new e77.c(getConfiguration().f266761a);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIProcessManagerService;
    }

    @Override // v67.u
    public IPushMsgHandler getPushHandler() {
        if (this.mPushHandler != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mPushHandler != null) goto L8;
        this.mPushHandler = new PushMsgHandler(getConfiguration());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mPushHandler;
    }

    @Override // v67.u
    public v67.m getPushNotificationManagerService() {
        if (this.mIPushNotificationManagerService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIPushNotificationManagerService != null) goto L8;
        this.mIPushNotificationManagerService = new com.bytedance.push.notification.q();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIPushNotificationManagerService;
    }

    @Override // v67.u
    public v67.n getPushRedbadgeManager() {
        if (this.mRedbadgeManager != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mRedbadgeManager != null) goto L8;
        this.mRedbadgeManager = new h77.a(getConfiguration().f266761a);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mRedbadgeManager;
    }

    @Override // v67.u
    public IPushSdkMonitorService getPushSdkMonitorService() {
        if (this.mIPushSdkMonitorService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIPushSdkMonitorService != null) goto L8;
        this.mIPushSdkMonitorService = new PushSdkMonitorServiceImpl();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIPushSdkMonitorService;
    }

    @Override // v67.u
    public v67.s getSenderService() {
        if (this.mSenderService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mSenderService != null) goto L8;
        this.mSenderService = new e0();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mSenderService;
    }

    @Override // v67.u
    public v67.t getSignalReportService() {
        if (this.mIEventSyncService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mIEventSyncService != null) goto L8;
        this.mIEventSyncService = new SignalReportServiceImpl();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mIEventSyncService;
    }

    @Override // v67.u
    public v67.v getSystemBroadcastService() {
        if (this.mISystemBroadcastService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mISystemBroadcastService != null) goto L8;
        this.mISystemBroadcastService = new SystemBroadcastServiceImpl();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mISystemBroadcastService;
    }

    @Override // v67.u
    public IThirdSupportService getThirdService() {
        if (this.mThirdService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mThirdService != null) goto L8;
        this.mThirdService = new f0(getSenderService(), getPushHandler(), getConfiguration());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mThirdService;
    }

    @Override // v67.u
    public v67.w getTokenRetryService() {
        if (this.mITokenRetryService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mITokenRetryService != null) goto L8;
        this.mITokenRetryService = new k87.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.mITokenRetryService;
    }

    public PushSupporter() {
        this.mLogger = new x67.b();
    }

    public static ILogger logger() {
        return get().getLogger();
    }

    public static IMonitor monitor() {
        return get().getMonitor();
    }

    public static IPushMsgHandler pushHandler() {
        return get().getPushHandler();
    }

    public static v67.e statisticsService() {
        return get().getStatisticsService();
    }

    public static IThirdSupportService thirdService() {
        return get().getThirdService();
    }

    @Override // v67.u
    public Map<String, String> getCommonParams() {
        d77.a r100 = getCommonParamProvider();
        r100.getClass();
        HashMap r101 = new HashMap();
        if (r100.f467295a != null) goto L13;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (r100.f467295a != null) goto L8;
        r100.f467295a = c.O;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
    L13:
        Application r102 = r100.f467295a.f266761a;
        boolean r103 = false;
        boolean r104 = PushServiceManager.get().getIPushNotificationService().isSupportProxyNotification();     // Catch: Throwable -> L16
    L44:
        IsSupportWakeUp r105 = PushServiceManager.get().getIAllianceService().isSupportWakeUp(r102);     // Catch: Throwable -> L33
        if (r105 == null) goto L34;
        PushOnlineSettings r106 = (PushOnlineSettings) j77.i.a(r102, PushOnlineSettings.class);     // Catch: Throwable -> L33
        if (r106.P() != 1) goto L24;
        r103 = r105.mIsSupportWakeUp;     // Catch: Throwable -> L33
        goto L34
    L24:
        if (r106.P() != 2) goto L27;
        r103 = r105.mIsEnableWakeUp;     // Catch: Throwable -> L33
        goto L34
    L27:
        if (r106.P() != 3) goto L34;
        if (r105.mIsEnableWakeUp == false) goto L34;
        if (r105.mIsSupportWakeUp == false) goto L34;
        r103 = true;
    L34:
        if (r104 == false) goto L37;
        if (r103 == false) goto L37;
        String r107 = "3";
    L42:
        r101.put("proxy_support_type", r107);
        return PushCommonSupport.getInstance().getPushCommonParamService().getHttpCommonParams(r101);
    L37:
        if (r103 == false) goto L39;
        r107 = "1";
        goto L42
    L39:
        if (r104 == false) goto L41;
        r107 = "2";
        goto L42
    L41:
        r107 = "";
    L16:
        r104 = false;
        goto L44
    }

    public gfc.a getPushAdapter() {
        return com.bytedance.push.third.g.g();
    }

    @Override // v67.u
    public v67.e getStatisticsService() {
        return getConfiguration().f266773m;
    }

    public static v67.u get() {
        return supporter;
    }

    public JSONObject getFrontierSetting() {
        return this.mFrontierSetting;
    }

    @Override // v67.u
    public ILogger getLogger() {
        return this.mLogger;
    }

    @Override // v67.u
    public void init(n67.a r100) {
        this.mAbsBDPushConfiguration = r100;
    }

    @Override // v67.u
    public void requestSettings(boolean r100) {
        ThreadPlus.submitRunnable(new i87.a(r100));
    }

    @Override // v67.u
    public void setFrontierSetting(JSONObject r100) {
        this.mFrontierSetting = r100;
    }

    public String filterUrl(Context r100, String r101) {
        getConfiguration().getClass();
        return r101;
    }

    @Override // v67.u
    public void init(c r100, d77.a r101) {
        this.mConfiguration = r100;
        this.mCommonParamProvider = r101;
    }
}
