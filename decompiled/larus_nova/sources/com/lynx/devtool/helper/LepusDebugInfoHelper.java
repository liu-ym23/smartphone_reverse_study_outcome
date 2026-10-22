package com.lynx.devtool.helper;

import b5a.a;
import com.lynx.tasm.base.LLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public class LepusDebugInfoHelper {
    private static final String TAG = "LepusDebugInfoHelper";
    private String mDebugInfo;
    private AtomicBoolean mIsLoading;

    public LepusDebugInfoHelper() {
        this.mIsLoading = new AtomicBoolean(false);
    }

    public static /* synthetic */ AtomicBoolean access$100(LepusDebugInfoHelper r100) {
        return r100.mIsLoading;
    }

    private void downloadDebugInfo(String r100) {
        new a(r100, new AnonymousClass1(this));
    }

    public String getDebugInfo(String r100) {
        LLog.i(TAG, "lepus debug: debug info url: " + r100);
        this.mIsLoading.set(true);
        downloadDebugInfo(r100);
    L11:
    L7:
        e = move-exception;
        LLog.e(TAG, e.toString());
    L10:
        return this.mDebugInfo;
    L4:
        if (this.mIsLoading.get() == false) goto L10;
        Thread.sleep(10);     // Catch: InterruptedException -> L7
        goto L11
    }

    public static /* synthetic */ String access$002(LepusDebugInfoHelper r100, String r101) {
        r100.mDebugInfo = r101;
        return r101;
    }
}
