package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/service/audio/VideoSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL", "EXTERNAL_ORIGINAL", "EXTERNAL_ENCODED", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VideoSourceType extends Enum<VideoSourceType> {
    public static final VideoSourceType EXTERNAL_ENCODED = null;
    public static final VideoSourceType EXTERNAL_ORIGINAL = null;
    public static final VideoSourceType INTERNAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoSourceType[] f350678a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350679b = null;

    public static EnumEntries<VideoSourceType> getEntries() {
        return f350679b;
    }

    static {
        VideoSourceType r100 = new VideoSourceType("INTERNAL", 0);
        INTERNAL = r100;
        VideoSourceType r101 = new VideoSourceType("EXTERNAL_ORIGINAL", 1);
        EXTERNAL_ORIGINAL = r101;
        VideoSourceType r102 = new VideoSourceType("EXTERNAL_ENCODED", 2);
        EXTERNAL_ENCODED = r102;
        VideoSourceType[] r103 = {r100, r101, r102};
        f350678a = r103;
        f350679b = EnumEntriesKt.enumEntries(r103);
    }

    public static VideoSourceType[] values() {
        return (VideoSourceType[]) f350678a.clone();
    }

    public static VideoSourceType valueOf(String r100) {
        return (VideoSourceType) r27.a.a(VideoSourceType.class, r100);
    }

    public VideoSourceType(String r100, int r101) {
        super(r100, r101);
    }
}
