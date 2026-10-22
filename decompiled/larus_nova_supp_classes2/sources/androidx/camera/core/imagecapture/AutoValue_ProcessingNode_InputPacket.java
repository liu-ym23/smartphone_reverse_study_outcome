package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_ProcessingNode_InputPacket extends ProcessingNode.InputPacket {
    private final ImageProxy imageProxy;
    private final ProcessingRequest processingRequest;

    public int hashCode() {
        return ((this.processingRequest.hashCode() ^ 1000003) * 1000003) ^ this.imageProxy.hashCode();
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.processingRequest + ", imageProxy=" + this.imageProxy + "}";
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.InputPacket
    public ImageProxy getImageProxy() {
        return this.imageProxy;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.InputPacket
    public ProcessingRequest getProcessingRequest() {
        return this.processingRequest;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ProcessingNode.InputPacket) == false) goto L14;
        ProcessingNode.InputPacket r6 = (ProcessingNode.InputPacket) r5;
        if (this.processingRequest.equals(r6.getProcessingRequest()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.imageProxy.equals(r6.getImageProxy()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_ProcessingNode_InputPacket(ProcessingRequest r1, ImageProxy r2) {
        if (r1 == null) goto L11;
        this.processingRequest = r1;
        if (r2 == null) goto L9;
        this.imageProxy = r2;
        return;
    L9:
        throw new NullPointerException("Null imageProxy");
    L11:
        throw new NullPointerException("Null processingRequest");
    }
}
