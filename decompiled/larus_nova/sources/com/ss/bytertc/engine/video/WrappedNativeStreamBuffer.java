package com.ss.bytertc.engine.video;

import com.bytedance.realx.base.JniCommon;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
class WrappedNativeStreamBuffer implements VideoStream.Buffer {
    private final ByteBuffer data;
    private final long nativeBuffer;
    private final int size;

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer
    public ByteBuffer getData() {
        return this.data.slice();
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        JniCommon.nativeReleaseRef(this.nativeBuffer);
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        JniCommon.nativeAddRef(this.nativeBuffer);
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer
    public int getDataSize() {
        return this.size;
    }

    public WrappedNativeStreamBuffer(int r100, ByteBuffer r101, long r102) {
        this.size = r100;
        this.data = r101;
        this.nativeBuffer = r102;
        retain();
    }
}
