package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.workaround.ExtraSupportedSurfaceCombinationsContainer;
import androidx.camera.camera2.internal.compat.workaround.ResolutionCorrector;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraMode;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class SupportedSurfaceCombination {
    private static final String TAG = "SupportedSurfaceCombination";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final String mCameraId;
    private final CameraCharacteristicsCompat mCharacteristics;
    private final List<SurfaceCombination> mConcurrentSurfaceCombinations;
    private final DisplayInfoManager mDisplayInfoManager;
    private final DynamicRangeResolver mDynamicRangeResolver;
    private final ExtraSupportedSurfaceCombinationsContainer mExtraSupportedSurfaceCombinationsContainer;
    private final Map<FeatureSettings, List<SurfaceCombination>> mFeatureSettingsToSupportedCombinationsMap;
    private final int mHardwareLevel;
    private boolean mIsBurstCaptureSupported;
    private boolean mIsConcurrentCameraModeSupported;
    private boolean mIsPreviewStabilizationSupported;
    private boolean mIsRawSupported;
    private boolean mIsStreamUseCaseSupported;
    private boolean mIsUltraHighResolutionSensorSupported;
    private final List<SurfaceCombination> mPreviewStabilizationSurfaceCombinations;
    private final ResolutionCorrector mResolutionCorrector;
    private final List<SurfaceCombination> mSurfaceCombinations;
    private final List<SurfaceCombination> mSurfaceCombinations10Bit;
    private final List<SurfaceCombination> mSurfaceCombinationsStreamUseCase;
    private final List<SurfaceCombination> mSurfaceCombinationsUltraHdr;
    SurfaceSizeDefinition mSurfaceSizeDefinition;
    List<Integer> mSurfaceSizeDefinitionFormats;
    private final TargetAspectRatio mTargetAspectRatio;
    private final List<SurfaceCombination> mUltraHighSurfaceCombinations;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Size[] getHighResolutionOutputSizes(StreamConfigurationMap r0, int r1) {
            return r0.getHighResolutionOutputSizes(r1);
        }
    }

    public static abstract class FeatureSettings {
        public FeatureSettings() {
        }

        public abstract int getCameraMode();

        public abstract int getRequiredMaxBitDepth();

        public abstract boolean isPreviewStabilizationOn();

        public abstract boolean isUltraHdrOn();

        public static FeatureSettings of(int r1, int r2, boolean r3, boolean r4) {
            return new AutoValue_SupportedSurfaceCombination_FeatureSettings(r1, r2, r3, r4);
        }
    }

    private void checkCustomization() {
    }

    private void generate10BitSupportedCombinationList() {
        this.mSurfaceCombinations10Bit.addAll(GuaranteedConfigurationsUtil.get10BitSupportedCombinationList());
    }

    private void generateConcurrentSupportedCombinationList() {
        this.mConcurrentSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getConcurrentSupportedCombinationList());
    }

    private void generatePreviewStabilizationSupportedCombinationList() {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        this.mPreviewStabilizationSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getPreviewStabilizationSupportedCombinationList());
        return;
    }

    private void generateStreamUseCaseSupportedCombinationList() {
        if (Build.VERSION.SDK_INT < 33) goto L6;
        this.mSurfaceCombinationsStreamUseCase.addAll(GuaranteedConfigurationsUtil.getStreamUseCaseSupportedCombinationList());
        return;
    }

    private void generateSupportedCombinationList() {
        this.mSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.generateSupportedCombinationList(this.mHardwareLevel, this.mIsRawSupported, this.mIsBurstCaptureSupported));
        this.mSurfaceCombinations.addAll(this.mExtraSupportedSurfaceCombinationsContainer.get(this.mCameraId));
    }

    private void generateSurfaceSizeDefinition() {
        Size r3 = this.mDisplayInfoManager.getPreviewSize();
        Size r5 = getRecordSize();
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(SizeUtil.RESOLUTION_VGA, new HashMap(), r3, new HashMap(), r5, new HashMap(), new HashMap());
    }

    private void generateUltraHdrSupportedCombinationList() {
        this.mSurfaceCombinationsUltraHdr.addAll(GuaranteedConfigurationsUtil.getUltraHdrSupportedCombinationList());
    }

    private void generateUltraHighSupportedCombinationList() {
        this.mUltraHighSurfaceCombinations.addAll(GuaranteedConfigurationsUtil.getUltraHighResolutionSupportedCombinationList());
    }

    private Size getRecordSize() {
        int r0 = CastIntegerProtector.parseInt(this.mCameraId);     // Catch: NumberFormatException -> L12
        if (this.mCamcorderProfileHelper.hasProfile(r0, 1) == false) goto L6;
        CamcorderProfile r1 = this.mCamcorderProfileHelper.get(r0, 1);
    L7:
        if (r1 == null) goto L11;
        return new Size(r1.videoFrameWidth, r1.videoFrameHeight);
    L11:
        return getRecordSizeByHasProfile(r0);
    L6:
        r1 = null;
    L13:
        return getRecordSizeFromStreamConfigurationMap();
    }

    private Size getRecordSizeFromStreamConfigurationMap() {
        Size[] r0 = this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap().getOutputSizes(MediaRecorder.class);
        if (r0 == null) goto L5;
        Arrays.sort(r0, new CompareSizesByArea(true));
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L15;
        Size r3 = r0[r2];
        int r4 = r3.getWidth();
        Size r5 = SizeUtil.RESOLUTION_1080P;
        if (r4 > r5.getWidth()) goto L13;
        if (r3.getHeight() > r5.getHeight()) goto L13;
        return r3;
    L13:
        r2 = r2 + 1;
        goto L7
    L15:
        return SizeUtil.RESOLUTION_480P;
    L5:
        return SizeUtil.RESOLUTION_480P;
    }

    private boolean isUltraHdrSupported() {
        int[] r0 = this.mCharacteristics.getStreamConfigurationMapCompat().getOutputFormats();
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        if (r0[r3] == 4101) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void refreshPreviewSize() {
        this.mDisplayInfoManager.refresh();
        if (this.mSurfaceSizeDefinition != null) goto L5;
        generateSurfaceSizeDefinition();
        return;
    L5:
        Size r3 = this.mDisplayInfoManager.getPreviewSize();
        this.mSurfaceSizeDefinition = SurfaceSizeDefinition.create(this.mSurfaceSizeDefinition.getAnalysisSize(), this.mSurfaceSizeDefinition.getS720pSizeMap(), r3, this.mSurfaceSizeDefinition.getS1440pSizeMap(), this.mSurfaceSizeDefinition.getRecordSize(), this.mSurfaceSizeDefinition.getMaximumSizeMap(), this.mSurfaceSizeDefinition.getUltraMaximumSizeMap());
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    public boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    private List<List<Size>> getAllPossibleSizeArrangements(List<List<Size>> r13) {
        Iterator<List<Size>> r0 = r13.iterator();
        int r2 = 1;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = r2 * r0.next().size();
        goto L4
    L6:
        if (r2 == 0) goto L22;
        ArrayList r1 = new ArrayList();
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L10;
        r1.add(new ArrayList());
        r4 = r4 + 1;
        goto L8
    L10:
        int r5 = r2 / ((List) ListProtector.get(r13, 0)).size();
        int r6 = r2;
        int r7 = 0;
    L12:
        if (r7 >= r13.size()) goto L20;
        List r8 = (List) ListProtector.get(r13, r7);
        int r9 = 0;
    L14:
        if (r9 >= r2) goto L17;
        ((List) ListProtector.get(r1, r9)).add((Size) ListProtector.get(r8, (r9 % r6) / r5));
        r9 = r9 + 1;
        goto L14
    L17:
        if (r7 >= (r13.size() - 1)) goto L19;
        int r10 = r5 / ((List) ListProtector.get(r13, r7 + 1)).size();
        r6 = r5;
        r5 = r10;
    L19:
        r7 = r7 + 1;
        goto L12
    L20:
        return r1;
    L22:
        throw new IllegalArgumentException("Failed to find supported resolutions.");
    }

    private int getMaxSupportedFpsFromAttachedSurfaces(List<AttachedSurfaceInfo> r4) {
        Iterator<AttachedSurfaceInfo> r5 = r4.iterator();
        int r0 = Integer.MAX_VALUE;
    L4:
        if (r5.hasNext() == false) goto L6;
        AttachedSurfaceInfo r1 = r5.next();
        r0 = getUpdatedMaximumFps(r0, r1.getImageFormat(), r1.getSize());
        goto L4
    L6:
        return r0;
    }

    private static int getRangeLength(Range<Integer> r1) {
        return (((Integer) r1.getUpper()).intValue() - ((Integer) r1.getLower()).intValue()) + 1;
    }

    private Size getRecordSizeByHasProfile(int r4) {
        Size r0 = SizeUtil.RESOLUTION_480P;
        if (this.mCamcorderProfileHelper.hasProfile(r4, 10) == false) goto L6;
        CamcorderProfile r5 = this.mCamcorderProfileHelper.get(r4, 10);
    L21:
        if (r5 != null) goto L23;
        return r0;
    L23:
        return new Size(r5.videoFrameWidth, r5.videoFrameHeight);
    L6:
        if (this.mCamcorderProfileHelper.hasProfile(r4, 8) == false) goto L9;
        r5 = this.mCamcorderProfileHelper.get(r4, 8);
        goto L21
    L9:
        if (this.mCamcorderProfileHelper.hasProfile(r4, 12) == false) goto L12;
        r5 = this.mCamcorderProfileHelper.get(r4, 12);
        goto L21
    L12:
        if (this.mCamcorderProfileHelper.hasProfile(r4, 6) == false) goto L15;
        r5 = this.mCamcorderProfileHelper.get(r4, 6);
        goto L21
    L15:
        if (this.mCamcorderProfileHelper.hasProfile(r4, 5) == false) goto L18;
        r5 = this.mCamcorderProfileHelper.get(r4, 5);
        goto L21
    L18:
        if (this.mCamcorderProfileHelper.hasProfile(r4, 4) == false) goto L20;
        r5 = this.mCamcorderProfileHelper.get(r4, 4);
        goto L21
    L20:
        r5 = null;
        goto L21
    }

    private static int getRequiredMaxBitDepth(Map<UseCaseConfig<?>, DynamicRange> r2) {
        Iterator<DynamicRange> r3 = r2.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        if (r3.next().getBitDepth() != 10) goto L4;
        return 10;
    L8:
        return 8;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private List<SurfaceCombination> getSurfaceCombinationsByFeatureSettings(FeatureSettings r4) {
        if (this.mFeatureSettingsToSupportedCombinationsMap.containsKey(r4) == true) goto L5;
        ArrayList r0 = new ArrayList();
        if (r4.isUltraHdrOn() == false) goto L12;
        List<SurfaceCombination> r1 = r0;
        if (r4.getCameraMode() != 0) goto L29;
        r0.addAll(this.mSurfaceCombinationsUltraHdr);
        r1 = r0;
    L29:
        this.mFeatureSettingsToSupportedCombinationsMap.put(r4, r1);
        return r1;
    L12:
        if (r4.getRequiredMaxBitDepth() != 8) goto L24;
        int r2 = r4.getCameraMode();
        if (r2 != 1) goto L16;
        r1 = this.mConcurrentSurfaceCombinations;
        goto L29
    L16:
        if (r2 != 2) goto L18;
        r0.addAll(this.mUltraHighSurfaceCombinations);
        r0.addAll(this.mSurfaceCombinations);
        r1 = r0;
        goto L29
    L18:
        if (r4.isPreviewStabilizationOn() == false) goto L20;
        List<SurfaceCombination> r3 = this.mPreviewStabilizationSurfaceCombinations;
    L21:
        r0.addAll(r3);
        r1 = r0;
        goto L29
    L20:
        r3 = this.mSurfaceCombinations;
        goto L21
    L24:
        r1 = r0;
        if (r4.getRequiredMaxBitDepth() != 10) goto L29;
        r1 = r0;
        if (r4.getCameraMode() != 0) goto L29;
        r0.addAll(this.mSurfaceCombinations10Bit);
        r1 = r0;
        goto L29
    L5:
        return this.mFeatureSettingsToSupportedCombinationsMap.get(r4);
    }

    private static List<Integer> getUseCasesPriorityOrder(List<UseCaseConfig<?>> r7) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<UseCaseConfig<?>> r2 = r7.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        int r3 = r2.next().getSurfaceOccupancyPriority(0);
        if (r1.contains(Integer.valueOf(r3)) == true) goto L4;
        r1.add(Integer.valueOf(r3));
        goto L4
    L8:
        Collections.sort(r1);
        Collections.reverse(r1);
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L17;
        int r5 = ((Integer) r4.next()).intValue();
        Iterator<UseCaseConfig<?>> r6 = r7.iterator();
    L13:
        if (r6.hasNext() == false) goto L10;
        UseCaseConfig<?> r8 = r6.next();
        if (r5 != r8.getSurfaceOccupancyPriority(0)) goto L13;
        r0.add(Integer.valueOf(r7.indexOf(r8)));
        goto L13
    L17:
        return r0;
    }

    public SurfaceSizeDefinition getUpdatedSurfaceSizeDefinitionByFormat(int r3) {
        if (this.mSurfaceSizeDefinitionFormats.contains(Integer.valueOf(r3)) == true) goto L6;
        updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS720pSizeMap(), SizeUtil.RESOLUTION_720P, r3);
        updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.getS1440pSizeMap(), SizeUtil.RESOLUTION_1440P, r3);
        updateMaximumSizeByFormat(this.mSurfaceSizeDefinition.getMaximumSizeMap(), r3);
        updateUltraMaximumSizeByFormat(this.mSurfaceSizeDefinition.getUltraMaximumSizeMap(), r3);
        this.mSurfaceSizeDefinitionFormats.add(Integer.valueOf(r3));
    L6:
        return this.mSurfaceSizeDefinition;
    }

    private Range<Integer> getClosestSupportedDeviceFrameRate(Range<Integer> r9, int r10) {
        if (r9 == null) goto L41;
        Range<Integer> r0 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
        if (r9.equals(r0) == true) goto L41;
        Range<Integer>[] r1 = (Range[]) this.mCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (r1 != null) goto L9;
        return r0;
    L9:
        Range<T> r2 = new Range(Integer.valueOf(Math.min(((Integer) r9.getLower()).intValue(), r10)), Integer.valueOf(Math.min(((Integer) r9.getUpper()).intValue(), r10)));
        int r11 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r3 >= r11) goto L51;
        Range<Integer> r5 = r1[r3];
        if (r10 < ((Integer) r5.getLower()).intValue()) goto L38;
        if (r0.equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED) == false) goto L17;
        r0 = r5;
    L17:
        if (r5.equals(r2) == true) goto L39;
        int r6 = getRangeLength(r5.intersect(r2));     // Catch: IllegalArgumentException -> L25
        if (r4 != 0) goto L22;
        r4 = r6;
    L37:
        r0 = r5;
        goto L38
    L22:
        if (r6 < r4) goto L24;
        r0 = compareIntersectingRanges(r2, r0, r5);     // Catch: IllegalArgumentException -> L25
        r4 = getRangeLength(r2.intersect(r0));     // Catch: IllegalArgumentException -> L25
    L24:
        r5 = r0;
    L26:
        if (r4 != 0) goto L38;
        if (getRangeDistance(r5, r2) < getRangeDistance(r0, r2)) goto L37;
        if (getRangeDistance(r5, r2) != getRangeDistance(r0, r2)) goto L38;
        if (((Integer) r5.getLower()).intValue() > ((Integer) r0.getUpper()).intValue()) goto L37;
        if (getRangeLength(r5) >= getRangeLength(r0)) goto L38;
    L39:
        return r5;
    L38:
        r3 = r3 + 1;
        goto L10
    L51:
        return r0;
    L41:
        return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }

    private static int getRangeDistance(Range<Integer> r2, Range<Integer> r3) {
        if (r2.contains((Integer) r3.getUpper()) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkState(r0, "Ranges must not intersect");
        if (((Integer) r2.getLower()).intValue() <= ((Integer) r3.getUpper()).intValue()) goto L13;
        return ((Integer) r2.getLower()).intValue() - ((Integer) r3.getUpper()).intValue();
    L13:
        return ((Integer) r3.getLower()).intValue() - ((Integer) r2.getUpper()).intValue();
    L5:
        if (r2.contains((Integer) r3.getLower()) == true) goto L7;
        r0 = true;
        goto L8
    }

    private Range<Integer> getUpdatedTargetFramerate(Range<Integer> r1, Range<Integer> r2) {
        if (r2 == null) goto L12;
        if (r1 == null) goto L8;
        return r2.intersect(r1);
    L8:
        return r2;
    L12:
        return r1;
    }

    private static boolean isUltraHdrOn(List<AttachedSurfaceInfo> r3, Map<UseCaseConfig<?>, List<Size>> r4) {
        Iterator<AttachedSurfaceInfo> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r5.next().getImageFormat() != 4101) goto L4;
        return true;
    L8:
        Iterator<UseCaseConfig<?>> r6 = r4.keySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        if (r6.next().getInputFormat() != 4101) goto L10;
        return true;
    L14:
        return false;
    }

    private void updateMaximumSizeByFormat(Map<Integer, Size> r3, int r4) {
        Size r0 = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), r4, true);
        if (r0 == null) goto L6;
        r3.put(Integer.valueOf(r4), r0);
        return;
    }

    private void updateUltraMaximumSizeByFormat(Map<Integer, Size> r4, int r5) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return;
    L5:
        if (this.mIsUltraHighResolutionSensorSupported == false) goto L13;
        StreamConfigurationMap r0 = (StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION);
        if (r0 != null) goto L10;
        return;
    L10:
        r4.put(Integer.valueOf(r5), getMaxOutputSizeByFormat(r0, r5, true));
        return;
    }

    public List<Size> applyResolutionSelectionOrderRelatedWorkarounds(List<Size> r6, int r7) {
        int r0 = this.mTargetAspectRatio.get(this.mCameraId, this.mCharacteristics);
        if (r0 != 0) goto L5;
        Rational r1 = AspectRatioUtil.ASPECT_RATIO_4_3;
    L12:
        if (r1 == null) goto L23;
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<Size> r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L21;
        Size r4 = r8.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r4, r1) == true) goto L19;
        r3.add(r4);
        goto L16
    L19:
        r2.add(r4);
        goto L16
    L21:
        r3.addAll(0, r2);
        r6 = r3;
    L23:
        return this.mResolutionCorrector.insertOrPrioritize(SurfaceConfig.getConfigType(r7), r6);
    L5:
        if (r0 != 1) goto L7;
        r1 = AspectRatioUtil.ASPECT_RATIO_16_9;
        goto L12
    L7:
        if (r0 == 2) goto L9;
        r1 = null;
        goto L12
    L9:
        Size r5 = getUpdatedSurfaceSizeDefinitionByFormat(256).getMaximumSize(256);
        r1 = new Rational(r5.getWidth(), r5.getHeight());
        goto L12
    }

    public boolean checkSupported(FeatureSettings r4, List<SurfaceConfig> r5) {
        Iterator<SurfaceCombination> r6 = getSurfaceCombinationsByFeatureSettings(r4).iterator();
        boolean r1 = false;
    L4:
        if (r6.hasNext() == false) goto L10;
        if (r6.next().getOrderedSupportedSurfaceConfigList(r5) == null) goto L8;
        r1 = true;
    L9:
        if (r1 == false) goto L4;
    L8:
        r1 = false;
    L10:
        return r1;
    }

    public List<SurfaceConfig> getOrderedSupportedStreamUseCaseSurfaceConfigList(FeatureSettings r3, List<SurfaceConfig> r4) {
        if (StreamUseCaseUtil.shouldUseStreamUseCase(r3) == true) goto L5;
        return null;
    L5:
        Iterator<SurfaceCombination> r5 = this.mSurfaceCombinationsStreamUseCase.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        List<SurfaceConfig> r1 = r5.next().getOrderedSupportedSurfaceConfigList(r4);
        if (r1 == null) goto L7;
        return r1;
    L11:
        return null;
    }

    private static Range<Integer> compareIntersectingRanges(Range<Integer> r10, Range<Integer> r11, Range<Integer> r12) {
        double r0 = getRangeLength(r11.intersect(r10));
        double r2 = getRangeLength(r12.intersect(r10));
        double r4 = r2 / ((double) getRangeLength(r12));
        double r6 = r0 / ((double) getRangeLength(r11));
        if (r2 > r0) goto L5;
        if (r2 != r0) goto L18;
        if (r4 <= r6) goto L13;
        return r12;
    L13:
        if (r4 == r6) goto L15;
    L22:
        return r11;
    L15:
        if (((Integer) r12.getLower()).intValue() <= ((Integer) r11.getLower()).intValue()) goto L22;
        return r12;
    L18:
        if (r6 >= 0.5d) goto L22;
        if (r4 <= r6) goto L22;
        return r12;
    L5:
        if (r4 < 0.5d) goto L7;
    L8:
        return r12;
    L7:
        if (r4 < r6) goto L22;
        goto L8
    }

    private Map<UseCaseConfig<?>, List<Size>> filterSupportedSizes(Map<UseCaseConfig<?>, List<Size>> r11, FeatureSettings r12, Range<Integer> r13) {
        HashMap r0 = new HashMap();
        Iterator<UseCaseConfig<?>> r1 = r11.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L19;
        UseCaseConfig<?> r2 = r1.next();
        ArrayList r3 = new ArrayList();
        HashMap r4 = new HashMap();
        Iterator<Size> r5 = r11.get(r2).iterator();
    L7:
        if (r5.hasNext() == false) goto L18;
        Size r6 = r5.next();
        int r7 = r2.getInputFormat();
        SurfaceConfig.ConfigSize r8 = SurfaceConfig.transformSurfaceConfig(r12.getCameraMode(), r7, r6, getUpdatedSurfaceSizeDefinitionByFormat(r7)).getConfigSize();
        if (r13 == null) goto L11;
        int r9 = getMaxFrameRate(this.mCharacteristics, r7, r6);
    L12:
        Set r10 = (Set) r4.get(r8);
        if (r10 != null) goto L16;
        r10 = new HashSet();
        r4.put(r8, r10);
    L16:
        if (r10.contains(Integer.valueOf(r9)) == true) goto L7;
        r3.add(r6);
        r10.add(Integer.valueOf(r9));
        goto L7
    L11:
        r9 = Integer.MAX_VALUE;
        goto L12
    L18:
        r0.put(r2, r3);
        goto L4
    L19:
        return r0;
    }

    public static int getMaxFrameRate(CameraCharacteristicsCompat r2, int r3, Size r4) {
        return (int) (1.0E9d / ((StreamConfigurationMap) r2.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(r3, r4));
    L4:
        return 0;
    }

    private Size getMaxOutputSizeByFormat(StreamConfigurationMap r6, int r7, boolean r8) {
        if (r7 != 34) goto L5;
        Size[] r0 = r6.getOutputSizes(SurfaceTexture.class);
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.length == 0) goto L22;
        CompareSizesByArea r1 = new CompareSizesByArea();
        Size r2 = (Size) Collections.max(Arrays.asList(r0), r1);
        Size r3 = SizeUtil.RESOLUTION_ZERO;
        if (Build.VERSION.SDK_INT < 23) goto L19;
        if (r8 == false) goto L19;
        Size[] r9 = Api23Impl.getHighResolutionOutputSizes(r6, r7);
        if (r9 == null) goto L19;
        if (r9.length <= 0) goto L19;
        r3 = (Size) Collections.max(Arrays.asList(r9), r1);
    L19:
        return (Size) Collections.max(Arrays.asList(new Size[]{r2, r3}), r1);
    L22:
        return null;
    L5:
        r0 = r6.getOutputSizes(r7);
        goto L6
    }

    private Range<Integer> getTargetFpsRange(List<AttachedSurfaceInfo> r4, List<UseCaseConfig<?>> r5, List<Integer> r6) {
        Iterator<AttachedSurfaceInfo> r7 = r4.iterator();
        Range<Integer> r1 = null;
    L4:
        if (r7.hasNext() == false) goto L6;
        r1 = getUpdatedTargetFramerate(r7.next().getTargetFrameRate(), r1);
        goto L4
    L6:
        Iterator<Integer> r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r1 = getUpdatedTargetFramerate(((UseCaseConfig) ListProtector.get(r5, r8.next().intValue())).getTargetFrameRate(null), r1);
        goto L8
    L10:
        return r1;
    }

    private int getUpdatedMaximumFps(int r2, int r3, Size r4) {
        return Math.min(r2, getMaxFrameRate(this.mCharacteristics, r3, r4));
    }

    private boolean isUseCasesCombinationSupported(FeatureSettings r8, List<AttachedSurfaceInfo> r9, Map<UseCaseConfig<?>, List<Size>> r10) {
        ArrayList r0 = new ArrayList();
        Iterator<AttachedSurfaceInfo> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r0.add(r11.next().getSurfaceConfig());
        goto L4
    L6:
        CompareSizesByArea r12 = new CompareSizesByArea();
        Iterator<UseCaseConfig<?>> r1 = r10.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        UseCaseConfig<?> r2 = r1.next();
        List<Size> r3 = r10.get(r2);
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        Preconditions.checkArgument(r4, "No available output size is found for " + r2 + ".");
        Size r5 = (Size) Collections.min(r3, r12);
        int r6 = r2.getInputFormat();
        r0.add(SurfaceConfig.transformSurfaceConfig(r8.getCameraMode(), r6, r5, getUpdatedSurfaceSizeDefinitionByFormat(r6)));
        goto L8
    L12:
        if (r3.isEmpty() == true) goto L14;
        r4 = true;
        goto L15
    L17:
        return checkSupported(r8, r0);
    }

    private void updateS720pOrS1440pSizeByFormat(Map<Integer, Size> r4, Size r5, int r6) {
        if (this.mIsConcurrentCameraModeSupported == true) goto L5;
        return;
    L5:
        Size r0 = getMaxOutputSizeByFormat(this.mCharacteristics.getStreamConfigurationMapCompat().toStreamConfigurationMap(), r6, false);
        Integer r7 = Integer.valueOf(r6);
        if (r0 == null) goto L9;
        r5 = (Size) Collections.min(Arrays.asList(new Size[]{r5, r0}), new CompareSizesByArea());
    L9:
        r4.put(r7, r5);
    }

    public SurfaceConfig transformSurfaceConfig(int r2, int r3, Size r4) {
        return SurfaceConfig.transformSurfaceConfig(r2, r3, r4, getUpdatedSurfaceSizeDefinitionByFormat(r3));
    }

    public SupportedSurfaceCombination(Context r5, String r6, CameraManagerCompat r7, CamcorderProfileHelper r8) throws CameraUnavailableException {
        this.mSurfaceCombinations = new ArrayList();
        this.mUltraHighSurfaceCombinations = new ArrayList();
        this.mConcurrentSurfaceCombinations = new ArrayList();
        this.mPreviewStabilizationSurfaceCombinations = new ArrayList();
        this.mFeatureSettingsToSupportedCombinationsMap = new HashMap();
        this.mSurfaceCombinations10Bit = new ArrayList();
        this.mSurfaceCombinationsUltraHdr = new ArrayList();
        this.mSurfaceCombinationsStreamUseCase = new ArrayList();
        int r0 = 0;
        this.mIsRawSupported = false;
        this.mIsBurstCaptureSupported = false;
        this.mIsConcurrentCameraModeSupported = false;
        this.mIsStreamUseCaseSupported = false;
        this.mIsUltraHighResolutionSensorSupported = false;
        this.mIsPreviewStabilizationSupported = false;
        this.mSurfaceSizeDefinitionFormats = new ArrayList();
        this.mTargetAspectRatio = new TargetAspectRatio();
        this.mResolutionCorrector = new ResolutionCorrector();
        String r9 = (String) Preconditions.checkNotNull(r6);
        this.mCameraId = r9;
        this.mCamcorderProfileHelper = (CamcorderProfileHelper) Preconditions.checkNotNull(r8);
        this.mExtraSupportedSurfaceCombinationsContainer = new ExtraSupportedSurfaceCombinationsContainer();
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(r5);
        CameraCharacteristicsCompat r10 = r7.getCameraCharacteristicsCompat(r9);     // Catch: CameraAccessExceptionCompat -> L44
        this.mCharacteristics = r10;     // Catch: CameraAccessExceptionCompat -> L44
        Integer r11 = (Integer) r10.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);     // Catch: CameraAccessExceptionCompat -> L44
        if (r11 == null) goto L6;
        int r12 = r11.intValue();     // Catch: CameraAccessExceptionCompat -> L44
    L7:
        this.mHardwareLevel = r12;     // Catch: CameraAccessExceptionCompat -> L44
        int[] r13 = (int[]) r10.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (r13 == null) goto L24;
        int r14 = r13.length;
    L11:
        if (r0 >= r14) goto L24;
        int r15 = r13[r0];
        if (r15 != 3) goto L16;
        this.mIsRawSupported = true;
    L23:
        r0 = r0 + 1;
        goto L11
    L16:
        if (r15 != 6) goto L19;
        this.mIsBurstCaptureSupported = true;
        goto L23
    L19:
        if (Build.VERSION.SDK_INT < 31) goto L23;
        if (r15 != 16) goto L23;
        this.mIsUltraHighResolutionSensorSupported = true;
    L24:
        DynamicRangeResolver r16 = new DynamicRangeResolver(this.mCharacteristics);
        this.mDynamicRangeResolver = r16;
        generateSupportedCombinationList();
        if (this.mIsUltraHighResolutionSensorSupported == false) goto L27;
        generateUltraHighSupportedCombinationList();
    L27:
        boolean r17 = r5.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
        this.mIsConcurrentCameraModeSupported = r17;
        if (r17 == false) goto L31;
        generateConcurrentSupportedCombinationList();
    L31:
        if (r16.is10BitDynamicRangeSupported() == false) goto L34;
        generate10BitSupportedCombinationList();
    L34:
        if (isUltraHdrSupported() == false) goto L36;
        generateUltraHdrSupportedCombinationList();
    L36:
        boolean r18 = StreamUseCaseUtil.isStreamUseCaseSupported(this.mCharacteristics);
        this.mIsStreamUseCaseSupported = r18;
        if (r18 == false) goto L39;
        generateStreamUseCaseSupportedCombinationList();
    L39:
        boolean r19 = VideoStabilizationUtil.isPreviewStabilizationSupported(this.mCharacteristics);
        this.mIsPreviewStabilizationSupported = r19;
        if (r19 == false) goto L42;
        generatePreviewStabilizationSupportedCombinationList();
    L42:
        generateSurfaceSizeDefinition();
        checkCustomization();
        return;
    L6:
        r12 = 2;
    L44:
        e = move-exception;
        throw CameraUnavailableExceptionHelper.createFrom(e);
    }

    private FeatureSettings createFeatureSettings(int r5, Map<UseCaseConfig<?>, DynamicRange> r6, boolean r7, boolean r8) {
        int r9 = getRequiredMaxBitDepth(r6);
        if (r5 == 0) goto L8;
        if (r8 == false) goto L8;
        throw new IllegalArgumentException(String.format("Camera device id is %s. Ultra HDR is not currently supported in %s camera mode.", new Object[]{this.mCameraId, CameraMode.toLabelString(r5)}));
    L8:
        if (r5 == 0) goto L15;
        if (r9 != 10) goto L15;
        throw new IllegalArgumentException(String.format("Camera device id is %s. 10 bit dynamic range is not currently supported in %s camera mode.", new Object[]{this.mCameraId, CameraMode.toLabelString(r5)}));
    L15:
        return FeatureSettings.of(r5, r9, r7, r8);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecifications(int r36, List<AttachedSurfaceInfo> r37, Map<UseCaseConfig<?>, List<Size>> r38, boolean r39, boolean r40) {
        refreshPreviewSize();
        ArrayList r11 = new ArrayList(r38.keySet());
        List<Integer> r12 = getUseCasesPriorityOrder(r11);
        Map<UseCaseConfig<?>, DynamicRange> r13 = this.mDynamicRangeResolver.resolveAndValidateDynamicRanges(r37, r11, r12);
        FeatureSettings r15 = createFeatureSettings(r36, r13, r39, isUltraHdrOn(r37, r38));
        boolean r16 = isUseCasesCombinationSupported(r15, r37, r38);
        String r8 = ".  May be attempting to bind too many use cases. Existing surfaces: ";
        String r7 = " New configs: ";
        String r6 = "No supported surface combination is found for camera device - Id : ";
        if (r16 == false) goto L106;
        Range<Integer> r5 = getTargetFpsRange(r37, r11, r12);
        Map<UseCaseConfig<?>, List<Size>> r0 = filterSupportedSizes(r38, r15, r5);
        ArrayList r1 = new ArrayList();
        Iterator<Integer> r2 = r12.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        UseCaseConfig r3 = (UseCaseConfig) ListProtector.get(r11, r2.next().intValue());
        r1.add(applyResolutionSelectionOrderRelatedWorkarounds(r0.get(r3), r3.getInputFormat()));
        goto L6
    L8:
        List<List<Size>> r17 = getAllPossibleSizeArrangements(r1);
        HashMap r4 = new HashMap();
        HashMap r9 = new HashMap();
        HashMap r10 = new HashMap();
        HashMap r14 = new HashMap();
        boolean r18 = StreamUseCaseUtil.containsZslUseCase(r37, r11);
        int r19 = getMaxSupportedFpsFromAttachedSurfaces(r37);
        HashMap r310 = r14;
        Range<Integer> r110 = null;
        if (this.mIsStreamUseCaseSupported == false) goto L32;
        if (r18 == true) goto L32;
        Iterator<List<Size>> r111 = r17.iterator();
        List<SurfaceConfig> r20 = null;
    L13:
        if (r111.hasNext() == false) goto L25;
        HashMap r311 = r310;
        HashMap r312 = r10;
        HashMap r21 = r9;
        HashMap r22 = r4;
        Map<UseCaseConfig<?>, DynamicRange> r23 = r13;
        Range<Integer> r112 = r5;
        List<Integer> r24 = r12;
        Range<Integer> r25 = r112;
        String r113 = r6;
        int r26 = r19;
        int r27 = r19;
        String r114 = r7;
        List<Integer> r28 = r12;
        String r115 = r8;
        r20 = getOrderedSupportedStreamUseCaseSurfaceConfigList(r15, (List) getSurfaceConfigListAndFpsCeiling(r36, r37, r111.next(), r11, r24, r26, r312, r311).first);
        HashMap r29 = r312;
        HashMap r30 = r311;
        if (r20 != null) goto L17;
    L19:
        if (r20 == null) goto L24;
        if (StreamUseCaseUtil.areStreamUseCasesAvailableForSurfaceConfigs(this.mCharacteristics, r20) == true) goto L26;
        r20 = null;
    L26:
        if (r20 != null) goto L31;
        if (r16 == true) goto L31;
        throw new IllegalArgumentException(r113 + this.mCameraId + r115 + r37 + r114 + r11);
    L31:
        List<SurfaceConfig> r116 = r20;
    L33:
        Iterator<List<Size>> r117 = r17.iterator();
        boolean r118 = false;
        List<Size> r210 = null;
        List<Size> r211 = null;
        int r31 = Integer.MAX_VALUE;
        int r32 = Integer.MAX_VALUE;
        boolean r119 = false;
        boolean r212 = false;
    L35:
        if (r117.hasNext() == false) goto L73;
        List<Size> r33 = r117.next();
        int r34 = r31;
        int r35 = r32;
        String r313 = r114;
        HashMap r120 = r30;
        String r314 = r113;
        HashMap r121 = r29;
        Pair<List<SurfaceConfig>, Integer> r41 = getSurfaceConfigListAndFpsCeiling(r36, r37, r33, r11, r28, r27, null, null);
        List<SurfaceConfig> r42 = (List) r41.first;
        r32 = ((Integer) r41.second).intValue();
        int r43 = r27;
        if (r25 == null) goto L42;
        if (r43 <= r32) goto L42;
        if (r32 >= ((Integer) r25.getLower()).intValue()) goto L42;
        boolean r44 = false;
    L43:
        if (r119 == false) goto L45;
    L55:
        int r45 = r35;
        int r46 = Integer.MAX_VALUE;
    L56:
        if (r116 == null) goto L71;
        if (r212 == true) goto L71;
        if (getOrderedSupportedStreamUseCaseSurfaceConfigList(r15, r42) == null) goto L71;
        if (r34 == r46) goto L64;
        if (r34 < r32) goto L64;
        r31 = r34;
    L66:
        if (r44 == false) goto L72;
        r31 = r32;
        if (r119 == true) goto L69;
        r211 = r33;
        r212 = true;
        goto L72
    L69:
        r32 = r45;
        List<Size> r47 = r210;
        List<Size> r48 = r33;
    L74:
        if (r47 == null) goto L104;
        if (r25 == null) goto L77;
        r110 = getClosestSupportedDeviceFrameRate(r25, r32);
    L77:
        Range<Integer> r49 = r110;
        Iterator r50 = r11.iterator();
    L79:
        if (r50.hasNext() == false) goto L84;
        UseCaseConfig r51 = (UseCaseConfig) r50.next();
        List<Integer> r52 = r28;
        Map<UseCaseConfig<?>, DynamicRange> r122 = r23;
        Iterator r315 = r50;
        StreamSpec.Builder r53 = StreamSpec.builder((Size) ListProtector.get(r47, r52.indexOf(Integer.valueOf(r11.indexOf(r51))))).setDynamicRange((DynamicRange) Preconditions.checkNotNull(r122.get(r51))).setImplementationOptions(StreamUseCaseUtil.getStreamSpecImplementationOptions(r51)).setZslDisabled(r40);
        if (r49 == null) goto L83;
        r53.setExpectedFrameRateRange(r49);
    L83:
        Range<Integer> r316 = r49;
        r21.put(r51, r53.build());
        r50 = r315;
        r28 = r52;
        r23 = r122;
        r49 = r316;
        goto L79
    L84:
        HashMap r54 = r21;
        if (r116 == null) goto L100;
        if (r32 != r31) goto L100;
        if (r47.size() != r48.size()) goto L100;
        int r55 = 0;
    L91:
        if (r55 >= r47.size()) goto L96;
        if (((Size) ListProtector.get(r47, r55)).equals(ListProtector.get(r48, r55)) == false) goto L94;
        r55 = r55 + 1;
        goto L91
    L94:
        r118 = true;
    L96:
        if (r118 == true) goto L100;
        HashMap r56 = r22;
        if (StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithInteropOverride(this.mCharacteristics, r37, r54, r56) == true) goto L102;
        StreamUseCaseUtil.populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(r54, r56, r121, r120, r116);
    L102:
        return new Pair(r54, r56);
    L100:
        r56 = r22;
        goto L102
    L104:
        throw new IllegalArgumentException(r314 + this.mCameraId + " and Hardware level: " + this.mHardwareLevel + ". May be the specified resolution is too large and not supported. Existing surfaces: " + r37 + r313 + r11);
    L72:
        r27 = r43;
        r32 = r45;
        r29 = r121;
        r30 = r120;
        r113 = r314;
        r114 = r313;
    L64:
        r31 = r32;
        r211 = r33;
    L71:
        r31 = r34;
        goto L72
    L45:
        if (checkSupported(r15, r42) == false) goto L55;
        r45 = r35;
        r46 = Integer.MAX_VALUE;
        if (r45 == Integer.MAX_VALUE) goto L50;
        if (r45 < r32) goto L50;
    L51:
        if (r44 == false) goto L56;
        if (r212 == true) goto L53;
        r45 = r32;
        r210 = r33;
        r119 = true;
        goto L56
    L53:
        r48 = r211;
        r47 = r33;
        r31 = r34;
    L50:
        r45 = r32;
        r210 = r33;
    L42:
        r44 = true;
        goto L43
    L73:
        r314 = r113;
        r313 = r114;
        r120 = r30;
        r121 = r29;
        r47 = r210;
        r48 = r211;
    L24:
        r29.clear();
        r30.clear();
        r310 = r30;
        r10 = r29;
        r8 = r115;
        r6 = r113;
        r7 = r114;
        r13 = r23;
        r9 = r21;
        r4 = r22;
        r5 = r25;
        r19 = r27;
        r12 = r28;
        goto L13
    L17:
        if (StreamUseCaseUtil.areCaptureTypesEligible(r29, r30, r20) == true) goto L19;
        r20 = null;
        goto L19
    L25:
        r21 = r9;
        r22 = r4;
        r25 = r5;
        r28 = r12;
        r23 = r13;
        r27 = r19;
        r113 = r6;
        r114 = r7;
        r115 = r8;
        r30 = r310;
        r29 = r10;
    L32:
        r29 = r10;
        r21 = r9;
        r22 = r4;
        r25 = r5;
        r28 = r12;
        r23 = r13;
        r27 = r19;
        r113 = "No supported surface combination is found for camera device - Id : ";
        r114 = " New configs: ";
        r30 = r310;
        r116 = null;
        goto L33
    L106:
        throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.mCameraId + ".  May be attempting to bind too many use cases. Existing surfaces: " + r37 + " New configs: " + r11);
    }

    private Pair<List<SurfaceConfig>, Integer> getSurfaceConfigListAndFpsCeiling(int r5, List<AttachedSurfaceInfo> r6, List<Size> r7, List<UseCaseConfig<?>> r8, List<Integer> r9, int r10, Map<Integer, AttachedSurfaceInfo> r11, Map<Integer, UseCaseConfig<?>> r12) {
        ArrayList r0 = new ArrayList();
        Iterator<AttachedSurfaceInfo> r13 = r6.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        AttachedSurfaceInfo r1 = r13.next();
        r0.add(r1.getSurfaceConfig());
        if (r11 == null) goto L4;
        r11.put(Integer.valueOf(r0.size() - 1), r1);
        goto L4
    L8:
        int r14 = 0;
    L10:
        if (r14 >= r7.size()) goto L16;
        Size r15 = (Size) ListProtector.get(r7, r14);
        UseCaseConfig<?> r2 = (UseCaseConfig) ListProtector.get(r8, ((Integer) ListProtector.get(r9, r14)).intValue());
        int r3 = r2.getInputFormat();
        r0.add(SurfaceConfig.transformSurfaceConfig(r5, r3, r15, getUpdatedSurfaceSizeDefinitionByFormat(r3)));
        if (r12 == null) goto L14;
        r12.put(Integer.valueOf(r0.size() - 1), r2);
    L14:
        r10 = getUpdatedMaximumFps(r10, r2.getInputFormat(), r15);
        r14 = r14 + 1;
        goto L10
    L16:
        return new Pair(r0, Integer.valueOf(r10));
    }
}
