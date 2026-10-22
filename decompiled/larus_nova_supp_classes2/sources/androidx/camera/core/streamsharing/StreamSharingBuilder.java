package androidx.camera.core.streamsharing;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import java.util.UUID;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class StreamSharingBuilder implements UseCaseConfig.Builder<StreamSharing, StreamSharingConfig, StreamSharingBuilder> {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by StreamSharingBuilder.";
    private final MutableOptionsBundle mMutableConfig;

    @Override // androidx.camera.core.ExtendableBuilder
    public StreamSharing build() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingConfig getUseCaseConfig() {
        return new StreamSharingConfig(OptionsBundle.from(this.mMutableConfig));
    }

    public StreamSharingBuilder() {
        this(MutableOptionsBundle.create());
    }

    @Override // androidx.camera.core.ExtendableBuilder
    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    @Override // androidx.camera.core.ExtendableBuilder
    public /* bridge */ /* synthetic */ Object build() {
        return build();
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ UseCaseConfig getUseCaseConfig() {
        return getUseCaseConfig();
    }

    public StreamSharingBuilder(MutableOptionsBundle r4) {
        this.mMutableConfig = r4;
        Class r5 = (Class) r4.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (r5 != null) goto L5;
    L9:
        setCaptureType(UseCaseConfigFactory.CaptureType.STREAM_SHARING);
        setTargetClass(StreamSharing.class);
        return;
    L5:
        if (r5.equals(StreamSharing.class) == true) goto L9;
        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + r5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r2) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setCaptureType(UseCaseConfigFactory.CaptureType r3) {
        getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_TYPE, r3);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setDefaultCaptureConfig(CaptureConfig r2) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setDefaultSessionConfig(SessionConfig r2) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setHighResolutionDisabled(boolean r2) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r2) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setSurfaceOccupancyPriority(int r2) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.internal.TargetConfig.Builder
    public StreamSharingBuilder setTargetClass(Class<StreamSharing> r4) {
        getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, r4);
        if (getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) goto L5;
        setTargetName(r4.getCanonicalName() + "-" + UUID.randomUUID());
    L5:
        return this;
    }

    @Override // androidx.camera.core.internal.TargetConfig.Builder
    public StreamSharingBuilder setTargetName(String r3) {
        getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, r3);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public StreamSharingBuilder setZslDisabled(boolean r2) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker r1) {
        return setCaptureOptionUnpacker(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setCaptureType(UseCaseConfigFactory.CaptureType r1) {
        return setCaptureType(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setDefaultCaptureConfig(CaptureConfig r1) {
        return setDefaultCaptureConfig(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setDefaultSessionConfig(SessionConfig r1) {
        return setDefaultSessionConfig(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setHighResolutionDisabled(boolean r1) {
        return setHighResolutionDisabled(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setSessionOptionUnpacker(SessionConfig.OptionUnpacker r1) {
        return setSessionOptionUnpacker(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setSurfaceOccupancyPriority(int r1) {
        return setSurfaceOccupancyPriority(r1);
    }

    @Override // androidx.camera.core.internal.TargetConfig.Builder
    public /* bridge */ /* synthetic */ Object setTargetClass(Class r1) {
        return setTargetClass(r1);
    }

    @Override // androidx.camera.core.internal.TargetConfig.Builder
    public /* bridge */ /* synthetic */ Object setTargetName(String r1) {
        return setTargetName(r1);
    }

    @Override // androidx.camera.core.impl.UseCaseConfig.Builder
    public /* bridge */ /* synthetic */ StreamSharingBuilder setZslDisabled(boolean r1) {
        return setZslDisabled(r1);
    }
}
