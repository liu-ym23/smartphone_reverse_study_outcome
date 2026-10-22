package com.ss.texturerender.effect;

/* JADX INFO: loaded from: classes40.dex */
public class PicoTextureObj {
    public static final int PICO_VR_TEX_USE_FOR_CROP_SR_SCREEN = 2;
    public static final int PICO_VR_TEX_USE_FOR_FOV_SCREEN = 1;
    public static final int PICO_VR_TEX_USE_FOR_PLANE_ONLINE_SCREEN = 3;
    public static final int PICO_VR_TEX_USE_FOR_PLANE_SCREEN = 0;
    private int mHeight;
    private int mUnityTexId;
    private int mUseFor;
    private int mWidth;

    public int getHeight() {
        return this.mHeight;
    }

    public int getUnityTexId() {
        return this.mUnityTexId;
    }

    public int getUseFor() {
        return this.mUseFor;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setUnityTexId(int r100) {
        this.mUnityTexId = r100;
    }

    public void setUseFor(int r100) {
        this.mUseFor = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }

    public PicoTextureObj(int r100, int r101, int r102, int r103) {
        this.mUnityTexId = r100;
        this.mWidth = r101;
        this.mHeight = r102;
        this.mUseFor = r103;
    }
}
