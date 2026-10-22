package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraXConfig implements TargetConfig<CameraX> {
    static final long DEFAULT_OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = -1;
    static final Config.Option<CameraSelector> OPTION_AVAILABLE_CAMERAS_LIMITER = null;
    static final Config.Option<Executor> OPTION_CAMERA_EXECUTOR = null;
    static final Config.Option<CameraFactory.Provider> OPTION_CAMERA_FACTORY_PROVIDER = null;
    static final Config.Option<Long> OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = null;
    static final Config.Option<RetryPolicy> OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY = null;
    static final Config.Option<CameraDeviceSurfaceManager.Provider> OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = null;
    static final Config.Option<Integer> OPTION_MIN_LOGGING_LEVEL = null;
    static final Config.Option<QuirkSettings> OPTION_QUIRK_SETTINGS = null;
    static final Config.Option<Handler> OPTION_SCHEDULER_HANDLER = null;
    static final Config.Option<UseCaseConfigFactory.Provider> OPTION_USECASE_CONFIG_FACTORY_PROVIDER = null;
    private final OptionsBundle mConfig;

    public static final class Builder implements TargetConfig.Builder<CameraX, Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public CameraXConfig build() {
            return new CameraXConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        private Builder(MutableOptionsBundle r4) {
            this.mMutableConfig = r4;
            Class r5 = (Class) r4.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (r5 != null) goto L5;
        L9:
            setTargetClass(CameraX.class);
            return;
        L5:
            if (r5.equals(CameraX.class) == true) goto L9;
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r5);
        }

        public static Builder fromConfig(CameraXConfig r1) {
            return new Builder(MutableOptionsBundle.from(r1));
        }

        public Builder setAvailableCamerasLimiter(CameraSelector r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_AVAILABLE_CAMERAS_LIMITER, r3);
            return this;
        }

        public Builder setCameraExecutor(Executor r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_EXECUTOR, r3);
            return this;
        }

        public Builder setCameraFactoryProvider(CameraFactory.Provider r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_FACTORY_PROVIDER, r3);
            return this;
        }

        public Builder setCameraOpenRetryMaxTimeoutInMillisWhileResuming(long r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING, Long.valueOf(r3));
            return this;
        }

        public Builder setCameraProviderInitRetryPolicy(RetryPolicy r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY, r3);
            return this;
        }

        public Builder setDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, r3);
            return this;
        }

        public Builder setMinimumLoggingLevel(int r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_MIN_LOGGING_LEVEL, Integer.valueOf(r3));
            return this;
        }

        public Builder setQuirkSettings(QuirkSettings r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_QUIRK_SETTINGS, r3);
            return this;
        }

        public Builder setSchedulerHandler(Handler r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_SCHEDULER_HANDLER, r3);
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetClass(Class<CameraX> r4) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r4);
            if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
            setTargetName(r4.getCanonicalName() + "-" + UUID.randomUUID());
        L5:
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public Builder setTargetName(String r3) {
            getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, r3);
            return this;
        }

        public Builder setUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider r3) {
            getMutableConfig().insertOption(CameraXConfig.OPTION_USECASE_CONFIG_FACTORY_PROVIDER, r3);
            return this;
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetClass(Class<CameraX> r1) {
            return setTargetClass(r1);
        }

        @Override // androidx.camera.core.internal.TargetConfig.Builder
        public /* bridge */ /* synthetic */ Builder setTargetName(String r1) {
            return setTargetName(r1);
        }
    }

    public interface Provider {
        CameraXConfig getCameraXConfig();
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ boolean containsOption(Config.Option r1) {
        return ReadableConfig.CC.$default$containsOption(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ void findOptions(String r1, Config.OptionMatcher r2) {
        ReadableConfig.CC.$default$findOptions(this, r1, r2);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option r1) {
        return ReadableConfig.CC.$default$getOptionPriority(this, r1);
    }

    @Override // androidx.camera.core.impl.ReadableConfig, androidx.camera.core.impl.Config
    public final /* synthetic */ Set getPriorities(Config.Option r1) {
        return ReadableConfig.CC.$default$getPriorities(this, r1);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class<CameraX> getTargetClass() {
        return TargetConfig.CC.$default$getTargetClass(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ Class<CameraX> getTargetClass(Class<CameraX> r1) {
        return TargetConfig.CC.$default$getTargetClass(this, r1);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName() {
        return TargetConfig.CC.$default$getTargetName(this);
    }

    @Override // androidx.camera.core.internal.TargetConfig
    public final /* synthetic */ String getTargetName(String r1) {
        return TargetConfig.CC.$default$getTargetName(this, r1);
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

    static {
        OPTION_CAMERA_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.cameraFactoryProvider", CameraFactory.Provider.class);
        OPTION_DEVICE_SURFACE_MANAGER_PROVIDER = Config.Option.create("camerax.core.appConfig.deviceSurfaceManagerProvider", CameraDeviceSurfaceManager.Provider.class);
        OPTION_USECASE_CONFIG_FACTORY_PROVIDER = Config.Option.create("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.Provider.class);
        OPTION_CAMERA_EXECUTOR = Config.Option.create("camerax.core.appConfig.cameraExecutor", Executor.class);
        OPTION_SCHEDULER_HANDLER = Config.Option.create("camerax.core.appConfig.schedulerHandler", Handler.class);
        OPTION_MIN_LOGGING_LEVEL = Config.Option.create("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
        OPTION_AVAILABLE_CAMERAS_LIMITER = Config.Option.create("camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class);
        OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING = Config.Option.create("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE);
        OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY = Config.Option.create("camerax.core.appConfig.cameraProviderInitRetryPolicy", RetryPolicy.class);
        OPTION_QUIRK_SETTINGS = Config.Option.create("camerax.core.appConfig.quirksSettings", QuirkSettings.class);
    }

    public long getCameraOpenRetryMaxTimeoutInMillisWhileResuming() {
        return ((Long) this.mConfig.retrieveOption(OPTION_CAMERA_OPEN_RETRY_MAX_TIMEOUT_IN_MILLIS_WHILE_RESUMING, -1L)).longValue();
    }

    public RetryPolicy getCameraProviderInitRetryPolicy() {
        RetryPolicy r0 = (RetryPolicy) this.mConfig.retrieveOption(OPTION_CAMERA_PROVIDER_INIT_RETRY_POLICY, RetryPolicy.DEFAULT);
        Objects.requireNonNull(r0);
        return r0;
    }

    public int getMinimumLoggingLevel() {
        return ((Integer) this.mConfig.retrieveOption(OPTION_MIN_LOGGING_LEVEL, 3)).intValue();
    }

    public QuirkSettings getQuirkSettings() {
        return (QuirkSettings) this.mConfig.retrieveOption(OPTION_QUIRK_SETTINGS, null);
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    public CameraXConfig(OptionsBundle r1) {
        this.mConfig = r1;
    }

    public CameraSelector getAvailableCamerasLimiter(CameraSelector r3) {
        return (CameraSelector) this.mConfig.retrieveOption(OPTION_AVAILABLE_CAMERAS_LIMITER, r3);
    }

    public Executor getCameraExecutor(Executor r3) {
        return (Executor) this.mConfig.retrieveOption(OPTION_CAMERA_EXECUTOR, r3);
    }

    public CameraFactory.Provider getCameraFactoryProvider(CameraFactory.Provider r3) {
        return (CameraFactory.Provider) this.mConfig.retrieveOption(OPTION_CAMERA_FACTORY_PROVIDER, r3);
    }

    public CameraDeviceSurfaceManager.Provider getDeviceSurfaceManagerProvider(CameraDeviceSurfaceManager.Provider r3) {
        return (CameraDeviceSurfaceManager.Provider) this.mConfig.retrieveOption(OPTION_DEVICE_SURFACE_MANAGER_PROVIDER, r3);
    }

    public Handler getSchedulerHandler(Handler r3) {
        return (Handler) this.mConfig.retrieveOption(OPTION_SCHEDULER_HANDLER, r3);
    }

    public UseCaseConfigFactory.Provider getUseCaseConfigFactoryProvider(UseCaseConfigFactory.Provider r3) {
        return (UseCaseConfigFactory.Provider) this.mConfig.retrieveOption(OPTION_USECASE_CONFIG_FACTORY_PROVIDER, r3);
    }
}
