package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MediaStreamType extends Enum<MediaStreamType> {
    private static final /* synthetic */ MediaStreamType[] $VALUES = null;
    public static final MediaStreamType RTC_MEDIA_STREAM_TYPE_AUDIO = null;
    public static final MediaStreamType RTC_MEDIA_STREAM_TYPE_BOTH = null;
    public static final MediaStreamType RTC_MEDIA_STREAM_TYPE_VIDEO = null;
    public final int value;

    static {
        MediaStreamType r100 = new MediaStreamType("RTC_MEDIA_STREAM_TYPE_AUDIO", 0, 1);
        RTC_MEDIA_STREAM_TYPE_AUDIO = r100;
        MediaStreamType r101 = new MediaStreamType("RTC_MEDIA_STREAM_TYPE_VIDEO", 1, 2);
        RTC_MEDIA_STREAM_TYPE_VIDEO = r101;
        MediaStreamType r102 = new MediaStreamType("RTC_MEDIA_STREAM_TYPE_BOTH", 2, 3);
        RTC_MEDIA_STREAM_TYPE_BOTH = r102;
        $VALUES = new MediaStreamType[]{r100, r101, r102};
    }

    public static MediaStreamType[] values() {
        return (MediaStreamType[]) $VALUES.clone();
    }

    public static MediaStreamType valueOf(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return RTC_MEDIA_STREAM_TYPE_BOTH;
    L13:
        return RTC_MEDIA_STREAM_TYPE_VIDEO;
    L15:
        return RTC_MEDIA_STREAM_TYPE_AUDIO;
    }

    public static MediaStreamType valueOf(String r100) {
        return (MediaStreamType) a.a(MediaStreamType.class, r100);
    }

    private MediaStreamType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
