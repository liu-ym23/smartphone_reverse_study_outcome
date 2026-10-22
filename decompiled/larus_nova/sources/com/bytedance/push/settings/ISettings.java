package com.bytedance.push.settings;

import android.content.Context;
import j77.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ISettings {
    void registerValChanged(Context r100, String r101, String r102, a r103);

    void unregisterValChanged(a r100);

    void updateSettings(Context r100, JSONObject r101);
}
