package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes10.dex */
public interface LocationListener {
    Executor callbackExecutor();

    void onLocation(LocationOutput r100);
}
