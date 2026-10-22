package com.facebook.drawee.components;

/* JADX INFO: loaded from: classes23.dex */
public class RetryManager {
    private static final int MAX_TAP_TO_RETRY_ATTEMPTS = 4;
    private int mMaxTapToRetryAttempts;
    private int mTapToRetryAttempts;
    private boolean mTapToRetryEnabled;

    public void init() {
        this.mTapToRetryEnabled = false;
        this.mMaxTapToRetryAttempts = 4;
        reset();
    }

    public void reset() {
        this.mTapToRetryAttempts = 0;
    }

    public static RetryManager newInstance() {
        return new RetryManager();
    }

    public void notifyTapToRetry() {
        this.mTapToRetryAttempts++;
    }

    public boolean shouldRetryOnTap() {
        if (this.mTapToRetryEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mTapToRetryAttempts >= this.mMaxTapToRetryAttempts) goto L7;
        return true;
    }

    public RetryManager() {
        init();
    }

    public boolean isTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    public void setMaxTapToRetryAttemps(int r100) {
        this.mMaxTapToRetryAttempts = r100;
    }

    public void setTapToRetryEnabled(boolean r100) {
        this.mTapToRetryEnabled = r100;
    }
}
