package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public abstract class LoadControl extends NativeObject {
    public abstract int onCodecStackSelected(int r100);

    public abstract int onFilterStackSelected(int r100);

    public abstract int onTrackSelected(int r100);

    public abstract boolean shouldStartPlayback(long r100, float r101, boolean r102);

    public LoadControl() {
    }
}
