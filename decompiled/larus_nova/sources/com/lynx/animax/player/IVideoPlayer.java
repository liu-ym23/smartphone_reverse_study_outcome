package com.lynx.animax.player;

/* JADX INFO: loaded from: classes32.dex */
public interface IVideoPlayer {
    void attachAsset(VideoAsset r100);

    void destroy();

    float[] getTransformMatrix();

    void setSurface(int r100);

    boolean updateSurface(int r100);
}
