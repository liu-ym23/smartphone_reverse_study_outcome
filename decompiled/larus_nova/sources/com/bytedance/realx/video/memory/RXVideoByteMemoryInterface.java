package com.bytedance.realx.video.memory;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public interface RXVideoByteMemoryInterface extends RXVideoMemoryInterface {
    int getNumberOfPlanes();

    ByteBuffer getPlaneData(int r100);

    int getPlaneLineSize(int r100);
}
