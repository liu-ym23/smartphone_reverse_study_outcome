package com.ss.android.lark.monitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public abstract class e extends d {
    protected boolean isAppFront;
    protected i mMetricsConfig;

    public abstract void pauseScene(String r100);

    public abstract void startScene(String r100);

    public abstract void stopScene(String r100, JSONObject r101);

    public e() {
    }

    public e(i r100) {
        this.mMetricsConfig = r100;
    }
}
