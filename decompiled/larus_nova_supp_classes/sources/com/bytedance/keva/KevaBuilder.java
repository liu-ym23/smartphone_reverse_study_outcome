package com.bytedance.keva;

import android.content.Context;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        KevaBuilder r0 = mInstance;
        if (r0 == null) goto L6;
        return r0;
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

    public KevaBuilder setContext(Context r1) {
        this.mContext = r1;
        return this;
    }

    public void setEnableExecutorOpt(boolean r1) {
        this.mEnableExecutorOpt = r1;
    }

    public KevaBuilder setExecutor(Executor r1) {
        this.mExecutor = r1;
        return this;
    }

    public void setGetRepoLockOpt(boolean r1) {
        this.mGetRepoLockOpt = r1;
    }

    public void setInitRepoOpt(int r1) {
        this.mInitRepoOpt = r1;
    }

    public void setMainThreadPriorityOpt(boolean r1) {
        this.mMainThreadPriorityOpt = r1;
    }

    public void setMainThreadPriorityValue(int r1) {
        this.mPriorityValue = r1;
    }

    public KevaBuilder setMonitor(KevaMonitor r1) {
        this.mMonitor = r1;
        return this;
    }

    public KevaBuilder setPortedRepoName(String r1) {
        this.mPortedRepoName = r1;
        return this;
    }

    public KevaBuilder setWorkDir(File r2) {
        if (r2.exists() == true) goto L7;
        r2.getPath();
        if (r2.mkdirs() == true) goto L7;
        return this;
    L7:
        this.mWorkDir = r2;
        return this;
    }

    public KevaBuilder setRepoMemoryReleaseConfig(int r1, Set<String> r2) {
        if (r1 <= 0) goto L4;
        this.mRepoIdleReleaseMainThreadThreshold = r1;
    L4:
        this.mRepoIdleReleaseWhiteList = r2;
        return this;
    }

    public KevaBuilder setPreloaderConfig(int r1, int r2, int r3, int r4, int r5, int r6) {
        this.mTimeMsLoadThreshold = r1;
        this.mPercentPreloadBuffer = r2;
        this.mUpdateVersionCode = r3;
        this.mVersionMask = r4;
        this.mTimeMsPreloadDelay = r5;
        this.mTimeMsToAvoidCollide = r6;
        return this;
    }
}
