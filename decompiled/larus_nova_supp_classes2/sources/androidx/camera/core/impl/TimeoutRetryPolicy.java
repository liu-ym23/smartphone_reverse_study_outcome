package androidx.camera.core.impl;

import androidx.camera.core.RetryPolicy;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class TimeoutRetryPolicy implements RetryPolicy {
    private final RetryPolicy mDelegatePolicy;
    private final long mTimeoutInMillis;

    @Override // androidx.camera.core.RetryPolicy
    public long getTimeoutInMillis() {
        return this.mTimeoutInMillis;
    }

    @Override // androidx.camera.core.RetryPolicy
    public RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState r8) {
        RetryPolicy.RetryConfig r0 = this.mDelegatePolicy.onRetryDecisionRequested(r8);
        if (getTimeoutInMillis() > 0) goto L5;
        return r0;
    L5:
        if (r8.getExecutedTimeInMillis() >= (getTimeoutInMillis() - r0.getRetryDelayInMillis())) goto L7;
        return r0;
    L7:
        return RetryPolicy.RetryConfig.NOT_RETRY;
    }

    public TimeoutRetryPolicy(long r4, RetryPolicy r6) {
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Timeout must be non-negative.");
        this.mTimeoutInMillis = r4;
        this.mDelegatePolicy = r6;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
