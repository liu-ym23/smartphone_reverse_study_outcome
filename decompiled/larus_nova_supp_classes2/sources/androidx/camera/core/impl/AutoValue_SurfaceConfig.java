package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SurfaceConfig extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;
    private final long streamUseCase;

    public int hashCode() {
        int r0 = (((this.configType.hashCode() ^ 1000003) * 1000003) ^ this.configSize.hashCode()) * 1000003;
        long r1 = this.streamUseCase;
        return r0 ^ ((int) (r1 ^ (r1 >>> 32)));
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.configType + ", configSize=" + this.configSize + ", streamUseCase=" + this.streamUseCase + "}";
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public long getStreamUseCase() {
        return this.streamUseCase;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof SurfaceConfig) == false) goto L16;
        SurfaceConfig r9 = (SurfaceConfig) r8;
        if (this.configType.equals(r9.getConfigType()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.configSize.equals(r9.getConfigSize()) == false) goto L14;
        if (this.streamUseCase != r9.getStreamUseCase()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_SurfaceConfig(SurfaceConfig.ConfigType r1, SurfaceConfig.ConfigSize r2, long r3) {
        if (r1 == null) goto L11;
        this.configType = r1;
        if (r2 == null) goto L9;
        this.configSize = r2;
        this.streamUseCase = r3;
        return;
    L9:
        throw new NullPointerException("Null configSize");
    L11:
        throw new NullPointerException("Null configType");
    }
}
