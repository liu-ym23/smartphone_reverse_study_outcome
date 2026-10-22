package com.bytedance.reparo;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IReparoConfig {
    public IReparoConfig() {
    }

    public boolean autoFailThenSyncMode() {
        return false;
    }

    public boolean autoFetchPatch() {
        return false;
    }

    public abstract boolean enable();

    public abstract String executePatchRequest(int r100, String r101, byte[] r102, String r103) throws Exception;

    public abstract String getAppId();

    public abstract Application getApplication();

    public abstract String getChannel();

    public abstract String getDeviceId();

    public abstract String getUpdateVersionCode();

    public abstract boolean isMainProcess();

    public c97.a getAbiHelper(Application r100) {
        return new c97.b(r100);
    }
}
