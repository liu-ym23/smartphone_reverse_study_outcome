package com.bytedance.ee.bear.doc.resupdate;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface h {
    void a(String r1, JSONObject r2);

    String b(Context r1);

    long c();

    String d();

    int getAppId();

    String getDeviceId();

    boolean isBoe();

    boolean isEnable(String r1);
}
