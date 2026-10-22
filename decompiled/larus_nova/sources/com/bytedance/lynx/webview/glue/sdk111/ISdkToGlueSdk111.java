package com.bytedance.lynx.webview.glue.sdk111;

import android.webkit.WebViewFactoryProvider;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface ISdkToGlueSdk111 {
    Map<String, String> getCrashInfo();

    String getLatestUrl();

    WebViewFactoryProvider getProviderInstance(String r100);

    int getWebViewCount();

    boolean isAdblockEnable();

    void loadLibrary(String r100);

    void notifyAppInfoGetterAvailable();

    boolean setAdblockDeserializeFile(String r100, String r101);

    boolean setAdblockEnable(boolean r100);

    boolean setAdblockRulesPath(String[] r100, String[] r101);

    void setJsonObject(JSONObject r100);

    void setPreconnectUrl(String r100, int r101);
}
