package com.ss.bytertc.engine.mediaio;

import com.ss.bytertc.engine.data.VideoCodecType;
import com.ss.bytertc.engine.data.VideoPictureType;
import com.ss.bytertc.engine.data.VideoRotation;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class RTCEncodedVideoFrame {
    public final ByteBuffer buffer;
    public int height;
    public ByteBuffer seiData;
    public long timestampDtsUs;
    public long timestampUs;
    public VideoCodecType videoCodecType;
    public VideoPictureType videoPictureType;
    public VideoRotation videoRotation;
    public int width;

    public RTCEncodedVideoFrame(ByteBuffer r100, long r101, long r102, int r103, int r104, VideoCodecType r105, VideoPictureType r106, VideoRotation r110) {
        this.buffer = r100;
        this.timestampUs = r101;
        this.timestampDtsUs = r102;
        this.width = r103;
        this.height = r104;
        this.videoCodecType = r105;
        this.videoPictureType = r106;
        this.videoRotation = r110;
    }
}
