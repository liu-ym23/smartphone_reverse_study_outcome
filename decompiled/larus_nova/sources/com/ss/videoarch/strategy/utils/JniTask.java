package com.ss.videoarch.strategy.utils;

import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.network.ThreadPoolApi;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class JniTask {
    static final String TAG = "JniTaskQueue";
    private ThreadPoolApi mThreadPoolApi;

    public static class JniTaskInstance {
        private static final JniTask mInstance = null;

        private JniTaskInstance() {
        }

        static {
            mInstance = new JniTask();
        }

        public static /* synthetic */ JniTask access$000() {
            return mInstance;
        }
    }

    private native void nativeStart(boolean r100);

    public JniTask() {
        this.mThreadPoolApi = new ThreadPoolApi();
    }

    public static JniTask getInstance() {
        return JniTaskInstance.access$000();
    }

    public void Start() {
        final boolean r100 = true;
        if (LSSettings.inst().mEnableJniQueue == 1) goto L6;
        r100 = false;
    L6:
        this.mThreadPoolApi.execute(new AnonymousClass1(this, r100));
    }

    public static /* synthetic */ void access$100(JniTask r100, boolean r101) {
        r100.nativeStart(r101);
    }
}
