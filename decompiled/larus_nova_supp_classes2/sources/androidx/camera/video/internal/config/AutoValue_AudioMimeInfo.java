package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_AudioMimeInfo extends AudioMimeInfo {
    private final EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile;
    private final String mimeType;
    private final int profile;

    /* JADX INFO: renamed from: androidx.camera.video.internal.config.AutoValue_AudioMimeInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioMimeInfo.Builder {
        private EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile;
        private String mimeType;
        private Integer profile;

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder, androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo build() {
            if (this.mimeType != null) goto L5;
            String r0 = " mimeType";
        L7:
            if (this.profile != null) goto L10;
            r0 = r0 + " profile";
        L10:
            if (r0.isEmpty() == false) goto L14;
            return new AutoValue_AudioMimeInfo(this.mimeType, this.profile.intValue(), this.compatibleAudioProfile, null);
        L14:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder, androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ MimeInfo build() {
            return build();
        }

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder
        public AudioMimeInfo.Builder setCompatibleAudioProfile(EncoderProfilesProxy.AudioProfileProxy r1) {
            this.compatibleAudioProfile = r1;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo.Builder setMimeType(String r2) {
            if (r2 == null) goto L6;
            this.mimeType = r2;
            return this;
        L6:
            throw new NullPointerException("Null mimeType");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo.Builder setProfile(int r1) {
            this.profile = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ AudioMimeInfo.Builder setMimeType(String r1) {
            return setMimeType(r1);
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ AudioMimeInfo.Builder setProfile(int r1) {
            return setProfile(r1);
        }
    }

    public int hashCode() {
        int r0 = (((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy r1 = this.compatibleAudioProfile;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 ^ r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AudioMimeInfo{mimeType=" + this.mimeType + ", profile=" + this.profile + ", compatibleAudioProfile=" + this.compatibleAudioProfile + "}";
    }

    @Override // androidx.camera.video.internal.config.AudioMimeInfo
    public EncoderProfilesProxy.AudioProfileProxy getCompatibleAudioProfile() {
        return this.compatibleAudioProfile;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public int getProfile() {
        return this.profile;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioMimeInfo) == false) goto L21;
        AudioMimeInfo r6 = (AudioMimeInfo) r5;
        if (this.mimeType.equals(r6.getMimeType()) == true) goto L10;
    L19:
        return false;
    L10:
        if (this.profile != r6.getProfile()) goto L19;
        EncoderProfilesProxy.AudioProfileProxy r1 = this.compatibleAudioProfile;
        if (r1 != null) goto L17;
        if (r6.getCompatibleAudioProfile() != null) goto L19;
        return true;
    L17:
        if (r1.equals(r6.getCompatibleAudioProfile()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    private AutoValue_AudioMimeInfo(String r1, int r2, EncoderProfilesProxy.AudioProfileProxy r3) {
        this.mimeType = r1;
        this.profile = r2;
        this.compatibleAudioProfile = r3;
    }

    public /* synthetic */ AutoValue_AudioMimeInfo(String r1, int r2, EncoderProfilesProxy.AudioProfileProxy r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }
}
