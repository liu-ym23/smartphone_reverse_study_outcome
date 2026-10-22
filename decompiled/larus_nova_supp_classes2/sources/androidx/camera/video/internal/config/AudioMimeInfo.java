package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class AudioMimeInfo extends MimeInfo {

    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public abstract AudioMimeInfo build();

        public abstract Builder setCompatibleAudioProfile(EncoderProfilesProxy.AudioProfileProxy r1);

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ MimeInfo build() {
            return build();
        }

        public Builder() {
        }
    }

    public abstract EncoderProfilesProxy.AudioProfileProxy getCompatibleAudioProfile();

    public AudioMimeInfo() {
    }

    public static Builder builder(String r1) {
        return new AutoValue_AudioMimeInfo.Builder().setMimeType(r1).setProfile(-1);
    }
}
