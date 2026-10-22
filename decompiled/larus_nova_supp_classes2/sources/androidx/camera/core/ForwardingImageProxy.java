package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class ForwardingImageProxy implements ImageProxy {
    protected final ImageProxy mImage;
    private final Object mLock;
    private final Set<OnImageCloseListener> mOnImageCloseListeners;

    public interface OnImageCloseListener {
        void onImageClose(ImageProxy r1);
    }

    @Override // androidx.camera.core.ImageProxy
    public final /* synthetic */ Bitmap toBitmap() {
        return ImageProxy.CC.$default$toBitmap(this);
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.mImage.close();
        notifyOnImageCloseListeners();
    }

    @Override // androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    public Image getImage() {
        return this.mImage.getImage();
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        return this.mImage.getImageInfo();
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mImage.getPlanes();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mImage.getWidth();
    }

    public void notifyOnImageCloseListeners() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        HashSet r1 = new HashSet(this.mOnImageCloseListeners);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((OnImageCloseListener) r2.next()).onImageClose(this);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public ForwardingImageProxy(ImageProxy r2) {
        this.mLock = new Object();
        this.mOnImageCloseListeners = new HashSet();
        this.mImage = r2;
    }

    public void addOnImageCloseListener(OnImageCloseListener r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mOnImageCloseListeners.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(Rect r2) {
        this.mImage.setCropRect(r2);
    }
}
