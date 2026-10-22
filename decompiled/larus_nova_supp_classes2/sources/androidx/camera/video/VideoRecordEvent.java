package androidx.camera.video;

import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class VideoRecordEvent {
    private final OutputOptions mOutputOptions;
    private final RecordingStats mRecordingStats;

    public static final class Finalize extends VideoRecordEvent {
        public static final int ERROR_DURATION_LIMIT_REACHED = 9;
        public static final int ERROR_ENCODING_FAILED = 6;
        public static final int ERROR_FILE_SIZE_LIMIT_REACHED = 2;
        public static final int ERROR_INSUFFICIENT_STORAGE = 3;
        public static final int ERROR_INVALID_OUTPUT_OPTIONS = 5;
        public static final int ERROR_NONE = 0;
        public static final int ERROR_NO_VALID_DATA = 8;
        public static final int ERROR_RECORDER_ERROR = 7;
        public static final int ERROR_RECORDING_GARBAGE_COLLECTED = 10;
        public static final int ERROR_SOURCE_INACTIVE = 4;
        public static final int ERROR_UNKNOWN = 1;
        private final Throwable mCause;
        private final int mError;
        private final OutputResults mOutputResults;

        @Retention(RetentionPolicy.SOURCE)
        public @interface VideoRecordError {
        }

        public boolean hasError() {
            if (this.mError == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public Throwable getCause() {
            return this.mCause;
        }

        public int getError() {
            return this.mError;
        }

        public OutputResults getOutputResults() {
            return this.mOutputResults;
        }

        public static String errorToString(int r2) {
            switch(r2) {
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L19;
                case 4: goto L17;
                case 5: goto L15;
                case 6: goto L13;
                case 7: goto L11;
                case 8: goto L9;
                case 9: goto L7;
                case 10: goto L5;
                default: goto L4;
            };
        L5:
            return "ERROR_RECORDING_GARBAGE_COLLECTED";
        L7:
            return "ERROR_DURATION_LIMIT_REACHED";
        L9:
            return "ERROR_NO_VALID_DATA";
        L11:
            return "ERROR_RECORDER_ERROR";
        L13:
            return "ERROR_ENCODING_FAILED";
        L15:
            return "ERROR_INVALID_OUTPUT_OPTIONS";
        L17:
            return "ERROR_SOURCE_INACTIVE";
        L19:
            return "ERROR_INSUFFICIENT_STORAGE";
        L21:
            return "ERROR_FILE_SIZE_LIMIT_REACHED";
        L23:
            return "ERROR_UNKNOWN";
        L25:
            return "ERROR_NONE";
        L4:
            return "Unknown(" + r2 + ")";
        }

        public Finalize(OutputOptions r1, RecordingStats r2, OutputResults r3, int r4, Throwable r5) {
            super(r1, r2);
            this.mOutputResults = r3;
            this.mError = r4;
            this.mCause = r5;
        }
    }

    public static final class Pause extends VideoRecordEvent {
        public Pause(OutputOptions r1, RecordingStats r2) {
            super(r1, r2);
        }
    }

    public static final class Resume extends VideoRecordEvent {
        public Resume(OutputOptions r1, RecordingStats r2) {
            super(r1, r2);
        }
    }

    public static final class Start extends VideoRecordEvent {
        public Start(OutputOptions r1, RecordingStats r2) {
            super(r1, r2);
        }
    }

    public static final class Status extends VideoRecordEvent {
        public Status(OutputOptions r1, RecordingStats r2) {
            super(r1, r2);
        }
    }

    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    public RecordingStats getRecordingStats() {
        return this.mRecordingStats;
    }

    public VideoRecordEvent(OutputOptions r1, RecordingStats r2) {
        this.mOutputOptions = (OutputOptions) Preconditions.checkNotNull(r1);
        this.mRecordingStats = (RecordingStats) Preconditions.checkNotNull(r2);
    }

    public static Pause pause(OutputOptions r1, RecordingStats r2) {
        return new Pause(r1, r2);
    }

    public static Resume resume(OutputOptions r1, RecordingStats r2) {
        return new Resume(r1, r2);
    }

    public static Start start(OutputOptions r1, RecordingStats r2) {
        return new Start(r1, r2);
    }

    public static Status status(OutputOptions r1, RecordingStats r2) {
        return new Status(r1, r2);
    }

    public static Finalize finalize(OutputOptions r7, RecordingStats r8, OutputResults r9) {
        return new Finalize(r7, r8, r9, 0, null);
    }

    public static Finalize finalizeWithError(OutputOptions r8, RecordingStats r9, OutputResults r10, int r11, Throwable r12) {
        if (r11 == 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "An error type is required.");
        return new Finalize(r8, r9, r10, r11, r12);
    L4:
        r0 = false;
        goto L5
    }
}
