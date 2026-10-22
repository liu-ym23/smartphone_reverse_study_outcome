package androidx.camera.core.processing;

import androidx.camera.core.processing.util.OutConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_SurfaceProcessorNode_In extends SurfaceProcessorNode.In {
    private final List<OutConfig> outConfigs;
    private final SurfaceEdge surfaceEdge;

    public int hashCode() {
        return ((this.surfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.outConfigs.hashCode();
    }

    public String toString() {
        return "In{surfaceEdge=" + this.surfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.In
    public List<OutConfig> getOutConfigs() {
        return this.outConfigs;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.In
    public SurfaceEdge getSurfaceEdge() {
        return this.surfaceEdge;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SurfaceProcessorNode.In) == false) goto L14;
        SurfaceProcessorNode.In r6 = (SurfaceProcessorNode.In) r5;
        if (this.surfaceEdge.equals(r6.getSurfaceEdge()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.outConfigs.equals(r6.getOutConfigs()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_SurfaceProcessorNode_In(SurfaceEdge r1, List<OutConfig> r2) {
        if (r1 == null) goto L11;
        this.surfaceEdge = r1;
        if (r2 == null) goto L9;
        this.outConfigs = r2;
        return;
    L9:
        throw new NullPointerException("Null outConfigs");
    L11:
        throw new NullPointerException("Null surfaceEdge");
    }
}
