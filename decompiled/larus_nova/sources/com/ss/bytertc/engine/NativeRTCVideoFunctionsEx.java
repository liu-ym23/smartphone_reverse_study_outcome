package com.ss.bytertc.engine;

import android.content.Context;
import com.bytedance.realx.video.EglBase;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.handler.RTCVideoEventHandler;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class NativeRTCVideoFunctionsEx {
    public NativeRTCVideoFunctionsEx() {
    }

    public static native long nativeCreateRTCVideoEx(Context r100, String r101, RTCVideoEventHandler r102, String r103, EglBase.Context r104, String r105);

    public static native void nativeDestroyRTCVideoEx(long r100);

    public static native int nativePushExternalVideoFrame(long r100, int r101, VideoFrameData r102);

    public static native int nativeSetAudioContentType(long r100, int r101, boolean r102, boolean r103, boolean r104);

    public static native int nativeSetAudioEncodeConfig(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110);

    public static native int nativeSetAudioSourceVolume(long r100, int r101, int r102);

    public static native int nativeSetCaptureVolume(long r100, int r101);

    public static native int nativeSetLocalStreamPriority(long r100, int r101, int r102);

    public static native int nativeSetScreenCaptureVolume(long r100, int r101);

    public static native int nativeSetVideoCaptureConfig(long r100, int r101, InternalVideoCaptureConfig r102);

    public static native int nativeSetVideoEncoderConfig(long r100, int r101, List<InternalVideoEncoderConfig> r102);

    public static native int nativeSetVideoSource(long r100, int r101, int r102, int r103);

    public static native int nativeStartVideoCapture(long r100, int r101, String r102);

    public static native int nativeStopVideoCapture(long r100, int r101);
}
