package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.internal.utils.ImageUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ImageProxy extends AutoCloseable {

    /* JADX INFO: renamed from: androidx.camera.core.ImageProxy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Bitmap $default$toBitmap(ImageProxy r0) {
            return ImageUtil.createBitmapFromImageProxy(r0);
        }
    }

    public interface PlaneProxy {
        ByteBuffer getBuffer();

        int getPixelStride();

        int getRowStride();
    }

    @Override // java.lang.AutoCloseable
    void close();

    Rect getCropRect();

    int getFormat();

    int getHeight();

    Image getImage();

    ImageInfo getImageInfo();

    PlaneProxy[] getPlanes();

    int getWidth();

    void setCropRect(Rect r1);

    Bitmap toBitmap();
}
