package com.bytedance.bmmt.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
class MediaCodecWrapperFactoryImpl implements MediaCodecWrapperFactory {

    public static class MediaCodecWrapperImpl implements MediaCodecWrapper {
        private final MediaCodec mediaCodec;

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public Surface createInputSurface() {
            return this.mediaCodec.createInputSurface();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void flush() {
            this.mediaCodec.flush();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaCodecInfo getCodecInfo() {
            return this.mediaCodec.getCodecInfo();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer[] getInputBuffers() {
            return this.mediaCodec.getInputBuffers();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer[] getOutputBuffers() {
            return this.mediaCodec.getOutputBuffers();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaFormat getOutputFormat() {
            return this.mediaCodec.getOutputFormat();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public List<String> getSupportedVendorParameters() {
            if (Build.VERSION.SDK_INT >= 31) goto L5;
            return null;
        L5:
            return this.mediaCodec.getSupportedVendorParameters();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void release() {
            this.mediaCodec.release();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void start() {
            this.mediaCodec.start();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void stop() {
            this.mediaCodec.stop();
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaCodec getRealCodec() {
            return this.mediaCodec;
        }

        public MediaCodecWrapperImpl(MediaCodec r100) {
            this.mediaCodec = r100;
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public int dequeueInputBuffer(long r100) {
            return this.mediaCodec.dequeueInputBuffer(r100);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer getInputBuffer(int r100) {
            return this.mediaCodec.getInputBuffer(r100);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public ByteBuffer getOutputBuffer(int r100) {
            return this.mediaCodec.getOutputBuffer(r100);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public MediaFormat getOutputFormat(int r100) {
            return this.mediaCodec.getOutputFormat(r100);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void setOutputSurface(Surface r100) {
            if (Build.VERSION.SDK_INT < 23) goto L6;
            this.mediaCodec.setOutputSurface(r100);
            return;
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void setParameters(Bundle r100) {
            this.mediaCodec.setParameters(r100);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public int dequeueOutputBuffer(MediaCodec.BufferInfo r100, long r101) {
            return this.mediaCodec.dequeueOutputBuffer(r100, r101);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void releaseOutputBuffer(int r100, long r101) {
            this.mediaCodec.releaseOutputBuffer(r100, r101);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void setCallback(MediaCodec.Callback r100, Handler r101) {
            if (Build.VERSION.SDK_INT < 23) goto L8;
            if (r101 != null) goto L7;
            this.mediaCodec.setCallback(r100);
            return;
        L7:
            this.mediaCodec.setCallback(r100, r101);
            return;
        L8:
            this.mediaCodec.setCallback(r100);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void releaseOutputBuffer(int r100, boolean r101) {
            this.mediaCodec.releaseOutputBuffer(r100, r101);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void configure(MediaFormat r100, Surface r101, MediaCrypto r102, int r103) {
            this.mediaCodec.configure(r100, r101, r102, r103);
        }

        @Override // com.bytedance.bmmt.video.MediaCodecWrapper
        public void queueInputBuffer(int r100, int r101, int r110, long r111, int r112) {
            this.mediaCodec.queueInputBuffer(r100, r101, r110, r111, r112);
        }
    }

    public MediaCodecWrapperFactoryImpl() {
    }

    @Override // com.bytedance.bmmt.video.MediaCodecWrapperFactory
    public MediaCodecWrapper createByCodecName(String r100) throws IOException {
        return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(r100));
    }
}
