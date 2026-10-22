package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes15.dex */
class WsChannelSaver implements IWsChannelSaver {
    private static final String TAG = null;
    private final Context mContext;

    static {
        TAG = "WsChannelSaver";
    }

    @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
    public Map<Integer, IWsApp> loadWsChannels() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = WsChannelSettings.inst(this.mContext).getWsApp();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L7;
        Logger.d(TAG, "load from sp wsAppStr: " + r101);     // Catch: Exception -> L29
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return r100;
    L9:
        JSONArray r102 = new JSONArray(r101);     // Catch: Exception -> L29
        int r103 = r102.length();     // Catch: Exception -> L29
        if (r103 > 0) goto L12;
        return r100;
    L12:
        ArrayList<Integer> r104 = WsChannelSettings.inst(this.mContext).getAutoConnectDisabledChannelIds();     // Catch: Exception -> L29
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "load from sp disabledList: " + r104);     // Catch: Exception -> L29
    L15:
        int r105 = 0;
    L16:
        if (r105 >= r103) goto L26;
        SsWsApp r106 = new SsWsApp.SsWsAppBuilder().buildFromJson(r102.optJSONObject(r105));     // Catch: Exception -> L29
        if (checkValidWsApp(r106) == false) goto L24;
        if (r104 != null) goto L21;
    L23:
        r100.put(Integer.valueOf(WsChannelService.getClientKey(r106)), r106);     // Catch: Exception -> L29
        goto L24
    L21:
        if (r104.contains(Integer.valueOf(WsChannelService.getClientKey(r106))) == false) goto L23;
    L24:
        r105 = r105 + 1;     // Catch: Exception -> L29
        goto L16
    L26:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "loadWsChannels final wsApp: " + r100);     // Catch: Exception -> L29
    L31:
        return r100;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    public WsChannelSaver(Context r100) {
        this.mContext = r100;
    }

    private boolean checkValidWsApp(IWsApp r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getChannelId() > 0) goto L9;
        return false;
    L9:
        if (r100.getAppId() > 0) goto L12;
        return false;
    L12:
        if (StringUtils.isEmpty(r100.getAppKey()) == false) goto L15;
        return false;
    L15:
        if (r100.getAppVersion() > 0) goto L18;
        return false;
    L18:
        if (r100.getConnectUrls().isEmpty() == false) goto L21;
        return false;
    L21:
        if (StringUtils.isEmpty(r100.getDeviceId()) == false) goto L24;
        return false;
    L24:
        if (r100.getFPID() > 0) goto L27;
        return false;
    L27:
        if (StringUtils.isEmpty(r100.getInstallId()) == false) goto L30;
        return false;
    L30:
        if (r100.getPlatform() == 0) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
    public void saveWsChannels(Map<Integer, IWsApp> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONArray r101 = new JSONArray();
        monitor-enter(WsChannelService.class);
        Iterator<Map.Entry<Integer, IWsApp>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<Integer, IWsApp> r103 = r102.next();     // Catch: Throwable -> L22
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L8
    L11:
        if (checkValidWsApp(r103.getValue()) == false) goto L8;
        r101.put(r103.getValue().toJson());     // Catch: Exception -> L14 Throwable -> L22
    L16:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L22
        Logger.d(TAG, "save to sp : " + r101.toString());     // Catch: Exception -> L19
        WsChannelSettings.inst(this.mContext).setWsApp(r101.toString());     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
