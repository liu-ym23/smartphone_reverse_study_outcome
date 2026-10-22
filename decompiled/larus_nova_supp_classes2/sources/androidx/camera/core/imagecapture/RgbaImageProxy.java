package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class RgbaImageProxy implements ImageProxy {
    private final Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final Object mLock;
    ImageProxy.PlaneProxy[] mPlaneProxy;
    private final int mWidth;

    @Override // androidx.camera.core.ImageProxy
    public final /* synthetic */ Bitmap toBitmap() {
        return ImageProxy.CC.$default$toBitmap(this);
    }

    private void checkNotClosed() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPlaneProxy == null) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, "The image is closed.");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L7
        this.mPlaneProxy = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Bitmap createBitmap() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L7
        Bitmap r1 = ImageUtil.createBitmapFromPlane(getPlanes(), getWidth(), getHeight());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L7
        Rect r1 = this.mCropRect;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 1;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L7
        int r1 = this.mHeight;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public Image getImage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L7
        ImageInfo r1 = this.mImageInfo;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L7
        ImageProxy.PlaneProxy[] r1 = this.mPlaneProxy;     // Catch: Throwable -> L7
        Objects.requireNonNull(r1);     // Catch: Throwable -> L7
        ImageProxy.PlaneProxy[] r2 = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L7
        int r1 = this.mWidth;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public RgbaImageProxy(Packet<Bitmap> r9) {
        this(r9.getData(), r9.getCropRect(), r9.getRotationDegrees(), r9.getSensorToBufferTransform(), r9.getCameraCaptureResult().getTimestamp());
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(Rect r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkNotClosed();     // Catch: Throwable -> L9
        if (r3 == null) goto L7;
        this.mCropRect.set(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static ImageInfo createImageInfo(final long r1, final int r3, final Matrix r4) {
        return new AnonymousClass2(r1, r3, r4);
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(final ByteBuffer r1, final int r2, final int r3) {
        return new AnonymousClass1(r2, r3, r1);
    }

    public RgbaImageProxy(Bitmap r11, Rect r12, int r13, Matrix r14, long r15) {
        this(ImageUtil.createDirectByteBuffer(r11), 4, r11.getWidth(), r11.getHeight(), r12, r13, r14, r15);
    }

    public RgbaImageProxy(ByteBuffer r2, int r3, int r4, int r5, Rect r6, int r7, Matrix r8, long r9) {
        this.mLock = new Object();
        this.mWidth = r4;
        this.mHeight = r5;
        this.mCropRect = r6;
        this.mImageInfo = createImageInfo(r9, r7, r8);
        r2.rewind();
        this.mPlaneProxy = new ImageProxy.PlaneProxy[]{createPlaneProxy(r2, r4 * r3, r3)};
    }
}
