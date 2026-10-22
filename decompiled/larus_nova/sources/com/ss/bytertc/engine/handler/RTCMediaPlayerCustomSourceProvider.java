package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IMediaPlayerCustomSourceProvider;
import com.ss.bytertc.engine.data.MediaPlayerCustomSourceSeekWhence;
import com.ss.bytertc.engine.data.ReturnStatus;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class RTCMediaPlayerCustomSourceProvider {
    private IMediaPlayerCustomSourceProvider mCustomSourceProvider;

    public RTCMediaPlayerCustomSourceProvider() {
    }

    public void setCustomSourceProvider(IMediaPlayerCustomSourceProvider r100) {
        this.mCustomSourceProvider = r100;
    }

    public int onReadData(ByteBuffer r100, int r101) {
        IMediaPlayerCustomSourceProvider r102 = this.mCustomSourceProvider;
        if (r102 == null) goto L7;
        return r102.onReadData(r100, r101);
    L7:
        return ReturnStatus.RETURN_STATUS_WRONG_STATE.value();
    }

    public long onSeek(long r100, int r101) {
        IMediaPlayerCustomSourceProvider r102 = this.mCustomSourceProvider;
        if (r102 == null) goto L7;
        return r102.onSeek(r100, MediaPlayerCustomSourceSeekWhence.fromId(r101));
    L7:
        return ReturnStatus.RETURN_STATUS_WRONG_STATE.value();
    }
}
