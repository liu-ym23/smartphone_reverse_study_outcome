package com.ss.bytertc.engine;

import com.ss.bytertc.ktv.IKTVManagerEventHandler;

/* JADX INFO: loaded from: classes40.dex */
public class NativeKTVManagerFunctions {
    public NativeKTVManagerFunctions() {
    }

    public static native void nativeCancelDownload(long r100, int r101);

    public static native void nativeClearCache(long r100);

    public static native int nativeDownloadLyric(long r100, String r101, int r102);

    public static native int nativeDownloadMidi(long r100, String r101);

    public static native int nativeDownloadMusic(long r100, String r101);

    public static native void nativeGetHotMusic(long r100, String[] r101, int r102);

    public static native long nativeGetKTVPlayer(long r100);

    public static native void nativeGetMusicDetail(long r100, String r101);

    public static native void nativeGetMusicList(long r100, int r101, int r102, int r103);

    public static native void nativeReleaseKTVManagerEventHandler(long r100);

    public static native void nativeSearchMusic(long r100, String r101, int r102, int r103, int r104);

    public static native long nativeSetKTVManagerEventHandler(long r100, IKTVManagerEventHandler r101);

    public static native void nativeSetMaxCacheSize(long r100, int r101);
}
