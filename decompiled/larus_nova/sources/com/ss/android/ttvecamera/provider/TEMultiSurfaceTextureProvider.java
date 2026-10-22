package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ttvecamera.ICameraInstance;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.TEMultiCamera;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public class TEMultiSurfaceTextureProvider extends TECameraProvider {
    private static final String TAG = "TEMultiSurfaceTextureProvider";
    Map<Integer, SurfaceTexture> SurfaceTextures;
    Map<Integer, List<Surface>> Surfaces;
    Map<Integer, Integer> TextureIDs;
    Map<Integer, List<ImageReader>> imageReaders;
    Map<Integer, TECameraProvider.CaptureListener> mCaptureListeners;
    private int mPrimaryFacing;
    private int mSecondaryFacing;

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 32;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture r100, boolean r101) {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        if (this.Surfaces.get(0) != null) goto L5;
        return null;
    L5:
        return (Surface) ListProtector.get(this.Surfaces.get(0), 0);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface[] getSurfaces() {
        if (this.Surfaces.get(0) != null) goto L5;
        return null;
    L5:
        return (Surface[]) this.Surfaces.get(0).toArray(new Surface[0]);
    }

    public boolean isFull() {
        if (this.SurfaceTextures.get(Integer.valueOf(this.mSecondaryFacing)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        Iterator<Map.Entry<Integer, TECameraProvider.CaptureListener>> r100 = this.mCaptureListeners.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry<Integer, TECameraProvider.CaptureListener> r101 = r100.next();
        if ((r101.getValue() instanceof TECameraProvider.CaptureListenerWithAR) == true) goto L7;
        r101.setValue(this.mEmptyCaptureListener);
        goto L4
    L7:
        r101.setValue(this.mEmptyCaptureListenerWithAR);
        goto L4
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void releaseSurfaceTexture() {
        Iterator<Map.Entry<Integer, SurfaceTexture>> r100 = this.SurfaceTextures.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        Map.Entry<Integer, SurfaceTexture> r101 = r100.next();
        if (r101.getValue() == null) goto L4;
        if (Build.VERSION.SDK_INT < 26) goto L4;
        if (r101.getValue().isReleased() == true) goto L4;
        TELogUtils.i(TAG, "releaseSurfaceTexture, mSurfaceTexture = " + r101.getValue());
        r101.getValue().release();
        goto L4
    }

    public SurfaceTexture.OnFrameAvailableListener createSurfaceTextureListener(final int r100) {
        return new AnonymousClass1(this, r100);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface(int r100) {
        if (this.Surfaces.get(Integer.valueOf(r100)) != null) goto L5;
        return null;
    L5:
        return (Surface) ListProtector.get(this.Surfaces.get(Integer.valueOf(r100)), 0);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture(int r100) {
        return this.SurfaceTextures.get(Integer.valueOf(r100));
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface[] getSurfaces(int r100) {
        if (this.Surfaces.get(Integer.valueOf(r100)) != null) goto L5;
        return null;
    L5:
        return (Surface[]) this.Surfaces.get(Integer.valueOf(r100)).toArray(new Surface[0]);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setCaptureListener(TECameraProvider.CaptureListener r100) {
        if (this.mCaptureListeners.get(Integer.valueOf(this.mPrimaryFacing)) != null) goto L5;
        this.mCaptureListeners.put(Integer.valueOf(this.mPrimaryFacing), r100);
        return;
    L5:
        this.mCaptureListeners.put(Integer.valueOf(this.mSecondaryFacing), r100);
    }

    public TEMultiSurfaceTextureProvider(TECameraProviderManager.ProviderSettings r100, ICameraInstance r101) {
        super(r100, r101);
        int r102 = 0;
        this.mPrimaryFacing = 0;
        this.mSecondaryFacing = 1;
        this.SurfaceTextures = new HashMap();
        this.Surfaces = new HashMap();
        this.imageReaders = new HashMap();
        this.TextureIDs = new HashMap();
        this.mCaptureListeners = new ConcurrentHashMap();
        if ((r101 instanceof TEMultiCamera) == false) goto L9;
        int r103 = ((TEMultiCamera) r101).getPrimaryCameraFacing();
        this.mPrimaryFacing = r103;
        if (r103 != 0) goto L7;
        r102 = 1;
    L7:
        this.mSecondaryFacing = r102;
        return;
    }

    private void initOnFrameAvailableListener(SurfaceTexture r100, SurfaceTexture.OnFrameAvailableListener r101) {
        if (r100 == null) goto L5;
        r100.setOnFrameAvailableListener(r101, this.mCamera.getHandler());
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> r100, TEFrameSizei r110) {
        if (r100 != null) goto L4;
    L6:
        Iterator<Map.Entry<Integer, SurfaceTexture>> r101 = this.SurfaceTextures.entrySet().iterator();
    L7:
        int r102 = 0;
        if (r101.hasNext() == false) goto L16;
        final Map.Entry<Integer, SurfaceTexture> r111 = r101.next();
        SurfaceTexture r103 = r111.getValue();
        int r104 = r111.getKey().intValue();
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        if (r103 == null) goto L13;
        TEFrameSizei r107 = this.mSize;
        r103.setDefaultBufferSize(r107.width, r107.height);
        r106.add(new Surface(r103));
    L13:
        if (r102 >= this.mImageReaderCount) goto L15;
        TEFrameSizei r108 = this.mSize;
        ImageReader r109 = ImageReader.newInstance(r108.width, r108.height, TECameraFrame.pixelFormat2ImageFormat(this.mFormat), 1);
        r109.setOnImageAvailableListener(new AnonymousClass2(this, r111), this.mCamera.getHandler());
        r105.add(r109);
        r106.add(r109.getSurface());
        r102 = r102 + 1;
        goto L13
    L15:
        this.imageReaders.put(Integer.valueOf(r104), r105);
        this.Surfaces.put(Integer.valueOf(r104), r106);
        goto L7
    L16:
        return 0;
    L4:
        if (r100.size() <= 0) goto L6;
        this.mSize = TECameraUtils.calcPreviewSize(r100, this.mSize, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
        goto L6
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(StreamConfigurationMap r100, TEFrameSizei r101) {
        int[] r102 = r100.getOutputFormats();
        int r103 = TECameraFrame.pixelFormat2ImageFormat(this.mFormat);
        int r104 = r102.length;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L8;
        int r107 = r102[r106];
        if (r107 == r103) goto L6;
        r106 = r106 + 1;
        goto L3
    L6:
        r105 = r107;
    L8:
        if (r105 != 0) goto L11;
        r105 = 35;
    L11:
        return init(TECameraProvider.convertSizes(r100.getOutputSizes(r105)), r101);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(int r100, SurfaceTexture r101, boolean r102, int r103) {
        if (this.SurfaceTextures.get(Integer.valueOf(this.mPrimaryFacing)) != null) goto L5;
        this.SurfaceTextures.put(Integer.valueOf(this.mPrimaryFacing), r101);
        this.TextureIDs.put(Integer.valueOf(this.mPrimaryFacing), Integer.valueOf(r103));
        SurfaceTexture.OnFrameAvailableListener r104 = createSurfaceTextureListener(this.mPrimaryFacing);
    L6:
        initOnFrameAvailableListener(r101, r104);
        return;
    L5:
        this.SurfaceTextures.put(Integer.valueOf(this.mSecondaryFacing), r101);
        this.TextureIDs.put(Integer.valueOf(this.mSecondaryFacing), Integer.valueOf(r103));
        r104 = createSurfaceTextureListener(this.mSecondaryFacing);
        goto L6
    }
}
