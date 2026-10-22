package androidx.camera.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_AudioStats extends AudioStats {
    private final double audioAmplitudeInternal;
    private final int audioState;
    private final Throwable errorCause;

    public int hashCode() {
        int r0 = (((this.audioState ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.audioAmplitudeInternal) >>> 32) ^ Double.doubleToLongBits(this.audioAmplitudeInternal)))) * 1000003;
        Throwable r1 = this.errorCause;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 ^ r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AudioStats{audioState=" + this.audioState + ", audioAmplitudeInternal=" + this.audioAmplitudeInternal + ", errorCause=" + this.errorCause + "}";
    }

    @Override // androidx.camera.video.AudioStats
    public double getAudioAmplitudeInternal() {
        return this.audioAmplitudeInternal;
    }

    @Override // androidx.camera.video.AudioStats
    public int getAudioState() {
        return this.audioState;
    }

    @Override // androidx.camera.video.AudioStats
    public Throwable getErrorCause() {
        return this.errorCause;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof AudioStats) == false) goto L21;
        AudioStats r9 = (AudioStats) r8;
        if (this.audioState == r9.getAudioState()) goto L10;
    L19:
        return false;
    L10:
        if (Double.doubleToLongBits(this.audioAmplitudeInternal) != Double.doubleToLongBits(r9.getAudioAmplitudeInternal())) goto L19;
        Throwable r1 = this.errorCause;
        if (r1 != null) goto L17;
        if (r9.getErrorCause() != null) goto L19;
        return true;
    L17:
        if (r1.equals(r9.getErrorCause()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    public AutoValue_AudioStats(int r1, double r2, Throwable r4) {
        this.audioState = r1;
        this.audioAmplitudeInternal = r2;
        this.errorCause = r4;
    }
}
