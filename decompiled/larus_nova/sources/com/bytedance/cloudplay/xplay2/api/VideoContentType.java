package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/VideoContentType;", "", "NORMAL_FRAME", "BLACK_FRAME", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum VideoContentType extends Enum<VideoContentType> {
    public static final VideoContentType BLACK_FRAME = null;
    public static final VideoContentType NORMAL_FRAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoContentType[] f202791a = null;

    public static VideoContentType valueOf(String r100) {
        return (VideoContentType) a.a(VideoContentType.class, r100);
    }

    public static VideoContentType[] values() {
        return (VideoContentType[]) f202791a.clone();
    }

    static {
        VideoContentType r100 = new VideoContentType("NORMAL_FRAME", 0);
        NORMAL_FRAME = r100;
        VideoContentType r101 = new VideoContentType("BLACK_FRAME", 1);
        BLACK_FRAME = r101;
        f202791a = new VideoContentType[]{r100, r101};
    }

    public VideoContentType(String r100, int r101) {
        super(r100, r101);
    }
}
