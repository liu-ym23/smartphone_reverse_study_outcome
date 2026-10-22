package com.bytedance.memory.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryWidgetConfig implements Serializable {
    private static final long serialVersionUID = 2435829043493095963L;
    private boolean mClientAnalyse;
    private boolean mCombineDumpAndUpload;
    private boolean mDeepShrink;
    private a mDumpShrinkConfig;
    private String mFilePath;
    private boolean mIsDebug;
    private int mMemoryRate;
    private int mNumAnalyse;
    private int mRunStrategy;
    private b mShrinkConfig;
    private v17.a mTeaReport;

    public static class Builder implements Serializable {
        private static final long serialVersionUID = 2629625684428405094L;
        private boolean mClientAnalyse;
        private boolean mDeepShrink;
        private a mDumpShrinkConfig;
        private String mFilePath;
        private boolean mIsDebug;
        private int mMemoryRate;
        private int mNumAnalyse;
        private int mRunStrategy;
        private b mShrinkConfig;
        private v17.a mTeaReport;

        public Builder buildTeaReport(v17.a r100) {
            return this;
        }

        public Builder dumpAndShrinkConfig(a r100) {
            return this;
        }

        public Builder shrinkConfig(b r100) {
            return this;
        }

        public MemoryWidgetConfig build() {
            MemoryWidgetConfig r100 = new MemoryWidgetConfig();
            MemoryWidgetConfig.access$002(r100, this.mIsDebug);
            MemoryWidgetConfig.access$102(r100, this.mClientAnalyse);
            MemoryWidgetConfig.access$202(r100, null);
            MemoryWidgetConfig.access$302(r100, this.mNumAnalyse);
            MemoryWidgetConfig.access$402(r100, this.mMemoryRate);
            MemoryWidgetConfig.access$502(r100, this.mRunStrategy);
            MemoryWidgetConfig.access$602(r100, null);
            MemoryWidgetConfig.access$702(r100, null);
            MemoryWidgetConfig.access$802(r100, this.mFilePath);
            MemoryWidgetConfig.access$902(r100, this.mDeepShrink);
            return r100;
        }

        public Builder() {
            this.mClientAnalyse = false;
            this.mNumAnalyse = 200;
            this.mMemoryRate = 90;
            this.mRunStrategy = 1;
            this.mDeepShrink = false;
        }

        public Builder buildClientAnalyse(boolean r100) {
            this.mClientAnalyse = r100;
            return this;
        }

        public Builder buildDebug(boolean r100) {
            this.mIsDebug = r100;
            return this;
        }

        public Builder buildFilePath(String r100) {
            this.mFilePath = r100;
            return this;
        }

        public Builder buildMemoryRate(int r100) {
            this.mMemoryRate = r100;
            return this;
        }

        public Builder buildNumAnalyse(int r100) {
            this.mNumAnalyse = r100;
            return this;
        }

        public Builder buildRunStrategy(int r100) {
            this.mRunStrategy = r100;
            return this;
        }

        public Builder deepShrink(boolean r100) {
            this.mDeepShrink = r100;
            return this;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public interface a {
    }

    /* JADX INFO: loaded from: classes21.dex */
    public interface b {
    }

    public a getDumpAndShrinkConfig() {
        return null;
    }

    public b getShrinkConfig() {
        return null;
    }

    public v17.a getTeaReport() {
        return null;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return "MemoryWidgetConfig{ mIsDebug:" + this.mIsDebug + ", mClientAnalyse:" + this.mClientAnalyse + ", mMemoryRate:" + this.mMemoryRate + ", mRunStrategy:" + this.mRunStrategy + ", mFilePath:" + this.mFilePath + ", mShrinkConfig:null, mDumpShrinkConfig:null, mDeepShrink:" + this.mDeepShrink + " }";
    }

    public MemoryWidgetConfig() {
        this.mClientAnalyse = false;
        this.mCombineDumpAndUpload = false;
        this.mNumAnalyse = 200;
        this.mMemoryRate = 90;
        this.mRunStrategy = 1;
        this.mDeepShrink = false;
    }

    public boolean clientAnalyse() {
        return this.mClientAnalyse;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public int getMemoryRate() {
        return this.mMemoryRate;
    }

    public int getNumAnalyse() {
        return this.mNumAnalyse;
    }

    public int getRunStrategy() {
        return this.mRunStrategy;
    }

    public boolean isCombineDumpAndUpload() {
        return this.mCombineDumpAndUpload;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public boolean isDeepShrink() {
        return this.mDeepShrink;
    }

    public void setClientAnalyse(boolean r100) {
        this.mClientAnalyse = r100;
    }

    public void setCombineDumpAndUpload(boolean r100) {
        this.mCombineDumpAndUpload = r100;
    }

    public void setMemoryRate(int r100) {
        this.mMemoryRate = r100;
    }

    public void setNumAnalyse(int r100) {
        this.mNumAnalyse = r100;
    }

    public void setRunStrategy(int r100) {
        this.mRunStrategy = r100;
    }

    public static /* synthetic */ boolean access$002(MemoryWidgetConfig r100, boolean r101) {
        r100.mIsDebug = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(MemoryWidgetConfig r100, boolean r101) {
        r100.mClientAnalyse = r101;
        return r101;
    }

    public static /* synthetic */ v17.a access$202(MemoryWidgetConfig r100, v17.a r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ int access$302(MemoryWidgetConfig r100, int r101) {
        r100.mNumAnalyse = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(MemoryWidgetConfig r100, int r101) {
        r100.mMemoryRate = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(MemoryWidgetConfig r100, int r101) {
        r100.mRunStrategy = r101;
        return r101;
    }

    public static /* synthetic */ b access$602(MemoryWidgetConfig r100, b r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ a access$702(MemoryWidgetConfig r100, a r101) {
        r100.getClass();
        return r101;
    }

    public static /* synthetic */ String access$802(MemoryWidgetConfig r100, String r101) {
        r100.mFilePath = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(MemoryWidgetConfig r100, boolean r101) {
        r100.mDeepShrink = r101;
        return r101;
    }
}
