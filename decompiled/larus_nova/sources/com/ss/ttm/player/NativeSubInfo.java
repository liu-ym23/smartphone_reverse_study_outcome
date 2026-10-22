package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes40.dex */
public class NativeSubInfo extends SubInfo {
    public NativeSubInfo() {
    }

    private static boolean isNativeSubInfo(SubInfo r100) {
        return r100 instanceof NativeSubInfo;
    }

    @Override // com.ss.ttm.player.SubInfo
    public void onSubLoadFinished(int r100) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    public void onSubInfoCallback2(int r100, String r101) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    public void onSubLoadFinished2(int r100, String r101) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    public void onSubSwitchCompleted(int r100, int r101) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    public void onSubInfoCallback(int r100, int r101, String r102) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
