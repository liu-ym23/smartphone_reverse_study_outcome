package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public interface h {
    void a(String r100, JSONObject r101);

    String b(Context r100);

    long c();

    String d();

    int getAppId();

    String getDeviceId();

    boolean isBoe();

    boolean isEnable(String r100);
}
