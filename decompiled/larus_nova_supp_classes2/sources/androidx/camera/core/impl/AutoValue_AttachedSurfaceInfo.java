package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_AttachedSurfaceInfo extends AttachedSurfaceInfo {
    private final List<UseCaseConfigFactory.CaptureType> captureTypes;
    private final DynamicRange dynamicRange;
    private final int imageFormat;
    private final Config implementationOptions;
    private final Size size;
    private final SurfaceConfig surfaceConfig;
    private final Range<Integer> targetFrameRate;

    public int hashCode() {
        int r0 = (((((((((this.surfaceConfig.hashCode() ^ 1000003) * 1000003) ^ this.imageFormat) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.dynamicRange.hashCode()) * 1000003) ^ this.captureTypes.hashCode()) * 1000003;
        Config r2 = this.implementationOptions;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r1 = (r0 ^ r4) * 1000003;
        Range<Integer> r5 = this.targetFrameRate;
        if (r5 == null) goto L11;
        r3 = r5.hashCode();
    L11:
        return r1 ^ r3;
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.surfaceConfig + ", imageFormat=" + this.imageFormat + ", size=" + this.size + ", dynamicRange=" + this.dynamicRange + ", captureTypes=" + this.captureTypes + ", implementationOptions=" + this.implementationOptions + ", targetFrameRate=" + this.targetFrameRate + "}";
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
        return this.captureTypes;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public DynamicRange getDynamicRange() {
        return this.dynamicRange;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public int getImageFormat() {
        return this.imageFormat;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Config getImplementationOptions() {
        return this.implementationOptions;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public SurfaceConfig getSurfaceConfig() {
        return this.surfaceConfig;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Range<Integer> getTargetFrameRate() {
        return this.targetFrameRate;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AttachedSurfaceInfo) == false) goto L34;
        AttachedSurfaceInfo r6 = (AttachedSurfaceInfo) r5;
        if (this.surfaceConfig.equals(r6.getSurfaceConfig()) == true) goto L10;
    L32:
        return false;
    L10:
        if (this.imageFormat != r6.getImageFormat()) goto L32;
        if (this.size.equals(r6.getSize()) == false) goto L32;
        if (this.dynamicRange.equals(r6.getDynamicRange()) == false) goto L32;
        if (this.captureTypes.equals(r6.getCaptureTypes()) == false) goto L32;
        Config r1 = this.implementationOptions;
        if (r1 != null) goto L23;
        if (r6.getImplementationOptions() != null) goto L32;
    L24:
        Range<Integer> r2 = this.targetFrameRate;
        if (r2 != null) goto L30;
        if (r6.getTargetFrameRate() != null) goto L32;
        return true;
    L30:
        if (r2.equals(r6.getTargetFrameRate()) == false) goto L32;
        return true;
    L23:
        if (r1.equals(r6.getImplementationOptions()) == false) goto L32;
    L34:
        return false;
    }

    public AutoValue_AttachedSurfaceInfo(SurfaceConfig r1, int r2, Size r3, DynamicRange r4, List<UseCaseConfigFactory.CaptureType> r5, Config r6, Range<Integer> r7) {
        if (r1 == null) goto L19;
        this.surfaceConfig = r1;
        this.imageFormat = r2;
        if (r3 == null) goto L17;
        this.size = r3;
        if (r4 == null) goto L15;
        this.dynamicRange = r4;
        if (r5 == null) goto L13;
        this.captureTypes = r5;
        this.implementationOptions = r6;
        this.targetFrameRate = r7;
        return;
    L13:
        throw new NullPointerException("Null captureTypes");
    L15:
        throw new NullPointerException("Null dynamicRange");
    L17:
        throw new NullPointerException("Null size");
    L19:
        throw new NullPointerException("Null surfaceConfig");
    }
}
