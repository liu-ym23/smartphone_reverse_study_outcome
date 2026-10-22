package androidx.camera.core.impl.compat;

import android.media.EncoderProfiles;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class EncoderProfilesProxyCompatApi33Impl {
    private EncoderProfilesProxyCompatApi33Impl() {
    }

    public static EncoderProfilesProxy from(EncoderProfiles r3) {
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r3.getDefaultDurationSeconds(), r3.getRecommendedFileFormat(), fromAudioProfiles(r3.getAudioProfiles()), fromVideoProfiles(r3.getVideoProfiles()));
    }

    private static List<EncoderProfilesProxy.AudioProfileProxy> fromAudioProfiles(List<EncoderProfiles.AudioProfile> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<EncoderProfiles.AudioProfile> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        EncoderProfiles.AudioProfile r1 = r9.next();
        r0.add(EncoderProfilesProxy.AudioProfileProxy.create(r1.getCodec(), r1.getMediaType(), r1.getBitrate(), r1.getSampleRate(), r1.getChannels(), r1.getProfile()));
        goto L4
    L6:
        return r0;
    }

    private static List<EncoderProfilesProxy.VideoProfileProxy> fromVideoProfiles(List<EncoderProfiles.VideoProfile> r12) {
        ArrayList r0 = new ArrayList();
        Iterator<EncoderProfiles.VideoProfile> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        EncoderProfiles.VideoProfile r1 = r13.next();
        r0.add(EncoderProfilesProxy.VideoProfileProxy.create(r1.getCodec(), r1.getMediaType(), r1.getBitrate(), r1.getFrameRate(), r1.getWidth(), r1.getHeight(), r1.getProfile(), r1.getBitDepth(), r1.getChromaSubsampling(), r1.getHdrFormat()));
        goto L4
    L6:
        return r0;
    }
}
