package com.bytedance.common.wschannel.utils;

import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes15.dex */
public class WsThreadFactory implements ThreadFactory {
    private static final String TAG = null;
    private final String mThreadName;

    static {
        TAG = "WsThreadFactory";
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public WsThreadFactory(String r100) {
        this.mThreadName = "WsChannel-" + r100;
    }

    public static /* synthetic */ String access$100(WsThreadFactory r100) {
        return r100.mThreadName;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "creating newThread " + this.mThreadName);
    L6:
        return new PthreadThreadV2(new AnonymousClass1(this, r100), this.mThreadName);
    }
}
