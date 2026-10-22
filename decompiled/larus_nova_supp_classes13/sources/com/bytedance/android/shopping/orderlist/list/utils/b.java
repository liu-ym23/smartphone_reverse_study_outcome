package com.bytedance.android.shopping.orderlist.list.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Executor {
    public b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(r3);
    }
}
