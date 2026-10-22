package androidx.camera.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_RecordingStats extends RecordingStats {
    private final AudioStats audioStats;
    private final long numBytesRecorded;
    private final long recordedDurationNanos;

    public int hashCode() {
        long r0 = this.recordedDurationNanos;
        int r1 = (((int) (r0 ^ (r0 >>> 32))) ^ 1000003) * 1000003;
        long r3 = this.numBytesRecorded;
        int r2 = this.audioStats.hashCode();
        return r2 ^ ((r1 ^ ((int) ((r3 >>> 32) ^ r3))) * 1000003);
    }

    public String toString() {
        return "RecordingStats{recordedDurationNanos=" + this.recordedDurationNanos + ", numBytesRecorded=" + this.numBytesRecorded + ", audioStats=" + this.audioStats + "}";
    }

    @Override // androidx.camera.video.RecordingStats
    public AudioStats getAudioStats() {
        return this.audioStats;
    }

    @Override // androidx.camera.video.RecordingStats
    public long getNumBytesRecorded() {
        return this.numBytesRecorded;
    }

    @Override // androidx.camera.video.RecordingStats
    public long getRecordedDurationNanos() {
        return this.recordedDurationNanos;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof RecordingStats) == false) goto L16;
        RecordingStats r9 = (RecordingStats) r8;
        if (this.recordedDurationNanos == r9.getRecordedDurationNanos()) goto L10;
    L14:
        return false;
    L10:
        if (this.numBytesRecorded != r9.getNumBytesRecorded()) goto L14;
        if (this.audioStats.equals(r9.getAudioStats()) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_RecordingStats(long r1, long r3, AudioStats r5) {
        this.recordedDurationNanos = r1;
        this.numBytesRecorded = r3;
        if (r5 == null) goto L7;
        this.audioStats = r5;
        return;
    L7:
        throw new NullPointerException("Null audioStats");
    }
}
