package androidx.camera.core.impl;

import android.util.Size;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class SurfaceSizeDefinition {
    public abstract Size getAnalysisSize();

    public abstract Map<Integer, Size> getMaximumSizeMap();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();

    public abstract Map<Integer, Size> getS1440pSizeMap();

    public abstract Map<Integer, Size> getS720pSizeMap();

    public abstract Map<Integer, Size> getUltraMaximumSizeMap();

    public SurfaceSizeDefinition() {
    }

    public Size getMaximumSize(int r2) {
        return getMaximumSizeMap().get(Integer.valueOf(r2));
    }

    public Size getS1440pSize(int r2) {
        return getS1440pSizeMap().get(Integer.valueOf(r2));
    }

    public Size getS720pSize(int r2) {
        return getS720pSizeMap().get(Integer.valueOf(r2));
    }

    public Size getUltraMaximumSize(int r2) {
        return getUltraMaximumSizeMap().get(Integer.valueOf(r2));
    }

    public static SurfaceSizeDefinition create(Size r9, Map<Integer, Size> r10, Size r11, Map<Integer, Size> r12, Size r13, Map<Integer, Size> r14, Map<Integer, Size> r15) {
        return new AutoValue_SurfaceSizeDefinition(r9, r10, r11, r12, r13, r14, r15);
    }
}
