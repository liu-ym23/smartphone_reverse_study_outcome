package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public class MediaCodecTextureBufferHelper {
    private ReleaseOutPutBuffer mReleaseFunc;
    private SurfaceTextureHelper mSurfaceTextureHelper;
    private boolean render;

    @FunctionalInterface
    public interface ReleaseOutPutBuffer {
        int release(boolean r100);
    }

    public float[] getMatrix() {
        SurfaceTextureHelper r100 = this.mSurfaceTextureHelper;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTexMatrix();
    }

    public boolean isAvaliable() {
        SurfaceTextureHelper r100 = this.mSurfaceTextureHelper;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isAvaliable();
    }

    public boolean updateTextureImage() {
        SurfaceTextureHelper r100 = this.mSurfaceTextureHelper;
        if (r100 != null) goto L6;
        return false;
    L6:
        r100.updateTexImage();
        return true;
    }

    public MediaCodecTextureBufferHelper(ReleaseOutPutBuffer r100) {
        this.render = false;
        this.mSurfaceTextureHelper = null;
        this.mReleaseFunc = r100;
    }

    public void releaseOutputBuffer(boolean r100) {
        runTask(r100);
    }

    public int runTask(boolean r100) {
        return this.mReleaseFunc.release(r100);
    }

    public void setRender(boolean r100) {
        this.render = r100;
    }

    public void setSurfaceTextureHelper(SurfaceTextureHelper r100) {
        this.mSurfaceTextureHelper = r100;
    }

    public boolean updateTextureImageAndWait(int r100) {
        SurfaceTextureHelper r101 = this.mSurfaceTextureHelper;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.updateTexImageAndWait(r100);
    }
}
