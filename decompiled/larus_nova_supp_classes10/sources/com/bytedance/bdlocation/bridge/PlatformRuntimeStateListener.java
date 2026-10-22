package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface PlatformRuntimeStateListener {
    public static final int STATE_TYPE_LIFE_ID = 2;
    public static final int STATE_TYPE_MOTION_MODE = 3;
    public static final int STATE_TYPE_NAV_ID = 1;

    Executor callbackExecutor();

    void onRuntimeStateUpdated(int r1, String r2);
}
