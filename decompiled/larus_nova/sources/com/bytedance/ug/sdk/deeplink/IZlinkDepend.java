package com.bytedance.ug.sdk.deeplink;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IZlinkDepend {
    boolean dealWithClipboard(boolean r100, String r101, boolean r102);

    boolean dealWithSchema(String r100);

    long delayMillis();

    String getAppId();

    List<String> getDeepLinkActivities();

    String getDeviceId();

    List<String> getSchemeList();

    long getUpdateVersionCode();

    boolean isConfirmedPrivacy();

    void log(int r100, String r101, String r102, Throwable r103);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void onEvent(String r100, JSONObject r101);

    boolean settingsRefactorEnable();
}
