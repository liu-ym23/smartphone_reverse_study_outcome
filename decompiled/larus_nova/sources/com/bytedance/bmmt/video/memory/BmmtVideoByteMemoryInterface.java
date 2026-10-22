package com.bytedance.bmmt.video.memory;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public interface BmmtVideoByteMemoryInterface extends BmmtVideoMemoryInterface {
    int getNumberOfPlanes();

    ByteBuffer getPlaneData(int r100);

    int getPlaneLineSize(int r100);
}
