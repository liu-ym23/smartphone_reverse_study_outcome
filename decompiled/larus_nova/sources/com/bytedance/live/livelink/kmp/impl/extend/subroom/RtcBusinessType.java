package com.bytedance.live.livelink.kmp.impl.extend.subroom;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/livelink/kmp/impl/extend/subroom/RtcBusinessType;", "", "UNKNOWN", "PK_CLOUD_GAME", "REAL_TIME_CHORUS", "GAME_BARRAGE_LINKER", "live-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RtcBusinessType extends Enum<RtcBusinessType> {
    public static final RtcBusinessType GAME_BARRAGE_LINKER = null;
    public static final RtcBusinessType PK_CLOUD_GAME = null;
    public static final RtcBusinessType REAL_TIME_CHORUS = null;
    public static final RtcBusinessType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RtcBusinessType[] f255611a = null;

    static {
        RtcBusinessType r100 = new RtcBusinessType("UNKNOWN", 0);
        UNKNOWN = r100;
        RtcBusinessType r101 = new RtcBusinessType("PK_CLOUD_GAME", 1);
        PK_CLOUD_GAME = r101;
        RtcBusinessType r102 = new RtcBusinessType("REAL_TIME_CHORUS", 2);
        REAL_TIME_CHORUS = r102;
        RtcBusinessType r103 = new RtcBusinessType("GAME_BARRAGE_LINKER", 3);
        GAME_BARRAGE_LINKER = r103;
        f255611a = new RtcBusinessType[]{r100, r101, r102, r103};
    }

    public static RtcBusinessType valueOf(String r100) {
        return (RtcBusinessType) a.a(RtcBusinessType.class, r100);
    }

    public static RtcBusinessType[] values() {
        return (RtcBusinessType[]) f255611a.clone();
    }

    public RtcBusinessType(String r100, int r101) {
        super(r100, r101);
    }
}
