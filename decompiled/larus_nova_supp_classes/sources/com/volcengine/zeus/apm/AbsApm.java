package com.volcengine.zeus.apm;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class AbsApm {
    public AbsApm() {
    }

    public abstract String getDid();

    public abstract void init();

    public abstract void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    public abstract void reportError(String r1, Throwable r2);
}
