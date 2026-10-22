package com.ss.android.downloadlib.addownload.model;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadEventInfo {
    private long mAdId;
    private long mExtValue;
    private boolean mIsEnableBackDialog;
    private String mLogExtra;

    public static class Builder {
        public long mAdId;
        public long mExtValue;
        public boolean mIsEnableBackDialog;
        public String mLogExtra;

        public Builder() {
        }

        public DownloadEventInfo build() {
            return new DownloadEventInfo(this);
        }

        public Builder setAdId(long r100) {
            this.mAdId = r100;
            return this;
        }

        public Builder setExtValue(long r100) {
            this.mExtValue = r100;
            return this;
        }

        public Builder setIsEnableBackDialog(boolean r100) {
            this.mIsEnableBackDialog = r100;
            return this;
        }

        public Builder setLogExtra(String r100) {
            this.mLogExtra = r100;
            return this;
        }
    }

    public long getAdId() {
        return this.mAdId;
    }

    public long getExtValue() {
        return this.mExtValue;
    }

    public String getLogExtra() {
        return this.mLogExtra;
    }

    public boolean isEnableBackDialog() {
        return this.mIsEnableBackDialog;
    }

    public DownloadEventInfo(Builder r100) {
        this.mAdId = r100.mAdId;
        this.mExtValue = r100.mExtValue;
        this.mLogExtra = r100.mLogExtra;
        this.mIsEnableBackDialog = r100.mIsEnableBackDialog;
    }
}
