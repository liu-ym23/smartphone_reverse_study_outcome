package androidx.camera.video.internal;

import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_VideoValidatedEncoderProfilesProxy extends VideoValidatedEncoderProfilesProxy {
    private final List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles;
    private final EncoderProfilesProxy.AudioProfileProxy defaultAudioProfile;
    private final int defaultDurationSeconds;
    private final EncoderProfilesProxy.VideoProfileProxy defaultVideoProfile;
    private final int recommendedFileFormat;
    private final List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;

    public int hashCode() {
        int r0 = (((((((this.defaultDurationSeconds ^ 1000003) * 1000003) ^ this.recommendedFileFormat) * 1000003) ^ this.audioProfiles.hashCode()) * 1000003) ^ this.videoProfiles.hashCode()) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy r2 = this.defaultAudioProfile;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return ((r0 ^ r3) * 1000003) ^ this.defaultVideoProfile.hashCode();
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "VideoValidatedEncoderProfilesProxy{defaultDurationSeconds=" + this.defaultDurationSeconds + ", recommendedFileFormat=" + this.recommendedFileFormat + ", audioProfiles=" + this.audioProfiles + ", videoProfiles=" + this.videoProfiles + ", defaultAudioProfile=" + this.defaultAudioProfile + ", defaultVideoProfile=" + this.defaultVideoProfile + "}";
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public List<EncoderProfilesProxy.AudioProfileProxy> getAudioProfiles() {
        return this.audioProfiles;
    }

    @Override // androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy
    public EncoderProfilesProxy.AudioProfileProxy getDefaultAudioProfile() {
        return this.defaultAudioProfile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getDefaultDurationSeconds() {
        return this.defaultDurationSeconds;
    }

    @Override // androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy
    public EncoderProfilesProxy.VideoProfileProxy getDefaultVideoProfile() {
        return this.defaultVideoProfile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getRecommendedFileFormat() {
        return this.recommendedFileFormat;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public List<EncoderProfilesProxy.VideoProfileProxy> getVideoProfiles() {
        return this.videoProfiles;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoValidatedEncoderProfilesProxy) == false) goto L27;
        VideoValidatedEncoderProfilesProxy r6 = (VideoValidatedEncoderProfilesProxy) r5;
        if (this.defaultDurationSeconds == r6.getDefaultDurationSeconds()) goto L10;
    L25:
        return false;
    L10:
        if (this.recommendedFileFormat != r6.getRecommendedFileFormat()) goto L25;
        if (this.audioProfiles.equals(r6.getAudioProfiles()) == false) goto L25;
        if (this.videoProfiles.equals(r6.getVideoProfiles()) == false) goto L25;
        EncoderProfilesProxy.AudioProfileProxy r1 = this.defaultAudioProfile;
        if (r1 != null) goto L21;
        if (r6.getDefaultAudioProfile() != null) goto L25;
    L23:
        if (this.defaultVideoProfile.equals(r6.getDefaultVideoProfile()) == false) goto L25;
        return true;
    L21:
        if (r1.equals(r6.getDefaultAudioProfile()) == false) goto L25;
    L27:
        return false;
    }

    public AutoValue_VideoValidatedEncoderProfilesProxy(int r1, int r2, List<EncoderProfilesProxy.AudioProfileProxy> r3, List<EncoderProfilesProxy.VideoProfileProxy> r4, EncoderProfilesProxy.AudioProfileProxy r5, EncoderProfilesProxy.VideoProfileProxy r6) {
        this.defaultDurationSeconds = r1;
        this.recommendedFileFormat = r2;
        if (r3 == null) goto L15;
        this.audioProfiles = r3;
        if (r4 == null) goto L13;
        this.videoProfiles = r4;
        this.defaultAudioProfile = r5;
        if (r6 == null) goto L11;
        this.defaultVideoProfile = r6;
        return;
    L11:
        throw new NullPointerException("Null defaultVideoProfile");
    L13:
        throw new NullPointerException("Null videoProfiles");
    L15:
        throw new NullPointerException("Null audioProfiles");
    }
}
