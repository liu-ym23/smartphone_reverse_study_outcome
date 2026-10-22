package com.huawei.agconnect;

import com.huawei.agconnect.core.a.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AGCInitFinishManager {
    private static final AGCInitFinishManager INSTANCE = null;

    /* JADX INFO: loaded from: classes23.dex */
    public interface AGCInitFinishCallback {
        void onFinish();
    }

    static {
        INSTANCE = new a();
    }

    public AGCInitFinishManager() {
    }

    public static AGCInitFinishManager getInstance() {
        return INSTANCE;
    }

    public abstract void addAGCInitFinishCallback(AGCInitFinishCallback r100);
}
