package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MiscConfigManager {
    private static volatile MiscConfigManager mInstance;
    private final List<String> mRequestLogHeaderRmList;

    public static MiscConfigManager inst() {
        if (mInstance != null) goto L15;
        monitor-enter(MiscConfigManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new MiscConfigManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MiscConfigManager.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private MiscConfigManager() {
        this.mRequestLogHeaderRmList = new CopyOnWriteArrayList();
    }

    public List<String> getRequestLogHeaderRmList() {
        return this.mRequestLogHeaderRmList;
    }

    public void onServerConfigChanged(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        TTConfigManager.parseJsonArray(r100, "log_header_rm_list", this.mRequestLogHeaderRmList);
    }
}
