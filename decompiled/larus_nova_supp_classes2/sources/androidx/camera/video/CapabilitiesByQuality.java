package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class CapabilitiesByQuality {
    private static final String TAG = "CapabilitiesByQuality";
    private final TreeMap<Size, Quality> mAreaSortedSizeToQualityMap;
    private final VideoValidatedEncoderProfilesProxy mHighestProfiles;
    private final VideoValidatedEncoderProfilesProxy mLowestProfiles;
    private final Map<Quality, VideoValidatedEncoderProfilesProxy> mSupportedProfilesMap;

    public List<Quality> getSupportedQualities() {
        return new ArrayList(this.mSupportedProfilesMap.keySet());
    }

    public CapabilitiesByQuality(EncoderProfilesProvider r7) {
        this.mSupportedProfilesMap = new LinkedHashMap();
        this.mAreaSortedSizeToQualityMap = new TreeMap(new CompareSizesByArea());
        Iterator<Quality> r0 = Quality.getSortedQualities().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Quality r1 = r0.next();
        EncoderProfilesProxy r3 = getEncoderProfiles(r1, r7);
        if (r3 == null) goto L4;
        Logger.d(TAG, "profiles = " + r3);
        VideoValidatedEncoderProfilesProxy r4 = toValidatedProfiles(r3);
        if (r4 == null) goto L10;
        EncoderProfilesProxy.VideoProfileProxy r2 = r4.getDefaultVideoProfile();
        this.mAreaSortedSizeToQualityMap.put(new Size(r2.getWidth(), r2.getHeight()), r1);
        this.mSupportedProfilesMap.put(r1, r4);
        goto L4
    L10:
        Logger.w(TAG, "EncoderProfiles of quality " + r1 + " has no video validated profiles.");
        goto L4
    L13:
        if (this.mSupportedProfilesMap.isEmpty() == false) goto L15;
        Logger.e(TAG, "No supported EncoderProfiles");
        this.mLowestProfiles = null;
        this.mHighestProfiles = null;
        return;
    L15:
        ArrayDeque r8 = new ArrayDeque(this.mSupportedProfilesMap.values());
        this.mHighestProfiles = (VideoValidatedEncoderProfilesProxy) r8.peekFirst();
        this.mLowestProfiles = (VideoValidatedEncoderProfilesProxy) r8.peekLast();
    }

    private static void checkQualityConstantsOrThrow(Quality r3) {
        Preconditions.checkArgument(Quality.containsQuality(r3), "Unknown quality: " + r3);
    }

    private VideoValidatedEncoderProfilesProxy toValidatedProfiles(EncoderProfilesProxy r2) {
        if (r2.getVideoProfiles().isEmpty() == false) goto L7;
        return null;
    L7:
        return VideoValidatedEncoderProfilesProxy.from(r2);
    }

    public VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size r4) {
        Quality r0 = findNearestHigherSupportedQualityFor(r4);
        Logger.d(TAG, "Using supported quality of " + r0 + " for size " + r4);
        if (r0 == Quality.NONE) goto L9;
        VideoValidatedEncoderProfilesProxy r5 = getProfiles(r0);
        if (r5 == null) goto L8;
        return r5;
    L8:
        throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles for advertised quality.");
    L9:
        return null;
    }

    public Quality findNearestHigherSupportedQualityFor(Size r2) {
        Quality r3 = (Quality) SizeUtil.findNearestHigherFor(r2, this.mAreaSortedSizeToQualityMap);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return Quality.NONE;
    }

    public VideoValidatedEncoderProfilesProxy getProfiles(Quality r2) {
        checkQualityConstantsOrThrow(r2);
        if (r2 != Quality.HIGHEST) goto L7;
        return this.mHighestProfiles;
    L7:
        if (r2 != Quality.LOWEST) goto L11;
        return this.mLowestProfiles;
    L11:
        return this.mSupportedProfilesMap.get(r2);
    }

    public boolean isQualitySupported(Quality r1) {
        checkQualityConstantsOrThrow(r1);
        if (getProfiles(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private EncoderProfilesProxy getEncoderProfiles(Quality r3, EncoderProfilesProvider r4) {
        Preconditions.checkState(r3 instanceof Quality.ConstantQuality, "Currently only support ConstantQuality");
        return r4.getAll(((Quality.ConstantQuality) r3).getValue());
    }
}
