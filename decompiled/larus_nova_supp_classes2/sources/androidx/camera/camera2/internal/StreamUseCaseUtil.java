package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class StreamUseCaseUtil {
    public static final Config.Option<Long> STREAM_USE_CASE_STREAM_SPEC_OPTION = null;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP = null;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP = null;
    private static final String TAG = "StreamUseCaseUtil";

    static {
        STREAM_USE_CASE_STREAM_SPEC_OPTION = Config.Option.create("camera2.streamSpec.streamUseCase", Long.TYPE);
        HashMap r0 = new HashMap();
        STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP = r0;
        HashMap r1 = new HashMap();
        STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP = r1;
        if (Build.VERSION.SDK_INT < 33) goto L6;
        HashSet r2 = new HashSet();
        UseCaseConfigFactory.CaptureType r3 = UseCaseConfigFactory.CaptureType.PREVIEW;
        r2.add(r3);
        UseCaseConfigFactory.CaptureType r4 = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        r2.add(r4);
        r0.put(4L, r2);
        HashSet r5 = new HashSet();
        r5.add(r3);
        r5.add(r4);
        r5.add(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
        r0.put(1L, r5);
        HashSet r6 = new HashSet();
        UseCaseConfigFactory.CaptureType r7 = UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE;
        r6.add(r7);
        r0.put(2L, r6);
        HashSet r8 = new HashSet();
        UseCaseConfigFactory.CaptureType r9 = UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
        r8.add(r9);
        r0.put(3L, r8);
        HashSet r10 = new HashSet();
        r10.add(r3);
        r10.add(r7);
        r10.add(r9);
        r1.put(4L, r10);
        HashSet r11 = new HashSet();
        r11.add(r3);
        r11.add(r9);
        r1.put(3L, r11);
        return;
    }

    private static void throwInvalidCamera2InteropOverrideException() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }

    private StreamUseCaseUtil() {
    }

    public static Camera2ImplConfig getStreamSpecImplementationOptions(UseCaseConfig<?> r3) {
        MutableOptionsBundle r0 = MutableOptionsBundle.create();
        Config.Option<?> r1 = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
        if (r3.containsOption(r1) == false) goto L5;
        r0.insertOption(r1, (Long) r3.retrieveOption(r1));
    L5:
        Config.Option<?> r2 = UseCaseConfig.OPTION_ZSL_DISABLED;
        if (r3.containsOption(r2) == false) goto L8;
        r0.insertOption(r2, (Boolean) r3.retrieveOption(r2));
    L8:
        Config.Option<?> r4 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (r3.containsOption(r4) == false) goto L11;
        r0.insertOption(r4, (Integer) r3.retrieveOption(r4));
    L11:
        Config.Option<?> r5 = ImageInputConfig.OPTION_INPUT_FORMAT;
        if (r3.containsOption(r5) == false) goto L15;
        r0.insertOption(r5, (Integer) r3.retrieveOption(r5));
    L15:
        return new Camera2ImplConfig(r0);
    }

    public static boolean isStreamUseCaseSupported(CameraCharacteristicsCompat r3) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        long[] r4 = (long[]) r3.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (r4 != null) goto L8;
    L12:
        return false;
    L8:
        if (r4.length == 0) goto L12;
        return true;
    }

    public static boolean shouldUseStreamUseCase(SupportedSurfaceCombination.FeatureSettings r1) {
        if (r1.getCameraMode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.getRequiredMaxBitDepth() != 8) goto L7;
        return true;
    }

    private static boolean areStreamUseCasesAvailable(Set<Long> r1, Set<Long> r2) {
        Iterator<Long> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (r1.contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static boolean areStreamUseCasesAvailableForSurfaceConfigs(CameraCharacteristicsCompat r6, List<SurfaceConfig> r7) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        long[] r8 = (long[]) r6.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (r8 != null) goto L8;
    L21:
        return false;
    L8:
        if (r8.length == 0) goto L21;
        HashSet r0 = new HashSet();
        int r1 = r8.length;
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L13;
        r0.add(Long.valueOf(r8[r3]));
        r3 = r3 + 1;
        goto L11
    L13:
        Iterator<SurfaceConfig> r9 = r7.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        if (r0.contains(Long.valueOf(r9.next().getStreamUseCase())) == true) goto L15;
        return false;
    L19:
        return true;
    }

    public static boolean containsZslUseCase(List<AttachedSurfaceInfo> r4, List<UseCaseConfig<?>> r5) {
        Iterator<AttachedSurfaceInfo> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        AttachedSurfaceInfo r0 = r6.next();
        UseCaseConfigFactory.CaptureType r2 = (UseCaseConfigFactory.CaptureType) ListProtector.get(r0.getCaptureTypes(), 0);
        if (isZslUseCase(r0.getImplementationOptions(), r2) == false) goto L4;
        return true;
    L8:
        Iterator<UseCaseConfig<?>> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        UseCaseConfig<?> r8 = r7.next();
        if (isZslUseCase(r8, r8.getCaptureType()) == false) goto L10;
        return true;
    L14:
        return false;
    }

    private static Config getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(Config r4, long r5) {
        Config.Option<Long> r0 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (r4.containsOption(r0) == true) goto L5;
    L8:
        MutableOptionsBundle r6 = MutableOptionsBundle.from(r4);
        r6.insertOption(r0, Long.valueOf(r5));
        return new Camera2ImplConfig(r6);
    L5:
        if (((Long) r4.retrieveOption(r0)).longValue() != r5) goto L8;
        return null;
    }

    private static boolean isZslUseCase(Config r3, UseCaseConfigFactory.CaptureType r4) {
        if (((Boolean) r3.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.FALSE)).booleanValue() == false) goto L5;
        return false;
    L5:
        Config.Option<Integer> r0 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (r3.containsOption(r0) == true) goto L9;
        return false;
    L9:
        if (TemplateTypeUtil.getSessionConfigTemplateType(r4, ((Integer) r3.retrieveOption(r0)).intValue()) != 5) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean areCaptureTypesEligible(Map<Integer, AttachedSurfaceInfo> r8, Map<Integer, UseCaseConfig<?>> r9, List<SurfaceConfig> r10) {
        int r1 = 0;
    L4:
        if (r1 >= r10.size()) goto L26;
        long r4 = ((SurfaceConfig) ListProtector.get(r10, r1)).getStreamUseCase();
        if (r8.containsKey(Integer.valueOf(r1)) == false) goto L15;
        AttachedSurfaceInfo r2 = r8.get(Integer.valueOf(r1));
        if (r2.getCaptureTypes().size() != 1) goto L10;
        UseCaseConfigFactory.CaptureType r3 = (UseCaseConfigFactory.CaptureType) ListProtector.get(r2.getCaptureTypes(), 0);
    L12:
        if (isEligibleCaptureType(r3, r4, r2.getCaptureTypes()) == true) goto L23;
        return false;
    L23:
        r1 = r1 + 1;
        goto L4
    L10:
        r3 = UseCaseConfigFactory.CaptureType.STREAM_SHARING;
        goto L12
    L15:
        if (r9.containsKey(Integer.valueOf(r1)) == false) goto L25;
        UseCaseConfig<?> r5 = r9.get(Integer.valueOf(r1));
        UseCaseConfigFactory.CaptureType r6 = r5.getCaptureType();
        if (r5.getCaptureType() != UseCaseConfigFactory.CaptureType.STREAM_SHARING) goto L19;
        List<UseCaseConfigFactory.CaptureType> r7 = ((StreamSharingConfig) r5).getCaptureTypes();
    L21:
        if (isEligibleCaptureType(r6, r4, r7) == true) goto L23;
        return false;
    L19:
        r7 = Collections.emptyList();
        goto L21
    L25:
        throw new AssertionError("SurfaceConfig does not map to any use case");
    L26:
        return true;
    }

    private static boolean isEligibleCaptureType(UseCaseConfigFactory.CaptureType r3, long r4, List<UseCaseConfigFactory.CaptureType> r6) {
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        return false;
    L6:
        if (r3 != UseCaseConfigFactory.CaptureType.STREAM_SHARING) goto L20;
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> r5 = STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
        if (r5.containsKey(Long.valueOf(r4)) == true) goto L10;
        return false;
    L10:
        Set<UseCaseConfigFactory.CaptureType> r7 = r5.get(Long.valueOf(r4));
        if (r6.size() == r7.size()) goto L13;
        return false;
    L13:
        Iterator<UseCaseConfigFactory.CaptureType> r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        if (r7.contains(r8.next()) == true) goto L15;
        return false;
    L19:
        return true;
    L20:
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> r9 = STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
        if (r9.containsKey(Long.valueOf(r4)) == true) goto L23;
        return false;
    L23:
        if (r9.get(Long.valueOf(r4)).contains(r3) == false) goto L30;
        return true;
    L30:
        return false;
    }

    private static boolean isValidCamera2InteropOverride(List<AttachedSurfaceInfo> r9, List<UseCaseConfig<?>> r10, Set<Long> r11) {
        HashSet r0 = new HashSet();
        Iterator<AttachedSurfaceInfo> r12 = r9.iterator();
        if (r12.hasNext() == false) goto L11;
        AttachedSurfaceInfo r13 = r12.next();
        Config r1 = r13.getImplementationOptions();
        Config.Option<Long> r6 = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
        if (r1.containsOption(r6) == true) goto L8;
    L6:
        boolean r14 = false;
        boolean r2 = true;
    L13:
        Iterator<UseCaseConfig<?>> r15 = r10.iterator();
    L15:
        if (r15.hasNext() == false) goto L28;
        UseCaseConfig<?> r7 = r15.next();
        Config.Option<?> r8 = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
        if (r7.containsOption(r8) == false) goto L18;
        long r16 = ((Long) r7.retrieveOption(r8)).longValue();
        if (r16 == 0) goto L23;
        if (r2 == false) goto L27;
        throwInvalidCamera2InteropOverrideException();
    L27:
        r0.add(Long.valueOf(r16));
        r14 = true;
        goto L15
    L23:
        if (r14 == true) goto L24;
    L20:
        r2 = true;
        goto L15
    L24:
        throwInvalidCamera2InteropOverrideException();
        goto L20
    L18:
        if (r14 == false) goto L20;
        throwInvalidCamera2InteropOverrideException();
        goto L20
    L28:
        if (r2 == false) goto L30;
    L32:
        return false;
    L30:
        if (areStreamUseCasesAvailable(r11, r0) == false) goto L32;
        return true;
    L8:
        if (((Long) r13.getImplementationOptions().retrieveOption(r6)).longValue() == 0) goto L6;
        r14 = true;
    L12:
        r2 = false;
        goto L13
    L11:
        r14 = false;
        goto L12
    }

    public static void populateSurfaceToStreamUseCaseMapping(Collection<SessionConfig> r6, Collection<UseCaseConfig<?>> r7, Map<DeferrableSurface, Long> r8) {
        ArrayList r0 = new ArrayList(r7);
        Iterator<SessionConfig> r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L14;
        SessionConfig r1 = r9.next();
        Config r4 = r1.getImplementationOptions();
        Config.Option<Long> r5 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (r4.containsOption(r5) == false) goto L12;
        if (r1.getSurfaces().size() == 1) goto L12;
        Logger.e(TAG, String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", new Object[]{Integer.valueOf(r1.getSurfaces().size())}));
        return;
    L12:
        if (r1.getImplementationOptions().containsOption(r5) == false) goto L4;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L28;
        Iterator<SessionConfig> r11 = r6.iterator();
        int r12 = 0;
    L18:
        if (r11.hasNext() == false) goto L38;
        SessionConfig r2 = r11.next();
        if (((UseCaseConfig) ListProtector.get(r0, r12)).getCaptureType() != UseCaseConfigFactory.CaptureType.METERING_REPEATING) goto L22;
        Preconditions.checkState(!r2.getSurfaces().isEmpty(), "MeteringRepeating should contain a surface");
        r8.put((DeferrableSurface) ListProtector.get(r2.getSurfaces(), 0), 1L);
    L27:
        r12 = r12 + 1;
        goto L18
    L22:
        Config r13 = r2.getImplementationOptions();
        Config.Option<Long> r14 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (r13.containsOption(r14) == false) goto L27;
        if (r2.getSurfaces().isEmpty() == true) goto L27;
        r8.put((DeferrableSurface) ListProtector.get(r2.getSurfaces(), 0), (Long) r2.getImplementationOptions().retrieveOption(r14));
        goto L27
    L38:
        return;
    L28:
        return;
    L14:
        r10 = false;
        goto L15
    }

    public static boolean populateStreamUseCaseStreamSpecOptionWithInteropOverride(CameraCharacteristicsCompat r7, List<AttachedSurfaceInfo> r8, Map<UseCaseConfig<?>, StreamSpec> r9, Map<AttachedSurfaceInfo, StreamSpec> r10) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        ArrayList r0 = new ArrayList(r9.keySet());
        Iterator<AttachedSurfaceInfo> r1 = r8.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Preconditions.checkNotNull(r1.next().getImplementationOptions());
        goto L7
    L9:
        Iterator r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Preconditions.checkNotNull(((StreamSpec) Preconditions.checkNotNull(r9.get((UseCaseConfig) r2.next()))).getImplementationOptions());
        goto L11
    L13:
        long[] r11 = (long[]) r7.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (r11 != null) goto L16;
    L37:
        return false;
    L16:
        if (r11.length == 0) goto L37;
        HashSet r3 = new HashSet();
        int r4 = r11.length;
        int r5 = 0;
    L19:
        if (r5 >= r4) goto L22;
        r3.add(Long.valueOf(r11[r5]));
        r5 = r5 + 1;
        goto L19
    L22:
        if (isValidCamera2InteropOverride(r8, r0, r3) == false) goto L37;
        Iterator<AttachedSurfaceInfo> r12 = r8.iterator();
    L25:
        if (r12.hasNext() == false) goto L29;
        AttachedSurfaceInfo r13 = r12.next();
        Config r6 = r13.getImplementationOptions();
        Config r14 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(r6, ((Long) r6.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
        if (r14 == null) goto L25;
        r10.put(r13, r13.toStreamSpec(r14));
        goto L25
    L29:
        Iterator r15 = r0.iterator();
    L31:
        if (r15.hasNext() == false) goto L35;
        UseCaseConfig<?> r16 = (UseCaseConfig) r15.next();
        StreamSpec r17 = r9.get(r16);
        Config r18 = r17.getImplementationOptions();
        Config r19 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(r18, ((Long) r18.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
        if (r19 == null) goto L31;
        r9.put(r16, r17.toBuilder().setImplementationOptions(r19).build());
        goto L31
    L35:
        return true;
    }

    public static void populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(Map<UseCaseConfig<?>, StreamSpec> r6, Map<AttachedSurfaceInfo, StreamSpec> r7, Map<Integer, AttachedSurfaceInfo> r8, Map<Integer, UseCaseConfig<?>> r9, List<SurfaceConfig> r10) {
        int r0 = 0;
    L4:
        if (r0 >= r10.size()) goto L18;
        long r1 = ((SurfaceConfig) ListProtector.get(r10, r0)).getStreamUseCase();
        if (r8.containsKey(Integer.valueOf(r0)) == false) goto L11;
        AttachedSurfaceInfo r3 = r8.get(Integer.valueOf(r0));
        Config r2 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(r3.getImplementationOptions(), r1);
        if (r2 == null) goto L15;
        r7.put(r3, r3.toStreamSpec(r2));
    L15:
        r0 = r0 + 1;
        goto L4
    L11:
        if (r9.containsKey(Integer.valueOf(r0)) == false) goto L17;
        UseCaseConfig<?> r4 = r9.get(Integer.valueOf(r0));
        StreamSpec r5 = r6.get(r4);
        Config r11 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(r5.getImplementationOptions(), r1);
        if (r11 == null) goto L15;
        r6.put(r4, r5.toBuilder().setImplementationOptions(r11).build());
        goto L15
    L17:
        throw new AssertionError("SurfaceConfig does not map to any use case");
    }
}
