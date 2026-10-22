package androidx.camera.core.impl;

import android.util.Size;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SurfaceSizeDefinition extends SurfaceSizeDefinition {
    private final Size analysisSize;
    private final Map<Integer, Size> maximumSizeMap;
    private final Size previewSize;
    private final Size recordSize;
    private final Map<Integer, Size> s1440pSizeMap;
    private final Map<Integer, Size> s720pSizeMap;
    private final Map<Integer, Size> ultraMaximumSizeMap;

    public int hashCode() {
        return ((((((((((((this.analysisSize.hashCode() ^ 1000003) * 1000003) ^ this.s720pSizeMap.hashCode()) * 1000003) ^ this.previewSize.hashCode()) * 1000003) ^ this.s1440pSizeMap.hashCode()) * 1000003) ^ this.recordSize.hashCode()) * 1000003) ^ this.maximumSizeMap.hashCode()) * 1000003) ^ this.ultraMaximumSizeMap.hashCode();
    }

    public String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.analysisSize + ", s720pSizeMap=" + this.s720pSizeMap + ", previewSize=" + this.previewSize + ", s1440pSizeMap=" + this.s1440pSizeMap + ", recordSize=" + this.recordSize + ", maximumSizeMap=" + this.maximumSizeMap + ", ultraMaximumSizeMap=" + this.ultraMaximumSizeMap + "}";
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getAnalysisSize() {
        return this.analysisSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getMaximumSizeMap() {
        return this.maximumSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getPreviewSize() {
        return this.previewSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getRecordSize() {
        return this.recordSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getS1440pSizeMap() {
        return this.s1440pSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getS720pSizeMap() {
        return this.s720pSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map<Integer, Size> getUltraMaximumSizeMap() {
        return this.ultraMaximumSizeMap;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SurfaceSizeDefinition) == false) goto L24;
        SurfaceSizeDefinition r6 = (SurfaceSizeDefinition) r5;
        if (this.analysisSize.equals(r6.getAnalysisSize()) == true) goto L10;
    L22:
        return false;
    L10:
        if (this.s720pSizeMap.equals(r6.getS720pSizeMap()) == false) goto L22;
        if (this.previewSize.equals(r6.getPreviewSize()) == false) goto L22;
        if (this.s1440pSizeMap.equals(r6.getS1440pSizeMap()) == false) goto L22;
        if (this.recordSize.equals(r6.getRecordSize()) == false) goto L22;
        if (this.maximumSizeMap.equals(r6.getMaximumSizeMap()) == false) goto L22;
        if (this.ultraMaximumSizeMap.equals(r6.getUltraMaximumSizeMap()) == false) goto L22;
        return true;
    L24:
        return false;
    }

    public AutoValue_SurfaceSizeDefinition(Size r1, Map<Integer, Size> r2, Size r3, Map<Integer, Size> r4, Size r5, Map<Integer, Size> r6, Map<Integer, Size> r7) {
        if (r1 == null) goto L31;
        this.analysisSize = r1;
        if (r2 == null) goto L29;
        this.s720pSizeMap = r2;
        if (r3 == null) goto L27;
        this.previewSize = r3;
        if (r4 == null) goto L25;
        this.s1440pSizeMap = r4;
        if (r5 == null) goto L23;
        this.recordSize = r5;
        if (r6 == null) goto L21;
        this.maximumSizeMap = r6;
        if (r7 == null) goto L19;
        this.ultraMaximumSizeMap = r7;
        return;
    L19:
        throw new NullPointerException("Null ultraMaximumSizeMap");
    L21:
        throw new NullPointerException("Null maximumSizeMap");
    L23:
        throw new NullPointerException("Null recordSize");
    L25:
        throw new NullPointerException("Null s1440pSizeMap");
    L27:
        throw new NullPointerException("Null previewSize");
    L29:
        throw new NullPointerException("Null s720pSizeMap");
    L31:
        throw new NullPointerException("Null analysisSize");
    }
}
