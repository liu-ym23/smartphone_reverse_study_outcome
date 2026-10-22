package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.RetryPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraProviderExecutionState implements RetryPolicy.ExecutionState {
    private final int mAttemptCount;
    private final Throwable mCause;
    private final int mStatus;
    private final long mTaskExecutedTimeInMillis;

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public Throwable getCause() {
        return this.mCause;
    }

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public long getExecutedTimeInMillis() {
        return this.mTaskExecutedTimeInMillis;
    }

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public int getNumOfAttempts() {
        return this.mAttemptCount;
    }

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public int getStatus() {
        return this.mStatus;
    }

    public CameraProviderExecutionState(long r3, int r5, Throwable r6) {
        this.mTaskExecutedTimeInMillis = SystemClock.elapsedRealtime() - r3;
        this.mAttemptCount = r5;
        if ((r6 instanceof CameraValidator.CameraIdListIncorrectException) == false) goto L6;
        this.mStatus = 2;
        this.mCause = r6;
        return;
    L6:
        if ((r6 instanceof InitializationException) == false) goto L17;
        Throwable r4 = r6.getCause();
        if (r4 == null) goto L10;
        r6 = r4;
    L10:
        this.mCause = r6;
        if ((r6 instanceof CameraUnavailableException) == false) goto L14;
        this.mStatus = 2;
        return;
    L14:
        if ((r6 instanceof IllegalArgumentException) == false) goto L16;
        this.mStatus = 1;
        return;
    L16:
        this.mStatus = 0;
        return;
    L17:
        this.mStatus = 0;
        this.mCause = r6;
    }
}
