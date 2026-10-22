package androidx.camera.video.internal;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DynamicRangeMatchedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final DynamicRange mDynamicRange;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final EncoderProfilesProvider mEncoderProfilesProvider;

    private EncoderProfilesProxy getProfilesInternal(int r3) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r3)) == false) goto L7;
        return this.mEncoderProfilesCache.get(Integer.valueOf(r3));
    L7:
        if (this.mEncoderProfilesProvider.hasProfile(r3) == false) goto L9;
        EncoderProfilesProxy r0 = filterUnmatchedDynamicRange(this.mEncoderProfilesProvider.getAll(r3), this.mDynamicRange);
        this.mEncoderProfilesCache.put(Integer.valueOf(r3), r0);
        return r0;
    L9:
        return null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r1) {
        return getProfilesInternal(r1);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r3) {
        if (this.mEncoderProfilesProvider.hasProfile(r3) == true) goto L6;
        return false;
    L6:
        if (getProfilesInternal(r3) == null) goto L9;
        return true;
    L9:
        return false;
    }

    public DynamicRangeMatchedEncoderProfilesProvider(EncoderProfilesProvider r2, DynamicRange r3) {
        this.mEncoderProfilesCache = new HashMap();
        this.mEncoderProfilesProvider = r2;
        this.mDynamicRange = r3;
    }

    private static EncoderProfilesProxy filterUnmatchedDynamicRange(EncoderProfilesProxy r5, DynamicRange r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r2 = r5.getVideoProfiles().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        EncoderProfilesProxy.VideoProfileProxy r3 = r2.next();
        if (DynamicRangeUtil.isHdrSettingsMatched(r3, r6) == false) goto L7;
        r1.add(r3);
        goto L7
    L12:
        if (r1.isEmpty() == false) goto L15;
        return null;
    L15:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r5.getDefaultDurationSeconds(), r5.getRecommendedFileFormat(), r5.getAudioProfiles(), r1);
    }
}
