package com.larus.bmhome.music.save_video;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes26.dex */
public interface b {
    void a(ByteBuffer r100, MediaCodec.BufferInfo r101);

    void b(ByteBuffer r100, MediaCodec.BufferInfo r101);

    void c(MediaFormat r100, MediaExtractor r101);

    long d();

    boolean isStarted();

    void release();
}
