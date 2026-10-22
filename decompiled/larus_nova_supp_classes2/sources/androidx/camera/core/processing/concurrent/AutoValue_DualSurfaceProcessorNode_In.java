package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.SurfaceEdge;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_DualSurfaceProcessorNode_In extends DualSurfaceProcessorNode.In {
    private final List<DualOutConfig> outConfigs;
    private final SurfaceEdge primarySurfaceEdge;
    private final SurfaceEdge secondarySurfaceEdge;

    public int hashCode() {
        return ((((this.primarySurfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.secondarySurfaceEdge.hashCode()) * 1000003) ^ this.outConfigs.hashCode();
    }

    public String toString() {
        return "In{primarySurfaceEdge=" + this.primarySurfaceEdge + ", secondarySurfaceEdge=" + this.secondarySurfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.In
    public List<DualOutConfig> getOutConfigs() {
        return this.outConfigs;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.In
    public SurfaceEdge getPrimarySurfaceEdge() {
        return this.primarySurfaceEdge;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.In
    public SurfaceEdge getSecondarySurfaceEdge() {
        return this.secondarySurfaceEdge;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DualSurfaceProcessorNode.In) == false) goto L16;
        DualSurfaceProcessorNode.In r6 = (DualSurfaceProcessorNode.In) r5;
        if (this.primarySurfaceEdge.equals(r6.getPrimarySurfaceEdge()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.secondarySurfaceEdge.equals(r6.getSecondarySurfaceEdge()) == false) goto L14;
        if (this.outConfigs.equals(r6.getOutConfigs()) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_DualSurfaceProcessorNode_In(SurfaceEdge r1, SurfaceEdge r2, List<DualOutConfig> r3) {
        if (r1 == null) goto L15;
        this.primarySurfaceEdge = r1;
        if (r2 == null) goto L13;
        this.secondarySurfaceEdge = r2;
        if (r3 == null) goto L11;
        this.outConfigs = r3;
        return;
    L11:
        throw new NullPointerException("Null outConfigs");
    L13:
        throw new NullPointerException("Null secondarySurfaceEdge");
    L15:
        throw new NullPointerException("Null primarySurfaceEdge");
    }
}
