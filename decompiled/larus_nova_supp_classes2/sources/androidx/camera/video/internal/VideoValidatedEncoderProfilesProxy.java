package androidx.camera.video.internal;

import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class VideoValidatedEncoderProfilesProxy implements EncoderProfilesProxy {
    public VideoValidatedEncoderProfilesProxy() {
    }

    public abstract EncoderProfilesProxy.AudioProfileProxy getDefaultAudioProfile();

    public abstract EncoderProfilesProxy.VideoProfileProxy getDefaultVideoProfile();

    public static VideoValidatedEncoderProfilesProxy from(EncoderProfilesProxy r3) {
        return create(r3.getDefaultDurationSeconds(), r3.getRecommendedFileFormat(), r3.getAudioProfiles(), r3.getVideoProfiles());
    }

    public static VideoValidatedEncoderProfilesProxy create(int r9, int r10, List<EncoderProfilesProxy.AudioProfileProxy> r11, List<EncoderProfilesProxy.VideoProfileProxy> r12) {
        Preconditions.checkArgument(!r12.isEmpty(), "Should contain at least one VideoProfile.");
        EncoderProfilesProxy.VideoProfileProxy r8 = (EncoderProfilesProxy.VideoProfileProxy) ListProtector.get(r12, 0);
        if (r11.isEmpty() == true) goto L5;
        EncoderProfilesProxy.AudioProfileProxy r0 = (EncoderProfilesProxy.AudioProfileProxy) ListProtector.get(r11, 0);
    L7:
        return new AutoValue_VideoValidatedEncoderProfilesProxy(r9, r10, Collections.unmodifiableList(new ArrayList(r11)), Collections.unmodifiableList(new ArrayList(r12)), r0, r8);
    L5:
        r0 = null;
        goto L7
    }
}
