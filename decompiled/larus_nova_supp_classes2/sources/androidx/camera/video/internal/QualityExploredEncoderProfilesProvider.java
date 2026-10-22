package androidx.camera.video.internal;

import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.CapabilitiesByQuality;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.camera.video.internal.utils.EncoderProfilesUtil;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class QualityExploredEncoderProfilesProvider implements EncoderProfilesProvider {
    private final EncoderProfilesProvider mBaseEncoderProfilesProvider;
    private final Set<Size> mCameraSupportedResolutions;
    private final Map<DynamicRange, CapabilitiesByQuality> mDynamicRangeToCapabilitiesMap;
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache;
    private final Set<DynamicRange> mTargetDynamicRanges;
    private final Set<Quality> mTargetQualities;
    private final Function<VideoEncoderConfig, VideoEncoderInfo> mVideoEncoderInfoFinder;

    private static void checkFullySpecifiedOrThrow(Collection<DynamicRange> r3) {
        Iterator<DynamicRange> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        DynamicRange r0 = r4.next();
        if (r0.isFullySpecified() == true) goto L4;
        throw new IllegalArgumentException("Contains non-fully specified DynamicRange: " + r0);
    }

    private EncoderProfilesProxy exploreProfiles(Quality.ConstantQuality r12) {
        Preconditions.checkArgument(this.mTargetQualities.contains(r12));
        EncoderProfilesProxy r0 = this.mBaseEncoderProfilesProvider.getAll(r12.getValue());
        Iterator<Size> r13 = r12.getTypicalSizes().iterator();
    L4:
        if (r13.hasNext() == false) goto L27;
        Size r1 = r13.next();
        if (this.mCameraSupportedResolutions.contains(r1) == false) goto L4;
        TreeMap r2 = new TreeMap(new CompareSizesByArea());
        ArrayList r3 = new ArrayList();
        Iterator<DynamicRange> r4 = this.mTargetDynamicRanges.iterator();
    L10:
        if (r4.hasNext() == false) goto L24;
        DynamicRange r5 = r4.next();
        if (hasMatchedVideoProfileForDynamicRange(r0, r5) == true) goto L10;
        VideoValidatedEncoderProfilesProxy r6 = getCapabilitiesByQualityFor(r5).findNearestHigherSupportedEncoderProfilesFor(r1);
        if (r6 == null) goto L10;
        EncoderProfilesProxy.VideoProfileProxy r7 = r6.getDefaultVideoProfile();
        VideoEncoderConfig r8 = VideoConfigUtil.toVideoEncoderConfig(r7);
        VideoEncoderInfo r9 = this.mVideoEncoderInfoFinder.apply(r8);
        if (r9 == null) goto L10;
        if (r9.isSizeSupportedAllowSwapping(r1.getWidth(), r1.getHeight()) == false) goto L10;
        r2.put(new Size(r7.getWidth(), r7.getHeight()), r6);
        r3.add(EncoderProfilesUtil.deriveVideoProfile(r7, r1, r9.getSupportedBitrateRange()));
        goto L10
    L24:
        if (r3.isEmpty() == true) goto L4;
        EncoderProfilesProxy r14 = (EncoderProfilesProxy) SizeUtil.findNearestHigherFor(r1, r2);
        Objects.requireNonNull(r14);
        EncoderProfilesProxy r15 = r14;
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r15.getDefaultDurationSeconds(), r15.getRecommendedFileFormat(), r15.getAudioProfiles(), r3);
    L27:
        return null;
    }

    private Quality.ConstantQuality findQualityInTargetQualities(int r4) {
        Iterator<Quality> r0 = this.mTargetQualities.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Quality.ConstantQuality r1 = (Quality.ConstantQuality) r0.next();
        if (r1.getValue() != r4) goto L4;
        return r1;
    L8:
        return null;
    }

    private CapabilitiesByQuality getCapabilitiesByQualityFor(DynamicRange r3) {
        if (this.mDynamicRangeToCapabilitiesMap.containsKey(r3) == false) goto L6;
        CapabilitiesByQuality r4 = this.mDynamicRangeToCapabilitiesMap.get(r3);
        Objects.requireNonNull(r4);
        return r4;
    L6:
        CapabilitiesByQuality r1 = new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mBaseEncoderProfilesProvider, r3));
        this.mDynamicRangeToCapabilitiesMap.put(r3, r1);
        return r1;
    }

    private EncoderProfilesProxy getProfilesInternal(int r4) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(r4)) == true) goto L5;
        EncoderProfilesProxy r0 = this.mBaseEncoderProfilesProvider.getAll(r4);
        Quality.ConstantQuality r1 = findQualityInTargetQualities(r4);
        if (r1 != null) goto L9;
    L11:
        this.mEncoderProfilesCache.put(Integer.valueOf(r4), r0);
        return r0;
    L9:
        if (hasMatchedVideoProfileForAllTargetDynamicRanges(r0) == true) goto L11;
        r0 = mergeEncoderProfiles(r0, exploreProfiles(r1));
        goto L11
    L5:
        return this.mEncoderProfilesCache.get(Integer.valueOf(r4));
    }

    private boolean hasMatchedVideoProfileForAllTargetDynamicRanges(EncoderProfilesProxy r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<DynamicRange> r1 = this.mTargetDynamicRanges.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        if (hasMatchedVideoProfileForDynamicRange(r4, r1.next()) == true) goto L7;
        return false;
    L11:
        return true;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public EncoderProfilesProxy getAll(int r1) {
        return getProfilesInternal(r1);
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int r1) {
        if (getProfilesInternal(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasMatchedVideoProfileForDynamicRange(EncoderProfilesProxy r2, DynamicRange r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Iterator<EncoderProfilesProxy.VideoProfileProxy> r4 = r2.getVideoProfiles().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (DynamicRangeUtil.isHdrSettingsMatched(r4.next(), r3) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private static EncoderProfilesProxy mergeEncoderProfiles(EncoderProfilesProxy r4, EncoderProfilesProxy r5) {
        if (r4 != null) goto L6;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r4 == null) goto L8;
        int r0 = r4.getDefaultDurationSeconds();
    L9:
        if (r4 == null) goto L11;
        int r1 = r4.getRecommendedFileFormat();
    L12:
        if (r4 == null) goto L14;
        List<EncoderProfilesProxy.AudioProfileProxy> r2 = r4.getAudioProfiles();
    L15:
        ArrayList r3 = new ArrayList();
        if (r4 == null) goto L18;
        r3.addAll(r4.getVideoProfiles());
    L18:
        if (r5 == null) goto L21;
        r3.addAll(r5.getVideoProfiles());
    L21:
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r0, r1, r2, r3);
    L14:
        r2 = r5.getAudioProfiles();
        goto L15
    L11:
        r1 = r5.getRecommendedFileFormat();
        goto L12
    L8:
        r0 = r5.getDefaultDurationSeconds();
        goto L9
    }

    public QualityExploredEncoderProfilesProvider(EncoderProfilesProvider r2, Collection<Quality> r3, Collection<DynamicRange> r4, Collection<Size> r5, Function<VideoEncoderConfig, VideoEncoderInfo> r6) {
        this.mEncoderProfilesCache = new HashMap();
        this.mDynamicRangeToCapabilitiesMap = new HashMap();
        checkFullySpecifiedOrThrow(r4);
        this.mBaseEncoderProfilesProvider = r2;
        this.mTargetQualities = new HashSet(r3);
        this.mTargetDynamicRanges = new HashSet(r4);
        this.mCameraSupportedResolutions = new HashSet(r5);
        this.mVideoEncoderInfoFinder = r6;
    }
}
