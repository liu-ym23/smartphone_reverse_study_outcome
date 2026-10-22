package com.bytedance.realx.video.memory;

import com.bytedance.realx.base.RefCounted;
import com.bytedance.realx.video.RXColorSpace;
import com.bytedance.realx.video.RXVideoRotation;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public interface RXVideoFrameInterface extends RefCounted {
    RXVideoMemoryInterface getAndRetainVideoFrameMemory();

    RXColorSpace getColorSpace();

    int getHeight();

    long getNativeHandle();

    int getRotatedHeight();

    int getRotatedWidth();

    RXVideoRotation getRotation();

    ByteBuffer getSupplementData();

    long getTimestampNs();

    long getTimestampUs();

    int getWidth();

    @Override // com.bytedance.realx.base.RefCounted
    void release();

    @Override // com.bytedance.realx.base.RefCounted
    void retain();

    void setRotation(RXVideoRotation r100);

    void setTimestampNs(long r100);

    void setTimestampUs(long r100);

    RXVideoFrameInterface toI420();
}
