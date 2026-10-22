package com.bytedance.keva;

import android.content.Context;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class KevaBuilder {
    public static final int INIT_REPO_OPT_ALL = 2;
    public static final int INIT_REPO_OPT_DISABLE = 0;
    public static final int INIT_REPO_OPT_MAIN_ONLY = 1;
    private static KevaBuilder mInstance;
    Context mContext;
    boolean mEnableExecutorOpt;
    Executor mExecutor;
    boolean mGetRepoLockOpt;
    int mInitRepoOpt;
    boolean mMainThreadPriorityOpt;
    KevaMonitor mMonitor;
    int mPercentPreloadBuffer;
    String mPortedRepoName;
    int mPriorityValue;
    int mRepoIdleReleaseMainThreadThreshold;
    Set<String> mRepoIdleReleaseWhiteList;
    int mTimeMsLoadThreshold;
    int mTimeMsPreloadDelay;
    int mTimeMsToAvoidCollide;
    int mUpdateVersionCode;
    int mVersionMask;
    File mWorkDir;

    public static void clearInstance() {
        mInstance = null;
    }

    static {
        mInstance = new KevaBuilder();
    }

    public static KevaBuilder getInstance() {
        KevaBuilder r100 = mInstance;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new KevaBuilder();
    }

    public KevaBuilder() {
        this.mMainThreadPriorityOpt = false;
        this.mPriorityValue = 0;
        this.mGetRepoLockOpt = false;
        this.mInitRepoOpt = 0;
        this.mRepoIdleReleaseMainThreadThreshold = 2;
    }

    public int getMainThreadPriorityValue() {
        return this.mPriorityValue;
    }

    public boolean isMainThreadPriorityOpt() {
        return this.mMainThreadPriorityOpt;
    }

    public KevaBuilder setContext(Context r100) {
        this.mContext = r100;
        return this;
    }

    public void setEnableExecutorOpt(boolean r100) {
        this.mEnableExecutorOpt = r100;
    }

    public KevaBuilder setExecutor(Executor r100) {
        this.mExecutor = r100;
        return this;
    }

    public void setGetRepoLockOpt(boolean r100) {
        this.mGetRepoLockOpt = r100;
    }

    public void setInitRepoOpt(int r100) {
        this.mInitRepoOpt = r100;
    }

    public void setMainThreadPriorityOpt(boolean r100) {
        this.mMainThreadPriorityOpt = r100;
    }

    public void setMainThreadPriorityValue(int r100) {
        this.mPriorityValue = r100;
    }

    public KevaBuilder setMonitor(KevaMonitor r100) {
        this.mMonitor = r100;
        return this;
    }

    public KevaBuilder setPortedRepoName(String r100) {
        this.mPortedRepoName = r100;
        return this;
    }

    public KevaBuilder setWorkDir(File r100) {
        if (r100.exists() == true) goto L7;
        r100.getPath();
        if (r100.mkdirs() == true) goto L7;
        return this;
    L7:
        this.mWorkDir = r100;
        return this;
    }

    public KevaBuilder setRepoMemoryReleaseConfig(int r100, Set<String> r101) {
        if (r100 <= 0) goto L4;
        this.mRepoIdleReleaseMainThreadThreshold = r100;
    L4:
        this.mRepoIdleReleaseWhiteList = r101;
        return this;
    }

    public KevaBuilder setPreloaderConfig(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.mTimeMsLoadThreshold = r100;
        this.mPercentPreloadBuffer = r101;
        this.mUpdateVersionCode = r102;
        this.mVersionMask = r103;
        this.mTimeMsPreloadDelay = r104;
        this.mTimeMsToAvoidCollide = r105;
        return this;
    }
}
