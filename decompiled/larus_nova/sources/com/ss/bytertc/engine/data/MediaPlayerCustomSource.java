package com.ss.bytertc.engine.data;

import com.ss.bytertc.engine.IMediaPlayerCustomSourceProvider;

/* JADX INFO: loaded from: classes40.dex */
public class MediaPlayerCustomSource {
    public MediaPlayerCustomSourceMode mode;
    public IMediaPlayerCustomSourceProvider provider;
    public MediaPlayerCustomSourceStreamType type;

    public String toString() {
        return "MediaPlayerCustomSource{provider='" + this.provider + "', MediaPlayerCustomSourceMode='" + this.mode + "', MediaPlayerCustomSourceStreamType='" + this.type + "'}";
    }

    public MediaPlayerCustomSource() {
        this.provider = null;
        this.mode = MediaPlayerCustomSourceMode.PUSH;
        this.type = MediaPlayerCustomSourceStreamType.RAW;
    }

    public MediaPlayerCustomSource(IMediaPlayerCustomSourceProvider r100, MediaPlayerCustomSourceMode r101, MediaPlayerCustomSourceStreamType r102) {
        this.provider = null;
        this.mode = MediaPlayerCustomSourceMode.PUSH;
        MediaPlayerCustomSourceStreamType r103 = MediaPlayerCustomSourceStreamType.RAW;
        this.mode = r101;
        this.type = r102;
        this.provider = r100;
    }
}
