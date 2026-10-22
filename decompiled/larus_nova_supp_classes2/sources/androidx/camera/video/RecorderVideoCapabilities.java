package androidx.camera.video;

import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.internal.BackupHdrProfileEncoderProfilesProvider;
import androidx.camera.video.internal.DynamicRangeMatchedEncoderProfilesProvider;
import androidx.camera.video.internal.QualityExploredEncoderProfilesProvider;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.workaround.QualityAddedEncoderProfilesProvider;
import androidx.camera.video.internal.workaround.QualityResolutionModifiedEncoderProfilesProvider;
import androidx.camera.video.internal.workaround.QualityValidatedEncoderProfilesProvider;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class RecorderVideoCapabilities implements VideoCapabilities {
    private final Map<DynamicRange, CapabilitiesByQuality> mCapabilitiesMapForFullySpecifiedDynamicRange;
    private final Map<DynamicRange, CapabilitiesByQuality> mCapabilitiesMapForNonFullySpecifiedDynamicRange;
    private final boolean mIsStabilizationSupported;
    private final EncoderProfilesProvider mProfilesProvider;

    @Override // androidx.camera.video.VideoCapabilities
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mCapabilitiesMapForFullySpecifiedDynamicRange.keySet();
    }

    @Override // androidx.camera.video.VideoCapabilities
    public boolean isStabilizationSupported() {
        return this.mIsStabilizationSupported;
    }

    private CapabilitiesByQuality generateCapabilitiesForNonFullySpecifiedDynamicRange(DynamicRange r3) {
        if (DynamicRanges.canResolve(r3, getSupportedDynamicRanges()) == true) goto L7;
        return null;
    L7:
        return new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mProfilesProvider, r3));
    }

    private CapabilitiesByQuality getCapabilities(DynamicRange r3) {
        if (r3.isFullySpecified() == false) goto L7;
        return this.mCapabilitiesMapForFullySpecifiedDynamicRange.get(r3);
    L7:
        if (this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.containsKey(r3) == true) goto L9;
        CapabilitiesByQuality r0 = generateCapabilitiesForNonFullySpecifiedDynamicRange(r3);
        this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.put(r3, r0);
        return r0;
    L9:
        return this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.get(r3);
    }

    private static boolean isHlg10SupportedByCamera(CameraInfoInternal r3) {
        Iterator<DynamicRange> r4 = r3.getSupportedDynamicRanges().iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        DynamicRange r0 = r4.next();
        Integer r1 = Integer.valueOf(r0.getEncoding());
        int r2 = r0.getBitDepth();
        if (r1.equals(3) == false) goto L4;
        if (r2 != 10) goto L4;
        return true;
    L11:
        return false;
    }

    @Override // androidx.camera.video.VideoCapabilities
    public List<Quality> getSupportedQualities(DynamicRange r1) {
        CapabilitiesByQuality r2 = getCapabilities(r1);
        if (r2 != null) goto L6;
        return new ArrayList();
    L6:
        return r2.getSupportedQualities();
    }

    @Override // androidx.camera.video.VideoCapabilities
    public VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size r1, DynamicRange r2) {
        CapabilitiesByQuality r3 = getCapabilities(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3.findNearestHigherSupportedEncoderProfilesFor(r1);
    }

    @Override // androidx.camera.video.VideoCapabilities
    public Quality findNearestHigherSupportedQualityFor(Size r1, DynamicRange r2) {
        CapabilitiesByQuality r3 = getCapabilities(r2);
        if (r3 != null) goto L6;
        return Quality.NONE;
    L6:
        return r3.findNearestHigherSupportedQualityFor(r1);
    }

    @Override // androidx.camera.video.VideoCapabilities
    public VideoValidatedEncoderProfilesProxy getProfiles(Quality r1, DynamicRange r2) {
        CapabilitiesByQuality r3 = getCapabilities(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3.getProfiles(r1);
    }

    @Override // androidx.camera.video.VideoCapabilities
    public boolean isQualitySupported(Quality r1, DynamicRange r2) {
        CapabilitiesByQuality r3 = getCapabilities(r2);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.isQualitySupported(r1) == false) goto L7;
        return true;
    }

    public RecorderVideoCapabilities(int r10, CameraInfoInternal r11, Function<VideoEncoderConfig, VideoEncoderInfo> r12) {
        this.mCapabilitiesMapForFullySpecifiedDynamicRange = new HashMap();
        this.mCapabilitiesMapForNonFullySpecifiedDynamicRange = new HashMap();
        if (r10 == 0) goto L7;
        if (r10 == 1) goto L7;
        boolean r1 = false;
    L8:
        Preconditions.checkArgument(r1, "Not a supported video capabilities source: " + r10);
        EncoderProfilesProvider r2 = r11.getEncoderProfilesProvider();
        Quirks r3 = DeviceQuirks.getAll();
        EncoderProfilesProvider r4 = new QualityAddedEncoderProfilesProvider(r2, r3, r11, r12);
        if (r10 != 1) goto L11;
        r4 = new QualityExploredEncoderProfilesProvider(r4, Quality.getSortedQualities(), Collections.singleton(DynamicRange.SDR), r11.getSupportedResolutions(34), r12);
    L11:
        EncoderProfilesProvider r13 = new QualityResolutionModifiedEncoderProfilesProvider(r4, r3);
        if (isHlg10SupportedByCamera(r11) == false) goto L14;
        r13 = new BackupHdrProfileEncoderProfilesProvider(r13, r12);
    L14:
        this.mProfilesProvider = new QualityValidatedEncoderProfilesProvider(r13, r11, r3);
        Iterator<DynamicRange> r14 = r11.getSupportedDynamicRanges().iterator();
    L16:
        if (r14.hasNext() == false) goto L20;
        DynamicRange r15 = r14.next();
        CapabilitiesByQuality r5 = new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mProfilesProvider, r15));
        if (r5.getSupportedQualities().isEmpty() == true) goto L16;
        this.mCapabilitiesMapForFullySpecifiedDynamicRange.put(r15, r5);
        goto L16
    L20:
        this.mIsStabilizationSupported = r11.isVideoStabilizationSupported();
        return;
    L7:
        r1 = true;
        goto L8
    }
}
