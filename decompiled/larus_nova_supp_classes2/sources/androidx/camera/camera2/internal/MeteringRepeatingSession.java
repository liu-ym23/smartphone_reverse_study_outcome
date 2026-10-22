package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MeteringRepeatingSession {
    private static final int IMAGE_FORMAT = 34;
    private static final String TAG = "MeteringRepeating";
    private SessionConfig.CloseableErrorListener mCloseableErrorListener;
    private final MeteringRepeatingConfig mConfigWithDefaults;
    private DeferrableSurface mDeferrableSurface;
    private final Size mMeteringRepeatingSize;
    private SessionConfig mSessionConfig;
    private final SupportedRepeatingSurfaceSize mSupportedRepeatingSurfaceSize;
    private final SurfaceResetCallback mSurfaceResetCallback;

    public static class MeteringRepeatingConfig implements UseCaseConfig<UseCase> {
        private final Config mConfig;

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ boolean containsOption(Config.Option r1) {
            return ReadableConfig.CC.$default$containsOption(this, r1);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ void findOptions(String r1, Config.OptionMatcher r2) {
            ReadableConfig.CC.$default$findOptions(this, r1, r2);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r1) {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig r1) {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ SessionConfig getDefaultSessionConfig() {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig r1) {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this, r1);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig
        public final /* synthetic */ DynamicRange getDynamicRange() {
            return ImageInputConfig.CC.$default$getDynamicRange(this);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig
        public final /* synthetic */ int getInputFormat() {
            return ImageInputConfig.CC.$default$getInputFormat(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option r1) {
            return ReadableConfig.CC.$default$getOptionPriority(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ int getPreviewStabilizationMode() {
            return UseCaseConfig.CC.$default$getPreviewStabilizationMode(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Set getPriorities(Config.Option r1) {
            return ReadableConfig.CC.$default$getPriorities(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker r1) {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ int getSurfaceOccupancyPriority() {
            return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ int getSurfaceOccupancyPriority(int r1) {
            return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this, r1);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public final /* synthetic */ Class getTargetClass() {
            return TargetConfig.CC.$default$getTargetClass(this);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public final /* synthetic */ Class getTargetClass(Class r1) {
            return TargetConfig.CC.$default$getTargetClass(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ Range getTargetFrameRate() {
            return UseCaseConfig.CC.$default$getTargetFrameRate(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ Range getTargetFrameRate(Range r1) {
            return UseCaseConfig.CC.$default$getTargetFrameRate(this, r1);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public final /* synthetic */ String getTargetName() {
            return TargetConfig.CC.$default$getTargetName(this);
        }

        @Override // androidx.camera.core.internal.TargetConfig
        public final /* synthetic */ String getTargetName(String r1) {
            return TargetConfig.CC.$default$getTargetName(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ int getVideoStabilizationMode() {
            return UseCaseConfig.CC.$default$getVideoStabilizationMode(this);
        }

        @Override // androidx.camera.core.impl.ImageInputConfig
        public final /* synthetic */ boolean hasDynamicRange() {
            return ImageInputConfig.CC.$default$hasDynamicRange(this);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ boolean isHighResolutionDisabled(boolean r1) {
            return UseCaseConfig.CC.$default$isHighResolutionDisabled(this, r1);
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public final /* synthetic */ boolean isZslDisabled(boolean r1) {
            return UseCaseConfig.CC.$default$isZslDisabled(this, r1);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Set listOptions() {
            return ReadableConfig.CC.$default$listOptions(this);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Object retrieveOption(Config.Option r1) {
            return ReadableConfig.CC.$default$retrieveOption(this, r1);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Object retrieveOption(Config.Option r1, Object r2) {
            return ReadableConfig.CC.$default$retrieveOption(this, r1, r2);
        }

        @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
        public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option r1, Config.OptionPriority r2) {
            return ReadableConfig.CC.$default$retrieveOptionWithPriority(this, r1, r2);
        }

        public MeteringRepeatingConfig() {
            MutableOptionsBundle r0 = MutableOptionsBundle.create();
            r0.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new Camera2SessionOptionUnpacker());
            r0.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
            setTargetConfigs(r0);
            this.mConfig = r0;
        }

        @Override // androidx.camera.core.impl.UseCaseConfig
        public UseCaseConfigFactory.CaptureType getCaptureType() {
            return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        }

        @Override // androidx.camera.core.impl.ReadableConfig
        public Config getConfig() {
            return this.mConfig;
        }

        private void setTargetConfigs(MutableOptionsBundle r3) {
            r3.insertOption(TargetConfig.OPTION_TARGET_CLASS, MeteringRepeatingSession.class);
            r3.insertOption(TargetConfig.OPTION_TARGET_NAME, MeteringRepeatingSession.class.getCanonicalName() + "-" + UUID.randomUUID());
        }
    }

    public interface SurfaceResetCallback {
        void onSurfaceReset();
    }

    public static /* synthetic */ int a(Size r0, Size r1) {
        return lambda$getProperPreviewSize$1(r0, r1);
    }

    public static /* synthetic */ void b(MeteringRepeatingSession r0, SessionConfig r1, SessionConfig.SessionError r2) {
        r0.lambda$createSessionConfig$0(r1, r2);
    }

    public String getName() {
        return TAG;
    }

    public void clear() {
        Logger.d(TAG, "MeteringRepeating clear!");
        DeferrableSurface r0 = this.mDeferrableSurface;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        this.mDeferrableSurface = null;
    }

    public SessionConfig createSessionConfig() {
        final SurfaceTexture r0 = new SurfaceTexture(0);
        r0.setDefaultBufferSize(this.mMeteringRepeatingSize.getWidth(), this.mMeteringRepeatingSize.getHeight());
        final Surface r1 = new Surface(r0);
        SessionConfig.Builder r2 = SessionConfig.Builder.createFrom(this.mConfigWithDefaults, this.mMeteringRepeatingSize);
        r2.setTemplateType(1);
        ImmediateSurface r3 = new ImmediateSurface(r1);
        this.mDeferrableSurface = r3;
        Futures.addCallback(r3.getTerminationFuture(), new AnonymousClass1(this, r1, r0), CameraXExecutors.directExecutor());
        r2.addSurface(this.mDeferrableSurface);
        SessionConfig.CloseableErrorListener r4 = this.mCloseableErrorListener;
        if (r4 == null) goto L5;
        r4.close();
    L5:
        SessionConfig.CloseableErrorListener r5 = new SessionConfig.CloseableErrorListener(new v2(this));
        this.mCloseableErrorListener = r5;
        r2.setErrorListener(r5);
        return r2.build();
    }

    public Size getMeteringRepeatingSize() {
        return this.mMeteringRepeatingSize;
    }

    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    public UseCaseConfig<?> getUseCaseConfig() {
        return this.mConfigWithDefaults;
    }

    private Size getProperPreviewSize(CameraCharacteristicsCompat r12, DisplayInfoManager r13) {
        Size[] r14 = r12.getStreamConfigurationMapCompat().getOutputSizes(34);
        if (r14 != null) goto L6;
        Logger.e(TAG, "Can not get output size list.");
        return new Size(0, 0);
    L6:
        Size[] r15 = this.mSupportedRepeatingSurfaceSize.getSupportedSizes(r14);
        List r1 = Arrays.asList(r15);
        Collections.sort(r1, new w2());
        Size r16 = r13.getPreviewSize();
        long r2 = Math.min(((long) r16.getWidth()) * ((long) r16.getHeight()), 307200);
        int r17 = r15.length;
        Size r4 = null;
        int r5 = 0;
    L7:
        if (r5 >= r17) goto L16;
        Size r6 = r15[r5];
        long r7 = ((long) r6.getWidth()) * ((long) r6.getHeight());
        if (r7 == r2) goto L10;
        if (r7 > r2) goto L12;
        r5 = r5 + 1;
        r4 = r6;
        goto L7
    L12:
        if (r4 == null) goto L16;
        return r4;
    L10:
        return r6;
    L16:
        return (Size) ListProtector.get(r1, 0);
    }

    private /* synthetic */ void lambda$createSessionConfig$0(SessionConfig r1, SessionConfig.SessionError r2) {
        this.mSessionConfig = createSessionConfig();
        SurfaceResetCallback r3 = this.mSurfaceResetCallback;
        if (r3 == null) goto L6;
        r3.onSurfaceReset();
        return;
    }

    private static /* synthetic */ int lambda$getProperPreviewSize$1(Size r4, Size r5) {
        return Long.signum((((long) r4.getWidth()) * ((long) r4.getHeight())) - (((long) r5.getWidth()) * ((long) r5.getHeight())));
    }

    public MeteringRepeatingSession(CameraCharacteristicsCompat r2, DisplayInfoManager r3, SurfaceResetCallback r4) {
        this.mSupportedRepeatingSurfaceSize = new SupportedRepeatingSurfaceSize();
        this.mCloseableErrorListener = null;
        this.mConfigWithDefaults = new MeteringRepeatingConfig();
        this.mSurfaceResetCallback = r4;
        Size r5 = getProperPreviewSize(r2, r3);
        this.mMeteringRepeatingSize = r5;
        Logger.d(TAG, "MeteringSession SurfaceTexture size: " + r5);
        this.mSessionConfig = createSessionConfig();
    }
}
