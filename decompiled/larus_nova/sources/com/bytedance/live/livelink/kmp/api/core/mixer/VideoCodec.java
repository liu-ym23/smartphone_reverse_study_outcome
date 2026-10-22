package com.bytedance.live.livelink.kmp.api.core.mixer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/VideoCodec;", "", "H264", "BYTEVC1", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VideoCodec extends Enum<VideoCodec> {
    public static final VideoCodec BYTEVC1 = null;
    public static final VideoCodec H264 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoCodec[] f255255a = null;

    static {
        VideoCodec r100 = new VideoCodec("H264", 0);
        H264 = r100;
        VideoCodec r101 = new VideoCodec("BYTEVC1", 1);
        BYTEVC1 = r101;
        f255255a = new VideoCodec[]{r100, r101};
    }

    public static VideoCodec valueOf(String r100) {
        return (VideoCodec) a.a(VideoCodec.class, r100);
    }

    public static VideoCodec[] values() {
        return (VideoCodec[]) f255255a.clone();
    }

    public VideoCodec(String r100, int r101) {
        super(r100, r101);
    }
}
