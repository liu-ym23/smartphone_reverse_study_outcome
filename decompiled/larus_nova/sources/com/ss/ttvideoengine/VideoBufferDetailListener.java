package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public interface VideoBufferDetailListener {
    public static final int AFTER_FIRST_FRAME = 1;
    public static final int BEFORE_FIRST_FRAME = 0;
    public static final int BUFFERING_TYPE_DECODER = 1;
    public static final int BUFFERING_TYPE_NET = 0;
    public static final int BUFFER_START_ACTION_CHANG_RESOLUTION = 2;
    public static final int BUFFER_START_ACTION_NONE = 0;
    public static final int BUFFER_START_ACTION_SEEK = 1;

    void onBufferEnd(int r100);

    void onBufferStart(int r100, int r101, int r102);
}
