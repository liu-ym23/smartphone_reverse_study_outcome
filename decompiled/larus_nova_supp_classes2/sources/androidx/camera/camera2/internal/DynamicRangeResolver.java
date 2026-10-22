package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class DynamicRangeResolver {
    private static final String TAG = "DynamicRangeResolver";
    private final CameraCharacteristicsCompat mCharacteristics;
    private final DynamicRangesCompat mDynamicRangesInfo;
    private final boolean mIs10BitSupported;

    public static final class Api33Impl {
        private Api33Impl() {
        }

        public static DynamicRange getRecommended10BitDynamicRange(CameraCharacteristicsCompat r2) {
            Long r3 = (Long) r2.get(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (r3 != null) goto L5;
            return null;
        L5:
            return DynamicRangeConversions.profileToDynamicRange(r3.longValue());
        }
    }

    public boolean is10BitDynamicRangeSupported() {
        return this.mIs10BitSupported;
    }

    public DynamicRangeResolver(CameraCharacteristicsCompat r6) {
        this.mCharacteristics = r6;
        this.mDynamicRangesInfo = DynamicRangesCompat.fromCameraCharacteristics(r6);
        int[] r7 = (int[]) r6.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean r0 = false;
        if (r7 == null) goto L10;
        int r1 = r7.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        if (r7[r2] == 18) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        r0 = true;
    L10:
        this.mIs10BitSupported = r0;
    }

    private static boolean isFullyUnspecified(DynamicRange r1) {
        return Objects.equals(r1, DynamicRange.UNSPECIFIED);
    }

    private static boolean isPartiallySpecified(DynamicRange r2) {
        if (r2.getEncoding() != 2) goto L5;
    L14:
        return true;
    L5:
        if (r2.getEncoding() == 0) goto L9;
        if (r2.getBitDepth() == 0) goto L14;
    L9:
        if (r2.getEncoding() == 0) goto L11;
    L13:
        return false;
    L11:
        if (r2.getBitDepth() == 0) goto L13;
        goto L13
    }

    private static boolean canResolve(DynamicRange r4, DynamicRange r5) {
        Preconditions.checkState(r5.isFullySpecified(), "Fully specified range is not actually fully specified.");
        if (r4.getEncoding() != 2) goto L8;
        if (r5.getEncoding() != 1) goto L8;
        return false;
    L8:
        if (r4.getEncoding() == 2) goto L15;
        if (r4.getEncoding() == 0) goto L15;
        if (r4.getEncoding() == r5.getEncoding()) goto L15;
        return false;
    L15:
        if (r4.getBitDepth() != 0) goto L17;
        return true;
    L17:
        if (r4.getBitDepth() == r5.getBitDepth()) goto L22;
        return false;
    L22:
        return true;
    }

    private static boolean canResolveWithinConstraints(DynamicRange r1, DynamicRange r2, Set<DynamicRange> r3) {
        if (r3.contains(r2) == true) goto L7;
        Logger.d(TAG, String.format("Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  %s\nCandidate dynamic range:\n  %s", new Object[]{r1, r2}));
        return false;
    L7:
        return canResolve(r1, r2);
    }

    private static DynamicRange findSupportedHdrMatch(DynamicRange r6, Collection<DynamicRange> r7, Set<DynamicRange> r8) {
        if (r6.getEncoding() != 1) goto L5;
        return null;
    L5:
        Iterator<DynamicRange> r9 = r7.iterator();
    L7:
        if (r9.hasNext() == false) goto L14;
        DynamicRange r0 = r9.next();
        Preconditions.checkNotNull(r0, "Fully specified DynamicRange cannot be null.");
        int r3 = r0.getEncoding();
        Preconditions.checkState(r0.isFullySpecified(), "Fully specified DynamicRange must have fully defined encoding.");
        if (r3 == 1) goto L7;
        if (canResolveWithinConstraints(r6, r0, r8) == false) goto L7;
        return r0;
    L14:
        return null;
    }

    private static void updateConstraints(Set<DynamicRange> r4, DynamicRange r5, DynamicRangesCompat r6) {
        Preconditions.checkState(!r4.isEmpty(), "Cannot update already-empty constraints.");
        Set<DynamicRange> r7 = r6.getDynamicRangeCaptureRequestConstraints(r5);
        if (r7.isEmpty() == true) goto L9;
        HashSet r0 = new HashSet(r4);
        r4.retainAll(r7);
        if (r4.isEmpty() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(String.format("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  %s\nConstraints:\n  %s\nExisting constraints:\n  %s", new Object[]{r5, TextUtils.join("\n  ", r7), TextUtils.join("\n  ", r0)}));
    }

    public Map<UseCaseConfig<?>, DynamicRange> resolveAndValidateDynamicRanges(List<AttachedSurfaceInfo> r11, List<UseCaseConfig<?>> r12, List<Integer> r13) {
        LinkedHashSet r6 = new LinkedHashSet();
        Iterator<AttachedSurfaceInfo> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r6.add(r14.next().getDynamicRange());
        goto L4
    L6:
        Set<DynamicRange> r15 = this.mDynamicRangesInfo.getSupportedDynamicRanges();
        HashSet r7 = new HashSet(r15);
        Iterator<DynamicRange> r0 = r6.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        updateConstraints(r7, r0.next(), this.mDynamicRangesInfo);
        goto L8
    L10:
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<Integer> r16 = r13.iterator();
    L12:
        if (r16.hasNext() == false) goto L20;
        UseCaseConfig r4 = (UseCaseConfig) ListProtector.get(r12, r16.next().intValue());
        DynamicRange r5 = r4.getDynamicRange();
        if (isFullyUnspecified(r5) == true) goto L15;
        if (isPartiallySpecified(r5) == true) goto L18;
        r1.add(r4);
        goto L12
    L18:
        r2.add(r4);
        goto L12
    L15:
        r3.add(r4);
        goto L12
    L20:
        HashMap r17 = new HashMap();
        LinkedHashSet r18 = new LinkedHashSet();
        ArrayList r8 = new ArrayList();
        r8.addAll(r1);
        r8.addAll(r2);
        r8.addAll(r3);
        Iterator r9 = r8.iterator();
    L22:
        if (r9.hasNext() == false) goto L26;
        UseCaseConfig<?> r10 = (UseCaseConfig) r9.next();
        DynamicRange r19 = resolveDynamicRangeAndUpdateConstraints(r15, r6, r18, r10, r7);
        r17.put(r10, r19);
        if (r6.contains(r19) == true) goto L22;
        r18.add(r19);
        goto L22
    L26:
        return r17;
    }

    private DynamicRange resolveDynamicRange(DynamicRange r9, Set<DynamicRange> r10, Set<DynamicRange> r11, Set<DynamicRange> r12, String r13) {
        if (r9.isFullySpecified() == true) goto L5;
        int r0 = r9.getEncoding();
        int r2 = r9.getBitDepth();
        if (r0 != 1) goto L15;
        if (r2 != 0) goto L15;
        DynamicRange r14 = DynamicRange.SDR;
        if (r10.contains(r14) == false) goto L14;
        return r14;
    L14:
        return null;
    L15:
        DynamicRange r15 = findSupportedHdrMatch(r9, r11, r10);
        if (r15 == null) goto L19;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from existing attached surface.\n%s\n->\n%s", new Object[]{r13, r9, r15}));
        return r15;
    L19:
        DynamicRange r16 = findSupportedHdrMatch(r9, r12, r10);
        if (r16 == null) goto L23;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from concurrently bound use case.\n%s\n->\n%s", new Object[]{r13, r9, r16}));
        return r16;
    L23:
        DynamicRange r17 = DynamicRange.SDR;
        if (canResolveWithinConstraints(r9, r17, r10) == false) goto L27;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s to no compatible HDR dynamic ranges.\n%s\n->\n%s", new Object[]{r13, r9, r17}));
        return r17;
    L27:
        if (r0 == 2) goto L29;
    L45:
        Iterator<DynamicRange> r18 = r10.iterator();
    L47:
        if (r18.hasNext() == false) goto L55;
        DynamicRange r19 = r18.next();
        Preconditions.checkState(r19.isFullySpecified(), "Candidate dynamic range must be fully specified.");
        if (r19.equals(DynamicRange.SDR) == true) goto L47;
        if (canResolve(r9, r19) == false) goto L47;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from validated dynamic range constraints or supported HDR dynamic ranges.\n%s\n->\n%s", new Object[]{r13, r9, r19}));
        return r19;
    L55:
        return null;
    L29:
        if (r2 == 10) goto L31;
        if (r2 != 0) goto L45;
    L31:
        LinkedHashSet r110 = new LinkedHashSet();
        if (Build.VERSION.SDK_INT < 33) goto L36;
        DynamicRange r111 = Api33Impl.getRecommended10BitDynamicRange(this.mCharacteristics);
        if (r111 == null) goto L37;
        r110.add(r111);
    L37:
        r110.add(DynamicRange.HLG_10_BIT);
        DynamicRange r112 = findSupportedHdrMatch(r9, r110, r10);
        if (r112 == null) goto L45;
        Object[] r113 = new Object[4];
        r113[0] = r13;
        if (r112.equals(r111) == false) goto L42;
        String r114 = "recommended";
    L43:
        r113[1] = r114;
        r113[2] = r9;
        r113[3] = r112;
        Logger.d(TAG, String.format("Resolved dynamic range for use case %s from %s 10-bit supported dynamic range.\n%s\n->\n%s", r113));
        return r112;
    L42:
        r114 = "required";
        goto L43
    L36:
        r111 = null;
        goto L37
    L5:
        if (r10.contains(r9) == false) goto L7;
        return r9;
    L7:
        return null;
    }

    private DynamicRange resolveDynamicRangeAndUpdateConstraints(Set<DynamicRange> r8, Set<DynamicRange> r9, Set<DynamicRange> r10, UseCaseConfig<?> r11, Set<DynamicRange> r12) {
        DynamicRange r6 = r11.getDynamicRange();
        DynamicRange r13 = resolveDynamicRange(r6, r12, r9, r10, r11.getTargetName());
        if (r13 == null) goto L7;
        updateConstraints(r12, r13, this.mDynamicRangesInfo);
        return r13;
    L7:
        throw new IllegalArgumentException(String.format("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  %s\nRequested dynamic range:\n  %s\nSupported dynamic ranges:\n  %s\nConstrained set of concurrent dynamic ranges:\n  %s", new Object[]{r11.getTargetName(), r6, TextUtils.join("\n  ", r8), TextUtils.join("\n  ", r12)}));
    }
}
