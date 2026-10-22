package androidx.camera.video.internal.workaround;

import android.util.Size;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.compat.quirk.StretchedVideoResolutionQuirk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class QualityResolutionModifiedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final EncoderProfilesProvider mProvider;
    private final Quirks mQuirks;

    private Size getAlternativeResolution(int r3) {
        Iterator r0 = this.mQuirks.getAll(StretchedVideoResolutionQuirk.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        StretchedVideoResolutionQuirk r1 = (StretchedVideoResolutionQuirk) r0.next();
        if (r1 == null) goto L4;
        return r1.getAlternativeResolution(r3);
    L9:
        return null;
    }

    private EncoderProfilesProxy getProfilesInternal(int r3) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r3)) == false) goto L7;
        return this.mEncoderProfilesCache.get(Integer.valueOf(r3));
    L7:
        if (this.mProvider.hasProfile(r3) == false) goto L12;
        EncoderProfilesProxy r0 = this.mProvider.getAll(r3);
        Objects.requireNonNull(r0);
        EncoderProfilesProxy r1 = r0;
        Size r2 = getAlternativeResolution(r3);
        if (r2 == null) goto L13;
        r1 = createNewEncoderProfiles(r1, r2);
    L13:
        this.mEncoderProfilesCache.put(Integer.valueOf(r3), r1);
        return r1;
    L12:
        r1 = null;
        goto L13
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r1) {
        return getProfilesInternal(r1);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r3) {
        if (this.mProvider.hasProfile(r3) == true) goto L6;
        return false;
    L6:
        if (getProfilesInternal(r3) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public QualityResolutionModifiedEncoderProfilesProvider(EncoderProfilesProvider r2, Quirks r3) {
        this.mEncoderProfilesCache = new HashMap();
        this.mProvider = r2;
        this.mQuirks = r3;
    }

    private EncoderProfilesProxy createNewEncoderProfiles(EncoderProfilesProxy r4, Size r5) {
        ArrayList r0 = new ArrayList();
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r1 = r4.getVideoProfiles().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.add(generateVideoProfile(r1.next(), r5));
        goto L4
    L7:
        if (r0.isEmpty() == false) goto L10;
        return null;
    L10:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r4.getDefaultDurationSeconds(), r4.getRecommendedFileFormat(), r4.getAudioProfiles(), r0);
    }

    private static EncoderProfilesProxy.VideoProfileProxy generateVideoProfile(EncoderProfilesProxy.VideoProfileProxy r10, Size r11) {
        return EncoderProfilesProxy.VideoProfileProxy.create(r10.getCodec(), r10.getMediaType(), r10.getBitrate(), r10.getFrameRate(), r11.getWidth(), r11.getHeight(), r10.getProfile(), r10.getBitDepth(), r10.getChromaSubsampling(), r10.getHdrFormat());
    }
}
