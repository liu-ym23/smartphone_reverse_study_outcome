package com.ss.texturerender;

/* JADX INFO: loaded from: classes40.dex */
public abstract class SharpenBaseWrapper {
    protected final String LOG_TAG;

    public int AdaptiveSharpenDirectDraw(int r100, int r101, int r102, float r103, float r104, float r105, boolean r106, float r107, float r108, int[] r110) {
        return -1;
    }

    public int AdaptiveSharpenDirectDraw(int r100, int r101, int r102, int[] r103) {
        return -1;
    }

    public int AdaptiveSharpenOesDirectDraw(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, float r107, float r108, float r110, boolean r111, float r112, float r113, int[] r114) {
        return -1;
    }

    public int AdaptiveSharpenOesDirectDraw(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, int[] r107) {
        return -1;
    }

    public int AdaptiveSharpenOesProcess(int r100, int r101, int r102, float[] r103, boolean r104, int r105, float r106, float r107, float r108, int r110) {
        return -1;
    }

    public int AdaptiveSharpenOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106) {
        return -1;
    }

    public int AdaptiveSharpenOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, float r107, float r108, float r110, boolean r111, float r112, float r113) {
        return -1;
    }

    public int AdaptiveSharpenProcess(int r100, int r101, int r102) {
        return -1;
    }

    public int AdaptiveSharpenProcess(int r100, int r101, int r102, float r103, float r104, float r105, boolean r106, float r107, float r108) {
        return -1;
    }

    public int AdaptiveSharpenProcess(int r100, int r101, int r102, boolean r103, int r104, float r105, float r106, float r107, int r108) {
        return -1;
    }

    public int GetAdaptiveSharpenOutput() {
        return -1;
    }

    public int InitAdaptiveSharpen(int r100, int r101, int r102, int r103, String r104, float r105, float r106, float r107, boolean r108, float r110, float r111) {
        return -1;
    }

    public boolean InitAdaptiveSharpen(boolean r100, int r101, int r102, int r103) {
        return false;
    }

    public boolean InitVideoOclSr(String r100, int r101, boolean r102, String r103, int r104, int r105, int r106, String r107, String r108) {
        return false;
    }

    public void ReleaseAdaptiveSharpen() {
    }

    public SharpenBaseWrapper() {
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
    }
}
