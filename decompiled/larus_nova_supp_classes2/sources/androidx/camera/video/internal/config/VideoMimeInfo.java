package androidx.camera.video.internal.config;

import androidx.camera.core.impl.EncoderProfilesProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class VideoMimeInfo extends MimeInfo {

    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public abstract VideoMimeInfo build();

        public abstract Builder setCompatibleVideoProfile(EncoderProfilesProxy.VideoProfileProxy r1);

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public /* bridge */ /* synthetic */ MimeInfo build() {
            return build();
        }

        public Builder() {
        }
    }

    public abstract EncoderProfilesProxy.VideoProfileProxy getCompatibleVideoProfile();

    public VideoMimeInfo() {
    }

    public static Builder builder(String r1) {
        return new AutoValue_VideoMimeInfo.Builder().setMimeType(r1).setProfile(-1);
    }
}
