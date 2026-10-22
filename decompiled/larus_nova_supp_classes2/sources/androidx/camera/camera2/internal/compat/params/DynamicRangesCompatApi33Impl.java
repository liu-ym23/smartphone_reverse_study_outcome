package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class DynamicRangesCompatApi33Impl implements DynamicRangesCompat.DynamicRangeProfilesCompatImpl {
    private final DynamicRangeProfiles mDynamicRangeProfiles;

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return profileSetToDynamicRangeSet(this.mDynamicRangeProfiles.getSupportedProfiles());
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public DynamicRangeProfiles unwrap() {
        return this.mDynamicRangeProfiles;
    }

    public DynamicRangesCompatApi33Impl(Object r1) {
        this.mDynamicRangeProfiles = (DynamicRangeProfiles) r1;
    }

    private Long dynamicRangeToFirstSupportedProfile(DynamicRange r2) {
        return DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(r2, this.mDynamicRangeProfiles);
    }

    private static Set<DynamicRange> profileSetToDynamicRangeSet(Set<Long> r3) {
        if (r3.isEmpty() == true) goto L5;
        HashSet r0 = new HashSet(r3.size());
        Iterator<Long> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L11;
        r0.add(profileToDynamicRange(r4.next().longValue()));
        goto L8
    L11:
        return Collections.unmodifiableSet(r0);
    L5:
        return Collections.emptySet();
    }

    private static DynamicRange profileToDynamicRange(long r3) {
        return (DynamicRange) Preconditions.checkNotNull(DynamicRangeConversions.profileToDynamicRange(r3), "Dynamic range profile cannot be converted to a DynamicRange object: " + r3);
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(DynamicRange r5) {
        Long r0 = dynamicRangeToFirstSupportedProfile(r5);
        if (r0 == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "DynamicRange is not supported: " + r5);
        return profileSetToDynamicRangeSet(this.mDynamicRangeProfiles.getProfileCaptureRequestConstraints(r0.longValue()));
    L5:
        r1 = false;
        goto L6
    }

    @Override // androidx.camera.camera2.internal.compat.params.DynamicRangesCompat.DynamicRangeProfilesCompatImpl
    public boolean isExtraLatencyPresent(DynamicRange r5) {
        Long r0 = dynamicRangeToFirstSupportedProfile(r5);
        if (r0 == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "DynamicRange is not supported: " + r5);
        return this.mDynamicRangeProfiles.isExtraLatencyPresent(r0.longValue());
    L5:
        r1 = false;
        goto L6
    }
}
