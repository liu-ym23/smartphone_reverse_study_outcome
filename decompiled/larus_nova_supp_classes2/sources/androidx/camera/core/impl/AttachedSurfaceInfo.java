package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class AttachedSurfaceInfo {
    public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

    public abstract DynamicRange getDynamicRange();

    public abstract int getImageFormat();

    public abstract Config getImplementationOptions();

    public abstract Size getSize();

    public abstract SurfaceConfig getSurfaceConfig();

    public abstract Range<Integer> getTargetFrameRate();

    public AttachedSurfaceInfo() {
    }

    public StreamSpec toStreamSpec(Config r3) {
        StreamSpec.Builder r4 = StreamSpec.builder(getSize()).setDynamicRange(getDynamicRange()).setImplementationOptions(r3);
        if (getTargetFrameRate() == null) goto L6;
        r4.setExpectedFrameRateRange(getTargetFrameRate());
    L6:
        return r4.build();
    }

    public static AttachedSurfaceInfo create(SurfaceConfig r9, int r10, Size r11, DynamicRange r12, List<UseCaseConfigFactory.CaptureType> r13, Config r14, Range<Integer> r15) {
        return new AutoValue_AttachedSurfaceInfo(r9, r10, r11, r12, r13, r14, r15);
    }
}
