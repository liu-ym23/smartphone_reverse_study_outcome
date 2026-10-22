package androidx.camera.video.internal.encoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_VideoEncoderDataSpace extends VideoEncoderDataSpace {
    private final int range;
    private final int standard;
    private final int transfer;

    public int hashCode() {
        return ((((this.standard ^ 1000003) * 1000003) ^ this.transfer) * 1000003) ^ this.range;
    }

    public String toString() {
        return "VideoEncoderDataSpace{standard=" + this.standard + ", transfer=" + this.transfer + ", range=" + this.range + "}";
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getRange() {
        return this.range;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getStandard() {
        return this.standard;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderDataSpace
    public int getTransfer() {
        return this.transfer;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoEncoderDataSpace) == false) goto L16;
        VideoEncoderDataSpace r6 = (VideoEncoderDataSpace) r5;
        if (this.standard == r6.getStandard()) goto L10;
    L14:
        return false;
    L10:
        if (this.transfer != r6.getTransfer()) goto L14;
        if (this.range != r6.getRange()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_VideoEncoderDataSpace(int r1, int r2, int r3) {
        this.standard = r1;
        this.transfer = r2;
        this.range = r3;
    }
}
