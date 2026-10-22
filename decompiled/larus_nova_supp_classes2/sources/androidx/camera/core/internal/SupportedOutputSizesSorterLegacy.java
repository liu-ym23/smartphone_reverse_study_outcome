package androidx.camera.core.internal;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class SupportedOutputSizesSorterLegacy {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final Rational mFullFovRatio;
    private final boolean mIsSensorLandscapeResolution;
    private final int mLensFacing;
    private final int mSensorOrientation;

    private Size getTargetSize(ImageOutputConfig r4) {
        int r0 = r4.getTargetRotation(0);
        return flipSizeByRotation(r4.getTargetResolution(null), r0, this.mLensFacing, this.mSensorOrientation);
    }

    public SupportedOutputSizesSorterLegacy(CameraInfoInternal r2, Rational r3) {
        this.mSensorOrientation = r2.getSensorRotationDegrees();
        this.mLensFacing = r2.getLensFacing();
        this.mFullFovRatio = r3;
        boolean r4 = true;
        if (r3 != null) goto L5;
    L8:
        this.mIsSensorLandscapeResolution = r4;
        return;
    L5:
        if (r3.getNumerator() >= r3.getDenominator()) goto L8;
        r4 = false;
        goto L8
    }

    private static Rational getAspectRatioGroupKeyOfTargetSize(Size r2, List<Size> r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Iterator<Rational> r4 = SupportedOutputSizesSorter.getResolutionListGroupingAspectRatioKeys(r3).iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        Rational r0 = r4.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r2, r0) == false) goto L7;
        return r0;
    L12:
        return new Rational(r2.getWidth(), r2.getHeight());
    }

    private Rational getTargetAspectRatioByLegacyApi(ImageOutputConfig r2, List<Size> r3) {
        if (r2.hasTargetAspectRatio() == true) goto L10;
        Size r4 = getTargetSize(r2);
        if (r4 != null) goto L11;
        return null;
    L11:
        return getAspectRatioGroupKeyOfTargetSize(r4, r3);
    L10:
        return SupportedOutputSizesSorter.getTargetAspectRatioRationalValue(r2.getTargetAspectRatio(), this.mIsSensorLandscapeResolution);
    }

    public List<Size> sortSupportedOutputSizes(List<Size> r11, UseCaseConfig<?> r12) {
        if (r11.isEmpty() == false) goto L5;
        return r11;
    L5:
        ArrayList r0 = new ArrayList(r11);
        Collections.sort(r0, new CompareSizesByArea(true));
        ArrayList r13 = new ArrayList();
        ImageOutputConfig r14 = (ImageOutputConfig) r12;
        Size r3 = r14.getMaxResolution(null);
        Size r4 = (Size) ListProtector.get(r0, 0);
        if (r3 != null) goto L8;
    L9:
        r3 = r4;
    L10:
        Size r5 = getTargetSize(r14);
        Size r6 = SizeUtil.RESOLUTION_VGA;
        int r7 = SizeUtil.getArea(r6);
        if (SizeUtil.getArea(r3) >= r7) goto L13;
        r6 = SizeUtil.RESOLUTION_ZERO;
    L17:
        Iterator r8 = r0.iterator();
    L19:
        if (r8.hasNext() == false) goto L28;
        Size r9 = (Size) r8.next();
        if (SizeUtil.getArea(r9) > SizeUtil.getArea(r3)) goto L19;
        if (SizeUtil.getArea(r9) < SizeUtil.getArea(r6)) goto L19;
        if (r13.contains(r9) == true) goto L19;
        r13.add(r9);
        goto L19
    L28:
        if (r13.isEmpty() == true) goto L54;
        Rational r1 = getTargetAspectRatioByLegacyApi(r14, r13);
        if (r5 != null) goto L32;
        r5 = r14.getDefaultResolution(null);
    L32:
        ArrayList r15 = new ArrayList();
        new HashMap();
        if (r1 != null) goto L37;
        r15.addAll(r13);
        if (r5 == null) goto L52;
        SupportedOutputSizesSorter.sortSupportedSizesByFallbackRuleClosestHigherThenLower(r15, r5, true);
    L52:
        return r15;
    L37:
        Map<Rational, List<Size>> r16 = SupportedOutputSizesSorter.groupSizesByAspectRatio(r13);
        if (r5 == null) goto L43;
        Iterator<Rational> r2 = r16.keySet().iterator();
    L41:
        if (r2.hasNext() == false) goto L43;
        SupportedOutputSizesSorter.sortSupportedSizesByFallbackRuleClosestHigherThenLower(r16.get(r2.next()), r5, true);
    L43:
        ArrayList r10 = new ArrayList(r16.keySet());
        Collections.sort(r10, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(r1, this.mFullFovRatio));
        Iterator r17 = r10.iterator();
    L45:
        if (r17.hasNext() == false) goto L52;
        Iterator<Size> r18 = r16.get((Rational) r17.next()).iterator();
    L48:
        if (r18.hasNext() == false) goto L45;
        Size r19 = r18.next();
        if (r15.contains(r19) == true) goto L48;
        r15.add(r19);
        goto L48
    L54:
        throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + r6 + "\nmaxSize = " + r3 + "\ninitial size list: " + r0);
    L13:
        if (r5 == null) goto L17;
        if (SizeUtil.getArea(r5) >= r7) goto L17;
        r6 = r5;
        goto L17
    L8:
        if (SizeUtil.getArea(r4) >= SizeUtil.getArea(r3)) goto L10;
        goto L9
    }

    private static boolean isRotationNeeded(int r2, int r3, int r4) {
        int r5 = CameraOrientationUtil.surfaceRotationToDegrees(r2);
        if (1 != r3) goto L5;
        boolean r6 = true;
    L6:
        int r7 = CameraOrientationUtil.getRelativeImageRotation(r5, r4, r6);
        if (r7 != 90) goto L9;
    L10:
        return true;
    L9:
        if (r7 == 270) goto L10;
        return false;
    L5:
        r6 = false;
        goto L6
    }

    private static Size flipSizeByRotation(Size r0, int r1, int r2, int r3) {
        if (r0 != null) goto L4;
        return r0;
    L4:
        if (isRotationNeeded(r1, r2, r3) == true) goto L6;
        return r0;
    L6:
        return new Size(r0.getHeight(), r0.getWidth());
    }
}
