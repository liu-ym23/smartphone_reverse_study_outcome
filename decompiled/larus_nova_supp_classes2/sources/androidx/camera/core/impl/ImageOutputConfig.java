package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ImageOutputConfig extends ReadableConfig {
    public static final int INVALID_ROTATION = -1;
    public static final Config.Option<Integer> OPTION_APP_TARGET_ROTATION = null;
    public static final Config.Option<List<Size>> OPTION_CUSTOM_ORDERED_RESOLUTIONS = null;
    public static final Config.Option<Size> OPTION_DEFAULT_RESOLUTION = null;
    public static final Config.Option<Size> OPTION_MAX_RESOLUTION = null;
    public static final Config.Option<Integer> OPTION_MIRROR_MODE = null;
    public static final Config.Option<ResolutionSelector> OPTION_RESOLUTION_SELECTOR = null;
    public static final Config.Option<List<Pair<Integer, Size[]>>> OPTION_SUPPORTED_RESOLUTIONS = null;
    public static final Config.Option<Integer> OPTION_TARGET_ASPECT_RATIO = null;
    public static final Config.Option<Size> OPTION_TARGET_RESOLUTION = null;
    public static final Config.Option<Integer> OPTION_TARGET_ROTATION = null;
    public static final int ROTATION_NOT_SPECIFIED = -1;

    /* JADX INFO: renamed from: androidx.camera.core.impl.ImageOutputConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            int r0 = ImageOutputConfig.INVALID_ROTATION;
        }

        public static List $default$getCustomOrderedResolutions(ImageOutputConfig r2) {
            List r3 = (List) r2.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS);
            Objects.requireNonNull(r3);
            return new ArrayList(r3);
        }

        public static Size $default$getDefaultResolution(ImageOutputConfig r1) {
            return (Size) r1.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
        }

        public static Size $default$getMaxResolution(ImageOutputConfig r1) {
            return (Size) r1.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
        }

        public static ResolutionSelector $default$getResolutionSelector(ImageOutputConfig r1) {
            return (ResolutionSelector) r1.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR);
        }

        public static List $default$getSupportedResolutions(ImageOutputConfig r1) {
            return (List) r1.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
        }

        public static int $default$getTargetAspectRatio(ImageOutputConfig r1) {
            return ((Integer) r1.retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
        }

        public static Size $default$getTargetResolution(ImageOutputConfig r1) {
            return (Size) r1.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
        }

        public static int $default$getTargetRotation(ImageOutputConfig r1) {
            return ((Integer) r1.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION)).intValue();
        }

        public static boolean $default$hasTargetAspectRatio(ImageOutputConfig r1) {
            return r1.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
        }

        public static void validateConfig(ImageOutputConfig r3) {
            boolean r0 = r3.hasTargetAspectRatio();
            if (r3.getTargetResolution(null) == null) goto L5;
            boolean r2 = true;
        L6:
            if (r0 == false) goto L12;
            if (r2 == false) goto L12;
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        L12:
            if (r3.getResolutionSelector(null) == null) goto L18;
            if (r0 == true) goto L17;
            if (r2 == true) goto L17;
            return;
        L17:
            throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
        L18:
            return;
        L5:
            r2 = false;
            goto L6
        }

        public static int $default$getAppTargetRotation(ImageOutputConfig r1, int r2) {
            return ((Integer) r1.retrieveOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, Integer.valueOf(r2))).intValue();
        }

        public static List $default$getCustomOrderedResolutions(ImageOutputConfig r1, List r2) {
            List r3 = (List) r1.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return new ArrayList(r3);
        }

        public static Size $default$getDefaultResolution(ImageOutputConfig r1, Size r2) {
            return (Size) r1.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, r2);
        }

        public static Size $default$getMaxResolution(ImageOutputConfig r1, Size r2) {
            return (Size) r1.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, r2);
        }

        public static int $default$getMirrorMode(ImageOutputConfig r1, int r2) {
            return ((Integer) r1.retrieveOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(r2))).intValue();
        }

        public static ResolutionSelector $default$getResolutionSelector(ImageOutputConfig r1, ResolutionSelector r2) {
            return (ResolutionSelector) r1.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, r2);
        }

        public static List $default$getSupportedResolutions(ImageOutputConfig r1, List r2) {
            return (List) r1.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, r2);
        }

        public static Size $default$getTargetResolution(ImageOutputConfig r1, Size r2) {
            return (Size) r1.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, r2);
        }

        public static int $default$getTargetRotation(ImageOutputConfig r1, int r2) {
            return ((Integer) r1.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(r2))).intValue();
        }
    }

    public interface Builder<B> {
        B setCustomOrderedResolutions(List<Size> r1);

        B setDefaultResolution(Size r1);

        B setMaxResolution(Size r1);

        B setMirrorMode(int r1);

        B setResolutionSelector(ResolutionSelector r1);

        B setSupportedResolutions(List<Pair<Integer, Size[]>> r1);

        B setTargetAspectRatio(int r1);

        B setTargetResolution(Size r1);

        B setTargetRotation(int r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OptionalRotationValue {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationDegreesValue {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationValue {
    }

    int getAppTargetRotation(int r1);

    List<Size> getCustomOrderedResolutions();

    List<Size> getCustomOrderedResolutions(List<Size> r1);

    Size getDefaultResolution();

    Size getDefaultResolution(Size r1);

    Size getMaxResolution();

    Size getMaxResolution(Size r1);

    int getMirrorMode(int r1);

    ResolutionSelector getResolutionSelector();

    ResolutionSelector getResolutionSelector(ResolutionSelector r1);

    List<Pair<Integer, Size[]>> getSupportedResolutions();

    List<Pair<Integer, Size[]>> getSupportedResolutions(List<Pair<Integer, Size[]>> r1);

    int getTargetAspectRatio();

    Size getTargetResolution();

    Size getTargetResolution(Size r1);

    int getTargetRotation();

    int getTargetRotation(int r1);

    boolean hasTargetAspectRatio();

    static {
        OPTION_TARGET_ASPECT_RATIO = Config.Option.create("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
        Class r0 = Integer.TYPE;
        OPTION_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.targetRotation", r0);
        OPTION_APP_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.appTargetRotation", r0);
        OPTION_MIRROR_MODE = Config.Option.create("camerax.core.imageOutput.mirrorMode", r0);
        OPTION_TARGET_RESOLUTION = Config.Option.create("camerax.core.imageOutput.targetResolution", Size.class);
        OPTION_DEFAULT_RESOLUTION = Config.Option.create("camerax.core.imageOutput.defaultResolution", Size.class);
        OPTION_MAX_RESOLUTION = Config.Option.create("camerax.core.imageOutput.maxResolution", Size.class);
        OPTION_SUPPORTED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.supportedResolutions", List.class);
        OPTION_RESOLUTION_SELECTOR = Config.Option.create("camerax.core.imageOutput.resolutionSelector", ResolutionSelector.class);
        OPTION_CUSTOM_ORDERED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.customOrderedResolutions", List.class);
    }
}
