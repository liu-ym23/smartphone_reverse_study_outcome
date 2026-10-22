package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/service/audio/VideoEncoderCodecType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "H264", "H265", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoEncoderCodecType extends Enum<VideoEncoderCodecType> {
    public static final VideoEncoderCodecType H264 = null;
    public static final VideoEncoderCodecType H265 = null;
    public static final VideoEncoderCodecType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoEncoderCodecType[] f350676a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350677b = null;

    public static EnumEntries<VideoEncoderCodecType> getEntries() {
        return f350677b;
    }

    static {
        VideoEncoderCodecType r100 = new VideoEncoderCodecType("UNKNOWN", 0);
        UNKNOWN = r100;
        VideoEncoderCodecType r101 = new VideoEncoderCodecType("H264", 1);
        H264 = r101;
        VideoEncoderCodecType r102 = new VideoEncoderCodecType("H265", 2);
        H265 = r102;
        VideoEncoderCodecType[] r103 = {r100, r101, r102};
        f350676a = r103;
        f350677b = EnumEntriesKt.enumEntries(r103);
    }

    public static VideoEncoderCodecType[] values() {
        return (VideoEncoderCodecType[]) f350676a.clone();
    }

    public static VideoEncoderCodecType valueOf(String r100) {
        return (VideoEncoderCodecType) r27.a.a(VideoEncoderCodecType.class, r100);
    }

    public VideoEncoderCodecType(String r100, int r101) {
        super(r100, r101);
    }
}
