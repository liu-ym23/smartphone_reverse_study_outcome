package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes40.dex */
public class NativeABRStrategy extends ABRStrategy {
    public NativeABRStrategy(long r100) {
        setWeakNativeObj(r100);
    }

    public static boolean isNativeABRStrategy(ABRStrategy r100) {
        return r100 instanceof NativeABRStrategy;
    }

    @Override // com.ss.ttm.player.ABRStrategy
    public int probeBitrate(int r100) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.ABRStrategy
    public String probeBitrate(String r100) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
