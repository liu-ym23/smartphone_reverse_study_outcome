package com.bytedance.common.wschannel.channel.impl.ok.policy;

import android.content.Context;

/* JADX INFO: loaded from: classes15.dex */
public class RetryTimesPolicy extends RetryIntervalPolicy {
    private int mCurrRetryTime;
    private final int mMaxRetryTime;

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryIntervalPolicy
    public long getNextRetryInterval() {
        if (this.mCurrRetryTime >= this.mMaxRetryTime) goto L5;
        long r100 = super.getNextRetryInterval();
    L7:
        if (r100 == (-1)) goto L9;
        this.mCurrRetryTime++;
    L9:
        return r100;
    L5:
        r100 = -1;
        goto L7
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.mMaxRetryTime + ", mCurrRetryTime=" + this.mCurrRetryTime + '}';
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryIntervalPolicy, com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public void reset() {
        super.reset();
        this.mCurrRetryTime = 0;
    }

    public RetryTimesPolicy(Context r100) {
        this(r100, 4);
    }

    public RetryTimesPolicy(Context r100, int r101) {
        super(r100);
        if (r101 >= 0) goto L5;
        r101 = 4;
    L5:
        this.mMaxRetryTime = r101;
    }
}
