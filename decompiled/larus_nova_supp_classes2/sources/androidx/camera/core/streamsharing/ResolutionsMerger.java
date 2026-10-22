package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.SupportedOutputSizesSorter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.compose.material3.MenuKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ResolutionsMerger {
    private static final double SAME_AREA_WIDTH_HEIGHT_RATIO = 0.0d;
    private static final String TAG = "ResolutionsMerger";
    private final CameraInfoInternal mCameraInfo;
    private final Map<UseCaseConfig<?>, List<Size>> mChildSizesCache;
    private final Set<UseCaseConfig<?>> mChildrenConfigs;
    private final Rational mFallbackAspectRatio;
    private final Rational mSensorAspectRatio;
    private final Size mSensorSize;
    private final SupportedOutputSizesSorter mSizeSorter;

    public static class CompareAspectRatioByOverlappingAreaToReference implements Comparator<Rational> {
        private final Rational mReferenceAspectRatio;
        private final boolean mReverse;

        public CompareAspectRatioByOverlappingAreaToReference(Rational r1, boolean r2) {
            this.mReferenceAspectRatio = r1;
            this.mReverse = r2;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Rational r2, Rational r3) {
            float r4 = ResolutionsMerger.access$000(r2, this.mReferenceAspectRatio);
            float r5 = ResolutionsMerger.access$000(r3, this.mReferenceAspectRatio);
            if (this.mReverse == false) goto L7;
            return Float.compare(r5, r4);
        L7:
            return Float.compare(r4, r5);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Rational r1, Rational r2) {
            return compare2(r1, r2);
        }
    }

    private boolean areCroppingInDifferentDirection(float r4, float r5, float r6) {
        if (r4 != r5) goto L5;
        return false;
    L5:
        if (r5 != r6) goto L8;
        return false;
    L8:
        if (r4 > r5) goto L10;
        if (r5 <= r6) goto L18;
        return true;
    L18:
        return false;
    L10:
        if (r5 >= r6) goto L16;
        return true;
    L16:
        return false;
    }

    private List<Size> getCameraSupportedHighResolutions() {
        return this.mCameraInfo.getSupportedHighResolutions(34);
    }

    private List<Size> getCameraSupportedResolutions() {
        return this.mCameraInfo.getSupportedResolutions(34);
    }

    private Set<Size> getChildrenRequiredResolutions() {
        HashSet r0 = new HashSet();
        Iterator<UseCaseConfig<?>> r1 = this.mChildrenConfigs.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(getSortedChildSizes(r1.next()));
        goto L4
    L6:
        return r0;
    }

    private boolean shouldIncludeHighResolutions() {
        Iterator<UseCaseConfig<?>> r0 = this.mChildrenConfigs.iterator();
    L3:
        boolean r2 = false;
        if (r0.hasNext() == false) goto L14;
        UseCaseConfig<?> r1 = r0.next();
        if (r1.isHighResolutionDisabled(false) == true) goto L3;
        if ((r1 instanceof ImageOutputConfig) == false) goto L3;
        ResolutionSelector r3 = ((ImageOutputConfig) r1).getResolutionSelector(null);
        if (r3 == null) goto L3;
        r2 = true;
        if (r3.getAllowedResolutionMode() != 1) goto L3;
    L14:
        return r2;
    }

    private boolean needToAddSensorResolutions() {
        Iterator<Size> r0 = getChildrenRequiredResolutions().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (AspectRatioUtil.hasMatchingAspectRatio(r0.next(), this.mFallbackAspectRatio) == true) goto L4;
        return true;
    L9:
        return false;
    }

    static {
        SAME_AREA_WIDTH_HEIGHT_RATIO = Math.sqrt(2.3703703703703702d);
    }

    private static List<Size> filterOutChildSizesThatWillNeverBeSelected(List<Size> r7) {
        HashMap r0 = new HashMap();
        ArrayList r1 = new ArrayList();
        Iterator<Size> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L24;
        Size r2 = r8.next();
        Iterator r3 = r0.keySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Rational r4 = (Rational) r3.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r2, r4) == false) goto L7;
    L12:
        if (r4 == null) goto L22;
        Size r5 = (Size) r0.get(r4);
        Objects.requireNonNull(r5);
        if (r2.getHeight() > r5.getHeight()) goto L4;
        if (r2.getWidth() > r5.getWidth()) goto L4;
        if (r2.getWidth() != r5.getWidth()) goto L23;
        if (r2.getHeight() == r5.getHeight()) goto L4;
    L23:
        r1.add(r2);
        r0.put(r4, r2);
        goto L4
    L22:
        r4 = toRational(r2);
        goto L23
    L11:
        r4 = null;
        goto L12
    L24:
        return r1;
    }

    private static Rational findCloserAspectRatio(Size r4) {
        if ((((double) r4.getWidth()) / ((double) r4.getHeight())) <= SAME_AREA_WIDTH_HEIGHT_RATIO) goto L7;
        return AspectRatioUtil.ASPECT_RATIO_16_9;
    L7:
        return AspectRatioUtil.ASPECT_RATIO_4_3;
    }

    private static Rational getFallbackAspectRatio(Rational r3) {
        Rational r0 = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (r3.equals(r0) == false) goto L7;
        return AspectRatioUtil.ASPECT_RATIO_16_9;
    L7:
        if (r3.equals(AspectRatioUtil.ASPECT_RATIO_16_9) == false) goto L10;
        return r0;
    L10:
        throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + r3);
    }

    private static Rational getSensorAspectRatio(Size r3) {
        Rational r0 = findCloserAspectRatio(r3);
        Logger.d(TAG, "The closer aspect ratio to the sensor size (" + r3 + ") is " + r0 + ".");
        return r0;
    }

    private List<Size> getSortedChildSizes(UseCaseConfig<?> r4) {
        if (this.mChildrenConfigs.contains(r4) == false) goto L11;
        if (this.mChildSizesCache.containsKey(r4) == false) goto L8;
        List<Size> r5 = this.mChildSizesCache.get(r4);
        Objects.requireNonNull(r5);
        return r5;
    L8:
        List<Size> r0 = filterOutChildSizesThatWillNeverBeSelected(this.mSizeSorter.getSortedSupportedOutputSizes(r4));
        this.mChildSizesCache.put(r4, r0);
        return r0;
    L11:
        throw new IllegalArgumentException("Invalid child config: " + r4);
    }

    private static List<Size> getSupportedPrivResolutions(List<Pair<Integer, Size[]>> r3) {
        Iterator<Pair<Integer, Size[]>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Pair<Integer, Size[]> r0 = r4.next();
        if (((Integer) r0.first).equals(34) == false) goto L4;
        return Arrays.asList((Size[]) r0.second);
    L10:
        return new ArrayList();
    }

    private Map<Rational, List<Size>> groupSizesByAspectRatio(List<Size> r7) {
        HashMap r0 = new HashMap();
        Rational r1 = AspectRatioUtil.ASPECT_RATIO_4_3;
        r0.put(r1, new ArrayList());
        Rational r2 = AspectRatioUtil.ASPECT_RATIO_16_9;
        r0.put(r2, new ArrayList());
        ArrayList r3 = new ArrayList();
        r3.add(r1);
        r3.add(r2);
        Iterator<Size> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        Size r4 = r8.next();
        if (r4.getHeight() <= 0) goto L4;
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Rational r6 = (Rational) r5.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r4, r6) == false) goto L10;
        List r9 = (List) r0.get(r6);
    L15:
        if (r9 != null) goto L17;
        r9 = new ArrayList();
        Rational r10 = toRational(r4);
        r3.add(r10);
        r0.put(r10, r9);
    L17:
        r9.add(r4);
        goto L4
    L14:
        r9 = null;
        goto L15
    L18:
        return r0;
    }

    private static List<Size> removeDuplicates(List<Size> r2) {
        if (r2.isEmpty() == false) goto L6;
        return r2;
    L6:
        return new ArrayList(new LinkedHashSet(r2));
    }

    public static Rect reverseRect(Rect r4) {
        return new Rect(r4.top, r4.left, r4.bottom, r4.right);
    }

    private List<Size> selectParentResolutions(List<Size> r4) {
        ArrayList r0 = new ArrayList();
        if (needToAddSensorResolutions() == false) goto L5;
        r0.addAll(selectParentResolutionsByAspectRatio(this.mSensorAspectRatio, r4, false));
    L5:
        r0.addAll(selectParentResolutionsByAspectRatio(this.mFallbackAspectRatio, r4, false));
        r0.addAll(selectOtherAspectRatioParentResolutionsWithFovPriority(r4, false));
        if (r0.isEmpty() == false) goto L8;
        Logger.w(TAG, "Failed to find a parent resolution that does not result in double-cropping, this might due to camera not supporting 4:3 and 16:9resolutions or a strict ResolutionSelector settings. Starting resolution selection process with resolutions that might have a smaller FOV.");
        r0.addAll(selectOtherAspectRatioParentResolutionsWithFovPriority(r4, true));
    L8:
        Logger.d(TAG, "Parent resolutions: " + r0);
        return r0;
    }

    private void sortByFov(List<Rational> r4) {
        Collections.sort(r4, new CompareAspectRatioByOverlappingAreaToReference(toRational(this.mSensorSize), true));
    }

    public static void sortInDescendingOrder(List<Size> r2) {
        Collections.sort(r2, new CompareSizesByArea(true));
    }

    private static Rational toRational(Size r2) {
        return new Rational(r2.getWidth(), r2.getHeight());
    }

    private static Rational toRationalWithMod16Considered(Size r2) {
        Rational r0 = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (AspectRatioUtil.hasMatchingAspectRatio(r2, r0) == false) goto L5;
        return r0;
    L5:
        Rational r1 = AspectRatioUtil.ASPECT_RATIO_16_9;
        if (AspectRatioUtil.hasMatchingAspectRatio(r2, r1) == false) goto L9;
        return r1;
    L9:
        return toRational(r2);
    }

    public List<Size> getMergedResolutions(MutableConfig r4) {
        List<Size> r0 = getCameraSupportedResolutions();
        if (shouldIncludeHighResolutions() == false) goto L5;
        ArrayList r1 = new ArrayList(r0);
        r1.addAll(getCameraSupportedHighResolutions());
        r0 = r1;
    L5:
        List r5 = (List) r4.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
        if (r5 == null) goto L9;
        r0 = getSupportedPrivResolutions(r5);
    L9:
        return selectParentResolutions(r0);
    }

    public ResolutionsMerger(CameraInternal r2, Set<UseCaseConfig<?>> r3) {
        this(TransformUtils.rectToSize(r2.getCameraControlInternal().getSensorRect()), r2.getCameraInfoInternal(), r3);
    }

    public static /* synthetic */ float access$000(Rational r0, Rational r1) {
        return computeAreaOverlapping(r0, r1);
    }

    private static float computeAreaOverlapping(Rational r1, Rational r2) {
        float r3 = r1.floatValue();
        float r4 = r2.floatValue();
        if (r3 <= r4) goto L6;
        return r4 / r3;
    L6:
        return r3 / r4;
    }

    private List<Size> filterOutChildSizesCausingDoubleCropping(Rational r4, List<Size> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<Size> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Size r1 = r6.next();
        if (isDoubleCropping(r4, r1) == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public static List<Size> filterOutParentSizeThatIsTooSmall(Collection<Size> r3, List<Size> r4) {
        if (r3.isEmpty() == true) goto L15;
        if (r4.isEmpty() == true) goto L15;
        ArrayList r0 = new ArrayList();
        Iterator<Size> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Size r1 = r5.next();
        if (isAnyChildSizeCanBeCroppedOutWithoutUpscalingParent(r3, r1) == false) goto L9;
        r0.add(r1);
        goto L9
    L13:
        return r0;
    L15:
        return new ArrayList();
    }

    public static List<Size> filterResolutionsByAspectRatio(Rational r3, List<Size> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<Size> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Size r1 = r5.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r1, r3) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    private static Rect getCenterCroppedRectangle(Rational r5, Size r6) {
        int r0 = r6.getWidth();
        int r1 = r6.getHeight();
        Rational r7 = toRational(r6);
        if (r5.floatValue() != r7.floatValue()) goto L6;
        RectF r8 = new RectF(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r0, r1);
    L10:
        Rect r9 = new Rect();
        r8.round(r9);
        return r9;
    L6:
        if (r5.floatValue() <= r7.floatValue()) goto L8;
        float r10 = r0;
        float r11 = r10 / r5.floatValue();
        float r2 = (r1 - r11) / 2.0f;
        RectF r3 = new RectF(MenuKt.ClosedAlphaTarget, r2, r10, r11 + r2);
    L9:
        r8 = r3;
        goto L10
    L8:
        float r12 = r1;
        float r13 = r5.floatValue() * r12;
        float r4 = (r0 - r13) / 2.0f;
        r3 = new RectF(r4, MenuKt.ClosedAlphaTarget, r13 + r4, r12);
        goto L9
    }

    public static Rect getCropRectOfReferenceAspectRatio(Size r0, Size r1) {
        return getCenterCroppedRectangle(toRational(r1), r0);
    }

    public static List<Size> getParentSizesThatAreTooLarge(Collection<Size> r3, List<Size> r4) {
        if (r3.isEmpty() == true) goto L18;
        if (r4.isEmpty() == true) goto L18;
        List<Size> r5 = removeDuplicates(r4);
        ArrayList r0 = new ArrayList();
        Iterator<Size> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L14;
        Size r1 = r6.next();
        if (isAllChildSizesCanBeCroppedOutWithoutUpscalingParent(r3, r1) == false) goto L9;
        r0.add(r1);
        goto L9
    L14:
        if (r0.isEmpty() == true) goto L16;
        ListProtector.remove(r0, r0.size() - 1);
    L16:
        return r0;
    L18:
        return new ArrayList();
    }

    public static boolean hasUpscaling(Size r2, Size r3) {
        if (r2.getHeight() <= r3.getHeight()) goto L5;
    L8:
        return true;
    L5:
        if (r2.getWidth() > r3.getWidth()) goto L8;
        return false;
    }

    private static boolean isAllChildSizesCanBeCroppedOutWithoutUpscalingParent(Collection<Size> r1, Size r2) {
        Iterator<Size> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (hasUpscaling(r3.next(), r2) == false) goto L4;
        return false;
    L9:
        return true;
    }

    private static boolean isAnyChildSizeCanBeCroppedOutWithoutUpscalingParent(Collection<Size> r1, Size r2) {
        Iterator<Size> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (hasUpscaling(r3.next(), r2) == true) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isDoubleCropping(Rational r2, Size r3) {
        if (this.mSensorAspectRatio.equals(r2) == false) goto L5;
        return false;
    L5:
        if (AspectRatioUtil.hasMatchingAspectRatio(r3, r2) == false) goto L8;
        return false;
    L8:
        return areCroppingInDifferentDirection(this.mSensorAspectRatio.floatValue(), r2.floatValue(), toRationalWithMod16Considered(r3).floatValue());
    }

    private List<Size> selectOtherAspectRatioParentResolutionsWithFovPriority(List<Size> r5, boolean r6) {
        Map<Rational, List<Size>> r7 = groupSizesByAspectRatio(r5);
        ArrayList r0 = new ArrayList(r7.keySet());
        sortByFov(r0);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Rational r3 = (Rational) r2.next();
        if (r3.equals(AspectRatioUtil.ASPECT_RATIO_16_9) == true) goto L4;
        if (r3.equals(AspectRatioUtil.ASPECT_RATIO_4_3) == true) goto L4;
        List<Size> r4 = r7.get(r3);
        Objects.requireNonNull(r4);
        r1.addAll(selectParentResolutionsByAspectRatio(r3, r4, r6));
        goto L4
    L11:
        return r1;
    }

    public Size getPreferredChildSize(Size r4, UseCaseConfig<?> r5) {
        List<Size> r6 = getSortedChildSizes(r5);
        Iterator<Size> r0 = r6.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Size r1 = r0.next();
        if (isDoubleCropping(r4, r1) == true) goto L4;
        if (hasUpscaling(r1, r4) == true) goto L4;
        return r1;
    L11:
        Iterator<Size> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        Size r2 = r7.next();
        if (hasUpscaling(r2, r4) == true) goto L13;
        return r2;
    L17:
        return r4;
    }

    public Size getPreferredChildSizeForViewport(Size r3, UseCaseConfig<?> r4) {
        Iterator<Size> r5 = getSortedChildSizes(r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Size r0 = TransformUtils.rectToSize(getCropRectOfReferenceAspectRatio(r5.next(), r3));
        if (hasUpscaling(r0, r3) == true) goto L4;
        return r0;
    L8:
        return r3;
    }

    private boolean isDoubleCropping(Size r1, Size r2) {
        return isDoubleCropping(toRationalWithMod16Considered(r1), r2);
    }

    private ResolutionsMerger(Size r2, CameraInfoInternal r3, Set<UseCaseConfig<?>> r4) {
        this(r2, r3, r4, new SupportedOutputSizesSorter(r3, r2));
    }

    private Pair<Rect, Size> getPreferredChildSizePairInternal(Rect r1, UseCaseConfig<?> r2, boolean r3) {
        if (r3 == false) goto L4;
        Size r4 = getPreferredChildSizeForViewport(TransformUtils.rectToSize(r1), r2);
    L6:
        return new Pair(r1, r4);
    L4:
        Size r5 = TransformUtils.rectToSize(r1);
        r4 = getPreferredChildSize(r5, r2);
        r1 = getCropRectOfReferenceAspectRatio(r5, r4);
        goto L6
    }

    private List<Size> selectParentResolutionsByAspectRatio(Rational r5, List<Size> r6, boolean r7) {
        List<Size> r8 = filterResolutionsByAspectRatio(r5, r6);
        sortInDescendingOrder(r8);
        HashSet r0 = new HashSet(r8);
        Iterator<UseCaseConfig<?>> r1 = this.mChildrenConfigs.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        List<Size> r2 = getSortedChildSizes(r1.next());
        if (r7 == true) goto L9;
        r2 = filterOutChildSizesCausingDoubleCropping(r5, r2);
    L9:
        if (r2.isEmpty() == true) goto L11;
        r8 = filterOutParentSizeThatIsTooSmall(r2, r8);
        r0.retainAll(getParentSizesThatAreTooLarge(r2, r8));
        goto L4
    L11:
        return new ArrayList();
    L13:
        ArrayList r9 = new ArrayList();
        Iterator<Size> r10 = r8.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        Size r11 = r10.next();
        if (r0.contains(r11) == true) goto L15;
        r9.add(r11);
        goto L15
    L19:
        return r9;
    }

    public ResolutionsMerger(Size r2, CameraInfoInternal r3, Set<UseCaseConfig<?>> r4, SupportedOutputSizesSorter r5) {
        this.mChildSizesCache = new HashMap();
        this.mSensorSize = r2;
        Rational r6 = getSensorAspectRatio(r2);
        this.mSensorAspectRatio = r6;
        this.mFallbackAspectRatio = getFallbackAspectRatio(r6);
        this.mCameraInfo = r3;
        this.mChildrenConfigs = r4;
        this.mSizeSorter = r5;
    }

    public Pair<Rect, Size> getPreferredChildSizePair(UseCaseConfig<?> r1, Rect r2, int r3, boolean r4) {
        if (TransformUtils.is90or270(r3) == false) goto L5;
        r2 = reverseRect(r2);
        boolean r5 = true;
    L6:
        Pair<Rect, Size> r6 = getPreferredChildSizePairInternal(r2, r1, r4);
        Rect r7 = (Rect) r6.first;
        Size r8 = (Size) r6.second;
        if (r5 == false) goto L10;
        r8 = TransformUtils.reverseSize(r8);
        r7 = reverseRect(r7);
    L10:
        return new Pair(r7, r8);
    L5:
        r5 = false;
        goto L6
    }
}
