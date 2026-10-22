package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes40.dex */
public class NativeLoadControl extends LoadControl {
    public NativeLoadControl() {
    }

    private static boolean isNativeLoadControl(LoadControl r100) {
        return r100 instanceof NativeLoadControl;
    }

    @Override // com.ss.ttm.player.LoadControl
    public int onCodecStackSelected(int r100) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.LoadControl
    public int onFilterStackSelected(int r100) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.LoadControl
    public int onTrackSelected(int r100) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.LoadControl
    public boolean shouldStartPlayback(long r100, float r101, boolean r102) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
