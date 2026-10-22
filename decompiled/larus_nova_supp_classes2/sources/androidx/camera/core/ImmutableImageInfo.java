package androidx.camera.core;

import android.graphics.Matrix;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class ImmutableImageInfo implements ImageInfo {
    public ImmutableImageInfo() {
    }

    @Override // androidx.camera.core.ImageInfo
    public abstract int getRotationDegrees();

    @Override // androidx.camera.core.ImageInfo
    public abstract Matrix getSensorToBufferTransformMatrix();

    @Override // androidx.camera.core.ImageInfo
    public abstract TagBundle getTagBundle();

    @Override // androidx.camera.core.ImageInfo
    public abstract long getTimestamp();

    @Override // androidx.camera.core.ImageInfo
    public void populateExifData(ExifData.Builder r2) {
        r2.setOrientationDegrees(getRotationDegrees());
    }

    public static ImageInfo create(TagBundle r7, long r8, int r10, Matrix r11) {
        return new AutoValue_ImmutableImageInfo(r7, r8, r10, r11);
    }
}
