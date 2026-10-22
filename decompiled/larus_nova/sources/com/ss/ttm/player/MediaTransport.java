package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public abstract class MediaTransport extends NativeObject {
    public static final int FILTER_AUDIO = 2;
    public static final int FILTER_VIDEO = 1;

    public static class MediaPacket {
        public static final int CODEC_ID_AAC = 2;
        public static final int CODEC_ID_BYTE_VC1 = 1;
        public static final int CODEC_ID_H264 = 0;
        public static final int FLAG_CONFIG_FRAME = 1;
        public static final int FLAG_IS_DECODED_ONLY = 3;
        public static final int FLAG_KEY_FRAME = 2;
        public ByteBuffer mBuffer;
        public int mCodecId;
        public int mFlags;
        public boolean mIsAccessUnit;
        public boolean mIsVideo;
        public int mOffset;
        public long mPresentationTimeMs;
        public int mSize;

        public MediaPacket() {
        }

        public void set(ByteBuffer r100, boolean r101, boolean r102, int r103, int r104, long r105, int r106, int r107) {
            this.mBuffer = r100;
            this.mOffset = r103;
            this.mSize = r104;
            this.mPresentationTimeMs = r105;
            this.mFlags = r106;
            this.mIsVideo = r101;
            this.mCodecId = r107;
            this.mIsAccessUnit = r102;
        }
    }

    private native void nativeSetFilterType(int r100);

    public abstract void sendPacket(MediaPacket r100);

    public MediaTransport() {
    }

    public void setFilterType(int r100) {
        nativeSetFilterType(r100);
    }
}
