package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.MediaPlayerCustomSourceSeekWhence;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public interface IMediaPlayerCustomSourceProvider {
    int onReadData(ByteBuffer r100, int r101);

    long onSeek(long r100, MediaPlayerCustomSourceSeekWhence r101);
}
