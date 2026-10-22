package androidx.camera.core.internal;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SupportedOutputSizesSorter {
    private static final String TAG = "SupportedOutputSizesCollector";
    private final CameraInfoInternal mCameraInfoInternal;
    private final Rational mFullFovRatio;
    private final int mLensFacing;
    private final int mSensorOrientation;
    private final SupportedOutputSizesSorterLegacy mSupportedOutputSizesSorterLegacy;

    private Rational calculateFullFovRatioFromActiveArraySize(Size r3) {
        return new Rational(r3.getWidth(), r3.getHeight());
    }

    private Rational calculateFullFovRatioFromSupportedOutputSizes(CameraInfoInternal r3) {
        List<Size> r4 = r3.getSupportedResolutions(256);
        if (r4.isEmpty() == false) goto L6;
        return null;
    L6:
        Size r5 = (Size) Collections.max(r4, new CompareSizesByArea());
        return new Rational(r5.getWidth(), r5.getHeight());
    }

    public static List<Rational> getResolutionListGroupingAspectRatioKeys(List<Size> r5) {
        ArrayList r0 = new ArrayList();
        r0.add(AspectRatioUtil.ASPECT_RATIO_4_3);
        r0.add(AspectRatioUtil.ASPECT_RATIO_16_9);
        Iterator<Size> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L16;
        Size r1 = r6.next();
        Rational r2 = new Rational(r1.getWidth(), r1.getHeight());
        if (r0.contains(r2) == true) goto L4;
        Iterator r3 = r0.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        if (AspectRatioUtil.hasMatchingAspectRatio(r1, (Rational) r3.next()) == false) goto L9;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L4;
        r0.add(r2);
        goto L4
    L13:
        r4 = false;
        goto L14
    L16:
        return r0;
    }

    public static Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> r5) {
        HashMap r0 = new HashMap();
        Iterator<Rational> r1 = getResolutionListGroupingAspectRatioKeys(r5).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.put(r1.next(), new ArrayList());
        goto L4
    L6:
        Iterator<Size> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        Size r2 = r6.next();
        Iterator r3 = r0.keySet().iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        Rational r4 = (Rational) r3.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r2, r4) == false) goto L11;
        ((List) r0.get(r4)).add(r2);
        goto L11
    L15:
        return r0;
    }

    public List<Size> getSortedSupportedOutputSizes(UseCaseConfig<?> r13) {
        ImageOutputConfig r0 = (ImageOutputConfig) r13;
        List<Size> r2 = r0.getCustomOrderedResolutions(null);
        if (r2 == null) goto L5;
        return r2;
    L5:
        ResolutionSelector r3 = r0.getResolutionSelector(null);
        List<Size> r4 = getResolutionCandidateList(r0.getSupportedResolutions(null), r13.getInputFormat());
        if (r3 == null) goto L8;
        Size r7 = ((ImageOutputConfig) r13).getMaxResolution(null);
        int r8 = r0.getTargetRotation(0);
        if (r13.isHighResolutionDisabled(false) == true) goto L12;
        r4 = applyHighResolutionSettings(r4, r3, r13.getInputFormat());
    L12:
        ResolutionSelector r5 = r0.getResolutionSelector();
        return sortSupportedOutputSizesByResolutionSelector(r5, r4, r7, r8, this.mFullFovRatio, this.mSensorOrientation, this.mLensFacing);
    L8:
        return this.mSupportedOutputSizesSorterLegacy.sortSupportedOutputSizes(r4, r13);
    }

    public SupportedOutputSizesSorter(CameraInfoInternal r2, Size r3) {
        this.mCameraInfoInternal = r2;
        this.mSensorOrientation = r2.getSensorRotationDegrees();
        this.mLensFacing = r2.getLensFacing();
        if (r3 == null) goto L5;
        Rational r4 = calculateFullFovRatioFromActiveArraySize(r3);
    L6:
        this.mFullFovRatio = r4;
        this.mSupportedOutputSizesSorterLegacy = new SupportedOutputSizesSorterLegacy(r2, r4);
        return;
    L5:
        r4 = calculateFullFovRatioFromSupportedOutputSizes(r2);
        goto L6
    }

    private static void applyMaxResolutionRestriction(LinkedHashMap<Rational, List<Size>> r6, Size r7) {
        int r8 = SizeUtil.getArea(r7);
        Iterator<Rational> r0 = r6.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        List r1 = r6.get(r0.next());
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Size r4 = (Size) r3.next();
        if (SizeUtil.getArea(r4) > r8) goto L7;
        r2.add(r4);
        goto L7
    L11:
        r1.clear();
        r1.addAll(r2);
        goto L4
    }

    private static void applyResolutionStrategy(LinkedHashMap<Rational, List<Size>> r2, ResolutionStrategy r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<Rational> r0 = r2.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        applyResolutionStrategyFallbackRule(r2.get(r0.next()), r3);
        goto L6
    }

    private static void applyResolutionStrategyFallbackRule(List<Size> r4, ResolutionStrategy r5) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Integer r0 = Integer.valueOf(r5.getFallbackRule());
        if (r5.equals(ResolutionStrategy.HIGHEST_AVAILABLE_STRATEGY) == false) goto L8;
        return;
    L8:
        Size r6 = r5.getBoundSize();
        int r1 = r0.intValue();
        if (r1 != 0) goto L11;
        sortSupportedSizesByFallbackRuleNone(r4, r6);
        return;
    L11:
        if (r1 != 1) goto L13;
        sortSupportedSizesByFallbackRuleClosestHigherThenLower(r4, r6, true);
        return;
    L13:
        if (r1 != 2) goto L15;
        sortSupportedSizesByFallbackRuleClosestHigherThenLower(r4, r6, false);
        return;
    L15:
        if (r1 != 3) goto L17;
        sortSupportedSizesByFallbackRuleClosestLowerThenHigher(r4, r6, true);
        return;
    L17:
        if (r1 != 4) goto L29;
        sortSupportedSizesByFallbackRuleClosestLowerThenHigher(r4, r6, false);
        return;
    }

    private List<Size> getResolutionCandidateList(List<Pair<Integer, Size[]>> r3, int r4) {
        List<Size> r5 = getSizeListByFormat(r3, r4);
        if (r5 != null) goto L5;
        r5 = this.mCameraInfoInternal.getSupportedResolutions(r4);
    L5:
        ArrayList r0 = new ArrayList(r5);
        Collections.sort(r0, new CompareSizesByArea(true));
        if (r0.isEmpty() == false) goto L8;
        Logger.w(TAG, "The retrieved supported resolutions from camera info internal is empty. Format is " + r4 + ".");
    L8:
        return r0;
    }

    private List<Size> getSizeListByFormat(List<Pair<Integer, Size[]>> r4, int r5) {
        if (r4 == null) goto L10;
        Iterator<Pair<Integer, Size[]>> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Pair<Integer, Size[]> r1 = r6.next();
        if (((Integer) r1.first).intValue() != r5) goto L6;
        Size[] r7 = (Size[]) r1.second;
    L11:
        if (r7 != null) goto L14;
        return null;
    L14:
        return Arrays.asList(r7);
    L10:
        r7 = null;
        goto L11
    }

    public static Rational getTargetAspectRatioRationalValue(int r1, boolean r2) {
        if (r1 == (-1)) goto L14;
        if (r1 != 0) goto L6;
        if (r2 == false) goto L19;
        return AspectRatioUtil.ASPECT_RATIO_4_3;
    L19:
        return AspectRatioUtil.ASPECT_RATIO_3_4;
    L6:
        if (r1 == 1) goto L8;
        Logger.e(TAG, "Undefined target aspect ratio: " + r1);
        goto L14
    L8:
        if (r2 == false) goto L17;
        return AspectRatioUtil.ASPECT_RATIO_16_9;
    L17:
        return AspectRatioUtil.ASPECT_RATIO_9_16;
    L14:
        return null;
    }

    private static void sortSupportedSizesByFallbackRuleNone(List<Size> r1, Size r2) {
        boolean r0 = r1.contains(r2);
        r1.clear();
        if (r0 == false) goto L6;
        r1.add(r2);
        return;
    }

    private static LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategy(List<Size> r0, AspectRatioStrategy r1, Rational r2) {
        return applyAspectRatioStrategyFallbackRule(groupSizesByAspectRatio(r0), r1, r2);
    }

    private static LinkedHashMap<Rational, List<Size>> applyAspectRatioStrategyFallbackRule(Map<Rational, List<Size>> r4, AspectRatioStrategy r5, Rational r6) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        Rational r1 = getTargetAspectRatioRationalValue(r5.getPreferredAspectRatio(), r0);
        if (r5.getFallbackRule() != 0) goto L16;
        Rational r7 = getTargetAspectRatioRationalValue(r5.getPreferredAspectRatio(), r0);
        Iterator r2 = new ArrayList(r4.keySet()).iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        Rational r3 = (Rational) r2.next();
        if (r3.equals(r7) == true) goto L12;
        r4.remove(r3);
    L16:
        ArrayList r8 = new ArrayList(r4.keySet());
        Collections.sort(r8, new AspectRatioUtil.CompareAspectRatiosByMappingAreaInFullFovAspectRatioSpace(r1, r6));
        LinkedHashMap<Rational, List<Size>> r9 = new LinkedHashMap();
        Iterator r10 = r8.iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        Rational r11 = (Rational) r10.next();
        r9.put(r11, r4.get(r11));
        goto L18
    L20:
        return r9;
    L5:
        if (r6.getNumerator() >= r6.getDenominator()) goto L8;
        r0 = false;
        goto L8
    }

    private List<Size> applyHighResolutionSettings(List<Size> r2, ResolutionSelector r3, int r4) {
        if (r3.getAllowedResolutionMode() != 1) goto L6;
        ArrayList r5 = new ArrayList();
        r5.addAll(r2);
        r5.addAll(this.mCameraInfoInternal.getSupportedHighResolutions(r4));
        Collections.sort(r5, new CompareSizesByArea(true));
        return r5;
    L6:
        return r2;
    }

    public static void sortSupportedSizesByFallbackRuleClosestHigherThenLower(List<Size> r5, Size r6, boolean r7) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.size() - 1;
    L3:
        if (r1 < 0) goto L9;
        Size r2 = (Size) ListProtector.get(r5, r1);
        if (r2.getWidth() < r6.getWidth()) goto L8;
        if (r2.getHeight() >= r6.getHeight()) goto L9;
    L8:
        ListProtector.add(r0, 0, r2);
        r1 = r1 - 1;
    L9:
        r5.removeAll(r0);
        Collections.reverse(r5);
        if (r7 == false) goto L17;
        r5.addAll(r0);
        return;
    }

    private static void sortSupportedSizesByFallbackRuleClosestLowerThenHigher(List<Size> r6, Size r7, boolean r8) {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= r6.size()) goto L10;
        Size r3 = (Size) ListProtector.get(r6, r2);
        if (r3.getWidth() > r7.getWidth()) goto L9;
        if (r3.getHeight() <= r7.getHeight()) goto L10;
    L9:
        ListProtector.add(r0, 0, r3);
        r2 = r2 + 1;
    L10:
        r6.removeAll(r0);
        if (r8 == false) goto L18;
        r6.addAll(r0);
        return;
    }

    private static List<Size> applyResolutionFilter(List<Size> r1, ResolutionFilter r2, int r3, int r4, int r5) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        int r6 = CameraOrientationUtil.surfaceRotationToDegrees(r3);
        boolean r0 = true;
        if (r5 == 1) goto L8;
        r0 = false;
    L8:
        int r7 = CameraOrientationUtil.getRelativeImageRotation(r6, r4, r0);
        List<Size> r8 = r2.filter(new ArrayList(r1), r7);
        if (r1.containsAll(r8) == false) goto L12;
        return r8;
    L12:
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    public static List<Size> sortSupportedOutputSizesByResolutionSelector(ResolutionSelector r2, List<Size> r3, Size r4, int r5, Rational r6, int r7, int r8) {
        LinkedHashMap<Rational, List<Size>> r9 = applyAspectRatioStrategy(r3, r2.getAspectRatioStrategy(), r6);
        if (r4 == null) goto L5;
        applyMaxResolutionRestriction(r9, r4);
    L5:
        applyResolutionStrategy(r9, r2.getResolutionStrategy());
        ArrayList r10 = new ArrayList();
        Iterator<List<Size>> r11 = r9.values().iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        Iterator<Size> r12 = r11.next().iterator();
    L10:
        if (r12.hasNext() == false) goto L7;
        Size r0 = r12.next();
        if (r10.contains(r0) == true) goto L10;
        r10.add(r0);
        goto L10
    L15:
        return applyResolutionFilter(r10, r2.getResolutionFilter(), r5, r7, r8);
    }
}
