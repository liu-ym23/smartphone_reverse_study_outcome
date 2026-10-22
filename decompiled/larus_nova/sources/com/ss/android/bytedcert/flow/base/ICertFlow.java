package com.ss.android.bytedcert.flow.base;

import com.ss.android.bytedcert.config.ThemeConfig;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface ICertFlow {
    ThemeConfig getThemeConfig();

    void onEvent(String r100, JSONObject r101);

    void setTimestamp(String r100, String r101);
}
