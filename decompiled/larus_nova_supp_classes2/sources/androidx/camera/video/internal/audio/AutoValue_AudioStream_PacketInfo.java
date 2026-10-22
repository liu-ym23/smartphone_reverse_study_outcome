package androidx.camera.video.internal.audio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_AudioStream_PacketInfo extends AudioStream.PacketInfo {
    private final int sizeInBytes;
    private final long timestampNs;

    public int hashCode() {
        int r0 = (this.sizeInBytes ^ 1000003) * 1000003;
        long r1 = this.timestampNs;
        return r0 ^ ((int) (r1 ^ (r1 >>> 32)));
    }

    public String toString() {
        return "PacketInfo{sizeInBytes=" + this.sizeInBytes + ", timestampNs=" + this.timestampNs + "}";
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public int getSizeInBytes() {
        return this.sizeInBytes;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public long getTimestampNs() {
        return this.timestampNs;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof AudioStream.PacketInfo) == false) goto L14;
        AudioStream.PacketInfo r9 = (AudioStream.PacketInfo) r8;
        if (this.sizeInBytes == r9.getSizeInBytes()) goto L10;
    L12:
        return false;
    L10:
        if (this.timestampNs != r9.getTimestampNs()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_AudioStream_PacketInfo(int r1, long r2) {
        this.sizeInBytes = r1;
        this.timestampNs = r2;
    }
}
