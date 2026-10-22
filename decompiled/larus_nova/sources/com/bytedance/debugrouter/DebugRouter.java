package com.bytedance.debugrouter;

import android.content.Context;
import android.view.View;
import com.bytedance.debugrouter.app.MessageHandler;
import com.bytedance.debugrouter.report.DebugRouterReportServiceImpl;
import com.bytedance.debugrouter.usb.USBHijackServiceImpl;
import com.lynx.debugrouter.base.report.IDebugRouterReportService;
import com.lynx.debugrouter.base.service.DebugRouterServiceCenter;
import com.lynx.debugrouter.base.usb.IUSBHijackService;
import com.lynx.debugrouter.log.LLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class DebugRouter {
    private static volatile DebugRouter sInstance;

    public String getAppInfo() {
        return "";
    }

    public String getVersion() {
        return BuildConfig.DEBUGROUTER_VERSION;
    }

    public static DebugRouter getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DebugRouter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DebugRouter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DebugRouter.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Map<Integer, DebugRouterSlot> getSlots() {
        return new HashMap();
    }

    private DebugRouter() {
        LLog.i("com.bytedance.DebugRouter", "DebugRouter register Service.");
        DebugRouterServiceCenter.instance().registerService(IDebugRouterReportService.class, new DebugRouterReportServiceImpl());
        DebugRouterServiceCenter.instance().registerService(IUSBHijackService.class, new USBHijackServiceImpl());
        LLog.i("com.bytedance.DebugRouter", "DebugRouter init");
        com.lynx.debugrouter.DebugRouter.getInstance();
    }

    public static int getUSBPort() {
        com.lynx.debugrouter.DebugRouter.getInstance();
        return com.lynx.debugrouter.DebugRouter.getUSBPort();
    }

    public void disableDebugChannel() {
        com.lynx.debugrouter.DebugRouter.getInstance().disableDebugChannel();
    }

    public void enableAllSessions() {
        com.lynx.debugrouter.DebugRouter.getInstance().enableAllSessions();
    }

    public void enableDebugChannel() {
        com.lynx.debugrouter.DebugRouter.getInstance().enableDebugChannel();
    }

    public ConnectionState getConnectionState() {
        com.lynx.debugrouter.ConnectionState r100 = com.lynx.debugrouter.DebugRouter.getInstance().getConnectionState();
        if (r100 != com.lynx.debugrouter.ConnectionState.DISCONNECTED) goto L7;
        return ConnectionState.DISCONNECTED;
    L7:
        if (r100 != com.lynx.debugrouter.ConnectionState.DISCONNECTING) goto L11;
        return ConnectionState.DISCONNECTING;
    L11:
        if (r100 != com.lynx.debugrouter.ConnectionState.CONNECTING) goto L15;
        return ConnectionState.CONNECTING;
    L15:
        return ConnectionState.CONNECTED;
    }

    public String getInternalVersion() {
        return com.lynx.debugrouter.DebugRouter.getInstance().getVersion();
    }

    public String getServerUrl() {
        return com.lynx.debugrouter.DebugRouter.getInstance().getServerUrl();
    }

    public boolean isDebugChannelEnabled() {
        return com.lynx.debugrouter.DebugRouter.getInstance().isDebugChannelEnabled();
    }

    public void addGlobalHandler(DebugRouterGlobalHandler r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.lynx.debugrouter.DebugRouter.getInstance().addGlobalHandler(r100);
    }

    public void addMessageHandler(final MessageHandler r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.lynx.debugrouter.DebugRouter.getInstance().addMessageHandler(new AnonymousClass2(this, r100));
    }

    public void addSessionHandler(DebugRouterSessionHandler r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.lynx.debugrouter.DebugRouter.getInstance().addSessionHandler(r100);
    }

    public void addStateListener(final StateListener r100) {
        com.lynx.debugrouter.DebugRouter.getInstance().addStateListener(new AnonymousClass1(this, r100));
    }

    public void enableSingleSession(int r100) {
        com.lynx.debugrouter.DebugRouter.getInstance().enableSingleSession(r100);
    }

    public String getAppInfoByKey(String r100) {
        return com.lynx.debugrouter.DebugRouter.getInstance().getAppInfoByKey(r100);
    }

    public int getSessionIdByView(View r100) {
        return com.lynx.debugrouter.DebugRouter.getInstance().getSessionIdByView(r100);
    }

    public View getViewBySessionId(int r100) {
        return com.lynx.debugrouter.DebugRouter.getInstance().getViewBySessionId(r100);
    }

    public boolean handleSchema(String r100) {
        return com.lynx.debugrouter.DebugRouter.getInstance().handleSchema(r100);
    }

    public boolean isValidSchema(String r100) {
        return com.lynx.debugrouter.DebugRouter.getInstance().isValidSchema(r100);
    }

    public boolean removeGlobalHandler(DebugRouterGlobalHandler r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return com.lynx.debugrouter.DebugRouter.getInstance().removeGlobalHandler(r100);
    }

    public boolean removeSessionHandler(DebugRouterSessionHandler r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return com.lynx.debugrouter.DebugRouter.getInstance().removeSessionHandler(r100);
    }

    public void sendAsync(String r100) {
        com.lynx.debugrouter.DebugRouter.getInstance().sendAsync(r100);
    }

    public void setAppInfo(Map<String, String> r100) {
        com.lynx.debugrouter.DebugRouter.getInstance().setAppInfo(r100);
    }

    public void setAppInfo(Context r100, Map<String, String> r101) {
        com.lynx.debugrouter.DebugRouter.getInstance().setAppInfo(r100, r101);
    }

    public void setSessionIdOfView(View r100, int r101) {
        com.lynx.debugrouter.DebugRouter.getInstance().setSessionIdOfView(r100, r101);
    }

    public void sendData(String r100, int r101, String r102) {
        com.lynx.debugrouter.DebugRouter.getInstance().sendData(r100, r101, r102);
    }

    public void sendDataAsync(String r100, int r101, String r102) {
        com.lynx.debugrouter.DebugRouter.getInstance().sendDataAsync(r100, r101, r102);
    }

    public void sendDataAsync(String r100, int r101, JSONObject r102) {
        com.lynx.debugrouter.DebugRouter.getInstance().sendDataAsync(r100, r101, r102);
    }
}
