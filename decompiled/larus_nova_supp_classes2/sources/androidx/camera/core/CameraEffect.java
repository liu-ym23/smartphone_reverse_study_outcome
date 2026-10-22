package androidx.camera.core;

import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class CameraEffect {
    public static final int IMAGE_CAPTURE = 4;
    public static final int OUTPUT_OPTION_ONE_FOR_ALL_TARGETS = 0;
    public static final int OUTPUT_OPTION_ONE_FOR_EACH_TARGET = 1;
    public static final int PREVIEW = 1;
    private static final List<Integer> SURFACE_PROCESSOR_TARGETS = null;
    public static final int TRANSFORMATION_ARBITRARY = 0;
    public static final int TRANSFORMATION_CAMERA_AND_SURFACE_ROTATION = 1;
    public static final int TRANSFORMATION_PASSTHROUGH = 2;
    public static final int VIDEO_CAPTURE = 2;
    private final Consumer<Throwable> mErrorListener;
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;
    private final int mOutputOption;
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;
    private final int mTransformation;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Formats {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputOptions {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Targets {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformations {
    }

    static {
        SURFACE_PROCESSOR_TARGETS = Arrays.asList(new Integer[]{1, 2, 3, 7});
    }

    public SurfaceProcessorInternal createSurfaceProcessorInternal() {
        return new SurfaceProcessorWithExecutor(this);
    }

    public Consumer<Throwable> getErrorListener() {
        return this.mErrorListener;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    public int getOutputOption() {
        return this.mOutputOption;
    }

    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public int getTransformation() {
        return this.mTransformation;
    }

    public CameraEffect(int r4, Executor r5, ImageProcessor r6, Consumer<Throwable> r7) {
        if (r4 != 4) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Currently ImageProcessor can only target IMAGE_CAPTURE.");
        this.mTargets = r4;
        this.mTransformation = 0;
        this.mOutputOption = 0;
        this.mExecutor = r5;
        this.mSurfaceProcessor = null;
        this.mImageProcessor = r6;
        this.mErrorListener = r7;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public CameraEffect(int r8, Executor r9, SurfaceProcessor r10, Consumer<Throwable> r11) {
        this(r8, 0, 0, r9, r10, r11);
    }

    public CameraEffect(int r8, int r9, Executor r10, SurfaceProcessor r11, Consumer<Throwable> r12) {
        this(r8, 0, r9, r10, r11, r12);
    }

    public CameraEffect(int r2, int r3, int r4, Executor r5, SurfaceProcessor r6, Consumer<Throwable> r7) {
        TargetUtils.checkSupportedTargets(SURFACE_PROCESSOR_TARGETS, r2);
        this.mTargets = r2;
        this.mOutputOption = r3;
        this.mTransformation = r4;
        this.mExecutor = r5;
        this.mSurfaceProcessor = r6;
        this.mImageProcessor = null;
        this.mErrorListener = r7;
    }
}
