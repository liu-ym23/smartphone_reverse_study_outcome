package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_Packet<T> extends Packet<T> {
    private final CameraCaptureResult cameraCaptureResult;
    private final Rect cropRect;
    private final T data;
    private final Exif exif;
    private final int format;
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransform;
    private final Size size;

    public int hashCode() {
        int r0 = (this.data.hashCode() ^ 1000003) * 1000003;
        Exif r2 = this.exif;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return ((((((((((((r0 ^ r3) * 1000003) ^ this.format) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.cameraCaptureResult.hashCode();
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "Packet{data=" + this.data + ", exif=" + this.exif + ", format=" + this.format + ", size=" + this.size + ", cropRect=" + this.cropRect + ", rotationDegrees=" + this.rotationDegrees + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", cameraCaptureResult=" + this.cameraCaptureResult + "}";
    }

    @Override // androidx.camera.core.processing.Packet
    public CameraCaptureResult getCameraCaptureResult() {
        return this.cameraCaptureResult;
    }

    @Override // androidx.camera.core.processing.Packet
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.processing.Packet
    public T getData() {
        return this.data;
    }

    @Override // androidx.camera.core.processing.Packet
    public Exif getExif() {
        return this.exif;
    }

    @Override // androidx.camera.core.processing.Packet
    public int getFormat() {
        return this.format;
    }

    @Override // androidx.camera.core.processing.Packet
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.processing.Packet
    public Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    @Override // androidx.camera.core.processing.Packet
    public Size getSize() {
        return this.size;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Packet) == false) goto L31;
        Packet r6 = (Packet) r5;
        if (this.data.equals(r6.getData()) == false) goto L29;
        Exif r1 = this.exif;
        if (r1 != null) goto L15;
        if (r6.getExif() != null) goto L29;
    L17:
        if (this.format != r6.getFormat()) goto L29;
        if (this.size.equals(r6.getSize()) == false) goto L29;
        if (this.cropRect.equals(r6.getCropRect()) == false) goto L29;
        if (this.rotationDegrees != r6.getRotationDegrees()) goto L29;
        if (this.sensorToBufferTransform.equals(r6.getSensorToBufferTransform()) == false) goto L29;
        if (this.cameraCaptureResult.equals(r6.getCameraCaptureResult()) == false) goto L29;
        return true;
    L15:
        if (r1.equals(r6.getExif()) == true) goto L17;
    L29:
        return false;
    L31:
        return false;
    }

    public AutoValue_Packet(T r1, Exif r2, int r3, Size r4, Rect r5, int r6, Matrix r7, CameraCaptureResult r8) {
        if (r1 == null) goto L23;
        this.data = r1;
        this.exif = r2;
        this.format = r3;
        if (r4 == null) goto L21;
        this.size = r4;
        if (r5 == null) goto L19;
        this.cropRect = r5;
        this.rotationDegrees = r6;
        if (r7 == null) goto L17;
        this.sensorToBufferTransform = r7;
        if (r8 == null) goto L15;
        this.cameraCaptureResult = r8;
        return;
    L15:
        throw new NullPointerException("Null cameraCaptureResult");
    L17:
        throw new NullPointerException("Null sensorToBufferTransform");
    L19:
        throw new NullPointerException("Null cropRect");
    L21:
        throw new NullPointerException("Null size");
    L23:
        throw new NullPointerException("Null data");
    }
}
