package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.RetryPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraProviderInitRetryPolicy implements RetryPolicyInternal {
    private final RetryPolicy mDelegatePolicy;

    public static final class Legacy implements RetryPolicyInternal {
        private final RetryPolicy mBasePolicy;

        @Override // androidx.camera.core.RetryPolicy
        public long getTimeoutInMillis() {
            return this.mBasePolicy.getTimeoutInMillis();
        }

        public Legacy(long r2) {
            this.mBasePolicy = new CameraProviderInitRetryPolicy(r2);
        }

        @Override // androidx.camera.core.impl.RetryPolicyInternal
        public RetryPolicy copy(long r2) {
            return new Legacy(r2);
        }

        @Override // androidx.camera.core.RetryPolicy
        public RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState r3) {
            if (this.mBasePolicy.onRetryDecisionRequested(r3).shouldRetry() == true) goto L13;
            Throwable r4 = r3.getCause();
            if ((r4 instanceof CameraValidator.CameraIdListIncorrectException) == false) goto L11;
            Logger.e("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
            if (((CameraValidator.CameraIdListIncorrectException) r4).getAvailableCameraCount() <= 0) goto L11;
            return RetryPolicy.RetryConfig.COMPLETE_WITHOUT_FAILURE;
        L11:
            return RetryPolicy.RetryConfig.NOT_RETRY;
        L13:
            return RetryPolicy.RetryConfig.DEFAULT_DELAY_RETRY;
        }
    }

    @Override // androidx.camera.core.RetryPolicy
    public long getTimeoutInMillis() {
        return this.mDelegatePolicy.getTimeoutInMillis();
    }

    public CameraProviderInitRetryPolicy(final long r3) {
        this.mDelegatePolicy = new TimeoutRetryPolicy(r3, new AnonymousClass1(this, r3));
    }

    @Override // androidx.camera.core.impl.RetryPolicyInternal
    public RetryPolicy copy(long r2) {
        return new CameraProviderInitRetryPolicy(r2);
    }

    @Override // androidx.camera.core.RetryPolicy
    public RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState r2) {
        return this.mDelegatePolicy.onRetryDecisionRequested(r2);
    }
}
