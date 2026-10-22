package com.larus.im.service.audio.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/im/service/audio/vlm/EncodedVideoCodecType;", "", "<init>", "(Ljava/lang/String;I)V", "H264", "H265", "UNKNOWN", "MJPEG", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EncodedVideoCodecType extends Enum<EncodedVideoCodecType> {
    public static final EncodedVideoCodecType H264 = null;
    public static final EncodedVideoCodecType H265 = null;
    public static final EncodedVideoCodecType MJPEG = null;
    public static final EncodedVideoCodecType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncodedVideoCodecType[] f350799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350800b = null;

    public static EnumEntries<EncodedVideoCodecType> getEntries() {
        return f350800b;
    }

    static {
        EncodedVideoCodecType r100 = new EncodedVideoCodecType("H264", 0);
        H264 = r100;
        EncodedVideoCodecType r101 = new EncodedVideoCodecType("H265", 1);
        H265 = r101;
        EncodedVideoCodecType r102 = new EncodedVideoCodecType("UNKNOWN", 2);
        UNKNOWN = r102;
        EncodedVideoCodecType r103 = new EncodedVideoCodecType("MJPEG", 3);
        MJPEG = r103;
        EncodedVideoCodecType[] r104 = {r100, r101, r102, r103};
        f350799a = r104;
        f350800b = EnumEntriesKt.enumEntries(r104);
    }

    public static EncodedVideoCodecType[] values() {
        return (EncodedVideoCodecType[]) f350799a.clone();
    }

    public static EncodedVideoCodecType valueOf(String r100) {
        return (EncodedVideoCodecType) a.a(EncodedVideoCodecType.class, r100);
    }

    public EncodedVideoCodecType(String r100, int r101) {
        super(r100, r101);
    }
}
