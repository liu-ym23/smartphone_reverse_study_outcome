package com.bytedance.realx.video;

import android.view.Surface;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* JADX INFO: loaded from: classes21.dex */
public interface VideoDecoder {

    /* JADX INFO: renamed from: com.bytedance.realx.video.VideoDecoder$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$createNativeVideoDecoder(VideoDecoder r100) {
            return 0;
        }
    }

    public interface Callback {
        void onDecodedFrame(RXVideoFrameInterface r100);

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
        public final int directRenderMode;
        public final boolean enableAGFXSurfaceTextureHelper;
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
        public final int texturePlayoutMode;
        public final int width;

        public Settings(int r100, int r101, int r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, EglBase.Context r112, boolean r113, int r114, int r115) {
            this.numberOfCores = r100;
            this.width = r101;
            this.height = r102;
            this.outputByDts = r103;
            this.enableSmoothOutput = r104;
            this.enableYUVOutput = r105;
            this.latencyInsensitiveMode = r106;
            this.enableSurfaceTextureReuse = r107;
            this.enableRecreateByResolution = r108;
            this.enableBFrameDecode = r110;
            this.sharedContext = r112;
            this.enableAGFXSurfaceTextureHelper = r111;
            this.enableAsyncMode = r113;
            this.directRenderMode = r114;
            this.texturePlayoutMode = r115;
        }
    }

    long createNativeVideoDecoder();

    VideoCodecStatus decode(EncodedImage r100);

    void disableExternalSurface();

    String getImplementationName();

    boolean getPrefersLateDecoding();

    VideoCodecStatus initDecode(Settings r100, Callback r101);

    void onFrame(RXVideoFrameInterface r100);

    VideoCodecStatus release();

    VideoCodecStatus setDeliverParams(boolean r100, int r101, float r102, float r103, int r104);

    void setExternalSurface(Surface r100);

    VideoCodecStatus setPrivateParam(String r100, String r101);

    VideoCodecStatus updateSettings(Settings r100);
}
