package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_EncoderProfilesProxy_AudioProfileProxy extends EncoderProfilesProxy.AudioProfileProxy {
    private final int bitrate;
    private final int channels;
    private final int codec;
    private final String mediaType;
    private final int profile;
    private final int sampleRate;

    public int hashCode() {
        return ((((((((((this.codec ^ 1000003) * 1000003) ^ this.mediaType.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channels) * 1000003) ^ this.profile;
    }

    public String toString() {
        return "AudioProfileProxy{codec=" + this.codec + ", mediaType=" + this.mediaType + ", bitrate=" + this.bitrate + ", sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", profile=" + this.profile + "}";
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getChannels() {
        return this.channels;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getCodec() {
        return this.codec;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof EncoderProfilesProxy.AudioProfileProxy) == false) goto L22;
        EncoderProfilesProxy.AudioProfileProxy r6 = (EncoderProfilesProxy.AudioProfileProxy) r5;
        if (this.codec == r6.getCodec()) goto L10;
    L20:
        return false;
    L10:
        if (this.mediaType.equals(r6.getMediaType()) == false) goto L20;
        if (this.bitrate != r6.getBitrate()) goto L20;
        if (this.sampleRate != r6.getSampleRate()) goto L20;
        if (this.channels != r6.getChannels()) goto L20;
        if (this.profile != r6.getProfile()) goto L20;
        return true;
    L22:
        return false;
    }

    public AutoValue_EncoderProfilesProxy_AudioProfileProxy(int r1, String r2, int r3, int r4, int r5, int r6) {
        this.codec = r1;
        if (r2 == null) goto L7;
        this.mediaType = r2;
        this.bitrate = r3;
        this.sampleRate = r4;
        this.channels = r5;
        this.profile = r6;
        return;
    L7:
        throw new NullPointerException("Null mediaType");
    }
}
