package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_EncoderProfilesProxy_VideoProfileProxy extends EncoderProfilesProxy.VideoProfileProxy {
    private final int bitDepth;
    private final int bitrate;
    private final int chromaSubsampling;
    private final int codec;
    private final int frameRate;
    private final int hdrFormat;
    private final int height;
    private final String mediaType;
    private final int profile;
    private final int width;

    public int hashCode() {
        return ((((((((((((((((((this.codec ^ 1000003) * 1000003) ^ this.mediaType.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.frameRate) * 1000003) ^ this.width) * 1000003) ^ this.height) * 1000003) ^ this.profile) * 1000003) ^ this.bitDepth) * 1000003) ^ this.chromaSubsampling) * 1000003) ^ this.hdrFormat;
    }

    public String toString() {
        return "VideoProfileProxy{codec=" + this.codec + ", mediaType=" + this.mediaType + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", width=" + this.width + ", height=" + this.height + ", profile=" + this.profile + ", bitDepth=" + this.bitDepth + ", chromaSubsampling=" + this.chromaSubsampling + ", hdrFormat=" + this.hdrFormat + "}";
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getBitDepth() {
        return this.bitDepth;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getChromaSubsampling() {
        return this.chromaSubsampling;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getCodec() {
        return this.codec;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getHdrFormat() {
        return this.hdrFormat;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy
    public int getWidth() {
        return this.width;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof EncoderProfilesProxy.VideoProfileProxy) == false) goto L30;
        EncoderProfilesProxy.VideoProfileProxy r6 = (EncoderProfilesProxy.VideoProfileProxy) r5;
        if (this.codec == r6.getCodec()) goto L10;
    L28:
        return false;
    L10:
        if (this.mediaType.equals(r6.getMediaType()) == false) goto L28;
        if (this.bitrate != r6.getBitrate()) goto L28;
        if (this.frameRate != r6.getFrameRate()) goto L28;
        if (this.width != r6.getWidth()) goto L28;
        if (this.height != r6.getHeight()) goto L28;
        if (this.profile != r6.getProfile()) goto L28;
        if (this.bitDepth != r6.getBitDepth()) goto L28;
        if (this.chromaSubsampling != r6.getChromaSubsampling()) goto L28;
        if (this.hdrFormat != r6.getHdrFormat()) goto L28;
        return true;
    L30:
        return false;
    }

    public AutoValue_EncoderProfilesProxy_VideoProfileProxy(int r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        this.codec = r1;
        if (r2 == null) goto L7;
        this.mediaType = r2;
        this.bitrate = r3;
        this.frameRate = r4;
        this.width = r5;
        this.height = r6;
        this.profile = r7;
        this.bitDepth = r8;
        this.chromaSubsampling = r9;
        this.hdrFormat = r10;
        return;
    L7:
        throw new NullPointerException("Null mediaType");
    }
}
