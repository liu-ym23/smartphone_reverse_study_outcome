package com.bytedance.bdlocation.bridge;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface LocationListener {
    Executor callbackExecutor();

    void onLocation(LocationOutput r1);
}
