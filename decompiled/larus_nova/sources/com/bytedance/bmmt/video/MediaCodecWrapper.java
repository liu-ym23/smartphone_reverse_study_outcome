package com.bytedance.bmmt.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
interface MediaCodecWrapper {
    void configure(MediaFormat r100, Surface r101, MediaCrypto r102, int r103);

    Surface createInputSurface();

    int dequeueInputBuffer(long r100);

    int dequeueOutputBuffer(MediaCodec.BufferInfo r100, long r101);

    void flush();

    MediaCodecInfo getCodecInfo();

    ByteBuffer getInputBuffer(int r100);

    ByteBuffer[] getInputBuffers();

    ByteBuffer getOutputBuffer(int r100);

    ByteBuffer[] getOutputBuffers();

    MediaFormat getOutputFormat();

    MediaFormat getOutputFormat(int r100);

    MediaCodec getRealCodec();

    List<String> getSupportedVendorParameters();

    void queueInputBuffer(int r100, int r101, int r102, long r103, int r104);

    void release();

    void releaseOutputBuffer(int r100, long r101);

    void releaseOutputBuffer(int r100, boolean r101);

    void setCallback(MediaCodec.Callback r100, Handler r101);

    void setOutputSurface(Surface r100);

    void setParameters(Bundle r100);

    void start();

    void stop();
}
