package com.ss.android.vesdk.audio;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioSample {
    private int byteSize;
    private c sampleBuffer;
    private long timeStamp;

    public static class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f455732a;

        public a(byte[] r100) {
            this.f455732a = r100;
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f455733a;

        public b(ByteBuffer r100) {
            this.f455733a = r100;
        }
    }

    public static class c {
        public c() {
        }
    }

    public int getByteSize() {
        return this.byteSize;
    }

    public c getSampleBuffer() {
        return this.sampleBuffer;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }

    public VEAudioSample(c r100, int r101) {
        this.sampleBuffer = r100;
        this.byteSize = r101;
    }

    public static VEAudioSample createByteArrayAudioSample(byte[] r100, int r101) {
        return new VEAudioSample(new a(r100), r101);
    }

    public static VEAudioSample createByteBufferAudioSample(ByteBuffer r100, int r101) {
        return new VEAudioSample(new b(r100), r101);
    }
}
