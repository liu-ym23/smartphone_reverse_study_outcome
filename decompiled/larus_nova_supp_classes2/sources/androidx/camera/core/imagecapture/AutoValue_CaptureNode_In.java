package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.processing.Edge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_CaptureNode_In extends CaptureNode.In {
    private final Edge<TakePictureManager.CaptureError> errorEdge;
    private final ImageReaderProxyProvider imageReaderProxyProvider;
    private final int inputFormat;
    private final int outputFormat;
    private final int postviewImageFormat;
    private final Size postviewSize;
    private final Edge<ProcessingRequest> requestEdge;
    private final Size size;
    private final boolean virtualCamera;

    public int hashCode() {
        int r0 = (((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat) * 1000003;
        if (this.virtualCamera == false) goto L5;
        int r2 = 1231;
    L6:
        int r1 = (r0 ^ r2) * 1000003;
        ImageReaderProxyProvider r3 = this.imageReaderProxyProvider;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r1 ^ r5) * 1000003;
        Size r7 = this.postviewSize;
        if (r7 == null) goto L15;
        r4 = r7.hashCode();
    L15:
        return ((((((r6 ^ r4) * 1000003) ^ this.postviewImageFormat) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.errorEdge.hashCode();
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r2 = 1237;
        goto L6
    }

    public String toString() {
        return "In{size=" + this.size + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + ", virtualCamera=" + this.virtualCamera + ", imageReaderProxyProvider=" + this.imageReaderProxyProvider + ", postviewSize=" + this.postviewSize + ", postviewImageFormat=" + this.postviewImageFormat + ", requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + "}";
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Edge<TakePictureManager.CaptureError> getErrorEdge() {
        return this.errorEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.imageReaderProxyProvider;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public int getPostviewImageFormat() {
        return this.postviewImageFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Size getPostviewSize() {
        return this.postviewSize;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    public boolean isVirtualCamera() {
        return this.virtualCamera;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof CaptureNode.In) == false) goto L38;
        CaptureNode.In r6 = (CaptureNode.In) r5;
        if (this.size.equals(r6.getSize()) == true) goto L10;
    L36:
        return false;
    L10:
        if (this.inputFormat != r6.getInputFormat()) goto L36;
        if (this.outputFormat != r6.getOutputFormat()) goto L36;
        if (this.virtualCamera != r6.isVirtualCamera()) goto L36;
        ImageReaderProxyProvider r1 = this.imageReaderProxyProvider;
        if (r1 != null) goto L21;
        if (r6.getImageReaderProxyProvider() != null) goto L36;
    L22:
        Size r2 = this.postviewSize;
        if (r2 != null) goto L28;
        if (r6.getPostviewSize() != null) goto L36;
    L30:
        if (this.postviewImageFormat != r6.getPostviewImageFormat()) goto L36;
        if (this.requestEdge.equals(r6.getRequestEdge()) == false) goto L36;
        if (this.errorEdge.equals(r6.getErrorEdge()) == false) goto L36;
        return true;
    L28:
        if (r2.equals(r6.getPostviewSize()) == false) goto L36;
    L21:
        if (r1.equals(r6.getImageReaderProxyProvider()) == false) goto L36;
    L38:
        return false;
    }

    public AutoValue_CaptureNode_In(Size r1, int r2, int r3, boolean r4, ImageReaderProxyProvider r5, Size r6, int r7, Edge<ProcessingRequest> r8, Edge<TakePictureManager.CaptureError> r9) {
        if (r1 == null) goto L15;
        this.size = r1;
        this.inputFormat = r2;
        this.outputFormat = r3;
        this.virtualCamera = r4;
        this.imageReaderProxyProvider = r5;
        this.postviewSize = r6;
        this.postviewImageFormat = r7;
        if (r8 == null) goto L13;
        this.requestEdge = r8;
        if (r9 == null) goto L11;
        this.errorEdge = r9;
        return;
    L11:
        throw new NullPointerException("Null errorEdge");
    L13:
        throw new NullPointerException("Null requestEdge");
    L15:
        throw new NullPointerException("Null size");
    }
}
