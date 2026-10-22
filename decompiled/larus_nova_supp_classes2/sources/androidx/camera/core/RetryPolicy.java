package androidx.camera.core;

import androidx.camera.core.impl.CameraProviderInitRetryPolicy;
import androidx.camera.core.impl.RetryPolicyInternal;
import androidx.camera.core.impl.TimeoutRetryPolicy;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface RetryPolicy {
    public static final RetryPolicy DEFAULT = null;
    public static final long DEFAULT_RETRY_TIMEOUT_IN_MILLIS = 6000;
    public static final RetryPolicy NEVER = null;
    public static final RetryPolicy RETRY_UNAVAILABLE_CAMERA = null;

    /* JADX INFO: renamed from: androidx.camera.core.RetryPolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$getTimeoutInMillis(RetryPolicy r2) {
            return 0;
        }

        static {
            RetryPolicy r0 = RetryPolicy.NEVER;
        }

        public static long getDefaultRetryTimeoutInMillis() {
            return RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        }

        public static /* synthetic */ RetryConfig lambda$static$0(ExecutionState r0) {
            return RetryConfig.NOT_RETRY;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.core.RetryPolicy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final RetryPolicy mBasePolicy;
        private long mTimeoutInMillis;

        public RetryPolicy build() {
            RetryPolicy r0 = this.mBasePolicy;
            if ((r0 instanceof RetryPolicyInternal) == false) goto L7;
            return ((RetryPolicyInternal) r0).copy(this.mTimeoutInMillis);
        L7:
            return new TimeoutRetryPolicy(this.mTimeoutInMillis, r0);
        }

        public Builder(RetryPolicy r3) {
            this.mBasePolicy = r3;
            this.mTimeoutInMillis = r3.getTimeoutInMillis();
        }

        public Builder setTimeoutInMillis(long r1) {
            this.mTimeoutInMillis = r1;
            return this;
        }
    }

    public interface ExecutionState {
        public static final int STATUS_CAMERA_UNAVAILABLE = 2;
        public static final int STATUS_CONFIGURATION_FAIL = 1;
        public static final int STATUS_UNKNOWN_ERROR = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
        }

        Throwable getCause();

        long getExecutedTimeInMillis();

        int getNumOfAttempts();

        int getStatus();
    }

    public static final class RetryConfig {
        public static RetryConfig COMPLETE_WITHOUT_FAILURE = null;
        private static final long DEFAULT_DELAY_MILLIS = 500;
        public static final RetryConfig DEFAULT_DELAY_RETRY = null;
        private static final long MINI_DELAY_MILLIS = 100;
        public static final RetryConfig MINI_DELAY_RETRY = null;
        public static final RetryConfig NOT_RETRY = null;
        private final boolean mCompleteWithoutFailure;
        private final long mDelayInMillis;
        private final boolean mShouldRetry;

        public static final class Builder {
            private boolean mShouldRetry;
            private long mTimeoutInMillis;

            public RetryConfig build() {
                return new RetryConfig(this.mShouldRetry, this.mTimeoutInMillis, null);
            }

            public Builder() {
                this.mShouldRetry = true;
                this.mTimeoutInMillis = RetryConfig.getDefaultRetryDelayInMillis();
            }

            public Builder setRetryDelayInMillis(long r1) {
                this.mTimeoutInMillis = r1;
                return this;
            }

            public Builder setShouldRetry(boolean r1) {
                this.mShouldRetry = r1;
                return this;
            }
        }

        public static long getDefaultRetryDelayInMillis() {
            return DEFAULT_DELAY_MILLIS;
        }

        static {
            NOT_RETRY = new RetryConfig(false, 0);
            DEFAULT_DELAY_RETRY = new RetryConfig(true);
            MINI_DELAY_RETRY = new RetryConfig(true, MINI_DELAY_MILLIS);
            COMPLETE_WITHOUT_FAILURE = new RetryConfig(false, 0, true);
        }

        public long getRetryDelayInMillis() {
            return this.mDelayInMillis;
        }

        public boolean shouldCompleteWithoutFailure() {
            return this.mCompleteWithoutFailure;
        }

        public boolean shouldRetry() {
            return this.mShouldRetry;
        }

        private RetryConfig(boolean r3) {
            this(r3, getDefaultRetryDelayInMillis());
        }

        private RetryConfig(boolean r2, long r3) {
            this(r2, r3, false);
        }

        private RetryConfig(boolean r1, long r2, boolean r4) {
            this.mShouldRetry = r1;
            this.mDelayInMillis = r2;
            if (r4 == false) goto L5;
            Preconditions.checkArgument(!r1, "shouldRetry must be false when completeWithoutFailure is set to true");
        L5:
            this.mCompleteWithoutFailure = r4;
        }

        public /* synthetic */ RetryConfig(boolean r1, long r2, AnonymousClass1 r4) {
            this(r1, r2);
        }
    }

    long getTimeoutInMillis();

    RetryConfig onRetryDecisionRequested(ExecutionState r1);

    static {
        NEVER = new d0();
        DEFAULT = new CameraProviderInitRetryPolicy.Legacy(CC.getDefaultRetryTimeoutInMillis());
        RETRY_UNAVAILABLE_CAMERA = new CameraProviderInitRetryPolicy(CC.getDefaultRetryTimeoutInMillis());
    }
}
