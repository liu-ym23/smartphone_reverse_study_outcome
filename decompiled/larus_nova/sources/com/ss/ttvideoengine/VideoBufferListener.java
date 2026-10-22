package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public interface VideoBufferListener {
    public static final int BUFFERING_TYPE_DECODER = 1;
    public static final int BUFFERING_TYPE_NET = 0;

    void onBufferEnd(int r100);

    void onBufferStart(int r100);
}
