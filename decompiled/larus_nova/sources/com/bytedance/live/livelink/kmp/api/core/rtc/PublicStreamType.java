package com.bytedance.live.livelink.kmp.api.core.rtc;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/rtc/PublicStreamType;", "", "VIDEO", "AUDIO", "VIDEO_AUDIO", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PublicStreamType extends Enum<PublicStreamType> {
    public static final PublicStreamType AUDIO = null;
    public static final PublicStreamType VIDEO = null;
    public static final PublicStreamType VIDEO_AUDIO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicStreamType[] f255257a = null;

    static {
        PublicStreamType r100 = new PublicStreamType("VIDEO", 0);
        VIDEO = r100;
        PublicStreamType r101 = new PublicStreamType("AUDIO", 1);
        AUDIO = r101;
        PublicStreamType r102 = new PublicStreamType("VIDEO_AUDIO", 2);
        VIDEO_AUDIO = r102;
        f255257a = new PublicStreamType[]{r100, r101, r102};
    }

    public static PublicStreamType valueOf(String r100) {
        return (PublicStreamType) a.a(PublicStreamType.class, r100);
    }

    public static PublicStreamType[] values() {
        return (PublicStreamType[]) f255257a.clone();
    }

    public PublicStreamType(String r100, int r101) {
        super(r100, r101);
    }
}
