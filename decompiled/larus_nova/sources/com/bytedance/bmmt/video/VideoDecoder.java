package com.bytedance.bmmt.video;

import android.view.Surface;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;

/* JADX INFO: loaded from: classes8.dex */
public interface VideoDecoder {

    /* JADX INFO: renamed from: com.bytedance.bmmt.video.VideoDecoder$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$createNativeVideoDecoder(VideoDecoder r100) {
            return 0;
        }
    }

    public interface Callback {
        void onDecodedFrame(BmmtVideoFrameInterface r100);

        void onMediaCodecStatus(VideoCodecStatus r100, String r101);
    }

    public static class DecodeInfo {
        public final boolean isMissingFrames;
        public final long renderTimeMs;

        public DecodeInfo(boolean r100, long r101) {
            this.isMissingFrames = r100;
            this.renderTimeMs = r101;
        }
    }

    public static class Settings {
        public final int adaptivePlaybackMaxHeight;
        public final int adaptivePlaybackMaxWidth;
        public final int directRenderMode;
        public final boolean enableAGFXSurfaceTextureHelper;
        public final boolean enableAdaptivePlayback;
        public final boolean enableAsyncMode;
        public final boolean enableBFrameDecode;
        public final boolean enableRecreateByResolution;
        public final boolean enableSmoothOutput;
        public final boolean enableSurfaceTextureReuse;
        public final boolean enableYUVOutput;
        public final int height;
        public final boolean latencyInsensitiveMode;
        public final int numberOfCores;
        public final boolean outputByDts;
        public final EglBase.Context sharedContext;
        public final int superResolutionHeight;
        public final int superResolutionMode;
        public final float superResolutionRatio;
        public final int superResolutionWidth;
        public final int texturePlayoutMode;
        public final int width;

        public Settings(int r100, int r101, int r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, boolean r113, EglBase.Context r114, boolean r115, int r116, int r117, int r118, float r119, int r210, int r211, boolean r212, int r213, int r214) {
            this.numberOfCores = r100;
            this.width = r101;
            this.height = r102;
            this.outputByDts = r103;
            this.enableSmoothOutput = r104;
            this.enableYUVOutput = r105;
            this.latencyInsensitiveMode = r106;
            this.enableSurfaceTextureReuse = r110;
            this.enableRecreateByResolution = r111;
            this.enableBFrameDecode = r112;
            this.sharedContext = r114;
            this.enableAGFXSurfaceTextureHelper = r113;
            this.enableAsyncMode = r115;
            this.directRenderMode = r116;
            this.texturePlayoutMode = r117;
            this.superResolutionMode = r118;
            this.superResolutionRatio = r119;
            this.superResolutionWidth = r210;
            this.superResolutionHeight = r211;
            this.enableAdaptivePlayback = r212;
            this.adaptivePlaybackMaxWidth = r213;
            this.adaptivePlaybackMaxHeight = r214;
        }
    }

    long createNativeVideoDecoder();

    VideoCodecStatus decode(EncodedImage r100);

    void disableExternalSurface();

    String getImplementationName();

    boolean getPrefersLateDecoding();

    VideoCodecStatus initDecode(Settings r100, Callback r101);

    void onFrame(BmmtVideoFrameInterface r100);

    VideoCodecStatus release();

    VideoCodecStatus setDeliverParams(boolean r100, int r101, float r102, float r103, int r104);

    void setExternalSurface(Surface r100);

    VideoCodecStatus setPrivateParam(String r100, String r101);

    VideoCodecStatus updateSettings(Settings r100);
}
