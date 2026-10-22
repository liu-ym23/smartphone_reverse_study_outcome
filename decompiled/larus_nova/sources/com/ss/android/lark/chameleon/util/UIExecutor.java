package com.ss.android.lark.chameleon.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes35.dex */
public class UIExecutor {
    private Handler mUIHandler;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.util.UIExecutor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class UIExecutorHolder {
        static final UIExecutor INSTANCE = null;

        private UIExecutorHolder() {
        }

        static {
            INSTANCE = new UIExecutor(null);
        }
    }

    private UIExecutor() {
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public static boolean checkUiThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static UIExecutor executor() {
        return UIExecutorHolder.INSTANCE;
    }

    public /* synthetic */ UIExecutor(AnonymousClass1 r100) {
        this();
    }

    public void post(Runnable r100) {
        this.mUIHandler.post(r100);
    }
}
