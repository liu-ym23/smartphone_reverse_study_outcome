package com.volcengine.zeus.apm;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsApm {
    public AbsApm() {
    }

    public abstract String getDid();

    public abstract void init();

    public abstract void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    public abstract void reportError(String r100, Throwable r101);
}
