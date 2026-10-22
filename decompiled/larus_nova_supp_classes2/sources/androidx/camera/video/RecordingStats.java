package androidx.camera.video;

import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class RecordingStats {
    public abstract AudioStats getAudioStats();

    public abstract long getNumBytesRecorded();

    public abstract long getRecordedDurationNanos();

    public RecordingStats() {
    }

    public static RecordingStats of(long r8, long r10, AudioStats r12) {
        boolean r0 = true;
        if (r8 < 0) goto L5;
        boolean r4 = true;
    L6:
        Preconditions.checkArgument(r4, "duration must be positive value.");
        if (r10 >= 0) goto L10;
        r0 = false;
    L10:
        Preconditions.checkArgument(r0, "bytes must be positive value.");
        return new AutoValue_RecordingStats(r8, r10, r12);
    L5:
        r4 = false;
        goto L6
    }
}
