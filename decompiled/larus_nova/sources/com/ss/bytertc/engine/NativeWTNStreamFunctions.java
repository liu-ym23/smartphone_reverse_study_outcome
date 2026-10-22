package com.ss.bytertc.engine;

import android.view.View;
import com.ss.bytertc.engine.handler.NativeWTNStreamEventHandler;
import com.ss.bytertc.engine.video.IVideoSink;

/* JADX INFO: loaded from: classes40.dex */
public class NativeWTNStreamFunctions {
    public NativeWTNStreamFunctions() {
    }

    public static native void nativeDestroy(long r100);

    public static native void nativeEnableWTNRemoteAudioFrameCallback(long r100, boolean r101);

    public static native int nativeRegisterWTNAudioFrameObserver(long r100, IWTNAudioFrameObserver r101);

    public static native int nativeSetWTNRemoteAudioPlaybackVolume(long r100, String r101, int r102);

    public static native int nativeSetWTNRemoteVideoCanvas(long r100, String r101, View r102, int r103, int r104, int r105);

    public static native int nativeSetWTNRemoteVideoSink(long r100, String r101, IVideoSink r102, int r103, int r104, int r105, int r106);

    public static native int nativeSetWTNStreamEventHandler(long r100, NativeWTNStreamEventHandler r101);

    public static native int nativeSubscribeWTNAudioStream(long r100, String r101, boolean r102);

    public static native int nativeSubscribeWTNVideoStream(long r100, String r101, boolean r102);
}
