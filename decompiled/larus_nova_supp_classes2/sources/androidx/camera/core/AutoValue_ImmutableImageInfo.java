package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_ImmutableImageInfo extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransformMatrix;
    private final TagBundle tagBundle;
    private final long timestamp;

    public int hashCode() {
        int r0 = (this.tagBundle.hashCode() ^ 1000003) * 1000003;
        long r2 = this.timestamp;
        return ((((r0 ^ ((int) (r2 ^ (r2 >>> 32)))) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.sensorToBufferTransformMatrix.hashCode();
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.tagBundle + ", timestamp=" + this.timestamp + ", rotationDegrees=" + this.rotationDegrees + ", sensorToBufferTransformMatrix=" + this.sensorToBufferTransformMatrix + "}";
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public Matrix getSensorToBufferTransformMatrix() {
        return this.sensorToBufferTransformMatrix;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public TagBundle getTagBundle() {
        return this.tagBundle;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof ImmutableImageInfo) == false) goto L18;
        ImmutableImageInfo r9 = (ImmutableImageInfo) r8;
        if (this.tagBundle.equals(r9.getTagBundle()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.timestamp != r9.getTimestamp()) goto L16;
        if (this.rotationDegrees != r9.getRotationDegrees()) goto L16;
        if (this.sensorToBufferTransformMatrix.equals(r9.getSensorToBufferTransformMatrix()) == false) goto L16;
        return true;
    L18:
        return false;
    }

    public AutoValue_ImmutableImageInfo(TagBundle r1, long r2, int r4, Matrix r5) {
        if (r1 == null) goto L11;
        this.tagBundle = r1;
        this.timestamp = r2;
        this.rotationDegrees = r4;
        if (r5 == null) goto L9;
        this.sensorToBufferTransformMatrix = r5;
        return;
    L9:
        throw new NullPointerException("Null sensorToBufferTransformMatrix");
    L11:
        throw new NullPointerException("Null tagBundle");
    }
}
