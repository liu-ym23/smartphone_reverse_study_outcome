package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamVideoConfig {
    public int bitrate;
    public boolean enableBframe;
    public int fps;
    public int gop;
    public int height;
    public MixedStreamVideoCodecType videoCodec;
    public int width;

    public String toString() {
        return "MixedStreamVideoConfig{videoCodec='" + this.videoCodec + "', fps=" + this.fps + ", gop=" + this.gop + ", bitrate=" + this.bitrate + ", width=" + this.width + ", height=" + this.height + ", enableBframe=" + this.enableBframe + '}';
    }

    public MixedStreamVideoConfig() {
        this.videoCodec = MixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
        this.fps = 15;
        this.gop = 2;
        this.bitrate = 500;
        this.width = 360;
        this.height = 640;
        this.enableBframe = false;
    }
}
