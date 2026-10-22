package com.bytedance.bmmt.video.memory;

import com.bytedance.bmmt.base.RefCounted;
import com.bytedance.bmmt.video.ColorSpace;
import com.bytedance.bmmt.video.VideoRotation;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public interface BmmtVideoFrameInterface extends RefCounted {
    BmmtVideoMemoryInterface getAndRetainVideoFrameMemory();

    ColorSpace getColorSpace();

    int getHeight();

    long getNativeHandle();

    int getRotatedHeight();

    int getRotatedWidth();

    VideoRotation getRotation();

    ByteBuffer getSupplementData();

    long getTimestampNs();

    long getTimestampUs();

    int getWidth();

    @Override // com.bytedance.bmmt.base.RefCounted
    void release();

    @Override // com.bytedance.bmmt.base.RefCounted
    void retain();

    void setRotation(VideoRotation r100);

    void setTimestampNs(long r100);

    void setTimestampUs(long r100);

    BmmtVideoFrameInterface toI420();
}
