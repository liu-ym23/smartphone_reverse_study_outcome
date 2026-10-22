package com.bytedance.common.jato;

import android.content.Context;
import com.bytedance.common.jato.logcut.LogCut;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class JatoXLConfig {
    public static int LOGCUT_ALL_LOG;
    public static int LOGCUT_JNI_LOG;
    public static int LOGCUT_NATIVE_LOG;
    boolean isEnabledCpuSetFeature;
    long mBlockInterval;
    Context mContext;
    boolean mEnabledThreadPrioProtect;
    ExecutorService mExecuteService;
    int mGcHeapLimit;
    boolean mIsAddref;
    boolean mIsDebug;
    boolean mIsEnabledArtGcBlocker;
    boolean mIsEnabledDalvikGcBlocker;
    boolean mIsSupportApex;
    int mLogCutType;
    int mMaxGcBlockTime;
    int mMaxHeapSize;
    JatoListener mMonitor;
    int mPrioVersion;
    int mPriority;
    JatoFeatureReporter mReporter;
    boolean mResetForNewThread;
    boolean mUseInterpreterBridge;
    boolean mUseJitBlock;
    boolean mUseLogCut;

    public static class Builder {
        private final JatoXLConfig mJatoXLConfig;

        private boolean checkInit() {
            JatoXLConfig r100 = this.mJatoXLConfig;
            if (r100.mExecuteService != null) goto L6;
            return false;
        L6:
            if (r100.mContext != null) goto L8;
            return false;
        L8:
            return true;
        }

        public Builder() {
            this.mJatoXLConfig = new JatoXLConfig();
        }

        public JatoXLConfig build() {
            if (checkInit() == true) goto L5;
            return null;
        L5:
            return this.mJatoXLConfig;
        }

        public Builder setContext(Context r100) {
            this.mJatoXLConfig.mContext = r100;
            return this;
        }

        public Builder setExecutor(ExecutorService r100) {
            this.mJatoXLConfig.mExecuteService = r100;
            return this;
        }

        public Builder setLogCutType(int r100) {
            this.mJatoXLConfig.mLogCutType = r100;
            return this;
        }

        public Builder setUseLogCut(boolean r100) {
            this.mJatoXLConfig.mUseLogCut = r100;
            return this;
        }
    }

    public JatoFeatureReporter getReporter() {
        return null;
    }

    static {
        LOGCUT_NATIVE_LOG = LogCut.LOGCUT_NATIVE_LOG;
        LOGCUT_JNI_LOG = LogCut.LOGCUT_JNI_LOG;
        LOGCUT_ALL_LOG = LogCut.LOGCUT_ALL_LOG;
    }

    public File getCacheDir() {
        return this.mContext.getCacheDir();
    }

    public boolean isLargeHeapApp() {
        if ((this.mContext.getApplicationInfo().flags & 1048576) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public JatoXLConfig() {
        this.mPrioVersion = 1;
        this.mResetForNewThread = false;
        this.mEnabledThreadPrioProtect = false;
        this.mIsEnabledDalvikGcBlocker = false;
        this.mIsEnabledArtGcBlocker = true;
        this.mMaxGcBlockTime = 3000;
        this.mGcHeapLimit = -1;
        this.mMaxHeapSize = -1;
        this.mIsSupportApex = false;
        this.isEnabledCpuSetFeature = true;
        this.mIsDebug = false;
    }

    public int getGcHeapLimit() {
        return this.mGcHeapLimit;
    }

    public boolean getIsSupportApex() {
        return this.mIsSupportApex;
    }

    public int getMaxGcBlockTimeout() {
        return this.mMaxGcBlockTime;
    }

    public int getMaxHeapSize() {
        return this.mMaxHeapSize;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public boolean isEnabledArtGcBlocker() {
        return this.mIsEnabledArtGcBlocker;
    }

    public boolean isEnabledDalvikGcBlocker() {
        return this.mIsEnabledDalvikGcBlocker;
    }
}
