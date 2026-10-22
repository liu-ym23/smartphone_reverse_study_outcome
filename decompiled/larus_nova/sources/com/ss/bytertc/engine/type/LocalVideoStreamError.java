package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalVideoStreamError extends Enum<LocalVideoStreamError> {
    private static final /* synthetic */ LocalVideoStreamError[] $VALUES = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_DISCONNECTED = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_NOT_FOUND = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_FAILURE = null;
    public static final LocalVideoStreamError LOCAL_VIDEO_STREAM_ERROR_OK = null;
    private int value;

    static {
        LocalVideoStreamError r100 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_OK", 0, 0);
        LOCAL_VIDEO_STREAM_ERROR_OK = r100;
        LocalVideoStreamError r101 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_FAILURE", 1, 1);
        LOCAL_VIDEO_STREAM_ERROR_FAILURE = r101;
        LocalVideoStreamError r102 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION", 2, 2);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_NO_PERMISSION = r102;
        LocalVideoStreamError r103 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY", 3, 3);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_BUSY = r103;
        LocalVideoStreamError r104 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_NOT_FOUND", 4, 4);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_NOT_FOUND = r104;
        LocalVideoStreamError r105 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE", 5, 5);
        LOCAL_VIDEO_STREAM_ERROR_CAPTURE_FAILURE = r105;
        LocalVideoStreamError r110 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE", 6, 6);
        LOCAL_VIDEO_STREAM_ERROR_ENCODE_FAILURE = r110;
        LocalVideoStreamError r111 = new LocalVideoStreamError("LOCAL_VIDEO_STREAM_ERROR_DEVICE_DISCONNECTED", 7, 7);
        LOCAL_VIDEO_STREAM_ERROR_DEVICE_DISCONNECTED = r111;
        $VALUES = new LocalVideoStreamError[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static LocalVideoStreamError[] values() {
        return (LocalVideoStreamError[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static LocalVideoStreamError fromId(int r100) {
        LocalVideoStreamError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        LocalVideoStreamError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static LocalVideoStreamError valueOf(String r100) {
        return (LocalVideoStreamError) a.a(LocalVideoStreamError.class, r100);
    }

    private LocalVideoStreamError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
