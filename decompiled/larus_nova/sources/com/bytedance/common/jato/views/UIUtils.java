package com.bytedance.common.jato.views;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes15.dex */
public class UIUtils {

    public static final class ViewCalledFromWrongThreadException extends AndroidRuntimeException {
        public ViewCalledFromWrongThreadException(String r100) {
            super(r100);
        }
    }

    public static void checkRunOnUIThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L6;
        return;
    L6:
        throw new ViewCalledFromWrongThreadException("Only the original thread that created a view hierarchy can touch its views.");
    }
}
