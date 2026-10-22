package com.bytedance.ttnet;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ITTNetDepend {
    int checkHttpRequestException(Throwable r100, String[] r101);

    String executeGet(int r100, String r101) throws Exception;

    String getApiIHostPrefix();

    int getAppId();

    String getCdnHostSuffix();

    String[] getConfigServers();

    Context getContext();

    ArrayList<String> getCookieFlushPathList();

    Map<String, String> getHostReverseMap();

    String getHostSuffix();

    int getProviderInt(Context r100, String r101, int r102);

    String getProviderString(Context r100, String r101, String r102);

    String getShareCookieMainDomain();

    Map<String, String> getTTNetServiceDomainMap();

    boolean isCronetPluginInstalled();

    boolean isPrivateApiAccessEnabled();

    void mobOnEvent(Context r100, String r101, String r102, JSONObject r103);

    void monitorLogSend(String r100, JSONObject r101);

    void onAppConfigUpdated(Context r100, JSONObject r101);

    void onColdStartFinish();

    void onNetConfigUpdate(JSONObject r100, boolean r101);

    void onShareCookieConfigUpdated(String r100);

    void saveMapToProvider(Context r100, Map<String, ?> r101);
}
