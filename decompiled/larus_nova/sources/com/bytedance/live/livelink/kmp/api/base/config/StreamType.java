package com.bytedance.live.livelink.kmp.api.base.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/config/StreamType;", "", "AUDIO", "VIDEO", "AUDIO_VIDEO", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum StreamType extends Enum<StreamType> {
    public static final StreamType AUDIO = null;
    public static final StreamType AUDIO_VIDEO = null;
    public static final StreamType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StreamType[] f255218a = null;

    static {
        StreamType r100 = new StreamType("AUDIO", 0);
        AUDIO = r100;
        StreamType r101 = new StreamType("VIDEO", 1);
        VIDEO = r101;
        StreamType r102 = new StreamType("AUDIO_VIDEO", 2);
        AUDIO_VIDEO = r102;
        f255218a = new StreamType[]{r100, r101, r102};
    }

    public static StreamType valueOf(String r100) {
        return (StreamType) a.a(StreamType.class, r100);
    }

    public static StreamType[] values() {
        return (StreamType[]) f255218a.clone();
    }

    public StreamType(String r100, int r101) {
        super(r100, r101);
    }
}
