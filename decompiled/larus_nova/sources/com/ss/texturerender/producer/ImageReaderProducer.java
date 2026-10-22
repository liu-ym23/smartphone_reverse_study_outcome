package com.ss.texturerender.producer;

import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import com.ss.texturerender.IFrameAvailableListener;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.effect.EffectTexture;

/* JADX INFO: loaded from: classes40.dex */
public class ImageReaderProducer implements IFrameProducer, ImageReader.OnImageAvailableListener {
    public static final int IMAGEREADER_STATUS = 1;
    public static final int IMAGEREADER_STATUS_CLOSE = 1;
    public static final int IMAGEREADER_STATUS_OPEN = 2;
    public static final int IMAGEREADER_STATUS_UNKNOWN = 0;
    private static final float[] MatrixFlipV = null;
    private final String TAG;
    private volatile Image mCurImage;
    private EffectTexture mEffectTexture;
    private IFrameAvailableListener mFrameAvailableListener;
    private ImageReader mImageReader;
    private volatile boolean mIsRelease;
    private volatile int mStatus;
    private int mTexType;

    @Override // com.ss.texturerender.producer.IFrameProducer
    public int getProducerType() {
        return 2;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void release() {
        this.mIsRelease = true;
        this.mImageReader = null;
        this.mFrameAvailableListener = null;
        this.mEffectTexture = null;
        if (this.mCurImage == null) goto L9;
        this.mCurImage.close();     // Catch: Exception -> L6
        this.mCurImage = null;     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void updateImage() {
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void updateTexDimension(int r100, int r101) {
    }

    static {
        MatrixFlipV = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    }

    private void _updateImage() {
        ImageReader r100 = this.mImageReader;
        if (r100 != null) goto L27;
        return;
    L27:
        Image r101 = r100.acquireNextImage();     // Catch: Exception -> L21
        if (r101 == null) goto L30;
    L19:
        Exception e100 = e;
    L23:
        TextureRenderLog.e(this.mTexType, this.TAG, e100.toString());
        if (r101 == null) goto L32;
        r101.close();
        return;
    L32:
        return;
    L9:
        if (this.mCurImage == null) goto L12;
        this.mCurImage.close();     // Catch: Exception -> L19
        this.mCurImage = null;     // Catch: Exception -> L19
    L12:
        if (this.mIsRelease == false) goto L14;
    L17:
        r101.close();     // Catch: Exception -> L19
        return;
    L14:
        if (this.mStatus == 1) goto L17;
        this.mCurImage = r101;     // Catch: Exception -> L19
        return;
    L30:
        return;
    L21:
        e = move-exception;
        e100 = e;
        r101 = null;
        goto L23
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public EffectTexture getEffectTexture() {
        if (this.mImageReader != null) goto L5;
        return null;
    L5:
        if (this.mIsRelease == false) goto L8;
        return null;
    L8:
        if (this.mCurImage != null) goto L11;
        _updateImage();
    L11:
        if (this.mCurImage == null) goto L19;
        HardwareBuffer r100 = this.mCurImage.getHardwareBuffer();     // Catch: Exception -> L16
        if (r100 == null) goto L19;
        this.mEffectTexture = new EffectTexture(null, r100, this.mCurImage.getWidth(), this.mCurImage.getHeight(), r100.getFormat(), 2);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.TAG, "getEffectTexture,e:" + e.toString());
    L19:
        return this.mEffectTexture;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public long getTimestamp() {
        if (this.mCurImage != null) goto L9;
        return 0;
    L9:
        return this.mCurImage.getTimestamp();
    L11:
        return 0;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void releaseOffScreenSurface() {
        release();
    }

    public ImageReaderProducer(int r100) {
        this.mCurImage = null;
        this.mEffectTexture = null;
        this.mIsRelease = false;
        this.mStatus = 0;
        this.TAG = TextureRenderLog.getLogTag(this);
        this.mTexType = r100;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void getTransformMatrix(float[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 16) goto L6;
        r100[r101] = MatrixFlipV[r101];
        r101 = r101 + 1;
        goto L4
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader r100) {
        if (this.mStatus != 1) goto L5;
        return;
    L5:
        this.mImageReader = r100;
        _updateImage();
        IFrameAvailableListener r101 = this.mFrameAvailableListener;
        if (r101 == null) goto L9;
        r101.onFrameAvailable();
        return;
    }

    public void setIntOption(int r100, int r101) {
        if (r100 != 1) goto L10;
        this.mStatus = r101;
        TextureRenderLog.d(this.mTexType, this.TAG, "set status:" + this.mStatus + "image:" + this.mCurImage);
        if (r101 == 1) goto L7;
        return;
    L7:
        if (this.mCurImage == null) goto L12;
        this.mCurImage.close();
        this.mCurImage = null;
        return;
    L12:
        return;
    }

    @Override // com.ss.texturerender.producer.IFrameProducer
    public void setOnFrameAvailableListener(IFrameAvailableListener r100, Handler r101) {
        this.mFrameAvailableListener = r100;
    }
}
