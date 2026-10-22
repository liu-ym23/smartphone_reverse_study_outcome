package com.bytedance.common.wschannel;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelSettings {
    private static final String TAG = null;
    private static volatile WsChannelSettings mInstance;
    private static final AtomicReference<WsLoginAuthStrategy$LoginCallback> sLoginCallback = null;
    private final WsChannelMultiProcessSharedProvider.MultiProcessShared multiProcessShared;

    /* JADX INFO: loaded from: classes15.dex */
    public interface OkOpaqueCallback {
    }

    public static OkOpaqueCallback getOkOpaqueCallback() {
        return null;
    }

    static {
        TAG = WsChannelSettings.class.getName();
        sLoginCallback = new AtomicReference();
    }

    public static WsLoginAuthStrategy$LoginCallback getLoginAuthCallback() {
        return sLoginCallback.get();
    }

    public ArrayList<Integer> getAutoConnectDisabledChannelIds() {
        ArrayList<Integer> r100 = new ArrayList();
        String r101 = this.multiProcessShared.getString(WsConstants.KEY_AUTO_CONNECT_DISABLED, "");
        if (TextUtils.isEmpty(r101) == false) goto L16;
        return r100;
    L16:
        JSONArray r102 = new JSONArray(r101);     // Catch: JSONException -> L13
        int r103 = 0;
    L7:
        if (r103 >= r102.length()) goto L10;
        r100.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r102, r103)));     // Catch: JSONException -> L13
        r103 = r103 + 1;     // Catch: JSONException -> L13
        goto L7
    L10:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "getAutoConnectDisabledChannelIds: " + r100);     // Catch: JSONException -> L13
    L15:
        return r100;
    L13:
        e = move-exception;
        Logger.e(TAG, e.getMessage());
        goto L15
    }

    public long getRetryDelay() {
        return this.multiProcessShared.getLong(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);
    }

    public long getSocketReadLimitSize() {
        return this.multiProcessShared.getLong(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public String getWsApp() {
        return this.multiProcessShared.getString(WsConstants.KEY_WS_APPS, "");
    }

    public boolean isEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public boolean isEnableOfflineDetect() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_ENABLE_OFFLINE_DETECT, false);
    }

    public boolean isOkChannelEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public boolean isReportAppStateEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    private WsChannelSettings(Context r100) {
        this.multiProcessShared = WsChannelMultiProcessSharedProvider.getMultiprocessShared(r100.getApplicationContext());
    }

    public static WsChannelSettings inst(Context r100) {
        if (mInstance != null) goto L15;
        monitor-enter(WsChannelSettings.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new WsChannelSettings(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(WsChannelSettings.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void setAutoConnectDisabledChannelIds(ArrayList<Integer> r100) {
        if (r100 != null) goto L15;
        return;
    L15:
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L12
        Iterator<Integer> r102 = r100.iterator();     // Catch: Exception -> L12
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.put(r102.next().intValue());     // Catch: Exception -> L12
        goto L6
    L8:
        this.multiProcessShared.edit().putString(WsConstants.KEY_AUTO_CONNECT_DISABLED, r101.toString()).commit();     // Catch: Exception -> L12
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "setAutoConnectDisabledChannelIds: " + r101);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        Logger.e(TAG, e.getMessage());
    }

    public void setEnable(boolean r100) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_FRONTIER_ENABLED, r100).commit();
    }

    public void setEnableOfflineDetect(boolean r100) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_ENABLE_OFFLINE_DETECT, r100).commit();
    }

    public void setOKChannelEnable(boolean r100) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_OK_IMPL_ENABLE, r100).commit();
    }

    public void setReportAppStateEnable(boolean r100) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_ENABLE_REPORT_APP_STATE, r100).apply();
    }

    public void setRetrySendMsgDelay(long r100) {
        this.multiProcessShared.edit().putLong(WsConstants.KEY_RETRY_SEND_MSG_DELAY, r100).commit();
    }

    public void setSocketReadLimitSize(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        this.multiProcessShared.edit().putLong(WsConstants.KEY_IO_LIMIT, r100).commit();
    }

    public void setWsApp(String r100) {
        this.multiProcessShared.edit().putString(WsConstants.KEY_WS_APPS, r100).commit();
    }
}
