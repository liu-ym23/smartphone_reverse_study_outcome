package com.bytedance.live.livelink.kmp.api.core.mixer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/FrameType;", "", "DEFAULT_OCCUPY", "METADATA", "SEI", "METADATA_SEI", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FrameType extends Enum<FrameType> {
    public static final FrameType DEFAULT_OCCUPY = null;
    public static final FrameType METADATA = null;
    public static final FrameType METADATA_SEI = null;
    public static final FrameType SEI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FrameType[] f255233a = null;

    static {
        FrameType r100 = new FrameType("DEFAULT_OCCUPY", 0);
        DEFAULT_OCCUPY = r100;
        FrameType r101 = new FrameType("METADATA", 1);
        METADATA = r101;
        FrameType r102 = new FrameType("SEI", 2);
        SEI = r102;
        FrameType r103 = new FrameType("METADATA_SEI", 3);
        METADATA_SEI = r103;
        f255233a = new FrameType[]{r100, r101, r102, r103};
    }

    public static FrameType valueOf(String r100) {
        return (FrameType) a.a(FrameType.class, r100);
    }

    public static FrameType[] values() {
        return (FrameType[]) f255233a.clone();
    }

    public FrameType(String r100, int r101) {
        super(r100, r101);
    }
}
