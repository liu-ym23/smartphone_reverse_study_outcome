package com.ss.texturerender;

import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public abstract class VideoOCLSRBaseWrapper {
    protected final String LOG_TAG;

    public int GetVideoOclSrOutput() {
        return -1;
    }

    public boolean InitVideoAsyncOclSr(String r100, int r101, boolean r102, boolean r103, int r104, int r105, String r106, int r107, int r108, int r110, String r111, String r112, Bundle r113) {
        return false;
    }

    public boolean InitVideoOclSr(String r100, int r101, boolean r102, int r103, int r104) {
        return false;
    }

    public boolean InitVideoOclSr(String r100, int r101, boolean r102, String r103, int r104, int r105, int r106, String r107, String r108) {
        return false;
    }

    public boolean InitVideoOclSr(String r100, int r101, boolean r102, boolean r103, int r104, int r105, String r106, int r107, int r108, int r110, String r111, String r112, Bundle r113) {
        return false;
    }

    public void ReleaseVideoOclSr() {
    }

    public int VideoOclSrDirectDraw(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, long r108, int r110, Bundle r111, int[] r112) {
        return -1;
    }

    public int VideoOclSrOesDirectDraw(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, int r107, int r110, int r111, int r112, int r113, long r114, int r115, Bundle r116, int[] r117) {
        return -1;
    }

    public int VideoOclSrOesProcess(int r100, int r101, int r102, float[] r103, boolean r104, int r105, int r106, int r107, int r108, int r110, long r111, int r112, int r113, Bundle r114) {
        return -1;
    }

    public int VideoOclSrOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, int r107, int r110, int r111, int r112, int r113, long r114, int r115, Bundle r116) {
        return -1;
    }

    public int VideoOclSrOesProcess(int r100, int r101, int r102, float[] r103, float[] r104, float[] r105, boolean r106, Bundle r107) {
        return -1;
    }

    public int VideoOclSrProcess(int r100, int r101, int r102, boolean r103) {
        return -1;
    }

    public int VideoOclSrProcess(int r100, int r101, int r102, boolean r103, int r104, int r105, int r106, int r107, int r108, long r110, int r111, int r112, Bundle r113) {
        return -1;
    }

    public boolean glSrInit(String r100, int r101, boolean r102, int r103, int r104) {
        return false;
    }

    public int videoOclSrProcess(int r100, int r101, int r102, boolean r103, int r104) {
        return -1;
    }

    public VideoOCLSRBaseWrapper() {
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
    }
}
