package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes40.dex */
public class NativeMaskInfo extends MaskInfo {
    public NativeMaskInfo() {
    }

    private static boolean isNativeMaskInfo(MaskInfo r100) {
        return r100 instanceof NativeMaskInfo;
    }

    @Override // com.ss.ttm.player.MaskInfo
    public void onMaskInfoCallback(int r100, int r101, String r102) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
