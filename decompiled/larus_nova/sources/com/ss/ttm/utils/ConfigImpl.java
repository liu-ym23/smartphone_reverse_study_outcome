package com.ss.ttm.utils;

import com.ss.ttm.player.TTPlayer;

/* JADX INFO: loaded from: classes40.dex */
public class ConfigImpl extends ConfigAPI {
    private long mHandle;

    private static native long _nativeCopy(long r100);

    private static native long _nativeCreate(long r100);

    private static native int _nativeGetInt(long r100, int r101, int r102);

    private static native void _nativeRelease(long r100);

    private static native void _nativeSetInt(long r100, int r101, int r102);

    @Override // com.ss.ttm.utils.ConfigAPI
    public void release() {
        long r100 = this.mHandle;
        if (r100 == 0) goto L6;
        this.mHandle = 0;
        _nativeRelease(r100);
        return;
    }

    static {
        TTPlayer.getAppPath();
    }

    @Override // com.ss.ttm.utils.ConfigAPI
    public long nativeHandle() {
        return this.mHandle;
    }

    public ConfigImpl(long r100, int r101) {
        this.mHandle = 0;
        if (r101 != 0) goto L6;
        this.mHandle = _nativeCreate(r100);
        return;
    L6:
        if (r101 != 1) goto L10;
        this.mHandle = _nativeCopy(r100);
        return;
    }

    public static ConfigAPI create(long r100, int r101) {
        return new ConfigImpl(r100, r101);
    }

    @Override // com.ss.ttm.utils.ConfigAPI
    public int getIntValue(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return r101;
    L5:
        return _nativeGetInt(r102, r100, r101);
    }

    @Override // com.ss.ttm.utils.ConfigAPI
    public void setIntValue(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 == 0) goto L6;
        _nativeSetInt(r102, r100, r101);
        return;
    }
}
