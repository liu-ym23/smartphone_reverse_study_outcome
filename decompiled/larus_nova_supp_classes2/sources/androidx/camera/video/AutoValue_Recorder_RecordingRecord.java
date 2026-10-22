package androidx.camera.video;

import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_Recorder_RecordingRecord extends Recorder.RecordingRecord {
    private final Executor getCallbackExecutor;
    private final Consumer<VideoRecordEvent> getEventListener;
    private final OutputOptions getOutputOptions;
    private final long getRecordingId;
    private final boolean hasAudioEnabled;
    private final boolean isPersistent;

    public int hashCode() {
        int r0 = (this.getOutputOptions.hashCode() ^ 1000003) * 1000003;
        Executor r2 = this.getCallbackExecutor;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r1 = (r0 ^ r4) * 1000003;
        Consumer<VideoRecordEvent> r5 = this.getEventListener;
        if (r5 == null) goto L10;
        r3 = r5.hashCode();
    L10:
        int r6 = (r1 ^ r3) * 1000003;
        int r7 = 1231;
        if (this.hasAudioEnabled == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 ^ r8) * 1000003;
        if (this.isPersistent == true) goto L18;
        r7 = 1237;
    L18:
        long r10 = this.getRecordingId;
        return ((r9 ^ r7) * 1000003) ^ ((int) (r10 ^ (r10 >>> 32)));
    L13:
        r8 = 1237;
        goto L14
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "RecordingRecord{getOutputOptions=" + this.getOutputOptions + ", getCallbackExecutor=" + this.getCallbackExecutor + ", getEventListener=" + this.getEventListener + ", hasAudioEnabled=" + this.hasAudioEnabled + ", isPersistent=" + this.isPersistent + ", getRecordingId=" + this.getRecordingId + "}";
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public Executor getCallbackExecutor() {
        return this.getCallbackExecutor;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public Consumer<VideoRecordEvent> getEventListener() {
        return this.getEventListener;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public OutputOptions getOutputOptions() {
        return this.getOutputOptions;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public long getRecordingId() {
        return this.getRecordingId;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public boolean hasAudioEnabled() {
        return this.hasAudioEnabled;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    public boolean isPersistent() {
        return this.isPersistent;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Recorder.RecordingRecord) == false) goto L32;
        Recorder.RecordingRecord r9 = (Recorder.RecordingRecord) r8;
        if (this.getOutputOptions.equals(r9.getOutputOptions()) == false) goto L30;
        Executor r1 = this.getCallbackExecutor;
        if (r1 != null) goto L15;
        if (r9.getCallbackExecutor() != null) goto L30;
    L16:
        Consumer<VideoRecordEvent> r2 = this.getEventListener;
        if (r2 != null) goto L22;
        if (r9.getEventListener() != null) goto L30;
    L24:
        if (this.hasAudioEnabled != r9.hasAudioEnabled()) goto L30;
        if (this.isPersistent != r9.isPersistent()) goto L30;
        if (this.getRecordingId != r9.getRecordingId()) goto L30;
        return true;
    L22:
        if (r2.equals(r9.getEventListener()) == false) goto L30;
    L15:
        if (r1.equals(r9.getCallbackExecutor()) == true) goto L16;
    L30:
        return false;
    L32:
        return false;
    }

    public AutoValue_Recorder_RecordingRecord(OutputOptions r1, Executor r2, Consumer<VideoRecordEvent> r3, boolean r4, boolean r5, long r6) {
        if (r1 == null) goto L7;
        this.getOutputOptions = r1;
        this.getCallbackExecutor = r2;
        this.getEventListener = r3;
        this.hasAudioEnabled = r4;
        this.isPersistent = r5;
        this.getRecordingId = r6;
        return;
    L7:
        throw new NullPointerException("Null getOutputOptions");
    }
}
