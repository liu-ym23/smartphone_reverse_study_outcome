package com.bytedance.lynx.webview.glue.sdk112;

import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface ISdkToGlueSdk112 {
    boolean CheckGlueVersion(String r100);

    boolean CheckSdkVersion(String r100);

    void onCallMS(String r100);

    void preconnectUrl(String r100, int r101);

    boolean setCustomedHeaders(Map<String, String> r100);
}
